package de.musterhaus.mobiq.druck;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class VorlagenEngineTest {

    @Test
    void rechnungWirdGedruckt() {
        byte[] pdf = new VorlagenEngine(Testdaten.vorlagen()).drucke("rechnung", Map.of("beleg", Testdaten.rechnung()));
        assertThat(pdf).isNotEmpty();
    }
}
