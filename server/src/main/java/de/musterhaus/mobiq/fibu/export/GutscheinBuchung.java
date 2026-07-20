package de.musterhaus.mobiq.fibu.export;

import de.musterhaus.mobiq.kasse.Gutschein;

/** Buchungen zu Gutscheinen für die Finanzbuchhaltung. */
public class GutscheinBuchung {

    /** Verkauf: Gutscheinwert als Verbindlichkeit. */
    public Buchung verkauf(Gutschein g) {
        return Buchung.verbindlichkeit(Konten.GUTSCHEIN, g.wert());
    }

    /** Einlösung: die Verbindlichkeit wird vollständig aufgelöst. */
    public Buchung einloesung(Gutschein g) {
        return Buchung.aufloesen(Konten.GUTSCHEIN, g.wert());
    }
}
