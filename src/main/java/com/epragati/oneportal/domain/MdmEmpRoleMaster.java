package com.epragati.oneportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A MdmEmpRoleMaster.
 */
@Entity
@Table(name = "mdm_emp_role_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdmEmpRoleMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "role_name")
    private String roleName;

    @NotNull
    @Column(name = "office_code", nullable = false)
    private String officeCode;

    @Column(name = "office_name")
    private String officeName;

    @Column(name = "person_id")
    private String personId;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "district_code")
    private String districtCode;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "mandal_code")
    private String mandalCode;

    @Column(name = "mandal_name")
    private String mandalName;

    @Column(name = "village_code")
    private String villageCode;

    @Column(name = "village_name")
    private String villageName;

    @Column(name = "circle_name")
    private String circleName;

    @Column(name = "division_name")
    private String divisionName;

    @Column(name = "sub_division_name")
    private String subDivisionName;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "active_status_flag")
    private Integer activeStatusFlag;

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

    @Column(name = "volunteer_secretariat_role")
    private String volunteerSecretariatRole;

    @ManyToOne
    @JsonIgnoreProperties("mdmEmpRoleMasters")
    private MdmOrganizationMaster organizationCode;

    @ManyToOne
    @JsonIgnoreProperties("mdmEmpRoleMasters")
    private MdmEmployeeMaster employeeCode;

    @ManyToOne
    @JsonIgnoreProperties("mdmEmpRoleMasters")
    private MdmRoleMaster roleCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public MdmEmpRoleMaster employeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRoleName() {
        return roleName;
    }

    public MdmEmpRoleMaster roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public MdmEmpRoleMaster officeCode(String officeCode) {
        this.officeCode = officeCode;
        return this;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getOfficeName() {
        return officeName;
    }

    public MdmEmpRoleMaster officeName(String officeName) {
        this.officeName = officeName;
        return this;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getPersonId() {
        return personId;
    }

    public MdmEmpRoleMaster personId(String personId) {
        this.personId = personId;
        return this;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public MdmEmpRoleMaster organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public MdmEmpRoleMaster stateCode(String stateCode) {
        this.stateCode = stateCode;
        return this;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public MdmEmpRoleMaster stateName(String stateName) {
        this.stateName = stateName;
        return this;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public MdmEmpRoleMaster districtCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public MdmEmpRoleMaster districtName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getMandalCode() {
        return mandalCode;
    }

    public MdmEmpRoleMaster mandalCode(String mandalCode) {
        this.mandalCode = mandalCode;
        return this;
    }

    public void setMandalCode(String mandalCode) {
        this.mandalCode = mandalCode;
    }

    public String getMandalName() {
        return mandalName;
    }

    public MdmEmpRoleMaster mandalName(String mandalName) {
        this.mandalName = mandalName;
        return this;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public MdmEmpRoleMaster villageCode(String villageCode) {
        this.villageCode = villageCode;
        return this;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public MdmEmpRoleMaster villageName(String villageName) {
        this.villageName = villageName;
        return this;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getCircleName() {
        return circleName;
    }

    public MdmEmpRoleMaster circleName(String circleName) {
        this.circleName = circleName;
        return this;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public MdmEmpRoleMaster divisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getSubDivisionName() {
        return subDivisionName;
    }

    public MdmEmpRoleMaster subDivisionName(String subDivisionName) {
        this.subDivisionName = subDivisionName;
        return this;
    }

    public void setSubDivisionName(String subDivisionName) {
        this.subDivisionName = subDivisionName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public MdmEmpRoleMaster sectionName(String sectionName) {
        this.sectionName = sectionName;
        return this;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getActiveStatusFlag() {
        return activeStatusFlag;
    }

    public MdmEmpRoleMaster activeStatusFlag(Integer activeStatusFlag) {
        this.activeStatusFlag = activeStatusFlag;
        return this;
    }

    public void setActiveStatusFlag(Integer activeStatusFlag) {
        this.activeStatusFlag = activeStatusFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MdmEmpRoleMaster createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MdmEmpRoleMaster updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getRecordInsertTime() {
        return recordInsertTime;
    }

    public MdmEmpRoleMaster recordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
        return this;
    }

    public void setRecordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public MdmEmpRoleMaster createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public MdmEmpRoleMaster updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public String getVolunteerSecretariatRole() {
        return volunteerSecretariatRole;
    }

    public MdmEmpRoleMaster volunteerSecretariatRole(String volunteerSecretariatRole) {
        this.volunteerSecretariatRole = volunteerSecretariatRole;
        return this;
    }

    public void setVolunteerSecretariatRole(String volunteerSecretariatRole) {
        this.volunteerSecretariatRole = volunteerSecretariatRole;
    }

    public MdmOrganizationMaster getOrganizationCode() {
        return organizationCode;
    }

    public MdmEmpRoleMaster organizationCode(MdmOrganizationMaster mdmOrganizationMaster) {
        this.organizationCode = mdmOrganizationMaster;
        return this;
    }

    public void setOrganizationCode(MdmOrganizationMaster mdmOrganizationMaster) {
        this.organizationCode = mdmOrganizationMaster;
    }

    public MdmEmployeeMaster getEmployeeCode() {
        return employeeCode;
    }

    public MdmEmpRoleMaster employeeCode(MdmEmployeeMaster mdmEmployeeMaster) {
        this.employeeCode = mdmEmployeeMaster;
        return this;
    }

    public void setEmployeeCode(MdmEmployeeMaster mdmEmployeeMaster) {
        this.employeeCode = mdmEmployeeMaster;
    }

    public MdmRoleMaster getRoleCode() {
        return roleCode;
    }

    public MdmEmpRoleMaster roleCode(MdmRoleMaster mdmRoleMaster) {
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
        if (!(o instanceof MdmEmpRoleMaster)) {
            return false;
        }
        return id != null && id.equals(((MdmEmpRoleMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdmEmpRoleMaster{" +
            "id=" + getId() +
            ", employeeName='" + getEmployeeName() + "'" +
            ", roleName='" + getRoleName() + "'" +
            ", officeCode='" + getOfficeCode() + "'" +
            ", officeName='" + getOfficeName() + "'" +
            ", personId='" + getPersonId() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", stateCode='" + getStateCode() + "'" +
            ", stateName='" + getStateName() + "'" +
            ", districtCode='" + getDistrictCode() + "'" +
            ", districtName='" + getDistrictName() + "'" +
            ", mandalCode='" + getMandalCode() + "'" +
            ", mandalName='" + getMandalName() + "'" +
            ", villageCode='" + getVillageCode() + "'" +
            ", villageName='" + getVillageName() + "'" +
            ", circleName='" + getCircleName() + "'" +
            ", divisionName='" + getDivisionName() + "'" +
            ", subDivisionName='" + getSubDivisionName() + "'" +
            ", sectionName='" + getSectionName() + "'" +
            ", activeStatusFlag=" + getActiveStatusFlag() +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", recordInsertTime='" + getRecordInsertTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", volunteerSecretariatRole='" + getVolunteerSecretariatRole() + "'" +
            "}";
    }
}
