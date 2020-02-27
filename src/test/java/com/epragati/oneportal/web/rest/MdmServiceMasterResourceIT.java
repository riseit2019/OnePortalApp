package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.OnePortalApp;
import com.epragati.oneportal.domain.MdmServiceMaster;
import com.epragati.oneportal.repository.MdmServiceMasterRepository;
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
 * Integration tests for the {@link MdmServiceMasterResource} REST controller.
 */
@SpringBootTest(classes = OnePortalApp.class)
public class MdmServiceMasterResourceIT {

    private static final String DEFAULT_SERVICE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_SHORT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_SHORT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_DESC = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_SERVICE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_SERVICE_CODE = "BBBBBBBBBB";

    private static final Instant DEFAULT_SERVICE_PERIOD_START_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_SERVICE_PERIOD_START_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_SERVICE_PERIOD_END_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_SERVICE_PERIOD_END_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_SERVICE_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_LINK = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_LINK = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_CLASS = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_INTEGRATION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_INTEGRATION_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_LOOKUP_ROLE_ID = 1;
    private static final Integer UPDATED_LOOKUP_ROLE_ID = 2;

    private static final String DEFAULT_LOOKUP_ROLE = "AAAAAAAAAA";
    private static final String UPDATED_LOOKUP_ROLE = "BBBBBBBBBB";

    private static final Integer DEFAULT_LOOKUP_SECTOR_ID = 1;
    private static final Integer UPDATED_LOOKUP_SECTOR_ID = 2;

    private static final String DEFAULT_LOOKUP_SECTOR = "AAAAAAAAAA";
    private static final String UPDATED_LOOKUP_SECTOR = "BBBBBBBBBB";

    private static final Integer DEFAULT_LOOKUP_LIFEEVENT_ID = 1;
    private static final Integer UPDATED_LOOKUP_LIFEEVENT_ID = 2;

    private static final String DEFAULT_LOOKUP_LIFEEVENT = "AAAAAAAAAA";
    private static final String UPDATED_LOOKUP_LIFEEVENT = "BBBBBBBBBB";

    private static final Integer DEFAULT_SLA_GOAL = 1;
    private static final Integer UPDATED_SLA_GOAL = 2;

    private static final Integer DEFAULT_SERVICE_ACTIVE_FLAG = 1;
    private static final Integer UPDATED_SERVICE_ACTIVE_FLAG = 2;

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

    private static final String DEFAULT_SECTION_DISPLAY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SECTION_DISPLAY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SECTION_DISPLAY_ICON = "AAAAAAAAAA";
    private static final String UPDATED_SECTION_DISPLAY_ICON = "BBBBBBBBBB";

    private static final String DEFAULT_RULESET_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RULESET_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_SERVICE_PRIORITY = 1;
    private static final Integer UPDATED_SERVICE_PRIORITY = 2;

    private static final String DEFAULT_SERVICE_CHANNEL_ACCESS = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_CHANNEL_ACCESS = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_ACCESS = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_ACCESS = "BBBBBBBBBB";

    private static final String DEFAULT_ASSISTEDMODEEKYC_REQ = "AAAAAAAAAA";
    private static final String UPDATED_ASSISTEDMODEEKYC_REQ = "BBBBBBBBBB";

    private static final String DEFAULT_ASSISTED_OTH_ADR_REQ = "AAAAAAAAAA";
    private static final String UPDATED_ASSISTED_OTH_ADR_REQ = "BBBBBBBBBB";

    private static final Integer DEFAULT_SLA_DEADLINE = 1;
    private static final Integer UPDATED_SLA_DEADLINE = 2;

    private static final Long DEFAULT_PAYMENT_CHANNEL_ID = 1L;
    private static final Long UPDATED_PAYMENT_CHANNEL_ID = 2L;

    private static final String DEFAULT_PAYMENT_RETURN_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_RETURN_CLASS = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_RETURN_RULESET = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_RETURN_RULESET = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_RETURNURL = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_RETURNURL = "BBBBBBBBBB";

    private static final String DEFAULT_HELP_LINK = "AAAAAAAAAA";
    private static final String UPDATED_HELP_LINK = "BBBBBBBBBB";

    private static final String DEFAULT_INTERMEDIATE_SCREEN = "AAAAAAAAAA";
    private static final String UPDATED_INTERMEDIATE_SCREEN = "BBBBBBBBBB";

    private static final String DEFAULT_AADHAAR_REQUIRED = "AAAAAAAAAA";
    private static final String UPDATED_AADHAAR_REQUIRED = "BBBBBBBBBB";

    private static final Integer DEFAULT_MEESEVA_SERVICE_ID = 1;
    private static final Integer UPDATED_MEESEVA_SERVICE_ID = 2;

    private static final String DEFAULT_MEESEVA_SERVICE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MEESEVA_SERVICE_NAME = "BBBBBBBBBB";

    private static final Float DEFAULT_PMT_FEE_AMT_TOTAL = 1F;
    private static final Float UPDATED_PMT_FEE_AMT_TOTAL = 2F;

    private static final Float DEFAULT_PMT_FEE_AMT_OTHERS_1 = 1F;
    private static final Float UPDATED_PMT_FEE_AMT_OTHERS_1 = 2F;

    private static final String DEFAULT_PMT_FEE_AMT_OTHERS_1_DESC = "AAAAAAAAAA";
    private static final String UPDATED_PMT_FEE_AMT_OTHERS_1_DESC = "BBBBBBBBBB";

    private static final Float DEFAULT_PMT_FEE_AMT_OTHERS_2 = 1F;
    private static final Float UPDATED_PMT_FEE_AMT_OTHERS_2 = 2F;

    private static final String DEFAULT_PMT_FEE_AMT_OTHERS_2_DESC = "AAAAAAAAAA";
    private static final String UPDATED_PMT_FEE_AMT_OTHERS_2_DESC = "BBBBBBBBBB";

    private static final Float DEFAULT_PMT_FEE_AMT_OTHERS_3 = 1F;
    private static final Float UPDATED_PMT_FEE_AMT_OTHERS_3 = 2F;

    private static final String DEFAULT_PMT_FEE_AMT_OTHERS_3_DESC = "AAAAAAAAAA";
    private static final String UPDATED_PMT_FEE_AMT_OTHERS_3_DESC = "BBBBBBBBBB";

    private static final Float DEFAULT_PMT_FEE_AMT_OTHERS_4 = 1F;
    private static final Float UPDATED_PMT_FEE_AMT_OTHERS_4 = 2F;

    private static final String DEFAULT_PMT_FEE_AMT_OTHERS_4_DESC = "AAAAAAAAAA";
    private static final String UPDATED_PMT_FEE_AMT_OTHERS_4_DESC = "BBBBBBBBBB";

