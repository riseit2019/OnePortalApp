package com.epragati.oneportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A MdmRoleActivityMaster.
 */
@Entity
@Table(name = "mdm_role_activity_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdmRoleActivityMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "syspk", nullable = false)
    private Long syspk;

    @NotNull
    @Column(name = "activity_name", nullable = false)
    private String activityName;

    @Column(name = "activity_level_id")
    private Integer activityLevelId;

    @Column(name = "activity_level_desc")
    private String activityLevelDesc;

    @NotNull
    @Column(name = "role_code", nullable = false)
    private String roleCode;

    @NotNull
    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "role_level_id")
    private Integer roleLevelId;

    @Column(name = "role_level_desc")
    private String roleLevelDesc;

    @Column(name = "role_activity_status")
    private String roleActivityStatus;

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

    @ManyToOne
    @JsonIgnoreProperties("mdmRoleActivityMasters")
    private MdmActivityMaster activityCode;

    @ManyToOne
    @JsonIgnoreProperties("mdmRoleActivityMasters")
    private MdmRoleMaster roleCode;

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

    public MdmRoleActivityMaster syspk(Long syspk) {
        this.syspk = syspk;
        return this;
    }

    public void setSyspk(Long syspk) {
        this.syspk = syspk;
    }

    public String getActivityName() {
        return activityName;
    }

    public MdmRoleActivityMaster activityName(String activityName) {
        this.activityName = activityName;
        return this;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityLevelId() {
        return activityLevelId;
    }

    public MdmRoleActivityMaster activityLevelId(Integer activityLevelId) {
        this.activityLevelId = activityLevelId;
        return this;
    }

    public void setActivityLevelId(Integer activityLevelId) {
        this.activityLevelId = activityLevelId;
    }

    public String getActivityLevelDesc() {
        return activityLevelDesc;
    }

    public MdmRoleActivityMaster activityLevelDesc(String activityLevelDesc) {
        this.activityLevelDesc = activityLevelDesc;
        return this;
    }

    public void setActivityLevelDesc(String activityLevelDesc) {
        this.activityLevelDesc = activityLevelDesc;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public MdmRoleActivityMaster roleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public MdmRoleActivityMaster roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleLevelId() {
        return roleLevelId;
    }

    public MdmRoleActivityMaster roleLevelId(Integer roleLevelId) {
        this.roleLevelId = roleLevelId;
        return this;
    }

    public void setRoleLevelId(Integer roleLevelId) {
        this.roleLevelId = roleLevelId;
    }

    public String getRoleLevelDesc() {
        return roleLevelDesc;
    }

    public MdmRoleActivityMaster roleLevelDesc(String roleLevelDesc) {
        this.roleLevelDesc = roleLevelDesc;
        return this;
    }

    public void setRoleLevelDesc(String roleLevelDesc) {
        this.roleLevelDesc = roleLevelDesc;
    }

    public String getRoleActivityStatus() {
        return roleActivityStatus;
    }

    public MdmRoleActivityMaster roleActivityStatus(String roleActivityStatus) {
        this.roleActivityStatus = roleActivityStatus;
        return this;
    }

    public void setRoleActivityStatus(String roleActivityStatus) {
        this.roleActivityStatus = roleActivityStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MdmRoleActivityMaster createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MdmRoleActivityMaster updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getRecordInsertTime() {
        return recordInsertTime;
    }

    public MdmRoleActivityMaster recordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
        return this;
    }

    public void setRecordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public MdmRoleActivityMaster createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public MdmRoleActivityMaster updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public MdmActivityMaster getActivityCode() {
        return activityCode;
    }

    public MdmRoleActivityMaster activityCode(MdmActivityMaster mdmActivityMaster) {
        this.activityCode = mdmActivityMaster;
        return this;
    }

    public void setActivityCode(MdmActivityMaster mdmActivityMaster) {
        this.activityCode = mdmActivityMaster;
    }

    public MdmRoleMaster getRoleCode() {
        return roleCode;
    }

    public MdmRoleActivityMaster roleCode(MdmRoleMaster mdmRoleMaster) {
        this.roleCode = mdmRoleMaster;
        return this;
    }

    public void setRoleCode(MdmRoleMaster mdmRoleMaster) {
        this.roleCode = mdmRoleMaster;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MdmRoleActivityMaster)) {
            return false;
        }
        return id != null && id.equals(((MdmRoleActivityMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdmRoleActivityMaster{" +
            "id=" + getId() +
            ", syspk=" + getSyspk() +
            ", activityName='" + getActivityName() + "'" +
            ", activityLevelId=" + getActivityLevelId() +
            ", activityLevelDesc='" + getActivityLevelDesc() + "'" +
            ", roleCode='" + getRoleCode() + "'" +
            ", roleName='" + getRoleName() + "'" +
            ", roleLevelId=" + getRoleLevelId() +
            ", roleLevelDesc='" + getRoleLevelDesc() + "'" +
            ", roleActivityStatus='" + getRoleActivityStatus() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", recordInsertTime='" + getRecordInsertTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
