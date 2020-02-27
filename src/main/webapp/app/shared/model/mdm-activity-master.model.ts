import { Moment } from 'moment';
import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';

export interface IMdmActivityMaster {
  id?: number;
  activityCode?: string;
  activityName?: string;
  activityDesc?: string;
  activityLevelId?: number;
  activityLevelDesc?: string;
  organizationName?: string;
  activityStatus?: string;
  createdBy?: string;
  updatedBy?: string;
  recordInsertTime?: Moment;
  createTime?: Moment;
  updateTime?: Moment;
  organizationCode?: IMdmOrganizationMaster;
  organizationCode?: IMdmOrganizationMaster;
}

export class MdmActivityMaster implements IMdmActivityMaster {
  constructor(
    public id?: number,
    public activityCode?: string,
    public activityName?: string,
    public activityDesc?: string,
    public activityLevelId?: number,
    public activityLevelDesc?: string,
    public organizationName?: string,
    public activityStatus?: string,
    public createdBy?: string,
    public updatedBy?: string,
    public recordInsertTime?: Moment,
    public createTime?: Moment,
    public updateTime?: Moment,
    public organizationCode?: IMdmOrganizationMaster,
    public organizationCode?: IMdmOrganizationMaster
  ) {}
}
