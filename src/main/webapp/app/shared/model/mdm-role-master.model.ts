import { Moment } from 'moment';

export interface IMdmRoleMaster {
  id?: number;
  roleCode?: string;
  roleName?: string;
  roleDesc?: string;
  organizationName?: string;
  serviceCode?: string;
  serviceName?: string;
  locationCode?: string;
  locationName?: string;
  roleStatus?: string;
  createdBy?: string;
  updatedBy?: string;
  recordInsertTime?: Moment;
  createTime?: Moment;
  updateTime?: Moment;
  roleLevelId?: number;
  roleLevelDesc?: string;
  volunteerSecretariat?: string;
}

export class MdmRoleMaster implements IMdmRoleMaster {
  constructor(
    public id?: number,
    public roleCode?: string,
    public roleName?: string,
    public roleDesc?: string,
    public organizationName?: string,
    public serviceCode?: string,
    public serviceName?: string,
    public locationCode?: string,
    public locationName?: string,
    public roleStatus?: string,
    public createdBy?: string,
    public updatedBy?: string,
    public recordInsertTime?: Moment,
    public createTime?: Moment,
    public updateTime?: Moment,
    public roleLevelId?: number,
    public roleLevelDesc?: string,
    public volunteerSecretariat?: string
  ) {}
}
