package com.nebarry.webapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.nebarry.webapp.web.rest.TestUtil;

public class CdTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Cd.class);
        Cd cd1 = new Cd();
        cd1.setId("id1");
        Cd cd2 = new Cd();
        cd2.setId(cd1.getId());
        assertThat(cd1).isEqualTo(cd2);
        cd2.setId("id2");
        assertThat(cd1).isNotEqualTo(cd2);
        cd1.setId(null);
        assertThat(cd1).isNotEqualTo(cd2);
    }
}
