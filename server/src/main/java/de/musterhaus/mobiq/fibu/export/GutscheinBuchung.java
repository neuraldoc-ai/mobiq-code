package de.musterhaus.mobiq.fibu.export;

import de.musterhaus.mobiq.kasse.Gutschein;
import java.math.BigDecimal;

/** Buchungen zu Gutscheinen für die Finanzbuchhaltung. */
public class GutscheinBuchung {

    /** Verkauf: Gutscheinwert als Verbindlichkeit. */
    public Buchung verkauf(Gutschein g) {
        return Buchung.verbindlichkeit(Konten.GUTSCHEIN, g.wert());
    }

    /** Einlösung: die Verbindlichkeit wird in Höhe des eingelösten Betrags aufgelöst, der Rest bleibt stehen. */
    public Buchung einloesung(Gutschein g, BigDecimal eingeloest) {
        return Buchung.aufloesen(Konten.GUTSCHEIN, eingeloest);
    }
}
