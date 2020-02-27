package com.epragati.oneportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A MdmActivityMaster.
 */
@Entity
@Table(name = "mdm_activity_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdmActivityMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "activity_code", nullable = false)
    private String activityCode;

    @NotNull
    @Column(name = "activity_name", nullable = false)
    private String activityName;

    @Column(name = "activity_desc")
    private String activityDesc;

    @Column(name = "activity_level_id")
    private Integer activityLevelId;

    @Column(name = "activity_level_desc")
    private String activityLevelDesc;

    @NotNull
    @Column(name = "organization_code", nullable = false)
    private String organizationCode;

    @Column(name = "organization_name")
    private String organizationName;

    @NotNull
    @Column(name = "activity_status", nullable = false)
    private String activityStatus;

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

    @OneToOne
    @JoinColumn(unique = true)
    private MdmOrganizationMaster organizationCode;

    @ManyToOne
    @JsonIgnoreProperties("mdmActivityMasters")
    private MdmOrganizationMaster organizationCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public MdmActivityMaster activityCode(String activityCode) {
        this.activityCode = activityCode;
        return this;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityName() {
        return activityName;
    }

    public MdmActivityMaster activityName(String activityName) {
        this.activityName = activityName;
        return this;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public MdmActivityMaster activityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
        return this;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public Integer getActivityLevelId() {
        return activityLevelId;
    }

    public MdmActivityMaster activityLevelId(Integer activityLevelId) {
        this.activityLevelId = activityLevelId;
        return this;
    }

    public void setActivityLevelId(Integer activityLevelId) {
        this.activityLevelId = activityLevelId;
    }

    public String getActivityLevelDesc() {
        return activityLevelDesc;
    }

    public MdmActivityMaster activityLevelDesc(String activityLevelDesc) {
        this.activityLevelDesc = activityLevelDesc;
        return this;
    }

    public void setActivityLevelDesc(String activityLevelDesc) {
        this.activityLevelDesc = activityLevelDesc;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public MdmActivityMaster organizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
        return this;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public MdmActivityMaster organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public MdmActivityMaster activityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
        return this;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MdmActivityMaster createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MdmActivityMaster updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getRecordInsertTime() {
        return recordInsertTime;
    }

    public MdmActivityMaster recordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
        return this;
    }

    public void setRecordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public MdmActivityMaster createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public MdmActivityMaster updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public MdmOrganizationMaster getOrganizationCode() {
        return organizationCode;
    }

    public MdmActivityMaster organizationCode(MdmOrganizationMaster mdmOrganizationMaster) {
        this.organizationCode = mdmOrganizationMaster;
        return this;
    }

    public void setOrganizationCode(MdmOrganizationMaster mdmOrganizationMaster) {
        this.organizationCode = mdmOrganizationMaster;
    }

    public MdmOrganizationMaster getOrganizationCode() {
        return organizationCode;
    }

    public MdmActivityMaster organizationCode(MdmOrganizationMaster mdmOrganizationMaster) {
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
        if (!(o instanceof MdmActivityMaster)) {
            return false;
        }
        return id != null && id.equals(((MdmActivityMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdmActivityMaster{" +
            "id=" + getId() +
            ", activityCode='" + getActivityCode() + "'" +
            ", activityName='" + getActivityName() + "'" +
            ", activityDesc='" + getActivityDesc() + "'" +
            ", activityLevelId=" + getActivityLevelId() +
            ", activityLevelDesc='" + getActivityLevelDesc() + "'" +
            ", organizationCode='" + getOrganizationCode() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", activityStatus='" + getActivityStatus() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", recordInsertTime='" + getRecordInsertTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
