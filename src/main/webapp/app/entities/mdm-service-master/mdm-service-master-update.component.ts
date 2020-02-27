import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IMdmServiceMaster, MdmServiceMaster } from 'app/shared/model/mdm-service-master.model';
import { MdmServiceMasterService } from './mdm-service-master.service';
import { IMdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';
import { MdmMeesevaServiceMasterService } from 'app/entities/mdm-meeseva-service-master/mdm-meeseva-service-master.service';
import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { MdmOrganizationMasterService } from 'app/entities/mdm-organization-master/mdm-organization-master.service';

type SelectableEntity = IMdmMeesevaServiceMaster | IMdmOrganizationMaster;

@Component({
  selector: 'jhi-mdm-service-master-update',
  templateUrl: './mdm-service-master-update.component.html'
})
export class MdmServiceMasterUpdateComponent implements OnInit {
  isSaving = false;
  meesevaserviceids: IMdmMeesevaServiceMaster[] = [];
  organizationcodes: IMdmOrganizationMaster[] = [];

  editForm = this.fb.group({
    id: [],
    serviceCode: [null, [Validators.required]],
    organizationName: [],
    serviceShortName: [],
    serviceName: [],
    serviceDesc: [],
    parentServiceCode: [],
    servicePeriodStartDate: [],
    servicePeriodEndDate: [],
    serviceCategory: [],
    serviceLink: [],
    serviceClass: [],
    serviceIntegrationType: [],
    serviceType: [],
    lookupRoleId: [],
    lookupRole: [],
    lookupSectorId: [],
    lookupSector: [],
    lookupLifeeventId: [],
    lookupLifeevent: [],
    slaGoal: [],
    serviceActiveFlag: [null, [Validators.required]],
    createdBy: [],
    updatedBy: [],
    recordInsertTime: [],
    createTime: [],
    updateTime: [],
    sectionDisplayName: [],
    sectionDisplayIcon: [],
    rulesetName: [],
    servicePriority: [],
    serviceChannelAccess: [],
    serviceAccess: [],
    assistedmodeekycReq: [],
    assistedOthAdrReq: [],
    slaDeadline: [],
    paymentChannelId: [],
    paymentReturnClass: [],
    paymentReturnRuleset: [],
    paymentReturnurl: [],
    helpLink: [],
    intermediateScreen: [],
    aadhaarRequired: [],
    meesevaServiceName: [],
    pmtFeeAmtTotal: [],
    pmtFeeAmtOthers1: [],
    pmtFeeAmtOthers1Desc: [],
    pmtFeeAmtOthers2: [],
    pmtFeeAmtOthers2Desc: [],
    pmtFeeAmtOthers3: [],
    pmtFeeAmtOthers3Desc: [],
    pmtFeeAmtOthers4: [],
    pmtFeeAmtOthers4Desc: [],
    pmtFeeAmtOthers5: [],
    pmtFeeAmtOthers5Desc: [],
    meesevaServiceId: [],
    organizationCode: []
  });

  constructor(
    protected mdmServiceMasterService: MdmServiceMasterService,
    protected mdmMeesevaServiceMasterService: MdmMeesevaServiceMasterService,
    protected mdmOrganizationMasterService: MdmOrganizationMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmServiceMaster }) => {
      if (!mdmServiceMaster.id) {
        const today = moment().startOf('day');
        mdmServiceMaster.servicePeriodStartDate = today;
        mdmServiceMaster.servicePeriodEndDate = today;
        mdmServiceMaster.recordInsertTime = today;
        mdmServiceMaster.createTime = today;
        mdmServiceMaster.updateTime = today;
      }

      this.updateForm(mdmServiceMaster);

      this.mdmMeesevaServiceMasterService
        .query({ filter: 'meesevaserviceid-is-null' })
        .pipe(
          map((res: HttpResponse<IMdmMeesevaServiceMaster[]>) => {
            return res.body || [];
          })
        )
        .subscribe((resBody: IMdmMeesevaServiceMaster[]) => {
          if (!mdmServiceMaster.meesevaServiceId || !mdmServiceMaster.meesevaServiceId.id) {
            this.meesevaserviceids = resBody;
          } else {
            this.mdmMeesevaServiceMasterService
              .find(mdmServiceMaster.meesevaServiceId.id)
              .pipe(
                map((subRes: HttpResponse<IMdmMeesevaServiceMaster>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: IMdmMeesevaServiceMaster[]) => (this.meesevaserviceids = concatRes));
          }
        });

      this.mdmOrganizationMasterService
        .query({ filter: 'organizationcode-is-null' })
        .pipe(
          map((res: HttpResponse<IMdmOrganizationMaster[]>) => {
            return res.body || [];
          })
        )
        .subscribe((resBody: IMdmOrganizationMaster[]) => {
          if (!mdmServiceMaster.organizationCode || !mdmServiceMaster.organizationCode.id) {
            this.organizationcodes = resBody;
          } else {
            this.mdmOrganizationMasterService
              .find(mdmServiceMaster.organizationCode.id)
              .pipe(
                map((subRes: HttpResponse<IMdmOrganizationMaster>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: IMdmOrganizationMaster[]) => (this.organizationcodes = concatRes));
          }
        });
    });
  }

  updateForm(mdmServiceMaster: IMdmServiceMaster): void {
    this.editForm.patchValue({
      id: mdmServiceMaster.id,
      serviceCode: mdmServiceMaster.serviceCode,
      organizationName: mdmServiceMaster.organizationName,
      serviceShortName: mdmServiceMaster.serviceShortName,
      serviceName: mdmServiceMaster.serviceName,
      serviceDesc: mdmServiceMaster.serviceDesc,
      parentServiceCode: mdmServiceMaster.parentServiceCode,
      servicePeriodStartDate: mdmServiceMaster.servicePeriodStartDate
        ? mdmServiceMaster.servicePeriodStartDate.format(DATE_TIME_FORMAT)
        : null,
      servicePeriodEndDate: mdmServiceMaster.servicePeriodEndDate ? mdmServiceMaster.servicePeriodEndDate.format(DATE_TIME_FORMAT) : null,
      serviceCategory: mdmServiceMaster.serviceCategory,
      serviceLink: mdmServiceMaster.serviceLink,
      serviceClass: mdmServiceMaster.serviceClass,
      serviceIntegrationType: mdmServiceMaster.serviceIntegrationType,
      serviceType: mdmServiceMaster.serviceType,
      lookupRoleId: mdmServiceMaster.lookupRoleId,
      lookupRole: mdmServiceMaster.lookupRole,
      lookupSectorId: mdmServiceMaster.lookupSectorId,
      lookupSector: mdmServiceMaster.lookupSector,
      lookupLifeeventId: mdmServiceMaster.lookupLifeeventId,
      lookupLifeevent: mdmServiceMaster.lookupLifeevent,
      slaGoal: mdmServiceMaster.slaGoal,
      serviceActiveFlag: mdmServiceMaster.serviceActiveFlag,
      createdBy: mdmServiceMaster.createdBy,
      updatedBy: mdmServiceMaster.updatedBy,
      recordInsertTime: mdmServiceMaster.recordInsertTime ? mdmServiceMaster.recordInsertTime.format(DATE_TIME_FORMAT) : null,
      createTime: mdmServiceMaster.createTime ? mdmServiceMaster.createTime.format(DATE_TIME_FORMAT) : null,
      updateTime: mdmServiceMaster.updateTime ? mdmServiceMaster.updateTime.format(DATE_TIME_FORMAT) : null,
      sectionDisplayName: mdmServiceMaster.sectionDisplayName,
      sectionDisplayIcon: mdmServiceMaster.sectionDisplayIcon,
      rulesetName: mdmServiceMaster.rulesetName,
      servicePriority: mdmServiceMaster.servicePriority,
      serviceChannelAccess: mdmServiceMaster.serviceChannelAccess,
      serviceAccess: mdmServiceMaster.serviceAccess,
      assistedmodeekycReq: mdmServiceMaster.assistedmodeekycReq,
      assistedOthAdrReq: mdmServiceMaster.assistedOthAdrReq,
      slaDeadline: mdmServiceMaster.slaDeadline,
      paymentChannelId: mdmServiceMaster.paymentChannelId,
      paymentReturnClass: mdmServiceMaster.paymentReturnClass,
      paymentReturnRuleset: mdmServiceMaster.paymentReturnRuleset,
      paymentReturnurl: mdmServiceMaster.paymentReturnurl,
      helpLink: mdmServiceMaster.helpLink,
      intermediateScreen: mdmServiceMaster.intermediateScreen,
      aadhaarRequired: mdmServiceMaster.aadhaarRequired,
      meesevaServiceName: mdmServiceMaster.meesevaServiceName,
      pmtFeeAmtTotal: mdmServiceMaster.pmtFeeAmtTotal,
      pmtFeeAmtOthers1: mdmServiceMaster.pmtFeeAmtOthers1,
      pmtFeeAmtOthers1Desc: mdmServiceMaster.pmtFeeAmtOthers1Desc,
      pmtFeeAmtOthers2: mdmServiceMaster.pmtFeeAmtOthers2,
      pmtFeeAmtOthers2Desc: mdmServiceMaster.pmtFeeAmtOthers2Desc,
      pmtFeeAmtOthers3: mdmServiceMaster.pmtFeeAmtOthers3,
      pmtFeeAmtOthers3Desc: mdmServiceMaster.pmtFeeAmtOthers3Desc,
      pmtFeeAmtOthers4: mdmServiceMaster.pmtFeeAmtOthers4,
      pmtFeeAmtOthers4Desc: mdmServiceMaster.pmtFeeAmtOthers4Desc,
      pmtFeeAmtOthers5: mdmServiceMaster.pmtFeeAmtOthers5,
      pmtFeeAmtOthers5Desc: mdmServiceMaster.pmtFeeAmtOthers5Desc,
      meesevaServiceId: mdmServiceMaster.meesevaServiceId,
      organizationCode: mdmServiceMaster.organizationCode
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdmServiceMaster = this.createFromForm();
    if (mdmServiceMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.mdmServiceMasterService.update(mdmServiceMaster));
    } else {
      this.subscribeToSaveResponse(this.mdmServiceMasterService.create(mdmServiceMaster));
    }
  }

  private createFromForm(): IMdmServiceMaster {
    return {
      ...new MdmServiceMaster(),
      id: this.editForm.get(['id'])!.value,
      serviceCode: this.editForm.get(['serviceCode'])!.value,
      organizationName: this.editForm.get(['organizationName'])!.value,
      serviceShortName: this.editForm.get(['serviceShortName'])!.value,
      serviceName: this.editForm.get(['serviceName'])!.value,
      serviceDesc: this.editForm.get(['serviceDesc'])!.value,
      parentServiceCode: this.editForm.get(['parentServiceCode'])!.value,
      servicePeriodStartDate: this.editForm.get(['servicePeriodStartDate'])!.value
        ? moment(this.editForm.get(['servicePeriodStartDate'])!.value, DATE_TIME_FORMAT)
        : undefined,
      servicePeriodEndDate: this.editForm.get(['servicePeriodEndDate'])!.value
        ? moment(this.editForm.get(['servicePeriodEndDate'])!.value, DATE_TIME_FORMAT)
        : undefined,
      serviceCategory: this.editForm.get(['serviceCategory'])!.value,
      serviceLink: this.editForm.get(['serviceLink'])!.value,
      serviceClass: this.editForm.get(['serviceClass'])!.value,
      serviceIntegrationType: this.editForm.get(['serviceIntegrationType'])!.value,
      serviceType: this.editForm.get(['serviceType'])!.value,
      lookupRoleId: this.editForm.get(['lookupRoleId'])!.value,
      lookupRole: this.editForm.get(['lookupRole'])!.value,
      lookupSectorId: this.editForm.get(['lookupSectorId'])!.value,
      lookupSector: this.editForm.get(['lookupSector'])!.value,
      lookupLifeeventId: this.editForm.get(['lookupLifeeventId'])!.value,
      lookupLifeevent: this.editForm.get(['lookupLifeevent'])!.value,
      slaGoal: this.editForm.get(['slaGoal'])!.value,
      serviceActiveFlag: this.editForm.get(['serviceActiveFlag'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      updatedBy: this.editForm.get(['updatedBy'])!.value,
      recordInsertTime: this.editForm.get(['recordInsertTime'])!.value
        ? moment(this.editForm.get(['recordInsertTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      createTime: this.editForm.get(['createTime'])!.value ? moment(this.editForm.get(['createTime'])!.value, DATE_TIME_FORMAT) : undefined,
      updateTime: this.editForm.get(['updateTime'])!.value ? moment(this.editForm.get(['updateTime'])!.value, DATE_TIME_FORMAT) : undefined,
      sectionDisplayName: this.editForm.get(['sectionDisplayName'])!.value,
      sectionDisplayIcon: this.editForm.get(['sectionDisplayIcon'])!.value,
      rulesetName: this.editForm.get(['rulesetName'])!.value,
      servicePriority: this.editForm.get(['servicePriority'])!.value,
      serviceChannelAccess: this.editForm.get(['serviceChannelAccess'])!.value,
      serviceAccess: this.editForm.get(['serviceAccess'])!.value,
      assistedmodeekycReq: this.editForm.get(['assistedmodeekycReq'])!.value,
      assistedOthAdrReq: this.editForm.get(['assistedOthAdrReq'])!.value,
      slaDeadline: this.editForm.get(['slaDeadline'])!.value,
      paymentChannelId: this.editForm.get(['paymentChannelId'])!.value,
      paymentReturnClass: this.editForm.get(['paymentReturnClass'])!.value,
      paymentReturnRuleset: this.editForm.get(['paymentReturnRuleset'])!.value,
      paymentReturnurl: this.editForm.get(['paymentReturnurl'])!.value,
      helpLink: this.editForm.get(['helpLink'])!.value,
      intermediateScreen: this.editForm.get(['intermediateScreen'])!.value,
      aadhaarRequired: this.editForm.get(['aadhaarRequired'])!.value,
      meesevaServiceName: this.editForm.get(['meesevaServiceName'])!.value,
      pmtFeeAmtTotal: this.editForm.get(['pmtFeeAmtTotal'])!.value,
      pmtFeeAmtOthers1: this.editForm.get(['pmtFeeAmtOthers1'])!.value,
      pmtFeeAmtOthers1Desc: this.editForm.get(['pmtFeeAmtOthers1Desc'])!.value,
      pmtFeeAmtOthers2: this.editForm.get(['pmtFeeAmtOthers2'])!.value,
      pmtFeeAmtOthers2Desc: this.editForm.get(['pmtFeeAmtOthers2Desc'])!.value,
      pmtFeeAmtOthers3: this.editForm.get(['pmtFeeAmtOthers3'])!.value,
      pmtFeeAmtOthers3Desc: this.editForm.get(['pmtFeeAmtOthers3Desc'])!.value,
      pmtFeeAmtOthers4: this.editForm.get(['pmtFeeAmtOthers4'])!.value,
      pmtFeeAmtOthers4Desc: this.editForm.get(['pmtFeeAmtOthers4Desc'])!.value,
      pmtFeeAmtOthers5: this.editForm.get(['pmtFeeAmtOthers5'])!.value,
      pmtFeeAmtOthers5Desc: this.editForm.get(['pmtFeeAmtOthers5Desc'])!.value,
      meesevaServiceId: this.editForm.get(['meesevaServiceId'])!.value,
      organizationCode: this.editForm.get(['organizationCode'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdmServiceMaster>>): void {
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
