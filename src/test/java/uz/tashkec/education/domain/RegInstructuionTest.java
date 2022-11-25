package uz.tashkec.education.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import uz.tashkec.education.web.rest.TestUtil;

class RegInstructuionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RegInstructuion.class);
        RegInstructuion regInstructuion1 = new RegInstructuion();
        regInstructuion1.setId(1L);
        RegInstructuion regInstructuion2 = new RegInstructuion();
        regInstructuion2.setId(regInstructuion1.getId());
        assertThat(regInstructuion1).isEqualTo(regInstructuion2);
        regInstructuion2.setId(2L);
        assertThat(regInstructuion1).isNotEqualTo(regInstructuion2);
        regInstructuion1.setId(null);
        assertThat(regInstructuion1).isNotEqualTo(regInstructuion2);
    }
}
