package de.musterhaus.mobiq.fibu.export;

import de.musterhaus.mobiq.faktura.Belegart;
import java.math.BigDecimal;

/** Ein Satz in fibu_export. Der Dienst fibu-import liest die Tabelle nachts. */
public record Buchungssatz(
        Belegart belegart,
        String belegnr,
        String kvNr,
        BigDecimal betragBrutto,
        short steuerschluessel) {
}
