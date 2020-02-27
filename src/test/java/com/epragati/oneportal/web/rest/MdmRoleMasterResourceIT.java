package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.OnePortalApp;
import com.epragati.oneportal.domain.MdmRoleMaster;
import com.epragati.oneportal.repository.MdmRoleMasterRepository;
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
 * Integration tests for the {@link MdmRoleMasterResource} REST controller.
 */
@SpringBootTest(classes = OnePortalApp.class)
public class MdmRoleMasterResourceIT {

    private static final String DEFAULT_ROLE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE_DESC = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LOCATION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_LOCATION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_LOCATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LOCATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_STATUS = "BBBBBBBBBB";

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

    private static final Integer DEFAULT_ROLE_LEVEL_ID = 1;
    private static final Integer UPDATED_ROLE_LEVEL_ID = 2;

    private static final String DEFAULT_ROLE_LEVEL_DESC = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_LEVEL_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_VOLUNTEER_SECRETARIAT = "AAAAAAAAAA";
    private static final String UPDATED_VOLUNTEER_SECRETARIAT = "BBBBBBBBBB";

    @Autowired
    private MdmRoleMasterRepository mdmRoleMasterRepository;

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

    private MockMvc restMdmRoleMasterMockMvc;

    private MdmRoleMaster mdmRoleMaster;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdmRoleMasterResource mdmRoleMasterResource = new MdmRoleMasterResource(mdmRoleMasterRepository);
        this.restMdmRoleMasterMockMvc = MockMvcBuilders.standaloneSetup(mdmRoleMasterResource)
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
    public static MdmRoleMaster createEntity(EntityManager em) {
        MdmRoleMaster mdmRoleMaster = new MdmRoleMaster()
            .roleCode(DEFAULT_ROLE_CODE)
            .roleName(DEFAULT_ROLE_NAME)
            .roleDesc(DEFAULT_ROLE_DESC)
            .organizationCode(DEFAULT_ORGANIZATION_CODE)
            .organizationName(DEFAULT_ORGANIZATION_NAME)
            .serviceCode(DEFAULT_SERVICE_CODE)
            .serviceName(DEFAULT_SERVICE_NAME)
            .locationCode(DEFAULT_LOCATION_CODE)
            .locationName(DEFAULT_LOCATION_NAME)
            .roleStatus(DEFAULT_ROLE_STATUS)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedBy(DEFAULT_UPDATED_BY)
            .recordInsertTime(DEFAULT_RECORD_INSERT_TIME)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME)
            .roleLevelId(DEFAULT_ROLE_LEVEL_ID)
            .roleLevelDesc(DEFAULT_ROLE_LEVEL_DESC)
            .volunteerSecretariat(DEFAULT_VOLUNTEER_SECRETARIAT);
        return mdmRoleMaster;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmRoleMaster createUpdatedEntity(EntityManager em) {
        MdmRoleMaster mdmRoleMaster = new MdmRoleMaster()
            .roleCode(UPDATED_ROLE_CODE)
            .roleName(UPDATED_ROLE_NAME)
            .roleDesc(UPDATED_ROLE_DESC)
            .organizationCode(UPDATED_ORGANIZATION_CODE)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .serviceCode(UPDATED_SERVICE_CODE)
            .serviceName(UPDATED_SERVICE_NAME)
            .locationCode(UPDATED_LOCATION_CODE)
            .locationName(UPDATED_LOCATION_NAME)
            .roleStatus(UPDATED_ROLE_STATUS)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .roleLevelId(UPDATED_ROLE_LEVEL_ID)
            .roleLevelDesc(UPDATED_ROLE_LEVEL_DESC)
            .volunteerSecretariat(UPDATED_VOLUNTEER_SECRETARIAT);
        return mdmRoleMaster;
    }

