package com.epragati.oneportal.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.epragati.oneportal.web.rest.TestUtil;

public class MdmServiceMasterTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdmServiceMaster.class);
        MdmServiceMaster mdmServiceMaster1 = new MdmServiceMaster();
        mdmServiceMaster1.setId(1L);
        MdmServiceMaster mdmServiceMaster2 = new MdmServiceMaster();
        mdmServiceMaster2.setId(mdmServiceMaster1.getId());
        assertThat(mdmServiceMaster1).isEqualTo(mdmServiceMaster2);
        mdmServiceMaster2.setId(2L);
        assertThat(mdmServiceMaster1).isNotEqualTo(mdmServiceMaster2);
        mdmServiceMaster1.setId(null);
        assertThat(mdmServiceMaster1).isNotEqualTo(mdmServiceMaster2);
    }
}
