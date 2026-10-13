package de.musterhaus.mobiq.kasse;

import java.math.BigDecimal;

/** Gutscheine an der Kasse. */
public class GutscheinService {

    public Einloesung einloesen(Gutschein g, BigDecimal bonBetrag) {
        if (bonBetrag.compareTo(g.restwert()) < 0) {
            return Einloesung.abgelehnt("Gutschein nur vollständig einlösbar");
        }
        BigDecimal eingeloest = g.restwert();
        g.belasten(eingeloest);
        return Einloesung.voll(eingeloest);
    }
}
