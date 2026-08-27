package de.musterhaus.mobiq.kasse;

import java.math.BigDecimal;

/** Gutscheine an der Kasse. */
public class GutscheinService {

    /**
     * Löst einen Gutschein ganz oder teilweise ein. Ein Restguthaben bleibt auf demselben
     * Gutschein und kann später eingelöst werden.
     */
    public Einloesung einloesen(Gutschein g, BigDecimal bonBetrag) {
        BigDecimal eingeloest = g.restwert().min(bonBetrag);
        g.belasten(eingeloest);
        return Einloesung.teilweise(eingeloest, g.restwert());
    }
}
