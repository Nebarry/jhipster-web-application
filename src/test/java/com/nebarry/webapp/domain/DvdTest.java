package com.nebarry.webapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.nebarry.webapp.web.rest.TestUtil;

public class DvdTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Dvd.class);
        Dvd dvd1 = new Dvd();
        dvd1.setId("id1");
        Dvd dvd2 = new Dvd();
        dvd2.setId(dvd1.getId());
        assertThat(dvd1).isEqualTo(dvd2);
        dvd2.setId("id2");
        assertThat(dvd1).isNotEqualTo(dvd2);
        dvd1.setId(null);
        assertThat(dvd1).isNotEqualTo(dvd2);
    }
}
