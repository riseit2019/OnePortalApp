package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.OnePortalApp;
import com.epragati.oneportal.domain.MdmEmployeeMaster;
import com.epragati.oneportal.repository.MdmEmployeeMasterRepository;
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
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.epragati.oneportal.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link MdmEmployeeMasterResource} REST controller.
 */
@SpringBootTest(classes = OnePortalApp.class)
public class MdmEmployeeMasterResourceIT {

    private static final Long DEFAULT_SYSPK = 1L;
    private static final Long UPDATED_SYSPK = 2L;

    private static final String DEFAULT_EMPLOYEE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_CODE = "BBBBBBBBBB";

    private static final Long DEFAULT_TEMP_REF_ID = 1L;
    private static final Long UPDATED_TEMP_REF_ID = 2L;

    private static final Integer DEFAULT_EMPLOYEE_ID = 1;
    private static final Integer UPDATED_EMPLOYEE_ID = 2;

    private static final String DEFAULT_EMPLOYEE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ENTITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DESIGNATION_ID = "AAAAAAAAAA";
    private static final String UPDATED_DESIGNATION_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DESIGNATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DESIGNATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_POST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_POST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_UNIT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_UNIT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_ORGANIZATION_UNIT = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_ORGANIZATION_UNIT = "BBBBBBBBBB";

    private static final Long DEFAULT_MOBILE_NUMBER = 1L;
    private static final Long UPDATED_MOBILE_NUMBER = 2L;

    private static final String DEFAULT_EMAIL_ID = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS_1 = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS_2 = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_2 = "BBBBBBBBBB";

    private static final String DEFAULT_CITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CITY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_POST_OFFICE = "AAAAAAAAAA";
    private static final String UPDATED_POST_OFFICE = "BBBBBBBBBB";

    private static final String DEFAULT_IS_PRIMARY = "AAAAAAAAAA";
    private static final String UPDATED_IS_PRIMARY = "BBBBBBBBBB";

    private static final String DEFAULT_IS_OU_HEAD = "AAAAAAAAAA";
    private static final String UPDATED_IS_OU_HEAD = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRICT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DISTRICT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRICT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DISTRICT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_MANDAL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MANDAL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MANDAL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MANDAL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_VILLAGE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_VILLAGE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_VILLAGE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_VILLAGE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PANCHAYAT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PANCHAYAT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PANCHAYAT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PANCHAYAT_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_CONSTITUENCY_CODE = 1;
    private static final Integer UPDATED_CONSTITUENCY_CODE = 2;

    private static final String DEFAULT_CONSTITUENCY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CONSTITUENCY_NAME = "BBBBBBBBBB";

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

    private static final String DEFAULT_EMPLOYEE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_MANAGER_EMPLOYEE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MANAGER_EMPLOYEE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYEE_ACTIVE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_ACTIVE_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_ID_1 = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_ID_1 = "BBBBBBBBBB";

    private static final Long DEFAULT_AADHAAR_REF_ID = 1L;
    private static final Long UPDATED_AADHAAR_REF_ID = 2L;

    private static final String DEFAULT_VOLUNTEER_SECRETARIAT_ID = "AAAAAAAAAA";
    private static final String UPDATED_VOLUNTEER_SECRETARIAT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_VOLUNTEER_SECRETARIAT_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_VOLUNTEER_SECRETARIAT_FLAG = "BBBBBBBBBB";

    private static final Long DEFAULT_AADHAAR_NUMBER = 1L;
    private static final Long UPDATED_AADHAAR_NUMBER = 2L;

    @Autowired
    private MdmEmployeeMasterRepository mdmEmployeeMasterRepository;

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

    private MockMvc restMdmEmployeeMasterMockMvc;

