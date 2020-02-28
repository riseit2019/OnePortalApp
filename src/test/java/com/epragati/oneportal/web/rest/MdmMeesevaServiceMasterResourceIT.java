package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.OnePortalApp;
import com.epragati.oneportal.domain.MdmMeesevaServiceMaster;
import com.epragati.oneportal.repository.MdmMeesevaServiceMasterRepository;
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
 * Integration tests for the {@link MdmMeesevaServiceMasterResource} REST controller.
 */
@SpringBootTest(classes = OnePortalApp.class)
public class MdmMeesevaServiceMasterResourceIT {

    private static final Long DEFAULT_SYSPK = 1L;
    private static final Long UPDATED_SYSPK = 2L;

    private static final Integer DEFAULT_MEESEVA_SERVICE_ID = 1;
    private static final Integer UPDATED_MEESEVA_SERVICE_ID = 2;

    private static final String DEFAULT_MEESEVA_SERVICE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MEESEVA_SERVICE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_IS_CHARGED = "AAAAAAAAAA";
    private static final String UPDATED_IS_CHARGED = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_ENTITY_TYPE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_ENTITY_TYPE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_APPLICATION_TABLE = "AAAAAAAAAA";
    private static final String UPDATED_APPLICATION_TABLE = "BBBBBBBBBB";

    private static final String DEFAULT_APPLICATION_OBJECT = "AAAAAAAAAA";
    private static final String UPDATED_APPLICATION_OBJECT = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_DEFAULT_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_DEFAULT_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_CHANNEL_DEFAULT_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_CHANNEL_DEFAULT_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_URL = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_URL = "BBBBBBBBBB";

    private static final String DEFAULT_BACK_OFFICE_URL = "AAAAAAAAAA";
    private static final String UPDATED_BACK_OFFICE_URL = "BBBBBBBBBB";

    private static final Integer DEFAULT_PACKAGE_ID = 1;
    private static final Integer UPDATED_PACKAGE_ID = 2;

    private static final String DEFAULT_MEESEVA_SERVICE_ACTIVE_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_MEESEVA_SERVICE_ACTIVE_FLAG = "BBBBBBBBBB";

    private static final Integer DEFAULT_MEESEVA_SERVICE_GROUP_ID = 1;
    private static final Integer UPDATED_MEESEVA_SERVICE_GROUP_ID = 2;

    private static final Integer DEFAULT_MEESEVA_SERVICE_SUB_GROUP_ID = 1;
    private static final Integer UPDATED_MEESEVA_SERVICE_SUB_GROUP_ID = 2;

    private static final Integer DEFAULT_MEESEVA_SERVICE_TYPE_ID = 1;
    private static final Integer UPDATED_MEESEVA_SERVICE_TYPE_ID = 2;

    private static final Integer DEFAULT_MEESEVA_SERVICE_SUB_TYPE_ID = 1;
    private static final Integer UPDATED_MEESEVA_SERVICE_SUB_TYPE_ID = 2;

    private static final String DEFAULT_DEPARTMENT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTMENT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_EFMS_DEPARTMENT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_EFMS_DEPARTMENT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_IS_ONLINE = "AAAAAAAAAA";
    private static final String UPDATED_IS_ONLINE = "BBBBBBBBBB";

    private static final Integer DEFAULT_AGENCY_TYPE = 1;
    private static final Integer UPDATED_AGENCY_TYPE = 2;

    private static final Instant DEFAULT_LAUNCH_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAUNCH_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_IS_MOBILE = "AAAAAAAAAA";
    private static final String UPDATED_IS_MOBILE = "BBBBBBBBBB";

    private static final Integer DEFAULT_INNER_SUB_ID = 1;
    private static final Integer UPDATED_INNER_SUB_ID = 2;

    private static final String DEFAULT_DIGILOCKER_ENABLED = "AAAAAAAAAA";
    private static final String UPDATED_DIGILOCKER_ENABLED = "BBBBBBBBBB";

    private static final String DEFAULT_IS_REGULAR = "AAAAAAAAAA";
    private static final String UPDATED_IS_REGULAR = "BBBBBBBBBB";

    private static final String DEFAULT_IS_SEASONAL = "AAAAAAAAAA";
    private static final String UPDATED_IS_SEASONAL = "BBBBBBBBBB";

    private static final Instant DEFAULT_CITIZEN_PORTAL_LAUNCH_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CITIZEN_PORTAL_LAUNCH_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

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

