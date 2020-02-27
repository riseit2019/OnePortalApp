import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IMdmEmpRoleMaster, MdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';
import { MdmEmpRoleMasterService } from './mdm-emp-role-master.service';
import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { MdmOrganizationMasterService } from 'app/entities/mdm-organization-master/mdm-organization-master.service';
import { IMdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';
import { MdmEmployeeMasterService } from 'app/entities/mdm-employee-master/mdm-employee-master.service';
import { IMdmRoleMaster } from 'app/shared/model/mdm-role-master.model';
import { MdmRoleMasterService } from 'app/entities/mdm-role-master/mdm-role-master.service';

type SelectableEntity = IMdmOrganizationMaster | IMdmEmployeeMaster | IMdmRoleMaster;

@Component({
  selector: 'jhi-mdm-emp-role-master-update',
  templateUrl: './mdm-emp-role-master-update.component.html'
})
export class MdmEmpRoleMasterUpdateComponent implements OnInit {
  isSaving = false;
  mdmorganizationmasters: IMdmOrganizationMaster[] = [];
  mdmemployeemasters: IMdmEmployeeMaster[] = [];
  mdmrolemasters: IMdmRoleMaster[] = [];

  editForm = this.fb.group({
    id: [],
    syspk: [null, [Validators.required]],
    employeeName: [],
    roleName: [],
    officeCode: [null, [Validators.required]],
    officeName: [],
    personId: [],
    organizationName: [],
    stateCode: [],
    stateName: [],
    districtCode: [],
    districtName: [],
    mandalCode: [],
    mandalName: [],
    villageCode: [],
    villageName: [],
    circleName: [],
    divisionName: [],
    subDivisionName: [],
    sectionName: [],
    activeStatusFlag: [],
    createdBy: [],
    updatedBy: [],
    recordInsertTime: [],
    createTime: [],
    updateTime: [],
    volunteerSecretariatRole: [],
    organizationCode: [],
    employeeCode: [],
    roleCode: []
  });

  constructor(
    protected mdmEmpRoleMasterService: MdmEmpRoleMasterService,
    protected mdmOrganizationMasterService: MdmOrganizationMasterService,
    protected mdmEmployeeMasterService: MdmEmployeeMasterService,
    protected mdmRoleMasterService: MdmRoleMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmEmpRoleMaster }) => {
      if (!mdmEmpRoleMaster.id) {
        const today = moment().startOf('day');
        mdmEmpRoleMaster.recordInsertTime = today;
        mdmEmpRoleMaster.createTime = today;
        mdmEmpRoleMaster.updateTime = today;
      }

      this.updateForm(mdmEmpRoleMaster);

      this.mdmOrganizationMasterService
        .query()
        .subscribe((res: HttpResponse<IMdmOrganizationMaster[]>) => (this.mdmorganizationmasters = res.body || []));

      this.mdmEmployeeMasterService
        .query()
        .subscribe((res: HttpResponse<IMdmEmployeeMaster[]>) => (this.mdmemployeemasters = res.body || []));

      this.mdmRoleMasterService.query().subscribe((res: HttpResponse<IMdmRoleMaster[]>) => (this.mdmrolemasters = res.body || []));
    });
  }

  updateForm(mdmEmpRoleMaster: IMdmEmpRoleMaster): void {
    this.editForm.patchValue({
      id: mdmEmpRoleMaster.id,
      syspk: mdmEmpRoleMaster.syspk,
      employeeName: mdmEmpRoleMaster.employeeName,
      roleName: mdmEmpRoleMaster.roleName,
      officeCode: mdmEmpRoleMaster.officeCode,
      officeName: mdmEmpRoleMaster.officeName,
      personId: mdmEmpRoleMaster.personId,
      organizationName: mdmEmpRoleMaster.organizationName,
      stateCode: mdmEmpRoleMaster.stateCode,
      stateName: mdmEmpRoleMaster.stateName,
      districtCode: mdmEmpRoleMaster.districtCode,
      districtName: mdmEmpRoleMaster.districtName,
      mandalCode: mdmEmpRoleMaster.mandalCode,
      mandalName: mdmEmpRoleMaster.mandalName,
      villageCode: mdmEmpRoleMaster.villageCode,
      villageName: mdmEmpRoleMaster.villageName,
      circleName: mdmEmpRoleMaster.circleName,
      divisionName: mdmEmpRoleMaster.divisionName,
      subDivisionName: mdmEmpRoleMaster.subDivisionName,
      sectionName: mdmEmpRoleMaster.sectionName,
      activeStatusFlag: mdmEmpRoleMaster.activeStatusFlag,
      createdBy: mdmEmpRoleMaster.createdBy,
      updatedBy: mdmEmpRoleMaster.updatedBy,
      recordInsertTime: mdmEmpRoleMaster.recordInsertTime ? mdmEmpRoleMaster.recordInsertTime.format(DATE_TIME_FORMAT) : null,
      createTime: mdmEmpRoleMaster.createTime ? mdmEmpRoleMaster.createTime.format(DATE_TIME_FORMAT) : null,
      updateTime: mdmEmpRoleMaster.updateTime ? mdmEmpRoleMaster.updateTime.format(DATE_TIME_FORMAT) : null,
      volunteerSecretariatRole: mdmEmpRoleMaster.volunteerSecretariatRole,
      organizationCode: mdmEmpRoleMaster.organizationCode,
      employeeCode: mdmEmpRoleMaster.employeeCode,
      roleCode: mdmEmpRoleMaster.roleCode
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdmEmpRoleMaster = this.createFromForm();
    if (mdmEmpRoleMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.mdmEmpRoleMasterService.update(mdmEmpRoleMaster));
    } else {
      this.subscribeToSaveResponse(this.mdmEmpRoleMasterService.create(mdmEmpRoleMaster));
    }
  }

  private createFromForm(): IMdmEmpRoleMaster {
    return {
      ...new MdmEmpRoleMaster(),
      id: this.editForm.get(['id'])!.value,
      syspk: this.editForm.get(['syspk'])!.value,
      employeeName: this.editForm.get(['employeeName'])!.value,
      roleName: this.editForm.get(['roleName'])!.value,
      officeCode: this.editForm.get(['officeCode'])!.value,
      officeName: this.editForm.get(['officeName'])!.value,
      personId: this.editForm.get(['personId'])!.value,
      organizationName: this.editForm.get(['organizationName'])!.value,
      stateCode: this.editForm.get(['stateCode'])!.value,
      stateName: this.editForm.get(['stateName'])!.value,
      districtCode: this.editForm.get(['districtCode'])!.value,
      districtName: this.editForm.get(['districtName'])!.value,
      mandalCode: this.editForm.get(['mandalCode'])!.value,
      mandalName: this.editForm.get(['mandalName'])!.value,
      villageCode: this.editForm.get(['villageCode'])!.value,
      villageName: this.editForm.get(['villageName'])!.value,
      circleName: this.editForm.get(['circleName'])!.value,
      divisionName: this.editForm.get(['divisionName'])!.value,
      subDivisionName: this.editForm.get(['subDivisionName'])!.value,
      sectionName: this.editForm.get(['sectionName'])!.value,
      activeStatusFlag: this.editForm.get(['activeStatusFlag'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      updatedBy: this.editForm.get(['updatedBy'])!.value,
      recordInsertTime: this.editForm.get(['recordInsertTime'])!.value
        ? moment(this.editForm.get(['recordInsertTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      createTime: this.editForm.get(['createTime'])!.value ? moment(this.editForm.get(['createTime'])!.value, DATE_TIME_FORMAT) : undefined,
      updateTime: this.editForm.get(['updateTime'])!.value ? moment(this.editForm.get(['updateTime'])!.value, DATE_TIME_FORMAT) : undefined,
      volunteerSecretariatRole: this.editForm.get(['volunteerSecretariatRole'])!.value,
      organizationCode: this.editForm.get(['organizationCode'])!.value,
      employeeCode: this.editForm.get(['employeeCode'])!.value,
      roleCode: this.editForm.get(['roleCode'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdmEmpRoleMaster>>): void {
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