    private MdmEmployeeMaster mdmEmployeeMaster;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdmEmployeeMasterResource mdmEmployeeMasterResource = new MdmEmployeeMasterResource(mdmEmployeeMasterRepository);
        this.restMdmEmployeeMasterMockMvc = MockMvcBuilders.standaloneSetup(mdmEmployeeMasterResource)
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
    public static MdmEmployeeMaster createEntity(EntityManager em) {
        MdmEmployeeMaster mdmEmployeeMaster = new MdmEmployeeMaster()
            .syspk(DEFAULT_SYSPK)
            .employeeCode(DEFAULT_EMPLOYEE_CODE)
            .tempRefId(DEFAULT_TEMP_REF_ID)
            .employeeId(DEFAULT_EMPLOYEE_ID)
            .employeeName(DEFAULT_EMPLOYEE_NAME)
            .entityName(DEFAULT_ENTITY_NAME)
            .organizationName(DEFAULT_ORGANIZATION_NAME)
            .designationId(DEFAULT_DESIGNATION_ID)
            .designationName(DEFAULT_DESIGNATION_NAME)
            .postName(DEFAULT_POST_NAME)
            .organizationUnitName(DEFAULT_ORGANIZATION_UNIT_NAME)
            .parentOrganizationUnit(DEFAULT_PARENT_ORGANIZATION_UNIT)
            .mobileNumber(DEFAULT_MOBILE_NUMBER)
            .emailId(DEFAULT_EMAIL_ID)
            .addressType(DEFAULT_ADDRESS_TYPE)
            .address1(DEFAULT_ADDRESS_1)
            .address2(DEFAULT_ADDRESS_2)
            .cityName(DEFAULT_CITY_NAME)
            .postOffice(DEFAULT_POST_OFFICE)
            .isPrimary(DEFAULT_IS_PRIMARY)
            .isOuHead(DEFAULT_IS_OU_HEAD)
            .districtCode(DEFAULT_DISTRICT_CODE)
            .districtName(DEFAULT_DISTRICT_NAME)
            .mandalCode(DEFAULT_MANDAL_CODE)
            .mandalName(DEFAULT_MANDAL_NAME)
            .villageCode(DEFAULT_VILLAGE_CODE)
            .villageName(DEFAULT_VILLAGE_NAME)
            .panchayatCode(DEFAULT_PANCHAYAT_CODE)
            .panchayatName(DEFAULT_PANCHAYAT_NAME)
            .constituencyCode(DEFAULT_CONSTITUENCY_CODE)
            .constituencyName(DEFAULT_CONSTITUENCY_NAME)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedBy(DEFAULT_UPDATED_BY)
            .recordInsertTime(DEFAULT_RECORD_INSERT_TIME)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME)
            .employeeType(DEFAULT_EMPLOYEE_TYPE)
            .managerEmployeeCode(DEFAULT_MANAGER_EMPLOYEE_CODE)
            .employeeActiveStatus(DEFAULT_EMPLOYEE_ACTIVE_STATUS)
            .personId1(DEFAULT_PERSON_ID_1)
            .aadhaarRefId(DEFAULT_AADHAAR_REF_ID)
            .volunteerSecretariatId(DEFAULT_VOLUNTEER_SECRETARIAT_ID)
            .volunteerSecretariatFlag(DEFAULT_VOLUNTEER_SECRETARIAT_FLAG)
            .aadhaarNumber(DEFAULT_AADHAAR_NUMBER);
        return mdmEmployeeMaster;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmEmployeeMaster createUpdatedEntity(EntityManager em) {
        MdmEmployeeMaster mdmEmployeeMaster = new MdmEmployeeMaster()
            .syspk(UPDATED_SYSPK)
            .employeeCode(UPDATED_EMPLOYEE_CODE)
            .tempRefId(UPDATED_TEMP_REF_ID)
            .employeeId(UPDATED_EMPLOYEE_ID)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .entityName(UPDATED_ENTITY_NAME)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .designationId(UPDATED_DESIGNATION_ID)
            .designationName(UPDATED_DESIGNATION_NAME)
            .postName(UPDATED_POST_NAME)
            .organizationUnitName(UPDATED_ORGANIZATION_UNIT_NAME)
            .parentOrganizationUnit(UPDATED_PARENT_ORGANIZATION_UNIT)
            .mobileNumber(UPDATED_MOBILE_NUMBER)
            .emailId(UPDATED_EMAIL_ID)
            .addressType(UPDATED_ADDRESS_TYPE)
            .address1(UPDATED_ADDRESS_1)
            .address2(UPDATED_ADDRESS_2)
            .cityName(UPDATED_CITY_NAME)
            .postOffice(UPDATED_POST_OFFICE)
            .isPrimary(UPDATED_IS_PRIMARY)
            .isOuHead(UPDATED_IS_OU_HEAD)
            .districtCode(UPDATED_DISTRICT_CODE)
            .districtName(UPDATED_DISTRICT_NAME)
            .mandalCode(UPDATED_MANDAL_CODE)
            .mandalName(UPDATED_MANDAL_NAME)
            .villageCode(UPDATED_VILLAGE_CODE)
            .villageName(UPDATED_VILLAGE_NAME)
            .panchayatCode(UPDATED_PANCHAYAT_CODE)
            .panchayatName(UPDATED_PANCHAYAT_NAME)
            .constituencyCode(UPDATED_CONSTITUENCY_CODE)
            .constituencyName(UPDATED_CONSTITUENCY_NAME)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .employeeType(UPDATED_EMPLOYEE_TYPE)
            .managerEmployeeCode(UPDATED_MANAGER_EMPLOYEE_CODE)
            .employeeActiveStatus(UPDATED_EMPLOYEE_ACTIVE_STATUS)
            .personId1(UPDATED_PERSON_ID_1)
            .aadhaarRefId(UPDATED_AADHAAR_REF_ID)
            .volunteerSecretariatId(UPDATED_VOLUNTEER_SECRETARIAT_ID)
            .volunteerSecretariatFlag(UPDATED_VOLUNTEER_SECRETARIAT_FLAG)
            .aadhaarNumber(UPDATED_AADHAAR_NUMBER);
        return mdmEmployeeMaster;
    }

