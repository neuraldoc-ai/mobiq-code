package de.musterhaus.mobiq.faktura;

import de.musterhaus.mobiq.auftrag.Kaufvertrag;
import de.musterhaus.mobiq.auftrag.KvPosition;
import de.musterhaus.mobiq.auftrag.Lieferteil;
import java.math.BigDecimal;
import java.math.RoundingMode;

/** Verrechnet die Anzahlung eines Kaufvertrags mit Rechnungen. */
public class AnzahlungVerrechnung {

    /** Ohne Teillieferung: die gesamte Anzahlung wird mit der Schlussrechnung verrechnet. */
    public BigDecimal voll(Kaufvertrag kv) {
        return kv.anzahlung();
    }

    /** Teillieferung: Anzahlung anteilig nach Warenwert des Lieferteils. */
    public BigDecimal anteilig(Kaufvertrag kv, Lieferteil teil) {
        BigDecimal anteil = teil.positionen().stream().map(KvPosition::betrag).reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(kv.warenwert(), 6, RoundingMode.HALF_UP);
        return kv.anzahlung().multiply(anteil).setScale(2, RoundingMode.HALF_UP);
    }
}