    private static final Float DEFAULT_PMT_FEE_AMT_OTHERS_5 = 1F;
    private static final Float UPDATED_PMT_FEE_AMT_OTHERS_5 = 2F;

    private static final String DEFAULT_PMT_FEE_AMT_OTHERS_5_DESC = "AAAAAAAAAA";
    private static final String UPDATED_PMT_FEE_AMT_OTHERS_5_DESC = "BBBBBBBBBB";

    @Autowired
    private MdmServiceMasterRepository mdmServiceMasterRepository;

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

    private MockMvc restMdmServiceMasterMockMvc;

    private MdmServiceMaster mdmServiceMaster;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdmServiceMasterResource mdmServiceMasterResource = new MdmServiceMasterResource(mdmServiceMasterRepository);
        this.restMdmServiceMasterMockMvc = MockMvcBuilders.standaloneSetup(mdmServiceMasterResource)
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
    public static MdmServiceMaster createEntity(EntityManager em) {
        MdmServiceMaster mdmServiceMaster = new MdmServiceMaster()
            .serviceCode(DEFAULT_SERVICE_CODE)
            .organizationCode(DEFAULT_ORGANIZATION_CODE)
            .organizationName(DEFAULT_ORGANIZATION_NAME)
            .serviceShortName(DEFAULT_SERVICE_SHORT_NAME)
            .serviceName(DEFAULT_SERVICE_NAME)
            .serviceDesc(DEFAULT_SERVICE_DESC)
            .parentServiceCode(DEFAULT_PARENT_SERVICE_CODE)
            .servicePeriodStartDate(DEFAULT_SERVICE_PERIOD_START_DATE)
            .servicePeriodEndDate(DEFAULT_SERVICE_PERIOD_END_DATE)
            .serviceCategory(DEFAULT_SERVICE_CATEGORY)
            .serviceLink(DEFAULT_SERVICE_LINK)
            .serviceClass(DEFAULT_SERVICE_CLASS)
            .serviceIntegrationType(DEFAULT_SERVICE_INTEGRATION_TYPE)
            .serviceType(DEFAULT_SERVICE_TYPE)
            .lookupRoleId(DEFAULT_LOOKUP_ROLE_ID)
            .lookupRole(DEFAULT_LOOKUP_ROLE)
            .lookupSectorId(DEFAULT_LOOKUP_SECTOR_ID)
            .lookupSector(DEFAULT_LOOKUP_SECTOR)
            .lookupLifeeventId(DEFAULT_LOOKUP_LIFEEVENT_ID)
            .lookupLifeevent(DEFAULT_LOOKUP_LIFEEVENT)
            .slaGoal(DEFAULT_SLA_GOAL)
            .serviceActiveFlag(DEFAULT_SERVICE_ACTIVE_FLAG)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedBy(DEFAULT_UPDATED_BY)
            .recordInsertTime(DEFAULT_RECORD_INSERT_TIME)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME)
            .sectionDisplayName(DEFAULT_SECTION_DISPLAY_NAME)
            .sectionDisplayIcon(DEFAULT_SECTION_DISPLAY_ICON)
            .rulesetName(DEFAULT_RULESET_NAME)
            .servicePriority(DEFAULT_SERVICE_PRIORITY)
            .serviceChannelAccess(DEFAULT_SERVICE_CHANNEL_ACCESS)
            .serviceAccess(DEFAULT_SERVICE_ACCESS)
            .assistedmodeekycReq(DEFAULT_ASSISTEDMODEEKYC_REQ)
            .assistedOthAdrReq(DEFAULT_ASSISTED_OTH_ADR_REQ)
            .slaDeadline(DEFAULT_SLA_DEADLINE)
            .paymentChannelId(DEFAULT_PAYMENT_CHANNEL_ID)
            .paymentReturnClass(DEFAULT_PAYMENT_RETURN_CLASS)
            .paymentReturnRuleset(DEFAULT_PAYMENT_RETURN_RULESET)
            .paymentReturnurl(DEFAULT_PAYMENT_RETURNURL)
            .helpLink(DEFAULT_HELP_LINK)
            .intermediateScreen(DEFAULT_INTERMEDIATE_SCREEN)
            .aadhaarRequired(DEFAULT_AADHAAR_REQUIRED)
            .meesevaServiceId(DEFAULT_MEESEVA_SERVICE_ID)
            .meesevaServiceName(DEFAULT_MEESEVA_SERVICE_NAME)
            .pmtFeeAmtTotal(DEFAULT_PMT_FEE_AMT_TOTAL)
            .pmtFeeAmtOthers1(DEFAULT_PMT_FEE_AMT_OTHERS_1)
            .pmtFeeAmtOthers1Desc(DEFAULT_PMT_FEE_AMT_OTHERS_1_DESC)
            .pmtFeeAmtOthers2(DEFAULT_PMT_FEE_AMT_OTHERS_2)
            .pmtFeeAmtOthers2Desc(DEFAULT_PMT_FEE_AMT_OTHERS_2_DESC)
            .pmtFeeAmtOthers3(DEFAULT_PMT_FEE_AMT_OTHERS_3)
            .pmtFeeAmtOthers3Desc(DEFAULT_PMT_FEE_AMT_OTHERS_3_DESC)
            .pmtFeeAmtOthers4(DEFAULT_PMT_FEE_AMT_OTHERS_4)
            .pmtFeeAmtOthers4Desc(DEFAULT_PMT_FEE_AMT_OTHERS_4_DESC)
            .pmtFeeAmtOthers5(DEFAULT_PMT_FEE_AMT_OTHERS_5)
            .pmtFeeAmtOthers5Desc(DEFAULT_PMT_FEE_AMT_OTHERS_5_DESC);
        return mdmServiceMaster;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdmServiceMaster createUpdatedEntity(EntityManager em) {
        MdmServiceMaster mdmServiceMaster = new MdmServiceMaster()
            .serviceCode(UPDATED_SERVICE_CODE)
            .organizationCode(UPDATED_ORGANIZATION_CODE)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .serviceShortName(UPDATED_SERVICE_SHORT_NAME)
            .serviceName(UPDATED_SERVICE_NAME)
            .serviceDesc(UPDATED_SERVICE_DESC)
            .parentServiceCode(UPDATED_PARENT_SERVICE_CODE)
            .servicePeriodStartDate(UPDATED_SERVICE_PERIOD_START_DATE)
            .servicePeriodEndDate(UPDATED_SERVICE_PERIOD_END_DATE)
            .serviceCategory(UPDATED_SERVICE_CATEGORY)
            .serviceLink(UPDATED_SERVICE_LINK)
            .serviceClass(UPDATED_SERVICE_CLASS)
            .serviceIntegrationType(UPDATED_SERVICE_INTEGRATION_TYPE)
            .serviceType(UPDATED_SERVICE_TYPE)
            .lookupRoleId(UPDATED_LOOKUP_ROLE_ID)
            .lookupRole(UPDATED_LOOKUP_ROLE)
            .lookupSectorId(UPDATED_LOOKUP_SECTOR_ID)
            .lookupSector(UPDATED_LOOKUP_SECTOR)
            .lookupLifeeventId(UPDATED_LOOKUP_LIFEEVENT_ID)
            .lookupLifeevent(UPDATED_LOOKUP_LIFEEVENT)
            .slaGoal(UPDATED_SLA_GOAL)
            .serviceActiveFlag(UPDATED_SERVICE_ACTIVE_FLAG)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .sectionDisplayName(UPDATED_SECTION_DISPLAY_NAME)
            .sectionDisplayIcon(UPDATED_SECTION_DISPLAY_ICON)
            .rulesetName(UPDATED_RULESET_NAME)
            .servicePriority(UPDATED_SERVICE_PRIORITY)
            .serviceChannelAccess(UPDATED_SERVICE_CHANNEL_ACCESS)
            .serviceAccess(UPDATED_SERVICE_ACCESS)
            .assistedmodeekycReq(UPDATED_ASSISTEDMODEEKYC_REQ)
            .assistedOthAdrReq(UPDATED_ASSISTED_OTH_ADR_REQ)
            .slaDeadline(UPDATED_SLA_DEADLINE)
            .paymentChannelId(UPDATED_PAYMENT_CHANNEL_ID)
            .paymentReturnClass(UPDATED_PAYMENT_RETURN_CLASS)
            .paymentReturnRuleset(UPDATED_PAYMENT_RETURN_RULESET)
            .paymentReturnurl(UPDATED_PAYMENT_RETURNURL)
            .helpLink(UPDATED_HELP_LINK)
            .intermediateScreen(UPDATED_INTERMEDIATE_SCREEN)
            .aadhaarRequired(UPDATED_AADHAAR_REQUIRED)
            .meesevaServiceId(UPDATED_MEESEVA_SERVICE_ID)
            .meesevaServiceName(UPDATED_MEESEVA_SERVICE_NAME)
            .pmtFeeAmtTotal(UPDATED_PMT_FEE_AMT_TOTAL)
            .pmtFeeAmtOthers1(UPDATED_PMT_FEE_AMT_OTHERS_1)
            .pmtFeeAmtOthers1Desc(UPDATED_PMT_FEE_AMT_OTHERS_1_DESC)
            .pmtFeeAmtOthers2(UPDATED_PMT_FEE_AMT_OTHERS_2)
            .pmtFeeAmtOthers2Desc(UPDATED_PMT_FEE_AMT_OTHERS_2_DESC)
            .pmtFeeAmtOthers3(UPDATED_PMT_FEE_AMT_OTHERS_3)
            .pmtFeeAmtOthers3Desc(UPDATED_PMT_FEE_AMT_OTHERS_3_DESC)
            .pmtFeeAmtOthers4(UPDATED_PMT_FEE_AMT_OTHERS_4)
            .pmtFeeAmtOthers4Desc(UPDATED_PMT_FEE_AMT_OTHERS_4_DESC)
            .pmtFeeAmtOthers5(UPDATED_PMT_FEE_AMT_OTHERS_5)
            .pmtFeeAmtOthers5Desc(UPDATED_PMT_FEE_AMT_OTHERS_5_DESC);
        return mdmServiceMaster;
    }

