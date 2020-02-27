package com.epragati.oneportal.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A MdmEmployeeMaster.
 */
@Entity
@Table(name = "mdm_employee_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdmEmployeeMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "employee_code", nullable = false)
    private String employeeCode;

    @Column(name = "temp_ref_id")
    private Long tempRefId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "entity_name")
    private String entityName;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "designation_id")
    private String designationId;

    @Column(name = "designation_name")
    private String designationName;

    @Column(name = "post_name")
    private String postName;

    @Column(name = "organization_unit_name")
    private String organizationUnitName;

    @Column(name = "parent_organization_unit")
    private String parentOrganizationUnit;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "post_office")
    private String postOffice;

    @Column(name = "is_primary")
    private String isPrimary;

    @Column(name = "is_ou_head")
    private String isOuHead;

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

    @Column(name = "panchayat_code")
    private String panchayatCode;

    @Column(name = "panchayat_name")
    private String panchayatName;

    @Column(name = "constituency_code")
    private Integer constituencyCode;

    @Column(name = "constituency_name")
    private String constituencyName;

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

    @Column(name = "employee_type")
    private String employeeType;

    @Column(name = "manager_employee_code")
    private String managerEmployeeCode;

    @Column(name = "employee_active_status")
    private String employeeActiveStatus;

    @Column(name = "person_id_1")
    private String personId1;

    @Column(name = "aadhaar_ref_id")
    private Long aadhaarRefId;

    @Column(name = "volunteer_secretariat_id")
    private String volunteerSecretariatId;

    @Column(name = "volunteer_secretariat_flag")
    private String volunteerSecretariatFlag;

    @Column(name = "aadhaar_number")
    private Long aadhaarNumber;

    @OneToOne
    @JoinColumn(unique = true)
    private MdmOrganizationMaster organizationCode;

    @OneToOne
    @JoinColumn(unique = true)
    private MdmCitizenData personId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public MdmEmployeeMaster employeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Long getTempRefId() {
        return tempRefId;
    }

    public MdmEmployeeMaster tempRefId(Long tempRefId) {
        this.tempRefId = tempRefId;
        return this;
    }

    public void setTempRefId(Long tempRefId) {
        this.tempRefId = tempRefId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public MdmEmployeeMaster employeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public MdmEmployeeMaster employeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEntityName() {
        return entityName;
    }

    public MdmEmployeeMaster entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public MdmEmployeeMaster organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDesignationId() {
        return designationId;
    }

    public MdmEmployeeMaster designationId(String designationId) {
        this.designationId = designationId;
        return this;
    }

    public void setDesignationId(String designationId) {
        this.designationId = designationId;
    }

    public String getDesignationName() {
        return designationName;
    }

    public MdmEmployeeMaster designationName(String designationName) {
        this.designationName = designationName;
        return this;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getPostName() {
        return postName;
    }

    public MdmEmployeeMaster postName(String postName) {
        this.postName = postName;
        return this;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getOrganizationUnitName() {
        return organizationUnitName;
    }

    public MdmEmployeeMaster organizationUnitName(String organizationUnitName) {
        this.organizationUnitName = organizationUnitName;
        return this;
    }

    public void setOrganizationUnitName(String organizationUnitName) {
        this.organizationUnitName = organizationUnitName;
    }

    public String getParentOrganizationUnit() {
        return parentOrganizationUnit;
    }

    public MdmEmployeeMaster parentOrganizationUnit(String parentOrganizationUnit) {
        this.parentOrganizationUnit = parentOrganizationUnit;
        return this;
    }

    public void setParentOrganizationUnit(String parentOrganizationUnit) {
        this.parentOrganizationUnit = parentOrganizationUnit;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public MdmEmployeeMaster mobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public MdmEmployeeMaster emailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddressType() {
        return addressType;
    }

    public MdmEmployeeMaster addressType(String addressType) {
        this.addressType = addressType;
        return this;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress1() {
        return address1;
    }

    public MdmEmployeeMaster address1(String address1) {
        this.address1 = address1;
        return this;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public MdmEmployeeMaster address2(String address2) {
        this.address2 = address2;
        return this;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCityName() {
        return cityName;
    }

    public MdmEmployeeMaster cityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public MdmEmployeeMaster postOffice(String postOffice) {
        this.postOffice = postOffice;
        return this;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getIsPrimary() {
        return isPrimary;
    }

    public MdmEmployeeMaster isPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
        return this;
    }

    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getIsOuHead() {
        return isOuHead;
    }

    public MdmEmployeeMaster isOuHead(String isOuHead) {
        this.isOuHead = isOuHead;
        return this;
    }

    public void setIsOuHead(String isOuHead) {
        this.isOuHead = isOuHead;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public MdmEmployeeMaster districtCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public MdmEmployeeMaster districtName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getMandalCode() {
        return mandalCode;
    }

    public MdmEmployeeMaster mandalCode(String mandalCode) {
        this.mandalCode = mandalCode;
        return this;
    }

    public void setMandalCode(String mandalCode) {
        this.mandalCode = mandalCode;
    }

    public String getMandalName() {
        return mandalName;
    }

    public MdmEmployeeMaster mandalName(String mandalName) {
        this.mandalName = mandalName;
        return this;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public MdmEmployeeMaster villageCode(String villageCode) {
        this.villageCode = villageCode;
        return this;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public MdmEmployeeMaster villageName(String villageName) {
        this.villageName = villageName;
        return this;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getPanchayatCode() {
        return panchayatCode;
    }

    public MdmEmployeeMaster panchayatCode(String panchayatCode) {
        this.panchayatCode = panchayatCode;
        return this;
    }

    public void setPanchayatCode(String panchayatCode) {
        this.panchayatCode = panchayatCode;
    }

    public String getPanchayatName() {
        return panchayatName;
    }

    public MdmEmployeeMaster panchayatName(String panchayatName) {
        this.panchayatName = panchayatName;
        return this;
    }

    public void setPanchayatName(String panchayatName) {
        this.panchayatName = panchayatName;
    }

    public Integer getConstituencyCode() {
        return constituencyCode;
    }

    public MdmEmployeeMaster constituencyCode(Integer constituencyCode) {
        this.constituencyCode = constituencyCode;
        return this;
    }

    public void setConstituencyCode(Integer constituencyCode) {
        this.constituencyCode = constituencyCode;
    }

    public String getConstituencyName() {
        return constituencyName;
    }

    public MdmEmployeeMaster constituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
        return this;
    }

    public void setConstituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MdmEmployeeMaster createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MdmEmployeeMaster updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getRecordInsertTime() {
        return recordInsertTime;
    }

    public MdmEmployeeMaster recordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
        return this;
    }

    public void setRecordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public MdmEmployeeMaster createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public MdmEmployeeMaster updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public MdmEmployeeMaster employeeType(String employeeType) {
        this.employeeType = employeeType;
        return this;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getManagerEmployeeCode() {
        return managerEmployeeCode;
    }

    public MdmEmployeeMaster managerEmployeeCode(String managerEmployeeCode) {
        this.managerEmployeeCode = managerEmployeeCode;
        return this;
    }

    public void setManagerEmployeeCode(String managerEmployeeCode) {
        this.managerEmployeeCode = managerEmployeeCode;
    }

    public String getEmployeeActiveStatus() {
        return employeeActiveStatus;
    }

    public MdmEmployeeMaster employeeActiveStatus(String employeeActiveStatus) {
        this.employeeActiveStatus = employeeActiveStatus;
        return this;
    }

    public void setEmployeeActiveStatus(String employeeActiveStatus) {
        this.employeeActiveStatus = employeeActiveStatus;
    }

    public String getPersonId1() {
        return personId1;
    }

    public MdmEmployeeMaster personId1(String personId1) {
        this.personId1 = personId1;
        return this;
    }

    public void setPersonId1(String personId1) {
        this.personId1 = personId1;
    }

    public Long getAadhaarRefId() {
        return aadhaarRefId;
    }

    public MdmEmployeeMaster aadhaarRefId(Long aadhaarRefId) {
        this.aadhaarRefId = aadhaarRefId;
        return this;
    }

    public void setAadhaarRefId(Long aadhaarRefId) {
        this.aadhaarRefId = aadhaarRefId;
    }

    public String getVolunteerSecretariatId() {
        return volunteerSecretariatId;
    }

    public MdmEmployeeMaster volunteerSecretariatId(String volunteerSecretariatId) {
        this.volunteerSecretariatId = volunteerSecretariatId;
        return this;
    }

    public void setVolunteerSecretariatId(String volunteerSecretariatId) {
        this.volunteerSecretariatId = volunteerSecretariatId;
    }

    public String getVolunteerSecretariatFlag() {
        return volunteerSecretariatFlag;
    }

    public MdmEmployeeMaster volunteerSecretariatFlag(String volunteerSecretariatFlag) {
        this.volunteerSecretariatFlag = volunteerSecretariatFlag;
        return this;
    }

    public void setVolunteerSecretariatFlag(String volunteerSecretariatFlag) {
        this.volunteerSecretariatFlag = volunteerSecretariatFlag;
    }

    public Long getAadhaarNumber() {
        return aadhaarNumber;
    }

    public MdmEmployeeMaster aadhaarNumber(Long aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
        return this;
    }

    public void setAadhaarNumber(Long aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public MdmOrganizationMaster getOrganizationCode() {
        return organizationCode;
    }

    public MdmEmployeeMaster organizationCode(MdmOrganizationMaster mdmOrganizationMaster) {
        this.organizationCode = mdmOrganizationMaster;
        return this;
    }

    public void setOrganizationCode(MdmOrganizationMaster mdmOrganizationMaster) {
        this.organizationCode = mdmOrganizationMaster;
    }

    public MdmCitizenData getPersonId() {
        return personId;
    }

    public MdmEmployeeMaster personId(MdmCitizenData mdmCitizenData) {
        this.personId = mdmCitizenData;
        return this;
    }

    public void setPersonId(MdmCitizenData mdmCitizenData) {
        this.personId = mdmCitizenData;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MdmEmployeeMaster)) {
            return false;
        }
        return id != null && id.equals(((MdmEmployeeMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdmEmployeeMaster{" +
            "id=" + getId() +
            ", employeeCode='" + getEmployeeCode() + "'" +
            ", tempRefId=" + getTempRefId() +
            ", employeeId=" + getEmployeeId() +
            ", employeeName='" + getEmployeeName() + "'" +
            ", entityName='" + getEntityName() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", designationId='" + getDesignationId() + "'" +
            ", designationName='" + getDesignationName() + "'" +
            ", postName='" + getPostName() + "'" +
            ", organizationUnitName='" + getOrganizationUnitName() + "'" +
            ", parentOrganizationUnit='" + getParentOrganizationUnit() + "'" +
            ", mobileNumber=" + getMobileNumber() +
            ", emailId='" + getEmailId() + "'" +
            ", addressType='" + getAddressType() + "'" +
            ", address1='" + getAddress1() + "'" +
            ", address2='" + getAddress2() + "'" +
            ", cityName='" + getCityName() + "'" +
            ", postOffice='" + getPostOffice() + "'" +
            ", isPrimary='" + getIsPrimary() + "'" +
            ", isOuHead='" + getIsOuHead() + "'" +
            ", districtCode='" + getDistrictCode() + "'" +
            ", districtName='" + getDistrictName() + "'" +
            ", mandalCode='" + getMandalCode() + "'" +
            ", mandalName='" + getMandalName() + "'" +
            ", villageCode='" + getVillageCode() + "'" +
            ", villageName='" + getVillageName() + "'" +
            ", panchayatCode='" + getPanchayatCode() + "'" +
            ", panchayatName='" + getPanchayatName() + "'" +
            ", constituencyCode=" + getConstituencyCode() +
            ", constituencyName='" + getConstituencyName() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", recordInsertTime='" + getRecordInsertTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", employeeType='" + getEmployeeType() + "'" +
            ", managerEmployeeCode='" + getManagerEmployeeCode() + "'" +
            ", employeeActiveStatus='" + getEmployeeActiveStatus() + "'" +
            ", personId1='" + getPersonId1() + "'" +
            ", aadhaarRefId=" + getAadhaarRefId() +
            ", volunteerSecretariatId='" + getVolunteerSecretariatId() + "'" +
            ", volunteerSecretariatFlag='" + getVolunteerSecretariatFlag() + "'" +
            ", aadhaarNumber=" + getAadhaarNumber() +
            "}";
    }
}
