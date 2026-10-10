package de.musterhaus.mobiq.kasse;

import java.math.BigDecimal;

public class GutscheinService {

    public Einloesung einloesen(Gutschein g, BigDecimal bonBetrag) {
        BigDecimal eingeloest = g.restwert().min(bonBetrag);
        g.belasten(eingeloest);
        return Einloesung.teilweise(eingeloest, g.restwert());
    }
}
