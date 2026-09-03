package de.musterhaus.mobiq.kasse;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class GutscheinServiceTest {

    @Test
    void teileinloesungLaesstRestAufDemGutschein() {
        Gutschein g = Gutschein.neu(new BigDecimal("100.00"));
        Einloesung e = new GutscheinService().einloesen(g, new BigDecimal("30.00"));
        assertThat(e.eingeloest()).isEqualByComparingTo("30.00");
        assertThat(g.restwert()).isEqualByComparingTo("70.00");
    }
}
