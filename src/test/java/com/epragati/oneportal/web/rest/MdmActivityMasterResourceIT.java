package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.OnePortalApp;
import com.epragati.oneportal.domain.MdmActivityMaster;
import com.epragati.oneportal.repository.MdmActivityMasterRepository;
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
 * Integration tests for the {@link MdmActivityMasterResource} REST controller.
 */
@SpringBootTest(classes = OnePortalApp.class)
public class MdmActivityMasterResourceIT {

    private static final Long DEFAULT_SYSPK = 1L;
    private static final Long UPDATED_SYSPK = 2L;

    private static final String DEFAULT_ACTIVITY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVITY_DESC = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITY_DESC = "BBBBBBBBBB";

    private static final Integer DEFAULT_ACTIVITY_LEVEL_ID = 1;
    private static final Integer UPDATED_ACTIVITY_LEVEL_ID = 2;

    private static final String DEFAULT_ACTIVITY_LEVEL_DESC = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITY_LEVEL_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVITY_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITY_STATUS = "BBBBBBBBBB";

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
    private MdmActivityMasterRepository mdmActivityMasterRepository;

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

    private MockMvc restMdmActivityMasterMockMvc;

    private MdmActivityMaster mdmActivityMaster;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdmActivityMasterResource mdmActivityMasterResource = new MdmActivityMasterResource(mdmActivityMasterRepository);
        this.restMdmActivityMasterMockMvc = MockMvcBuilders.standaloneSetup(mdmActivityMasterResource)
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
    public static MdmActivityMaster createEntity(EntityManager em) {
        MdmActivityMaster mdmActivityMaster = new MdmActivityMaster()
            .syspk(DEFAULT_SYSPK)
            .activityCode(DEFAULT_ACTIVITY_CODE)
            .activityName(DEFAULT_ACTIVITY_NAME)
            .activityDesc(DEFAULT_ACTIVITY_DESC)
            .activityLevelId(DEFAULT_ACTIVITY_LEVEL_ID)
            .activityLevelDesc(DEFAULT_ACTIVITY_LEVEL_DESC)
            .organizationName(DEFAULT_ORGANIZATION_NAME)
            .activityStatus(DEFAULT_ACTIVITY_STATUS)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedBy(DEFAULT_UPDATED_BY)
            .recordInsertTime(DEFAULT_RECORD_INSERT_TIME)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME);
        return mdmActivityMaster;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmActivityMaster createUpdatedEntity(EntityManager em) {
        MdmActivityMaster mdmActivityMaster = new MdmActivityMaster()
            .syspk(UPDATED_SYSPK)
            .activityCode(UPDATED_ACTIVITY_CODE)
            .activityName(UPDATED_ACTIVITY_NAME)
            .activityDesc(UPDATED_ACTIVITY_DESC)
            .activityLevelId(UPDATED_ACTIVITY_LEVEL_ID)
            .activityLevelDesc(UPDATED_ACTIVITY_LEVEL_DESC)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .activityStatus(UPDATED_ACTIVITY_STATUS)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME);
        return mdmActivityMaster;
    }

    @BeforeEach
    public void initTest() {
        mdmActivityMaster = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdmActivityMaster() throws Exception {
        int databaseSizeBeforeCreate = mdmActivityMasterRepository.findAll().size();

        // Create the MdmActivityMaster
        restMdmActivityMasterMockMvc.perform(post("/api/mdm-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmActivityMaster)))
            .andExpect(status().isCreated());

        // Validate the MdmActivityMaster in the database
        List<MdmActivityMaster> mdmActivityMasterList = mdmActivityMasterRepository.findAll();
        assertThat(mdmActivityMasterList).hasSize(databaseSizeBeforeCreate + 1);
        MdmActivityMaster testMdmActivityMaster = mdmActivityMasterList.get(mdmActivityMasterList.size() - 1);
        assertThat(testMdmActivityMaster.getSyspk()).isEqualTo(DEFAULT_SYSPK);
        assertThat(testMdmActivityMaster.getActivityCode()).isEqualTo(DEFAULT_ACTIVITY_CODE);
        assertThat(testMdmActivityMaster.getActivityName()).isEqualTo(DEFAULT_ACTIVITY_NAME);
        assertThat(testMdmActivityMaster.getActivityDesc()).isEqualTo(DEFAULT_ACTIVITY_DESC);
        assertThat(testMdmActivityMaster.getActivityLevelId()).isEqualTo(DEFAULT_ACTIVITY_LEVEL_ID);
        assertThat(testMdmActivityMaster.getActivityLevelDesc()).isEqualTo(DEFAULT_ACTIVITY_LEVEL_DESC);
        assertThat(testMdmActivityMaster.getOrganizationName()).isEqualTo(DEFAULT_ORGANIZATION_NAME);
        assertThat(testMdmActivityMaster.getActivityStatus()).isEqualTo(DEFAULT_ACTIVITY_STATUS);
        assertThat(testMdmActivityMaster.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testMdmActivityMaster.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testMdmActivityMaster.getRecordInsertTime()).isEqualTo(DEFAULT_RECORD_INSERT_TIME);
        assertThat(testMdmActivityMaster.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testMdmActivityMaster.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void createMdmActivityMasterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdmActivityMasterRepository.findAll().size();

        // Create the MdmActivityMaster with an existing ID
        mdmActivityMaster.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdmActivityMasterMockMvc.perform(post("/api/mdm-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmActivityMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmActivityMaster in the database
        List<MdmActivityMaster> mdmActivityMasterList = mdmActivityMasterRepository.findAll();
        assertThat(mdmActivityMasterList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkSyspkIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmActivityMasterRepository.findAll().size();
        // set the field null
        mdmActivityMaster.setSyspk(null);

        // Create the MdmActivityMaster, which fails.

        restMdmActivityMasterMockMvc.perform(post("/api/mdm-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmActivityMaster)))
            .andExpect(status().isBadRequest());

        List<MdmActivityMaster> mdmActivityMasterList = mdmActivityMasterRepository.findAll();
        assertThat(mdmActivityMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkActivityCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmActivityMasterRepository.findAll().size();
        // set the field null
        mdmActivityMaster.setActivityCode(null);

        // Create the MdmActivityMaster, which fails.

        restMdmActivityMasterMockMvc.perform(post("/api/mdm-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmActivityMaster)))
            .andExpect(status().isBadRequest());

        List<MdmActivityMaster> mdmActivityMasterList = mdmActivityMasterRepository.findAll();
        assertThat(mdmActivityMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkActivityNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmActivityMasterRepository.findAll().size();
        // set the field null
        mdmActivityMaster.setActivityName(null);

        // Create the MdmActivityMaster, which fails.

        restMdmActivityMasterMockMvc.perform(post("/api/mdm-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmActivityMaster)))
            .andExpect(status().isBadRequest());

        List<MdmActivityMaster> mdmActivityMasterList = mdmActivityMasterRepository.findAll();
        assertThat(mdmActivityMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkActivityStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmActivityMasterRepository.findAll().size();
        // set the field null
        mdmActivityMaster.setActivityStatus(null);

        // Create the MdmActivityMaster, which fails.

        restMdmActivityMasterMockMvc.perform(post("/api/mdm-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmActivityMaster)))
            .andExpect(status().isBadRequest());

        List<MdmActivityMaster> mdmActivityMasterList = mdmActivityMasterRepository.findAll();
        assertThat(mdmActivityMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMdmActivityMasters() throws Exception {
        // Initialize the database
        mdmActivityMasterRepository.saveAndFlush(mdmActivityMaster);

        // Get all the mdmActivityMasterList
        restMdmActivityMasterMockMvc.perform(get("/api/mdm-activity-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdmActivityMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].syspk").value(hasItem(DEFAULT_SYSPK.intValue())))
            .andExpect(jsonPath("$.[*].activityCode").value(hasItem(DEFAULT_ACTIVITY_CODE)))
            .andExpect(jsonPath("$.[*].activityName").value(hasItem(DEFAULT_ACTIVITY_NAME)))
            .andExpect(jsonPath("$.[*].activityDesc").value(hasItem(DEFAULT_ACTIVITY_DESC)))
            .andExpect(jsonPath("$.[*].activityLevelId").value(hasItem(DEFAULT_ACTIVITY_LEVEL_ID)))
            .andExpect(jsonPath("$.[*].activityLevelDesc").value(hasItem(DEFAULT_ACTIVITY_LEVEL_DESC)))
            .andExpect(jsonPath("$.[*].organizationName").value(hasItem(DEFAULT_ORGANIZATION_NAME)))
            .andExpect(jsonPath("$.[*].activityStatus").value(hasItem(DEFAULT_ACTIVITY_STATUS)))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].recordInsertTime").value(hasItem(DEFAULT_RECORD_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())));
    }
    
    @Test
    @Transactional
    public void getMdmActivityMaster() throws Exception {
        // Initialize the database
        mdmActivityMasterRepository.saveAndFlush(mdmActivityMaster);

        // Get the mdmActivityMaster
        restMdmActivityMasterMockMvc.perform(get("/api/mdm-activity-masters/{id}", mdmActivityMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mdmActivityMaster.getId().intValue()))
            .andExpect(jsonPath("$.syspk").value(DEFAULT_SYSPK.intValue()))
            .andExpect(jsonPath("$.activityCode").value(DEFAULT_ACTIVITY_CODE))
            .andExpect(jsonPath("$.activityName").value(DEFAULT_ACTIVITY_NAME))
            .andExpect(jsonPath("$.activityDesc").value(DEFAULT_ACTIVITY_DESC))
            .andExpect(jsonPath("$.activityLevelId").value(DEFAULT_ACTIVITY_LEVEL_ID))
            .andExpect(jsonPath("$.activityLevelDesc").value(DEFAULT_ACTIVITY_LEVEL_DESC))
            .andExpect(jsonPath("$.organizationName").value(DEFAULT_ORGANIZATION_NAME))
            .andExpect(jsonPath("$.activityStatus").value(DEFAULT_ACTIVITY_STATUS))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.recordInsertTime").value(DEFAULT_RECORD_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingMdmActivityMaster() throws Exception {
        // Get the mdmActivityMaster
        restMdmActivityMasterMockMvc.perform(get("/api/mdm-activity-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdmActivityMaster() throws Exception {
        // Initialize the database
        mdmActivityMasterRepository.saveAndFlush(mdmActivityMaster);

        int databaseSizeBeforeUpdate = mdmActivityMasterRepository.findAll().size();

        // Update the mdmActivityMaster
        MdmActivityMaster updatedMdmActivityMaster = mdmActivityMasterRepository.findById(mdmActivityMaster.getId()).get();
        // Disconnect from session so that the updates on updatedMdmActivityMaster are not directly saved in db
        em.detach(updatedMdmActivityMaster);
        updatedMdmActivityMaster
            .syspk(UPDATED_SYSPK)
            .activityCode(UPDATED_ACTIVITY_CODE)
            .activityName(UPDATED_ACTIVITY_NAME)
            .activityDesc(UPDATED_ACTIVITY_DESC)
            .activityLevelId(UPDATED_ACTIVITY_LEVEL_ID)
            .activityLevelDesc(UPDATED_ACTIVITY_LEVEL_DESC)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .activityStatus(UPDATED_ACTIVITY_STATUS)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME);

        restMdmActivityMasterMockMvc.perform(put("/api/mdm-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdmActivityMaster)))
            .andExpect(status().isOk());

        // Validate the MdmActivityMaster in the database
        List<MdmActivityMaster> mdmActivityMasterList = mdmActivityMasterRepository.findAll();
        assertThat(mdmActivityMasterList).hasSize(databaseSizeBeforeUpdate);
        MdmActivityMaster testMdmActivityMaster = mdmActivityMasterList.get(mdmActivityMasterList.size() - 1);
        assertThat(testMdmActivityMaster.getSyspk()).isEqualTo(UPDATED_SYSPK);
        assertThat(testMdmActivityMaster.getActivityCode()).isEqualTo(UPDATED_ACTIVITY_CODE);
        assertThat(testMdmActivityMaster.getActivityName()).isEqualTo(UPDATED_ACTIVITY_NAME);
        assertThat(testMdmActivityMaster.getActivityDesc()).isEqualTo(UPDATED_ACTIVITY_DESC);
        assertThat(testMdmActivityMaster.getActivityLevelId()).isEqualTo(UPDATED_ACTIVITY_LEVEL_ID);
        assertThat(testMdmActivityMaster.getActivityLevelDesc()).isEqualTo(UPDATED_ACTIVITY_LEVEL_DESC);
        assertThat(testMdmActivityMaster.getOrganizationName()).isEqualTo(UPDATED_ORGANIZATION_NAME);
        assertThat(testMdmActivityMaster.getActivityStatus()).isEqualTo(UPDATED_ACTIVITY_STATUS);
        assertThat(testMdmActivityMaster.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testMdmActivityMaster.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testMdmActivityMaster.getRecordInsertTime()).isEqualTo(UPDATED_RECORD_INSERT_TIME);
        assertThat(testMdmActivityMaster.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testMdmActivityMaster.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingMdmActivityMaster() throws Exception {
        int databaseSizeBeforeUpdate = mdmActivityMasterRepository.findAll().size();

        // Create the MdmActivityMaster

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdmActivityMasterMockMvc.perform(put("/api/mdm-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmActivityMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmActivityMaster in the database
        List<MdmActivityMaster> mdmActivityMasterList = mdmActivityMasterRepository.findAll();
        assertThat(mdmActivityMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdmActivityMaster() throws Exception {
        // Initialize the database
        mdmActivityMasterRepository.saveAndFlush(mdmActivityMaster);

        int databaseSizeBeforeDelete = mdmActivityMasterRepository.findAll().size();

        // Delete the mdmActivityMaster
        restMdmActivityMasterMockMvc.perform(delete("/api/mdm-activity-masters/{id}", mdmActivityMaster.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdmActivityMaster> mdmActivityMasterList = mdmActivityMasterRepository.findAll();
        assertThat(mdmActivityMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
