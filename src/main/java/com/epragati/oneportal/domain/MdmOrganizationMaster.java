package com.epragati.oneportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A MdmOrganizationMaster.
 */
@Entity
@Table(name = "mdm_organization_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdmOrganizationMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "syspk", nullable = false)
    private Long syspk;

    @NotNull
    @Column(name = "organization_code", nullable = false)
    private String organizationCode;

    @Column(name = "organization_short_name")
    private String organizationShortName;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "organization_type")
    private String organizationType;

    @Column(name = "organization_desc")
    private String organizationDesc;

    @Column(name = "sector_code")
    private String sectorCode;

    @Column(name = "parent_org_code")
    private String parentOrgCode;

    @Column(name = "organization_active_flag")
    private Boolean organizationActiveFlag;

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

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "organization_type_desc")
    private String organizationTypeDesc;

    @Column(name = "jurisdiction_type")
    private String jurisdictionType;

    @OneToOne(mappedBy = "organizationCode")
    @JsonIgnore
    private MdmEmployeeMaster organizationCode;

    @OneToOne(mappedBy = "organizationCode")
    @JsonIgnore
    private MdmServiceMaster organizationCode;

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

    public MdmOrganizationMaster syspk(Long syspk) {
        this.syspk = syspk;
        return this;
    }

    public void setSyspk(Long syspk) {
        this.syspk = syspk;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public MdmOrganizationMaster organizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
        return this;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationShortName() {
        return organizationShortName;
    }

    public MdmOrganizationMaster organizationShortName(String organizationShortName) {
        this.organizationShortName = organizationShortName;
        return this;
    }

    public void setOrganizationShortName(String organizationShortName) {
        this.organizationShortName = organizationShortName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public MdmOrganizationMaster organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public MdmOrganizationMaster organizationType(String organizationType) {
        this.organizationType = organizationType;
        return this;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getOrganizationDesc() {
        return organizationDesc;
    }

    public MdmOrganizationMaster organizationDesc(String organizationDesc) {
        this.organizationDesc = organizationDesc;
        return this;
    }

    public void setOrganizationDesc(String organizationDesc) {
        this.organizationDesc = organizationDesc;
    }

    public String getSectorCode() {
        return sectorCode;
    }

    public MdmOrganizationMaster sectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
        return this;
    }

    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    public String getParentOrgCode() {
        return parentOrgCode;
    }

    public MdmOrganizationMaster parentOrgCode(String parentOrgCode) {
        this.parentOrgCode = parentOrgCode;
        return this;
    }

    public void setParentOrgCode(String parentOrgCode) {
        this.parentOrgCode = parentOrgCode;
    }

    public Boolean isOrganizationActiveFlag() {
        return organizationActiveFlag;
    }

    public MdmOrganizationMaster organizationActiveFlag(Boolean organizationActiveFlag) {
        this.organizationActiveFlag = organizationActiveFlag;
        return this;
    }

    public void setOrganizationActiveFlag(Boolean organizationActiveFlag) {
        this.organizationActiveFlag = organizationActiveFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MdmOrganizationMaster createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MdmOrganizationMaster updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getRecordInsertTime() {
        return recordInsertTime;
    }

    public MdmOrganizationMaster recordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
        return this;
    }

    public void setRecordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public MdmOrganizationMaster createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public MdmOrganizationMaster updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public MdmOrganizationMaster startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public MdmOrganizationMaster endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getOrganizationTypeDesc() {
        return organizationTypeDesc;
    }

    public MdmOrganizationMaster organizationTypeDesc(String organizationTypeDesc) {
        this.organizationTypeDesc = organizationTypeDesc;
        return this;
    }

    public void setOrganizationTypeDesc(String organizationTypeDesc) {
        this.organizationTypeDesc = organizationTypeDesc;
    }

    public String getJurisdictionType() {
        return jurisdictionType;
    }

    public MdmOrganizationMaster jurisdictionType(String jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
        return this;
    }

    public void setJurisdictionType(String jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    public MdmEmployeeMaster getOrganizationCode() {
        return organizationCode;
    }

    public MdmOrganizationMaster organizationCode(MdmEmployeeMaster mdmEmployeeMaster) {
        this.organizationCode = mdmEmployeeMaster;
        return this;
    }

    public void setOrganizationCode(MdmEmployeeMaster mdmEmployeeMaster) {
        this.organizationCode = mdmEmployeeMaster;
    }

    public MdmServiceMaster getOrganizationCode() {
        return organizationCode;
    }

    public MdmOrganizationMaster organizationCode(MdmServiceMaster mdmServiceMaster) {
        this.organizationCode = mdmServiceMaster;
        return this;
    }

    public void setOrganizationCode(MdmServiceMaster mdmServiceMaster) {
        this.organizationCode = mdmServiceMaster;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MdmOrganizationMaster)) {
            return false;
        }
        return id != null && id.equals(((MdmOrganizationMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdmOrganizationMaster{" +
            "id=" + getId() +
            ", syspk=" + getSyspk() +
            ", organizationCode='" + getOrganizationCode() + "'" +
            ", organizationShortName='" + getOrganizationShortName() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", organizationType='" + getOrganizationType() + "'" +
            ", organizationDesc='" + getOrganizationDesc() + "'" +
            ", sectorCode='" + getSectorCode() + "'" +
            ", parentOrgCode='" + getParentOrgCode() + "'" +
            ", organizationActiveFlag='" + isOrganizationActiveFlag() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", recordInsertTime='" + getRecordInsertTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", organizationTypeDesc='" + getOrganizationTypeDesc() + "'" +
            ", jurisdictionType='" + getJurisdictionType() + "'" +
            "}";
    }
}
