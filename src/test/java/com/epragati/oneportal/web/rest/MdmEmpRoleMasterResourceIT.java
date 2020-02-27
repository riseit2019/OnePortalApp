package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.OnePortalApp;
import com.epragati.oneportal.domain.MdmEmpRoleMaster;
import com.epragati.oneportal.repository.MdmEmpRoleMasterRepository;
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
 * Integration tests for the {@link MdmEmpRoleMasterResource} REST controller.
 */
@SpringBootTest(classes = OnePortalApp.class)
public class MdmEmpRoleMasterResourceIT {

    private static final Long DEFAULT_SYSPK = 1L;
    private static final Long UPDATED_SYSPK = 2L;

    private static final String DEFAULT_EMPLOYEE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_OFFICE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_OFFICE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_OFFICE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_OFFICE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_ID = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_STATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_STATE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_STATE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_STATE_NAME = "BBBBBBBBBB";

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

    private static final String DEFAULT_CIRCLE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CIRCLE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DIVISION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DIVISION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SUB_DIVISION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SUB_DIVISION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SECTION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SECTION_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_ACTIVE_STATUS_FLAG = 1;
    private static final Integer UPDATED_ACTIVE_STATUS_FLAG = 2;

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

    private static final String DEFAULT_VOLUNTEER_SECRETARIAT_ROLE = "AAAAAAAAAA";
    private static final String UPDATED_VOLUNTEER_SECRETARIAT_ROLE = "BBBBBBBBBB";

    @Autowired
    private MdmEmpRoleMasterRepository mdmEmpRoleMasterRepository;

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

    private MockMvc restMdmEmpRoleMasterMockMvc;

    private MdmEmpRoleMaster mdmEmpRoleMaster;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdmEmpRoleMasterResource mdmEmpRoleMasterResource = new MdmEmpRoleMasterResource(mdmEmpRoleMasterRepository);
        this.restMdmEmpRoleMasterMockMvc = MockMvcBuilders.standaloneSetup(mdmEmpRoleMasterResource)
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
    public static MdmEmpRoleMaster createEntity(EntityManager em) {
        MdmEmpRoleMaster mdmEmpRoleMaster = new MdmEmpRoleMaster()
            .syspk(DEFAULT_SYSPK)
            .employeeName(DEFAULT_EMPLOYEE_NAME)
            .roleName(DEFAULT_ROLE_NAME)
            .officeCode(DEFAULT_OFFICE_CODE)
            .officeName(DEFAULT_OFFICE_NAME)
            .personId(DEFAULT_PERSON_ID)
            .organizationName(DEFAULT_ORGANIZATION_NAME)
            .stateCode(DEFAULT_STATE_CODE)
            .stateName(DEFAULT_STATE_NAME)
            .districtCode(DEFAULT_DISTRICT_CODE)
            .districtName(DEFAULT_DISTRICT_NAME)
            .mandalCode(DEFAULT_MANDAL_CODE)
            .mandalName(DEFAULT_MANDAL_NAME)
            .villageCode(DEFAULT_VILLAGE_CODE)
            .villageName(DEFAULT_VILLAGE_NAME)
            .circleName(DEFAULT_CIRCLE_NAME)
            .divisionName(DEFAULT_DIVISION_NAME)
            .subDivisionName(DEFAULT_SUB_DIVISION_NAME)
            .sectionName(DEFAULT_SECTION_NAME)
            .activeStatusFlag(DEFAULT_ACTIVE_STATUS_FLAG)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedBy(DEFAULT_UPDATED_BY)
            .recordInsertTime(DEFAULT_RECORD_INSERT_TIME)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME)
            .volunteerSecretariatRole(DEFAULT_VOLUNTEER_SECRETARIAT_ROLE);
        return mdmEmpRoleMaster;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmEmpRoleMaster createUpdatedEntity(EntityManager em) {
        MdmEmpRoleMaster mdmEmpRoleMaster = new MdmEmpRoleMaster()
            .syspk(UPDATED_SYSPK)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .roleName(UPDATED_ROLE_NAME)
            .officeCode(UPDATED_OFFICE_CODE)
            .officeName(UPDATED_OFFICE_NAME)
            .personId(UPDATED_PERSON_ID)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .stateCode(UPDATED_STATE_CODE)
            .stateName(UPDATED_STATE_NAME)
            .districtCode(UPDATED_DISTRICT_CODE)
            .districtName(UPDATED_DISTRICT_NAME)
            .mandalCode(UPDATED_MANDAL_CODE)
            .mandalName(UPDATED_MANDAL_NAME)
            .villageCode(UPDATED_VILLAGE_CODE)
            .villageName(UPDATED_VILLAGE_NAME)
            .circleName(UPDATED_CIRCLE_NAME)
            .divisionName(UPDATED_DIVISION_NAME)
            .subDivisionName(UPDATED_SUB_DIVISION_NAME)
            .sectionName(UPDATED_SECTION_NAME)
            .activeStatusFlag(UPDATED_ACTIVE_STATUS_FLAG)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .volunteerSecretariatRole(UPDATED_VOLUNTEER_SECRETARIAT_ROLE);
        return mdmEmpRoleMaster;
    }

