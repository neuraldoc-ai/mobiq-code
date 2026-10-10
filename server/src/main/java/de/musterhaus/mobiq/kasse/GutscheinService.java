package de.musterhaus.mobiq.kasse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GutscheinService {

    public Einloesung einloesen(Gutschein g, BigDecimal bonBetrag) {
        if (g.gueltigBis().isBefore(LocalDate.now())) {
            return Einloesung.abgelehnt(g.restwert());
        }
        BigDecimal eingeloest = g.restwert().min(bonBetrag);
        g.belasten(eingeloest);
        return Einloesung.teilweise(eingeloest, g.restwert());
    }
}
