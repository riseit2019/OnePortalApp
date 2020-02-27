import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IMdmActivityMaster, MdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';
import { MdmActivityMasterService } from './mdm-activity-master.service';
import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { MdmOrganizationMasterService } from 'app/entities/mdm-organization-master/mdm-organization-master.service';

@Component({
  selector: 'jhi-mdm-activity-master-update',
  templateUrl: './mdm-activity-master-update.component.html'
})
export class MdmActivityMasterUpdateComponent implements OnInit {
  isSaving = false;
  mdmorganizationmasters: IMdmOrganizationMaster[] = [];

  editForm = this.fb.group({
    id: [],
    activityCode: [null, [Validators.required]],
    activityName: [null, [Validators.required]],
    activityDesc: [],
    activityLevelId: [],
    activityLevelDesc: [],
    organizationName: [],
    activityStatus: [null, [Validators.required]],
    createdBy: [],
    updatedBy: [],
    recordInsertTime: [],
    createTime: [],
    updateTime: [],
    organizationCode: []
  });

  constructor(
    protected mdmActivityMasterService: MdmActivityMasterService,
    protected mdmOrganizationMasterService: MdmOrganizationMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmActivityMaster }) => {
      if (!mdmActivityMaster.id) {
        const today = moment().startOf('day');
        mdmActivityMaster.recordInsertTime = today;
        mdmActivityMaster.createTime = today;
        mdmActivityMaster.updateTime = today;
      }

      this.updateForm(mdmActivityMaster);

      this.mdmOrganizationMasterService
        .query()
        .subscribe((res: HttpResponse<IMdmOrganizationMaster[]>) => (this.mdmorganizationmasters = res.body || []));
    });
  }

  updateForm(mdmActivityMaster: IMdmActivityMaster): void {
    this.editForm.patchValue({
      id: mdmActivityMaster.id,
      activityCode: mdmActivityMaster.activityCode,
      activityName: mdmActivityMaster.activityName,
      activityDesc: mdmActivityMaster.activityDesc,
      activityLevelId: mdmActivityMaster.activityLevelId,
      activityLevelDesc: mdmActivityMaster.activityLevelDesc,
      organizationName: mdmActivityMaster.organizationName,
      activityStatus: mdmActivityMaster.activityStatus,
      createdBy: mdmActivityMaster.createdBy,
      updatedBy: mdmActivityMaster.updatedBy,
      recordInsertTime: mdmActivityMaster.recordInsertTime ? mdmActivityMaster.recordInsertTime.format(DATE_TIME_FORMAT) : null,
      createTime: mdmActivityMaster.createTime ? mdmActivityMaster.createTime.format(DATE_TIME_FORMAT) : null,
      updateTime: mdmActivityMaster.updateTime ? mdmActivityMaster.updateTime.format(DATE_TIME_FORMAT) : null,
      organizationCode: mdmActivityMaster.organizationCode
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdmActivityMaster = this.createFromForm();
    if (mdmActivityMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.mdmActivityMasterService.update(mdmActivityMaster));
    } else {
      this.subscribeToSaveResponse(this.mdmActivityMasterService.create(mdmActivityMaster));
    }
  }

  private createFromForm(): IMdmActivityMaster {
    return {
      ...new MdmActivityMaster(),
      id: this.editForm.get(['id'])!.value,
      activityCode: this.editForm.get(['activityCode'])!.value,
      activityName: this.editForm.get(['activityName'])!.value,
      activityDesc: this.editForm.get(['activityDesc'])!.value,
      activityLevelId: this.editForm.get(['activityLevelId'])!.value,
      activityLevelDesc: this.editForm.get(['activityLevelDesc'])!.value,
      organizationName: this.editForm.get(['organizationName'])!.value,
      activityStatus: this.editForm.get(['activityStatus'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      updatedBy: this.editForm.get(['updatedBy'])!.value,
      recordInsertTime: this.editForm.get(['recordInsertTime'])!.value
        ? moment(this.editForm.get(['recordInsertTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      createTime: this.editForm.get(['createTime'])!.value ? moment(this.editForm.get(['createTime'])!.value, DATE_TIME_FORMAT) : undefined,
      updateTime: this.editForm.get(['updateTime'])!.value ? moment(this.editForm.get(['updateTime'])!.value, DATE_TIME_FORMAT) : undefined,
      organizationCode: this.editForm.get(['organizationCode'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdmActivityMaster>>): void {
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

  trackById(index: number, item: IMdmOrganizationMaster): any {
    return item.id;
  }
}
