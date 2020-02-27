import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IMdmMeesevaServiceMaster, MdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';
import { MdmMeesevaServiceMasterService } from './mdm-meeseva-service-master.service';

@Component({
  selector: 'jhi-mdm-meeseva-service-master-update',
  templateUrl: './mdm-meeseva-service-master-update.component.html'
})
export class MdmMeesevaServiceMasterUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    meesevaServiceId: [null, [Validators.required]],
    meesevaServiceName: [null, [Validators.required]],
    isCharged: [],
    organizationEntityTypeCode: [],
    applicationTable: [],
    applicationObject: [],
    customerDefaultFlag: [],
    channelDefaultFlag: [],
    serviceUrl: [],
    backOfficeUrl: [],
    packageId: [],
    meesevaServiceActiveFlag: [],
    meesevaServiceGroupId: [],
    meesevaServiceSubGroupId: [],
    meesevaServiceTypeId: [],
    meesevaServiceSubTypeId: [],
    departmentCode: [],
    efmsDepartmentCode: [],
    isOnline: [],
    agencyType: [],
    launchDate: [],
    isMobile: [],
    innerSubId: [],
    digilockerEnabled: [],
    isRegular: [],
    isSeasonal: [],
    citizenPortalLaunchDate: [],
    createdBy: [],
    updatedBy: [],
    recordInsertTime: [],
    createTime: [],
    updateTime: []
  });

  constructor(
    protected mdmMeesevaServiceMasterService: MdmMeesevaServiceMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmMeesevaServiceMaster }) => {
      if (!mdmMeesevaServiceMaster.id) {
        const today = moment().startOf('day');
        mdmMeesevaServiceMaster.launchDate = today;
        mdmMeesevaServiceMaster.citizenPortalLaunchDate = today;
        mdmMeesevaServiceMaster.recordInsertTime = today;
        mdmMeesevaServiceMaster.createTime = today;
        mdmMeesevaServiceMaster.updateTime = today;
      }

      this.updateForm(mdmMeesevaServiceMaster);
    });
  }

  updateForm(mdmMeesevaServiceMaster: IMdmMeesevaServiceMaster): void {
    this.editForm.patchValue({
      id: mdmMeesevaServiceMaster.id,
      meesevaServiceId: mdmMeesevaServiceMaster.meesevaServiceId,
      meesevaServiceName: mdmMeesevaServiceMaster.meesevaServiceName,
      isCharged: mdmMeesevaServiceMaster.isCharged,
      organizationEntityTypeCode: mdmMeesevaServiceMaster.organizationEntityTypeCode,
      applicationTable: mdmMeesevaServiceMaster.applicationTable,
      applicationObject: mdmMeesevaServiceMaster.applicationObject,
      customerDefaultFlag: mdmMeesevaServiceMaster.customerDefaultFlag,
      channelDefaultFlag: mdmMeesevaServiceMaster.channelDefaultFlag,
      serviceUrl: mdmMeesevaServiceMaster.serviceUrl,
      backOfficeUrl: mdmMeesevaServiceMaster.backOfficeUrl,
      packageId: mdmMeesevaServiceMaster.packageId,
      meesevaServiceActiveFlag: mdmMeesevaServiceMaster.meesevaServiceActiveFlag,
      meesevaServiceGroupId: mdmMeesevaServiceMaster.meesevaServiceGroupId,
      meesevaServiceSubGroupId: mdmMeesevaServiceMaster.meesevaServiceSubGroupId,
      meesevaServiceTypeId: mdmMeesevaServiceMaster.meesevaServiceTypeId,
      meesevaServiceSubTypeId: mdmMeesevaServiceMaster.meesevaServiceSubTypeId,
      departmentCode: mdmMeesevaServiceMaster.departmentCode,
      efmsDepartmentCode: mdmMeesevaServiceMaster.efmsDepartmentCode,
      isOnline: mdmMeesevaServiceMaster.isOnline,
      agencyType: mdmMeesevaServiceMaster.agencyType,
      launchDate: mdmMeesevaServiceMaster.launchDate ? mdmMeesevaServiceMaster.launchDate.format(DATE_TIME_FORMAT) : null,
      isMobile: mdmMeesevaServiceMaster.isMobile,
      innerSubId: mdmMeesevaServiceMaster.innerSubId,
      digilockerEnabled: mdmMeesevaServiceMaster.digilockerEnabled,
      isRegular: mdmMeesevaServiceMaster.isRegular,
      isSeasonal: mdmMeesevaServiceMaster.isSeasonal,
      citizenPortalLaunchDate: mdmMeesevaServiceMaster.citizenPortalLaunchDate
        ? mdmMeesevaServiceMaster.citizenPortalLaunchDate.format(DATE_TIME_FORMAT)
        : null,
      createdBy: mdmMeesevaServiceMaster.createdBy,
      updatedBy: mdmMeesevaServiceMaster.updatedBy,
      recordInsertTime: mdmMeesevaServiceMaster.recordInsertTime ? mdmMeesevaServiceMaster.recordInsertTime.format(DATE_TIME_FORMAT) : null,
      createTime: mdmMeesevaServiceMaster.createTime ? mdmMeesevaServiceMaster.createTime.format(DATE_TIME_FORMAT) : null,
      updateTime: mdmMeesevaServiceMaster.updateTime ? mdmMeesevaServiceMaster.updateTime.format(DATE_TIME_FORMAT) : null
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdmMeesevaServiceMaster = this.createFromForm();
    if (mdmMeesevaServiceMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.mdmMeesevaServiceMasterService.update(mdmMeesevaServiceMaster));
    } else {
      this.subscribeToSaveResponse(this.mdmMeesevaServiceMasterService.create(mdmMeesevaServiceMaster));
    }
  }

  private createFromForm(): IMdmMeesevaServiceMaster {
    return {
      ...new MdmMeesevaServiceMaster(),
      id: this.editForm.get(['id'])!.value,
      meesevaServiceId: this.editForm.get(['meesevaServiceId'])!.value,
      meesevaServiceName: this.editForm.get(['meesevaServiceName'])!.value,
      isCharged: this.editForm.get(['isCharged'])!.value,
      organizationEntityTypeCode: this.editForm.get(['organizationEntityTypeCode'])!.value,
      applicationTable: this.editForm.get(['applicationTable'])!.value,
      applicationObject: this.editForm.get(['applicationObject'])!.value,
      customerDefaultFlag: this.editForm.get(['customerDefaultFlag'])!.value,
      channelDefaultFlag: this.editForm.get(['channelDefaultFlag'])!.value,
      serviceUrl: this.editForm.get(['serviceUrl'])!.value,
      backOfficeUrl: this.editForm.get(['backOfficeUrl'])!.value,
      packageId: this.editForm.get(['packageId'])!.value,
      meesevaServiceActiveFlag: this.editForm.get(['meesevaServiceActiveFlag'])!.value,
      meesevaServiceGroupId: this.editForm.get(['meesevaServiceGroupId'])!.value,
      meesevaServiceSubGroupId: this.editForm.get(['meesevaServiceSubGroupId'])!.value,
      meesevaServiceTypeId: this.editForm.get(['meesevaServiceTypeId'])!.value,
      meesevaServiceSubTypeId: this.editForm.get(['meesevaServiceSubTypeId'])!.value,
      departmentCode: this.editForm.get(['departmentCode'])!.value,
      efmsDepartmentCode: this.editForm.get(['efmsDepartmentCode'])!.value,
      isOnline: this.editForm.get(['isOnline'])!.value,
      agencyType: this.editForm.get(['agencyType'])!.value,
      launchDate: this.editForm.get(['launchDate'])!.value ? moment(this.editForm.get(['launchDate'])!.value, DATE_TIME_FORMAT) : undefined,
      isMobile: this.editForm.get(['isMobile'])!.value,
      innerSubId: this.editForm.get(['innerSubId'])!.value,
      digilockerEnabled: this.editForm.get(['digilockerEnabled'])!.value,
      isRegular: this.editForm.get(['isRegular'])!.value,
      isSeasonal: this.editForm.get(['isSeasonal'])!.value,
      citizenPortalLaunchDate: this.editForm.get(['citizenPortalLaunchDate'])!.value
        ? moment(this.editForm.get(['citizenPortalLaunchDate'])!.value, DATE_TIME_FORMAT)
        : undefined,
      createdBy: this.editForm.get(['createdBy'])!.value,
      updatedBy: this.editForm.get(['updatedBy'])!.value,
      recordInsertTime: this.editForm.get(['recordInsertTime'])!.value
        ? moment(this.editForm.get(['recordInsertTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      createTime: this.editForm.get(['createTime'])!.value ? moment(this.editForm.get(['createTime'])!.value, DATE_TIME_FORMAT) : undefined,
      updateTime: this.editForm.get(['updateTime'])!.value ? moment(this.editForm.get(['updateTime'])!.value, DATE_TIME_FORMAT) : undefined
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdmMeesevaServiceMaster>>): void {
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
}
