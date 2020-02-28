import { Moment } from 'moment';
import { IMdmServiceMaster } from 'app/shared/model/mdm-service-master.model';

export interface IMdmMeesevaServiceMaster {
  id?: number;
  syspk?: number;
  meesevaServiceId?: number;
  meesevaServiceName?: string;
  isCharged?: string;
  organizationEntityTypeCode?: string;
  applicationTable?: string;
  applicationObject?: string;
  customerDefaultFlag?: string;
  channelDefaultFlag?: string;
  serviceUrl?: string;
  backOfficeUrl?: string;
  packageId?: number;
  meesevaServiceActiveFlag?: string;
  meesevaServiceGroupId?: number;
  meesevaServiceSubGroupId?: number;
  meesevaServiceTypeId?: number;
  meesevaServiceSubTypeId?: number;
  departmentCode?: string;
  efmsDepartmentCode?: string;
  isOnline?: string;
  agencyType?: number;
  launchDate?: Moment;
  isMobile?: string;
  innerSubId?: number;
  digilockerEnabled?: string;
  isRegular?: string;
  isSeasonal?: string;
  citizenPortalLaunchDate?: Moment;
  createdBy?: string;
  updatedBy?: string;
  recordInsertTime?: Moment;
  createTime?: Moment;
  updateTime?: Moment;
  meesevaServiceId?: IMdmServiceMaster;
}

export class MdmMeesevaServiceMaster implements IMdmMeesevaServiceMaster {
  constructor(
    public id?: number,
    public syspk?: number,
    public meesevaServiceId?: number,
    public meesevaServiceName?: string,
    public isCharged?: string,
    public organizationEntityTypeCode?: string,
    public applicationTable?: string,
    public applicationObject?: string,
    public customerDefaultFlag?: string,
    public channelDefaultFlag?: string,
    public serviceUrl?: string,
    public backOfficeUrl?: string,
    public packageId?: number,
    public meesevaServiceActiveFlag?: string,
    public meesevaServiceGroupId?: number,
    public meesevaServiceSubGroupId?: number,
    public meesevaServiceTypeId?: number,
    public meesevaServiceSubTypeId?: number,
    public departmentCode?: string,
    public efmsDepartmentCode?: string,
    public isOnline?: string,
    public agencyType?: number,
    public launchDate?: Moment,
    public isMobile?: string,
    public innerSubId?: number,
    public digilockerEnabled?: string,
    public isRegular?: string,
    public isSeasonal?: string,
    public citizenPortalLaunchDate?: Moment,
    public createdBy?: string,
    public updatedBy?: string,
    public recordInsertTime?: Moment,
    public createTime?: Moment,
    public updateTime?: Moment,
    public meesevaServiceId?: IMdmServiceMaster
  ) {}
}
