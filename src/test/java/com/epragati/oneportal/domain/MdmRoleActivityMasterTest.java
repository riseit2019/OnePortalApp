package com.epragati.oneportal.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.epragati.oneportal.web.rest.TestUtil;

public class MdmRoleActivityMasterTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdmRoleActivityMaster.class);
        MdmRoleActivityMaster mdmRoleActivityMaster1 = new MdmRoleActivityMaster();
        mdmRoleActivityMaster1.setId(1L);
        MdmRoleActivityMaster mdmRoleActivityMaster2 = new MdmRoleActivityMaster();
        mdmRoleActivityMaster2.setId(mdmRoleActivityMaster1.getId());
        assertThat(mdmRoleActivityMaster1).isEqualTo(mdmRoleActivityMaster2);
        mdmRoleActivityMaster2.setId(2L);
        assertThat(mdmRoleActivityMaster1).isNotEqualTo(mdmRoleActivityMaster2);
        mdmRoleActivityMaster1.setId(null);
        assertThat(mdmRoleActivityMaster1).isNotEqualTo(mdmRoleActivityMaster2);
    }
}
