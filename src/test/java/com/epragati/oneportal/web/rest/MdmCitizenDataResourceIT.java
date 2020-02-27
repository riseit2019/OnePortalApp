package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.OnePortalApp;
import com.epragati.oneportal.domain.MdmCitizenData;
import com.epragati.oneportal.repository.MdmCitizenDataRepository;
import com.epragati.oneportal.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.epragati.oneportal.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link MdmCitizenDataResource} REST controller.
 */
@SpringBootTest(classes = OnePortalApp.class)
public class MdmCitizenDataResourceIT {

    private static final Long DEFAULT_SYSPK = 1L;
    private static final Long UPDATED_SYSPK = 2L;

    private static final Long DEFAULT_TEMP_REF_ID = 1L;
    private static final Long UPDATED_TEMP_REF_ID = 2L;

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_ID = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_ID = "BBBBBBBBBB";

    private static final Long DEFAULT_MOBILE_NUMBER = 1L;
    private static final Long UPDATED_MOBILE_NUMBER = 2L;

    private static final LocalDate DEFAULT_DATE_OF_BIRTH = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_OF_BIRTH = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_GENDER_ID = 1;
    private static final Integer UPDATED_GENDER_ID = 2;

    private static final String DEFAULT_GENDER = "AAAAAAAAAA";
    private static final String UPDATED_GENDER = "BBBBBBBBBB";

    private static final String DEFAULT_HOUSE_NUMBER_ADH = "AAAAAAAAAA";
    private static final String UPDATED_HOUSE_NUMBER_ADH = "BBBBBBBBBB";

    private static final String DEFAULT_STREET_ADH = "AAAAAAAAAA";
    private static final String UPDATED_STREET_ADH = "BBBBBBBBBB";

    private static final String DEFAULT_VILLAGE_ADH = "AAAAAAAAAA";
    private static final String UPDATED_VILLAGE_ADH = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRICT_NAME_AH = "AAAAAAAAAA";
    private static final String UPDATED_DISTRICT_NAME_AH = "BBBBBBBBBB";

    private static final String DEFAULT_SUB_DISTRICT_NAME_ADH = "AAAAAAAAAA";
    private static final String UPDATED_SUB_DISTRICT_NAME_ADH = "BBBBBBBBBB";

    private static final String DEFAULT_POST_OFFICE_ADH = "AAAAAAAAAA";
    private static final String UPDATED_POST_OFFICE_ADH = "BBBBBBBBBB";

    private static final String DEFAULT_STATE_NAME_ADH = "AAAAAAAAAA";
    private static final String UPDATED_STATE_NAME_ADH = "BBBBBBBBBB";

    private static final String DEFAULT_PIN_CODE_ADH = "AAAAAAAAAA";
    private static final String UPDATED_PIN_CODE_ADH = "BBBBBBBBBB";

    private static final Integer DEFAULT_DISTRICT_CODE_PSS = 1;
    private static final Integer UPDATED_DISTRICT_CODE_PSS = 2;

    private static final String DEFAULT_DISTRICT_NAME_PSS = "AAAAAAAAAA";
    private static final String UPDATED_DISTRICT_NAME_PSS = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRICT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DISTRICT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MANDAL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MANDAL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_VILLAGE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_VILLAGE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRICT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DISTRICT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_MANDAL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MANDAL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_VILLAGE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_VILLAGE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_HOUSE_HOLD_ID = "AAAAAAAAAA";
    private static final String UPDATED_HOUSE_HOLD_ID = "BBBBBBBBBB";

    private static final String DEFAULT_RELATIONSHIP_WITH_HOH = "AAAAAAAAAA";
    private static final String UPDATED_RELATIONSHIP_WITH_HOH = "BBBBBBBBBB";

    private static final String DEFAULT_BUILDING_NAME_PSS = "AAAAAAAAAA";
    private static final String UPDATED_BUILDING_NAME_PSS = "BBBBBBBBBB";

    private static final String DEFAULT_HOUSE_NAME_WARD_NO_DIV_PSS = "AAAAAAAAAA";
    private static final String UPDATED_HOUSE_NAME_WARD_NO_DIV_PSS = "BBBBBBBBBB";

    private static final String DEFAULT_AREA_WARD_COLONY_STREET_PSS = "AAAAAAAAAA";
    private static final String UPDATED_AREA_WARD_COLONY_STREET_PSS = "BBBBBBBBBB";

    private static final String DEFAULT_VILLAGE_TOWN_PSS = "AAAAAAAAAA";
    private static final String UPDATED_VILLAGE_TOWN_PSS = "BBBBBBBBBB";

    private static final String DEFAULT_PIN_CODE_PSS = "AAAAAAAAAA";
    private static final String UPDATED_PIN_CODE_PSS = "BBBBBBBBBB";

    private static final Integer DEFAULT_RELIGION_ID = 1;
    private static final Integer UPDATED_RELIGION_ID = 2;

    private static final String DEFAULT_RELIGION = "AAAAAAAAAA";
    private static final String UPDATED_RELIGION = "BBBBBBBBBB";

    private static final Integer DEFAULT_CASTE_ID = 1;
    private static final Integer UPDATED_CASTE_ID = 2;

    private static final String DEFAULT_CASTE = "AAAAAAAAAA";
    private static final String UPDATED_CASTE = "BBBBBBBBBB";

    private static final Integer DEFAULT_SUB_CASTE_ID = 1;
    private static final Integer UPDATED_SUB_CASTE_ID = 2;

    private static final String DEFAULT_SUB_CASTE = "AAAAAAAAAA";
    private static final String UPDATED_SUB_CASTE = "BBBBBBBBBB";

    private static final Integer DEFAULT_MOTHER_TONGUE_ID = 1;
    private static final Integer UPDATED_MOTHER_TONGUE_ID = 2;

    private static final String DEFAULT_MOTHER_TONGUE = "AAAAAAAAAA";
    private static final String UPDATED_MOTHER_TONGUE = "BBBBBBBBBB";

    private static final Integer DEFAULT_HOUSEHOLD_OWNERSHIP_ID = 1;
    private static final Integer UPDATED_HOUSEHOLD_OWNERSHIP_ID = 2;

    private static final String DEFAULT_HOUSEHOLD_OWNERSHIP = "AAAAAAAAAA";
    private static final String UPDATED_HOUSEHOLD_OWNERSHIP = "BBBBBBBBBB";

    private static final Integer DEFAULT_EDUCATION_ID = 1;
    private static final Integer UPDATED_EDUCATION_ID = 2;

    private static final String DEFAULT_EDUCATION = "AAAAAAAAAA";
    private static final String UPDATED_EDUCATION = "BBBBBBBBBB";

    private static final Integer DEFAULT_OCCUPATION_ID = 1;
    private static final Integer UPDATED_OCCUPATION_ID = 2;

    private static final String DEFAULT_OCCUPATION = "AAAAAAAAAA";
    private static final String UPDATED_OCCUPATION = "BBBBBBBBBB";

    private static final Integer DEFAULT_OCCUPATION_CATEGORY_ID = 1;
    private static final Integer UPDATED_OCCUPATION_CATEGORY_ID = 2;

    private static final String DEFAULT_OCCUPATION_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_OCCUPATION_CATEGORY = "BBBBBBBBBB";

    private static final Integer DEFAULT_MARTIAL_STATUS_ID = 1;
    private static final Integer UPDATED_MARTIAL_STATUS_ID = 2;

    private static final String DEFAULT_MARTIAL_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_MARTIAL_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_PHYSICALHANDICAPPED_TYPE_ID = 1;
    private static final Integer UPDATED_PHYSICALHANDICAPPED_TYPE_ID = 2;

    private static final String DEFAULT_PHYSICALHANDICAPPED_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_PHYSICALHANDICAPPED_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_PHYSICALHANDICAPPED_PERCENTAGE = 1;
    private static final Integer UPDATED_PHYSICALHANDICAPPED_PERCENTAGE = 2;

    private static final String DEFAULT_VOTERS_CARD_NO = "AAAAAAAAAA";
    private static final String UPDATED_VOTERS_CARD_NO = "BBBBBBBBBB";

    private static final String DEFAULT_KISSAN_CARD_AVAILABLE = "AAAAAAAAAA";
    private static final String UPDATED_KISSAN_CARD_AVAILABLE = "BBBBBBBBBB";

    private static final String DEFAULT_ANNUAL_INCOME = "AAAAAAAAAA";
    private static final String UPDATED_ANNUAL_INCOME = "BBBBBBBBBB";

    private static final String DEFAULT_RATION_ID = "AAAAAAAAAA";
    private static final String UPDATED_RATION_ID = "BBBBBBBBBB";

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final String DEFAULT_UPDATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_RECORD_INSERT_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_RECORD_INSERT_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_CREATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_AADHAAR_VERIFIED = "AAAAAAAAAA";
    private static final String UPDATED_AADHAAR_VERIFIED = "BBBBBBBBBB";

