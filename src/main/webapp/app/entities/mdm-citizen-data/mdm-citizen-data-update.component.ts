import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IMdmCitizenData, MdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';
import { MdmCitizenDataService } from './mdm-citizen-data.service';

@Component({
  selector: 'jhi-mdm-citizen-data-update',
  templateUrl: './mdm-citizen-data-update.component.html'
})
export class MdmCitizenDataUpdateComponent implements OnInit {
  isSaving = false;
  dateOfBirthDp: any;

  editForm = this.fb.group({
    id: [],
    syspk: [null, [Validators.required]],
    personId: [null, [Validators.required]],
    tempRefId: [],
    name: [null, [Validators.required]],
    emailId: [],
    mobileNumber: [],
    dateOfBirth: [],
    genderId: [],
    gender: [],
    houseNumberAdh: [],
    streetAdh: [],
    villageAdh: [],
    districtNameAh: [],
    subDistrictNameAdh: [],
    postOfficeAdh: [],
    stateNameAdh: [],
    pinCodeAdh: [],
    districtCodePss: [],
    districtNamePss: [],
    districtCode: [],
    mandalCode: [],
    villageCode: [],
    districtName: [],
    mandalName: [],
    villageName: [],
    houseHoldId: [],
    relationshipWithHoh: [],
    buildingNamePss: [],
    houseNameWardNoDivPss: [],
    areaWardColonyStreetPss: [],
    villageTownPss: [],
    pinCodePss: [],
    religionId: [],
    religion: [],
    casteId: [],
    caste: [],
    subCasteId: [],
    subCaste: [],
    motherTongueId: [],
    motherTongue: [],
    householdOwnershipId: [],
    householdOwnership: [],
    educationId: [],
    education: [],
    occupationId: [],
    occupation: [],
    occupationCategoryId: [],
    occupationCategory: [],
    martialStatusId: [],
    martialStatus: [],
    physicalhandicappedTypeId: [],
    physicalhandicappedStatus: [],
    physicalhandicappedPercentage: [],
    votersCardNo: [],
    kissanCardAvailable: [],
    annualIncome: [],
    rationId: [],
    createdBy: [],
    updatedBy: [],
    recordInsertTime: [],
    createTime: [],
    updateTime: [],
    aadhaarVerified: [],
    aadhaarVerifiedDate: [],
    emailVerified: [],
    phoneNoVerified: [],
    citizenActiveStatus: [],
    sourceOfRegistrationId: [],
    sourceOfRegistration: [],
    ssoId: [],
    operatorId: [],
    aadhaarRefId: [],
    careOfAdh: [],
    assistedModeOperatorId: [],
    uidReferenceKeyAponline: [],
    uidToken: [],
    volunteerSecretariatEmailId: [],
    volunteerSecretariatMobile: [],
    volunteerSecretariatId: []
  });

