package com.epragati.oneportal.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A MdmServiceMaster.
 */
@Entity
@Table(name = "mdm_service_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdmServiceMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "syspk", nullable = false)
    private Long syspk;

    @NotNull
    @Column(name = "service_code", nullable = false)
    private String serviceCode;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "service_short_name")
    private String serviceShortName;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "service_desc")
    private String serviceDesc;

    @Column(name = "parent_service_code")
    private String parentServiceCode;

    @Column(name = "service_period_start_date")
    private Instant servicePeriodStartDate;

    @Column(name = "service_period_end_date")
    private Instant servicePeriodEndDate;

    @Column(name = "service_category")
    private String serviceCategory;

    @Column(name = "service_link")
    private String serviceLink;

    @Column(name = "service_class")
    private String serviceClass;

    @Column(name = "service_integration_type")
    private String serviceIntegrationType;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "lookup_role_id")
    private Integer lookupRoleId;

    @Column(name = "lookup_role")
    private String lookupRole;

    @Column(name = "lookup_sector_id")
    private Integer lookupSectorId;

    @Column(name = "lookup_sector")
    private String lookupSector;

    @Column(name = "lookup_lifeevent_id")
    private Integer lookupLifeeventId;

    @Column(name = "lookup_lifeevent")
    private String lookupLifeevent;

    @Column(name = "sla_goal")
    private Integer slaGoal;

    @NotNull
    @Column(name = "service_active_flag", nullable = false)
    private Integer serviceActiveFlag;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "record_insert_time")
    private Instant recordInsertTime;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "update_time")
    private Instant updateTime;

    @Column(name = "section_display_name")
    private String sectionDisplayName;

    @Column(name = "section_display_icon")
    private String sectionDisplayIcon;

    @Column(name = "ruleset_name")
    private String rulesetName;

    @Column(name = "service_priority")
    private Integer servicePriority;

    @Column(name = "service_channel_access")
    private String serviceChannelAccess;

    @Column(name = "service_access")
    private String serviceAccess;

    @Column(name = "assistedmodeekyc_req")
    private String assistedmodeekycReq;

    @Column(name = "assisted_oth_adr_req")
    private String assistedOthAdrReq;

    @Column(name = "sla_deadline")
    private Integer slaDeadline;

    @Column(name = "payment_channel_id")
    private Long paymentChannelId;

    @Column(name = "payment_return_class")
    private String paymentReturnClass;

    @Column(name = "payment_return_ruleset")
    private String paymentReturnRuleset;

    @Column(name = "payment_returnurl")
    private String paymentReturnurl;

    @Column(name = "help_link")
    private String helpLink;

    @Column(name = "intermediate_screen")
    private String intermediateScreen;

    @Column(name = "aadhaar_required")
    private String aadhaarRequired;

    @Column(name = "meeseva_service_name")
    private String meesevaServiceName;

    @Column(name = "pmt_fee_amt_total")
    private Float pmtFeeAmtTotal;

    @Column(name = "pmt_fee_amt_others_1")
    private Float pmtFeeAmtOthers1;

    @Column(name = "pmt_fee_amt_others_1_desc")
    private String pmtFeeAmtOthers1Desc;

    @Column(name = "pmt_fee_amt_others_2")
    private Float pmtFeeAmtOthers2;

    @Column(name = "pmt_fee_amt_others_2_desc")
    private String pmtFeeAmtOthers2Desc;

    @Column(name = "pmt_fee_amt_others_3")
    private Float pmtFeeAmtOthers3;

    @Column(name = "pmt_fee_amt_others_3_desc")
    private String pmtFeeAmtOthers3Desc;

    @Column(name = "pmt_fee_amt_others_4")
    private Float pmtFeeAmtOthers4;

    @Column(name = "pmt_fee_amt_others_4_desc")
    private String pmtFeeAmtOthers4Desc;

    @Column(name = "pmt_fee_amt_others_5")
    private Float pmtFeeAmtOthers5;

    @Column(name = "pmt_fee_amt_others_5_desc")
    private String pmtFeeAmtOthers5Desc;

    @OneToOne
    @JoinColumn(unique = true)
    private MdmMeesevaServiceMaster meesevaServiceId;

    @OneToOne
    @JoinColumn(unique = true)
    private MdmOrganizationMaster organizationCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSyspk() {
        return syspk;
    }

    public MdmServiceMaster syspk(Long syspk) {
        this.syspk = syspk;
        return this;
    }

    public void setSyspk(Long syspk) {
        this.syspk = syspk;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public MdmServiceMaster serviceCode(String serviceCode) {
        this.serviceCode = serviceCode;
        return this;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public MdmServiceMaster organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getServiceShortName() {
        return serviceShortName;
    }

    public MdmServiceMaster serviceShortName(String serviceShortName) {
        this.serviceShortName = serviceShortName;
        return this;
    }

    public void setServiceShortName(String serviceShortName) {
        this.serviceShortName = serviceShortName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public MdmServiceMaster serviceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public MdmServiceMaster serviceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
        return this;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getParentServiceCode() {
        return parentServiceCode;
    }

    public MdmServiceMaster parentServiceCode(String parentServiceCode) {
        this.parentServiceCode = parentServiceCode;
        return this;
    }

    public void setParentServiceCode(String parentServiceCode) {
        this.parentServiceCode = parentServiceCode;
    }

    public Instant getServicePeriodStartDate() {
        return servicePeriodStartDate;
    }

    public MdmServiceMaster servicePeriodStartDate(Instant servicePeriodStartDate) {
        this.servicePeriodStartDate = servicePeriodStartDate;
        return this;
    }

    public void setServicePeriodStartDate(Instant servicePeriodStartDate) {
        this.servicePeriodStartDate = servicePeriodStartDate;
    }

    public Instant getServicePeriodEndDate() {
        return servicePeriodEndDate;
    }

    public MdmServiceMaster servicePeriodEndDate(Instant servicePeriodEndDate) {
        this.servicePeriodEndDate = servicePeriodEndDate;
        return this;
    }

    public void setServicePeriodEndDate(Instant servicePeriodEndDate) {
        this.servicePeriodEndDate = servicePeriodEndDate;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public MdmServiceMaster serviceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
        return this;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceLink() {
        return serviceLink;
    }

    public MdmServiceMaster serviceLink(String serviceLink) {
        this.serviceLink = serviceLink;
        return this;
    }

    public void setServiceLink(String serviceLink) {
        this.serviceLink = serviceLink;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public MdmServiceMaster serviceClass(String serviceClass) {
        this.serviceClass = serviceClass;
        return this;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public String getServiceIntegrationType() {
        return serviceIntegrationType;
    }

    public MdmServiceMaster serviceIntegrationType(String serviceIntegrationType) {
        this.serviceIntegrationType = serviceIntegrationType;
        return this;
    }

    public void setServiceIntegrationType(String serviceIntegrationType) {
        this.serviceIntegrationType = serviceIntegrationType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public MdmServiceMaster serviceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getLookupRoleId() {
        return lookupRoleId;
    }

    public MdmServiceMaster lookupRoleId(Integer lookupRoleId) {
        this.lookupRoleId = lookupRoleId;
        return this;
    }

    public void setLookupRoleId(Integer lookupRoleId) {
        this.lookupRoleId = lookupRoleId;
    }

    public String getLookupRole() {
        return lookupRole;
    }

    public MdmServiceMaster lookupRole(String lookupRole) {
        this.lookupRole = lookupRole;
        return this;
    }

    public void setLookupRole(String lookupRole) {
        this.lookupRole = lookupRole;
    }

    public Integer getLookupSectorId() {
        return lookupSectorId;
    }

    public MdmServiceMaster lookupSectorId(Integer lookupSectorId) {
        this.lookupSectorId = lookupSectorId;
        return this;
    }

    public void setLookupSectorId(Integer lookupSectorId) {
        this.lookupSectorId = lookupSectorId;
    }

    public String getLookupSector() {
        return lookupSector;
    }

    public MdmServiceMaster lookupSector(String lookupSector) {
        this.lookupSector = lookupSector;
        return this;
    }

    public void setLookupSector(String lookupSector) {
        this.lookupSector = lookupSector;
    }

    public Integer getLookupLifeeventId() {
        return lookupLifeeventId;
    }

    public MdmServiceMaster lookupLifeeventId(Integer lookupLifeeventId) {
        this.lookupLifeeventId = lookupLifeeventId;
        return this;
    }

    public void setLookupLifeeventId(Integer lookupLifeeventId) {
        this.lookupLifeeventId = lookupLifeeventId;
    }

    public String getLookupLifeevent() {
        return lookupLifeevent;
    }

    public MdmServiceMaster lookupLifeevent(String lookupLifeevent) {
        this.lookupLifeevent = lookupLifeevent;
        return this;
    }

    public void setLookupLifeevent(String lookupLifeevent) {
        this.lookupLifeevent = lookupLifeevent;
    }

    public Integer getSlaGoal() {
        return slaGoal;
    }

    public MdmServiceMaster slaGoal(Integer slaGoal) {
        this.slaGoal = slaGoal;
        return this;
    }

    public void setSlaGoal(Integer slaGoal) {
        this.slaGoal = slaGoal;
    }

    public Integer getServiceActiveFlag() {
        return serviceActiveFlag;
    }

    public MdmServiceMaster serviceActiveFlag(Integer serviceActiveFlag) {
        this.serviceActiveFlag = serviceActiveFlag;
        return this;
    }

    public void setServiceActiveFlag(Integer serviceActiveFlag) {
        this.serviceActiveFlag = serviceActiveFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MdmServiceMaster createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MdmServiceMaster updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getRecordInsertTime() {
        return recordInsertTime;
    }

    public MdmServiceMaster recordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
        return this;
    }

    public void setRecordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public MdmServiceMaster createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public MdmServiceMaster updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public String getSectionDisplayName() {
        return sectionDisplayName;
    }

    public MdmServiceMaster sectionDisplayName(String sectionDisplayName) {
        this.sectionDisplayName = sectionDisplayName;
        return this;
    }

    public void setSectionDisplayName(String sectionDisplayName) {
        this.sectionDisplayName = sectionDisplayName;
    }

    public String getSectionDisplayIcon() {
        return sectionDisplayIcon;
    }

    public MdmServiceMaster sectionDisplayIcon(String sectionDisplayIcon) {
        this.sectionDisplayIcon = sectionDisplayIcon;
        return this;
    }

    public void setSectionDisplayIcon(String sectionDisplayIcon) {
        this.sectionDisplayIcon = sectionDisplayIcon;
    }

    public String getRulesetName() {
        return rulesetName;
    }

    public MdmServiceMaster rulesetName(String rulesetName) {
        this.rulesetName = rulesetName;
        return this;
    }

    public void setRulesetName(String rulesetName) {
        this.rulesetName = rulesetName;
    }

    public Integer getServicePriority() {
        return servicePriority;
    }

    public MdmServiceMaster servicePriority(Integer servicePriority) {
        this.servicePriority = servicePriority;
        return this;
    }

    public void setServicePriority(Integer servicePriority) {
        this.servicePriority = servicePriority;
    }

    public String getServiceChannelAccess() {
        return serviceChannelAccess;
    }

    public MdmServiceMaster serviceChannelAccess(String serviceChannelAccess) {
        this.serviceChannelAccess = serviceChannelAccess;
        return this;
    }

    public void setServiceChannelAccess(String serviceChannelAccess) {
        this.serviceChannelAccess = serviceChannelAccess;
    }

    public String getServiceAccess() {
        return serviceAccess;
    }

    public MdmServiceMaster serviceAccess(String serviceAccess) {
        this.serviceAccess = serviceAccess;
        return this;
    }

    public void setServiceAccess(String serviceAccess) {
        this.serviceAccess = serviceAccess;
    }

    public String getAssistedmodeekycReq() {
        return assistedmodeekycReq;
    }

    public MdmServiceMaster assistedmodeekycReq(String assistedmodeekycReq) {
        this.assistedmodeekycReq = assistedmodeekycReq;
        return this;
    }

    public void setAssistedmodeekycReq(String assistedmodeekycReq) {
        this.assistedmodeekycReq = assistedmodeekycReq;
    }

    public String getAssistedOthAdrReq() {
        return assistedOthAdrReq;
    }

    public MdmServiceMaster assistedOthAdrReq(String assistedOthAdrReq) {
        this.assistedOthAdrReq = assistedOthAdrReq;
        return this;
    }

    public void setAssistedOthAdrReq(String assistedOthAdrReq) {
        this.assistedOthAdrReq = assistedOthAdrReq;
    }

    public Integer getSlaDeadline() {
        return slaDeadline;
    }

    public MdmServiceMaster slaDeadline(Integer slaDeadline) {
        this.slaDeadline = slaDeadline;
        return this;
    }

    public void setSlaDeadline(Integer slaDeadline) {
        this.slaDeadline = slaDeadline;
    }

    public Long getPaymentChannelId() {
        return paymentChannelId;
    }

    public MdmServiceMaster paymentChannelId(Long paymentChannelId) {
        this.paymentChannelId = paymentChannelId;
        return this;
    }

    public void setPaymentChannelId(Long paymentChannelId) {
        this.paymentChannelId = paymentChannelId;
    }

    public String getPaymentReturnClass() {
        return paymentReturnClass;
    }

    public MdmServiceMaster paymentReturnClass(String paymentReturnClass) {
        this.paymentReturnClass = paymentReturnClass;
        return this;
    }

    public void setPaymentReturnClass(String paymentReturnClass) {
        this.paymentReturnClass = paymentReturnClass;
    }

    public String getPaymentReturnRuleset() {
        return paymentReturnRuleset;
    }

    public MdmServiceMaster paymentReturnRuleset(String paymentReturnRuleset) {
        this.paymentReturnRuleset = paymentReturnRuleset;
        return this;
    }

    public void setPaymentReturnRuleset(String paymentReturnRuleset) {
        this.paymentReturnRuleset = paymentReturnRuleset;
    }

    public String getPaymentReturnurl() {
        return paymentReturnurl;
    }

    public MdmServiceMaster paymentReturnurl(String paymentReturnurl) {
        this.paymentReturnurl = paymentReturnurl;
        return this;
    }

    public void setPaymentReturnurl(String paymentReturnurl) {
        this.paymentReturnurl = paymentReturnurl;
    }

    public String getHelpLink() {
        return helpLink;
    }

    public MdmServiceMaster helpLink(String helpLink) {
        this.helpLink = helpLink;
        return this;
    }

    public void setHelpLink(String helpLink) {
        this.helpLink = helpLink;
    }

    public String getIntermediateScreen() {
        return intermediateScreen;
    }

    public MdmServiceMaster intermediateScreen(String intermediateScreen) {
        this.intermediateScreen = intermediateScreen;
        return this;
    }

    public void setIntermediateScreen(String intermediateScreen) {
        this.intermediateScreen = intermediateScreen;
    }

    public String getAadhaarRequired() {
        return aadhaarRequired;
    }

    public MdmServiceMaster aadhaarRequired(String aadhaarRequired) {
        this.aadhaarRequired = aadhaarRequired;
        return this;
    }

    public void setAadhaarRequired(String aadhaarRequired) {
        this.aadhaarRequired = aadhaarRequired;
    }

    public String getMeesevaServiceName() {
        return meesevaServiceName;
    }

    public MdmServiceMaster meesevaServiceName(String meesevaServiceName) {
        this.meesevaServiceName = meesevaServiceName;
        return this;
    }

    public void setMeesevaServiceName(String meesevaServiceName) {
        this.meesevaServiceName = meesevaServiceName;
    }

    public Float getPmtFeeAmtTotal() {
        return pmtFeeAmtTotal;
    }

    public MdmServiceMaster pmtFeeAmtTotal(Float pmtFeeAmtTotal) {
        this.pmtFeeAmtTotal = pmtFeeAmtTotal;
        return this;
    }

    public void setPmtFeeAmtTotal(Float pmtFeeAmtTotal) {
        this.pmtFeeAmtTotal = pmtFeeAmtTotal;
    }

    public Float getPmtFeeAmtOthers1() {
        return pmtFeeAmtOthers1;
    }

    public MdmServiceMaster pmtFeeAmtOthers1(Float pmtFeeAmtOthers1) {
        this.pmtFeeAmtOthers1 = pmtFeeAmtOthers1;
        return this;
    }

    public void setPmtFeeAmtOthers1(Float pmtFeeAmtOthers1) {
        this.pmtFeeAmtOthers1 = pmtFeeAmtOthers1;
    }

    public String getPmtFeeAmtOthers1Desc() {
        return pmtFeeAmtOthers1Desc;
    }

    public MdmServiceMaster pmtFeeAmtOthers1Desc(String pmtFeeAmtOthers1Desc) {
        this.pmtFeeAmtOthers1Desc = pmtFeeAmtOthers1Desc;
        return this;
    }

    public void setPmtFeeAmtOthers1Desc(String pmtFeeAmtOthers1Desc) {
        this.pmtFeeAmtOthers1Desc = pmtFeeAmtOthers1Desc;
    }

    public Float getPmtFeeAmtOthers2() {
        return pmtFeeAmtOthers2;
    }

    public MdmServiceMaster pmtFeeAmtOthers2(Float pmtFeeAmtOthers2) {
        this.pmtFeeAmtOthers2 = pmtFeeAmtOthers2;
        return this;
    }

    public void setPmtFeeAmtOthers2(Float pmtFeeAmtOthers2) {
        this.pmtFeeAmtOthers2 = pmtFeeAmtOthers2;
    }

    public String getPmtFeeAmtOthers2Desc() {
        return pmtFeeAmtOthers2Desc;
    }

    public MdmServiceMaster pmtFeeAmtOthers2Desc(String pmtFeeAmtOthers2Desc) {
        this.pmtFeeAmtOthers2Desc = pmtFeeAmtOthers2Desc;
        return this;
    }

    public void setPmtFeeAmtOthers2Desc(String pmtFeeAmtOthers2Desc) {
        this.pmtFeeAmtOthers2Desc = pmtFeeAmtOthers2Desc;
    }

    public Float getPmtFeeAmtOthers3() {
        return pmtFeeAmtOthers3;
    }

    public MdmServiceMaster pmtFeeAmtOthers3(Float pmtFeeAmtOthers3) {
        this.pmtFeeAmtOthers3 = pmtFeeAmtOthers3;
        return this;
    }

    public void setPmtFeeAmtOthers3(Float pmtFeeAmtOthers3) {
        this.pmtFeeAmtOthers3 = pmtFeeAmtOthers3;
    }

    public String getPmtFeeAmtOthers3Desc() {
        return pmtFeeAmtOthers3Desc;
    }

    public MdmServiceMaster pmtFeeAmtOthers3Desc(String pmtFeeAmtOthers3Desc) {
        this.pmtFeeAmtOthers3Desc = pmtFeeAmtOthers3Desc;
        return this;
    }

    public void setPmtFeeAmtOthers3Desc(String pmtFeeAmtOthers3Desc) {
        this.pmtFeeAmtOthers3Desc = pmtFeeAmtOthers3Desc;
    }

    public Float getPmtFeeAmtOthers4() {
        return pmtFeeAmtOthers4;
    }

    public MdmServiceMaster pmtFeeAmtOthers4(Float pmtFeeAmtOthers4) {
        this.pmtFeeAmtOthers4 = pmtFeeAmtOthers4;
        return this;
    }

    public void setPmtFeeAmtOthers4(Float pmtFeeAmtOthers4) {
        this.pmtFeeAmtOthers4 = pmtFeeAmtOthers4;
    }

    public String getPmtFeeAmtOthers4Desc() {
        return pmtFeeAmtOthers4Desc;
    }

    public MdmServiceMaster pmtFeeAmtOthers4Desc(String pmtFeeAmtOthers4Desc) {
        this.pmtFeeAmtOthers4Desc = pmtFeeAmtOthers4Desc;
        return this;
    }

    public void setPmtFeeAmtOthers4Desc(String pmtFeeAmtOthers4Desc) {
        this.pmtFeeAmtOthers4Desc = pmtFeeAmtOthers4Desc;
    }

    public Float getPmtFeeAmtOthers5() {
        return pmtFeeAmtOthers5;
    }

    public MdmServiceMaster pmtFeeAmtOthers5(Float pmtFeeAmtOthers5) {
        this.pmtFeeAmtOthers5 = pmtFeeAmtOthers5;
        return this;
    }

    public void setPmtFeeAmtOthers5(Float pmtFeeAmtOthers5) {
        this.pmtFeeAmtOthers5 = pmtFeeAmtOthers5;
    }

    public String getPmtFeeAmtOthers5Desc() {
        return pmtFeeAmtOthers5Desc;
    }

    public MdmServiceMaster pmtFeeAmtOthers5Desc(String pmtFeeAmtOthers5Desc) {
        this.pmtFeeAmtOthers5Desc = pmtFeeAmtOthers5Desc;
        return this;
    }

    public void setPmtFeeAmtOthers5Desc(String pmtFeeAmtOthers5Desc) {
        this.pmtFeeAmtOthers5Desc = pmtFeeAmtOthers5Desc;
    }

    public MdmMeesevaServiceMaster getMeesevaServiceId() {
        return meesevaServiceId;
    }

    public MdmServiceMaster meesevaServiceId(MdmMeesevaServiceMaster mdmMeesevaServiceMaster) {
        this.meesevaServiceId = mdmMeesevaServiceMaster;
        return this;
    }

    public void setMeesevaServiceId(MdmMeesevaServiceMaster mdmMeesevaServiceMaster) {
        this.meesevaServiceId = mdmMeesevaServiceMaster;
    }

    public MdmOrganizationMaster getOrganizationCode() {
        return organizationCode;
    }

    public MdmServiceMaster organizationCode(MdmOrganizationMaster mdmOrganizationMaster) {
        this.organizationCode = mdmOrganizationMaster;
        return this;
    }

    public void setOrganizationCode(MdmOrganizationMaster mdmOrganizationMaster) {
        this.organizationCode = mdmOrganizationMaster;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MdmServiceMaster)) {
            return false;
        }
        return id != null && id.equals(((MdmServiceMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdmServiceMaster{" +
            "id=" + getId() +
            ", syspk=" + getSyspk() +
            ", serviceCode='" + getServiceCode() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", serviceShortName='" + getServiceShortName() + "'" +
            ", serviceName='" + getServiceName() + "'" +
            ", serviceDesc='" + getServiceDesc() + "'" +
            ", parentServiceCode='" + getParentServiceCode() + "'" +
            ", servicePeriodStartDate='" + getServicePeriodStartDate() + "'" +
            ", servicePeriodEndDate='" + getServicePeriodEndDate() + "'" +
            ", serviceCategory='" + getServiceCategory() + "'" +
            ", serviceLink='" + getServiceLink() + "'" +
            ", serviceClass='" + getServiceClass() + "'" +
            ", serviceIntegrationType='" + getServiceIntegrationType() + "'" +
            ", serviceType='" + getServiceType() + "'" +
            ", lookupRoleId=" + getLookupRoleId() +
            ", lookupRole='" + getLookupRole() + "'" +
            ", lookupSectorId=" + getLookupSectorId() +
            ", lookupSector='" + getLookupSector() + "'" +
            ", lookupLifeeventId=" + getLookupLifeeventId() +
            ", lookupLifeevent='" + getLookupLifeevent() + "'" +
            ", slaGoal=" + getSlaGoal() +
            ", serviceActiveFlag=" + getServiceActiveFlag() +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", recordInsertTime='" + getRecordInsertTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", sectionDisplayName='" + getSectionDisplayName() + "'" +
            ", sectionDisplayIcon='" + getSectionDisplayIcon() + "'" +
            ", rulesetName='" + getRulesetName() + "'" +
            ", servicePriority=" + getServicePriority() +
            ", serviceChannelAccess='" + getServiceChannelAccess() + "'" +
            ", serviceAccess='" + getServiceAccess() + "'" +
            ", assistedmodeekycReq='" + getAssistedmodeekycReq() + "'" +
            ", assistedOthAdrReq='" + getAssistedOthAdrReq() + "'" +
            ", slaDeadline=" + getSlaDeadline() +
            ", paymentChannelId=" + getPaymentChannelId() +
            ", paymentReturnClass='" + getPaymentReturnClass() + "'" +
            ", paymentReturnRuleset='" + getPaymentReturnRuleset() + "'" +
            ", paymentReturnurl='" + getPaymentReturnurl() + "'" +
            ", helpLink='" + getHelpLink() + "'" +
            ", intermediateScreen='" + getIntermediateScreen() + "'" +
            ", aadhaarRequired='" + getAadhaarRequired() + "'" +
            ", meesevaServiceName='" + getMeesevaServiceName() + "'" +
            ", pmtFeeAmtTotal=" + getPmtFeeAmtTotal() +
            ", pmtFeeAmtOthers1=" + getPmtFeeAmtOthers1() +
            ", pmtFeeAmtOthers1Desc='" + getPmtFeeAmtOthers1Desc() + "'" +
            ", pmtFeeAmtOthers2=" + getPmtFeeAmtOthers2() +
            ", pmtFeeAmtOthers2Desc='" + getPmtFeeAmtOthers2Desc() + "'" +
            ", pmtFeeAmtOthers3=" + getPmtFeeAmtOthers3() +
            ", pmtFeeAmtOthers3Desc='" + getPmtFeeAmtOthers3Desc() + "'" +
            ", pmtFeeAmtOthers4=" + getPmtFeeAmtOthers4() +
            ", pmtFeeAmtOthers4Desc='" + getPmtFeeAmtOthers4Desc() + "'" +
            ", pmtFeeAmtOthers5=" + getPmtFeeAmtOthers5() +
            ", pmtFeeAmtOthers5Desc='" + getPmtFeeAmtOthers5Desc() + "'" +
            "}";
    }
}
