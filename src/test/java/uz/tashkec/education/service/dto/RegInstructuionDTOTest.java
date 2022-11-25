package uz.tashkec.education.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import uz.tashkec.education.web.rest.TestUtil;

class RegInstructuionDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RegInstructuionDTO.class);
        RegInstructuionDTO regInstructuionDTO1 = new RegInstructuionDTO();
        regInstructuionDTO1.setId(1L);
        RegInstructuionDTO regInstructuionDTO2 = new RegInstructuionDTO();
        assertThat(regInstructuionDTO1).isNotEqualTo(regInstructuionDTO2);
        regInstructuionDTO2.setId(regInstructuionDTO1.getId());
        assertThat(regInstructuionDTO1).isEqualTo(regInstructuionDTO2);
        regInstructuionDTO2.setId(2L);
        assertThat(regInstructuionDTO1).isNotEqualTo(regInstructuionDTO2);
        regInstructuionDTO1.setId(null);
        assertThat(regInstructuionDTO1).isNotEqualTo(regInstructuionDTO2);
    }
}
