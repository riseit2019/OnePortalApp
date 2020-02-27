import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IMdmEmployeeMaster, MdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';
import { MdmEmployeeMasterService } from './mdm-employee-master.service';
import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { MdmOrganizationMasterService } from 'app/entities/mdm-organization-master/mdm-organization-master.service';
import { IMdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';
import { MdmCitizenDataService } from 'app/entities/mdm-citizen-data/mdm-citizen-data.service';

type SelectableEntity = IMdmOrganizationMaster | IMdmCitizenData;

@Component({
  selector: 'jhi-mdm-employee-master-update',
  templateUrl: './mdm-employee-master-update.component.html'
})
export class MdmEmployeeMasterUpdateComponent implements OnInit {
  isSaving = false;
  organizationcodes: IMdmOrganizationMaster[] = [];
  personids: IMdmCitizenData[] = [];

  editForm = this.fb.group({
    id: [],
    employeeCode: [null, [Validators.required]],
    tempRefId: [],
    employeeId: [],
    employeeName: [],
    entityName: [],
    organizationName: [],
    designationId: [],
    designationName: [],
    postName: [],
    organizationUnitName: [],
    parentOrganizationUnit: [],
    mobileNumber: [],
    emailId: [],
    addressType: [],
    address1: [],
    address2: [],
    cityName: [],
    postOffice: [],
    isPrimary: [],
    isOuHead: [],
    districtCode: [],
    districtName: [],
    mandalCode: [],
    mandalName: [],
    villageCode: [],
    villageName: [],
    panchayatCode: [],
    panchayatName: [],
    constituencyCode: [],
    constituencyName: [],
    createdBy: [],
    updatedBy: [],
    recordInsertTime: [],
    createTime: [],
    updateTime: [],
    employeeType: [],
    managerEmployeeCode: [],
    employeeActiveStatus: [],
    personId1: [],
    aadhaarRefId: [],
    volunteerSecretariatId: [],
    volunteerSecretariatFlag: [],
    aadhaarNumber: [],
    organizationCode: [],
    personId: []
  });

  constructor(
    protected mdmEmployeeMasterService: MdmEmployeeMasterService,
    protected mdmOrganizationMasterService: MdmOrganizationMasterService,
    protected mdmCitizenDataService: MdmCitizenDataService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmEmployeeMaster }) => {
      if (!mdmEmployeeMaster.id) {
        const today = moment().startOf('day');
        mdmEmployeeMaster.recordInsertTime = today;
        mdmEmployeeMaster.createTime = today;
        mdmEmployeeMaster.updateTime = today;
      }

      this.updateForm(mdmEmployeeMaster);

      this.mdmOrganizationMasterService
        .query({ filter: 'mdmemployeemaster-is-null' })
        .pipe(
          map((res: HttpResponse<IMdmOrganizationMaster[]>) => {
            return res.body || [];
          })
        )
        .subscribe((resBody: IMdmOrganizationMaster[]) => {
          if (!mdmEmployeeMaster.organizationCode || !mdmEmployeeMaster.organizationCode.id) {
            this.organizationcodes = resBody;
          } else {
            this.mdmOrganizationMasterService
              .find(mdmEmployeeMaster.organizationCode.id)
              .pipe(
                map((subRes: HttpResponse<IMdmOrganizationMaster>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: IMdmOrganizationMaster[]) => (this.organizationcodes = concatRes));
          }
        });

      this.mdmCitizenDataService
        .query({ filter: 'mdmemployeemaster-is-null' })
        .pipe(
          map((res: HttpResponse<IMdmCitizenData[]>) => {
            return res.body || [];
          })
        )
        .subscribe((resBody: IMdmCitizenData[]) => {
          if (!mdmEmployeeMaster.personId || !mdmEmployeeMaster.personId.id) {
            this.personids = resBody;
          } else {
            this.mdmCitizenDataService
              .find(mdmEmployeeMaster.personId.id)
              .pipe(
                map((subRes: HttpResponse<IMdmCitizenData>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: IMdmCitizenData[]) => (this.personids = concatRes));
          }
        });
    });
  }

  updateForm(mdmEmployeeMaster: IMdmEmployeeMaster): void {
    this.editForm.patchValue({
      id: mdmEmployeeMaster.id,
      employeeCode: mdmEmployeeMaster.employeeCode,
      tempRefId: mdmEmployeeMaster.tempRefId,
      employeeId: mdmEmployeeMaster.employeeId,
      employeeName: mdmEmployeeMaster.employeeName,
      entityName: mdmEmployeeMaster.entityName,
      organizationName: mdmEmployeeMaster.organizationName,
      designationId: mdmEmployeeMaster.designationId,
      designationName: mdmEmployeeMaster.designationName,
      postName: mdmEmployeeMaster.postName,
      organizationUnitName: mdmEmployeeMaster.organizationUnitName,
      parentOrganizationUnit: mdmEmployeeMaster.parentOrganizationUnit,
      mobileNumber: mdmEmployeeMaster.mobileNumber,
      emailId: mdmEmployeeMaster.emailId,
      addressType: mdmEmployeeMaster.addressType,
      address1: mdmEmployeeMaster.address1,
      address2: mdmEmployeeMaster.address2,
      cityName: mdmEmployeeMaster.cityName,
      postOffice: mdmEmployeeMaster.postOffice,
      isPrimary: mdmEmployeeMaster.isPrimary,
      isOuHead: mdmEmployeeMaster.isOuHead,
      districtCode: mdmEmployeeMaster.districtCode,
      districtName: mdmEmployeeMaster.districtName,
      mandalCode: mdmEmployeeMaster.mandalCode,
      mandalName: mdmEmployeeMaster.mandalName,
      villageCode: mdmEmployeeMaster.villageCode,
      villageName: mdmEmployeeMaster.villageName,
      panchayatCode: mdmEmployeeMaster.panchayatCode,
      panchayatName: mdmEmployeeMaster.panchayatName,
      constituencyCode: mdmEmployeeMaster.constituencyCode,
      constituencyName: mdmEmployeeMaster.constituencyName,
      createdBy: mdmEmployeeMaster.createdBy,
      updatedBy: mdmEmployeeMaster.updatedBy,
      recordInsertTime: mdmEmployeeMaster.recordInsertTime ? mdmEmployeeMaster.recordInsertTime.format(DATE_TIME_FORMAT) : null,
      createTime: mdmEmployeeMaster.createTime ? mdmEmployeeMaster.createTime.format(DATE_TIME_FORMAT) : null,
      updateTime: mdmEmployeeMaster.updateTime ? mdmEmployeeMaster.updateTime.format(DATE_TIME_FORMAT) : null,
      employeeType: mdmEmployeeMaster.employeeType,
      managerEmployeeCode: mdmEmployeeMaster.managerEmployeeCode,
      employeeActiveStatus: mdmEmployeeMaster.employeeActiveStatus,
      personId1: mdmEmployeeMaster.personId1,
      aadhaarRefId: mdmEmployeeMaster.aadhaarRefId,
      volunteerSecretariatId: mdmEmployeeMaster.volunteerSecretariatId,
      volunteerSecretariatFlag: mdmEmployeeMaster.volunteerSecretariatFlag,
      aadhaarNumber: mdmEmployeeMaster.aadhaarNumber,
      organizationCode: mdmEmployeeMaster.organizationCode,
      personId: mdmEmployeeMaster.personId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdmEmployeeMaster = this.createFromForm();
    if (mdmEmployeeMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.mdmEmployeeMasterService.update(mdmEmployeeMaster));
    } else {
      this.subscribeToSaveResponse(this.mdmEmployeeMasterService.create(mdmEmployeeMaster));
    }
  }

  private createFromForm(): IMdmEmployeeMaster {
    return {
      ...new MdmEmployeeMaster(),
      id: this.editForm.get(['id'])!.value,
      employeeCode: this.editForm.get(['employeeCode'])!.value,
      tempRefId: this.editForm.get(['tempRefId'])!.value,
      employeeId: this.editForm.get(['employeeId'])!.value,
      employeeName: this.editForm.get(['employeeName'])!.value,
      entityName: this.editForm.get(['entityName'])!.value,
      organizationName: this.editForm.get(['organizationName'])!.value,
      designationId: this.editForm.get(['designationId'])!.value,
      designationName: this.editForm.get(['designationName'])!.value,
      postName: this.editForm.get(['postName'])!.value,
      organizationUnitName: this.editForm.get(['organizationUnitName'])!.value,
      parentOrganizationUnit: this.editForm.get(['parentOrganizationUnit'])!.value,
      mobileNumber: this.editForm.get(['mobileNumber'])!.value,
      emailId: this.editForm.get(['emailId'])!.value,
      addressType: this.editForm.get(['addressType'])!.value,
      address1: this.editForm.get(['address1'])!.value,
      address2: this.editForm.get(['address2'])!.value,
      cityName: this.editForm.get(['cityName'])!.value,
      postOffice: this.editForm.get(['postOffice'])!.value,
      isPrimary: this.editForm.get(['isPrimary'])!.value,
      isOuHead: this.editForm.get(['isOuHead'])!.value,
      districtCode: this.editForm.get(['districtCode'])!.value,
      districtName: this.editForm.get(['districtName'])!.value,
      mandalCode: this.editForm.get(['mandalCode'])!.value,
      mandalName: this.editForm.get(['mandalName'])!.value,
      villageCode: this.editForm.get(['villageCode'])!.value,
      villageName: this.editForm.get(['villageName'])!.value,
      panchayatCode: this.editForm.get(['panchayatCode'])!.value,
      panchayatName: this.editForm.get(['panchayatName'])!.value,
      constituencyCode: this.editForm.get(['constituencyCode'])!.value,
      constituencyName: this.editForm.get(['constituencyName'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      updatedBy: this.editForm.get(['updatedBy'])!.value,
      recordInsertTime: this.editForm.get(['recordInsertTime'])!.value
        ? moment(this.editForm.get(['recordInsertTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      createTime: this.editForm.get(['createTime'])!.value ? moment(this.editForm.get(['createTime'])!.value, DATE_TIME_FORMAT) : undefined,
      updateTime: this.editForm.get(['updateTime'])!.value ? moment(this.editForm.get(['updateTime'])!.value, DATE_TIME_FORMAT) : undefined,
      employeeType: this.editForm.get(['employeeType'])!.value,
      managerEmployeeCode: this.editForm.get(['managerEmployeeCode'])!.value,
      employeeActiveStatus: this.editForm.get(['employeeActiveStatus'])!.value,
      personId1: this.editForm.get(['personId1'])!.value,
      aadhaarRefId: this.editForm.get(['aadhaarRefId'])!.value,
      volunteerSecretariatId: this.editForm.get(['volunteerSecretariatId'])!.value,
      volunteerSecretariatFlag: this.editForm.get(['volunteerSecretariatFlag'])!.value,
      aadhaarNumber: this.editForm.get(['aadhaarNumber'])!.value,
      organizationCode: this.editForm.get(['organizationCode'])!.value,
      personId: this.editForm.get(['personId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdmEmployeeMaster>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