  constructor(protected mdmCitizenDataService: MdmCitizenDataService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmCitizenData }) => {
      if (!mdmCitizenData.id) {
        const today = moment().startOf('day');
        mdmCitizenData.recordInsertTime = today;
        mdmCitizenData.createTime = today;
        mdmCitizenData.updateTime = today;
        mdmCitizenData.aadhaarVerifiedDate = today;
      }

      this.updateForm(mdmCitizenData);
    });
  }

  updateForm(mdmCitizenData: IMdmCitizenData): void {
    this.editForm.patchValue({
      id: mdmCitizenData.id,
      syspk: mdmCitizenData.syspk,
      personId: mdmCitizenData.personId,
      tempRefId: mdmCitizenData.tempRefId,
      name: mdmCitizenData.name,
      emailId: mdmCitizenData.emailId,
      mobileNumber: mdmCitizenData.mobileNumber,
      dateOfBirth: mdmCitizenData.dateOfBirth,
      genderId: mdmCitizenData.genderId,
      gender: mdmCitizenData.gender,
      houseNumberAdh: mdmCitizenData.houseNumberAdh,
      streetAdh: mdmCitizenData.streetAdh,
      villageAdh: mdmCitizenData.villageAdh,
      districtNameAh: mdmCitizenData.districtNameAh,
      subDistrictNameAdh: mdmCitizenData.subDistrictNameAdh,
      postOfficeAdh: mdmCitizenData.postOfficeAdh,
      stateNameAdh: mdmCitizenData.stateNameAdh,
      pinCodeAdh: mdmCitizenData.pinCodeAdh,
      districtCodePss: mdmCitizenData.districtCodePss,
      districtNamePss: mdmCitizenData.districtNamePss,
      districtCode: mdmCitizenData.districtCode,
      mandalCode: mdmCitizenData.mandalCode,
      villageCode: mdmCitizenData.villageCode,
      districtName: mdmCitizenData.districtName,
      mandalName: mdmCitizenData.mandalName,
      villageName: mdmCitizenData.villageName,
      houseHoldId: mdmCitizenData.houseHoldId,
      relationshipWithHoh: mdmCitizenData.relationshipWithHoh,
      buildingNamePss: mdmCitizenData.buildingNamePss,
      houseNameWardNoDivPss: mdmCitizenData.houseNameWardNoDivPss,
      areaWardColonyStreetPss: mdmCitizenData.areaWardColonyStreetPss,
      villageTownPss: mdmCitizenData.villageTownPss,
      pinCodePss: mdmCitizenData.pinCodePss,
      religionId: mdmCitizenData.religionId,
      religion: mdmCitizenData.religion,
      casteId: mdmCitizenData.casteId,
      caste: mdmCitizenData.caste,
      subCasteId: mdmCitizenData.subCasteId,
      subCaste: mdmCitizenData.subCaste,
      motherTongueId: mdmCitizenData.motherTongueId,
      motherTongue: mdmCitizenData.motherTongue,
      householdOwnershipId: mdmCitizenData.householdOwnershipId,
      householdOwnership: mdmCitizenData.householdOwnership,
      educationId: mdmCitizenData.educationId,
      education: mdmCitizenData.education,
      occupationId: mdmCitizenData.occupationId,
      occupation: mdmCitizenData.occupation,
      occupationCategoryId: mdmCitizenData.occupationCategoryId,
      occupationCategory: mdmCitizenData.occupationCategory,
      martialStatusId: mdmCitizenData.martialStatusId,
      martialStatus: mdmCitizenData.martialStatus,
      physicalhandicappedTypeId: mdmCitizenData.physicalhandicappedTypeId,
      physicalhandicappedStatus: mdmCitizenData.physicalhandicappedStatus,
      physicalhandicappedPercentage: mdmCitizenData.physicalhandicappedPercentage,
      votersCardNo: mdmCitizenData.votersCardNo,
      kissanCardAvailable: mdmCitizenData.kissanCardAvailable,
      annualIncome: mdmCitizenData.annualIncome,
      rationId: mdmCitizenData.rationId,
      createdBy: mdmCitizenData.createdBy,
      updatedBy: mdmCitizenData.updatedBy,
      recordInsertTime: mdmCitizenData.recordInsertTime ? mdmCitizenData.recordInsertTime.format(DATE_TIME_FORMAT) : null,
      createTime: mdmCitizenData.createTime ? mdmCitizenData.createTime.format(DATE_TIME_FORMAT) : null,
      updateTime: mdmCitizenData.updateTime ? mdmCitizenData.updateTime.format(DATE_TIME_FORMAT) : null,
      aadhaarVerified: mdmCitizenData.aadhaarVerified,
      aadhaarVerifiedDate: mdmCitizenData.aadhaarVerifiedDate ? mdmCitizenData.aadhaarVerifiedDate.format(DATE_TIME_FORMAT) : null,
      emailVerified: mdmCitizenData.emailVerified,
      phoneNoVerified: mdmCitizenData.phoneNoVerified,
      citizenActiveStatus: mdmCitizenData.citizenActiveStatus,
      sourceOfRegistrationId: mdmCitizenData.sourceOfRegistrationId,
      sourceOfRegistration: mdmCitizenData.sourceOfRegistration,
      ssoId: mdmCitizenData.ssoId,
      operatorId: mdmCitizenData.operatorId,
      aadhaarRefId: mdmCitizenData.aadhaarRefId,
      careOfAdh: mdmCitizenData.careOfAdh,
      assistedModeOperatorId: mdmCitizenData.assistedModeOperatorId,
      uidReferenceKeyAponline: mdmCitizenData.uidReferenceKeyAponline,
      uidToken: mdmCitizenData.uidToken,
      volunteerSecretariatEmailId: mdmCitizenData.volunteerSecretariatEmailId,
      volunteerSecretariatMobile: mdmCitizenData.volunteerSecretariatMobile,
      volunteerSecretariatId: mdmCitizenData.volunteerSecretariatId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdmCitizenData = this.createFromForm();
    if (mdmCitizenData.id !== undefined) {
      this.subscribeToSaveResponse(this.mdmCitizenDataService.update(mdmCitizenData));
    } else {
      this.subscribeToSaveResponse(this.mdmCitizenDataService.create(mdmCitizenData));
    }
  }

  private createFromForm(): IMdmCitizenData {
    return {
      ...new MdmCitizenData(),
      id: this.editForm.get(['id'])!.value,
      syspk: this.editForm.get(['syspk'])!.value,
      personId: this.editForm.get(['personId'])!.value,
      tempRefId: this.editForm.get(['tempRefId'])!.value,
      name: this.editForm.get(['name'])!.value,
      emailId: this.editForm.get(['emailId'])!.value,
      mobileNumber: this.editForm.get(['mobileNumber'])!.value,
      dateOfBirth: this.editForm.get(['dateOfBirth'])!.value,
      genderId: this.editForm.get(['genderId'])!.value,
      gender: this.editForm.get(['gender'])!.value,
      houseNumberAdh: this.editForm.get(['houseNumberAdh'])!.value,
      streetAdh: this.editForm.get(['streetAdh'])!.value,
      villageAdh: this.editForm.get(['villageAdh'])!.value,
      districtNameAh: this.editForm.get(['districtNameAh'])!.value,
      subDistrictNameAdh: this.editForm.get(['subDistrictNameAdh'])!.value,
      postOfficeAdh: this.editForm.get(['postOfficeAdh'])!.value,
      stateNameAdh: this.editForm.get(['stateNameAdh'])!.value,
      pinCodeAdh: this.editForm.get(['pinCodeAdh'])!.value,
      districtCodePss: this.editForm.get(['districtCodePss'])!.value,
      districtNamePss: this.editForm.get(['districtNamePss'])!.value,
      districtCode: this.editForm.get(['districtCode'])!.value,
      mandalCode: this.editForm.get(['mandalCode'])!.value,
      villageCode: this.editForm.get(['villageCode'])!.value,
      districtName: this.editForm.get(['districtName'])!.value,
      mandalName: this.editForm.get(['mandalName'])!.value,
      villageName: this.editForm.get(['villageName'])!.value,
      houseHoldId: this.editForm.get(['houseHoldId'])!.value,
      relationshipWithHoh: this.editForm.get(['relationshipWithHoh'])!.value,
      buildingNamePss: this.editForm.get(['buildingNamePss'])!.value,
      houseNameWardNoDivPss: this.editForm.get(['houseNameWardNoDivPss'])!.value,
      areaWardColonyStreetPss: this.editForm.get(['areaWardColonyStreetPss'])!.value,
      villageTownPss: this.editForm.get(['villageTownPss'])!.value,
      pinCodePss: this.editForm.get(['pinCodePss'])!.value,
      religionId: this.editForm.get(['religionId'])!.value,
      religion: this.editForm.get(['religion'])!.value,
      casteId: this.editForm.get(['casteId'])!.value,
      caste: this.editForm.get(['caste'])!.value,
      subCasteId: this.editForm.get(['subCasteId'])!.value,
      subCaste: this.editForm.get(['subCaste'])!.value,
      motherTongueId: this.editForm.get(['motherTongueId'])!.value,
      motherTongue: this.editForm.get(['motherTongue'])!.value,
      householdOwnershipId: this.editForm.get(['householdOwnershipId'])!.value,
      householdOwnership: this.editForm.get(['householdOwnership'])!.value,
      educationId: this.editForm.get(['educationId'])!.value,
      education: this.editForm.get(['education'])!.value,
      occupationId: this.editForm.get(['occupationId'])!.value,
      occupation: this.editForm.get(['occupation'])!.value,
      occupationCategoryId: this.editForm.get(['occupationCategoryId'])!.value,
      occupationCategory: this.editForm.get(['occupationCategory'])!.value,
      martialStatusId: this.editForm.get(['martialStatusId'])!.value,
      martialStatus: this.editForm.get(['martialStatus'])!.value,
      physicalhandicappedTypeId: this.editForm.get(['physicalhandicappedTypeId'])!.value,
      physicalhandicappedStatus: this.editForm.get(['physicalhandicappedStatus'])!.value,
      physicalhandicappedPercentage: this.editForm.get(['physicalhandicappedPercentage'])!.value,
      votersCardNo: this.editForm.get(['votersCardNo'])!.value,
      kissanCardAvailable: this.editForm.get(['kissanCardAvailable'])!.value,
      annualIncome: this.editForm.get(['annualIncome'])!.value,
      rationId: this.editForm.get(['rationId'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      updatedBy: this.editForm.get(['updatedBy'])!.value,
      recordInsertTime: this.editForm.get(['recordInsertTime'])!.value
        ? moment(this.editForm.get(['recordInsertTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      createTime: this.editForm.get(['createTime'])!.value ? moment(this.editForm.get(['createTime'])!.value, DATE_TIME_FORMAT) : undefined,
      updateTime: this.editForm.get(['updateTime'])!.value ? moment(this.editForm.get(['updateTime'])!.value, DATE_TIME_FORMAT) : undefined,
      aadhaarVerified: this.editForm.get(['aadhaarVerified'])!.value,
      aadhaarVerifiedDate: this.editForm.get(['aadhaarVerifiedDate'])!.value
        ? moment(this.editForm.get(['aadhaarVerifiedDate'])!.value, DATE_TIME_FORMAT)
        : undefined,
      emailVerified: this.editForm.get(['emailVerified'])!.value,
      phoneNoVerified: this.editForm.get(['phoneNoVerified'])!.value,
      citizenActiveStatus: this.editForm.get(['citizenActiveStatus'])!.value,
      sourceOfRegistrationId: this.editForm.get(['sourceOfRegistrationId'])!.value,
      sourceOfRegistration: this.editForm.get(['sourceOfRegistration'])!.value,
      ssoId: this.editForm.get(['ssoId'])!.value,
      operatorId: this.editForm.get(['operatorId'])!.value,
      aadhaarRefId: this.editForm.get(['aadhaarRefId'])!.value,
      careOfAdh: this.editForm.get(['careOfAdh'])!.value,
      assistedModeOperatorId: this.editForm.get(['assistedModeOperatorId'])!.value,
      uidReferenceKeyAponline: this.editForm.get(['uidReferenceKeyAponline'])!.value,
      uidToken: this.editForm.get(['uidToken'])!.value,
      volunteerSecretariatEmailId: this.editForm.get(['volunteerSecretariatEmailId'])!.value,
      volunteerSecretariatMobile: this.editForm.get(['volunteerSecretariatMobile'])!.value,
      volunteerSecretariatId: this.editForm.get(['volunteerSecretariatId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdmCitizenData>>): void {
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
