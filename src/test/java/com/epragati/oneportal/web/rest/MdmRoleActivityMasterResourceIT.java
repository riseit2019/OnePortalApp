package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.OnePortalApp;
import com.epragati.oneportal.domain.MdmRoleActivityMaster;
import com.epragati.oneportal.repository.MdmRoleActivityMasterRepository;
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
 * Integration tests for the {@link MdmRoleActivityMasterResource} REST controller.
 */
@SpringBootTest(classes = OnePortalApp.class)
public class MdmRoleActivityMasterResourceIT {

    private static final String DEFAULT_ACTIVITY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITY_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_ACTIVITY_LEVEL_ID = 1;
    private static final Integer UPDATED_ACTIVITY_LEVEL_ID = 2;

    private static final String DEFAULT_ACTIVITY_LEVEL_DESC = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITY_LEVEL_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROLE_LEVEL_ID = 1;
    private static final Integer UPDATED_ROLE_LEVEL_ID = 2;

    private static final String DEFAULT_ROLE_LEVEL_DESC = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_LEVEL_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE_ACTIVITY_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_ACTIVITY_STATUS = "BBBBBBBBBB";

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
    private MdmRoleActivityMasterRepository mdmRoleActivityMasterRepository;

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

    private MockMvc restMdmRoleActivityMasterMockMvc;

