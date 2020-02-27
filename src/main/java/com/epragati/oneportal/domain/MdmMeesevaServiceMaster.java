package com.epragati.oneportal.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A MdmMeesevaServiceMaster.
 */
@Entity
@Table(name = "mdm_meeseva_service_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdmMeesevaServiceMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "meeseva_service_id", nullable = false)
    private Integer meesevaServiceId;

    @NotNull
    @Column(name = "meeseva_service_name", nullable = false)
    private String meesevaServiceName;

    @Column(name = "is_charged")
    private String isCharged;

    @Column(name = "organization_entity_type_code")
    private String organizationEntityTypeCode;

    @Column(name = "application_table")
    private String applicationTable;

    @Column(name = "application_object")
    private String applicationObject;

    @Column(name = "customer_default_flag")
    private String customerDefaultFlag;

    @Column(name = "channel_default_flag")
    private String channelDefaultFlag;

    @Column(name = "service_url")
    private String serviceUrl;

    @Column(name = "back_office_url")
    private String backOfficeUrl;

    @Column(name = "package_id")
    private Integer packageId;

    @Column(name = "meeseva_service_active_flag")
    private String meesevaServiceActiveFlag;

    @Column(name = "meeseva_service_group_id")
    private Integer meesevaServiceGroupId;

    @Column(name = "meeseva_service_sub_group_id")
    private Integer meesevaServiceSubGroupId;

    @Column(name = "meeseva_service_type_id")
    private Integer meesevaServiceTypeId;

    @Column(name = "meeseva_service_sub_type_id")
    private Integer meesevaServiceSubTypeId;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "efms_department_code")
    private String efmsDepartmentCode;

    @Column(name = "is_online")
    private String isOnline;

    @Column(name = "agency_type")
    private Integer agencyType;

    @Column(name = "launch_date")
    private Instant launchDate;

    @Column(name = "is_mobile")
    private String isMobile;

    @Column(name = "inner_sub_id")
    private Integer innerSubId;

    @Column(name = "digilocker_enabled")
    private String digilockerEnabled;

    @Column(name = "is_regular")
    private String isRegular;

    @Column(name = "is_seasonal")
    private String isSeasonal;

    @Column(name = "citizen_portal_launch_date")
    private Instant citizenPortalLaunchDate;

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

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMeesevaServiceId() {
        return meesevaServiceId;
    }

    public MdmMeesevaServiceMaster meesevaServiceId(Integer meesevaServiceId) {
        this.meesevaServiceId = meesevaServiceId;
        return this;
    }

    public void setMeesevaServiceId(Integer meesevaServiceId) {
        this.meesevaServiceId = meesevaServiceId;
    }

    public String getMeesevaServiceName() {
        return meesevaServiceName;
    }

    public MdmMeesevaServiceMaster meesevaServiceName(String meesevaServiceName) {
        this.meesevaServiceName = meesevaServiceName;
        return this;
    }

    public void setMeesevaServiceName(String meesevaServiceName) {
        this.meesevaServiceName = meesevaServiceName;
    }

    public String getIsCharged() {
        return isCharged;
    }

    public MdmMeesevaServiceMaster isCharged(String isCharged) {
        this.isCharged = isCharged;
        return this;
    }

    public void setIsCharged(String isCharged) {
        this.isCharged = isCharged;
    }

    public String getOrganizationEntityTypeCode() {
        return organizationEntityTypeCode;
    }

    public MdmMeesevaServiceMaster organizationEntityTypeCode(String organizationEntityTypeCode) {
        this.organizationEntityTypeCode = organizationEntityTypeCode;
        return this;
    }

    public void setOrganizationEntityTypeCode(String organizationEntityTypeCode) {
        this.organizationEntityTypeCode = organizationEntityTypeCode;
    }

    public String getApplicationTable() {
        return applicationTable;
    }

    public MdmMeesevaServiceMaster applicationTable(String applicationTable) {
        this.applicationTable = applicationTable;
        return this;
    }

    public void setApplicationTable(String applicationTable) {
        this.applicationTable = applicationTable;
    }

    public String getApplicationObject() {
        return applicationObject;
    }

    public MdmMeesevaServiceMaster applicationObject(String applicationObject) {
        this.applicationObject = applicationObject;
        return this;
    }

    public void setApplicationObject(String applicationObject) {
        this.applicationObject = applicationObject;
    }

    public String getCustomerDefaultFlag() {
        return customerDefaultFlag;
    }

    public MdmMeesevaServiceMaster customerDefaultFlag(String customerDefaultFlag) {
        this.customerDefaultFlag = customerDefaultFlag;
        return this;
    }

    public void setCustomerDefaultFlag(String customerDefaultFlag) {
        this.customerDefaultFlag = customerDefaultFlag;
    }

    public String getChannelDefaultFlag() {
        return channelDefaultFlag;
    }

    public MdmMeesevaServiceMaster channelDefaultFlag(String channelDefaultFlag) {
        this.channelDefaultFlag = channelDefaultFlag;
        return this;
    }

    public void setChannelDefaultFlag(String channelDefaultFlag) {
        this.channelDefaultFlag = channelDefaultFlag;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public MdmMeesevaServiceMaster serviceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
        return this;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getBackOfficeUrl() {
        return backOfficeUrl;
    }

    public MdmMeesevaServiceMaster backOfficeUrl(String backOfficeUrl) {
        this.backOfficeUrl = backOfficeUrl;
        return this;
    }

    public void setBackOfficeUrl(String backOfficeUrl) {
        this.backOfficeUrl = backOfficeUrl;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public MdmMeesevaServiceMaster packageId(Integer packageId) {
        this.packageId = packageId;
        return this;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getMeesevaServiceActiveFlag() {
        return meesevaServiceActiveFlag;
    }

    public MdmMeesevaServiceMaster meesevaServiceActiveFlag(String meesevaServiceActiveFlag) {
        this.meesevaServiceActiveFlag = meesevaServiceActiveFlag;
        return this;
    }

    public void setMeesevaServiceActiveFlag(String meesevaServiceActiveFlag) {
        this.meesevaServiceActiveFlag = meesevaServiceActiveFlag;
    }

    public Integer getMeesevaServiceGroupId() {
        return meesevaServiceGroupId;
    }

    public MdmMeesevaServiceMaster meesevaServiceGroupId(Integer meesevaServiceGroupId) {
        this.meesevaServiceGroupId = meesevaServiceGroupId;
        return this;
    }

    public void setMeesevaServiceGroupId(Integer meesevaServiceGroupId) {
        this.meesevaServiceGroupId = meesevaServiceGroupId;
    }

    public Integer getMeesevaServiceSubGroupId() {
        return meesevaServiceSubGroupId;
    }

    public MdmMeesevaServiceMaster meesevaServiceSubGroupId(Integer meesevaServiceSubGroupId) {
        this.meesevaServiceSubGroupId = meesevaServiceSubGroupId;
        return this;
    }

    public void setMeesevaServiceSubGroupId(Integer meesevaServiceSubGroupId) {
        this.meesevaServiceSubGroupId = meesevaServiceSubGroupId;
    }

    public Integer getMeesevaServiceTypeId() {
        return meesevaServiceTypeId;
    }

    public MdmMeesevaServiceMaster meesevaServiceTypeId(Integer meesevaServiceTypeId) {
        this.meesevaServiceTypeId = meesevaServiceTypeId;
        return this;
    }

    public void setMeesevaServiceTypeId(Integer meesevaServiceTypeId) {
        this.meesevaServiceTypeId = meesevaServiceTypeId;
    }

    public Integer getMeesevaServiceSubTypeId() {
        return meesevaServiceSubTypeId;
    }

    public MdmMeesevaServiceMaster meesevaServiceSubTypeId(Integer meesevaServiceSubTypeId) {
        this.meesevaServiceSubTypeId = meesevaServiceSubTypeId;
        return this;
    }

    public void setMeesevaServiceSubTypeId(Integer meesevaServiceSubTypeId) {
        this.meesevaServiceSubTypeId = meesevaServiceSubTypeId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public MdmMeesevaServiceMaster departmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
        return this;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getEfmsDepartmentCode() {
        return efmsDepartmentCode;
    }

    public MdmMeesevaServiceMaster efmsDepartmentCode(String efmsDepartmentCode) {
        this.efmsDepartmentCode = efmsDepartmentCode;
        return this;
    }

    public void setEfmsDepartmentCode(String efmsDepartmentCode) {
        this.efmsDepartmentCode = efmsDepartmentCode;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public MdmMeesevaServiceMaster isOnline(String isOnline) {
        this.isOnline = isOnline;
        return this;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getAgencyType() {
        return agencyType;
    }

    public MdmMeesevaServiceMaster agencyType(Integer agencyType) {
        this.agencyType = agencyType;
        return this;
    }

    public void setAgencyType(Integer agencyType) {
        this.agencyType = agencyType;
    }

    public Instant getLaunchDate() {
        return launchDate;
    }

    public MdmMeesevaServiceMaster launchDate(Instant launchDate) {
        this.launchDate = launchDate;
        return this;
    }

    public void setLaunchDate(Instant launchDate) {
        this.launchDate = launchDate;
    }

    public String getIsMobile() {
        return isMobile;
    }

    public MdmMeesevaServiceMaster isMobile(String isMobile) {
        this.isMobile = isMobile;
        return this;
    }

    public void setIsMobile(String isMobile) {
        this.isMobile = isMobile;
    }

    public Integer getInnerSubId() {
        return innerSubId;
    }

    public MdmMeesevaServiceMaster innerSubId(Integer innerSubId) {
        this.innerSubId = innerSubId;
        return this;
    }

    public void setInnerSubId(Integer innerSubId) {
        this.innerSubId = innerSubId;
    }

    public String getDigilockerEnabled() {
        return digilockerEnabled;
    }

    public MdmMeesevaServiceMaster digilockerEnabled(String digilockerEnabled) {
        this.digilockerEnabled = digilockerEnabled;
        return this;
    }

    public void setDigilockerEnabled(String digilockerEnabled) {
        this.digilockerEnabled = digilockerEnabled;
    }

    public String getIsRegular() {
        return isRegular;
    }

    public MdmMeesevaServiceMaster isRegular(String isRegular) {
        this.isRegular = isRegular;
        return this;
    }

    public void setIsRegular(String isRegular) {
        this.isRegular = isRegular;
    }

    public String getIsSeasonal() {
        return isSeasonal;
    }

    public MdmMeesevaServiceMaster isSeasonal(String isSeasonal) {
        this.isSeasonal = isSeasonal;
        return this;
    }

    public void setIsSeasonal(String isSeasonal) {
        this.isSeasonal = isSeasonal;
    }

    public Instant getCitizenPortalLaunchDate() {
        return citizenPortalLaunchDate;
    }

    public MdmMeesevaServiceMaster citizenPortalLaunchDate(Instant citizenPortalLaunchDate) {
        this.citizenPortalLaunchDate = citizenPortalLaunchDate;
        return this;
    }

    public void setCitizenPortalLaunchDate(Instant citizenPortalLaunchDate) {
        this.citizenPortalLaunchDate = citizenPortalLaunchDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MdmMeesevaServiceMaster createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MdmMeesevaServiceMaster updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getRecordInsertTime() {
        return recordInsertTime;
    }

    public MdmMeesevaServiceMaster recordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
        return this;
    }

    public void setRecordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public MdmMeesevaServiceMaster createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public MdmMeesevaServiceMaster updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MdmMeesevaServiceMaster)) {
            return false;
        }
        return id != null && id.equals(((MdmMeesevaServiceMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdmMeesevaServiceMaster{" +
            "id=" + getId() +
            ", meesevaServiceId=" + getMeesevaServiceId() +
            ", meesevaServiceName='" + getMeesevaServiceName() + "'" +
            ", isCharged='" + getIsCharged() + "'" +
            ", organizationEntityTypeCode='" + getOrganizationEntityTypeCode() + "'" +
            ", applicationTable='" + getApplicationTable() + "'" +
            ", applicationObject='" + getApplicationObject() + "'" +
            ", customerDefaultFlag='" + getCustomerDefaultFlag() + "'" +
            ", channelDefaultFlag='" + getChannelDefaultFlag() + "'" +
            ", serviceUrl='" + getServiceUrl() + "'" +
            ", backOfficeUrl='" + getBackOfficeUrl() + "'" +
            ", packageId=" + getPackageId() +
            ", meesevaServiceActiveFlag='" + getMeesevaServiceActiveFlag() + "'" +
            ", meesevaServiceGroupId=" + getMeesevaServiceGroupId() +
            ", meesevaServiceSubGroupId=" + getMeesevaServiceSubGroupId() +
            ", meesevaServiceTypeId=" + getMeesevaServiceTypeId() +
            ", meesevaServiceSubTypeId=" + getMeesevaServiceSubTypeId() +
            ", departmentCode='" + getDepartmentCode() + "'" +
            ", efmsDepartmentCode='" + getEfmsDepartmentCode() + "'" +
            ", isOnline='" + getIsOnline() + "'" +
            ", agencyType=" + getAgencyType() +
            ", launchDate='" + getLaunchDate() + "'" +
            ", isMobile='" + getIsMobile() + "'" +
            ", innerSubId=" + getInnerSubId() +
            ", digilockerEnabled='" + getDigilockerEnabled() + "'" +
            ", isRegular='" + getIsRegular() + "'" +
            ", isSeasonal='" + getIsSeasonal() + "'" +
            ", citizenPortalLaunchDate='" + getCitizenPortalLaunchDate() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", recordInsertTime='" + getRecordInsertTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
