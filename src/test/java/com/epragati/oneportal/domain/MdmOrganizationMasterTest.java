package com.epragati.oneportal.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.epragati.oneportal.web.rest.TestUtil;

public class MdmOrganizationMasterTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdmOrganizationMaster.class);
        MdmOrganizationMaster mdmOrganizationMaster1 = new MdmOrganizationMaster();
        mdmOrganizationMaster1.setId(1L);
        MdmOrganizationMaster mdmOrganizationMaster2 = new MdmOrganizationMaster();
        mdmOrganizationMaster2.setId(mdmOrganizationMaster1.getId());
        assertThat(mdmOrganizationMaster1).isEqualTo(mdmOrganizationMaster2);
        mdmOrganizationMaster2.setId(2L);
        assertThat(mdmOrganizationMaster1).isNotEqualTo(mdmOrganizationMaster2);
        mdmOrganizationMaster1.setId(null);
        assertThat(mdmOrganizationMaster1).isNotEqualTo(mdmOrganizationMaster2);
    }
}