    private static final Instant DEFAULT_AADHAAR_VERIFIED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_AADHAAR_VERIFIED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_EMAIL_VERIFIED = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_VERIFIED = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NO_VERIFIED = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NO_VERIFIED = "BBBBBBBBBB";

    private static final String DEFAULT_CITIZEN_ACTIVE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_CITIZEN_ACTIVE_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_SOURCE_OF_REGISTRATION_ID = 1;
    private static final Integer UPDATED_SOURCE_OF_REGISTRATION_ID = 2;

    private static final String DEFAULT_SOURCE_OF_REGISTRATION = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_OF_REGISTRATION = "BBBBBBBBBB";

    private static final String DEFAULT_SSO_ID = "AAAAAAAAAA";
    private static final String UPDATED_SSO_ID = "BBBBBBBBBB";

    private static final String DEFAULT_OPERATOR_ID = "AAAAAAAAAA";
    private static final String UPDATED_OPERATOR_ID = "BBBBBBBBBB";

    private static final Long DEFAULT_AADHAAR_REF_ID = 1L;
    private static final Long UPDATED_AADHAAR_REF_ID = 2L;

    private static final String DEFAULT_CARE_OF_ADH = "AAAAAAAAAA";
    private static final String UPDATED_CARE_OF_ADH = "BBBBBBBBBB";

    private static final String DEFAULT_ASSISTED_MODE_OPERATOR_ID = "AAAAAAAAAA";
    private static final String UPDATED_ASSISTED_MODE_OPERATOR_ID = "BBBBBBBBBB";

    private static final Long DEFAULT_UID_REFERENCE_KEY_APONLINE = 1L;
    private static final Long UPDATED_UID_REFERENCE_KEY_APONLINE = 2L;

    private static final String DEFAULT_UID_TOKEN = "AAAAAAAAAA";
    private static final String UPDATED_UID_TOKEN = "BBBBBBBBBB";

    private static final String DEFAULT_VOLUNTEER_SECRETARIAT_EMAIL_ID = "AAAAAAAAAA";
    private static final String UPDATED_VOLUNTEER_SECRETARIAT_EMAIL_ID = "BBBBBBBBBB";

    private static final Long DEFAULT_VOLUNTEER_SECRETARIAT_MOBILE = 1L;
    private static final Long UPDATED_VOLUNTEER_SECRETARIAT_MOBILE = 2L;

    private static final String DEFAULT_VOLUNTEER_SECRETARIAT_ID = "AAAAAAAAAA";
    private static final String UPDATED_VOLUNTEER_SECRETARIAT_ID = "BBBBBBBBBB";

    @Autowired
    private MdmCitizenDataRepository mdmCitizenDataRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restMdmCitizenDataMockMvc;

