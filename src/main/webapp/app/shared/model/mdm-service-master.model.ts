import { Moment } from 'moment';

export interface IMdmServiceMaster {
  id?: number;
  syspk?: number;
  serviceCode?: string;
  organizationName?: string;
  serviceShortName?: string;
  serviceName?: string;
  serviceDesc?: string;
  parentServiceCode?: string;
  servicePeriodStartDate?: Moment;
  servicePeriodEndDate?: Moment;
  serviceCategory?: string;
  serviceLink?: string;
  serviceClass?: string;
  serviceIntegrationType?: string;
  serviceType?: string;
  lookupRoleId?: number;
  lookupRole?: string;
  lookupSectorId?: number;
  lookupSector?: string;
  lookupLifeeventId?: number;
  lookupLifeevent?: string;
  slaGoal?: number;
  serviceActiveFlag?: number;
  createdBy?: string;
  updatedBy?: string;
  recordInsertTime?: Moment;
  createTime?: Moment;
  updateTime?: Moment;
  sectionDisplayName?: string;
  sectionDisplayIcon?: string;
  rulesetName?: string;
  servicePriority?: number;
  serviceChannelAccess?: string;
  serviceAccess?: string;
  assistedmodeekycReq?: string;
  assistedOthAdrReq?: string;
  slaDeadline?: number;
  paymentChannelId?: number;
  paymentReturnClass?: string;
  paymentReturnRuleset?: string;
  paymentReturnurl?: string;
  helpLink?: string;
  intermediateScreen?: string;
  aadhaarRequired?: string;
  meesevaServiceName?: string;
  pmtFeeAmtTotal?: number;
  pmtFeeAmtOthers1?: number;
  pmtFeeAmtOthers1Desc?: string;
  pmtFeeAmtOthers2?: number;
  pmtFeeAmtOthers2Desc?: string;
  pmtFeeAmtOthers3?: number;
  pmtFeeAmtOthers3Desc?: string;
  pmtFeeAmtOthers4?: number;
  pmtFeeAmtOthers4Desc?: string;
  pmtFeeAmtOthers5?: number;
  pmtFeeAmtOthers5Desc?: string;
}

export class MdmServiceMaster implements IMdmServiceMaster {
  constructor(
    public id?: number,
    public syspk?: number,
    public serviceCode?: string,
    public organizationName?: string,
    public serviceShortName?: string,
    public serviceName?: string,
    public serviceDesc?: string,
    public parentServiceCode?: string,
    public servicePeriodStartDate?: Moment,
    public servicePeriodEndDate?: Moment,
    public serviceCategory?: string,
    public serviceLink?: string,
    public serviceClass?: string,
    public serviceIntegrationType?: string,
    public serviceType?: string,
    public lookupRoleId?: number,
    public lookupRole?: string,
    public lookupSectorId?: number,
    public lookupSector?: string,
    public lookupLifeeventId?: number,
    public lookupLifeevent?: string,
    public slaGoal?: number,
    public serviceActiveFlag?: number,
    public createdBy?: string,
    public updatedBy?: string,
    public recordInsertTime?: Moment,
    public createTime?: Moment,
    public updateTime?: Moment,
    public sectionDisplayName?: string,
    public sectionDisplayIcon?: string,
    public rulesetName?: string,
    public servicePriority?: number,
    public serviceChannelAccess?: string,
    public serviceAccess?: string,
    public assistedmodeekycReq?: string,
    public assistedOthAdrReq?: string,
    public slaDeadline?: number,
    public paymentChannelId?: number,
    public paymentReturnClass?: string,
    public paymentReturnRuleset?: string,
    public paymentReturnurl?: string,
    public helpLink?: string,
    public intermediateScreen?: string,
    public aadhaarRequired?: string,
    public meesevaServiceName?: string,
    public pmtFeeAmtTotal?: number,
    public pmtFeeAmtOthers1?: number,
    public pmtFeeAmtOthers1Desc?: string,
    public pmtFeeAmtOthers2?: number,
    public pmtFeeAmtOthers2Desc?: string,
    public pmtFeeAmtOthers3?: number,
    public pmtFeeAmtOthers3Desc?: string,
    public pmtFeeAmtOthers4?: number,
    public pmtFeeAmtOthers4Desc?: string,
    public pmtFeeAmtOthers5?: number,
    public pmtFeeAmtOthers5Desc?: string
  ) {}
}
