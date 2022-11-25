package uz.tashkec.education.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import uz.tashkec.education.web.rest.TestUtil;

class AddmissionRulesDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AddmissionRulesDTO.class);
        AddmissionRulesDTO addmissionRulesDTO1 = new AddmissionRulesDTO();
        addmissionRulesDTO1.setId(1L);
        AddmissionRulesDTO addmissionRulesDTO2 = new AddmissionRulesDTO();
        assertThat(addmissionRulesDTO1).isNotEqualTo(addmissionRulesDTO2);
        addmissionRulesDTO2.setId(addmissionRulesDTO1.getId());
        assertThat(addmissionRulesDTO1).isEqualTo(addmissionRulesDTO2);
        addmissionRulesDTO2.setId(2L);
        assertThat(addmissionRulesDTO1).isNotEqualTo(addmissionRulesDTO2);
        addmissionRulesDTO1.setId(null);
        assertThat(addmissionRulesDTO1).isNotEqualTo(addmissionRulesDTO2);
    }
}