    private MdmRoleActivityMaster mdmRoleActivityMaster;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdmRoleActivityMasterResource mdmRoleActivityMasterResource = new MdmRoleActivityMasterResource(mdmRoleActivityMasterRepository);
        this.restMdmRoleActivityMasterMockMvc = MockMvcBuilders.standaloneSetup(mdmRoleActivityMasterResource)
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
    public static MdmRoleActivityMaster createEntity(EntityManager em) {
        MdmRoleActivityMaster mdmRoleActivityMaster = new MdmRoleActivityMaster()
            .activityCode(DEFAULT_ACTIVITY_CODE)
            .activityName(DEFAULT_ACTIVITY_NAME)
            .activityLevelId(DEFAULT_ACTIVITY_LEVEL_ID)
            .activityLevelDesc(DEFAULT_ACTIVITY_LEVEL_DESC)
            .roleCode(DEFAULT_ROLE_CODE)
            .roleName(DEFAULT_ROLE_NAME)
            .roleLevelId(DEFAULT_ROLE_LEVEL_ID)
            .roleLevelDesc(DEFAULT_ROLE_LEVEL_DESC)
            .roleActivityStatus(DEFAULT_ROLE_ACTIVITY_STATUS)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedBy(DEFAULT_UPDATED_BY)
            .recordInsertTime(DEFAULT_RECORD_INSERT_TIME)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME);
        return mdmRoleActivityMaster;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmRoleActivityMaster createUpdatedEntity(EntityManager em) {
        MdmRoleActivityMaster mdmRoleActivityMaster = new MdmRoleActivityMaster()
            .activityCode(UPDATED_ACTIVITY_CODE)
            .activityName(UPDATED_ACTIVITY_NAME)
            .activityLevelId(UPDATED_ACTIVITY_LEVEL_ID)
            .activityLevelDesc(UPDATED_ACTIVITY_LEVEL_DESC)
            .roleCode(UPDATED_ROLE_CODE)
            .roleName(UPDATED_ROLE_NAME)
            .roleLevelId(UPDATED_ROLE_LEVEL_ID)
            .roleLevelDesc(UPDATED_ROLE_LEVEL_DESC)
            .roleActivityStatus(UPDATED_ROLE_ACTIVITY_STATUS)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME);
        return mdmRoleActivityMaster;
    }

    @BeforeEach
    public void initTest() {
        mdmRoleActivityMaster = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdmRoleActivityMaster() throws Exception {
        int databaseSizeBeforeCreate = mdmRoleActivityMasterRepository.findAll().size();

        // Create the MdmRoleActivityMaster
        restMdmRoleActivityMasterMockMvc.perform(post("/api/mdm-role-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleActivityMaster)))
            .andExpect(status().isCreated());

        // Validate the MdmRoleActivityMaster in the database
        List<MdmRoleActivityMaster> mdmRoleActivityMasterList = mdmRoleActivityMasterRepository.findAll();
        assertThat(mdmRoleActivityMasterList).hasSize(databaseSizeBeforeCreate + 1);
        MdmRoleActivityMaster testMdmRoleActivityMaster = mdmRoleActivityMasterList.get(mdmRoleActivityMasterList.size() - 1);
        assertThat(testMdmRoleActivityMaster.getActivityCode()).isEqualTo(DEFAULT_ACTIVITY_CODE);
        assertThat(testMdmRoleActivityMaster.getActivityName()).isEqualTo(DEFAULT_ACTIVITY_NAME);
        assertThat(testMdmRoleActivityMaster.getActivityLevelId()).isEqualTo(DEFAULT_ACTIVITY_LEVEL_ID);
        assertThat(testMdmRoleActivityMaster.getActivityLevelDesc()).isEqualTo(DEFAULT_ACTIVITY_LEVEL_DESC);
        assertThat(testMdmRoleActivityMaster.getRoleCode()).isEqualTo(DEFAULT_ROLE_CODE);
        assertThat(testMdmRoleActivityMaster.getRoleName()).isEqualTo(DEFAULT_ROLE_NAME);
        assertThat(testMdmRoleActivityMaster.getRoleLevelId()).isEqualTo(DEFAULT_ROLE_LEVEL_ID);
        assertThat(testMdmRoleActivityMaster.getRoleLevelDesc()).isEqualTo(DEFAULT_ROLE_LEVEL_DESC);
        assertThat(testMdmRoleActivityMaster.getRoleActivityStatus()).isEqualTo(DEFAULT_ROLE_ACTIVITY_STATUS);
        assertThat(testMdmRoleActivityMaster.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testMdmRoleActivityMaster.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testMdmRoleActivityMaster.getRecordInsertTime()).isEqualTo(DEFAULT_RECORD_INSERT_TIME);
        assertThat(testMdmRoleActivityMaster.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testMdmRoleActivityMaster.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void createMdmRoleActivityMasterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdmRoleActivityMasterRepository.findAll().size();

        // Create the MdmRoleActivityMaster with an existing ID
        mdmRoleActivityMaster.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdmRoleActivityMasterMockMvc.perform(post("/api/mdm-role-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleActivityMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmRoleActivityMaster in the database
        List<MdmRoleActivityMaster> mdmRoleActivityMasterList = mdmRoleActivityMasterRepository.findAll();
        assertThat(mdmRoleActivityMasterList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkActivityCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmRoleActivityMasterRepository.findAll().size();
        // set the field null
        mdmRoleActivityMaster.setActivityCode(null);

        // Create the MdmRoleActivityMaster, which fails.

        restMdmRoleActivityMasterMockMvc.perform(post("/api/mdm-role-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleActivityMaster)))
            .andExpect(status().isBadRequest());

        List<MdmRoleActivityMaster> mdmRoleActivityMasterList = mdmRoleActivityMasterRepository.findAll();
        assertThat(mdmRoleActivityMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkActivityNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmRoleActivityMasterRepository.findAll().size();
        // set the field null
        mdmRoleActivityMaster.setActivityName(null);

        // Create the MdmRoleActivityMaster, which fails.

        restMdmRoleActivityMasterMockMvc.perform(post("/api/mdm-role-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleActivityMaster)))
            .andExpect(status().isBadRequest());

        List<MdmRoleActivityMaster> mdmRoleActivityMasterList = mdmRoleActivityMasterRepository.findAll();
        assertThat(mdmRoleActivityMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRoleCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmRoleActivityMasterRepository.findAll().size();
        // set the field null
        mdmRoleActivityMaster.setRoleCode(null);

        // Create the MdmRoleActivityMaster, which fails.

        restMdmRoleActivityMasterMockMvc.perform(post("/api/mdm-role-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleActivityMaster)))
            .andExpect(status().isBadRequest());

        List<MdmRoleActivityMaster> mdmRoleActivityMasterList = mdmRoleActivityMasterRepository.findAll();
        assertThat(mdmRoleActivityMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRoleNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmRoleActivityMasterRepository.findAll().size();
        // set the field null
        mdmRoleActivityMaster.setRoleName(null);

        // Create the MdmRoleActivityMaster, which fails.

        restMdmRoleActivityMasterMockMvc.perform(post("/api/mdm-role-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleActivityMaster)))
            .andExpect(status().isBadRequest());

        List<MdmRoleActivityMaster> mdmRoleActivityMasterList = mdmRoleActivityMasterRepository.findAll();
        assertThat(mdmRoleActivityMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMdmRoleActivityMasters() throws Exception {
        // Initialize the database
        mdmRoleActivityMasterRepository.saveAndFlush(mdmRoleActivityMaster);

        // Get all the mdmRoleActivityMasterList
        restMdmRoleActivityMasterMockMvc.perform(get("/api/mdm-role-activity-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdmRoleActivityMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].activityCode").value(hasItem(DEFAULT_ACTIVITY_CODE)))
            .andExpect(jsonPath("$.[*].activityName").value(hasItem(DEFAULT_ACTIVITY_NAME)))
            .andExpect(jsonPath("$.[*].activityLevelId").value(hasItem(DEFAULT_ACTIVITY_LEVEL_ID)))
            .andExpect(jsonPath("$.[*].activityLevelDesc").value(hasItem(DEFAULT_ACTIVITY_LEVEL_DESC)))
            .andExpect(jsonPath("$.[*].roleCode").value(hasItem(DEFAULT_ROLE_CODE)))
            .andExpect(jsonPath("$.[*].roleName").value(hasItem(DEFAULT_ROLE_NAME)))
            .andExpect(jsonPath("$.[*].roleLevelId").value(hasItem(DEFAULT_ROLE_LEVEL_ID)))
            .andExpect(jsonPath("$.[*].roleLevelDesc").value(hasItem(DEFAULT_ROLE_LEVEL_DESC)))
            .andExpect(jsonPath("$.[*].roleActivityStatus").value(hasItem(DEFAULT_ROLE_ACTIVITY_STATUS)))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].recordInsertTime").value(hasItem(DEFAULT_RECORD_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())));
    }
    
    @Test
    @Transactional
    public void getMdmRoleActivityMaster() throws Exception {
        // Initialize the database
        mdmRoleActivityMasterRepository.saveAndFlush(mdmRoleActivityMaster);

        // Get the mdmRoleActivityMaster
        restMdmRoleActivityMasterMockMvc.perform(get("/api/mdm-role-activity-masters/{id}", mdmRoleActivityMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mdmRoleActivityMaster.getId().intValue()))
            .andExpect(jsonPath("$.activityCode").value(DEFAULT_ACTIVITY_CODE))
            .andExpect(jsonPath("$.activityName").value(DEFAULT_ACTIVITY_NAME))
            .andExpect(jsonPath("$.activityLevelId").value(DEFAULT_ACTIVITY_LEVEL_ID))
            .andExpect(jsonPath("$.activityLevelDesc").value(DEFAULT_ACTIVITY_LEVEL_DESC))
            .andExpect(jsonPath("$.roleCode").value(DEFAULT_ROLE_CODE))
            .andExpect(jsonPath("$.roleName").value(DEFAULT_ROLE_NAME))
            .andExpect(jsonPath("$.roleLevelId").value(DEFAULT_ROLE_LEVEL_ID))
            .andExpect(jsonPath("$.roleLevelDesc").value(DEFAULT_ROLE_LEVEL_DESC))
            .andExpect(jsonPath("$.roleActivityStatus").value(DEFAULT_ROLE_ACTIVITY_STATUS))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.recordInsertTime").value(DEFAULT_RECORD_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingMdmRoleActivityMaster() throws Exception {
        // Get the mdmRoleActivityMaster
        restMdmRoleActivityMasterMockMvc.perform(get("/api/mdm-role-activity-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdmRoleActivityMaster() throws Exception {
        // Initialize the database
        mdmRoleActivityMasterRepository.saveAndFlush(mdmRoleActivityMaster);

        int databaseSizeBeforeUpdate = mdmRoleActivityMasterRepository.findAll().size();

        // Update the mdmRoleActivityMaster
        MdmRoleActivityMaster updatedMdmRoleActivityMaster = mdmRoleActivityMasterRepository.findById(mdmRoleActivityMaster.getId()).get();
        // Disconnect from session so that the updates on updatedMdmRoleActivityMaster are not directly saved in db
        em.detach(updatedMdmRoleActivityMaster);
        updatedMdmRoleActivityMaster
            .activityCode(UPDATED_ACTIVITY_CODE)
            .activityName(UPDATED_ACTIVITY_NAME)
            .activityLevelId(UPDATED_ACTIVITY_LEVEL_ID)
            .activityLevelDesc(UPDATED_ACTIVITY_LEVEL_DESC)
            .roleCode(UPDATED_ROLE_CODE)
            .roleName(UPDATED_ROLE_NAME)
            .roleLevelId(UPDATED_ROLE_LEVEL_ID)
            .roleLevelDesc(UPDATED_ROLE_LEVEL_DESC)
            .roleActivityStatus(UPDATED_ROLE_ACTIVITY_STATUS)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME);

        restMdmRoleActivityMasterMockMvc.perform(put("/api/mdm-role-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdmRoleActivityMaster)))
            .andExpect(status().isOk());

        // Validate the MdmRoleActivityMaster in the database
        List<MdmRoleActivityMaster> mdmRoleActivityMasterList = mdmRoleActivityMasterRepository.findAll();
        assertThat(mdmRoleActivityMasterList).hasSize(databaseSizeBeforeUpdate);
        MdmRoleActivityMaster testMdmRoleActivityMaster = mdmRoleActivityMasterList.get(mdmRoleActivityMasterList.size() - 1);
        assertThat(testMdmRoleActivityMaster.getActivityCode()).isEqualTo(UPDATED_ACTIVITY_CODE);
        assertThat(testMdmRoleActivityMaster.getActivityName()).isEqualTo(UPDATED_ACTIVITY_NAME);
        assertThat(testMdmRoleActivityMaster.getActivityLevelId()).isEqualTo(UPDATED_ACTIVITY_LEVEL_ID);
        assertThat(testMdmRoleActivityMaster.getActivityLevelDesc()).isEqualTo(UPDATED_ACTIVITY_LEVEL_DESC);
        assertThat(testMdmRoleActivityMaster.getRoleCode()).isEqualTo(UPDATED_ROLE_CODE);
        assertThat(testMdmRoleActivityMaster.getRoleName()).isEqualTo(UPDATED_ROLE_NAME);
        assertThat(testMdmRoleActivityMaster.getRoleLevelId()).isEqualTo(UPDATED_ROLE_LEVEL_ID);
        assertThat(testMdmRoleActivityMaster.getRoleLevelDesc()).isEqualTo(UPDATED_ROLE_LEVEL_DESC);
        assertThat(testMdmRoleActivityMaster.getRoleActivityStatus()).isEqualTo(UPDATED_ROLE_ACTIVITY_STATUS);
        assertThat(testMdmRoleActivityMaster.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testMdmRoleActivityMaster.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testMdmRoleActivityMaster.getRecordInsertTime()).isEqualTo(UPDATED_RECORD_INSERT_TIME);
        assertThat(testMdmRoleActivityMaster.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testMdmRoleActivityMaster.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingMdmRoleActivityMaster() throws Exception {
        int databaseSizeBeforeUpdate = mdmRoleActivityMasterRepository.findAll().size();

        // Create the MdmRoleActivityMaster

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdmRoleActivityMasterMockMvc.perform(put("/api/mdm-role-activity-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleActivityMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmRoleActivityMaster in the database
        List<MdmRoleActivityMaster> mdmRoleActivityMasterList = mdmRoleActivityMasterRepository.findAll();
        assertThat(mdmRoleActivityMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdmRoleActivityMaster() throws Exception {
        // Initialize the database
        mdmRoleActivityMasterRepository.saveAndFlush(mdmRoleActivityMaster);

        int databaseSizeBeforeDelete = mdmRoleActivityMasterRepository.findAll().size();

        // Delete the mdmRoleActivityMaster
        restMdmRoleActivityMasterMockMvc.perform(delete("/api/mdm-role-activity-masters/{id}", mdmRoleActivityMaster.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdmRoleActivityMaster> mdmRoleActivityMasterList = mdmRoleActivityMasterRepository.findAll();
        assertThat(mdmRoleActivityMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
