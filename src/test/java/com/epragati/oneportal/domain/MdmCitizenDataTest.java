package com.epragati.oneportal.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.epragati.oneportal.web.rest.TestUtil;

public class MdmCitizenDataTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdmCitizenData.class);
        MdmCitizenData mdmCitizenData1 = new MdmCitizenData();
        mdmCitizenData1.setId(1L);
        MdmCitizenData mdmCitizenData2 = new MdmCitizenData();
        mdmCitizenData2.setId(mdmCitizenData1.getId());
        assertThat(mdmCitizenData1).isEqualTo(mdmCitizenData2);
        mdmCitizenData2.setId(2L);
        assertThat(mdmCitizenData1).isNotEqualTo(mdmCitizenData2);
        mdmCitizenData1.setId(null);
        assertThat(mdmCitizenData1).isNotEqualTo(mdmCitizenData2);
    }
}