    private MdmCitizenData mdmCitizenData;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdmCitizenDataResource mdmCitizenDataResource = new MdmCitizenDataResource(mdmCitizenDataRepository);
        this.restMdmCitizenDataMockMvc = MockMvcBuilders.standaloneSetup(mdmCitizenDataResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmCitizenData createEntity(EntityManager em) {
        MdmCitizenData mdmCitizenData = new MdmCitizenData()
            .syspk(DEFAULT_SYSPK)
            .tempRefId(DEFAULT_TEMP_REF_ID)
            .name(DEFAULT_NAME)
            .emailId(DEFAULT_EMAIL_ID)
            .mobileNumber(DEFAULT_MOBILE_NUMBER)
            .dateOfBirth(DEFAULT_DATE_OF_BIRTH)
            .genderId(DEFAULT_GENDER_ID)
            .gender(DEFAULT_GENDER)
            .houseNumberAdh(DEFAULT_HOUSE_NUMBER_ADH)
            .streetAdh(DEFAULT_STREET_ADH)
            .villageAdh(DEFAULT_VILLAGE_ADH)
            .districtNameAh(DEFAULT_DISTRICT_NAME_AH)
            .subDistrictNameAdh(DEFAULT_SUB_DISTRICT_NAME_ADH)
            .postOfficeAdh(DEFAULT_POST_OFFICE_ADH)
            .stateNameAdh(DEFAULT_STATE_NAME_ADH)
            .pinCodeAdh(DEFAULT_PIN_CODE_ADH)
            .districtCodePss(DEFAULT_DISTRICT_CODE_PSS)
            .districtNamePss(DEFAULT_DISTRICT_NAME_PSS)
            .districtCode(DEFAULT_DISTRICT_CODE)
            .mandalCode(DEFAULT_MANDAL_CODE)
            .villageCode(DEFAULT_VILLAGE_CODE)
            .districtName(DEFAULT_DISTRICT_NAME)
            .mandalName(DEFAULT_MANDAL_NAME)
            .villageName(DEFAULT_VILLAGE_NAME)
            .houseHoldId(DEFAULT_HOUSE_HOLD_ID)
            .relationshipWithHoh(DEFAULT_RELATIONSHIP_WITH_HOH)
            .buildingNamePss(DEFAULT_BUILDING_NAME_PSS)
            .houseNameWardNoDivPss(DEFAULT_HOUSE_NAME_WARD_NO_DIV_PSS)
            .areaWardColonyStreetPss(DEFAULT_AREA_WARD_COLONY_STREET_PSS)
            .villageTownPss(DEFAULT_VILLAGE_TOWN_PSS)
            .pinCodePss(DEFAULT_PIN_CODE_PSS)
            .religionId(DEFAULT_RELIGION_ID)
            .religion(DEFAULT_RELIGION)
            .casteId(DEFAULT_CASTE_ID)
            .caste(DEFAULT_CASTE)
            .subCasteId(DEFAULT_SUB_CASTE_ID)
            .subCaste(DEFAULT_SUB_CASTE)
            .motherTongueId(DEFAULT_MOTHER_TONGUE_ID)
            .motherTongue(DEFAULT_MOTHER_TONGUE)
            .householdOwnershipId(DEFAULT_HOUSEHOLD_OWNERSHIP_ID)
            .householdOwnership(DEFAULT_HOUSEHOLD_OWNERSHIP)
            .educationId(DEFAULT_EDUCATION_ID)
            .education(DEFAULT_EDUCATION)
            .occupationId(DEFAULT_OCCUPATION_ID)
            .occupation(DEFAULT_OCCUPATION)
            .occupationCategoryId(DEFAULT_OCCUPATION_CATEGORY_ID)
            .occupationCategory(DEFAULT_OCCUPATION_CATEGORY)
            .martialStatusId(DEFAULT_MARTIAL_STATUS_ID)
            .martialStatus(DEFAULT_MARTIAL_STATUS)
            .physicalhandicappedTypeId(DEFAULT_PHYSICALHANDICAPPED_TYPE_ID)
            .physicalhandicappedStatus(DEFAULT_PHYSICALHANDICAPPED_STATUS)
            .physicalhandicappedPercentage(DEFAULT_PHYSICALHANDICAPPED_PERCENTAGE)
            .votersCardNo(DEFAULT_VOTERS_CARD_NO)
            .kissanCardAvailable(DEFAULT_KISSAN_CARD_AVAILABLE)
            .annualIncome(DEFAULT_ANNUAL_INCOME)
            .rationId(DEFAULT_RATION_ID)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedBy(DEFAULT_UPDATED_BY)
            .recordInsertTime(DEFAULT_RECORD_INSERT_TIME)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME)
            .aadhaarVerified(DEFAULT_AADHAAR_VERIFIED)
            .aadhaarVerifiedDate(DEFAULT_AADHAAR_VERIFIED_DATE)
            .emailVerified(DEFAULT_EMAIL_VERIFIED)
            .phoneNoVerified(DEFAULT_PHONE_NO_VERIFIED)
            .citizenActiveStatus(DEFAULT_CITIZEN_ACTIVE_STATUS)
            .sourceOfRegistrationId(DEFAULT_SOURCE_OF_REGISTRATION_ID)
            .sourceOfRegistration(DEFAULT_SOURCE_OF_REGISTRATION)
            .ssoId(DEFAULT_SSO_ID)
            .operatorId(DEFAULT_OPERATOR_ID)
            .aadhaarRefId(DEFAULT_AADHAAR_REF_ID)
            .careOfAdh(DEFAULT_CARE_OF_ADH)
            .assistedModeOperatorId(DEFAULT_ASSISTED_MODE_OPERATOR_ID)
            .uidReferenceKeyAponline(DEFAULT_UID_REFERENCE_KEY_APONLINE)
            .uidToken(DEFAULT_UID_TOKEN)
            .volunteerSecretariatEmailId(DEFAULT_VOLUNTEER_SECRETARIAT_EMAIL_ID)
            .volunteerSecretariatMobile(DEFAULT_VOLUNTEER_SECRETARIAT_MOBILE)
            .volunteerSecretariatId(DEFAULT_VOLUNTEER_SECRETARIAT_ID);
        return mdmCitizenData;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmCitizenData createUpdatedEntity(EntityManager em) {
        MdmCitizenData mdmCitizenData = new MdmCitizenData()
            .syspk(UPDATED_SYSPK)
            .tempRefId(UPDATED_TEMP_REF_ID)
            .name(UPDATED_NAME)
            .emailId(UPDATED_EMAIL_ID)
            .mobileNumber(UPDATED_MOBILE_NUMBER)
            .dateOfBirth(UPDATED_DATE_OF_BIRTH)
            .genderId(UPDATED_GENDER_ID)
            .gender(UPDATED_GENDER)
            .houseNumberAdh(UPDATED_HOUSE_NUMBER_ADH)
            .streetAdh(UPDATED_STREET_ADH)
            .villageAdh(UPDATED_VILLAGE_ADH)
            .districtNameAh(UPDATED_DISTRICT_NAME_AH)
            .subDistrictNameAdh(UPDATED_SUB_DISTRICT_NAME_ADH)
            .postOfficeAdh(UPDATED_POST_OFFICE_ADH)
            .stateNameAdh(UPDATED_STATE_NAME_ADH)
            .pinCodeAdh(UPDATED_PIN_CODE_ADH)
            .districtCodePss(UPDATED_DISTRICT_CODE_PSS)
            .districtNamePss(UPDATED_DISTRICT_NAME_PSS)
            .districtCode(UPDATED_DISTRICT_CODE)
            .mandalCode(UPDATED_MANDAL_CODE)
            .villageCode(UPDATED_VILLAGE_CODE)
            .districtName(UPDATED_DISTRICT_NAME)
            .mandalName(UPDATED_MANDAL_NAME)
            .villageName(UPDATED_VILLAGE_NAME)
            .houseHoldId(UPDATED_HOUSE_HOLD_ID)
            .relationshipWithHoh(UPDATED_RELATIONSHIP_WITH_HOH)
            .buildingNamePss(UPDATED_BUILDING_NAME_PSS)
            .houseNameWardNoDivPss(UPDATED_HOUSE_NAME_WARD_NO_DIV_PSS)
            .areaWardColonyStreetPss(UPDATED_AREA_WARD_COLONY_STREET_PSS)
            .villageTownPss(UPDATED_VILLAGE_TOWN_PSS)
            .pinCodePss(UPDATED_PIN_CODE_PSS)
            .religionId(UPDATED_RELIGION_ID)
            .religion(UPDATED_RELIGION)
            .casteId(UPDATED_CASTE_ID)
            .caste(UPDATED_CASTE)
            .subCasteId(UPDATED_SUB_CASTE_ID)
            .subCaste(UPDATED_SUB_CASTE)
            .motherTongueId(UPDATED_MOTHER_TONGUE_ID)
            .motherTongue(UPDATED_MOTHER_TONGUE)
            .householdOwnershipId(UPDATED_HOUSEHOLD_OWNERSHIP_ID)
            .householdOwnership(UPDATED_HOUSEHOLD_OWNERSHIP)
            .educationId(UPDATED_EDUCATION_ID)
            .education(UPDATED_EDUCATION)
            .occupationId(UPDATED_OCCUPATION_ID)
            .occupation(UPDATED_OCCUPATION)
            .occupationCategoryId(UPDATED_OCCUPATION_CATEGORY_ID)
            .occupationCategory(UPDATED_OCCUPATION_CATEGORY)
            .martialStatusId(UPDATED_MARTIAL_STATUS_ID)
            .martialStatus(UPDATED_MARTIAL_STATUS)
            .physicalhandicappedTypeId(UPDATED_PHYSICALHANDICAPPED_TYPE_ID)
            .physicalhandicappedStatus(UPDATED_PHYSICALHANDICAPPED_STATUS)
            .physicalhandicappedPercentage(UPDATED_PHYSICALHANDICAPPED_PERCENTAGE)
            .votersCardNo(UPDATED_VOTERS_CARD_NO)
            .kissanCardAvailable(UPDATED_KISSAN_CARD_AVAILABLE)
            .annualIncome(UPDATED_ANNUAL_INCOME)
            .rationId(UPDATED_RATION_ID)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .aadhaarVerified(UPDATED_AADHAAR_VERIFIED)
            .aadhaarVerifiedDate(UPDATED_AADHAAR_VERIFIED_DATE)
            .emailVerified(UPDATED_EMAIL_VERIFIED)
            .phoneNoVerified(UPDATED_PHONE_NO_VERIFIED)
            .citizenActiveStatus(UPDATED_CITIZEN_ACTIVE_STATUS)
            .sourceOfRegistrationId(UPDATED_SOURCE_OF_REGISTRATION_ID)
            .sourceOfRegistration(UPDATED_SOURCE_OF_REGISTRATION)
            .ssoId(UPDATED_SSO_ID)
            .operatorId(UPDATED_OPERATOR_ID)
            .aadhaarRefId(UPDATED_AADHAAR_REF_ID)
            .careOfAdh(UPDATED_CARE_OF_ADH)
            .assistedModeOperatorId(UPDATED_ASSISTED_MODE_OPERATOR_ID)
            .uidReferenceKeyAponline(UPDATED_UID_REFERENCE_KEY_APONLINE)
            .uidToken(UPDATED_UID_TOKEN)
            .volunteerSecretariatEmailId(UPDATED_VOLUNTEER_SECRETARIAT_EMAIL_ID)
            .volunteerSecretariatMobile(UPDATED_VOLUNTEER_SECRETARIAT_MOBILE)
            .volunteerSecretariatId(UPDATED_VOLUNTEER_SECRETARIAT_ID);
        return mdmCitizenData;
    }

    @BeforeEach
    public void initTest() {
        mdmCitizenData = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdmCitizenData() throws Exception {
        int databaseSizeBeforeCreate = mdmCitizenDataRepository.findAll().size();

        // Create the MdmCitizenData
        restMdmCitizenDataMockMvc.perform(post("/api/mdm-citizen-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmCitizenData)))
            .andExpect(status().isCreated());

        // Validate the MdmCitizenData in the database
        List<MdmCitizenData> mdmCitizenDataList = mdmCitizenDataRepository.findAll();
        assertThat(mdmCitizenDataList).hasSize(databaseSizeBeforeCreate + 1);
        MdmCitizenData testMdmCitizenData = mdmCitizenDataList.get(mdmCitizenDataList.size() - 1);
        assertThat(testMdmCitizenData.getSyspk()).isEqualTo(DEFAULT_SYSPK);
        assertThat(testMdmCitizenData.getTempRefId()).isEqualTo(DEFAULT_TEMP_REF_ID);
        assertThat(testMdmCitizenData.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testMdmCitizenData.getEmailId()).isEqualTo(DEFAULT_EMAIL_ID);
        assertThat(testMdmCitizenData.getMobileNumber()).isEqualTo(DEFAULT_MOBILE_NUMBER);
        assertThat(testMdmCitizenData.getDateOfBirth()).isEqualTo(DEFAULT_DATE_OF_BIRTH);
        assertThat(testMdmCitizenData.getGenderId()).isEqualTo(DEFAULT_GENDER_ID);
        assertThat(testMdmCitizenData.getGender()).isEqualTo(DEFAULT_GENDER);
        assertThat(testMdmCitizenData.getHouseNumberAdh()).isEqualTo(DEFAULT_HOUSE_NUMBER_ADH);
        assertThat(testMdmCitizenData.getStreetAdh()).isEqualTo(DEFAULT_STREET_ADH);
        assertThat(testMdmCitizenData.getVillageAdh()).isEqualTo(DEFAULT_VILLAGE_ADH);
        assertThat(testMdmCitizenData.getDistrictNameAh()).isEqualTo(DEFAULT_DISTRICT_NAME_AH);
        assertThat(testMdmCitizenData.getSubDistrictNameAdh()).isEqualTo(DEFAULT_SUB_DISTRICT_NAME_ADH);
        assertThat(testMdmCitizenData.getPostOfficeAdh()).isEqualTo(DEFAULT_POST_OFFICE_ADH);
        assertThat(testMdmCitizenData.getStateNameAdh()).isEqualTo(DEFAULT_STATE_NAME_ADH);
        assertThat(testMdmCitizenData.getPinCodeAdh()).isEqualTo(DEFAULT_PIN_CODE_ADH);
        assertThat(testMdmCitizenData.getDistrictCodePss()).isEqualTo(DEFAULT_DISTRICT_CODE_PSS);
        assertThat(testMdmCitizenData.getDistrictNamePss()).isEqualTo(DEFAULT_DISTRICT_NAME_PSS);
        assertThat(testMdmCitizenData.getDistrictCode()).isEqualTo(DEFAULT_DISTRICT_CODE);
        assertThat(testMdmCitizenData.getMandalCode()).isEqualTo(DEFAULT_MANDAL_CODE);
        assertThat(testMdmCitizenData.getVillageCode()).isEqualTo(DEFAULT_VILLAGE_CODE);
        assertThat(testMdmCitizenData.getDistrictName()).isEqualTo(DEFAULT_DISTRICT_NAME);
        assertThat(testMdmCitizenData.getMandalName()).isEqualTo(DEFAULT_MANDAL_NAME);
        assertThat(testMdmCitizenData.getVillageName()).isEqualTo(DEFAULT_VILLAGE_NAME);
        assertThat(testMdmCitizenData.getHouseHoldId()).isEqualTo(DEFAULT_HOUSE_HOLD_ID);
        assertThat(testMdmCitizenData.getRelationshipWithHoh()).isEqualTo(DEFAULT_RELATIONSHIP_WITH_HOH);
        assertThat(testMdmCitizenData.getBuildingNamePss()).isEqualTo(DEFAULT_BUILDING_NAME_PSS);
        assertThat(testMdmCitizenData.getHouseNameWardNoDivPss()).isEqualTo(DEFAULT_HOUSE_NAME_WARD_NO_DIV_PSS);
        assertThat(testMdmCitizenData.getAreaWardColonyStreetPss()).isEqualTo(DEFAULT_AREA_WARD_COLONY_STREET_PSS);
        assertThat(testMdmCitizenData.getVillageTownPss()).isEqualTo(DEFAULT_VILLAGE_TOWN_PSS);
        assertThat(testMdmCitizenData.getPinCodePss()).isEqualTo(DEFAULT_PIN_CODE_PSS);
        assertThat(testMdmCitizenData.getReligionId()).isEqualTo(DEFAULT_RELIGION_ID);
        assertThat(testMdmCitizenData.getReligion()).isEqualTo(DEFAULT_RELIGION);
        assertThat(testMdmCitizenData.getCasteId()).isEqualTo(DEFAULT_CASTE_ID);
        assertThat(testMdmCitizenData.getCaste()).isEqualTo(DEFAULT_CASTE);
        assertThat(testMdmCitizenData.getSubCasteId()).isEqualTo(DEFAULT_SUB_CASTE_ID);
        assertThat(testMdmCitizenData.getSubCaste()).isEqualTo(DEFAULT_SUB_CASTE);
        assertThat(testMdmCitizenData.getMotherTongueId()).isEqualTo(DEFAULT_MOTHER_TONGUE_ID);
        assertThat(testMdmCitizenData.getMotherTongue()).isEqualTo(DEFAULT_MOTHER_TONGUE);
        assertThat(testMdmCitizenData.getHouseholdOwnershipId()).isEqualTo(DEFAULT_HOUSEHOLD_OWNERSHIP_ID);
        assertThat(testMdmCitizenData.getHouseholdOwnership()).isEqualTo(DEFAULT_HOUSEHOLD_OWNERSHIP);
        assertThat(testMdmCitizenData.getEducationId()).isEqualTo(DEFAULT_EDUCATION_ID);
        assertThat(testMdmCitizenData.getEducation()).isEqualTo(DEFAULT_EDUCATION);
        assertThat(testMdmCitizenData.getOccupationId()).isEqualTo(DEFAULT_OCCUPATION_ID);
        assertThat(testMdmCitizenData.getOccupation()).isEqualTo(DEFAULT_OCCUPATION);
        assertThat(testMdmCitizenData.getOccupationCategoryId()).isEqualTo(DEFAULT_OCCUPATION_CATEGORY_ID);
        assertThat(testMdmCitizenData.getOccupationCategory()).isEqualTo(DEFAULT_OCCUPATION_CATEGORY);
        assertThat(testMdmCitizenData.getMartialStatusId()).isEqualTo(DEFAULT_MARTIAL_STATUS_ID);
        assertThat(testMdmCitizenData.getMartialStatus()).isEqualTo(DEFAULT_MARTIAL_STATUS);
        assertThat(testMdmCitizenData.getPhysicalhandicappedTypeId()).isEqualTo(DEFAULT_PHYSICALHANDICAPPED_TYPE_ID);
        assertThat(testMdmCitizenData.getPhysicalhandicappedStatus()).isEqualTo(DEFAULT_PHYSICALHANDICAPPED_STATUS);
        assertThat(testMdmCitizenData.getPhysicalhandicappedPercentage()).isEqualTo(DEFAULT_PHYSICALHANDICAPPED_PERCENTAGE);
        assertThat(testMdmCitizenData.getVotersCardNo()).isEqualTo(DEFAULT_VOTERS_CARD_NO);
        assertThat(testMdmCitizenData.getKissanCardAvailable()).isEqualTo(DEFAULT_KISSAN_CARD_AVAILABLE);
        assertThat(testMdmCitizenData.getAnnualIncome()).isEqualTo(DEFAULT_ANNUAL_INCOME);
        assertThat(testMdmCitizenData.getRationId()).isEqualTo(DEFAULT_RATION_ID);
        assertThat(testMdmCitizenData.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testMdmCitizenData.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testMdmCitizenData.getRecordInsertTime()).isEqualTo(DEFAULT_RECORD_INSERT_TIME);
        assertThat(testMdmCitizenData.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testMdmCitizenData.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
        assertThat(testMdmCitizenData.getAadhaarVerified()).isEqualTo(DEFAULT_AADHAAR_VERIFIED);
        assertThat(testMdmCitizenData.getAadhaarVerifiedDate()).isEqualTo(DEFAULT_AADHAAR_VERIFIED_DATE);
        assertThat(testMdmCitizenData.getEmailVerified()).isEqualTo(DEFAULT_EMAIL_VERIFIED);
        assertThat(testMdmCitizenData.getPhoneNoVerified()).isEqualTo(DEFAULT_PHONE_NO_VERIFIED);
        assertThat(testMdmCitizenData.getCitizenActiveStatus()).isEqualTo(DEFAULT_CITIZEN_ACTIVE_STATUS);
        assertThat(testMdmCitizenData.getSourceOfRegistrationId()).isEqualTo(DEFAULT_SOURCE_OF_REGISTRATION_ID);
        assertThat(testMdmCitizenData.getSourceOfRegistration()).isEqualTo(DEFAULT_SOURCE_OF_REGISTRATION);
        assertThat(testMdmCitizenData.getSsoId()).isEqualTo(DEFAULT_SSO_ID);
        assertThat(testMdmCitizenData.getOperatorId()).isEqualTo(DEFAULT_OPERATOR_ID);
        assertThat(testMdmCitizenData.getAadhaarRefId()).isEqualTo(DEFAULT_AADHAAR_REF_ID);
        assertThat(testMdmCitizenData.getCareOfAdh()).isEqualTo(DEFAULT_CARE_OF_ADH);
        assertThat(testMdmCitizenData.getAssistedModeOperatorId()).isEqualTo(DEFAULT_ASSISTED_MODE_OPERATOR_ID);
        assertThat(testMdmCitizenData.getUidReferenceKeyAponline()).isEqualTo(DEFAULT_UID_REFERENCE_KEY_APONLINE);
        assertThat(testMdmCitizenData.getUidToken()).isEqualTo(DEFAULT_UID_TOKEN);
        assertThat(testMdmCitizenData.getVolunteerSecretariatEmailId()).isEqualTo(DEFAULT_VOLUNTEER_SECRETARIAT_EMAIL_ID);
        assertThat(testMdmCitizenData.getVolunteerSecretariatMobile()).isEqualTo(DEFAULT_VOLUNTEER_SECRETARIAT_MOBILE);
        assertThat(testMdmCitizenData.getVolunteerSecretariatId()).isEqualTo(DEFAULT_VOLUNTEER_SECRETARIAT_ID);
    }

    @Test
    @Transactional
    public void createMdmCitizenDataWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdmCitizenDataRepository.findAll().size();

        // Create the MdmCitizenData with an existing ID
        mdmCitizenData.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdmCitizenDataMockMvc.perform(post("/api/mdm-citizen-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmCitizenData)))
            .andExpect(status().isBadRequest());

        // Validate the MdmCitizenData in the database
        List<MdmCitizenData> mdmCitizenDataList = mdmCitizenDataRepository.findAll();
        assertThat(mdmCitizenDataList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkSyspkIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmCitizenDataRepository.findAll().size();
        // set the field null
        mdmCitizenData.setSyspk(null);

        // Create the MdmCitizenData, which fails.

        restMdmCitizenDataMockMvc.perform(post("/api/mdm-citizen-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmCitizenData)))
            .andExpect(status().isBadRequest());

        List<MdmCitizenData> mdmCitizenDataList = mdmCitizenDataRepository.findAll();
        assertThat(mdmCitizenDataList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmCitizenDataRepository.findAll().size();
        // set the field null
        mdmCitizenData.setName(null);

        // Create the MdmCitizenData, which fails.

        restMdmCitizenDataMockMvc.perform(post("/api/mdm-citizen-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmCitizenData)))
            .andExpect(status().isBadRequest());

        List<MdmCitizenData> mdmCitizenDataList = mdmCitizenDataRepository.findAll();
        assertThat(mdmCitizenDataList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMdmCitizenData() throws Exception {
        // Initialize the database
        mdmCitizenDataRepository.saveAndFlush(mdmCitizenData);

        // Get all the mdmCitizenDataList
        restMdmCitizenDataMockMvc.perform(get("/api/mdm-citizen-data?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdmCitizenData.getId().intValue())))
            .andExpect(jsonPath("$.[*].syspk").value(hasItem(DEFAULT_SYSPK.intValue())))
            .andExpect(jsonPath("$.[*].tempRefId").value(hasItem(DEFAULT_TEMP_REF_ID.intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].emailId").value(hasItem(DEFAULT_EMAIL_ID)))
            .andExpect(jsonPath("$.[*].mobileNumber").value(hasItem(DEFAULT_MOBILE_NUMBER.intValue())))
            .andExpect(jsonPath("$.[*].dateOfBirth").value(hasItem(DEFAULT_DATE_OF_BIRTH.toString())))
            .andExpect(jsonPath("$.[*].genderId").value(hasItem(DEFAULT_GENDER_ID)))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER)))
            .andExpect(jsonPath("$.[*].houseNumberAdh").value(hasItem(DEFAULT_HOUSE_NUMBER_ADH)))
            .andExpect(jsonPath("$.[*].streetAdh").value(hasItem(DEFAULT_STREET_ADH)))
            .andExpect(jsonPath("$.[*].villageAdh").value(hasItem(DEFAULT_VILLAGE_ADH)))
            .andExpect(jsonPath("$.[*].districtNameAh").value(hasItem(DEFAULT_DISTRICT_NAME_AH)))
            .andExpect(jsonPath("$.[*].subDistrictNameAdh").value(hasItem(DEFAULT_SUB_DISTRICT_NAME_ADH)))
            .andExpect(jsonPath("$.[*].postOfficeAdh").value(hasItem(DEFAULT_POST_OFFICE_ADH)))
            .andExpect(jsonPath("$.[*].stateNameAdh").value(hasItem(DEFAULT_STATE_NAME_ADH)))
            .andExpect(jsonPath("$.[*].pinCodeAdh").value(hasItem(DEFAULT_PIN_CODE_ADH)))
            .andExpect(jsonPath("$.[*].districtCodePss").value(hasItem(DEFAULT_DISTRICT_CODE_PSS)))
            .andExpect(jsonPath("$.[*].districtNamePss").value(hasItem(DEFAULT_DISTRICT_NAME_PSS)))
            .andExpect(jsonPath("$.[*].districtCode").value(hasItem(DEFAULT_DISTRICT_CODE)))
            .andExpect(jsonPath("$.[*].mandalCode").value(hasItem(DEFAULT_MANDAL_CODE)))
            .andExpect(jsonPath("$.[*].villageCode").value(hasItem(DEFAULT_VILLAGE_CODE)))
            .andExpect(jsonPath("$.[*].districtName").value(hasItem(DEFAULT_DISTRICT_NAME)))
            .andExpect(jsonPath("$.[*].mandalName").value(hasItem(DEFAULT_MANDAL_NAME)))
            .andExpect(jsonPath("$.[*].villageName").value(hasItem(DEFAULT_VILLAGE_NAME)))
            .andExpect(jsonPath("$.[*].houseHoldId").value(hasItem(DEFAULT_HOUSE_HOLD_ID)))
            .andExpect(jsonPath("$.[*].relationshipWithHoh").value(hasItem(DEFAULT_RELATIONSHIP_WITH_HOH)))
            .andExpect(jsonPath("$.[*].buildingNamePss").value(hasItem(DEFAULT_BUILDING_NAME_PSS)))
            .andExpect(jsonPath("$.[*].houseNameWardNoDivPss").value(hasItem(DEFAULT_HOUSE_NAME_WARD_NO_DIV_PSS)))
            .andExpect(jsonPath("$.[*].areaWardColonyStreetPss").value(hasItem(DEFAULT_AREA_WARD_COLONY_STREET_PSS)))
            .andExpect(jsonPath("$.[*].villageTownPss").value(hasItem(DEFAULT_VILLAGE_TOWN_PSS)))
            .andExpect(jsonPath("$.[*].pinCodePss").value(hasItem(DEFAULT_PIN_CODE_PSS)))
            .andExpect(jsonPath("$.[*].religionId").value(hasItem(DEFAULT_RELIGION_ID)))
            .andExpect(jsonPath("$.[*].religion").value(hasItem(DEFAULT_RELIGION)))
            .andExpect(jsonPath("$.[*].casteId").value(hasItem(DEFAULT_CASTE_ID)))
            .andExpect(jsonPath("$.[*].caste").value(hasItem(DEFAULT_CASTE)))
            .andExpect(jsonPath("$.[*].subCasteId").value(hasItem(DEFAULT_SUB_CASTE_ID)))
            .andExpect(jsonPath("$.[*].subCaste").value(hasItem(DEFAULT_SUB_CASTE)))
            .andExpect(jsonPath("$.[*].motherTongueId").value(hasItem(DEFAULT_MOTHER_TONGUE_ID)))
            .andExpect(jsonPath("$.[*].motherTongue").value(hasItem(DEFAULT_MOTHER_TONGUE)))
            .andExpect(jsonPath("$.[*].householdOwnershipId").value(hasItem(DEFAULT_HOUSEHOLD_OWNERSHIP_ID)))
            .andExpect(jsonPath("$.[*].householdOwnership").value(hasItem(DEFAULT_HOUSEHOLD_OWNERSHIP)))
            .andExpect(jsonPath("$.[*].educationId").value(hasItem(DEFAULT_EDUCATION_ID)))
            .andExpect(jsonPath("$.[*].education").value(hasItem(DEFAULT_EDUCATION)))
            .andExpect(jsonPath("$.[*].occupationId").value(hasItem(DEFAULT_OCCUPATION_ID)))
            .andExpect(jsonPath("$.[*].occupation").value(hasItem(DEFAULT_OCCUPATION)))
            .andExpect(jsonPath("$.[*].occupationCategoryId").value(hasItem(DEFAULT_OCCUPATION_CATEGORY_ID)))
            .andExpect(jsonPath("$.[*].occupationCategory").value(hasItem(DEFAULT_OCCUPATION_CATEGORY)))
            .andExpect(jsonPath("$.[*].martialStatusId").value(hasItem(DEFAULT_MARTIAL_STATUS_ID)))
            .andExpect(jsonPath("$.[*].martialStatus").value(hasItem(DEFAULT_MARTIAL_STATUS)))
            .andExpect(jsonPath("$.[*].physicalhandicappedTypeId").value(hasItem(DEFAULT_PHYSICALHANDICAPPED_TYPE_ID)))
            .andExpect(jsonPath("$.[*].physicalhandicappedStatus").value(hasItem(DEFAULT_PHYSICALHANDICAPPED_STATUS)))
            .andExpect(jsonPath("$.[*].physicalhandicappedPercentage").value(hasItem(DEFAULT_PHYSICALHANDICAPPED_PERCENTAGE)))
            .andExpect(jsonPath("$.[*].votersCardNo").value(hasItem(DEFAULT_VOTERS_CARD_NO)))
            .andExpect(jsonPath("$.[*].kissanCardAvailable").value(hasItem(DEFAULT_KISSAN_CARD_AVAILABLE)))
            .andExpect(jsonPath("$.[*].annualIncome").value(hasItem(DEFAULT_ANNUAL_INCOME)))
            .andExpect(jsonPath("$.[*].rationId").value(hasItem(DEFAULT_RATION_ID)))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].recordInsertTime").value(hasItem(DEFAULT_RECORD_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].aadhaarVerified").value(hasItem(DEFAULT_AADHAAR_VERIFIED)))
            .andExpect(jsonPath("$.[*].aadhaarVerifiedDate").value(hasItem(DEFAULT_AADHAAR_VERIFIED_DATE.toString())))
            .andExpect(jsonPath("$.[*].emailVerified").value(hasItem(DEFAULT_EMAIL_VERIFIED)))
            .andExpect(jsonPath("$.[*].phoneNoVerified").value(hasItem(DEFAULT_PHONE_NO_VERIFIED)))
            .andExpect(jsonPath("$.[*].citizenActiveStatus").value(hasItem(DEFAULT_CITIZEN_ACTIVE_STATUS)))
            .andExpect(jsonPath("$.[*].sourceOfRegistrationId").value(hasItem(DEFAULT_SOURCE_OF_REGISTRATION_ID)))
            .andExpect(jsonPath("$.[*].sourceOfRegistration").value(hasItem(DEFAULT_SOURCE_OF_REGISTRATION)))
            .andExpect(jsonPath("$.[*].ssoId").value(hasItem(DEFAULT_SSO_ID)))
            .andExpect(jsonPath("$.[*].operatorId").value(hasItem(DEFAULT_OPERATOR_ID)))
            .andExpect(jsonPath("$.[*].aadhaarRefId").value(hasItem(DEFAULT_AADHAAR_REF_ID.intValue())))
            .andExpect(jsonPath("$.[*].careOfAdh").value(hasItem(DEFAULT_CARE_OF_ADH)))
            .andExpect(jsonPath("$.[*].assistedModeOperatorId").value(hasItem(DEFAULT_ASSISTED_MODE_OPERATOR_ID)))
            .andExpect(jsonPath("$.[*].uidReferenceKeyAponline").value(hasItem(DEFAULT_UID_REFERENCE_KEY_APONLINE.intValue())))
            .andExpect(jsonPath("$.[*].uidToken").value(hasItem(DEFAULT_UID_TOKEN)))
            .andExpect(jsonPath("$.[*].volunteerSecretariatEmailId").value(hasItem(DEFAULT_VOLUNTEER_SECRETARIAT_EMAIL_ID)))
            .andExpect(jsonPath("$.[*].volunteerSecretariatMobile").value(hasItem(DEFAULT_VOLUNTEER_SECRETARIAT_MOBILE.intValue())))
            .andExpect(jsonPath("$.[*].volunteerSecretariatId").value(hasItem(DEFAULT_VOLUNTEER_SECRETARIAT_ID)));
    }
    
    @Test
    @Transactional
    public void getMdmCitizenData() throws Exception {
        // Initialize the database
        mdmCitizenDataRepository.saveAndFlush(mdmCitizenData);

        // Get the mdmCitizenData
        restMdmCitizenDataMockMvc.perform(get("/api/mdm-citizen-data/{id}", mdmCitizenData.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mdmCitizenData.getId().intValue()))
            .andExpect(jsonPath("$.syspk").value(DEFAULT_SYSPK.intValue()))
            .andExpect(jsonPath("$.tempRefId").value(DEFAULT_TEMP_REF_ID.intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.emailId").value(DEFAULT_EMAIL_ID))
            .andExpect(jsonPath("$.mobileNumber").value(DEFAULT_MOBILE_NUMBER.intValue()))
            .andExpect(jsonPath("$.dateOfBirth").value(DEFAULT_DATE_OF_BIRTH.toString()))
            .andExpect(jsonPath("$.genderId").value(DEFAULT_GENDER_ID))
            .andExpect(jsonPath("$.gender").value(DEFAULT_GENDER))
            .andExpect(jsonPath("$.houseNumberAdh").value(DEFAULT_HOUSE_NUMBER_ADH))
            .andExpect(jsonPath("$.streetAdh").value(DEFAULT_STREET_ADH))
            .andExpect(jsonPath("$.villageAdh").value(DEFAULT_VILLAGE_ADH))
            .andExpect(jsonPath("$.districtNameAh").value(DEFAULT_DISTRICT_NAME_AH))
            .andExpect(jsonPath("$.subDistrictNameAdh").value(DEFAULT_SUB_DISTRICT_NAME_ADH))
            .andExpect(jsonPath("$.postOfficeAdh").value(DEFAULT_POST_OFFICE_ADH))
            .andExpect(jsonPath("$.stateNameAdh").value(DEFAULT_STATE_NAME_ADH))
            .andExpect(jsonPath("$.pinCodeAdh").value(DEFAULT_PIN_CODE_ADH))
            .andExpect(jsonPath("$.districtCodePss").value(DEFAULT_DISTRICT_CODE_PSS))
            .andExpect(jsonPath("$.districtNamePss").value(DEFAULT_DISTRICT_NAME_PSS))
            .andExpect(jsonPath("$.districtCode").value(DEFAULT_DISTRICT_CODE))
            .andExpect(jsonPath("$.mandalCode").value(DEFAULT_MANDAL_CODE))
            .andExpect(jsonPath("$.villageCode").value(DEFAULT_VILLAGE_CODE))
            .andExpect(jsonPath("$.districtName").value(DEFAULT_DISTRICT_NAME))
            .andExpect(jsonPath("$.mandalName").value(DEFAULT_MANDAL_NAME))
            .andExpect(jsonPath("$.villageName").value(DEFAULT_VILLAGE_NAME))
            .andExpect(jsonPath("$.houseHoldId").value(DEFAULT_HOUSE_HOLD_ID))
            .andExpect(jsonPath("$.relationshipWithHoh").value(DEFAULT_RELATIONSHIP_WITH_HOH))
            .andExpect(jsonPath("$.buildingNamePss").value(DEFAULT_BUILDING_NAME_PSS))
            .andExpect(jsonPath("$.houseNameWardNoDivPss").value(DEFAULT_HOUSE_NAME_WARD_NO_DIV_PSS))
            .andExpect(jsonPath("$.areaWardColonyStreetPss").value(DEFAULT_AREA_WARD_COLONY_STREET_PSS))
            .andExpect(jsonPath("$.villageTownPss").value(DEFAULT_VILLAGE_TOWN_PSS))
            .andExpect(jsonPath("$.pinCodePss").value(DEFAULT_PIN_CODE_PSS))
            .andExpect(jsonPath("$.religionId").value(DEFAULT_RELIGION_ID))
            .andExpect(jsonPath("$.religion").value(DEFAULT_RELIGION))
            .andExpect(jsonPath("$.casteId").value(DEFAULT_CASTE_ID))
            .andExpect(jsonPath("$.caste").value(DEFAULT_CASTE))
            .andExpect(jsonPath("$.subCasteId").value(DEFAULT_SUB_CASTE_ID))
            .andExpect(jsonPath("$.subCaste").value(DEFAULT_SUB_CASTE))
            .andExpect(jsonPath("$.motherTongueId").value(DEFAULT_MOTHER_TONGUE_ID))
            .andExpect(jsonPath("$.motherTongue").value(DEFAULT_MOTHER_TONGUE))
            .andExpect(jsonPath("$.householdOwnershipId").value(DEFAULT_HOUSEHOLD_OWNERSHIP_ID))
            .andExpect(jsonPath("$.householdOwnership").value(DEFAULT_HOUSEHOLD_OWNERSHIP))
            .andExpect(jsonPath("$.educationId").value(DEFAULT_EDUCATION_ID))
            .andExpect(jsonPath("$.education").value(DEFAULT_EDUCATION))
            .andExpect(jsonPath("$.occupationId").value(DEFAULT_OCCUPATION_ID))
            .andExpect(jsonPath("$.occupation").value(DEFAULT_OCCUPATION))
            .andExpect(jsonPath("$.occupationCategoryId").value(DEFAULT_OCCUPATION_CATEGORY_ID))
            .andExpect(jsonPath("$.occupationCategory").value(DEFAULT_OCCUPATION_CATEGORY))
            .andExpect(jsonPath("$.martialStatusId").value(DEFAULT_MARTIAL_STATUS_ID))
            .andExpect(jsonPath("$.martialStatus").value(DEFAULT_MARTIAL_STATUS))
            .andExpect(jsonPath("$.physicalhandicappedTypeId").value(DEFAULT_PHYSICALHANDICAPPED_TYPE_ID))
            .andExpect(jsonPath("$.physicalhandicappedStatus").value(DEFAULT_PHYSICALHANDICAPPED_STATUS))
            .andExpect(jsonPath("$.physicalhandicappedPercentage").value(DEFAULT_PHYSICALHANDICAPPED_PERCENTAGE))
            .andExpect(jsonPath("$.votersCardNo").value(DEFAULT_VOTERS_CARD_NO))
            .andExpect(jsonPath("$.kissanCardAvailable").value(DEFAULT_KISSAN_CARD_AVAILABLE))
            .andExpect(jsonPath("$.annualIncome").value(DEFAULT_ANNUAL_INCOME))
            .andExpect(jsonPath("$.rationId").value(DEFAULT_RATION_ID))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.recordInsertTime").value(DEFAULT_RECORD_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()))
            .andExpect(jsonPath("$.aadhaarVerified").value(DEFAULT_AADHAAR_VERIFIED))
            .andExpect(jsonPath("$.aadhaarVerifiedDate").value(DEFAULT_AADHAAR_VERIFIED_DATE.toString()))
            .andExpect(jsonPath("$.emailVerified").value(DEFAULT_EMAIL_VERIFIED))
            .andExpect(jsonPath("$.phoneNoVerified").value(DEFAULT_PHONE_NO_VERIFIED))
            .andExpect(jsonPath("$.citizenActiveStatus").value(DEFAULT_CITIZEN_ACTIVE_STATUS))
            .andExpect(jsonPath("$.sourceOfRegistrationId").value(DEFAULT_SOURCE_OF_REGISTRATION_ID))
            .andExpect(jsonPath("$.sourceOfRegistration").value(DEFAULT_SOURCE_OF_REGISTRATION))
            .andExpect(jsonPath("$.ssoId").value(DEFAULT_SSO_ID))
            .andExpect(jsonPath("$.operatorId").value(DEFAULT_OPERATOR_ID))
            .andExpect(jsonPath("$.aadhaarRefId").value(DEFAULT_AADHAAR_REF_ID.intValue()))
            .andExpect(jsonPath("$.careOfAdh").value(DEFAULT_CARE_OF_ADH))
            .andExpect(jsonPath("$.assistedModeOperatorId").value(DEFAULT_ASSISTED_MODE_OPERATOR_ID))
            .andExpect(jsonPath("$.uidReferenceKeyAponline").value(DEFAULT_UID_REFERENCE_KEY_APONLINE.intValue()))
            .andExpect(jsonPath("$.uidToken").value(DEFAULT_UID_TOKEN))
            .andExpect(jsonPath("$.volunteerSecretariatEmailId").value(DEFAULT_VOLUNTEER_SECRETARIAT_EMAIL_ID))
            .andExpect(jsonPath("$.volunteerSecretariatMobile").value(DEFAULT_VOLUNTEER_SECRETARIAT_MOBILE.intValue()))
            .andExpect(jsonPath("$.volunteerSecretariatId").value(DEFAULT_VOLUNTEER_SECRETARIAT_ID));
    }

    @Test
    @Transactional
    public void getNonExistingMdmCitizenData() throws Exception {
        // Get the mdmCitizenData
        restMdmCitizenDataMockMvc.perform(get("/api/mdm-citizen-data/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdmCitizenData() throws Exception {
        // Initialize the database
        mdmCitizenDataRepository.saveAndFlush(mdmCitizenData);

        int databaseSizeBeforeUpdate = mdmCitizenDataRepository.findAll().size();

        // Update the mdmCitizenData
        MdmCitizenData updatedMdmCitizenData = mdmCitizenDataRepository.findById(mdmCitizenData.getId()).get();
        // Disconnect from session so that the updates on updatedMdmCitizenData are not directly saved in db
        em.detach(updatedMdmCitizenData);
        updatedMdmCitizenData
            .syspk(UPDATED_SYSPK)
            .tempRefId(UPDATED_TEMP_REF_ID)
            .name(UPDATED_NAME)
            .emailId(UPDATED_EMAIL_ID)
            .mobileNumber(UPDATED_MOBILE_NUMBER)
            .dateOfBirth(UPDATED_DATE_OF_BIRTH)
            .genderId(UPDATED_GENDER_ID)
            .gender(UPDATED_GENDER)
            .houseNumberAdh(UPDATED_HOUSE_NUMBER_ADH)
            .streetAdh(UPDATED_STREET_ADH)
            .villageAdh(UPDATED_VILLAGE_ADH)
            .districtNameAh(UPDATED_DISTRICT_NAME_AH)
            .subDistrictNameAdh(UPDATED_SUB_DISTRICT_NAME_ADH)
            .postOfficeAdh(UPDATED_POST_OFFICE_ADH)
            .stateNameAdh(UPDATED_STATE_NAME_ADH)
            .pinCodeAdh(UPDATED_PIN_CODE_ADH)
            .districtCodePss(UPDATED_DISTRICT_CODE_PSS)
            .districtNamePss(UPDATED_DISTRICT_NAME_PSS)
            .districtCode(UPDATED_DISTRICT_CODE)
            .mandalCode(UPDATED_MANDAL_CODE)
            .villageCode(UPDATED_VILLAGE_CODE)
            .districtName(UPDATED_DISTRICT_NAME)
            .mandalName(UPDATED_MANDAL_NAME)
            .villageName(UPDATED_VILLAGE_NAME)
            .houseHoldId(UPDATED_HOUSE_HOLD_ID)
            .relationshipWithHoh(UPDATED_RELATIONSHIP_WITH_HOH)
            .buildingNamePss(UPDATED_BUILDING_NAME_PSS)
            .houseNameWardNoDivPss(UPDATED_HOUSE_NAME_WARD_NO_DIV_PSS)
            .areaWardColonyStreetPss(UPDATED_AREA_WARD_COLONY_STREET_PSS)
            .villageTownPss(UPDATED_VILLAGE_TOWN_PSS)
            .pinCodePss(UPDATED_PIN_CODE_PSS)
            .religionId(UPDATED_RELIGION_ID)
            .religion(UPDATED_RELIGION)
            .casteId(UPDATED_CASTE_ID)
            .caste(UPDATED_CASTE)
            .subCasteId(UPDATED_SUB_CASTE_ID)
            .subCaste(UPDATED_SUB_CASTE)
            .motherTongueId(UPDATED_MOTHER_TONGUE_ID)
            .motherTongue(UPDATED_MOTHER_TONGUE)
            .householdOwnershipId(UPDATED_HOUSEHOLD_OWNERSHIP_ID)
            .householdOwnership(UPDATED_HOUSEHOLD_OWNERSHIP)
            .educationId(UPDATED_EDUCATION_ID)
            .education(UPDATED_EDUCATION)
            .occupationId(UPDATED_OCCUPATION_ID)
            .occupation(UPDATED_OCCUPATION)
            .occupationCategoryId(UPDATED_OCCUPATION_CATEGORY_ID)
            .occupationCategory(UPDATED_OCCUPATION_CATEGORY)
            .martialStatusId(UPDATED_MARTIAL_STATUS_ID)
            .martialStatus(UPDATED_MARTIAL_STATUS)
            .physicalhandicappedTypeId(UPDATED_PHYSICALHANDICAPPED_TYPE_ID)
            .physicalhandicappedStatus(UPDATED_PHYSICALHANDICAPPED_STATUS)
            .physicalhandicappedPercentage(UPDATED_PHYSICALHANDICAPPED_PERCENTAGE)
            .votersCardNo(UPDATED_VOTERS_CARD_NO)
            .kissanCardAvailable(UPDATED_KISSAN_CARD_AVAILABLE)
            .annualIncome(UPDATED_ANNUAL_INCOME)
            .rationId(UPDATED_RATION_ID)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .aadhaarVerified(UPDATED_AADHAAR_VERIFIED)
            .aadhaarVerifiedDate(UPDATED_AADHAAR_VERIFIED_DATE)
            .emailVerified(UPDATED_EMAIL_VERIFIED)
            .phoneNoVerified(UPDATED_PHONE_NO_VERIFIED)
            .citizenActiveStatus(UPDATED_CITIZEN_ACTIVE_STATUS)
            .sourceOfRegistrationId(UPDATED_SOURCE_OF_REGISTRATION_ID)
            .sourceOfRegistration(UPDATED_SOURCE_OF_REGISTRATION)
            .ssoId(UPDATED_SSO_ID)
            .operatorId(UPDATED_OPERATOR_ID)
            .aadhaarRefId(UPDATED_AADHAAR_REF_ID)
            .careOfAdh(UPDATED_CARE_OF_ADH)
            .assistedModeOperatorId(UPDATED_ASSISTED_MODE_OPERATOR_ID)
            .uidReferenceKeyAponline(UPDATED_UID_REFERENCE_KEY_APONLINE)
            .uidToken(UPDATED_UID_TOKEN)
            .volunteerSecretariatEmailId(UPDATED_VOLUNTEER_SECRETARIAT_EMAIL_ID)
            .volunteerSecretariatMobile(UPDATED_VOLUNTEER_SECRETARIAT_MOBILE)
            .volunteerSecretariatId(UPDATED_VOLUNTEER_SECRETARIAT_ID);

        restMdmCitizenDataMockMvc.perform(put("/api/mdm-citizen-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdmCitizenData)))
            .andExpect(status().isOk());

        // Validate the MdmCitizenData in the database
        List<MdmCitizenData> mdmCitizenDataList = mdmCitizenDataRepository.findAll();
        assertThat(mdmCitizenDataList).hasSize(databaseSizeBeforeUpdate);
        MdmCitizenData testMdmCitizenData = mdmCitizenDataList.get(mdmCitizenDataList.size() - 1);
        assertThat(testMdmCitizenData.getSyspk()).isEqualTo(UPDATED_SYSPK);
        assertThat(testMdmCitizenData.getTempRefId()).isEqualTo(UPDATED_TEMP_REF_ID);
        assertThat(testMdmCitizenData.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testMdmCitizenData.getEmailId()).isEqualTo(UPDATED_EMAIL_ID);
        assertThat(testMdmCitizenData.getMobileNumber()).isEqualTo(UPDATED_MOBILE_NUMBER);
        assertThat(testMdmCitizenData.getDateOfBirth()).isEqualTo(UPDATED_DATE_OF_BIRTH);
        assertThat(testMdmCitizenData.getGenderId()).isEqualTo(UPDATED_GENDER_ID);
        assertThat(testMdmCitizenData.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testMdmCitizenData.getHouseNumberAdh()).isEqualTo(UPDATED_HOUSE_NUMBER_ADH);
        assertThat(testMdmCitizenData.getStreetAdh()).isEqualTo(UPDATED_STREET_ADH);
        assertThat(testMdmCitizenData.getVillageAdh()).isEqualTo(UPDATED_VILLAGE_ADH);
        assertThat(testMdmCitizenData.getDistrictNameAh()).isEqualTo(UPDATED_DISTRICT_NAME_AH);
        assertThat(testMdmCitizenData.getSubDistrictNameAdh()).isEqualTo(UPDATED_SUB_DISTRICT_NAME_ADH);
        assertThat(testMdmCitizenData.getPostOfficeAdh()).isEqualTo(UPDATED_POST_OFFICE_ADH);
        assertThat(testMdmCitizenData.getStateNameAdh()).isEqualTo(UPDATED_STATE_NAME_ADH);
        assertThat(testMdmCitizenData.getPinCodeAdh()).isEqualTo(UPDATED_PIN_CODE_ADH);
        assertThat(testMdmCitizenData.getDistrictCodePss()).isEqualTo(UPDATED_DISTRICT_CODE_PSS);
        assertThat(testMdmCitizenData.getDistrictNamePss()).isEqualTo(UPDATED_DISTRICT_NAME_PSS);
        assertThat(testMdmCitizenData.getDistrictCode()).isEqualTo(UPDATED_DISTRICT_CODE);
        assertThat(testMdmCitizenData.getMandalCode()).isEqualTo(UPDATED_MANDAL_CODE);
        assertThat(testMdmCitizenData.getVillageCode()).isEqualTo(UPDATED_VILLAGE_CODE);
        assertThat(testMdmCitizenData.getDistrictName()).isEqualTo(UPDATED_DISTRICT_NAME);
        assertThat(testMdmCitizenData.getMandalName()).isEqualTo(UPDATED_MANDAL_NAME);
        assertThat(testMdmCitizenData.getVillageName()).isEqualTo(UPDATED_VILLAGE_NAME);
        assertThat(testMdmCitizenData.getHouseHoldId()).isEqualTo(UPDATED_HOUSE_HOLD_ID);
        assertThat(testMdmCitizenData.getRelationshipWithHoh()).isEqualTo(UPDATED_RELATIONSHIP_WITH_HOH);
        assertThat(testMdmCitizenData.getBuildingNamePss()).isEqualTo(UPDATED_BUILDING_NAME_PSS);
        assertThat(testMdmCitizenData.getHouseNameWardNoDivPss()).isEqualTo(UPDATED_HOUSE_NAME_WARD_NO_DIV_PSS);
        assertThat(testMdmCitizenData.getAreaWardColonyStreetPss()).isEqualTo(UPDATED_AREA_WARD_COLONY_STREET_PSS);
        assertThat(testMdmCitizenData.getVillageTownPss()).isEqualTo(UPDATED_VILLAGE_TOWN_PSS);
        assertThat(testMdmCitizenData.getPinCodePss()).isEqualTo(UPDATED_PIN_CODE_PSS);
        assertThat(testMdmCitizenData.getReligionId()).isEqualTo(UPDATED_RELIGION_ID);
        assertThat(testMdmCitizenData.getReligion()).isEqualTo(UPDATED_RELIGION);
        assertThat(testMdmCitizenData.getCasteId()).isEqualTo(UPDATED_CASTE_ID);
        assertThat(testMdmCitizenData.getCaste()).isEqualTo(UPDATED_CASTE);
        assertThat(testMdmCitizenData.getSubCasteId()).isEqualTo(UPDATED_SUB_CASTE_ID);
        assertThat(testMdmCitizenData.getSubCaste()).isEqualTo(UPDATED_SUB_CASTE);
        assertThat(testMdmCitizenData.getMotherTongueId()).isEqualTo(UPDATED_MOTHER_TONGUE_ID);
        assertThat(testMdmCitizenData.getMotherTongue()).isEqualTo(UPDATED_MOTHER_TONGUE);
        assertThat(testMdmCitizenData.getHouseholdOwnershipId()).isEqualTo(UPDATED_HOUSEHOLD_OWNERSHIP_ID);
        assertThat(testMdmCitizenData.getHouseholdOwnership()).isEqualTo(UPDATED_HOUSEHOLD_OWNERSHIP);
        assertThat(testMdmCitizenData.getEducationId()).isEqualTo(UPDATED_EDUCATION_ID);
        assertThat(testMdmCitizenData.getEducation()).isEqualTo(UPDATED_EDUCATION);
        assertThat(testMdmCitizenData.getOccupationId()).isEqualTo(UPDATED_OCCUPATION_ID);
        assertThat(testMdmCitizenData.getOccupation()).isEqualTo(UPDATED_OCCUPATION);
        assertThat(testMdmCitizenData.getOccupationCategoryId()).isEqualTo(UPDATED_OCCUPATION_CATEGORY_ID);
        assertThat(testMdmCitizenData.getOccupationCategory()).isEqualTo(UPDATED_OCCUPATION_CATEGORY);
        assertThat(testMdmCitizenData.getMartialStatusId()).isEqualTo(UPDATED_MARTIAL_STATUS_ID);
        assertThat(testMdmCitizenData.getMartialStatus()).isEqualTo(UPDATED_MARTIAL_STATUS);
        assertThat(testMdmCitizenData.getPhysicalhandicappedTypeId()).isEqualTo(UPDATED_PHYSICALHANDICAPPED_TYPE_ID);
        assertThat(testMdmCitizenData.getPhysicalhandicappedStatus()).isEqualTo(UPDATED_PHYSICALHANDICAPPED_STATUS);
        assertThat(testMdmCitizenData.getPhysicalhandicappedPercentage()).isEqualTo(UPDATED_PHYSICALHANDICAPPED_PERCENTAGE);
        assertThat(testMdmCitizenData.getVotersCardNo()).isEqualTo(UPDATED_VOTERS_CARD_NO);
        assertThat(testMdmCitizenData.getKissanCardAvailable()).isEqualTo(UPDATED_KISSAN_CARD_AVAILABLE);
        assertThat(testMdmCitizenData.getAnnualIncome()).isEqualTo(UPDATED_ANNUAL_INCOME);
        assertThat(testMdmCitizenData.getRationId()).isEqualTo(UPDATED_RATION_ID);
        assertThat(testMdmCitizenData.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testMdmCitizenData.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testMdmCitizenData.getRecordInsertTime()).isEqualTo(UPDATED_RECORD_INSERT_TIME);
        assertThat(testMdmCitizenData.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testMdmCitizenData.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
        assertThat(testMdmCitizenData.getAadhaarVerified()).isEqualTo(UPDATED_AADHAAR_VERIFIED);
        assertThat(testMdmCitizenData.getAadhaarVerifiedDate()).isEqualTo(UPDATED_AADHAAR_VERIFIED_DATE);
        assertThat(testMdmCitizenData.getEmailVerified()).isEqualTo(UPDATED_EMAIL_VERIFIED);
        assertThat(testMdmCitizenData.getPhoneNoVerified()).isEqualTo(UPDATED_PHONE_NO_VERIFIED);
        assertThat(testMdmCitizenData.getCitizenActiveStatus()).isEqualTo(UPDATED_CITIZEN_ACTIVE_STATUS);
        assertThat(testMdmCitizenData.getSourceOfRegistrationId()).isEqualTo(UPDATED_SOURCE_OF_REGISTRATION_ID);
        assertThat(testMdmCitizenData.getSourceOfRegistration()).isEqualTo(UPDATED_SOURCE_OF_REGISTRATION);
        assertThat(testMdmCitizenData.getSsoId()).isEqualTo(UPDATED_SSO_ID);
        assertThat(testMdmCitizenData.getOperatorId()).isEqualTo(UPDATED_OPERATOR_ID);
        assertThat(testMdmCitizenData.getAadhaarRefId()).isEqualTo(UPDATED_AADHAAR_REF_ID);
        assertThat(testMdmCitizenData.getCareOfAdh()).isEqualTo(UPDATED_CARE_OF_ADH);
        assertThat(testMdmCitizenData.getAssistedModeOperatorId()).isEqualTo(UPDATED_ASSISTED_MODE_OPERATOR_ID);
        assertThat(testMdmCitizenData.getUidReferenceKeyAponline()).isEqualTo(UPDATED_UID_REFERENCE_KEY_APONLINE);
        assertThat(testMdmCitizenData.getUidToken()).isEqualTo(UPDATED_UID_TOKEN);
        assertThat(testMdmCitizenData.getVolunteerSecretariatEmailId()).isEqualTo(UPDATED_VOLUNTEER_SECRETARIAT_EMAIL_ID);
        assertThat(testMdmCitizenData.getVolunteerSecretariatMobile()).isEqualTo(UPDATED_VOLUNTEER_SECRETARIAT_MOBILE);
        assertThat(testMdmCitizenData.getVolunteerSecretariatId()).isEqualTo(UPDATED_VOLUNTEER_SECRETARIAT_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingMdmCitizenData() throws Exception {
        int databaseSizeBeforeUpdate = mdmCitizenDataRepository.findAll().size();

        // Create the MdmCitizenData

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdmCitizenDataMockMvc.perform(put("/api/mdm-citizen-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmCitizenData)))
            .andExpect(status().isBadRequest());

        // Validate the MdmCitizenData in the database
        List<MdmCitizenData> mdmCitizenDataList = mdmCitizenDataRepository.findAll();
        assertThat(mdmCitizenDataList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdmCitizenData() throws Exception {
        // Initialize the database
        mdmCitizenDataRepository.saveAndFlush(mdmCitizenData);

        int databaseSizeBeforeDelete = mdmCitizenDataRepository.findAll().size();

        // Delete the mdmCitizenData
        restMdmCitizenDataMockMvc.perform(delete("/api/mdm-citizen-data/{id}", mdmCitizenData.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdmCitizenData> mdmCitizenDataList = mdmCitizenDataRepository.findAll();
        assertThat(mdmCitizenDataList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