    @BeforeEach
    public void initTest() {
        mdmRoleMaster = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdmRoleMaster() throws Exception {
        int databaseSizeBeforeCreate = mdmRoleMasterRepository.findAll().size();

        // Create the MdmRoleMaster
        restMdmRoleMasterMockMvc.perform(post("/api/mdm-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleMaster)))
            .andExpect(status().isCreated());

        // Validate the MdmRoleMaster in the database
        List<MdmRoleMaster> mdmRoleMasterList = mdmRoleMasterRepository.findAll();
        assertThat(mdmRoleMasterList).hasSize(databaseSizeBeforeCreate + 1);
        MdmRoleMaster testMdmRoleMaster = mdmRoleMasterList.get(mdmRoleMasterList.size() - 1);
        assertThat(testMdmRoleMaster.getRoleCode()).isEqualTo(DEFAULT_ROLE_CODE);
        assertThat(testMdmRoleMaster.getRoleName()).isEqualTo(DEFAULT_ROLE_NAME);
        assertThat(testMdmRoleMaster.getRoleDesc()).isEqualTo(DEFAULT_ROLE_DESC);
        assertThat(testMdmRoleMaster.getOrganizationCode()).isEqualTo(DEFAULT_ORGANIZATION_CODE);
        assertThat(testMdmRoleMaster.getOrganizationName()).isEqualTo(DEFAULT_ORGANIZATION_NAME);
        assertThat(testMdmRoleMaster.getServiceCode()).isEqualTo(DEFAULT_SERVICE_CODE);
        assertThat(testMdmRoleMaster.getServiceName()).isEqualTo(DEFAULT_SERVICE_NAME);
        assertThat(testMdmRoleMaster.getLocationCode()).isEqualTo(DEFAULT_LOCATION_CODE);
        assertThat(testMdmRoleMaster.getLocationName()).isEqualTo(DEFAULT_LOCATION_NAME);
        assertThat(testMdmRoleMaster.getRoleStatus()).isEqualTo(DEFAULT_ROLE_STATUS);
        assertThat(testMdmRoleMaster.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testMdmRoleMaster.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testMdmRoleMaster.getRecordInsertTime()).isEqualTo(DEFAULT_RECORD_INSERT_TIME);
        assertThat(testMdmRoleMaster.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testMdmRoleMaster.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
        assertThat(testMdmRoleMaster.getRoleLevelId()).isEqualTo(DEFAULT_ROLE_LEVEL_ID);
        assertThat(testMdmRoleMaster.getRoleLevelDesc()).isEqualTo(DEFAULT_ROLE_LEVEL_DESC);
        assertThat(testMdmRoleMaster.getVolunteerSecretariat()).isEqualTo(DEFAULT_VOLUNTEER_SECRETARIAT);
    }

    @Test
    @Transactional
    public void createMdmRoleMasterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdmRoleMasterRepository.findAll().size();

        // Create the MdmRoleMaster with an existing ID
        mdmRoleMaster.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdmRoleMasterMockMvc.perform(post("/api/mdm-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmRoleMaster in the database
        List<MdmRoleMaster> mdmRoleMasterList = mdmRoleMasterRepository.findAll();
        assertThat(mdmRoleMasterList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkRoleCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmRoleMasterRepository.findAll().size();
        // set the field null
        mdmRoleMaster.setRoleCode(null);

        // Create the MdmRoleMaster, which fails.

        restMdmRoleMasterMockMvc.perform(post("/api/mdm-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleMaster)))
            .andExpect(status().isBadRequest());

        List<MdmRoleMaster> mdmRoleMasterList = mdmRoleMasterRepository.findAll();
        assertThat(mdmRoleMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMdmRoleMasters() throws Exception {
        // Initialize the database
        mdmRoleMasterRepository.saveAndFlush(mdmRoleMaster);

        // Get all the mdmRoleMasterList
        restMdmRoleMasterMockMvc.perform(get("/api/mdm-role-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdmRoleMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].roleCode").value(hasItem(DEFAULT_ROLE_CODE)))
            .andExpect(jsonPath("$.[*].roleName").value(hasItem(DEFAULT_ROLE_NAME)))
            .andExpect(jsonPath("$.[*].roleDesc").value(hasItem(DEFAULT_ROLE_DESC)))
            .andExpect(jsonPath("$.[*].organizationCode").value(hasItem(DEFAULT_ORGANIZATION_CODE)))
            .andExpect(jsonPath("$.[*].organizationName").value(hasItem(DEFAULT_ORGANIZATION_NAME)))
            .andExpect(jsonPath("$.[*].serviceCode").value(hasItem(DEFAULT_SERVICE_CODE)))
            .andExpect(jsonPath("$.[*].serviceName").value(hasItem(DEFAULT_SERVICE_NAME)))
            .andExpect(jsonPath("$.[*].locationCode").value(hasItem(DEFAULT_LOCATION_CODE)))
            .andExpect(jsonPath("$.[*].locationName").value(hasItem(DEFAULT_LOCATION_NAME)))
            .andExpect(jsonPath("$.[*].roleStatus").value(hasItem(DEFAULT_ROLE_STATUS)))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].recordInsertTime").value(hasItem(DEFAULT_RECORD_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].roleLevelId").value(hasItem(DEFAULT_ROLE_LEVEL_ID)))
            .andExpect(jsonPath("$.[*].roleLevelDesc").value(hasItem(DEFAULT_ROLE_LEVEL_DESC)))
            .andExpect(jsonPath("$.[*].volunteerSecretariat").value(hasItem(DEFAULT_VOLUNTEER_SECRETARIAT)));
    }
    
    @Test
    @Transactional
    public void getMdmRoleMaster() throws Exception {
        // Initialize the database
        mdmRoleMasterRepository.saveAndFlush(mdmRoleMaster);

        // Get the mdmRoleMaster
        restMdmRoleMasterMockMvc.perform(get("/api/mdm-role-masters/{id}", mdmRoleMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mdmRoleMaster.getId().intValue()))
            .andExpect(jsonPath("$.roleCode").value(DEFAULT_ROLE_CODE))
            .andExpect(jsonPath("$.roleName").value(DEFAULT_ROLE_NAME))
            .andExpect(jsonPath("$.roleDesc").value(DEFAULT_ROLE_DESC))
            .andExpect(jsonPath("$.organizationCode").value(DEFAULT_ORGANIZATION_CODE))
            .andExpect(jsonPath("$.organizationName").value(DEFAULT_ORGANIZATION_NAME))
            .andExpect(jsonPath("$.serviceCode").value(DEFAULT_SERVICE_CODE))
            .andExpect(jsonPath("$.serviceName").value(DEFAULT_SERVICE_NAME))
            .andExpect(jsonPath("$.locationCode").value(DEFAULT_LOCATION_CODE))
            .andExpect(jsonPath("$.locationName").value(DEFAULT_LOCATION_NAME))
            .andExpect(jsonPath("$.roleStatus").value(DEFAULT_ROLE_STATUS))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.recordInsertTime").value(DEFAULT_RECORD_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()))
            .andExpect(jsonPath("$.roleLevelId").value(DEFAULT_ROLE_LEVEL_ID))
            .andExpect(jsonPath("$.roleLevelDesc").value(DEFAULT_ROLE_LEVEL_DESC))
            .andExpect(jsonPath("$.volunteerSecretariat").value(DEFAULT_VOLUNTEER_SECRETARIAT));
    }

    @Test
    @Transactional
    public void getNonExistingMdmRoleMaster() throws Exception {
        // Get the mdmRoleMaster
        restMdmRoleMasterMockMvc.perform(get("/api/mdm-role-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdmRoleMaster() throws Exception {
        // Initialize the database
        mdmRoleMasterRepository.saveAndFlush(mdmRoleMaster);

        int databaseSizeBeforeUpdate = mdmRoleMasterRepository.findAll().size();

        // Update the mdmRoleMaster
        MdmRoleMaster updatedMdmRoleMaster = mdmRoleMasterRepository.findById(mdmRoleMaster.getId()).get();
        // Disconnect from session so that the updates on updatedMdmRoleMaster are not directly saved in db
        em.detach(updatedMdmRoleMaster);
        updatedMdmRoleMaster
            .roleCode(UPDATED_ROLE_CODE)
            .roleName(UPDATED_ROLE_NAME)
            .roleDesc(UPDATED_ROLE_DESC)
            .organizationCode(UPDATED_ORGANIZATION_CODE)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .serviceCode(UPDATED_SERVICE_CODE)
            .serviceName(UPDATED_SERVICE_NAME)
            .locationCode(UPDATED_LOCATION_CODE)
            .locationName(UPDATED_LOCATION_NAME)
            .roleStatus(UPDATED_ROLE_STATUS)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .roleLevelId(UPDATED_ROLE_LEVEL_ID)
            .roleLevelDesc(UPDATED_ROLE_LEVEL_DESC)
            .volunteerSecretariat(UPDATED_VOLUNTEER_SECRETARIAT);

        restMdmRoleMasterMockMvc.perform(put("/api/mdm-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdmRoleMaster)))
            .andExpect(status().isOk());

        // Validate the MdmRoleMaster in the database
        List<MdmRoleMaster> mdmRoleMasterList = mdmRoleMasterRepository.findAll();
        assertThat(mdmRoleMasterList).hasSize(databaseSizeBeforeUpdate);
        MdmRoleMaster testMdmRoleMaster = mdmRoleMasterList.get(mdmRoleMasterList.size() - 1);
        assertThat(testMdmRoleMaster.getRoleCode()).isEqualTo(UPDATED_ROLE_CODE);
        assertThat(testMdmRoleMaster.getRoleName()).isEqualTo(UPDATED_ROLE_NAME);
        assertThat(testMdmRoleMaster.getRoleDesc()).isEqualTo(UPDATED_ROLE_DESC);
        assertThat(testMdmRoleMaster.getOrganizationCode()).isEqualTo(UPDATED_ORGANIZATION_CODE);
        assertThat(testMdmRoleMaster.getOrganizationName()).isEqualTo(UPDATED_ORGANIZATION_NAME);
        assertThat(testMdmRoleMaster.getServiceCode()).isEqualTo(UPDATED_SERVICE_CODE);
        assertThat(testMdmRoleMaster.getServiceName()).isEqualTo(UPDATED_SERVICE_NAME);
        assertThat(testMdmRoleMaster.getLocationCode()).isEqualTo(UPDATED_LOCATION_CODE);
        assertThat(testMdmRoleMaster.getLocationName()).isEqualTo(UPDATED_LOCATION_NAME);
        assertThat(testMdmRoleMaster.getRoleStatus()).isEqualTo(UPDATED_ROLE_STATUS);
        assertThat(testMdmRoleMaster.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testMdmRoleMaster.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testMdmRoleMaster.getRecordInsertTime()).isEqualTo(UPDATED_RECORD_INSERT_TIME);
        assertThat(testMdmRoleMaster.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testMdmRoleMaster.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
        assertThat(testMdmRoleMaster.getRoleLevelId()).isEqualTo(UPDATED_ROLE_LEVEL_ID);
        assertThat(testMdmRoleMaster.getRoleLevelDesc()).isEqualTo(UPDATED_ROLE_LEVEL_DESC);
        assertThat(testMdmRoleMaster.getVolunteerSecretariat()).isEqualTo(UPDATED_VOLUNTEER_SECRETARIAT);
    }

    @Test
    @Transactional
    public void updateNonExistingMdmRoleMaster() throws Exception {
        int databaseSizeBeforeUpdate = mdmRoleMasterRepository.findAll().size();

        // Create the MdmRoleMaster

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdmRoleMasterMockMvc.perform(put("/api/mdm-role-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmRoleMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmRoleMaster in the database
        List<MdmRoleMaster> mdmRoleMasterList = mdmRoleMasterRepository.findAll();
        assertThat(mdmRoleMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdmRoleMaster() throws Exception {
        // Initialize the database
        mdmRoleMasterRepository.saveAndFlush(mdmRoleMaster);

        int databaseSizeBeforeDelete = mdmRoleMasterRepository.findAll().size();

        // Delete the mdmRoleMaster
        restMdmRoleMasterMockMvc.perform(delete("/api/mdm-role-masters/{id}", mdmRoleMaster.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdmRoleMaster> mdmRoleMasterList = mdmRoleMasterRepository.findAll();
        assertThat(mdmRoleMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
