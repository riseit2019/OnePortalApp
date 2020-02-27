package com.epragati.oneportal.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.epragati.oneportal.web.rest.TestUtil;

public class MdmMeesevaServiceMasterTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdmMeesevaServiceMaster.class);
        MdmMeesevaServiceMaster mdmMeesevaServiceMaster1 = new MdmMeesevaServiceMaster();
        mdmMeesevaServiceMaster1.setId(1L);
        MdmMeesevaServiceMaster mdmMeesevaServiceMaster2 = new MdmMeesevaServiceMaster();
        mdmMeesevaServiceMaster2.setId(mdmMeesevaServiceMaster1.getId());
        assertThat(mdmMeesevaServiceMaster1).isEqualTo(mdmMeesevaServiceMaster2);
        mdmMeesevaServiceMaster2.setId(2L);
        assertThat(mdmMeesevaServiceMaster1).isNotEqualTo(mdmMeesevaServiceMaster2);
        mdmMeesevaServiceMaster1.setId(null);
        assertThat(mdmMeesevaServiceMaster1).isNotEqualTo(mdmMeesevaServiceMaster2);
    }
}
