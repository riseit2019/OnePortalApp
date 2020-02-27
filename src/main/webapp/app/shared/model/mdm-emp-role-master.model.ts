import { Moment } from 'moment';
import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { IMdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';
import { IMdmRoleMaster } from 'app/shared/model/mdm-role-master.model';

export interface IMdmEmpRoleMaster {
  id?: number;
  syspk?: number;
  employeeName?: string;
  roleName?: string;
  officeCode?: string;
  officeName?: string;
  personId?: string;
  organizationName?: string;
  stateCode?: string;
  stateName?: string;
  districtCode?: string;
  districtName?: string;
  mandalCode?: string;
  mandalName?: string;
  villageCode?: string;
  villageName?: string;
  circleName?: string;
  divisionName?: string;
  subDivisionName?: string;
  sectionName?: string;
  activeStatusFlag?: number;
  createdBy?: string;
  updatedBy?: string;
  recordInsertTime?: Moment;
  createTime?: Moment;
  updateTime?: Moment;
  volunteerSecretariatRole?: string;
  organizationCode?: IMdmOrganizationMaster;
  employeeCode?: IMdmEmployeeMaster;
  roleCode?: IMdmRoleMaster;
}

export class MdmEmpRoleMaster implements IMdmEmpRoleMaster {
  constructor(
    public id?: number,
    public syspk?: number,
    public employeeName?: string,
    public roleName?: string,
    public officeCode?: string,
    public officeName?: string,
    public personId?: string,
    public organizationName?: string,
    public stateCode?: string,
    public stateName?: string,
    public districtCode?: string,
    public districtName?: string,
    public mandalCode?: string,
    public mandalName?: string,
    public villageCode?: string,
    public villageName?: string,
    public circleName?: string,
    public divisionName?: string,
    public subDivisionName?: string,
    public sectionName?: string,
    public activeStatusFlag?: number,
    public createdBy?: string,
    public updatedBy?: string,
    public recordInsertTime?: Moment,
    public createTime?: Moment,
    public updateTime?: Moment,
    public volunteerSecretariatRole?: string,
    public organizationCode?: IMdmOrganizationMaster,
    public employeeCode?: IMdmEmployeeMaster,
    public roleCode?: IMdmRoleMaster
  ) {}
}
