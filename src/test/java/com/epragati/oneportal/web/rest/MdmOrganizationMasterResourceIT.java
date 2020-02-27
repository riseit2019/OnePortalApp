package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.OnePortalApp;
import com.epragati.oneportal.domain.MdmOrganizationMaster;
import com.epragati.oneportal.repository.MdmOrganizationMasterRepository;
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
 * Integration tests for the {@link MdmOrganizationMasterResource} REST controller.
 */
@SpringBootTest(classes = OnePortalApp.class)
public class MdmOrganizationMasterResourceIT {

    private static final Long DEFAULT_SYSPK = 1L;
    private static final Long UPDATED_SYSPK = 2L;

    private static final String DEFAULT_ORGANIZATION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_SHORT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_SHORT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_DESC = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_SECTOR_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SECTOR_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_ORG_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_ORG_CODE = "BBBBBBBBBB";

    private static final Boolean DEFAULT_ORGANIZATION_ACTIVE_FLAG = false;
    private static final Boolean UPDATED_ORGANIZATION_ACTIVE_FLAG = true;

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

    private static final LocalDate DEFAULT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ORGANIZATION_TYPE_DESC = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_TYPE_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_JURISDICTION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_JURISDICTION_TYPE = "BBBBBBBBBB";

    @Autowired
    private MdmOrganizationMasterRepository mdmOrganizationMasterRepository;

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

    private MockMvc restMdmOrganizationMasterMockMvc;