    @BeforeEach
    public void initTest() {
        mdmEmpRoleMaster = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdmEmpRoleMaster() throws Exception {
        int databaseSizeBeforeCreate = mdmEmpRoleMasterRepository.findAll().size();

        // Create the MdmEmpRoleMaster
        restMdmEmpRoleMasterMockMvc.perform(post("/api/mdm-emp-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmpRoleMaster)))
            .andExpect(status().isCreated());

        // Validate the MdmEmpRoleMaster in the database
        List<MdmEmpRoleMaster> mdmEmpRoleMasterList = mdmEmpRoleMasterRepository.findAll();
        assertThat(mdmEmpRoleMasterList).hasSize(databaseSizeBeforeCreate + 1);
        MdmEmpRoleMaster testMdmEmpRoleMaster = mdmEmpRoleMasterList.get(mdmEmpRoleMasterList.size() - 1);
        assertThat(testMdmEmpRoleMaster.getSyspk()).isEqualTo(DEFAULT_SYSPK);
        assertThat(testMdmEmpRoleMaster.getEmployeeName()).isEqualTo(DEFAULT_EMPLOYEE_NAME);
        assertThat(testMdmEmpRoleMaster.getRoleName()).isEqualTo(DEFAULT_ROLE_NAME);
        assertThat(testMdmEmpRoleMaster.getOfficeCode()).isEqualTo(DEFAULT_OFFICE_CODE);
        assertThat(testMdmEmpRoleMaster.getOfficeName()).isEqualTo(DEFAULT_OFFICE_NAME);
        assertThat(testMdmEmpRoleMaster.getPersonId()).isEqualTo(DEFAULT_PERSON_ID);
        assertThat(testMdmEmpRoleMaster.getOrganizationName()).isEqualTo(DEFAULT_ORGANIZATION_NAME);
        assertThat(testMdmEmpRoleMaster.getStateCode()).isEqualTo(DEFAULT_STATE_CODE);
        assertThat(testMdmEmpRoleMaster.getStateName()).isEqualTo(DEFAULT_STATE_NAME);
        assertThat(testMdmEmpRoleMaster.getDistrictCode()).isEqualTo(DEFAULT_DISTRICT_CODE);
        assertThat(testMdmEmpRoleMaster.getDistrictName()).isEqualTo(DEFAULT_DISTRICT_NAME);
        assertThat(testMdmEmpRoleMaster.getMandalCode()).isEqualTo(DEFAULT_MANDAL_CODE);
        assertThat(testMdmEmpRoleMaster.getMandalName()).isEqualTo(DEFAULT_MANDAL_NAME);
        assertThat(testMdmEmpRoleMaster.getVillageCode()).isEqualTo(DEFAULT_VILLAGE_CODE);
        assertThat(testMdmEmpRoleMaster.getVillageName()).isEqualTo(DEFAULT_VILLAGE_NAME);
        assertThat(testMdmEmpRoleMaster.getCircleName()).isEqualTo(DEFAULT_CIRCLE_NAME);
        assertThat(testMdmEmpRoleMaster.getDivisionName()).isEqualTo(DEFAULT_DIVISION_NAME);
        assertThat(testMdmEmpRoleMaster.getSubDivisionName()).isEqualTo(DEFAULT_SUB_DIVISION_NAME);
        assertThat(testMdmEmpRoleMaster.getSectionName()).isEqualTo(DEFAULT_SECTION_NAME);
        assertThat(testMdmEmpRoleMaster.getActiveStatusFlag()).isEqualTo(DEFAULT_ACTIVE_STATUS_FLAG);
        assertThat(testMdmEmpRoleMaster.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testMdmEmpRoleMaster.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testMdmEmpRoleMaster.getRecordInsertTime()).isEqualTo(DEFAULT_RECORD_INSERT_TIME);
        assertThat(testMdmEmpRoleMaster.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testMdmEmpRoleMaster.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
        assertThat(testMdmEmpRoleMaster.getVolunteerSecretariatRole()).isEqualTo(DEFAULT_VOLUNTEER_SECRETARIAT_ROLE);
    }

    @Test
    @Transactional
    public void createMdmEmpRoleMasterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdmEmpRoleMasterRepository.findAll().size();

        // Create the MdmEmpRoleMaster with an existing ID
        mdmEmpRoleMaster.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdmEmpRoleMasterMockMvc.perform(post("/api/mdm-emp-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmpRoleMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmEmpRoleMaster in the database
        List<MdmEmpRoleMaster> mdmEmpRoleMasterList = mdmEmpRoleMasterRepository.findAll();
        assertThat(mdmEmpRoleMasterList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkSyspkIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmEmpRoleMasterRepository.findAll().size();
        // set the field null
        mdmEmpRoleMaster.setSyspk(null);

        // Create the MdmEmpRoleMaster, which fails.

        restMdmEmpRoleMasterMockMvc.perform(post("/api/mdm-emp-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmpRoleMaster)))
            .andExpect(status().isBadRequest());

        List<MdmEmpRoleMaster> mdmEmpRoleMasterList = mdmEmpRoleMasterRepository.findAll();
        assertThat(mdmEmpRoleMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOfficeCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmEmpRoleMasterRepository.findAll().size();
        // set the field null
        mdmEmpRoleMaster.setOfficeCode(null);

        // Create the MdmEmpRoleMaster, which fails.

        restMdmEmpRoleMasterMockMvc.perform(post("/api/mdm-emp-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmpRoleMaster)))
            .andExpect(status().isBadRequest());

        List<MdmEmpRoleMaster> mdmEmpRoleMasterList = mdmEmpRoleMasterRepository.findAll();
        assertThat(mdmEmpRoleMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMdmEmpRoleMasters() throws Exception {
        // Initialize the database
        mdmEmpRoleMasterRepository.saveAndFlush(mdmEmpRoleMaster);

        // Get all the mdmEmpRoleMasterList
        restMdmEmpRoleMasterMockMvc.perform(get("/api/mdm-emp-role-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdmEmpRoleMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].syspk").value(hasItem(DEFAULT_SYSPK.intValue())))
            .andExpect(jsonPath("$.[*].employeeName").value(hasItem(DEFAULT_EMPLOYEE_NAME)))
            .andExpect(jsonPath("$.[*].roleName").value(hasItem(DEFAULT_ROLE_NAME)))
            .andExpect(jsonPath("$.[*].officeCode").value(hasItem(DEFAULT_OFFICE_CODE)))
            .andExpect(jsonPath("$.[*].officeName").value(hasItem(DEFAULT_OFFICE_NAME)))
            .andExpect(jsonPath("$.[*].personId").value(hasItem(DEFAULT_PERSON_ID)))
            .andExpect(jsonPath("$.[*].organizationName").value(hasItem(DEFAULT_ORGANIZATION_NAME)))
            .andExpect(jsonPath("$.[*].stateCode").value(hasItem(DEFAULT_STATE_CODE)))
            .andExpect(jsonPath("$.[*].stateName").value(hasItem(DEFAULT_STATE_NAME)))
            .andExpect(jsonPath("$.[*].districtCode").value(hasItem(DEFAULT_DISTRICT_CODE)))
            .andExpect(jsonPath("$.[*].districtName").value(hasItem(DEFAULT_DISTRICT_NAME)))
            .andExpect(jsonPath("$.[*].mandalCode").value(hasItem(DEFAULT_MANDAL_CODE)))
            .andExpect(jsonPath("$.[*].mandalName").value(hasItem(DEFAULT_MANDAL_NAME)))
            .andExpect(jsonPath("$.[*].villageCode").value(hasItem(DEFAULT_VILLAGE_CODE)))
            .andExpect(jsonPath("$.[*].villageName").value(hasItem(DEFAULT_VILLAGE_NAME)))
            .andExpect(jsonPath("$.[*].circleName").value(hasItem(DEFAULT_CIRCLE_NAME)))
            .andExpect(jsonPath("$.[*].divisionName").value(hasItem(DEFAULT_DIVISION_NAME)))
            .andExpect(jsonPath("$.[*].subDivisionName").value(hasItem(DEFAULT_SUB_DIVISION_NAME)))
            .andExpect(jsonPath("$.[*].sectionName").value(hasItem(DEFAULT_SECTION_NAME)))
            .andExpect(jsonPath("$.[*].activeStatusFlag").value(hasItem(DEFAULT_ACTIVE_STATUS_FLAG)))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].recordInsertTime").value(hasItem(DEFAULT_RECORD_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].volunteerSecretariatRole").value(hasItem(DEFAULT_VOLUNTEER_SECRETARIAT_ROLE)));
    }
    
    @Test
    @Transactional
    public void getMdmEmpRoleMaster() throws Exception {
        // Initialize the database
        mdmEmpRoleMasterRepository.saveAndFlush(mdmEmpRoleMaster);

        // Get the mdmEmpRoleMaster
        restMdmEmpRoleMasterMockMvc.perform(get("/api/mdm-emp-role-masters/{id}", mdmEmpRoleMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mdmEmpRoleMaster.getId().intValue()))
            .andExpect(jsonPath("$.syspk").value(DEFAULT_SYSPK.intValue()))
            .andExpect(jsonPath("$.employeeName").value(DEFAULT_EMPLOYEE_NAME))
            .andExpect(jsonPath("$.roleName").value(DEFAULT_ROLE_NAME))
            .andExpect(jsonPath("$.officeCode").value(DEFAULT_OFFICE_CODE))
            .andExpect(jsonPath("$.officeName").value(DEFAULT_OFFICE_NAME))
            .andExpect(jsonPath("$.personId").value(DEFAULT_PERSON_ID))
            .andExpect(jsonPath("$.organizationName").value(DEFAULT_ORGANIZATION_NAME))
            .andExpect(jsonPath("$.stateCode").value(DEFAULT_STATE_CODE))
            .andExpect(jsonPath("$.stateName").value(DEFAULT_STATE_NAME))
            .andExpect(jsonPath("$.districtCode").value(DEFAULT_DISTRICT_CODE))
            .andExpect(jsonPath("$.districtName").value(DEFAULT_DISTRICT_NAME))
            .andExpect(jsonPath("$.mandalCode").value(DEFAULT_MANDAL_CODE))
            .andExpect(jsonPath("$.mandalName").value(DEFAULT_MANDAL_NAME))
            .andExpect(jsonPath("$.villageCode").value(DEFAULT_VILLAGE_CODE))
            .andExpect(jsonPath("$.villageName").value(DEFAULT_VILLAGE_NAME))
            .andExpect(jsonPath("$.circleName").value(DEFAULT_CIRCLE_NAME))
            .andExpect(jsonPath("$.divisionName").value(DEFAULT_DIVISION_NAME))
            .andExpect(jsonPath("$.subDivisionName").value(DEFAULT_SUB_DIVISION_NAME))
            .andExpect(jsonPath("$.sectionName").value(DEFAULT_SECTION_NAME))
            .andExpect(jsonPath("$.activeStatusFlag").value(DEFAULT_ACTIVE_STATUS_FLAG))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.recordInsertTime").value(DEFAULT_RECORD_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()))
            .andExpect(jsonPath("$.volunteerSecretariatRole").value(DEFAULT_VOLUNTEER_SECRETARIAT_ROLE));
    }

    @Test
    @Transactional
    public void getNonExistingMdmEmpRoleMaster() throws Exception {
        // Get the mdmEmpRoleMaster
        restMdmEmpRoleMasterMockMvc.perform(get("/api/mdm-emp-role-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdmEmpRoleMaster() throws Exception {
        // Initialize the database
        mdmEmpRoleMasterRepository.saveAndFlush(mdmEmpRoleMaster);

        int databaseSizeBeforeUpdate = mdmEmpRoleMasterRepository.findAll().size();

        // Update the mdmEmpRoleMaster
        MdmEmpRoleMaster updatedMdmEmpRoleMaster = mdmEmpRoleMasterRepository.findById(mdmEmpRoleMaster.getId()).get();
        // Disconnect from session so that the updates on updatedMdmEmpRoleMaster are not directly saved in db
        em.detach(updatedMdmEmpRoleMaster);
        updatedMdmEmpRoleMaster
            .syspk(UPDATED_SYSPK)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .roleName(UPDATED_ROLE_NAME)
            .officeCode(UPDATED_OFFICE_CODE)
            .officeName(UPDATED_OFFICE_NAME)
            .personId(UPDATED_PERSON_ID)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .stateCode(UPDATED_STATE_CODE)
            .stateName(UPDATED_STATE_NAME)
            .districtCode(UPDATED_DISTRICT_CODE)
            .districtName(UPDATED_DISTRICT_NAME)
            .mandalCode(UPDATED_MANDAL_CODE)
            .mandalName(UPDATED_MANDAL_NAME)
            .villageCode(UPDATED_VILLAGE_CODE)
            .villageName(UPDATED_VILLAGE_NAME)
            .circleName(UPDATED_CIRCLE_NAME)
            .divisionName(UPDATED_DIVISION_NAME)
            .subDivisionName(UPDATED_SUB_DIVISION_NAME)
            .sectionName(UPDATED_SECTION_NAME)
            .activeStatusFlag(UPDATED_ACTIVE_STATUS_FLAG)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .volunteerSecretariatRole(UPDATED_VOLUNTEER_SECRETARIAT_ROLE);

        restMdmEmpRoleMasterMockMvc.perform(put("/api/mdm-emp-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdmEmpRoleMaster)))
            .andExpect(status().isOk());

        // Validate the MdmEmpRoleMaster in the database
        List<MdmEmpRoleMaster> mdmEmpRoleMasterList = mdmEmpRoleMasterRepository.findAll();
        assertThat(mdmEmpRoleMasterList).hasSize(databaseSizeBeforeUpdate);
        MdmEmpRoleMaster testMdmEmpRoleMaster = mdmEmpRoleMasterList.get(mdmEmpRoleMasterList.size() - 1);
        assertThat(testMdmEmpRoleMaster.getSyspk()).isEqualTo(UPDATED_SYSPK);
        assertThat(testMdmEmpRoleMaster.getEmployeeName()).isEqualTo(UPDATED_EMPLOYEE_NAME);
        assertThat(testMdmEmpRoleMaster.getRoleName()).isEqualTo(UPDATED_ROLE_NAME);
        assertThat(testMdmEmpRoleMaster.getOfficeCode()).isEqualTo(UPDATED_OFFICE_CODE);
        assertThat(testMdmEmpRoleMaster.getOfficeName()).isEqualTo(UPDATED_OFFICE_NAME);
        assertThat(testMdmEmpRoleMaster.getPersonId()).isEqualTo(UPDATED_PERSON_ID);
        assertThat(testMdmEmpRoleMaster.getOrganizationName()).isEqualTo(UPDATED_ORGANIZATION_NAME);
        assertThat(testMdmEmpRoleMaster.getStateCode()).isEqualTo(UPDATED_STATE_CODE);
        assertThat(testMdmEmpRoleMaster.getStateName()).isEqualTo(UPDATED_STATE_NAME);
        assertThat(testMdmEmpRoleMaster.getDistrictCode()).isEqualTo(UPDATED_DISTRICT_CODE);
        assertThat(testMdmEmpRoleMaster.getDistrictName()).isEqualTo(UPDATED_DISTRICT_NAME);
        assertThat(testMdmEmpRoleMaster.getMandalCode()).isEqualTo(UPDATED_MANDAL_CODE);
        assertThat(testMdmEmpRoleMaster.getMandalName()).isEqualTo(UPDATED_MANDAL_NAME);
        assertThat(testMdmEmpRoleMaster.getVillageCode()).isEqualTo(UPDATED_VILLAGE_CODE);
        assertThat(testMdmEmpRoleMaster.getVillageName()).isEqualTo(UPDATED_VILLAGE_NAME);
        assertThat(testMdmEmpRoleMaster.getCircleName()).isEqualTo(UPDATED_CIRCLE_NAME);
        assertThat(testMdmEmpRoleMaster.getDivisionName()).isEqualTo(UPDATED_DIVISION_NAME);
        assertThat(testMdmEmpRoleMaster.getSubDivisionName()).isEqualTo(UPDATED_SUB_DIVISION_NAME);
        assertThat(testMdmEmpRoleMaster.getSectionName()).isEqualTo(UPDATED_SECTION_NAME);
        assertThat(testMdmEmpRoleMaster.getActiveStatusFlag()).isEqualTo(UPDATED_ACTIVE_STATUS_FLAG);
        assertThat(testMdmEmpRoleMaster.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testMdmEmpRoleMaster.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testMdmEmpRoleMaster.getRecordInsertTime()).isEqualTo(UPDATED_RECORD_INSERT_TIME);
        assertThat(testMdmEmpRoleMaster.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testMdmEmpRoleMaster.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
        assertThat(testMdmEmpRoleMaster.getVolunteerSecretariatRole()).isEqualTo(UPDATED_VOLUNTEER_SECRETARIAT_ROLE);
    }

    @Test
    @Transactional
    public void updateNonExistingMdmEmpRoleMaster() throws Exception {
        int databaseSizeBeforeUpdate = mdmEmpRoleMasterRepository.findAll().size();

        // Create the MdmEmpRoleMaster

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdmEmpRoleMasterMockMvc.perform(put("/api/mdm-emp-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmEmpRoleMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmEmpRoleMaster in the database
        List<MdmEmpRoleMaster> mdmEmpRoleMasterList = mdmEmpRoleMasterRepository.findAll();
        assertThat(mdmEmpRoleMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdmEmpRoleMaster() throws Exception {
        // Initialize the database
        mdmEmpRoleMasterRepository.saveAndFlush(mdmEmpRoleMaster);

        int databaseSizeBeforeDelete = mdmEmpRoleMasterRepository.findAll().size();

        // Delete the mdmEmpRoleMaster
        restMdmEmpRoleMasterMockMvc.perform(delete("/api/mdm-emp-role-masters/{id}", mdmEmpRoleMaster.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdmEmpRoleMaster> mdmEmpRoleMasterList = mdmEmpRoleMasterRepository.findAll();
        assertThat(mdmEmpRoleMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
