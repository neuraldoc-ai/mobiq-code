package de.musterhaus.mobiq.kasse;

import java.math.BigDecimal;

/** Gutscheine an der Kasse. */
public class GutscheinService {

    /**
     * Löst einen Gutschein ein. Ein Gutschein wird immer vollständig eingelöst;
     * ist der Bon günstiger, wird der Rest als neuer Gutschein ausgegeben.
     */
    public Einloesung einloesen(Gutschein g, BigDecimal bonBetrag) {
        BigDecimal rest = g.wert().subtract(bonBetrag);
        g.entwerten();
        if (rest.signum() > 0) {
            return Einloesung.mitNeuemGutschein(g.wert(), Gutschein.neu(rest));
        }
        return Einloesung.voll(g.wert());
    }
}
