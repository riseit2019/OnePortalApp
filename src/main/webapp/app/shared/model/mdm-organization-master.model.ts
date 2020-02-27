import { Moment } from 'moment';
import { IMdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';

export interface IMdmOrganizationMaster {
  id?: number;
  syspk?: number;
  organizationCode?: string;
  organizationShortName?: string;
  organizationName?: string;
  organizationType?: string;
  organizationDesc?: string;
  sectorCode?: string;
  parentOrgCode?: string;
  organizationActiveFlag?: boolean;
  createdBy?: string;
  updatedBy?: string;
  recordInsertTime?: Moment;
  createTime?: Moment;
  updateTime?: Moment;
  startDate?: Moment;
  endDate?: Moment;
  organizationTypeDesc?: string;
  jurisdictionType?: string;
  organizationCode?: IMdmEmployeeMaster;
}

export class MdmOrganizationMaster implements IMdmOrganizationMaster {
  constructor(
    public id?: number,
    public syspk?: number,
    public organizationCode?: string,
    public organizationShortName?: string,
    public organizationName?: string,
    public organizationType?: string,
    public organizationDesc?: string,
    public sectorCode?: string,
    public parentOrgCode?: string,
    public organizationActiveFlag?: boolean,
    public createdBy?: string,
    public updatedBy?: string,
    public recordInsertTime?: Moment,
    public createTime?: Moment,
    public updateTime?: Moment,
    public startDate?: Moment,
    public endDate?: Moment,
    public organizationTypeDesc?: string,
    public jurisdictionType?: string,
    public organizationCode?: IMdmEmployeeMaster
  ) {
    this.organizationActiveFlag = this.organizationActiveFlag || false;
  }
}
