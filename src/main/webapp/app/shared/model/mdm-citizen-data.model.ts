import { Moment } from 'moment';
import { IMdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';

export interface IMdmCitizenData {
  id?: number;
  personId?: string;
  tempRefId?: number;
  name?: string;
  emailId?: string;
  mobileNumber?: number;
  dateOfBirth?: Moment;
  genderId?: number;
  gender?: string;
  houseNumberAdh?: string;
  streetAdh?: string;
  villageAdh?: string;
  districtNameAh?: string;
  subDistrictNameAdh?: string;
  postOfficeAdh?: string;
  stateNameAdh?: string;
  pinCodeAdh?: string;
  districtCodePss?: number;
  districtNamePss?: string;
  districtCode?: string;
  mandalCode?: string;
  villageCode?: string;
  districtName?: string;
  mandalName?: string;
  villageName?: string;
  houseHoldId?: string;
  relationshipWithHoh?: string;
  buildingNamePss?: string;
  houseNameWardNoDivPss?: string;
  areaWardColonyStreetPss?: string;
  villageTownPss?: string;
  pinCodePss?: string;
  religionId?: number;
  religion?: string;
  casteId?: number;
  caste?: string;
  subCasteId?: number;
  subCaste?: string;
  motherTongueId?: number;
  motherTongue?: string;
  householdOwnershipId?: number;
  householdOwnership?: string;
  educationId?: number;
  education?: string;
  occupationId?: number;
  occupation?: string;
  occupationCategoryId?: number;
  occupationCategory?: string;
  martialStatusId?: number;
  martialStatus?: string;
  physicalhandicappedTypeId?: number;
  physicalhandicappedStatus?: string;
  physicalhandicappedPercentage?: number;
  votersCardNo?: string;
  kissanCardAvailable?: string;
  annualIncome?: string;
  rationId?: string;
  createdBy?: string;
  updatedBy?: string;
  recordInsertTime?: Moment;
  createTime?: Moment;
  updateTime?: Moment;
  aadhaarVerified?: string;
  aadhaarVerifiedDate?: Moment;
  emailVerified?: string;
  phoneNoVerified?: string;
  citizenActiveStatus?: string;
  sourceOfRegistrationId?: number;
  sourceOfRegistration?: string;
  ssoId?: string;
  operatorId?: string;
  aadhaarRefId?: number;
  careOfAdh?: string;
  assistedModeOperatorId?: string;
  uidReferenceKeyAponline?: number;
  uidToken?: string;
  volunteerSecretariatEmailId?: string;
  volunteerSecretariatMobile?: number;
  volunteerSecretariatId?: string;
  personId?: IMdmEmployeeMaster;
}

export class MdmCitizenData implements IMdmCitizenData {
  constructor(
    public id?: number,
    public personId?: string,
    public tempRefId?: number,
    public name?: string,
    public emailId?: string,
    public mobileNumber?: number,
    public dateOfBirth?: Moment,
    public genderId?: number,
    public gender?: string,
    public houseNumberAdh?: string,
    public streetAdh?: string,
    public villageAdh?: string,
    public districtNameAh?: string,
    public subDistrictNameAdh?: string,
    public postOfficeAdh?: string,
    public stateNameAdh?: string,
    public pinCodeAdh?: string,
    public districtCodePss?: number,
    public districtNamePss?: string,
    public districtCode?: string,
    public mandalCode?: string,
    public villageCode?: string,
    public districtName?: string,
    public mandalName?: string,
    public villageName?: string,
    public houseHoldId?: string,
    public relationshipWithHoh?: string,
    public buildingNamePss?: string,
    public houseNameWardNoDivPss?: string,
    public areaWardColonyStreetPss?: string,
    public villageTownPss?: string,
    public pinCodePss?: string,
    public religionId?: number,
    public religion?: string,
    public casteId?: number,
    public caste?: string,
    public subCasteId?: number,
    public subCaste?: string,
    public motherTongueId?: number,
    public motherTongue?: string,
    public householdOwnershipId?: number,
    public householdOwnership?: string,
    public educationId?: number,
    public education?: string,
    public occupationId?: number,
    public occupation?: string,
    public occupationCategoryId?: number,
    public occupationCategory?: string,
    public martialStatusId?: number,
    public martialStatus?: string,
    public physicalhandicappedTypeId?: number,
    public physicalhandicappedStatus?: string,
    public physicalhandicappedPercentage?: number,
    public votersCardNo?: string,
    public kissanCardAvailable?: string,
    public annualIncome?: string,
    public rationId?: string,
    public createdBy?: string,
    public updatedBy?: string,
    public recordInsertTime?: Moment,
    public createTime?: Moment,
    public updateTime?: Moment,
    public aadhaarVerified?: string,
    public aadhaarVerifiedDate?: Moment,
    public emailVerified?: string,
    public phoneNoVerified?: string,
    public citizenActiveStatus?: string,
    public sourceOfRegistrationId?: number,
    public sourceOfRegistration?: string,
    public ssoId?: string,
    public operatorId?: string,
    public aadhaarRefId?: number,
    public careOfAdh?: string,
    public assistedModeOperatorId?: string,
    public uidReferenceKeyAponline?: number,
    public uidToken?: string,
    public volunteerSecretariatEmailId?: string,
    public volunteerSecretariatMobile?: number,
    public volunteerSecretariatId?: string,
    public personId?: IMdmEmployeeMaster
  ) {}
}