    private MdmOrganizationMaster mdmOrganizationMaster;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdmOrganizationMasterResource mdmOrganizationMasterResource = new MdmOrganizationMasterResource(mdmOrganizationMasterRepository);
        this.restMdmOrganizationMasterMockMvc = MockMvcBuilders.standaloneSetup(mdmOrganizationMasterResource)
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
    public static MdmOrganizationMaster createEntity(EntityManager em) {
        MdmOrganizationMaster mdmOrganizationMaster = new MdmOrganizationMaster()
            .syspk(DEFAULT_SYSPK)
            .organizationCode(DEFAULT_ORGANIZATION_CODE)
            .organizationShortName(DEFAULT_ORGANIZATION_SHORT_NAME)
            .organizationName(DEFAULT_ORGANIZATION_NAME)
            .organizationType(DEFAULT_ORGANIZATION_TYPE)
            .organizationDesc(DEFAULT_ORGANIZATION_DESC)
            .sectorCode(DEFAULT_SECTOR_CODE)
            .parentOrgCode(DEFAULT_PARENT_ORG_CODE)
            .organizationActiveFlag(DEFAULT_ORGANIZATION_ACTIVE_FLAG)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedBy(DEFAULT_UPDATED_BY)
            .recordInsertTime(DEFAULT_RECORD_INSERT_TIME)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .organizationTypeDesc(DEFAULT_ORGANIZATION_TYPE_DESC)
            .jurisdictionType(DEFAULT_JURISDICTION_TYPE);
        return mdmOrganizationMaster;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmOrganizationMaster createUpdatedEntity(EntityManager em) {
        MdmOrganizationMaster mdmOrganizationMaster = new MdmOrganizationMaster()
            .syspk(UPDATED_SYSPK)
            .organizationCode(UPDATED_ORGANIZATION_CODE)
            .organizationShortName(UPDATED_ORGANIZATION_SHORT_NAME)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .organizationType(UPDATED_ORGANIZATION_TYPE)
            .organizationDesc(UPDATED_ORGANIZATION_DESC)
            .sectorCode(UPDATED_SECTOR_CODE)
            .parentOrgCode(UPDATED_PARENT_ORG_CODE)
            .organizationActiveFlag(UPDATED_ORGANIZATION_ACTIVE_FLAG)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .organizationTypeDesc(UPDATED_ORGANIZATION_TYPE_DESC)
            .jurisdictionType(UPDATED_JURISDICTION_TYPE);
        return mdmOrganizationMaster;
    }

    @BeforeEach
    public void initTest() {
        mdmOrganizationMaster = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdmOrganizationMaster() throws Exception {
        int databaseSizeBeforeCreate = mdmOrganizationMasterRepository.findAll().size();

        // Create the MdmOrganizationMaster
        restMdmOrganizationMasterMockMvc.perform(post("/api/mdm-organization-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmOrganizationMaster)))
            .andExpect(status().isCreated());

        // Validate the MdmOrganizationMaster in the database
        List<MdmOrganizationMaster> mdmOrganizationMasterList = mdmOrganizationMasterRepository.findAll();
        assertThat(mdmOrganizationMasterList).hasSize(databaseSizeBeforeCreate + 1);
        MdmOrganizationMaster testMdmOrganizationMaster = mdmOrganizationMasterList.get(mdmOrganizationMasterList.size() - 1);
        assertThat(testMdmOrganizationMaster.getSyspk()).isEqualTo(DEFAULT_SYSPK);
        assertThat(testMdmOrganizationMaster.getOrganizationCode()).isEqualTo(DEFAULT_ORGANIZATION_CODE);
        assertThat(testMdmOrganizationMaster.getOrganizationShortName()).isEqualTo(DEFAULT_ORGANIZATION_SHORT_NAME);
        assertThat(testMdmOrganizationMaster.getOrganizationName()).isEqualTo(DEFAULT_ORGANIZATION_NAME);
        assertThat(testMdmOrganizationMaster.getOrganizationType()).isEqualTo(DEFAULT_ORGANIZATION_TYPE);
        assertThat(testMdmOrganizationMaster.getOrganizationDesc()).isEqualTo(DEFAULT_ORGANIZATION_DESC);
        assertThat(testMdmOrganizationMaster.getSectorCode()).isEqualTo(DEFAULT_SECTOR_CODE);
        assertThat(testMdmOrganizationMaster.getParentOrgCode()).isEqualTo(DEFAULT_PARENT_ORG_CODE);
        assertThat(testMdmOrganizationMaster.isOrganizationActiveFlag()).isEqualTo(DEFAULT_ORGANIZATION_ACTIVE_FLAG);
        assertThat(testMdmOrganizationMaster.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testMdmOrganizationMaster.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testMdmOrganizationMaster.getRecordInsertTime()).isEqualTo(DEFAULT_RECORD_INSERT_TIME);
        assertThat(testMdmOrganizationMaster.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testMdmOrganizationMaster.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
        assertThat(testMdmOrganizationMaster.getStartDate()).isEqualTo(DEFAULT_START_DATE);
        assertThat(testMdmOrganizationMaster.getEndDate()).isEqualTo(DEFAULT_END_DATE);
        assertThat(testMdmOrganizationMaster.getOrganizationTypeDesc()).isEqualTo(DEFAULT_ORGANIZATION_TYPE_DESC);
        assertThat(testMdmOrganizationMaster.getJurisdictionType()).isEqualTo(DEFAULT_JURISDICTION_TYPE);
    }

    @Test
    @Transactional
    public void createMdmOrganizationMasterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdmOrganizationMasterRepository.findAll().size();

        // Create the MdmOrganizationMaster with an existing ID
        mdmOrganizationMaster.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdmOrganizationMasterMockMvc.perform(post("/api/mdm-organization-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmOrganizationMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmOrganizationMaster in the database
        List<MdmOrganizationMaster> mdmOrganizationMasterList = mdmOrganizationMasterRepository.findAll();
        assertThat(mdmOrganizationMasterList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkSyspkIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmOrganizationMasterRepository.findAll().size();
        // set the field null
        mdmOrganizationMaster.setSyspk(null);

        // Create the MdmOrganizationMaster, which fails.

        restMdmOrganizationMasterMockMvc.perform(post("/api/mdm-organization-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmOrganizationMaster)))
            .andExpect(status().isBadRequest());

        List<MdmOrganizationMaster> mdmOrganizationMasterList = mdmOrganizationMasterRepository.findAll();
        assertThat(mdmOrganizationMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOrganizationCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmOrganizationMasterRepository.findAll().size();
        // set the field null
        mdmOrganizationMaster.setOrganizationCode(null);

        // Create the MdmOrganizationMaster, which fails.

        restMdmOrganizationMasterMockMvc.perform(post("/api/mdm-organization-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmOrganizationMaster)))
            .andExpect(status().isBadRequest());

        List<MdmOrganizationMaster> mdmOrganizationMasterList = mdmOrganizationMasterRepository.findAll();
        assertThat(mdmOrganizationMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMdmOrganizationMasters() throws Exception {
        // Initialize the database
        mdmOrganizationMasterRepository.saveAndFlush(mdmOrganizationMaster);

        // Get all the mdmOrganizationMasterList
        restMdmOrganizationMasterMockMvc.perform(get("/api/mdm-organization-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdmOrganizationMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].syspk").value(hasItem(DEFAULT_SYSPK.intValue())))
            .andExpect(jsonPath("$.[*].organizationCode").value(hasItem(DEFAULT_ORGANIZATION_CODE)))
            .andExpect(jsonPath("$.[*].organizationShortName").value(hasItem(DEFAULT_ORGANIZATION_SHORT_NAME)))
            .andExpect(jsonPath("$.[*].organizationName").value(hasItem(DEFAULT_ORGANIZATION_NAME)))
            .andExpect(jsonPath("$.[*].organizationType").value(hasItem(DEFAULT_ORGANIZATION_TYPE)))
            .andExpect(jsonPath("$.[*].organizationDesc").value(hasItem(DEFAULT_ORGANIZATION_DESC)))
            .andExpect(jsonPath("$.[*].sectorCode").value(hasItem(DEFAULT_SECTOR_CODE)))
            .andExpect(jsonPath("$.[*].parentOrgCode").value(hasItem(DEFAULT_PARENT_ORG_CODE)))
            .andExpect(jsonPath("$.[*].organizationActiveFlag").value(hasItem(DEFAULT_ORGANIZATION_ACTIVE_FLAG.booleanValue())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].recordInsertTime").value(hasItem(DEFAULT_RECORD_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].organizationTypeDesc").value(hasItem(DEFAULT_ORGANIZATION_TYPE_DESC)))
            .andExpect(jsonPath("$.[*].jurisdictionType").value(hasItem(DEFAULT_JURISDICTION_TYPE)));
    }
    
    @Test
    @Transactional
    public void getMdmOrganizationMaster() throws Exception {
        // Initialize the database
        mdmOrganizationMasterRepository.saveAndFlush(mdmOrganizationMaster);

        // Get the mdmOrganizationMaster
        restMdmOrganizationMasterMockMvc.perform(get("/api/mdm-organization-masters/{id}", mdmOrganizationMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mdmOrganizationMaster.getId().intValue()))
            .andExpect(jsonPath("$.syspk").value(DEFAULT_SYSPK.intValue()))
            .andExpect(jsonPath("$.organizationCode").value(DEFAULT_ORGANIZATION_CODE))
            .andExpect(jsonPath("$.organizationShortName").value(DEFAULT_ORGANIZATION_SHORT_NAME))
            .andExpect(jsonPath("$.organizationName").value(DEFAULT_ORGANIZATION_NAME))
            .andExpect(jsonPath("$.organizationType").value(DEFAULT_ORGANIZATION_TYPE))
            .andExpect(jsonPath("$.organizationDesc").value(DEFAULT_ORGANIZATION_DESC))
            .andExpect(jsonPath("$.sectorCode").value(DEFAULT_SECTOR_CODE))
            .andExpect(jsonPath("$.parentOrgCode").value(DEFAULT_PARENT_ORG_CODE))
            .andExpect(jsonPath("$.organizationActiveFlag").value(DEFAULT_ORGANIZATION_ACTIVE_FLAG.booleanValue()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.recordInsertTime").value(DEFAULT_RECORD_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.organizationTypeDesc").value(DEFAULT_ORGANIZATION_TYPE_DESC))
            .andExpect(jsonPath("$.jurisdictionType").value(DEFAULT_JURISDICTION_TYPE));
    }

    @Test
    @Transactional
    public void getNonExistingMdmOrganizationMaster() throws Exception {
        // Get the mdmOrganizationMaster
        restMdmOrganizationMasterMockMvc.perform(get("/api/mdm-organization-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdmOrganizationMaster() throws Exception {
        // Initialize the database
        mdmOrganizationMasterRepository.saveAndFlush(mdmOrganizationMaster);

        int databaseSizeBeforeUpdate = mdmOrganizationMasterRepository.findAll().size();

        // Update the mdmOrganizationMaster
        MdmOrganizationMaster updatedMdmOrganizationMaster = mdmOrganizationMasterRepository.findById(mdmOrganizationMaster.getId()).get();
        // Disconnect from session so that the updates on updatedMdmOrganizationMaster are not directly saved in db
        em.detach(updatedMdmOrganizationMaster);
        updatedMdmOrganizationMaster
            .syspk(UPDATED_SYSPK)
            .organizationCode(UPDATED_ORGANIZATION_CODE)
            .organizationShortName(UPDATED_ORGANIZATION_SHORT_NAME)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .organizationType(UPDATED_ORGANIZATION_TYPE)
            .organizationDesc(UPDATED_ORGANIZATION_DESC)
            .sectorCode(UPDATED_SECTOR_CODE)
            .parentOrgCode(UPDATED_PARENT_ORG_CODE)
            .organizationActiveFlag(UPDATED_ORGANIZATION_ACTIVE_FLAG)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .organizationTypeDesc(UPDATED_ORGANIZATION_TYPE_DESC)
            .jurisdictionType(UPDATED_JURISDICTION_TYPE);

        restMdmOrganizationMasterMockMvc.perform(put("/api/mdm-organization-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdmOrganizationMaster)))
            .andExpect(status().isOk());

        // Validate the MdmOrganizationMaster in the database
        List<MdmOrganizationMaster> mdmOrganizationMasterList = mdmOrganizationMasterRepository.findAll();
        assertThat(mdmOrganizationMasterList).hasSize(databaseSizeBeforeUpdate);
        MdmOrganizationMaster testMdmOrganizationMaster = mdmOrganizationMasterList.get(mdmOrganizationMasterList.size() - 1);
        assertThat(testMdmOrganizationMaster.getSyspk()).isEqualTo(UPDATED_SYSPK);
        assertThat(testMdmOrganizationMaster.getOrganizationCode()).isEqualTo(UPDATED_ORGANIZATION_CODE);
        assertThat(testMdmOrganizationMaster.getOrganizationShortName()).isEqualTo(UPDATED_ORGANIZATION_SHORT_NAME);
        assertThat(testMdmOrganizationMaster.getOrganizationName()).isEqualTo(UPDATED_ORGANIZATION_NAME);
        assertThat(testMdmOrganizationMaster.getOrganizationType()).isEqualTo(UPDATED_ORGANIZATION_TYPE);
        assertThat(testMdmOrganizationMaster.getOrganizationDesc()).isEqualTo(UPDATED_ORGANIZATION_DESC);
        assertThat(testMdmOrganizationMaster.getSectorCode()).isEqualTo(UPDATED_SECTOR_CODE);
        assertThat(testMdmOrganizationMaster.getParentOrgCode()).isEqualTo(UPDATED_PARENT_ORG_CODE);
        assertThat(testMdmOrganizationMaster.isOrganizationActiveFlag()).isEqualTo(UPDATED_ORGANIZATION_ACTIVE_FLAG);
        assertThat(testMdmOrganizationMaster.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testMdmOrganizationMaster.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testMdmOrganizationMaster.getRecordInsertTime()).isEqualTo(UPDATED_RECORD_INSERT_TIME);
        assertThat(testMdmOrganizationMaster.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testMdmOrganizationMaster.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
        assertThat(testMdmOrganizationMaster.getStartDate()).isEqualTo(UPDATED_START_DATE);
        assertThat(testMdmOrganizationMaster.getEndDate()).isEqualTo(UPDATED_END_DATE);
        assertThat(testMdmOrganizationMaster.getOrganizationTypeDesc()).isEqualTo(UPDATED_ORGANIZATION_TYPE_DESC);
        assertThat(testMdmOrganizationMaster.getJurisdictionType()).isEqualTo(UPDATED_JURISDICTION_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingMdmOrganizationMaster() throws Exception {
        int databaseSizeBeforeUpdate = mdmOrganizationMasterRepository.findAll().size();

        // Create the MdmOrganizationMaster

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdmOrganizationMasterMockMvc.perform(put("/api/mdm-organization-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmOrganizationMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmOrganizationMaster in the database
        List<MdmOrganizationMaster> mdmOrganizationMasterList = mdmOrganizationMasterRepository.findAll();
        assertThat(mdmOrganizationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdmOrganizationMaster() throws Exception {
        // Initialize the database
        mdmOrganizationMasterRepository.saveAndFlush(mdmOrganizationMaster);

        int databaseSizeBeforeDelete = mdmOrganizationMasterRepository.findAll().size();

        // Delete the mdmOrganizationMaster
        restMdmOrganizationMasterMockMvc.perform(delete("/api/mdm-organization-masters/{id}", mdmOrganizationMaster.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdmOrganizationMaster> mdmOrganizationMasterList = mdmOrganizationMasterRepository.findAll();
        assertThat(mdmOrganizationMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