    @BeforeEach
    public void initTest() {
        mdmEmployeeMaster = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdmEmployeeMaster() throws Exception {
        int databaseSizeBeforeCreate = mdmEmployeeMasterRepository.findAll().size();

        // Create the MdmEmployeeMaster
        restMdmEmployeeMasterMockMvc.perform(post("/api/mdm-employee-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmployeeMaster)))
            .andExpect(status().isCreated());

        // Validate the MdmEmployeeMaster in the database
        List<MdmEmployeeMaster> mdmEmployeeMasterList = mdmEmployeeMasterRepository.findAll();
        assertThat(mdmEmployeeMasterList).hasSize(databaseSizeBeforeCreate + 1);
        MdmEmployeeMaster testMdmEmployeeMaster = mdmEmployeeMasterList.get(mdmEmployeeMasterList.size() - 1);
        assertThat(testMdmEmployeeMaster.getSyspk()).isEqualTo(DEFAULT_SYSPK);
        assertThat(testMdmEmployeeMaster.getEmployeeCode()).isEqualTo(DEFAULT_EMPLOYEE_CODE);
        assertThat(testMdmEmployeeMaster.getTempRefId()).isEqualTo(DEFAULT_TEMP_REF_ID);
        assertThat(testMdmEmployeeMaster.getEmployeeId()).isEqualTo(DEFAULT_EMPLOYEE_ID);
        assertThat(testMdmEmployeeMaster.getEmployeeName()).isEqualTo(DEFAULT_EMPLOYEE_NAME);
        assertThat(testMdmEmployeeMaster.getEntityName()).isEqualTo(DEFAULT_ENTITY_NAME);
        assertThat(testMdmEmployeeMaster.getOrganizationName()).isEqualTo(DEFAULT_ORGANIZATION_NAME);
        assertThat(testMdmEmployeeMaster.getDesignationId()).isEqualTo(DEFAULT_DESIGNATION_ID);
        assertThat(testMdmEmployeeMaster.getDesignationName()).isEqualTo(DEFAULT_DESIGNATION_NAME);
        assertThat(testMdmEmployeeMaster.getPostName()).isEqualTo(DEFAULT_POST_NAME);
        assertThat(testMdmEmployeeMaster.getOrganizationUnitName()).isEqualTo(DEFAULT_ORGANIZATION_UNIT_NAME);
        assertThat(testMdmEmployeeMaster.getParentOrganizationUnit()).isEqualTo(DEFAULT_PARENT_ORGANIZATION_UNIT);
        assertThat(testMdmEmployeeMaster.getMobileNumber()).isEqualTo(DEFAULT_MOBILE_NUMBER);
        assertThat(testMdmEmployeeMaster.getEmailId()).isEqualTo(DEFAULT_EMAIL_ID);
        assertThat(testMdmEmployeeMaster.getAddressType()).isEqualTo(DEFAULT_ADDRESS_TYPE);
        assertThat(testMdmEmployeeMaster.getAddress1()).isEqualTo(DEFAULT_ADDRESS_1);
        assertThat(testMdmEmployeeMaster.getAddress2()).isEqualTo(DEFAULT_ADDRESS_2);
        assertThat(testMdmEmployeeMaster.getCityName()).isEqualTo(DEFAULT_CITY_NAME);
        assertThat(testMdmEmployeeMaster.getPostOffice()).isEqualTo(DEFAULT_POST_OFFICE);
        assertThat(testMdmEmployeeMaster.getIsPrimary()).isEqualTo(DEFAULT_IS_PRIMARY);
        assertThat(testMdmEmployeeMaster.getIsOuHead()).isEqualTo(DEFAULT_IS_OU_HEAD);
        assertThat(testMdmEmployeeMaster.getDistrictCode()).isEqualTo(DEFAULT_DISTRICT_CODE);
        assertThat(testMdmEmployeeMaster.getDistrictName()).isEqualTo(DEFAULT_DISTRICT_NAME);
        assertThat(testMdmEmployeeMaster.getMandalCode()).isEqualTo(DEFAULT_MANDAL_CODE);
        assertThat(testMdmEmployeeMaster.getMandalName()).isEqualTo(DEFAULT_MANDAL_NAME);
        assertThat(testMdmEmployeeMaster.getVillageCode()).isEqualTo(DEFAULT_VILLAGE_CODE);
        assertThat(testMdmEmployeeMaster.getVillageName()).isEqualTo(DEFAULT_VILLAGE_NAME);
        assertThat(testMdmEmployeeMaster.getPanchayatCode()).isEqualTo(DEFAULT_PANCHAYAT_CODE);
        assertThat(testMdmEmployeeMaster.getPanchayatName()).isEqualTo(DEFAULT_PANCHAYAT_NAME);
        assertThat(testMdmEmployeeMaster.getConstituencyCode()).isEqualTo(DEFAULT_CONSTITUENCY_CODE);
        assertThat(testMdmEmployeeMaster.getConstituencyName()).isEqualTo(DEFAULT_CONSTITUENCY_NAME);
        assertThat(testMdmEmployeeMaster.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testMdmEmployeeMaster.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testMdmEmployeeMaster.getRecordInsertTime()).isEqualTo(DEFAULT_RECORD_INSERT_TIME);
        assertThat(testMdmEmployeeMaster.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testMdmEmployeeMaster.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
        assertThat(testMdmEmployeeMaster.getEmployeeType()).isEqualTo(DEFAULT_EMPLOYEE_TYPE);
        assertThat(testMdmEmployeeMaster.getManagerEmployeeCode()).isEqualTo(DEFAULT_MANAGER_EMPLOYEE_CODE);
        assertThat(testMdmEmployeeMaster.getEmployeeActiveStatus()).isEqualTo(DEFAULT_EMPLOYEE_ACTIVE_STATUS);
        assertThat(testMdmEmployeeMaster.getPersonId1()).isEqualTo(DEFAULT_PERSON_ID_1);
        assertThat(testMdmEmployeeMaster.getAadhaarRefId()).isEqualTo(DEFAULT_AADHAAR_REF_ID);
        assertThat(testMdmEmployeeMaster.getVolunteerSecretariatId()).isEqualTo(DEFAULT_VOLUNTEER_SECRETARIAT_ID);
        assertThat(testMdmEmployeeMaster.getVolunteerSecretariatFlag()).isEqualTo(DEFAULT_VOLUNTEER_SECRETARIAT_FLAG);
        assertThat(testMdmEmployeeMaster.getAadhaarNumber()).isEqualTo(DEFAULT_AADHAAR_NUMBER);
    }

    @Test
    @Transactional
    public void createMdmEmployeeMasterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdmEmployeeMasterRepository.findAll().size();

        // Create the MdmEmployeeMaster with an existing ID
        mdmEmployeeMaster.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdmEmployeeMasterMockMvc.perform(post("/api/mdm-employee-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmployeeMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmEmployeeMaster in the database
        List<MdmEmployeeMaster> mdmEmployeeMasterList = mdmEmployeeMasterRepository.findAll();
        assertThat(mdmEmployeeMasterList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkSyspkIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmEmployeeMasterRepository.findAll().size();
        // set the field null
        mdmEmployeeMaster.setSyspk(null);

        // Create the MdmEmployeeMaster, which fails.

        restMdmEmployeeMasterMockMvc.perform(post("/api/mdm-employee-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmployeeMaster)))
            .andExpect(status().isBadRequest());

        List<MdmEmployeeMaster> mdmEmployeeMasterList = mdmEmployeeMasterRepository.findAll();
        assertThat(mdmEmployeeMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEmployeeCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmEmployeeMasterRepository.findAll().size();
        // set the field null
        mdmEmployeeMaster.setEmployeeCode(null);

        // Create the MdmEmployeeMaster, which fails.

        restMdmEmployeeMasterMockMvc.perform(post("/api/mdm-employee-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmployeeMaster)))
            .andExpect(status().isBadRequest());

        List<MdmEmployeeMaster> mdmEmployeeMasterList = mdmEmployeeMasterRepository.findAll();
        assertThat(mdmEmployeeMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMdmEmployeeMasters() throws Exception {
        // Initialize the database
        mdmEmployeeMasterRepository.saveAndFlush(mdmEmployeeMaster);

        // Get all the mdmEmployeeMasterList
        restMdmEmployeeMasterMockMvc.perform(get("/api/mdm-employee-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdmEmployeeMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].syspk").value(hasItem(DEFAULT_SYSPK.intValue())))
            .andExpect(jsonPath("$.[*].employeeCode").value(hasItem(DEFAULT_EMPLOYEE_CODE)))
            .andExpect(jsonPath("$.[*].tempRefId").value(hasItem(DEFAULT_TEMP_REF_ID.intValue())))
            .andExpect(jsonPath("$.[*].employeeId").value(hasItem(DEFAULT_EMPLOYEE_ID)))
            .andExpect(jsonPath("$.[*].employeeName").value(hasItem(DEFAULT_EMPLOYEE_NAME)))
            .andExpect(jsonPath("$.[*].entityName").value(hasItem(DEFAULT_ENTITY_NAME)))
            .andExpect(jsonPath("$.[*].organizationName").value(hasItem(DEFAULT_ORGANIZATION_NAME)))
            .andExpect(jsonPath("$.[*].designationId").value(hasItem(DEFAULT_DESIGNATION_ID)))
            .andExpect(jsonPath("$.[*].designationName").value(hasItem(DEFAULT_DESIGNATION_NAME)))
            .andExpect(jsonPath("$.[*].postName").value(hasItem(DEFAULT_POST_NAME)))
            .andExpect(jsonPath("$.[*].organizationUnitName").value(hasItem(DEFAULT_ORGANIZATION_UNIT_NAME)))
            .andExpect(jsonPath("$.[*].parentOrganizationUnit").value(hasItem(DEFAULT_PARENT_ORGANIZATION_UNIT)))
            .andExpect(jsonPath("$.[*].mobileNumber").value(hasItem(DEFAULT_MOBILE_NUMBER.intValue())))
            .andExpect(jsonPath("$.[*].emailId").value(hasItem(DEFAULT_EMAIL_ID)))
            .andExpect(jsonPath("$.[*].addressType").value(hasItem(DEFAULT_ADDRESS_TYPE)))
            .andExpect(jsonPath("$.[*].address1").value(hasItem(DEFAULT_ADDRESS_1)))
            .andExpect(jsonPath("$.[*].address2").value(hasItem(DEFAULT_ADDRESS_2)))
            .andExpect(jsonPath("$.[*].cityName").value(hasItem(DEFAULT_CITY_NAME)))
            .andExpect(jsonPath("$.[*].postOffice").value(hasItem(DEFAULT_POST_OFFICE)))
            .andExpect(jsonPath("$.[*].isPrimary").value(hasItem(DEFAULT_IS_PRIMARY)))
            .andExpect(jsonPath("$.[*].isOuHead").value(hasItem(DEFAULT_IS_OU_HEAD)))
            .andExpect(jsonPath("$.[*].districtCode").value(hasItem(DEFAULT_DISTRICT_CODE)))
            .andExpect(jsonPath("$.[*].districtName").value(hasItem(DEFAULT_DISTRICT_NAME)))
            .andExpect(jsonPath("$.[*].mandalCode").value(hasItem(DEFAULT_MANDAL_CODE)))
            .andExpect(jsonPath("$.[*].mandalName").value(hasItem(DEFAULT_MANDAL_NAME)))
            .andExpect(jsonPath("$.[*].villageCode").value(hasItem(DEFAULT_VILLAGE_CODE)))
            .andExpect(jsonPath("$.[*].villageName").value(hasItem(DEFAULT_VILLAGE_NAME)))
            .andExpect(jsonPath("$.[*].panchayatCode").value(hasItem(DEFAULT_PANCHAYAT_CODE)))
            .andExpect(jsonPath("$.[*].panchayatName").value(hasItem(DEFAULT_PANCHAYAT_NAME)))
            .andExpect(jsonPath("$.[*].constituencyCode").value(hasItem(DEFAULT_CONSTITUENCY_CODE)))
            .andExpect(jsonPath("$.[*].constituencyName").value(hasItem(DEFAULT_CONSTITUENCY_NAME)))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].recordInsertTime").value(hasItem(DEFAULT_RECORD_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].employeeType").value(hasItem(DEFAULT_EMPLOYEE_TYPE)))
            .andExpect(jsonPath("$.[*].managerEmployeeCode").value(hasItem(DEFAULT_MANAGER_EMPLOYEE_CODE)))
            .andExpect(jsonPath("$.[*].employeeActiveStatus").value(hasItem(DEFAULT_EMPLOYEE_ACTIVE_STATUS)))
            .andExpect(jsonPath("$.[*].personId1").value(hasItem(DEFAULT_PERSON_ID_1)))
            .andExpect(jsonPath("$.[*].aadhaarRefId").value(hasItem(DEFAULT_AADHAAR_REF_ID.intValue())))
            .andExpect(jsonPath("$.[*].volunteerSecretariatId").value(hasItem(DEFAULT_VOLUNTEER_SECRETARIAT_ID)))
            .andExpect(jsonPath("$.[*].volunteerSecretariatFlag").value(hasItem(DEFAULT_VOLUNTEER_SECRETARIAT_FLAG)))
            .andExpect(jsonPath("$.[*].aadhaarNumber").value(hasItem(DEFAULT_AADHAAR_NUMBER.intValue())));
    }
    
    @Test
    @Transactional
    public void getMdmEmployeeMaster() throws Exception {
        // Initialize the database
        mdmEmployeeMasterRepository.saveAndFlush(mdmEmployeeMaster);

        // Get the mdmEmployeeMaster
        restMdmEmployeeMasterMockMvc.perform(get("/api/mdm-employee-masters/{id}", mdmEmployeeMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mdmEmployeeMaster.getId().intValue()))
            .andExpect(jsonPath("$.syspk").value(DEFAULT_SYSPK.intValue()))
            .andExpect(jsonPath("$.employeeCode").value(DEFAULT_EMPLOYEE_CODE))
            .andExpect(jsonPath("$.tempRefId").value(DEFAULT_TEMP_REF_ID.intValue()))
            .andExpect(jsonPath("$.employeeId").value(DEFAULT_EMPLOYEE_ID))
            .andExpect(jsonPath("$.employeeName").value(DEFAULT_EMPLOYEE_NAME))
            .andExpect(jsonPath("$.entityName").value(DEFAULT_ENTITY_NAME))
            .andExpect(jsonPath("$.organizationName").value(DEFAULT_ORGANIZATION_NAME))
            .andExpect(jsonPath("$.designationId").value(DEFAULT_DESIGNATION_ID))
            .andExpect(jsonPath("$.designationName").value(DEFAULT_DESIGNATION_NAME))
            .andExpect(jsonPath("$.postName").value(DEFAULT_POST_NAME))
            .andExpect(jsonPath("$.organizationUnitName").value(DEFAULT_ORGANIZATION_UNIT_NAME))
            .andExpect(jsonPath("$.parentOrganizationUnit").value(DEFAULT_PARENT_ORGANIZATION_UNIT))
            .andExpect(jsonPath("$.mobileNumber").value(DEFAULT_MOBILE_NUMBER.intValue()))
            .andExpect(jsonPath("$.emailId").value(DEFAULT_EMAIL_ID))
            .andExpect(jsonPath("$.addressType").value(DEFAULT_ADDRESS_TYPE))
            .andExpect(jsonPath("$.address1").value(DEFAULT_ADDRESS_1))
            .andExpect(jsonPath("$.address2").value(DEFAULT_ADDRESS_2))
            .andExpect(jsonPath("$.cityName").value(DEFAULT_CITY_NAME))
            .andExpect(jsonPath("$.postOffice").value(DEFAULT_POST_OFFICE))
            .andExpect(jsonPath("$.isPrimary").value(DEFAULT_IS_PRIMARY))
            .andExpect(jsonPath("$.isOuHead").value(DEFAULT_IS_OU_HEAD))
            .andExpect(jsonPath("$.districtCode").value(DEFAULT_DISTRICT_CODE))
            .andExpect(jsonPath("$.districtName").value(DEFAULT_DISTRICT_NAME))
            .andExpect(jsonPath("$.mandalCode").value(DEFAULT_MANDAL_CODE))
            .andExpect(jsonPath("$.mandalName").value(DEFAULT_MANDAL_NAME))
            .andExpect(jsonPath("$.villageCode").value(DEFAULT_VILLAGE_CODE))
            .andExpect(jsonPath("$.villageName").value(DEFAULT_VILLAGE_NAME))
            .andExpect(jsonPath("$.panchayatCode").value(DEFAULT_PANCHAYAT_CODE))
            .andExpect(jsonPath("$.panchayatName").value(DEFAULT_PANCHAYAT_NAME))
            .andExpect(jsonPath("$.constituencyCode").value(DEFAULT_CONSTITUENCY_CODE))
            .andExpect(jsonPath("$.constituencyName").value(DEFAULT_CONSTITUENCY_NAME))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.recordInsertTime").value(DEFAULT_RECORD_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()))
            .andExpect(jsonPath("$.employeeType").value(DEFAULT_EMPLOYEE_TYPE))
            .andExpect(jsonPath("$.managerEmployeeCode").value(DEFAULT_MANAGER_EMPLOYEE_CODE))
            .andExpect(jsonPath("$.employeeActiveStatus").value(DEFAULT_EMPLOYEE_ACTIVE_STATUS))
            .andExpect(jsonPath("$.personId1").value(DEFAULT_PERSON_ID_1))
            .andExpect(jsonPath("$.aadhaarRefId").value(DEFAULT_AADHAAR_REF_ID.intValue()))
            .andExpect(jsonPath("$.volunteerSecretariatId").value(DEFAULT_VOLUNTEER_SECRETARIAT_ID))
            .andExpect(jsonPath("$.volunteerSecretariatFlag").value(DEFAULT_VOLUNTEER_SECRETARIAT_FLAG))
            .andExpect(jsonPath("$.aadhaarNumber").value(DEFAULT_AADHAAR_NUMBER.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingMdmEmployeeMaster() throws Exception {
        // Get the mdmEmployeeMaster
        restMdmEmployeeMasterMockMvc.perform(get("/api/mdm-employee-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdmEmployeeMaster() throws Exception {
        // Initialize the database
        mdmEmployeeMasterRepository.saveAndFlush(mdmEmployeeMaster);

        int databaseSizeBeforeUpdate = mdmEmployeeMasterRepository.findAll().size();

        // Update the mdmEmployeeMaster
        MdmEmployeeMaster updatedMdmEmployeeMaster = mdmEmployeeMasterRepository.findById(mdmEmployeeMaster.getId()).get();
        // Disconnect from session so that the updates on updatedMdmEmployeeMaster are not directly saved in db
        em.detach(updatedMdmEmployeeMaster);
        updatedMdmEmployeeMaster
            .syspk(UPDATED_SYSPK)
            .employeeCode(UPDATED_EMPLOYEE_CODE)
            .tempRefId(UPDATED_TEMP_REF_ID)
            .employeeId(UPDATED_EMPLOYEE_ID)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .entityName(UPDATED_ENTITY_NAME)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .designationId(UPDATED_DESIGNATION_ID)
            .designationName(UPDATED_DESIGNATION_NAME)
            .postName(UPDATED_POST_NAME)
            .organizationUnitName(UPDATED_ORGANIZATION_UNIT_NAME)
            .parentOrganizationUnit(UPDATED_PARENT_ORGANIZATION_UNIT)
            .mobileNumber(UPDATED_MOBILE_NUMBER)
            .emailId(UPDATED_EMAIL_ID)
            .addressType(UPDATED_ADDRESS_TYPE)
            .address1(UPDATED_ADDRESS_1)
            .address2(UPDATED_ADDRESS_2)
            .cityName(UPDATED_CITY_NAME)
            .postOffice(UPDATED_POST_OFFICE)
            .isPrimary(UPDATED_IS_PRIMARY)
            .isOuHead(UPDATED_IS_OU_HEAD)
            .districtCode(UPDATED_DISTRICT_CODE)
            .districtName(UPDATED_DISTRICT_NAME)
            .mandalCode(UPDATED_MANDAL_CODE)
            .mandalName(UPDATED_MANDAL_NAME)
            .villageCode(UPDATED_VILLAGE_CODE)
            .villageName(UPDATED_VILLAGE_NAME)
            .panchayatCode(UPDATED_PANCHAYAT_CODE)
            .panchayatName(UPDATED_PANCHAYAT_NAME)
            .constituencyCode(UPDATED_CONSTITUENCY_CODE)
            .constituencyName(UPDATED_CONSTITUENCY_NAME)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .employeeType(UPDATED_EMPLOYEE_TYPE)
            .managerEmployeeCode(UPDATED_MANAGER_EMPLOYEE_CODE)
            .employeeActiveStatus(UPDATED_EMPLOYEE_ACTIVE_STATUS)
            .personId1(UPDATED_PERSON_ID_1)
            .aadhaarRefId(UPDATED_AADHAAR_REF_ID)
            .volunteerSecretariatId(UPDATED_VOLUNTEER_SECRETARIAT_ID)
            .volunteerSecretariatFlag(UPDATED_VOLUNTEER_SECRETARIAT_FLAG)
            .aadhaarNumber(UPDATED_AADHAAR_NUMBER);

        restMdmEmployeeMasterMockMvc.perform(put("/api/mdm-employee-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdmEmployeeMaster)))
            .andExpect(status().isOk());

        // Validate the MdmEmployeeMaster in the database
        List<MdmEmployeeMaster> mdmEmployeeMasterList = mdmEmployeeMasterRepository.findAll();
        assertThat(mdmEmployeeMasterList).hasSize(databaseSizeBeforeUpdate);
        MdmEmployeeMaster testMdmEmployeeMaster = mdmEmployeeMasterList.get(mdmEmployeeMasterList.size() - 1);
        assertThat(testMdmEmployeeMaster.getSyspk()).isEqualTo(UPDATED_SYSPK);
        assertThat(testMdmEmployeeMaster.getEmployeeCode()).isEqualTo(UPDATED_EMPLOYEE_CODE);
        assertThat(testMdmEmployeeMaster.getTempRefId()).isEqualTo(UPDATED_TEMP_REF_ID);
        assertThat(testMdmEmployeeMaster.getEmployeeId()).isEqualTo(UPDATED_EMPLOYEE_ID);
        assertThat(testMdmEmployeeMaster.getEmployeeName()).isEqualTo(UPDATED_EMPLOYEE_NAME);
        assertThat(testMdmEmployeeMaster.getEntityName()).isEqualTo(UPDATED_ENTITY_NAME);
        assertThat(testMdmEmployeeMaster.getOrganizationName()).isEqualTo(UPDATED_ORGANIZATION_NAME);
        assertThat(testMdmEmployeeMaster.getDesignationId()).isEqualTo(UPDATED_DESIGNATION_ID);
        assertThat(testMdmEmployeeMaster.getDesignationName()).isEqualTo(UPDATED_DESIGNATION_NAME);
        assertThat(testMdmEmployeeMaster.getPostName()).isEqualTo(UPDATED_POST_NAME);
        assertThat(testMdmEmployeeMaster.getOrganizationUnitName()).isEqualTo(UPDATED_ORGANIZATION_UNIT_NAME);
        assertThat(testMdmEmployeeMaster.getParentOrganizationUnit()).isEqualTo(UPDATED_PARENT_ORGANIZATION_UNIT);
        assertThat(testMdmEmployeeMaster.getMobileNumber()).isEqualTo(UPDATED_MOBILE_NUMBER);
        assertThat(testMdmEmployeeMaster.getEmailId()).isEqualTo(UPDATED_EMAIL_ID);
        assertThat(testMdmEmployeeMaster.getAddressType()).isEqualTo(UPDATED_ADDRESS_TYPE);
        assertThat(testMdmEmployeeMaster.getAddress1()).isEqualTo(UPDATED_ADDRESS_1);
        assertThat(testMdmEmployeeMaster.getAddress2()).isEqualTo(UPDATED_ADDRESS_2);
        assertThat(testMdmEmployeeMaster.getCityName()).isEqualTo(UPDATED_CITY_NAME);
        assertThat(testMdmEmployeeMaster.getPostOffice()).isEqualTo(UPDATED_POST_OFFICE);
        assertThat(testMdmEmployeeMaster.getIsPrimary()).isEqualTo(UPDATED_IS_PRIMARY);
        assertThat(testMdmEmployeeMaster.getIsOuHead()).isEqualTo(UPDATED_IS_OU_HEAD);
        assertThat(testMdmEmployeeMaster.getDistrictCode()).isEqualTo(UPDATED_DISTRICT_CODE);
        assertThat(testMdmEmployeeMaster.getDistrictName()).isEqualTo(UPDATED_DISTRICT_NAME);
        assertThat(testMdmEmployeeMaster.getMandalCode()).isEqualTo(UPDATED_MANDAL_CODE);
        assertThat(testMdmEmployeeMaster.getMandalName()).isEqualTo(UPDATED_MANDAL_NAME);
        assertThat(testMdmEmployeeMaster.getVillageCode()).isEqualTo(UPDATED_VILLAGE_CODE);
        assertThat(testMdmEmployeeMaster.getVillageName()).isEqualTo(UPDATED_VILLAGE_NAME);
        assertThat(testMdmEmployeeMaster.getPanchayatCode()).isEqualTo(UPDATED_PANCHAYAT_CODE);
        assertThat(testMdmEmployeeMaster.getPanchayatName()).isEqualTo(UPDATED_PANCHAYAT_NAME);
        assertThat(testMdmEmployeeMaster.getConstituencyCode()).isEqualTo(UPDATED_CONSTITUENCY_CODE);
        assertThat(testMdmEmployeeMaster.getConstituencyName()).isEqualTo(UPDATED_CONSTITUENCY_NAME);
        assertThat(testMdmEmployeeMaster.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testMdmEmployeeMaster.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testMdmEmployeeMaster.getRecordInsertTime()).isEqualTo(UPDATED_RECORD_INSERT_TIME);
        assertThat(testMdmEmployeeMaster.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testMdmEmployeeMaster.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
        assertThat(testMdmEmployeeMaster.getEmployeeType()).isEqualTo(UPDATED_EMPLOYEE_TYPE);
        assertThat(testMdmEmployeeMaster.getManagerEmployeeCode()).isEqualTo(UPDATED_MANAGER_EMPLOYEE_CODE);
        assertThat(testMdmEmployeeMaster.getEmployeeActiveStatus()).isEqualTo(UPDATED_EMPLOYEE_ACTIVE_STATUS);
        assertThat(testMdmEmployeeMaster.getPersonId1()).isEqualTo(UPDATED_PERSON_ID_1);
        assertThat(testMdmEmployeeMaster.getAadhaarRefId()).isEqualTo(UPDATED_AADHAAR_REF_ID);
        assertThat(testMdmEmployeeMaster.getVolunteerSecretariatId()).isEqualTo(UPDATED_VOLUNTEER_SECRETARIAT_ID);
        assertThat(testMdmEmployeeMaster.getVolunteerSecretariatFlag()).isEqualTo(UPDATED_VOLUNTEER_SECRETARIAT_FLAG);
        assertThat(testMdmEmployeeMaster.getAadhaarNumber()).isEqualTo(UPDATED_AADHAAR_NUMBER);
    }

    @Test
    @Transactional
    public void updateNonExistingMdmEmployeeMaster() throws Exception {
        int databaseSizeBeforeUpdate = mdmEmployeeMasterRepository.findAll().size();

        // Create the MdmEmployeeMaster

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdmEmployeeMasterMockMvc.perform(put("/api/mdm-employee-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmployeeMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmEmployeeMaster in the database
        List<MdmEmployeeMaster> mdmEmployeeMasterList = mdmEmployeeMasterRepository.findAll();
        assertThat(mdmEmployeeMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdmEmployeeMaster() throws Exception {
        // Initialize the database
        mdmEmployeeMasterRepository.saveAndFlush(mdmEmployeeMaster);

        int databaseSizeBeforeDelete = mdmEmployeeMasterRepository.findAll().size();

        // Delete the mdmEmployeeMaster
        restMdmEmployeeMasterMockMvc.perform(delete("/api/mdm-employee-masters/{id}", mdmEmployeeMaster.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdmEmployeeMaster> mdmEmployeeMasterList = mdmEmployeeMasterRepository.findAll();
        assertThat(mdmEmployeeMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
