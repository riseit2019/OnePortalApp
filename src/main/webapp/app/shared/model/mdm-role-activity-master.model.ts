import { Moment } from 'moment';
import { IMdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';
import { IMdmRoleMaster } from 'app/shared/model/mdm-role-master.model';

export interface IMdmRoleActivityMaster {
  id?: number;
  syspk?: number;
  activityName?: string;
  activityLevelId?: number;
  activityLevelDesc?: string;
  roleCode?: string;
  roleName?: string;
  roleLevelId?: number;
  roleLevelDesc?: string;
  roleActivityStatus?: string;
  createdBy?: string;
  updatedBy?: string;
  recordInsertTime?: Moment;
  createTime?: Moment;
  updateTime?: Moment;
  activityCode?: IMdmActivityMaster;
  roleCode?: IMdmRoleMaster;
}

export class MdmRoleActivityMaster implements IMdmRoleActivityMaster {
  constructor(
    public id?: number,
    public syspk?: number,
    public activityName?: string,
    public activityLevelId?: number,
    public activityLevelDesc?: string,
    public roleCode?: string,
    public roleName?: string,
    public roleLevelId?: number,
    public roleLevelDesc?: string,
    public roleActivityStatus?: string,
    public createdBy?: string,
    public updatedBy?: string,
    public recordInsertTime?: Moment,
    public createTime?: Moment,
    public updateTime?: Moment,
    public activityCode?: IMdmActivityMaster,
    public roleCode?: IMdmRoleMaster
  ) {}
}
