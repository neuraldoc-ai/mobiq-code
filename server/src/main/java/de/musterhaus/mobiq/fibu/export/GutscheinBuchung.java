package de.musterhaus.mobiq.fibu.export;

import de.musterhaus.mobiq.kasse.Gutschein;
import java.math.BigDecimal;

public class GutscheinBuchung {

    public Buchung verkauf(Gutschein g) {
        return Buchung.verbindlichkeit(Konten.GUTSCHEIN, g.wert());
    }

    public Buchung einloesung(Gutschein g, BigDecimal eingeloest) {
        return Buchung.aufloesen(Konten.GUTSCHEIN, eingeloest);
    }
}
