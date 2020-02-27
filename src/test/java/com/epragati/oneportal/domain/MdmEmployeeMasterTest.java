package com.epragati.oneportal.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.epragati.oneportal.web.rest.TestUtil;

public class MdmEmployeeMasterTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdmEmployeeMaster.class);
        MdmEmployeeMaster mdmEmployeeMaster1 = new MdmEmployeeMaster();
        mdmEmployeeMaster1.setId(1L);
        MdmEmployeeMaster mdmEmployeeMaster2 = new MdmEmployeeMaster();
        mdmEmployeeMaster2.setId(mdmEmployeeMaster1.getId());
        assertThat(mdmEmployeeMaster1).isEqualTo(mdmEmployeeMaster2);
        mdmEmployeeMaster2.setId(2L);
        assertThat(mdmEmployeeMaster1).isNotEqualTo(mdmEmployeeMaster2);
        mdmEmployeeMaster1.setId(null);
        assertThat(mdmEmployeeMaster1).isNotEqualTo(mdmEmployeeMaster2);
    }
}
