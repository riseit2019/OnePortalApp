import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IMdmRoleActivityMaster, MdmRoleActivityMaster } from 'app/shared/model/mdm-role-activity-master.model';
import { MdmRoleActivityMasterService } from './mdm-role-activity-master.service';
import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { MdmOrganizationMasterService } from 'app/entities/mdm-organization-master/mdm-organization-master.service';

@Component({
  selector: 'jhi-mdm-role-activity-master-update',
  templateUrl: './mdm-role-activity-master-update.component.html'
})
export class MdmRoleActivityMasterUpdateComponent implements OnInit {
  isSaving = false;
  mdmorganizationmasters: IMdmOrganizationMaster[] = [];

  editForm = this.fb.group({
    id: [],
    syspk: [null, [Validators.required]],
    activityCode: [null, [Validators.required]],
    activityName: [null, [Validators.required]],
    activityLevelId: [],
    activityLevelDesc: [],
    roleCode: [null, [Validators.required]],
    roleName: [null, [Validators.required]],
    roleLevelId: [],
    roleLevelDesc: [],
    roleActivityStatus: [],
    createdBy: [],
    updatedBy: [],
    recordInsertTime: [],
    createTime: [],
    updateTime: [],
    organizationCode: []
  });

  constructor(
    protected mdmRoleActivityMasterService: MdmRoleActivityMasterService,
    protected mdmOrganizationMasterService: MdmOrganizationMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmRoleActivityMaster }) => {
      if (!mdmRoleActivityMaster.id) {
        const today = moment().startOf('day');
        mdmRoleActivityMaster.recordInsertTime = today;
        mdmRoleActivityMaster.createTime = today;
        mdmRoleActivityMaster.updateTime = today;
      }

      this.updateForm(mdmRoleActivityMaster);

      this.mdmOrganizationMasterService
        .query()
        .subscribe((res: HttpResponse<IMdmOrganizationMaster[]>) => (this.mdmorganizationmasters = res.body || []));
    });
  }

  updateForm(mdmRoleActivityMaster: IMdmRoleActivityMaster): void {
    this.editForm.patchValue({
      id: mdmRoleActivityMaster.id,
      syspk: mdmRoleActivityMaster.syspk,
      activityCode: mdmRoleActivityMaster.activityCode,
      activityName: mdmRoleActivityMaster.activityName,
      activityLevelId: mdmRoleActivityMaster.activityLevelId,
      activityLevelDesc: mdmRoleActivityMaster.activityLevelDesc,
      roleCode: mdmRoleActivityMaster.roleCode,
      roleName: mdmRoleActivityMaster.roleName,
      roleLevelId: mdmRoleActivityMaster.roleLevelId,
      roleLevelDesc: mdmRoleActivityMaster.roleLevelDesc,
      roleActivityStatus: mdmRoleActivityMaster.roleActivityStatus,
      createdBy: mdmRoleActivityMaster.createdBy,
      updatedBy: mdmRoleActivityMaster.updatedBy,
      recordInsertTime: mdmRoleActivityMaster.recordInsertTime ? mdmRoleActivityMaster.recordInsertTime.format(DATE_TIME_FORMAT) : null,
      createTime: mdmRoleActivityMaster.createTime ? mdmRoleActivityMaster.createTime.format(DATE_TIME_FORMAT) : null,
      updateTime: mdmRoleActivityMaster.updateTime ? mdmRoleActivityMaster.updateTime.format(DATE_TIME_FORMAT) : null,
      organizationCode: mdmRoleActivityMaster.organizationCode
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdmRoleActivityMaster = this.createFromForm();
    if (mdmRoleActivityMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.mdmRoleActivityMasterService.update(mdmRoleActivityMaster));
    } else {
      this.subscribeToSaveResponse(this.mdmRoleActivityMasterService.create(mdmRoleActivityMaster));
    }
  }

  private createFromForm(): IMdmRoleActivityMaster {
    return {
      ...new MdmRoleActivityMaster(),
      id: this.editForm.get(['id'])!.value,
      syspk: this.editForm.get(['syspk'])!.value,
      activityCode: this.editForm.get(['activityCode'])!.value,
      activityName: this.editForm.get(['activityName'])!.value,
      activityLevelId: this.editForm.get(['activityLevelId'])!.value,
      activityLevelDesc: this.editForm.get(['activityLevelDesc'])!.value,
      roleCode: this.editForm.get(['roleCode'])!.value,
      roleName: this.editForm.get(['roleName'])!.value,
      roleLevelId: this.editForm.get(['roleLevelId'])!.value,
      roleLevelDesc: this.editForm.get(['roleLevelDesc'])!.value,
      roleActivityStatus: this.editForm.get(['roleActivityStatus'])!.value,
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

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdmRoleActivityMaster>>): void {
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
