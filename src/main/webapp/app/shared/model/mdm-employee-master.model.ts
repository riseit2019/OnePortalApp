import { Moment } from 'moment';
import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { IMdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';

export interface IMdmEmployeeMaster {
  id?: number;
  syspk?: number;
  employeeCode?: string;
  tempRefId?: number;
  employeeId?: number;
  employeeName?: string;
  entityName?: string;
  organizationName?: string;
  designationId?: string;
  designationName?: string;
  postName?: string;
  organizationUnitName?: string;
  parentOrganizationUnit?: string;
  mobileNumber?: number;
  emailId?: string;
  addressType?: string;
  address1?: string;
  address2?: string;
  cityName?: string;
  postOffice?: string;
  isPrimary?: string;
  isOuHead?: string;
  districtCode?: string;
  districtName?: string;
  mandalCode?: string;
  mandalName?: string;
  villageCode?: string;
  villageName?: string;
  panchayatCode?: string;
  panchayatName?: string;
  constituencyCode?: number;
  constituencyName?: string;
  createdBy?: string;
  updatedBy?: string;
  recordInsertTime?: Moment;
  createTime?: Moment;
  updateTime?: Moment;
  employeeType?: string;
  managerEmployeeCode?: string;
  employeeActiveStatus?: string;
  personId1?: string;
  aadhaarRefId?: number;
  volunteerSecretariatId?: string;
  volunteerSecretariatFlag?: string;
  aadhaarNumber?: number;
  organizationCode?: IMdmOrganizationMaster;
  personId?: IMdmCitizenData;
}

export class MdmEmployeeMaster implements IMdmEmployeeMaster {
  constructor(
    public id?: number,
    public syspk?: number,
    public employeeCode?: string,
    public tempRefId?: number,
    public employeeId?: number,
    public employeeName?: string,
    public entityName?: string,
    public organizationName?: string,
    public designationId?: string,
    public designationName?: string,
    public postName?: string,
    public organizationUnitName?: string,
    public parentOrganizationUnit?: string,
    public mobileNumber?: number,
    public emailId?: string,
    public addressType?: string,
    public address1?: string,
    public address2?: string,
    public cityName?: string,
    public postOffice?: string,
    public isPrimary?: string,
    public isOuHead?: string,
    public districtCode?: string,
    public districtName?: string,
    public mandalCode?: string,
    public mandalName?: string,
    public villageCode?: string,
    public villageName?: string,
    public panchayatCode?: string,
    public panchayatName?: string,
    public constituencyCode?: number,
    public constituencyName?: string,
    public createdBy?: string,
    public updatedBy?: string,
    public recordInsertTime?: Moment,
    public createTime?: Moment,
    public updateTime?: Moment,
    public employeeType?: string,
    public managerEmployeeCode?: string,
    public employeeActiveStatus?: string,
    public personId1?: string,
    public aadhaarRefId?: number,
    public volunteerSecretariatId?: string,
    public volunteerSecretariatFlag?: string,
    public aadhaarNumber?: number,
    public organizationCode?: IMdmOrganizationMaster,
    public personId?: IMdmCitizenData
  ) {}
}
