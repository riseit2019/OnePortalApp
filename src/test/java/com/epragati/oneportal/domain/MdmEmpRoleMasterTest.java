package com.epragati.oneportal.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.epragati.oneportal.web.rest.TestUtil;

public class MdmEmpRoleMasterTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdmEmpRoleMaster.class);
        MdmEmpRoleMaster mdmEmpRoleMaster1 = new MdmEmpRoleMaster();
        mdmEmpRoleMaster1.setId(1L);
        MdmEmpRoleMaster mdmEmpRoleMaster2 = new MdmEmpRoleMaster();
        mdmEmpRoleMaster2.setId(mdmEmpRoleMaster1.getId());
        assertThat(mdmEmpRoleMaster1).isEqualTo(mdmEmpRoleMaster2);
        mdmEmpRoleMaster2.setId(2L);
        assertThat(mdmEmpRoleMaster1).isNotEqualTo(mdmEmpRoleMaster2);
        mdmEmpRoleMaster1.setId(null);
        assertThat(mdmEmpRoleMaster1).isNotEqualTo(mdmEmpRoleMaster2);
    }
}
