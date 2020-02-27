package com.epragati.oneportal.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.epragati.oneportal.web.rest.TestUtil;

public class MdmActivityMasterTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdmActivityMaster.class);
        MdmActivityMaster mdmActivityMaster1 = new MdmActivityMaster();
        mdmActivityMaster1.setId(1L);
        MdmActivityMaster mdmActivityMaster2 = new MdmActivityMaster();
        mdmActivityMaster2.setId(mdmActivityMaster1.getId());
        assertThat(mdmActivityMaster1).isEqualTo(mdmActivityMaster2);
        mdmActivityMaster2.setId(2L);
        assertThat(mdmActivityMaster1).isNotEqualTo(mdmActivityMaster2);
        mdmActivityMaster1.setId(null);
        assertThat(mdmActivityMaster1).isNotEqualTo(mdmActivityMaster2);
    }
}
