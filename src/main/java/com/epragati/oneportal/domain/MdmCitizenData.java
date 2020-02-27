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
 * A MdmCitizenData.
 */
@Entity
@Table(name = "mdm_citizen_data")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdmCitizenData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "syspk", nullable = false)
    private Long syspk;

    @NotNull
    @Column(name = "person_id", nullable = false)
    private String personId;

    @Column(name = "temp_ref_id")
    private Long tempRefId;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender_id")
    private Integer genderId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "house_number_adh")
    private String houseNumberAdh;

    @Column(name = "street_adh")
    private String streetAdh;

    @Column(name = "village_adh")
    private String villageAdh;

    @Column(name = "district_name_ah")
    private String districtNameAh;

    @Column(name = "sub_district_name_adh")
    private String subDistrictNameAdh;

    @Column(name = "post_office_adh")
    private String postOfficeAdh;

    @Column(name = "state_name_adh")
    private String stateNameAdh;

    @Column(name = "pin_code_adh")
    private String pinCodeAdh;

    @Column(name = "district_code_pss")
    private Integer districtCodePss;

    @Column(name = "district_name_pss")
    private String districtNamePss;

    @Column(name = "district_code")
    private String districtCode;

    @Column(name = "mandal_code")
    private String mandalCode;

    @Column(name = "village_code")
    private String villageCode;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "mandal_name")
    private String mandalName;

    @Column(name = "village_name")
    private String villageName;

    @Column(name = "house_hold_id")
    private String houseHoldId;

    @Column(name = "relationship_with_hoh")
    private String relationshipWithHoh;

    @Column(name = "building_name_pss")
    private String buildingNamePss;

    @Column(name = "house_name_ward_no_div_pss")
    private String houseNameWardNoDivPss;

    @Column(name = "area_ward_colony_street_pss")
    private String areaWardColonyStreetPss;

    @Column(name = "village_town_pss")
    private String villageTownPss;

    @Column(name = "pin_code_pss")
    private String pinCodePss;

    @Column(name = "religion_id")
    private Integer religionId;

    @Column(name = "religion")
    private String religion;

    @Column(name = "caste_id")
    private Integer casteId;

    @Column(name = "caste")
    private String caste;

    @Column(name = "sub_caste_id")
    private Integer subCasteId;

    @Column(name = "sub_caste")
    private String subCaste;

    @Column(name = "mother_tongue_id")
    private Integer motherTongueId;

    @Column(name = "mother_tongue")
    private String motherTongue;

    @Column(name = "household_ownership_id")
    private Integer householdOwnershipId;

    @Column(name = "household_ownership")
    private String householdOwnership;

    @Column(name = "education_id")
    private Integer educationId;

    @Column(name = "education")
    private String education;

    @Column(name = "occupation_id")
    private Integer occupationId;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "occupation_category_id")
    private Integer occupationCategoryId;

    @Column(name = "occupation_category")
    private String occupationCategory;

    @Column(name = "martial_status_id")
    private Integer martialStatusId;

    @Column(name = "martial_status")
    private String martialStatus;

    @Column(name = "physicalhandicapped_type_id")
    private Integer physicalhandicappedTypeId;

    @Column(name = "physicalhandicapped_status")
    private String physicalhandicappedStatus;

    @Column(name = "physicalhandicapped_percentage")
    private Integer physicalhandicappedPercentage;

    @Column(name = "voters_card_no")
    private String votersCardNo;

    @Column(name = "kissan_card_available")
    private String kissanCardAvailable;

    @Column(name = "annual_income")
    private String annualIncome;

    @Column(name = "ration_id")
    private String rationId;

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

    @Column(name = "aadhaar_verified")
    private String aadhaarVerified;

    @Column(name = "aadhaar_verified_date")
    private Instant aadhaarVerifiedDate;

    @Column(name = "email_verified")
    private String emailVerified;

    @Column(name = "phone_no_verified")
    private String phoneNoVerified;

    @Column(name = "citizen_active_status")
    private String citizenActiveStatus;

    @Column(name = "source_of_registration_id")
    private Integer sourceOfRegistrationId;

    @Column(name = "source_of_registration")
    private String sourceOfRegistration;

    @Column(name = "sso_id")
    private String ssoId;

    @Column(name = "operator_id")
    private String operatorId;

    @Column(name = "aadhaar_ref_id")
    private Long aadhaarRefId;

    @Column(name = "care_of_adh")
    private String careOfAdh;

    @Column(name = "assisted_mode_operator_id")
    private String assistedModeOperatorId;

    @Column(name = "uid_reference_key_aponline")
    private Long uidReferenceKeyAponline;

    @Column(name = "uid_token")
    private String uidToken;

    @Column(name = "volunteer_secretariat_email_id")
    private String volunteerSecretariatEmailId;

    @Column(name = "volunteer_secretariat_mobile")
    private Long volunteerSecretariatMobile;

    @Column(name = "volunteer_secretariat_id")
    private String volunteerSecretariatId;

    @OneToOne(mappedBy = "personId")
    @JsonIgnore
    private MdmEmployeeMaster personId;

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

    public MdmCitizenData syspk(Long syspk) {
        this.syspk = syspk;
        return this;
    }

    public void setSyspk(Long syspk) {
        this.syspk = syspk;
    }

    public String getPersonId() {
        return personId;
    }

    public MdmCitizenData personId(String personId) {
        this.personId = personId;
        return this;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Long getTempRefId() {
        return tempRefId;
    }

    public MdmCitizenData tempRefId(Long tempRefId) {
        this.tempRefId = tempRefId;
        return this;
    }

    public void setTempRefId(Long tempRefId) {
        this.tempRefId = tempRefId;
    }

    public String getName() {
        return name;
    }

    public MdmCitizenData name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public MdmCitizenData emailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public MdmCitizenData mobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public MdmCitizenData dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public MdmCitizenData genderId(Integer genderId) {
        this.genderId = genderId;
        return this;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getGender() {
        return gender;
    }

    public MdmCitizenData gender(String gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHouseNumberAdh() {
        return houseNumberAdh;
    }

    public MdmCitizenData houseNumberAdh(String houseNumberAdh) {
        this.houseNumberAdh = houseNumberAdh;
        return this;
    }

    public void setHouseNumberAdh(String houseNumberAdh) {
        this.houseNumberAdh = houseNumberAdh;
    }

    public String getStreetAdh() {
        return streetAdh;
    }

    public MdmCitizenData streetAdh(String streetAdh) {
        this.streetAdh = streetAdh;
        return this;
    }

    public void setStreetAdh(String streetAdh) {
        this.streetAdh = streetAdh;
    }

    public String getVillageAdh() {
        return villageAdh;
    }

    public MdmCitizenData villageAdh(String villageAdh) {
        this.villageAdh = villageAdh;
        return this;
    }

    public void setVillageAdh(String villageAdh) {
        this.villageAdh = villageAdh;
    }

    public String getDistrictNameAh() {
        return districtNameAh;
    }

    public MdmCitizenData districtNameAh(String districtNameAh) {
        this.districtNameAh = districtNameAh;
        return this;
    }

    public void setDistrictNameAh(String districtNameAh) {
        this.districtNameAh = districtNameAh;
    }

    public String getSubDistrictNameAdh() {
        return subDistrictNameAdh;
    }

    public MdmCitizenData subDistrictNameAdh(String subDistrictNameAdh) {
        this.subDistrictNameAdh = subDistrictNameAdh;
        return this;
    }

    public void setSubDistrictNameAdh(String subDistrictNameAdh) {
        this.subDistrictNameAdh = subDistrictNameAdh;
    }

    public String getPostOfficeAdh() {
        return postOfficeAdh;
    }

    public MdmCitizenData postOfficeAdh(String postOfficeAdh) {
        this.postOfficeAdh = postOfficeAdh;
        return this;
    }

    public void setPostOfficeAdh(String postOfficeAdh) {
        this.postOfficeAdh = postOfficeAdh;
    }

    public String getStateNameAdh() {
        return stateNameAdh;
    }

    public MdmCitizenData stateNameAdh(String stateNameAdh) {
        this.stateNameAdh = stateNameAdh;
        return this;
    }

    public void setStateNameAdh(String stateNameAdh) {
        this.stateNameAdh = stateNameAdh;
    }

    public String getPinCodeAdh() {
        return pinCodeAdh;
    }

    public MdmCitizenData pinCodeAdh(String pinCodeAdh) {
        this.pinCodeAdh = pinCodeAdh;
        return this;
    }

    public void setPinCodeAdh(String pinCodeAdh) {
        this.pinCodeAdh = pinCodeAdh;
    }

    public Integer getDistrictCodePss() {
        return districtCodePss;
    }

    public MdmCitizenData districtCodePss(Integer districtCodePss) {
        this.districtCodePss = districtCodePss;
        return this;
    }

    public void setDistrictCodePss(Integer districtCodePss) {
        this.districtCodePss = districtCodePss;
    }

    public String getDistrictNamePss() {
        return districtNamePss;
    }

    public MdmCitizenData districtNamePss(String districtNamePss) {
        this.districtNamePss = districtNamePss;
        return this;
    }

    public void setDistrictNamePss(String districtNamePss) {
        this.districtNamePss = districtNamePss;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public MdmCitizenData districtCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getMandalCode() {
        return mandalCode;
    }

    public MdmCitizenData mandalCode(String mandalCode) {
        this.mandalCode = mandalCode;
        return this;
    }

    public void setMandalCode(String mandalCode) {
        this.mandalCode = mandalCode;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public MdmCitizenData villageCode(String villageCode) {
        this.villageCode = villageCode;
        return this;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public MdmCitizenData districtName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getMandalName() {
        return mandalName;
    }

    public MdmCitizenData mandalName(String mandalName) {
        this.mandalName = mandalName;
        return this;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public String getVillageName() {
        return villageName;
    }

    public MdmCitizenData villageName(String villageName) {
        this.villageName = villageName;
        return this;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getHouseHoldId() {
        return houseHoldId;
    }

    public MdmCitizenData houseHoldId(String houseHoldId) {
        this.houseHoldId = houseHoldId;
        return this;
    }

    public void setHouseHoldId(String houseHoldId) {
        this.houseHoldId = houseHoldId;
    }

    public String getRelationshipWithHoh() {
        return relationshipWithHoh;
    }

    public MdmCitizenData relationshipWithHoh(String relationshipWithHoh) {
        this.relationshipWithHoh = relationshipWithHoh;
        return this;
    }

    public void setRelationshipWithHoh(String relationshipWithHoh) {
        this.relationshipWithHoh = relationshipWithHoh;
    }

    public String getBuildingNamePss() {
        return buildingNamePss;
    }

    public MdmCitizenData buildingNamePss(String buildingNamePss) {
        this.buildingNamePss = buildingNamePss;
        return this;
    }

    public void setBuildingNamePss(String buildingNamePss) {
        this.buildingNamePss = buildingNamePss;
    }

    public String getHouseNameWardNoDivPss() {
        return houseNameWardNoDivPss;
    }

    public MdmCitizenData houseNameWardNoDivPss(String houseNameWardNoDivPss) {
        this.houseNameWardNoDivPss = houseNameWardNoDivPss;
        return this;
    }

    public void setHouseNameWardNoDivPss(String houseNameWardNoDivPss) {
        this.houseNameWardNoDivPss = houseNameWardNoDivPss;
    }

    public String getAreaWardColonyStreetPss() {
        return areaWardColonyStreetPss;
    }

    public MdmCitizenData areaWardColonyStreetPss(String areaWardColonyStreetPss) {
        this.areaWardColonyStreetPss = areaWardColonyStreetPss;
        return this;
    }

    public void setAreaWardColonyStreetPss(String areaWardColonyStreetPss) {
        this.areaWardColonyStreetPss = areaWardColonyStreetPss;
    }

    public String getVillageTownPss() {
        return villageTownPss;
    }

    public MdmCitizenData villageTownPss(String villageTownPss) {
        this.villageTownPss = villageTownPss;
        return this;
    }

    public void setVillageTownPss(String villageTownPss) {
        this.villageTownPss = villageTownPss;
    }

    public String getPinCodePss() {
        return pinCodePss;
    }

    public MdmCitizenData pinCodePss(String pinCodePss) {
        this.pinCodePss = pinCodePss;
        return this;
    }

    public void setPinCodePss(String pinCodePss) {
        this.pinCodePss = pinCodePss;
    }

    public Integer getReligionId() {
        return religionId;
    }

    public MdmCitizenData religionId(Integer religionId) {
        this.religionId = religionId;
        return this;
    }

    public void setReligionId(Integer religionId) {
        this.religionId = religionId;
    }

    public String getReligion() {
        return religion;
    }

    public MdmCitizenData religion(String religion) {
        this.religion = religion;
        return this;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Integer getCasteId() {
        return casteId;
    }

    public MdmCitizenData casteId(Integer casteId) {
        this.casteId = casteId;
        return this;
    }

    public void setCasteId(Integer casteId) {
        this.casteId = casteId;
    }

    public String getCaste() {
        return caste;
    }

    public MdmCitizenData caste(String caste) {
        this.caste = caste;
        return this;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public Integer getSubCasteId() {
        return subCasteId;
    }

    public MdmCitizenData subCasteId(Integer subCasteId) {
        this.subCasteId = subCasteId;
        return this;
    }

    public void setSubCasteId(Integer subCasteId) {
        this.subCasteId = subCasteId;
    }

    public String getSubCaste() {
        return subCaste;
    }

    public MdmCitizenData subCaste(String subCaste) {
        this.subCaste = subCaste;
        return this;
    }

    public void setSubCaste(String subCaste) {
        this.subCaste = subCaste;
    }

    public Integer getMotherTongueId() {
        return motherTongueId;
    }

    public MdmCitizenData motherTongueId(Integer motherTongueId) {
        this.motherTongueId = motherTongueId;
        return this;
    }

    public void setMotherTongueId(Integer motherTongueId) {
        this.motherTongueId = motherTongueId;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public MdmCitizenData motherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
        return this;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public Integer getHouseholdOwnershipId() {
        return householdOwnershipId;
    }

    public MdmCitizenData householdOwnershipId(Integer householdOwnershipId) {
        this.householdOwnershipId = householdOwnershipId;
        return this;
    }

    public void setHouseholdOwnershipId(Integer householdOwnershipId) {
        this.householdOwnershipId = householdOwnershipId;
    }

    public String getHouseholdOwnership() {
        return householdOwnership;
    }

    public MdmCitizenData householdOwnership(String householdOwnership) {
        this.householdOwnership = householdOwnership;
        return this;
    }

    public void setHouseholdOwnership(String householdOwnership) {
        this.householdOwnership = householdOwnership;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public MdmCitizenData educationId(Integer educationId) {
        this.educationId = educationId;
        return this;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getEducation() {
        return education;
    }

    public MdmCitizenData education(String education) {
        this.education = education;
        return this;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getOccupationId() {
        return occupationId;
    }

    public MdmCitizenData occupationId(Integer occupationId) {
        this.occupationId = occupationId;
        return this;
    }

    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    public String getOccupation() {
        return occupation;
    }

    public MdmCitizenData occupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getOccupationCategoryId() {
        return occupationCategoryId;
    }

    public MdmCitizenData occupationCategoryId(Integer occupationCategoryId) {
        this.occupationCategoryId = occupationCategoryId;
        return this;
    }

    public void setOccupationCategoryId(Integer occupationCategoryId) {
        this.occupationCategoryId = occupationCategoryId;
    }

    public String getOccupationCategory() {
        return occupationCategory;
    }

    public MdmCitizenData occupationCategory(String occupationCategory) {
        this.occupationCategory = occupationCategory;
        return this;
    }

    public void setOccupationCategory(String occupationCategory) {
        this.occupationCategory = occupationCategory;
    }

    public Integer getMartialStatusId() {
        return martialStatusId;
    }

    public MdmCitizenData martialStatusId(Integer martialStatusId) {
        this.martialStatusId = martialStatusId;
        return this;
    }

    public void setMartialStatusId(Integer martialStatusId) {
        this.martialStatusId = martialStatusId;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public MdmCitizenData martialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
        return this;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public Integer getPhysicalhandicappedTypeId() {
        return physicalhandicappedTypeId;
    }

    public MdmCitizenData physicalhandicappedTypeId(Integer physicalhandicappedTypeId) {
        this.physicalhandicappedTypeId = physicalhandicappedTypeId;
        return this;
    }

    public void setPhysicalhandicappedTypeId(Integer physicalhandicappedTypeId) {
        this.physicalhandicappedTypeId = physicalhandicappedTypeId;
    }

    public String getPhysicalhandicappedStatus() {
        return physicalhandicappedStatus;
    }

    public MdmCitizenData physicalhandicappedStatus(String physicalhandicappedStatus) {
        this.physicalhandicappedStatus = physicalhandicappedStatus;
        return this;
    }

    public void setPhysicalhandicappedStatus(String physicalhandicappedStatus) {
        this.physicalhandicappedStatus = physicalhandicappedStatus;
    }

    public Integer getPhysicalhandicappedPercentage() {
        return physicalhandicappedPercentage;
    }

    public MdmCitizenData physicalhandicappedPercentage(Integer physicalhandicappedPercentage) {
        this.physicalhandicappedPercentage = physicalhandicappedPercentage;
        return this;
    }

    public void setPhysicalhandicappedPercentage(Integer physicalhandicappedPercentage) {
        this.physicalhandicappedPercentage = physicalhandicappedPercentage;
    }

    public String getVotersCardNo() {
        return votersCardNo;
    }

    public MdmCitizenData votersCardNo(String votersCardNo) {
        this.votersCardNo = votersCardNo;
        return this;
    }

    public void setVotersCardNo(String votersCardNo) {
        this.votersCardNo = votersCardNo;
    }

    public String getKissanCardAvailable() {
        return kissanCardAvailable;
    }

    public MdmCitizenData kissanCardAvailable(String kissanCardAvailable) {
        this.kissanCardAvailable = kissanCardAvailable;
        return this;
    }

    public void setKissanCardAvailable(String kissanCardAvailable) {
        this.kissanCardAvailable = kissanCardAvailable;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public MdmCitizenData annualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
        return this;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getRationId() {
        return rationId;
    }

    public MdmCitizenData rationId(String rationId) {
        this.rationId = rationId;
        return this;
    }

    public void setRationId(String rationId) {
        this.rationId = rationId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MdmCitizenData createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MdmCitizenData updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getRecordInsertTime() {
        return recordInsertTime;
    }

    public MdmCitizenData recordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
        return this;
    }

    public void setRecordInsertTime(Instant recordInsertTime) {
        this.recordInsertTime = recordInsertTime;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public MdmCitizenData createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public MdmCitizenData updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public String getAadhaarVerified() {
        return aadhaarVerified;
    }

    public MdmCitizenData aadhaarVerified(String aadhaarVerified) {
        this.aadhaarVerified = aadhaarVerified;
        return this;
    }

    public void setAadhaarVerified(String aadhaarVerified) {
        this.aadhaarVerified = aadhaarVerified;
    }

    public Instant getAadhaarVerifiedDate() {
        return aadhaarVerifiedDate;
    }

    public MdmCitizenData aadhaarVerifiedDate(Instant aadhaarVerifiedDate) {
        this.aadhaarVerifiedDate = aadhaarVerifiedDate;
        return this;
    }

    public void setAadhaarVerifiedDate(Instant aadhaarVerifiedDate) {
        this.aadhaarVerifiedDate = aadhaarVerifiedDate;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public MdmCitizenData emailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
        return this;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getPhoneNoVerified() {
        return phoneNoVerified;
    }

    public MdmCitizenData phoneNoVerified(String phoneNoVerified) {
        this.phoneNoVerified = phoneNoVerified;
        return this;
    }

    public void setPhoneNoVerified(String phoneNoVerified) {
        this.phoneNoVerified = phoneNoVerified;
    }

    public String getCitizenActiveStatus() {
        return citizenActiveStatus;
    }

    public MdmCitizenData citizenActiveStatus(String citizenActiveStatus) {
        this.citizenActiveStatus = citizenActiveStatus;
        return this;
    }

    public void setCitizenActiveStatus(String citizenActiveStatus) {
        this.citizenActiveStatus = citizenActiveStatus;
    }

    public Integer getSourceOfRegistrationId() {
        return sourceOfRegistrationId;
    }

    public MdmCitizenData sourceOfRegistrationId(Integer sourceOfRegistrationId) {
        this.sourceOfRegistrationId = sourceOfRegistrationId;
        return this;
    }

    public void setSourceOfRegistrationId(Integer sourceOfRegistrationId) {
        this.sourceOfRegistrationId = sourceOfRegistrationId;
    }

    public String getSourceOfRegistration() {
        return sourceOfRegistration;
    }

    public MdmCitizenData sourceOfRegistration(String sourceOfRegistration) {
        this.sourceOfRegistration = sourceOfRegistration;
        return this;
    }

    public void setSourceOfRegistration(String sourceOfRegistration) {
        this.sourceOfRegistration = sourceOfRegistration;
    }

    public String getSsoId() {
        return ssoId;
    }

    public MdmCitizenData ssoId(String ssoId) {
        this.ssoId = ssoId;
        return this;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public MdmCitizenData operatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Long getAadhaarRefId() {
        return aadhaarRefId;
    }

    public MdmCitizenData aadhaarRefId(Long aadhaarRefId) {
        this.aadhaarRefId = aadhaarRefId;
        return this;
    }

    public void setAadhaarRefId(Long aadhaarRefId) {
        this.aadhaarRefId = aadhaarRefId;
    }

    public String getCareOfAdh() {
        return careOfAdh;
    }

    public MdmCitizenData careOfAdh(String careOfAdh) {
        this.careOfAdh = careOfAdh;
        return this;
    }

    public void setCareOfAdh(String careOfAdh) {
        this.careOfAdh = careOfAdh;
    }

    public String getAssistedModeOperatorId() {
        return assistedModeOperatorId;
    }

    public MdmCitizenData assistedModeOperatorId(String assistedModeOperatorId) {
        this.assistedModeOperatorId = assistedModeOperatorId;
        return this;
    }

    public void setAssistedModeOperatorId(String assistedModeOperatorId) {
        this.assistedModeOperatorId = assistedModeOperatorId;
    }

    public Long getUidReferenceKeyAponline() {
        return uidReferenceKeyAponline;
    }

    public MdmCitizenData uidReferenceKeyAponline(Long uidReferenceKeyAponline) {
        this.uidReferenceKeyAponline = uidReferenceKeyAponline;
        return this;
    }

    public void setUidReferenceKeyAponline(Long uidReferenceKeyAponline) {
        this.uidReferenceKeyAponline = uidReferenceKeyAponline;
    }

    public String getUidToken() {
        return uidToken;
    }

    public MdmCitizenData uidToken(String uidToken) {
        this.uidToken = uidToken;
        return this;
    }

    public void setUidToken(String uidToken) {
        this.uidToken = uidToken;
    }

    public String getVolunteerSecretariatEmailId() {
        return volunteerSecretariatEmailId;
    }

    public MdmCitizenData volunteerSecretariatEmailId(String volunteerSecretariatEmailId) {
        this.volunteerSecretariatEmailId = volunteerSecretariatEmailId;
        return this;
    }

    public void setVolunteerSecretariatEmailId(String volunteerSecretariatEmailId) {
        this.volunteerSecretariatEmailId = volunteerSecretariatEmailId;
    }

    public Long getVolunteerSecretariatMobile() {
        return volunteerSecretariatMobile;
    }

    public MdmCitizenData volunteerSecretariatMobile(Long volunteerSecretariatMobile) {
        this.volunteerSecretariatMobile = volunteerSecretariatMobile;
        return this;
    }

    public void setVolunteerSecretariatMobile(Long volunteerSecretariatMobile) {
        this.volunteerSecretariatMobile = volunteerSecretariatMobile;
    }

    public String getVolunteerSecretariatId() {
        return volunteerSecretariatId;
    }

    public MdmCitizenData volunteerSecretariatId(String volunteerSecretariatId) {
        this.volunteerSecretariatId = volunteerSecretariatId;
        return this;
    }

    public void setVolunteerSecretariatId(String volunteerSecretariatId) {
        this.volunteerSecretariatId = volunteerSecretariatId;
    }

    public MdmEmployeeMaster getPersonId() {
        return personId;
    }

    public MdmCitizenData personId(MdmEmployeeMaster mdmEmployeeMaster) {
        this.personId = mdmEmployeeMaster;
        return this;
    }

    public void setPersonId(MdmEmployeeMaster mdmEmployeeMaster) {
        this.personId = mdmEmployeeMaster;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MdmCitizenData)) {
            return false;
        }
        return id != null && id.equals(((MdmCitizenData) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdmCitizenData{" +
            "id=" + getId() +
            ", syspk=" + getSyspk() +
            ", personId='" + getPersonId() + "'" +
            ", tempRefId=" + getTempRefId() +
            ", name='" + getName() + "'" +
            ", emailId='" + getEmailId() + "'" +
            ", mobileNumber=" + getMobileNumber() +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", genderId=" + getGenderId() +
            ", gender='" + getGender() + "'" +
            ", houseNumberAdh='" + getHouseNumberAdh() + "'" +
            ", streetAdh='" + getStreetAdh() + "'" +
            ", villageAdh='" + getVillageAdh() + "'" +
            ", districtNameAh='" + getDistrictNameAh() + "'" +
            ", subDistrictNameAdh='" + getSubDistrictNameAdh() + "'" +
            ", postOfficeAdh='" + getPostOfficeAdh() + "'" +
            ", stateNameAdh='" + getStateNameAdh() + "'" +
            ", pinCodeAdh='" + getPinCodeAdh() + "'" +
            ", districtCodePss=" + getDistrictCodePss() +
            ", districtNamePss='" + getDistrictNamePss() + "'" +
            ", districtCode='" + getDistrictCode() + "'" +
            ", mandalCode='" + getMandalCode() + "'" +
            ", villageCode='" + getVillageCode() + "'" +
            ", districtName='" + getDistrictName() + "'" +
            ", mandalName='" + getMandalName() + "'" +
            ", villageName='" + getVillageName() + "'" +
            ", houseHoldId='" + getHouseHoldId() + "'" +
            ", relationshipWithHoh='" + getRelationshipWithHoh() + "'" +
            ", buildingNamePss='" + getBuildingNamePss() + "'" +
            ", houseNameWardNoDivPss='" + getHouseNameWardNoDivPss() + "'" +
            ", areaWardColonyStreetPss='" + getAreaWardColonyStreetPss() + "'" +
            ", villageTownPss='" + getVillageTownPss() + "'" +
            ", pinCodePss='" + getPinCodePss() + "'" +
            ", religionId=" + getReligionId() +
            ", religion='" + getReligion() + "'" +
            ", casteId=" + getCasteId() +
            ", caste='" + getCaste() + "'" +
            ", subCasteId=" + getSubCasteId() +
            ", subCaste='" + getSubCaste() + "'" +
            ", motherTongueId=" + getMotherTongueId() +
            ", motherTongue='" + getMotherTongue() + "'" +
            ", householdOwnershipId=" + getHouseholdOwnershipId() +
            ", householdOwnership='" + getHouseholdOwnership() + "'" +
            ", educationId=" + getEducationId() +
            ", education='" + getEducation() + "'" +
            ", occupationId=" + getOccupationId() +
            ", occupation='" + getOccupation() + "'" +
            ", occupationCategoryId=" + getOccupationCategoryId() +
            ", occupationCategory='" + getOccupationCategory() + "'" +
            ", martialStatusId=" + getMartialStatusId() +
            ", martialStatus='" + getMartialStatus() + "'" +
            ", physicalhandicappedTypeId=" + getPhysicalhandicappedTypeId() +
            ", physicalhandicappedStatus='" + getPhysicalhandicappedStatus() + "'" +
            ", physicalhandicappedPercentage=" + getPhysicalhandicappedPercentage() +
            ", votersCardNo='" + getVotersCardNo() + "'" +
            ", kissanCardAvailable='" + getKissanCardAvailable() + "'" +
            ", annualIncome='" + getAnnualIncome() + "'" +
            ", rationId='" + getRationId() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", recordInsertTime='" + getRecordInsertTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", aadhaarVerified='" + getAadhaarVerified() + "'" +
            ", aadhaarVerifiedDate='" + getAadhaarVerifiedDate() + "'" +
            ", emailVerified='" + getEmailVerified() + "'" +
            ", phoneNoVerified='" + getPhoneNoVerified() + "'" +
            ", citizenActiveStatus='" + getCitizenActiveStatus() + "'" +
            ", sourceOfRegistrationId=" + getSourceOfRegistrationId() +
            ", sourceOfRegistration='" + getSourceOfRegistration() + "'" +
            ", ssoId='" + getSsoId() + "'" +
            ", operatorId='" + getOperatorId() + "'" +
            ", aadhaarRefId=" + getAadhaarRefId() +
            ", careOfAdh='" + getCareOfAdh() + "'" +
            ", assistedModeOperatorId='" + getAssistedModeOperatorId() + "'" +
            ", uidReferenceKeyAponline=" + getUidReferenceKeyAponline() +
            ", uidToken='" + getUidToken() + "'" +
            ", volunteerSecretariatEmailId='" + getVolunteerSecretariatEmailId() + "'" +
            ", volunteerSecretariatMobile=" + getVolunteerSecretariatMobile() +
            ", volunteerSecretariatId='" + getVolunteerSecretariatId() + "'" +
            "}";
    }
}