    @BeforeEach
    public void initTest() {
        mdmServiceMaster = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdmServiceMaster() throws Exception {
        int databaseSizeBeforeCreate = mdmServiceMasterRepository.findAll().size();

        // Create the MdmServiceMaster
        restMdmServiceMasterMockMvc.perform(post("/api/mdm-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmServiceMaster)))
            .andExpect(status().isCreated());

        // Validate the MdmServiceMaster in the database
        List<MdmServiceMaster> mdmServiceMasterList = mdmServiceMasterRepository.findAll();
        assertThat(mdmServiceMasterList).hasSize(databaseSizeBeforeCreate + 1);
        MdmServiceMaster testMdmServiceMaster = mdmServiceMasterList.get(mdmServiceMasterList.size() - 1);
        assertThat(testMdmServiceMaster.getServiceCode()).isEqualTo(DEFAULT_SERVICE_CODE);
        assertThat(testMdmServiceMaster.getOrganizationCode()).isEqualTo(DEFAULT_ORGANIZATION_CODE);
        assertThat(testMdmServiceMaster.getOrganizationName()).isEqualTo(DEFAULT_ORGANIZATION_NAME);
        assertThat(testMdmServiceMaster.getServiceShortName()).isEqualTo(DEFAULT_SERVICE_SHORT_NAME);
        assertThat(testMdmServiceMaster.getServiceName()).isEqualTo(DEFAULT_SERVICE_NAME);
        assertThat(testMdmServiceMaster.getServiceDesc()).isEqualTo(DEFAULT_SERVICE_DESC);
        assertThat(testMdmServiceMaster.getParentServiceCode()).isEqualTo(DEFAULT_PARENT_SERVICE_CODE);
        assertThat(testMdmServiceMaster.getServicePeriodStartDate()).isEqualTo(DEFAULT_SERVICE_PERIOD_START_DATE);
        assertThat(testMdmServiceMaster.getServicePeriodEndDate()).isEqualTo(DEFAULT_SERVICE_PERIOD_END_DATE);
        assertThat(testMdmServiceMaster.getServiceCategory()).isEqualTo(DEFAULT_SERVICE_CATEGORY);
        assertThat(testMdmServiceMaster.getServiceLink()).isEqualTo(DEFAULT_SERVICE_LINK);
        assertThat(testMdmServiceMaster.getServiceClass()).isEqualTo(DEFAULT_SERVICE_CLASS);
        assertThat(testMdmServiceMaster.getServiceIntegrationType()).isEqualTo(DEFAULT_SERVICE_INTEGRATION_TYPE);
        assertThat(testMdmServiceMaster.getServiceType()).isEqualTo(DEFAULT_SERVICE_TYPE);
        assertThat(testMdmServiceMaster.getLookupRoleId()).isEqualTo(DEFAULT_LOOKUP_ROLE_ID);
        assertThat(testMdmServiceMaster.getLookupRole()).isEqualTo(DEFAULT_LOOKUP_ROLE);
        assertThat(testMdmServiceMaster.getLookupSectorId()).isEqualTo(DEFAULT_LOOKUP_SECTOR_ID);
        assertThat(testMdmServiceMaster.getLookupSector()).isEqualTo(DEFAULT_LOOKUP_SECTOR);
        assertThat(testMdmServiceMaster.getLookupLifeeventId()).isEqualTo(DEFAULT_LOOKUP_LIFEEVENT_ID);
        assertThat(testMdmServiceMaster.getLookupLifeevent()).isEqualTo(DEFAULT_LOOKUP_LIFEEVENT);
        assertThat(testMdmServiceMaster.getSlaGoal()).isEqualTo(DEFAULT_SLA_GOAL);
        assertThat(testMdmServiceMaster.getServiceActiveFlag()).isEqualTo(DEFAULT_SERVICE_ACTIVE_FLAG);
        assertThat(testMdmServiceMaster.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testMdmServiceMaster.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testMdmServiceMaster.getRecordInsertTime()).isEqualTo(DEFAULT_RECORD_INSERT_TIME);
        assertThat(testMdmServiceMaster.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testMdmServiceMaster.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
        assertThat(testMdmServiceMaster.getSectionDisplayName()).isEqualTo(DEFAULT_SECTION_DISPLAY_NAME);
        assertThat(testMdmServiceMaster.getSectionDisplayIcon()).isEqualTo(DEFAULT_SECTION_DISPLAY_ICON);
        assertThat(testMdmServiceMaster.getRulesetName()).isEqualTo(DEFAULT_RULESET_NAME);
        assertThat(testMdmServiceMaster.getServicePriority()).isEqualTo(DEFAULT_SERVICE_PRIORITY);
        assertThat(testMdmServiceMaster.getServiceChannelAccess()).isEqualTo(DEFAULT_SERVICE_CHANNEL_ACCESS);
        assertThat(testMdmServiceMaster.getServiceAccess()).isEqualTo(DEFAULT_SERVICE_ACCESS);
        assertThat(testMdmServiceMaster.getAssistedmodeekycReq()).isEqualTo(DEFAULT_ASSISTEDMODEEKYC_REQ);
        assertThat(testMdmServiceMaster.getAssistedOthAdrReq()).isEqualTo(DEFAULT_ASSISTED_OTH_ADR_REQ);
        assertThat(testMdmServiceMaster.getSlaDeadline()).isEqualTo(DEFAULT_SLA_DEADLINE);
        assertThat(testMdmServiceMaster.getPaymentChannelId()).isEqualTo(DEFAULT_PAYMENT_CHANNEL_ID);
        assertThat(testMdmServiceMaster.getPaymentReturnClass()).isEqualTo(DEFAULT_PAYMENT_RETURN_CLASS);
        assertThat(testMdmServiceMaster.getPaymentReturnRuleset()).isEqualTo(DEFAULT_PAYMENT_RETURN_RULESET);
        assertThat(testMdmServiceMaster.getPaymentReturnurl()).isEqualTo(DEFAULT_PAYMENT_RETURNURL);
        assertThat(testMdmServiceMaster.getHelpLink()).isEqualTo(DEFAULT_HELP_LINK);
        assertThat(testMdmServiceMaster.getIntermediateScreen()).isEqualTo(DEFAULT_INTERMEDIATE_SCREEN);
        assertThat(testMdmServiceMaster.getAadhaarRequired()).isEqualTo(DEFAULT_AADHAAR_REQUIRED);
        assertThat(testMdmServiceMaster.getMeesevaServiceId()).isEqualTo(DEFAULT_MEESEVA_SERVICE_ID);
        assertThat(testMdmServiceMaster.getMeesevaServiceName()).isEqualTo(DEFAULT_MEESEVA_SERVICE_NAME);
        assertThat(testMdmServiceMaster.getPmtFeeAmtTotal()).isEqualTo(DEFAULT_PMT_FEE_AMT_TOTAL);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers1()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_1);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers1Desc()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_1_DESC);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers2()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_2);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers2Desc()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_2_DESC);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers3()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_3);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers3Desc()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_3_DESC);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers4()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_4);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers4Desc()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_4_DESC);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers5()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_5);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers5Desc()).isEqualTo(DEFAULT_PMT_FEE_AMT_OTHERS_5_DESC);
    }

    @Test
    @Transactional
    public void createMdmServiceMasterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdmServiceMasterRepository.findAll().size();

        // Create the MdmServiceMaster with an existing ID
        mdmServiceMaster.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdmServiceMasterMockMvc.perform(post("/api/mdm-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmServiceMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmServiceMaster in the database
        List<MdmServiceMaster> mdmServiceMasterList = mdmServiceMasterRepository.findAll();
        assertThat(mdmServiceMasterList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkServiceCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmServiceMasterRepository.findAll().size();
        // set the field null
        mdmServiceMaster.setServiceCode(null);

        // Create the MdmServiceMaster, which fails.

        restMdmServiceMasterMockMvc.perform(post("/api/mdm-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmServiceMaster)))
            .andExpect(status().isBadRequest());

        List<MdmServiceMaster> mdmServiceMasterList = mdmServiceMasterRepository.findAll();
        assertThat(mdmServiceMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOrganizationCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmServiceMasterRepository.findAll().size();
        // set the field null
        mdmServiceMaster.setOrganizationCode(null);

        // Create the MdmServiceMaster, which fails.

        restMdmServiceMasterMockMvc.perform(post("/api/mdm-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmServiceMaster)))
            .andExpect(status().isBadRequest());

        List<MdmServiceMaster> mdmServiceMasterList = mdmServiceMasterRepository.findAll();
        assertThat(mdmServiceMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkServiceActiveFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = mdmServiceMasterRepository.findAll().size();
        // set the field null
        mdmServiceMaster.setServiceActiveFlag(null);

        // Create the MdmServiceMaster, which fails.

        restMdmServiceMasterMockMvc.perform(post("/api/mdm-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmServiceMaster)))
            .andExpect(status().isBadRequest());

        List<MdmServiceMaster> mdmServiceMasterList = mdmServiceMasterRepository.findAll();
        assertThat(mdmServiceMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMdmServiceMasters() throws Exception {
        // Initialize the database
        mdmServiceMasterRepository.saveAndFlush(mdmServiceMaster);

        // Get all the mdmServiceMasterList
        restMdmServiceMasterMockMvc.perform(get("/api/mdm-service-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdmServiceMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].serviceCode").value(hasItem(DEFAULT_SERVICE_CODE)))
            .andExpect(jsonPath("$.[*].organizationCode").value(hasItem(DEFAULT_ORGANIZATION_CODE)))
            .andExpect(jsonPath("$.[*].organizationName").value(hasItem(DEFAULT_ORGANIZATION_NAME)))
            .andExpect(jsonPath("$.[*].serviceShortName").value(hasItem(DEFAULT_SERVICE_SHORT_NAME)))
            .andExpect(jsonPath("$.[*].serviceName").value(hasItem(DEFAULT_SERVICE_NAME)))
            .andExpect(jsonPath("$.[*].serviceDesc").value(hasItem(DEFAULT_SERVICE_DESC)))
            .andExpect(jsonPath("$.[*].parentServiceCode").value(hasItem(DEFAULT_PARENT_SERVICE_CODE)))
            .andExpect(jsonPath("$.[*].servicePeriodStartDate").value(hasItem(DEFAULT_SERVICE_PERIOD_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].servicePeriodEndDate").value(hasItem(DEFAULT_SERVICE_PERIOD_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].serviceCategory").value(hasItem(DEFAULT_SERVICE_CATEGORY)))
            .andExpect(jsonPath("$.[*].serviceLink").value(hasItem(DEFAULT_SERVICE_LINK)))
            .andExpect(jsonPath("$.[*].serviceClass").value(hasItem(DEFAULT_SERVICE_CLASS)))
            .andExpect(jsonPath("$.[*].serviceIntegrationType").value(hasItem(DEFAULT_SERVICE_INTEGRATION_TYPE)))
            .andExpect(jsonPath("$.[*].serviceType").value(hasItem(DEFAULT_SERVICE_TYPE)))
            .andExpect(jsonPath("$.[*].lookupRoleId").value(hasItem(DEFAULT_LOOKUP_ROLE_ID)))
            .andExpect(jsonPath("$.[*].lookupRole").value(hasItem(DEFAULT_LOOKUP_ROLE)))
            .andExpect(jsonPath("$.[*].lookupSectorId").value(hasItem(DEFAULT_LOOKUP_SECTOR_ID)))
            .andExpect(jsonPath("$.[*].lookupSector").value(hasItem(DEFAULT_LOOKUP_SECTOR)))
            .andExpect(jsonPath("$.[*].lookupLifeeventId").value(hasItem(DEFAULT_LOOKUP_LIFEEVENT_ID)))
            .andExpect(jsonPath("$.[*].lookupLifeevent").value(hasItem(DEFAULT_LOOKUP_LIFEEVENT)))
            .andExpect(jsonPath("$.[*].slaGoal").value(hasItem(DEFAULT_SLA_GOAL)))
            .andExpect(jsonPath("$.[*].serviceActiveFlag").value(hasItem(DEFAULT_SERVICE_ACTIVE_FLAG)))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].recordInsertTime").value(hasItem(DEFAULT_RECORD_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].sectionDisplayName").value(hasItem(DEFAULT_SECTION_DISPLAY_NAME)))
            .andExpect(jsonPath("$.[*].sectionDisplayIcon").value(hasItem(DEFAULT_SECTION_DISPLAY_ICON)))
            .andExpect(jsonPath("$.[*].rulesetName").value(hasItem(DEFAULT_RULESET_NAME)))
            .andExpect(jsonPath("$.[*].servicePriority").value(hasItem(DEFAULT_SERVICE_PRIORITY)))
            .andExpect(jsonPath("$.[*].serviceChannelAccess").value(hasItem(DEFAULT_SERVICE_CHANNEL_ACCESS)))
            .andExpect(jsonPath("$.[*].serviceAccess").value(hasItem(DEFAULT_SERVICE_ACCESS)))
            .andExpect(jsonPath("$.[*].assistedmodeekycReq").value(hasItem(DEFAULT_ASSISTEDMODEEKYC_REQ)))
            .andExpect(jsonPath("$.[*].assistedOthAdrReq").value(hasItem(DEFAULT_ASSISTED_OTH_ADR_REQ)))
            .andExpect(jsonPath("$.[*].slaDeadline").value(hasItem(DEFAULT_SLA_DEADLINE)))
            .andExpect(jsonPath("$.[*].paymentChannelId").value(hasItem(DEFAULT_PAYMENT_CHANNEL_ID.intValue())))
            .andExpect(jsonPath("$.[*].paymentReturnClass").value(hasItem(DEFAULT_PAYMENT_RETURN_CLASS)))
            .andExpect(jsonPath("$.[*].paymentReturnRuleset").value(hasItem(DEFAULT_PAYMENT_RETURN_RULESET)))
            .andExpect(jsonPath("$.[*].paymentReturnurl").value(hasItem(DEFAULT_PAYMENT_RETURNURL)))
            .andExpect(jsonPath("$.[*].helpLink").value(hasItem(DEFAULT_HELP_LINK)))
            .andExpect(jsonPath("$.[*].intermediateScreen").value(hasItem(DEFAULT_INTERMEDIATE_SCREEN)))
            .andExpect(jsonPath("$.[*].aadhaarRequired").value(hasItem(DEFAULT_AADHAAR_REQUIRED)))
            .andExpect(jsonPath("$.[*].meesevaServiceId").value(hasItem(DEFAULT_MEESEVA_SERVICE_ID)))
            .andExpect(jsonPath("$.[*].meesevaServiceName").value(hasItem(DEFAULT_MEESEVA_SERVICE_NAME)))
            .andExpect(jsonPath("$.[*].pmtFeeAmtTotal").value(hasItem(DEFAULT_PMT_FEE_AMT_TOTAL.doubleValue())))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers1").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_1.doubleValue())))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers1Desc").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_1_DESC)))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers2").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_2.doubleValue())))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers2Desc").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_2_DESC)))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers3").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_3.doubleValue())))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers3Desc").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_3_DESC)))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers4").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_4.doubleValue())))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers4Desc").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_4_DESC)))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers5").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_5.doubleValue())))
            .andExpect(jsonPath("$.[*].pmtFeeAmtOthers5Desc").value(hasItem(DEFAULT_PMT_FEE_AMT_OTHERS_5_DESC)));
    }
    
    @Test
    @Transactional
    public void getMdmServiceMaster() throws Exception {
        // Initialize the database
        mdmServiceMasterRepository.saveAndFlush(mdmServiceMaster);

        // Get the mdmServiceMaster
        restMdmServiceMasterMockMvc.perform(get("/api/mdm-service-masters/{id}", mdmServiceMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mdmServiceMaster.getId().intValue()))
            .andExpect(jsonPath("$.serviceCode").value(DEFAULT_SERVICE_CODE))
            .andExpect(jsonPath("$.organizationCode").value(DEFAULT_ORGANIZATION_CODE))
            .andExpect(jsonPath("$.organizationName").value(DEFAULT_ORGANIZATION_NAME))
            .andExpect(jsonPath("$.serviceShortName").value(DEFAULT_SERVICE_SHORT_NAME))
            .andExpect(jsonPath("$.serviceName").value(DEFAULT_SERVICE_NAME))
            .andExpect(jsonPath("$.serviceDesc").value(DEFAULT_SERVICE_DESC))
            .andExpect(jsonPath("$.parentServiceCode").value(DEFAULT_PARENT_SERVICE_CODE))
            .andExpect(jsonPath("$.servicePeriodStartDate").value(DEFAULT_SERVICE_PERIOD_START_DATE.toString()))
            .andExpect(jsonPath("$.servicePeriodEndDate").value(DEFAULT_SERVICE_PERIOD_END_DATE.toString()))
            .andExpect(jsonPath("$.serviceCategory").value(DEFAULT_SERVICE_CATEGORY))
            .andExpect(jsonPath("$.serviceLink").value(DEFAULT_SERVICE_LINK))
            .andExpect(jsonPath("$.serviceClass").value(DEFAULT_SERVICE_CLASS))
            .andExpect(jsonPath("$.serviceIntegrationType").value(DEFAULT_SERVICE_INTEGRATION_TYPE))
            .andExpect(jsonPath("$.serviceType").value(DEFAULT_SERVICE_TYPE))
            .andExpect(jsonPath("$.lookupRoleId").value(DEFAULT_LOOKUP_ROLE_ID))
            .andExpect(jsonPath("$.lookupRole").value(DEFAULT_LOOKUP_ROLE))
            .andExpect(jsonPath("$.lookupSectorId").value(DEFAULT_LOOKUP_SECTOR_ID))
            .andExpect(jsonPath("$.lookupSector").value(DEFAULT_LOOKUP_SECTOR))
            .andExpect(jsonPath("$.lookupLifeeventId").value(DEFAULT_LOOKUP_LIFEEVENT_ID))
            .andExpect(jsonPath("$.lookupLifeevent").value(DEFAULT_LOOKUP_LIFEEVENT))
            .andExpect(jsonPath("$.slaGoal").value(DEFAULT_SLA_GOAL))
            .andExpect(jsonPath("$.serviceActiveFlag").value(DEFAULT_SERVICE_ACTIVE_FLAG))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.recordInsertTime").value(DEFAULT_RECORD_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()))
            .andExpect(jsonPath("$.sectionDisplayName").value(DEFAULT_SECTION_DISPLAY_NAME))
            .andExpect(jsonPath("$.sectionDisplayIcon").value(DEFAULT_SECTION_DISPLAY_ICON))
            .andExpect(jsonPath("$.rulesetName").value(DEFAULT_RULESET_NAME))
            .andExpect(jsonPath("$.servicePriority").value(DEFAULT_SERVICE_PRIORITY))
            .andExpect(jsonPath("$.serviceChannelAccess").value(DEFAULT_SERVICE_CHANNEL_ACCESS))
            .andExpect(jsonPath("$.serviceAccess").value(DEFAULT_SERVICE_ACCESS))
            .andExpect(jsonPath("$.assistedmodeekycReq").value(DEFAULT_ASSISTEDMODEEKYC_REQ))
            .andExpect(jsonPath("$.assistedOthAdrReq").value(DEFAULT_ASSISTED_OTH_ADR_REQ))
            .andExpect(jsonPath("$.slaDeadline").value(DEFAULT_SLA_DEADLINE))
            .andExpect(jsonPath("$.paymentChannelId").value(DEFAULT_PAYMENT_CHANNEL_ID.intValue()))
            .andExpect(jsonPath("$.paymentReturnClass").value(DEFAULT_PAYMENT_RETURN_CLASS))
            .andExpect(jsonPath("$.paymentReturnRuleset").value(DEFAULT_PAYMENT_RETURN_RULESET))
            .andExpect(jsonPath("$.paymentReturnurl").value(DEFAULT_PAYMENT_RETURNURL))
            .andExpect(jsonPath("$.helpLink").value(DEFAULT_HELP_LINK))
            .andExpect(jsonPath("$.intermediateScreen").value(DEFAULT_INTERMEDIATE_SCREEN))
            .andExpect(jsonPath("$.aadhaarRequired").value(DEFAULT_AADHAAR_REQUIRED))
            .andExpect(jsonPath("$.meesevaServiceId").value(DEFAULT_MEESEVA_SERVICE_ID))
            .andExpect(jsonPath("$.meesevaServiceName").value(DEFAULT_MEESEVA_SERVICE_NAME))
            .andExpect(jsonPath("$.pmtFeeAmtTotal").value(DEFAULT_PMT_FEE_AMT_TOTAL.doubleValue()))
            .andExpect(jsonPath("$.pmtFeeAmtOthers1").value(DEFAULT_PMT_FEE_AMT_OTHERS_1.doubleValue()))
            .andExpect(jsonPath("$.pmtFeeAmtOthers1Desc").value(DEFAULT_PMT_FEE_AMT_OTHERS_1_DESC))
            .andExpect(jsonPath("$.pmtFeeAmtOthers2").value(DEFAULT_PMT_FEE_AMT_OTHERS_2.doubleValue()))
            .andExpect(jsonPath("$.pmtFeeAmtOthers2Desc").value(DEFAULT_PMT_FEE_AMT_OTHERS_2_DESC))
            .andExpect(jsonPath("$.pmtFeeAmtOthers3").value(DEFAULT_PMT_FEE_AMT_OTHERS_3.doubleValue()))
            .andExpect(jsonPath("$.pmtFeeAmtOthers3Desc").value(DEFAULT_PMT_FEE_AMT_OTHERS_3_DESC))
            .andExpect(jsonPath("$.pmtFeeAmtOthers4").value(DEFAULT_PMT_FEE_AMT_OTHERS_4.doubleValue()))
            .andExpect(jsonPath("$.pmtFeeAmtOthers4Desc").value(DEFAULT_PMT_FEE_AMT_OTHERS_4_DESC))
            .andExpect(jsonPath("$.pmtFeeAmtOthers5").value(DEFAULT_PMT_FEE_AMT_OTHERS_5.doubleValue()))
            .andExpect(jsonPath("$.pmtFeeAmtOthers5Desc").value(DEFAULT_PMT_FEE_AMT_OTHERS_5_DESC));
    }

    @Test
    @Transactional
    public void getNonExistingMdmServiceMaster() throws Exception {
        // Get the mdmServiceMaster
        restMdmServiceMasterMockMvc.perform(get("/api/mdm-service-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdmServiceMaster() throws Exception {
        // Initialize the database
        mdmServiceMasterRepository.saveAndFlush(mdmServiceMaster);

        int databaseSizeBeforeUpdate = mdmServiceMasterRepository.findAll().size();

        // Update the mdmServiceMaster
        MdmServiceMaster updatedMdmServiceMaster = mdmServiceMasterRepository.findById(mdmServiceMaster.getId()).get();
        // Disconnect from session so that the updates on updatedMdmServiceMaster are not directly saved in db
        em.detach(updatedMdmServiceMaster);
        updatedMdmServiceMaster
            .serviceCode(UPDATED_SERVICE_CODE)
            .organizationCode(UPDATED_ORGANIZATION_CODE)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .serviceShortName(UPDATED_SERVICE_SHORT_NAME)
            .serviceName(UPDATED_SERVICE_NAME)
            .serviceDesc(UPDATED_SERVICE_DESC)
            .parentServiceCode(UPDATED_PARENT_SERVICE_CODE)
            .servicePeriodStartDate(UPDATED_SERVICE_PERIOD_START_DATE)
            .servicePeriodEndDate(UPDATED_SERVICE_PERIOD_END_DATE)
            .serviceCategory(UPDATED_SERVICE_CATEGORY)
            .serviceLink(UPDATED_SERVICE_LINK)
            .serviceClass(UPDATED_SERVICE_CLASS)
            .serviceIntegrationType(UPDATED_SERVICE_INTEGRATION_TYPE)
            .serviceType(UPDATED_SERVICE_TYPE)
            .lookupRoleId(UPDATED_LOOKUP_ROLE_ID)
            .lookupRole(UPDATED_LOOKUP_ROLE)
            .lookupSectorId(UPDATED_LOOKUP_SECTOR_ID)
            .lookupSector(UPDATED_LOOKUP_SECTOR)
            .lookupLifeeventId(UPDATED_LOOKUP_LIFEEVENT_ID)
            .lookupLifeevent(UPDATED_LOOKUP_LIFEEVENT)
            .slaGoal(UPDATED_SLA_GOAL)
            .serviceActiveFlag(UPDATED_SERVICE_ACTIVE_FLAG)
            .createdBy(UPDATED_CREATED_BY)
            .updatedBy(UPDATED_UPDATED_BY)
            .recordInsertTime(UPDATED_RECORD_INSERT_TIME)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME)
            .sectionDisplayName(UPDATED_SECTION_DISPLAY_NAME)
            .sectionDisplayIcon(UPDATED_SECTION_DISPLAY_ICON)
            .rulesetName(UPDATED_RULESET_NAME)
            .servicePriority(UPDATED_SERVICE_PRIORITY)
            .serviceChannelAccess(UPDATED_SERVICE_CHANNEL_ACCESS)
            .serviceAccess(UPDATED_SERVICE_ACCESS)
            .assistedmodeekycReq(UPDATED_ASSISTEDMODEEKYC_REQ)
            .assistedOthAdrReq(UPDATED_ASSISTED_OTH_ADR_REQ)
            .slaDeadline(UPDATED_SLA_DEADLINE)
            .paymentChannelId(UPDATED_PAYMENT_CHANNEL_ID)
            .paymentReturnClass(UPDATED_PAYMENT_RETURN_CLASS)
            .paymentReturnRuleset(UPDATED_PAYMENT_RETURN_RULESET)
            .paymentReturnurl(UPDATED_PAYMENT_RETURNURL)
            .helpLink(UPDATED_HELP_LINK)
            .intermediateScreen(UPDATED_INTERMEDIATE_SCREEN)
            .aadhaarRequired(UPDATED_AADHAAR_REQUIRED)
            .meesevaServiceId(UPDATED_MEESEVA_SERVICE_ID)
            .meesevaServiceName(UPDATED_MEESEVA_SERVICE_NAME)
            .pmtFeeAmtTotal(UPDATED_PMT_FEE_AMT_TOTAL)
            .pmtFeeAmtOthers1(UPDATED_PMT_FEE_AMT_OTHERS_1)
            .pmtFeeAmtOthers1Desc(UPDATED_PMT_FEE_AMT_OTHERS_1_DESC)
            .pmtFeeAmtOthers2(UPDATED_PMT_FEE_AMT_OTHERS_2)
            .pmtFeeAmtOthers2Desc(UPDATED_PMT_FEE_AMT_OTHERS_2_DESC)
            .pmtFeeAmtOthers3(UPDATED_PMT_FEE_AMT_OTHERS_3)
            .pmtFeeAmtOthers3Desc(UPDATED_PMT_FEE_AMT_OTHERS_3_DESC)
            .pmtFeeAmtOthers4(UPDATED_PMT_FEE_AMT_OTHERS_4)
            .pmtFeeAmtOthers4Desc(UPDATED_PMT_FEE_AMT_OTHERS_4_DESC)
            .pmtFeeAmtOthers5(UPDATED_PMT_FEE_AMT_OTHERS_5)
            .pmtFeeAmtOthers5Desc(UPDATED_PMT_FEE_AMT_OTHERS_5_DESC);

        restMdmServiceMasterMockMvc.perform(put("/api/mdm-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdmServiceMaster)))
            .andExpect(status().isOk());

        // Validate the MdmServiceMaster in the database
        List<MdmServiceMaster> mdmServiceMasterList = mdmServiceMasterRepository.findAll();
        assertThat(mdmServiceMasterList).hasSize(databaseSizeBeforeUpdate);
        MdmServiceMaster testMdmServiceMaster = mdmServiceMasterList.get(mdmServiceMasterList.size() - 1);
        assertThat(testMdmServiceMaster.getServiceCode()).isEqualTo(UPDATED_SERVICE_CODE);
        assertThat(testMdmServiceMaster.getOrganizationCode()).isEqualTo(UPDATED_ORGANIZATION_CODE);
        assertThat(testMdmServiceMaster.getOrganizationName()).isEqualTo(UPDATED_ORGANIZATION_NAME);
        assertThat(testMdmServiceMaster.getServiceShortName()).isEqualTo(UPDATED_SERVICE_SHORT_NAME);
        assertThat(testMdmServiceMaster.getServiceName()).isEqualTo(UPDATED_SERVICE_NAME);
        assertThat(testMdmServiceMaster.getServiceDesc()).isEqualTo(UPDATED_SERVICE_DESC);
        assertThat(testMdmServiceMaster.getParentServiceCode()).isEqualTo(UPDATED_PARENT_SERVICE_CODE);
        assertThat(testMdmServiceMaster.getServicePeriodStartDate()).isEqualTo(UPDATED_SERVICE_PERIOD_START_DATE);
        assertThat(testMdmServiceMaster.getServicePeriodEndDate()).isEqualTo(UPDATED_SERVICE_PERIOD_END_DATE);
        assertThat(testMdmServiceMaster.getServiceCategory()).isEqualTo(UPDATED_SERVICE_CATEGORY);
        assertThat(testMdmServiceMaster.getServiceLink()).isEqualTo(UPDATED_SERVICE_LINK);
        assertThat(testMdmServiceMaster.getServiceClass()).isEqualTo(UPDATED_SERVICE_CLASS);
        assertThat(testMdmServiceMaster.getServiceIntegrationType()).isEqualTo(UPDATED_SERVICE_INTEGRATION_TYPE);
        assertThat(testMdmServiceMaster.getServiceType()).isEqualTo(UPDATED_SERVICE_TYPE);
        assertThat(testMdmServiceMaster.getLookupRoleId()).isEqualTo(UPDATED_LOOKUP_ROLE_ID);
        assertThat(testMdmServiceMaster.getLookupRole()).isEqualTo(UPDATED_LOOKUP_ROLE);
        assertThat(testMdmServiceMaster.getLookupSectorId()).isEqualTo(UPDATED_LOOKUP_SECTOR_ID);
        assertThat(testMdmServiceMaster.getLookupSector()).isEqualTo(UPDATED_LOOKUP_SECTOR);
        assertThat(testMdmServiceMaster.getLookupLifeeventId()).isEqualTo(UPDATED_LOOKUP_LIFEEVENT_ID);
        assertThat(testMdmServiceMaster.getLookupLifeevent()).isEqualTo(UPDATED_LOOKUP_LIFEEVENT);
        assertThat(testMdmServiceMaster.getSlaGoal()).isEqualTo(UPDATED_SLA_GOAL);
        assertThat(testMdmServiceMaster.getServiceActiveFlag()).isEqualTo(UPDATED_SERVICE_ACTIVE_FLAG);
        assertThat(testMdmServiceMaster.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testMdmServiceMaster.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testMdmServiceMaster.getRecordInsertTime()).isEqualTo(UPDATED_RECORD_INSERT_TIME);
        assertThat(testMdmServiceMaster.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testMdmServiceMaster.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
        assertThat(testMdmServiceMaster.getSectionDisplayName()).isEqualTo(UPDATED_SECTION_DISPLAY_NAME);
        assertThat(testMdmServiceMaster.getSectionDisplayIcon()).isEqualTo(UPDATED_SECTION_DISPLAY_ICON);
        assertThat(testMdmServiceMaster.getRulesetName()).isEqualTo(UPDATED_RULESET_NAME);
        assertThat(testMdmServiceMaster.getServicePriority()).isEqualTo(UPDATED_SERVICE_PRIORITY);
        assertThat(testMdmServiceMaster.getServiceChannelAccess()).isEqualTo(UPDATED_SERVICE_CHANNEL_ACCESS);
        assertThat(testMdmServiceMaster.getServiceAccess()).isEqualTo(UPDATED_SERVICE_ACCESS);
        assertThat(testMdmServiceMaster.getAssistedmodeekycReq()).isEqualTo(UPDATED_ASSISTEDMODEEKYC_REQ);
        assertThat(testMdmServiceMaster.getAssistedOthAdrReq()).isEqualTo(UPDATED_ASSISTED_OTH_ADR_REQ);
        assertThat(testMdmServiceMaster.getSlaDeadline()).isEqualTo(UPDATED_SLA_DEADLINE);
        assertThat(testMdmServiceMaster.getPaymentChannelId()).isEqualTo(UPDATED_PAYMENT_CHANNEL_ID);
        assertThat(testMdmServiceMaster.getPaymentReturnClass()).isEqualTo(UPDATED_PAYMENT_RETURN_CLASS);
        assertThat(testMdmServiceMaster.getPaymentReturnRuleset()).isEqualTo(UPDATED_PAYMENT_RETURN_RULESET);
        assertThat(testMdmServiceMaster.getPaymentReturnurl()).isEqualTo(UPDATED_PAYMENT_RETURNURL);
        assertThat(testMdmServiceMaster.getHelpLink()).isEqualTo(UPDATED_HELP_LINK);
        assertThat(testMdmServiceMaster.getIntermediateScreen()).isEqualTo(UPDATED_INTERMEDIATE_SCREEN);
        assertThat(testMdmServiceMaster.getAadhaarRequired()).isEqualTo(UPDATED_AADHAAR_REQUIRED);
        assertThat(testMdmServiceMaster.getMeesevaServiceId()).isEqualTo(UPDATED_MEESEVA_SERVICE_ID);
        assertThat(testMdmServiceMaster.getMeesevaServiceName()).isEqualTo(UPDATED_MEESEVA_SERVICE_NAME);
        assertThat(testMdmServiceMaster.getPmtFeeAmtTotal()).isEqualTo(UPDATED_PMT_FEE_AMT_TOTAL);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers1()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_1);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers1Desc()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_1_DESC);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers2()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_2);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers2Desc()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_2_DESC);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers3()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_3);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers3Desc()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_3_DESC);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers4()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_4);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers4Desc()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_4_DESC);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers5()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_5);
        assertThat(testMdmServiceMaster.getPmtFeeAmtOthers5Desc()).isEqualTo(UPDATED_PMT_FEE_AMT_OTHERS_5_DESC);
    }

    @Test
    @Transactional
    public void updateNonExistingMdmServiceMaster() throws Exception {
        int databaseSizeBeforeUpdate = mdmServiceMasterRepository.findAll().size();

        // Create the MdmServiceMaster

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdmServiceMasterMockMvc.perform(put("/api/mdm-service-masters")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mdmServiceMaster)))
            .andExpect(status().isBadRequest());

        // Validate the MdmServiceMaster in the database
        List<MdmServiceMaster> mdmServiceMasterList = mdmServiceMasterRepository.findAll();
        assertThat(mdmServiceMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdmServiceMaster() throws Exception {
        // Initialize the database
        mdmServiceMasterRepository.saveAndFlush(mdmServiceMaster);

        int databaseSizeBeforeDelete = mdmServiceMasterRepository.findAll().size();

        // Delete the mdmServiceMaster
        restMdmServiceMasterMockMvc.perform(delete("/api/mdm-service-masters/{id}", mdmServiceMaster.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdmServiceMaster> mdmServiceMasterList = mdmServiceMasterRepository.findAll();
        assertThat(mdmServiceMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
