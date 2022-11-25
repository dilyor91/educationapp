package uz.tashkec.education.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import uz.tashkec.education.web.rest.TestUtil;

class AddmissionRulesTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AddmissionRules.class);
        AddmissionRules addmissionRules1 = new AddmissionRules();
        addmissionRules1.setId(1L);
        AddmissionRules addmissionRules2 = new AddmissionRules();
        addmissionRules2.setId(addmissionRules1.getId());
        assertThat(addmissionRules1).isEqualTo(addmissionRules2);
        addmissionRules2.setId(2L);
        assertThat(addmissionRules1).isNotEqualTo(addmissionRules2);
        addmissionRules1.setId(null);
        assertThat(addmissionRules1).isNotEqualTo(addmissionRules2);
    }
}
