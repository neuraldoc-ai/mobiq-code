package de.musterhaus.mobiq.kasse;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class GutscheinServiceTest {

    @Test
    void teileinloesungWirdAbgelehnt() {
        Gutschein g = Gutschein.neu(new BigDecimal("100.00"));
        Einloesung e = new GutscheinService().einloesen(g, new BigDecimal("30.00"));
        assertThat(e.abgelehnt()).isTrue();
        assertThat(g.restwert()).isEqualByComparingTo("100.00");
    }

    @Test
    void volleEinloesungLeertDenGutschein() {
        Gutschein g = Gutschein.neu(new BigDecimal("100.00"));
        Einloesung e = new GutscheinService().einloesen(g, new BigDecimal("120.00"));
        assertThat(e.eingeloest()).isEqualByComparingTo("100.00");
        assertThat(g.restwert()).isEqualByComparingTo("0.00");
    }
}
