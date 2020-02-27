package com.epragati.oneportal.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A MdmRoleMaster.
 */
@Entity
@Table(name = "mdm_role_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdmRoleMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "syspk", nullable = false)
    private Long syspk;

    @NotNull
    @Column(name = "role_code", nullable = false)
    private String roleCode;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_desc")
    private String roleDesc;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "service_code")
    private String serviceCode;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "location_code")
    private String locationCode;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "role_status")
    private String roleStatus;

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

    @Column(name = "role_level_id")
    private Integer roleLevelId;

    @Column(name = "role_level_desc")
    private String roleLevelDesc;

    @Column(name = "volunteer_secretariat")
    private String volunteerSecretariat;

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

    public MdmRoleMaster syspk(Long syspk) {
        this.syspk = syspk;
        return this;
    }

    public void setSyspk(Long syspk) {
        this.syspk = syspk;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public MdmRoleMaster roleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public MdmRoleMaster roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public MdmRoleMaster roleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
        return this;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public MdmRoleMaster organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public MdmRoleMaster serviceCode(String serviceCode) {
        this.serviceCode = serviceCode;
        return this;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public MdmRoleMaster serviceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public MdmRoleMaster locationCode(String locationCode) {
        this.locationCode = locationCode;
        return this;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public MdmRoleMaster locationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public MdmRoleMaster roleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
        return this;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MdmRoleMaster createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MdmRoleMaster updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getRecordInsertTime() {
        return recordInsertTime;
    }

    public MdmRoleMaster recordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
        return this;
    }

    public void setRecordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public MdmRoleMaster createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public MdmRoleMaster updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRoleLevelId() {
        return roleLevelId;
    }

    public MdmRoleMaster roleLevelId(Integer roleLevelId) {
        this.roleLevelId = roleLevelId;
        return this;
    }

    public void setRoleLevelId(Integer roleLevelId) {
        this.roleLevelId = roleLevelId;
    }

    public String getRoleLevelDesc() {
        return roleLevelDesc;
    }

    public MdmRoleMaster roleLevelDesc(String roleLevelDesc) {
        this.roleLevelDesc = roleLevelDesc;
        return this;
    }

    public void setRoleLevelDesc(String roleLevelDesc) {
        this.roleLevelDesc = roleLevelDesc;
    }

    public String getVolunteerSecretariat() {
        return volunteerSecretariat;
    }

    public MdmRoleMaster volunteerSecretariat(String volunteerSecretariat) {
        this.volunteerSecretariat = volunteerSecretariat;
        return this;
    }

    public void setVolunteerSecretariat(String volunteerSecretariat) {
        this.volunteerSecretariat = volunteerSecretariat;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MdmRoleMaster)) {
            return false;
        }
        return id != null && id.equals(((MdmRoleMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdmRoleMaster{" +
            "id=" + getId() +
            ", syspk=" + getSyspk() +
            ", roleCode='" + getRoleCode() + "'" +
            ", roleName='" + getRoleName() + "'" +
            ", roleDesc='" + getRoleDesc() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", serviceCode='" + getServiceCode() + "'" +
            ", serviceName='" + getServiceName() + "'" +
            ", locationCode='" + getLocationCode() + "'" +
            ", locationName='" + getLocationName() + "'" +
            ", roleStatus='" + getRoleStatus() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", recordInsertTime='" + getRecordInsertTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", roleLevelId=" + getRoleLevelId() +
            ", roleLevelDesc='" + getRoleLevelDesc() + "'" +
            ", volunteerSecretariat='" + getVolunteerSecretariat() + "'" +
            "}";
    }
}
