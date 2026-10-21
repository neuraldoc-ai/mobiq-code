package de.musterhaus.mobiq.kasse;

import java.math.BigDecimal;
import java.time.LocalDate;

/** Gutscheine an der Kasse. */
public class GutscheinService {

    /**
     * Löst einen Gutschein ganz oder teilweise ein. Ein Restguthaben bleibt auf demselben
     * Gutschein und kann später eingelöst werden.
     */
    public Einloesung einloesen(Gutschein g, BigDecimal bonBetrag) {
        if (g.gueltigBis().isBefore(LocalDate.now())) {
            return Einloesung.abgelehnt(g.restwert());
        }
        BigDecimal eingeloest = g.restwert().min(bonBetrag);
        g.belasten(eingeloest);
        return Einloesung.teilweise(eingeloest, g.restwert());
    }
}
