package de.musterhaus.mobiq.tour;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TourPruefungTest {

    @Test
    void ueberladeneTourBrauchtBestaetigung() {
        Tour tour = Testdaten.tourMitVolumen(41.5, 38);
        assertThat(new TourPruefung(Testdaten.parameter()).pruefe(tour).brauchtBestaetigung()).isTrue();
    }
}
