package com.epragati.oneportal.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.epragati.oneportal.web.rest.TestUtil;

public class MdmRoleMasterTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdmRoleMaster.class);
        MdmRoleMaster mdmRoleMaster1 = new MdmRoleMaster();
        mdmRoleMaster1.setId(1L);
        MdmRoleMaster mdmRoleMaster2 = new MdmRoleMaster();
        mdmRoleMaster2.setId(mdmRoleMaster1.getId());
        assertThat(mdmRoleMaster1).isEqualTo(mdmRoleMaster2);
        mdmRoleMaster2.setId(2L);
        assertThat(mdmRoleMaster1).isNotEqualTo(mdmRoleMaster2);
        mdmRoleMaster1.setId(null);
        assertThat(mdmRoleMaster1).isNotEqualTo(mdmRoleMaster2);
    }
}
