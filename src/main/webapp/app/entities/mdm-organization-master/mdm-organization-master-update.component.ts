import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IMdmOrganizationMaster, MdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { MdmOrganizationMasterService } from './mdm-organization-master.service';

@Component({
  selector: 'jhi-mdm-organization-master-update',
  templateUrl: './mdm-organization-master-update.component.html'
})
export class MdmOrganizationMasterUpdateComponent implements OnInit {
  isSaving = false;
  startDateDp: any;
  endDateDp: any;

  editForm = this.fb.group({
    id: [],
    organizationCode: [null, [Validators.required]],
    organizationShortName: [],
    organizationName: [],
    organizationType: [],
    organizationDesc: [],
    sectorCode: [],
    parentOrgCode: [],
    organizationActiveFlag: [],
    createdBy: [],
    updatedBy: [],
    recordInsertTime: [],
    createTime: [],
    updateTime: [],
    startDate: [],
    endDate: [],
    organizationTypeDesc: [],
    jurisdictionType: []
  });

  constructor(
    protected mdmOrganizationMasterService: MdmOrganizationMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmOrganizationMaster }) => {
      if (!mdmOrganizationMaster.id) {
        const today = moment().startOf('day');
        mdmOrganizationMaster.recordInsertTime = today;
        mdmOrganizationMaster.createTime = today;
        mdmOrganizationMaster.updateTime = today;
      }

      this.updateForm(mdmOrganizationMaster);
    });
  }

  updateForm(mdmOrganizationMaster: IMdmOrganizationMaster): void {
    this.editForm.patchValue({
      id: mdmOrganizationMaster.id,
      organizationCode: mdmOrganizationMaster.organizationCode,
      organizationShortName: mdmOrganizationMaster.organizationShortName,
      organizationName: mdmOrganizationMaster.organizationName,
      organizationType: mdmOrganizationMaster.organizationType,
      organizationDesc: mdmOrganizationMaster.organizationDesc,
      sectorCode: mdmOrganizationMaster.sectorCode,
      parentOrgCode: mdmOrganizationMaster.parentOrgCode,
      organizationActiveFlag: mdmOrganizationMaster.organizationActiveFlag,
      createdBy: mdmOrganizationMaster.createdBy,
      updatedBy: mdmOrganizationMaster.updatedBy,
      recordInsertTime: mdmOrganizationMaster.recordInsertTime ? mdmOrganizationMaster.recordInsertTime.format(DATE_TIME_FORMAT) : null,
      createTime: mdmOrganizationMaster.createTime ? mdmOrganizationMaster.createTime.format(DATE_TIME_FORMAT) : null,
      updateTime: mdmOrganizationMaster.updateTime ? mdmOrganizationMaster.updateTime.format(DATE_TIME_FORMAT) : null,
      startDate: mdmOrganizationMaster.startDate,
      endDate: mdmOrganizationMaster.endDate,
      organizationTypeDesc: mdmOrganizationMaster.organizationTypeDesc,
      jurisdictionType: mdmOrganizationMaster.jurisdictionType
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdmOrganizationMaster = this.createFromForm();
    if (mdmOrganizationMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.mdmOrganizationMasterService.update(mdmOrganizationMaster));
    } else {
      this.subscribeToSaveResponse(this.mdmOrganizationMasterService.create(mdmOrganizationMaster));
    }
  }

  private createFromForm(): IMdmOrganizationMaster {
    return {
      ...new MdmOrganizationMaster(),
      id: this.editForm.get(['id'])!.value,
      organizationCode: this.editForm.get(['organizationCode'])!.value,
      organizationShortName: this.editForm.get(['organizationShortName'])!.value,
      organizationName: this.editForm.get(['organizationName'])!.value,
      organizationType: this.editForm.get(['organizationType'])!.value,
      organizationDesc: this.editForm.get(['organizationDesc'])!.value,
      sectorCode: this.editForm.get(['sectorCode'])!.value,
      parentOrgCode: this.editForm.get(['parentOrgCode'])!.value,
      organizationActiveFlag: this.editForm.get(['organizationActiveFlag'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      updatedBy: this.editForm.get(['updatedBy'])!.value,
      recordInsertTime: this.editForm.get(['recordInsertTime'])!.value
        ? moment(this.editForm.get(['recordInsertTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      createTime: this.editForm.get(['createTime'])!.value ? moment(this.editForm.get(['createTime'])!.value, DATE_TIME_FORMAT) : undefined,
      updateTime: this.editForm.get(['updateTime'])!.value ? moment(this.editForm.get(['updateTime'])!.value, DATE_TIME_FORMAT) : undefined,
      startDate: this.editForm.get(['startDate'])!.value,
      endDate: this.editForm.get(['endDate'])!.value,
      organizationTypeDesc: this.editForm.get(['organizationTypeDesc'])!.value,
      jurisdictionType: this.editForm.get(['jurisdictionType'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdmOrganizationMaster>>): void {
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
