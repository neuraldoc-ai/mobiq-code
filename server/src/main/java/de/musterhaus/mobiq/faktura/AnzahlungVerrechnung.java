package de.musterhaus.mobiq.faktura;

import de.musterhaus.mobiq.auftrag.Kaufvertrag;
import java.math.BigDecimal;

/** Verrechnet die Anzahlung eines Kaufvertrags mit Rechnungen. */
public class AnzahlungVerrechnung {

    /** Die gesamte Anzahlung wird mit der Schlussrechnung verrechnet. */
    public BigDecimal voll(Kaufvertrag kv) {
        return kv.anzahlung();
    }
}