    @Autowired
    private MdmMeesevaServiceMasterRepository mdmMeesevaServiceMasterRepository;

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

    private MockMvc restMdmMeesevaServiceMasterMockMvc;

    private MdmMeesevaServiceMaster mdmMeesevaServiceMaster;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdmMeesevaServiceMasterResource mdmMeesevaServiceMasterResource = new MdmMeesevaServiceMasterResource(mdmMeesevaServiceMasterRepository);
        this.restMdmMeesevaServiceMasterMockMvc = MockMvcBuilders.standaloneSetup(mdmMeesevaServiceMasterResource)
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
    public static MdmMeesevaServiceMaster createEntity(EntityManager em) {
        MdmMeesevaServiceMaster mdmMeesevaServiceMaster = new MdmMeesevaServiceMaster()
            .syspk(DEFAULT_SYSPK)
            .meesevaServiceId(DEFAULT_MEESEVA_SERVICE_ID)
            .meesevaServiceName(DEFAULT_MEESEVA_SERVICE_NAME)
            .isCharged(DEFAULT_IS_CHARGED)
            .organizationEntityTypeCode(DEFAULT_ORGANIZATION_ENTITY_TYPE_CODE)
            .applicationTable(DEFAULT_APPLICATION_TABLE)
            .applicationObject(DEFAULT_APPLICATION_OBJECT)
            .customerDefaultFlag(DEFAULT_CUSTOMER_DEFAULT_FLAG)
            .channelDefaultFlag(DEFAULT_CHANNEL_DEFAULT_FLAG)
            .serviceUrl(DEFAULT_SERVICE_URL)
            .backOfficeUrl(DEFAULT_BACK_OFFICE_URL)
            .packageId(DEFAULT_PACKAGE_ID)
            .meesevaServiceActiveFlag(DEFAULT_MEESEVA_SERVICE_ACTIVE_FLAG)
            .meesevaServiceGroupId(DEFAULT_MEESEVA_SERVICE_GROUP_ID)
            .meesevaServiceSubGroupId(DEFAULT_MEESEVA_SERVICE_SUB_GROUP_ID)
            .meesevaServiceTypeId(DEFAULT_MEESEVA_SERVICE_TYPE_ID)
            .meesevaServiceSubTypeId(DEFAULT_MEESEVA_SERVICE_SUB_TYPE_ID)
            .departmentCode(DEFAULT_DEPARTMENT_CODE)
            .efmsDepartmentCode(DEFAULT_EFMS_DEPARTMENT_CODE)
            .isOnline(DEFAULT_IS_ONLINE)
            .agencyType(DEFAULT_AGENCY_TYPE)
            .launchDate(DEFAULT_LAUNCH_DATE)
            .isMobile(DEFAULT_IS_MOBILE)
            .innerSubId(DEFAULT_INNER_SUB_ID)
            .digilockerEnabled(DEFAULT_DIGILOCKER_ENABLED)
            .isRegular(DEFAULT_IS_REGULAR)
            .isSeasonal(DEFAULT_IS_SEASONAL)
            .citizenPortalLaunchDate(DEFAULT_CITIZEN_PORTAL_LAUNCH_DATE)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedBy(DEFAULT_UPDATED_BY)
            .recordInsertTime(DEFAULT_RECORD_INSERT_TIME)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME);
        return mdmMeesevaServiceMaster;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmMeesevaServiceMaster createUpdatedEntity(EntityManager em) {
        MdmMeesevaServiceMaster mdmMeesevaServiceMaster = new MdmMeesevaServiceMaster()
            .syspk(UPDATED_SYSPK)
            .meesevaServiceId(UPDATED_MEESEVA_SERVICE_ID)
            .meesevaServiceName(UPDATED_MEESEVA_SERVICE_NAME)
            .isCharged(UPDATED_IS_CHARGED)
            .organizationEntityTypeCode(UPDATED_ORGANIZATION_ENTITY_TYPE_CODE)
            .applicationTable(UPDATED_APPLICATION_TABLE)
            .applicationObject(UPDATED_APPLICATION_OBJECT)
            .customerDefaultFlag(UPDATED_CUSTOMER_DEFAULT_FLAG)
            .channelDefaultFlag(UPDATED_CHANNEL_DEFAULT_FLAG)
            .serviceUrl(UPDATED_SERVICE_URL)
            .backOfficeUrl(UPDATED_BACK_OFFICE_URL)
            .packageId(UPDATED_PACKAGE_ID)
            .meesevaServiceActiveFlag(UPDATED_MEESEVA_SERVICE_ACTIVE_FLAG)
            .meesevaServiceGroupId(UPDATED_MEESEVA_SERVICE_GROUP_ID)
            .meesevaServiceSubGroupId(UPDATED_MEESEVA_SERVICE_SUB_GROUP_ID)
            .meesevaServiceTypeId(UPDATED_MEESEVA_SERVICE_TYPE_ID)
            .meesevaServiceSubTypeId(UPDATED_MEESEVA_SERVICE_SUB_TYPE_ID)
            .departmentCode(UPDATED_DEPARTMENT_CODE)
            .efmsDepartmentCode(UPDATED_EFMS_DEPARTMENT_CODE)
            .isOnline(UPDATED_IS_ONLINE)
            .agencyType(UPDATED_AGENCY_TYPE)
            .launchDate(UPDATED_LAUNCH_DATE)
            .isMobile(UPDATED_IS_MOBILE)
            .innerSubId(UPDATED_INNER_SUB_ID)
            .digilockerEnabled(UPDATED_DIGILOCKER_ENABLED)
            .isRegular(UPDATED_IS_REGULAR)
            .isSeasonal(UPDATED_IS_SEASONAL)
            .citizenPortalLaunchDate(UPDATED_CITIZEN_PORTAL_LAUNCH_DATE)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME);
        return mdmMeesevaServiceMaster;
    }

    @BeforeEach
    public void initTest() {
        mdmMeesevaServiceMaster = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdmMeesevaServiceMaster() throws Exception {
        int databaseSizeBeforeCreate = mdmMeesevaServiceMasterRepository.findAll().size();

        // Create the MdmMeesevaServiceMaster
        restMdmMeesevaServiceMasterMockMvc.perform(post("/api/mdm-meeseva-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmMeesevaServiceMaster)))
            .andExpect(status().isCreated());

        // Validate the MdmMeesevaServiceMaster in the database
        List<MdmMeesevaServiceMaster> mdmMeesevaServiceMasterList = mdmMeesevaServiceMasterRepository.findAll();
        assertThat(mdmMeesevaServiceMasterList).hasSize(databaseSizeBeforeCreate + 1);
        MdmMeesevaServiceMaster testMdmMeesevaServiceMaster = mdmMeesevaServiceMasterList.get(mdmMeesevaServiceMasterList.size() - 1);
        assertThat(testMdmMeesevaServiceMaster.getSyspk()).isEqualTo(DEFAULT_SYSPK);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceId()).isEqualTo(DEFAULT_MEESEVA_SERVICE_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceName()).isEqualTo(DEFAULT_MEESEVA_SERVICE_NAME);
        assertThat(testMdmMeesevaServiceMaster.getIsCharged()).isEqualTo(DEFAULT_IS_CHARGED);
        assertThat(testMdmMeesevaServiceMaster.getOrganizationEntityTypeCode()).isEqualTo(DEFAULT_ORGANIZATION_ENTITY_TYPE_CODE);
        assertThat(testMdmMeesevaServiceMaster.getApplicationTable()).isEqualTo(DEFAULT_APPLICATION_TABLE);
        assertThat(testMdmMeesevaServiceMaster.getApplicationObject()).isEqualTo(DEFAULT_APPLICATION_OBJECT);
        assertThat(testMdmMeesevaServiceMaster.getCustomerDefaultFlag()).isEqualTo(DEFAULT_CUSTOMER_DEFAULT_FLAG);
        assertThat(testMdmMeesevaServiceMaster.getChannelDefaultFlag()).isEqualTo(DEFAULT_CHANNEL_DEFAULT_FLAG);
        assertThat(testMdmMeesevaServiceMaster.getServiceUrl()).isEqualTo(DEFAULT_SERVICE_URL);
        assertThat(testMdmMeesevaServiceMaster.getBackOfficeUrl()).isEqualTo(DEFAULT_BACK_OFFICE_URL);
        assertThat(testMdmMeesevaServiceMaster.getPackageId()).isEqualTo(DEFAULT_PACKAGE_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceActiveFlag()).isEqualTo(DEFAULT_MEESEVA_SERVICE_ACTIVE_FLAG);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceGroupId()).isEqualTo(DEFAULT_MEESEVA_SERVICE_GROUP_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceSubGroupId()).isEqualTo(DEFAULT_MEESEVA_SERVICE_SUB_GROUP_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceTypeId()).isEqualTo(DEFAULT_MEESEVA_SERVICE_TYPE_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceSubTypeId()).isEqualTo(DEFAULT_MEESEVA_SERVICE_SUB_TYPE_ID);
        assertThat(testMdmMeesevaServiceMaster.getDepartmentCode()).isEqualTo(DEFAULT_DEPARTMENT_CODE);
        assertThat(testMdmMeesevaServiceMaster.getEfmsDepartmentCode()).isEqualTo(DEFAULT_EFMS_DEPARTMENT_CODE);
        assertThat(testMdmMeesevaServiceMaster.getIsOnline()).isEqualTo(DEFAULT_IS_ONLINE);
        assertThat(testMdmMeesevaServiceMaster.getAgencyType()).isEqualTo(DEFAULT_AGENCY_TYPE);
        assertThat(testMdmMeesevaServiceMaster.getLaunchDate()).isEqualTo(DEFAULT_LAUNCH_DATE);
        assertThat(testMdmMeesevaServiceMaster.getIsMobile()).isEqualTo(DEFAULT_IS_MOBILE);
        assertThat(testMdmMeesevaServiceMaster.getInnerSubId()).isEqualTo(DEFAULT_INNER_SUB_ID);
        assertThat(testMdmMeesevaServiceMaster.getDigilockerEnabled()).isEqualTo(DEFAULT_DIGILOCKER_ENABLED);
        assertThat(testMdmMeesevaServiceMaster.getIsRegular()).isEqualTo(DEFAULT_IS_REGULAR);
        assertThat(testMdmMeesevaServiceMaster.getIsSeasonal()).isEqualTo(DEFAULT_IS_SEASONAL);
        assertThat(testMdmMeesevaServiceMaster.getCitizenPortalLaunchDate()).isEqualTo(DEFAULT_CITIZEN_PORTAL_LAUNCH_DATE);
        assertThat(testMdmMeesevaServiceMaster.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testMdmMeesevaServiceMaster.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testMdmMeesevaServiceMaster.getRecordInsertTime()).isEqualTo(DEFAULT_RECORD_INSERT_TIME);
        assertThat(testMdmMeesevaServiceMaster.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testMdmMeesevaServiceMaster.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void createMdmMeesevaServiceMasterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdmMeesevaServiceMasterRepository.findAll().size();

        // Create the MdmMeesevaServiceMaster with an existing ID
        mdmMeesevaServiceMaster.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdmMeesevaServiceMasterMockMvc.perform(post("/api/mdm-meeseva-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmMeesevaServiceMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmMeesevaServiceMaster in the database
        List<MdmMeesevaServiceMaster> mdmMeesevaServiceMasterList = mdmMeesevaServiceMasterRepository.findAll();
        assertThat(mdmMeesevaServiceMasterList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkSyspkIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmMeesevaServiceMasterRepository.findAll().size();
        // set the field null
        mdmMeesevaServiceMaster.setSyspk(null);

        // Create the MdmMeesevaServiceMaster, which fails.

        restMdmMeesevaServiceMasterMockMvc.perform(post("/api/mdm-meeseva-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmMeesevaServiceMaster)))
            .andExpect(status().isBadRequest());

        List<MdmMeesevaServiceMaster> mdmMeesevaServiceMasterList = mdmMeesevaServiceMasterRepository.findAll();
        assertThat(mdmMeesevaServiceMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkMeesevaServiceIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmMeesevaServiceMasterRepository.findAll().size();
        // set the field null
        mdmMeesevaServiceMaster.setMeesevaServiceId(null);

        // Create the MdmMeesevaServiceMaster, which fails.

        restMdmMeesevaServiceMasterMockMvc.perform(post("/api/mdm-meeseva-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmMeesevaServiceMaster)))
            .andExpect(status().isBadRequest());

        List<MdmMeesevaServiceMaster> mdmMeesevaServiceMasterList = mdmMeesevaServiceMasterRepository.findAll();
        assertThat(mdmMeesevaServiceMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkMeesevaServiceNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmMeesevaServiceMasterRepository.findAll().size();
        // set the field null
        mdmMeesevaServiceMaster.setMeesevaServiceName(null);

        // Create the MdmMeesevaServiceMaster, which fails.

        restMdmMeesevaServiceMasterMockMvc.perform(post("/api/mdm-meeseva-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmMeesevaServiceMaster)))
            .andExpect(status().isBadRequest());

        List<MdmMeesevaServiceMaster> mdmMeesevaServiceMasterList = mdmMeesevaServiceMasterRepository.findAll();
        assertThat(mdmMeesevaServiceMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMdmMeesevaServiceMasters() throws Exception {
        // Initialize the database
        mdmMeesevaServiceMasterRepository.saveAndFlush(mdmMeesevaServiceMaster);

        // Get all the mdmMeesevaServiceMasterList
        restMdmMeesevaServiceMasterMockMvc.perform(get("/api/mdm-meeseva-service-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdmMeesevaServiceMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].syspk").value(hasItem(DEFAULT_SYSPK.intValue())))
            .andExpect(jsonPath("$.[*].meesevaServiceId").value(hasItem(DEFAULT_MEESEVA_SERVICE_ID)))
            .andExpect(jsonPath("$.[*].meesevaServiceName").value(hasItem(DEFAULT_MEESEVA_SERVICE_NAME)))
            .andExpect(jsonPath("$.[*].isCharged").value(hasItem(DEFAULT_IS_CHARGED)))
            .andExpect(jsonPath("$.[*].organizationEntityTypeCode").value(hasItem(DEFAULT_ORGANIZATION_ENTITY_TYPE_CODE)))
            .andExpect(jsonPath("$.[*].applicationTable").value(hasItem(DEFAULT_APPLICATION_TABLE)))
            .andExpect(jsonPath("$.[*].applicationObject").value(hasItem(DEFAULT_APPLICATION_OBJECT)))
            .andExpect(jsonPath("$.[*].customerDefaultFlag").value(hasItem(DEFAULT_CUSTOMER_DEFAULT_FLAG)))
            .andExpect(jsonPath("$.[*].channelDefaultFlag").value(hasItem(DEFAULT_CHANNEL_DEFAULT_FLAG)))
            .andExpect(jsonPath("$.[*].serviceUrl").value(hasItem(DEFAULT_SERVICE_URL)))
            .andExpect(jsonPath("$.[*].backOfficeUrl").value(hasItem(DEFAULT_BACK_OFFICE_URL)))
            .andExpect(jsonPath("$.[*].packageId").value(hasItem(DEFAULT_PACKAGE_ID)))
            .andExpect(jsonPath("$.[*].meesevaServiceActiveFlag").value(hasItem(DEFAULT_MEESEVA_SERVICE_ACTIVE_FLAG)))
            .andExpect(jsonPath("$.[*].meesevaServiceGroupId").value(hasItem(DEFAULT_MEESEVA_SERVICE_GROUP_ID)))
            .andExpect(jsonPath("$.[*].meesevaServiceSubGroupId").value(hasItem(DEFAULT_MEESEVA_SERVICE_SUB_GROUP_ID)))
            .andExpect(jsonPath("$.[*].meesevaServiceTypeId").value(hasItem(DEFAULT_MEESEVA_SERVICE_TYPE_ID)))
            .andExpect(jsonPath("$.[*].meesevaServiceSubTypeId").value(hasItem(DEFAULT_MEESEVA_SERVICE_SUB_TYPE_ID)))
            .andExpect(jsonPath("$.[*].departmentCode").value(hasItem(DEFAULT_DEPARTMENT_CODE)))
            .andExpect(jsonPath("$.[*].efmsDepartmentCode").value(hasItem(DEFAULT_EFMS_DEPARTMENT_CODE)))
            .andExpect(jsonPath("$.[*].isOnline").value(hasItem(DEFAULT_IS_ONLINE)))
            .andExpect(jsonPath("$.[*].agencyType").value(hasItem(DEFAULT_AGENCY_TYPE)))
            .andExpect(jsonPath("$.[*].launchDate").value(hasItem(DEFAULT_LAUNCH_DATE.toString())))
            .andExpect(jsonPath("$.[*].isMobile").value(hasItem(DEFAULT_IS_MOBILE)))
            .andExpect(jsonPath("$.[*].innerSubId").value(hasItem(DEFAULT_INNER_SUB_ID)))
            .andExpect(jsonPath("$.[*].digilockerEnabled").value(hasItem(DEFAULT_DIGILOCKER_ENABLED)))
            .andExpect(jsonPath("$.[*].isRegular").value(hasItem(DEFAULT_IS_REGULAR)))
            .andExpect(jsonPath("$.[*].isSeasonal").value(hasItem(DEFAULT_IS_SEASONAL)))
            .andExpect(jsonPath("$.[*].citizenPortalLaunchDate").value(hasItem(DEFAULT_CITIZEN_PORTAL_LAUNCH_DATE.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].recordInsertTime").value(hasItem(DEFAULT_RECORD_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())));
    }
    
    @Test
    @Transactional
    public void getMdmMeesevaServiceMaster() throws Exception {
        // Initialize the database
        mdmMeesevaServiceMasterRepository.saveAndFlush(mdmMeesevaServiceMaster);

        // Get the mdmMeesevaServiceMaster
        restMdmMeesevaServiceMasterMockMvc.perform(get("/api/mdm-meeseva-service-masters/{id}", mdmMeesevaServiceMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mdmMeesevaServiceMaster.getId().intValue()))
            .andExpect(jsonPath("$.syspk").value(DEFAULT_SYSPK.intValue()))
            .andExpect(jsonPath("$.meesevaServiceId").value(DEFAULT_MEESEVA_SERVICE_ID))
            .andExpect(jsonPath("$.meesevaServiceName").value(DEFAULT_MEESEVA_SERVICE_NAME))
            .andExpect(jsonPath("$.isCharged").value(DEFAULT_IS_CHARGED))
            .andExpect(jsonPath("$.organizationEntityTypeCode").value(DEFAULT_ORGANIZATION_ENTITY_TYPE_CODE))
            .andExpect(jsonPath("$.applicationTable").value(DEFAULT_APPLICATION_TABLE))
            .andExpect(jsonPath("$.applicationObject").value(DEFAULT_APPLICATION_OBJECT))
            .andExpect(jsonPath("$.customerDefaultFlag").value(DEFAULT_CUSTOMER_DEFAULT_FLAG))
            .andExpect(jsonPath("$.channelDefaultFlag").value(DEFAULT_CHANNEL_DEFAULT_FLAG))
            .andExpect(jsonPath("$.serviceUrl").value(DEFAULT_SERVICE_URL))
            .andExpect(jsonPath("$.backOfficeUrl").value(DEFAULT_BACK_OFFICE_URL))
            .andExpect(jsonPath("$.packageId").value(DEFAULT_PACKAGE_ID))
            .andExpect(jsonPath("$.meesevaServiceActiveFlag").value(DEFAULT_MEESEVA_SERVICE_ACTIVE_FLAG))
            .andExpect(jsonPath("$.meesevaServiceGroupId").value(DEFAULT_MEESEVA_SERVICE_GROUP_ID))
            .andExpect(jsonPath("$.meesevaServiceSubGroupId").value(DEFAULT_MEESEVA_SERVICE_SUB_GROUP_ID))
            .andExpect(jsonPath("$.meesevaServiceTypeId").value(DEFAULT_MEESEVA_SERVICE_TYPE_ID))
            .andExpect(jsonPath("$.meesevaServiceSubTypeId").value(DEFAULT_MEESEVA_SERVICE_SUB_TYPE_ID))
            .andExpect(jsonPath("$.departmentCode").value(DEFAULT_DEPARTMENT_CODE))
            .andExpect(jsonPath("$.efmsDepartmentCode").value(DEFAULT_EFMS_DEPARTMENT_CODE))
            .andExpect(jsonPath("$.isOnline").value(DEFAULT_IS_ONLINE))
            .andExpect(jsonPath("$.agencyType").value(DEFAULT_AGENCY_TYPE))
            .andExpect(jsonPath("$.launchDate").value(DEFAULT_LAUNCH_DATE.toString()))
            .andExpect(jsonPath("$.isMobile").value(DEFAULT_IS_MOBILE))
            .andExpect(jsonPath("$.innerSubId").value(DEFAULT_INNER_SUB_ID))
            .andExpect(jsonPath("$.digilockerEnabled").value(DEFAULT_DIGILOCKER_ENABLED))
            .andExpect(jsonPath("$.isRegular").value(DEFAULT_IS_REGULAR))
            .andExpect(jsonPath("$.isSeasonal").value(DEFAULT_IS_SEASONAL))
            .andExpect(jsonPath("$.citizenPortalLaunchDate").value(DEFAULT_CITIZEN_PORTAL_LAUNCH_DATE.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.recordInsertTime").value(DEFAULT_RECORD_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingMdmMeesevaServiceMaster() throws Exception {
        // Get the mdmMeesevaServiceMaster
        restMdmMeesevaServiceMasterMockMvc.perform(get("/api/mdm-meeseva-service-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdmMeesevaServiceMaster() throws Exception {
        // Initialize the database
        mdmMeesevaServiceMasterRepository.saveAndFlush(mdmMeesevaServiceMaster);

        int databaseSizeBeforeUpdate = mdmMeesevaServiceMasterRepository.findAll().size();

        // Update the mdmMeesevaServiceMaster
        MdmMeesevaServiceMaster updatedMdmMeesevaServiceMaster = mdmMeesevaServiceMasterRepository.findById(mdmMeesevaServiceMaster.getId()).get();
        // Disconnect from session so that the updates on updatedMdmMeesevaServiceMaster are not directly saved in db
        em.detach(updatedMdmMeesevaServiceMaster);
        updatedMdmMeesevaServiceMaster
            .syspk(UPDATED_SYSPK)
            .meesevaServiceId(UPDATED_MEESEVA_SERVICE_ID)
            .meesevaServiceName(UPDATED_MEESEVA_SERVICE_NAME)
            .isCharged(UPDATED_IS_CHARGED)
            .organizationEntityTypeCode(UPDATED_ORGANIZATION_ENTITY_TYPE_CODE)
            .applicationTable(UPDATED_APPLICATION_TABLE)
            .applicationObject(UPDATED_APPLICATION_OBJECT)
            .customerDefaultFlag(UPDATED_CUSTOMER_DEFAULT_FLAG)
            .channelDefaultFlag(UPDATED_CHANNEL_DEFAULT_FLAG)
            .serviceUrl(UPDATED_SERVICE_URL)
            .backOfficeUrl(UPDATED_BACK_OFFICE_URL)
            .packageId(UPDATED_PACKAGE_ID)
            .meesevaServiceActiveFlag(UPDATED_MEESEVA_SERVICE_ACTIVE_FLAG)
            .meesevaServiceGroupId(UPDATED_MEESEVA_SERVICE_GROUP_ID)
            .meesevaServiceSubGroupId(UPDATED_MEESEVA_SERVICE_SUB_GROUP_ID)
            .meesevaServiceTypeId(UPDATED_MEESEVA_SERVICE_TYPE_ID)
            .meesevaServiceSubTypeId(UPDATED_MEESEVA_SERVICE_SUB_TYPE_ID)
            .departmentCode(UPDATED_DEPARTMENT_CODE)
            .efmsDepartmentCode(UPDATED_EFMS_DEPARTMENT_CODE)
            .isOnline(UPDATED_IS_ONLINE)
            .agencyType(UPDATED_AGENCY_TYPE)
            .launchDate(UPDATED_LAUNCH_DATE)
            .isMobile(UPDATED_IS_MOBILE)
            .innerSubId(UPDATED_INNER_SUB_ID)
            .digilockerEnabled(UPDATED_DIGILOCKER_ENABLED)
            .isRegular(UPDATED_IS_REGULAR)
            .isSeasonal(UPDATED_IS_SEASONAL)
            .citizenPortalLaunchDate(UPDATED_CITIZEN_PORTAL_LAUNCH_DATE)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME);

        restMdmMeesevaServiceMasterMockMvc.perform(put("/api/mdm-meeseva-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdmMeesevaServiceMaster)))
            .andExpect(status().isOk());

        // Validate the MdmMeesevaServiceMaster in the database
        List<MdmMeesevaServiceMaster> mdmMeesevaServiceMasterList = mdmMeesevaServiceMasterRepository.findAll();
        assertThat(mdmMeesevaServiceMasterList).hasSize(databaseSizeBeforeUpdate);
        MdmMeesevaServiceMaster testMdmMeesevaServiceMaster = mdmMeesevaServiceMasterList.get(mdmMeesevaServiceMasterList.size() - 1);
        assertThat(testMdmMeesevaServiceMaster.getSyspk()).isEqualTo(UPDATED_SYSPK);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceId()).isEqualTo(UPDATED_MEESEVA_SERVICE_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceName()).isEqualTo(UPDATED_MEESEVA_SERVICE_NAME);
        assertThat(testMdmMeesevaServiceMaster.getIsCharged()).isEqualTo(UPDATED_IS_CHARGED);
        assertThat(testMdmMeesevaServiceMaster.getOrganizationEntityTypeCode()).isEqualTo(UPDATED_ORGANIZATION_ENTITY_TYPE_CODE);
        assertThat(testMdmMeesevaServiceMaster.getApplicationTable()).isEqualTo(UPDATED_APPLICATION_TABLE);
        assertThat(testMdmMeesevaServiceMaster.getApplicationObject()).isEqualTo(UPDATED_APPLICATION_OBJECT);
        assertThat(testMdmMeesevaServiceMaster.getCustomerDefaultFlag()).isEqualTo(UPDATED_CUSTOMER_DEFAULT_FLAG);
        assertThat(testMdmMeesevaServiceMaster.getChannelDefaultFlag()).isEqualTo(UPDATED_CHANNEL_DEFAULT_FLAG);
        assertThat(testMdmMeesevaServiceMaster.getServiceUrl()).isEqualTo(UPDATED_SERVICE_URL);
        assertThat(testMdmMeesevaServiceMaster.getBackOfficeUrl()).isEqualTo(UPDATED_BACK_OFFICE_URL);
        assertThat(testMdmMeesevaServiceMaster.getPackageId()).isEqualTo(UPDATED_PACKAGE_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceActiveFlag()).isEqualTo(UPDATED_MEESEVA_SERVICE_ACTIVE_FLAG);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceGroupId()).isEqualTo(UPDATED_MEESEVA_SERVICE_GROUP_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceSubGroupId()).isEqualTo(UPDATED_MEESEVA_SERVICE_SUB_GROUP_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceTypeId()).isEqualTo(UPDATED_MEESEVA_SERVICE_TYPE_ID);
        assertThat(testMdmMeesevaServiceMaster.getMeesevaServiceSubTypeId()).isEqualTo(UPDATED_MEESEVA_SERVICE_SUB_TYPE_ID);
        assertThat(testMdmMeesevaServiceMaster.getDepartmentCode()).isEqualTo(UPDATED_DEPARTMENT_CODE);
        assertThat(testMdmMeesevaServiceMaster.getEfmsDepartmentCode()).isEqualTo(UPDATED_EFMS_DEPARTMENT_CODE);
        assertThat(testMdmMeesevaServiceMaster.getIsOnline()).isEqualTo(UPDATED_IS_ONLINE);
        assertThat(testMdmMeesevaServiceMaster.getAgencyType()).isEqualTo(UPDATED_AGENCY_TYPE);
        assertThat(testMdmMeesevaServiceMaster.getLaunchDate()).isEqualTo(UPDATED_LAUNCH_DATE);
        assertThat(testMdmMeesevaServiceMaster.getIsMobile()).isEqualTo(UPDATED_IS_MOBILE);
        assertThat(testMdmMeesevaServiceMaster.getInnerSubId()).isEqualTo(UPDATED_INNER_SUB_ID);
        assertThat(testMdmMeesevaServiceMaster.getDigilockerEnabled()).isEqualTo(UPDATED_DIGILOCKER_ENABLED);
        assertThat(testMdmMeesevaServiceMaster.getIsRegular()).isEqualTo(UPDATED_IS_REGULAR);
        assertThat(testMdmMeesevaServiceMaster.getIsSeasonal()).isEqualTo(UPDATED_IS_SEASONAL);
        assertThat(testMdmMeesevaServiceMaster.getCitizenPortalLaunchDate()).isEqualTo(UPDATED_CITIZEN_PORTAL_LAUNCH_DATE);
        assertThat(testMdmMeesevaServiceMaster.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testMdmMeesevaServiceMaster.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testMdmMeesevaServiceMaster.getRecordInsertTime()).isEqualTo(UPDATED_RECORD_INSERT_TIME);
        assertThat(testMdmMeesevaServiceMaster.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testMdmMeesevaServiceMaster.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingMdmMeesevaServiceMaster() throws Exception {
        int databaseSizeBeforeUpdate = mdmMeesevaServiceMasterRepository.findAll().size();

        // Create the MdmMeesevaServiceMaster

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdmMeesevaServiceMasterMockMvc.perform(put("/api/mdm-meeseva-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmMeesevaServiceMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmMeesevaServiceMaster in the database
        List<MdmMeesevaServiceMaster> mdmMeesevaServiceMasterList = mdmMeesevaServiceMasterRepository.findAll();
        assertThat(mdmMeesevaServiceMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdmMeesevaServiceMaster() throws Exception {
        // Initialize the database
        mdmMeesevaServiceMasterRepository.saveAndFlush(mdmMeesevaServiceMaster);

        int databaseSizeBeforeDelete = mdmMeesevaServiceMasterRepository.findAll().size();

        // Delete the mdmMeesevaServiceMaster
        restMdmMeesevaServiceMasterMockMvc.perform(delete("/api/mdm-meeseva-service-masters/{id}", mdmMeesevaServiceMaster.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdmMeesevaServiceMaster> mdmMeesevaServiceMasterList = mdmMeesevaServiceMasterRepository.findAll();
        assertThat(mdmMeesevaServiceMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
