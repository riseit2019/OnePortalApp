import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IMdmRoleMaster, MdmRoleMaster } from 'app/shared/model/mdm-role-master.model';
import { MdmRoleMasterService } from './mdm-role-master.service';

@Component({
  selector: 'jhi-mdm-role-master-update',
  templateUrl: './mdm-role-master-update.component.html'
})
export class MdmRoleMasterUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    roleCode: [null, [Validators.required]],
    roleName: [],
    roleDesc: [],
    organizationCode: [],
    organizationName: [],
    serviceCode: [],
    serviceName: [],
    locationCode: [],
    locationName: [],
    roleStatus: [],
    createdBy: [],
    updatedBy: [],
    recordInsertTime: [],
    createTime: [],
    updateTime: [],
    roleLevelId: [],
    roleLevelDesc: [],
    volunteerSecretariat: []
  });

  constructor(protected mdmRoleMasterService: MdmRoleMasterService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmRoleMaster }) => {
      if (!mdmRoleMaster.id) {
        const today = moment().startOf('day');
        mdmRoleMaster.recordInsertTime = today;
        mdmRoleMaster.createTime = today;
        mdmRoleMaster.updateTime = today;
      }

      this.updateForm(mdmRoleMaster);
    });
  }

  updateForm(mdmRoleMaster: IMdmRoleMaster): void {
    this.editForm.patchValue({
      id: mdmRoleMaster.id,
      roleCode: mdmRoleMaster.roleCode,
      roleName: mdmRoleMaster.roleName,
      roleDesc: mdmRoleMaster.roleDesc,
      organizationCode: mdmRoleMaster.organizationCode,
      organizationName: mdmRoleMaster.organizationName,
      serviceCode: mdmRoleMaster.serviceCode,
      serviceName: mdmRoleMaster.serviceName,
      locationCode: mdmRoleMaster.locationCode,
      locationName: mdmRoleMaster.locationName,
      roleStatus: mdmRoleMaster.roleStatus,
      createdBy: mdmRoleMaster.createdBy,
      updatedBy: mdmRoleMaster.updatedBy,
      recordInsertTime: mdmRoleMaster.recordInsertTime ? mdmRoleMaster.recordInsertTime.format(DATE_TIME_FORMAT) : null,
      createTime: mdmRoleMaster.createTime ? mdmRoleMaster.createTime.format(DATE_TIME_FORMAT) : null,
      updateTime: mdmRoleMaster.updateTime ? mdmRoleMaster.updateTime.format(DATE_TIME_FORMAT) : null,
      roleLevelId: mdmRoleMaster.roleLevelId,
      roleLevelDesc: mdmRoleMaster.roleLevelDesc,
      volunteerSecretariat: mdmRoleMaster.volunteerSecretariat
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdmRoleMaster = this.createFromForm();
    if (mdmRoleMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.mdmRoleMasterService.update(mdmRoleMaster));
    } else {
      this.subscribeToSaveResponse(this.mdmRoleMasterService.create(mdmRoleMaster));
    }
  }

  private createFromForm(): IMdmRoleMaster {
    return {
      ...new MdmRoleMaster(),
      id: this.editForm.get(['id'])!.value,
      roleCode: this.editForm.get(['roleCode'])!.value,
      roleName: this.editForm.get(['roleName'])!.value,
      roleDesc: this.editForm.get(['roleDesc'])!.value,
      organizationCode: this.editForm.get(['organizationCode'])!.value,
      organizationName: this.editForm.get(['organizationName'])!.value,
      serviceCode: this.editForm.get(['serviceCode'])!.value,
      serviceName: this.editForm.get(['serviceName'])!.value,
      locationCode: this.editForm.get(['locationCode'])!.value,
      locationName: this.editForm.get(['locationName'])!.value,
      roleStatus: this.editForm.get(['roleStatus'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      updatedBy: this.editForm.get(['updatedBy'])!.value,
      recordInsertTime: this.editForm.get(['recordInsertTime'])!.value
        ? moment(this.editForm.get(['recordInsertTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      createTime: this.editForm.get(['createTime'])!.value ? moment(this.editForm.get(['createTime'])!.value, DATE_TIME_FORMAT) : undefined,
      updateTime: this.editForm.get(['updateTime'])!.value ? moment(this.editForm.get(['updateTime'])!.value, DATE_TIME_FORMAT) : undefined,
      roleLevelId: this.editForm.get(['roleLevelId'])!.value,
      roleLevelDesc: this.editForm.get(['roleLevelDesc'])!.value,
      volunteerSecretariat: this.editForm.get(['volunteerSecretariat'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdmRoleMaster>>): void {
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
