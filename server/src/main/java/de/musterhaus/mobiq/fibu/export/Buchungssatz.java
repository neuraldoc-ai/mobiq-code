package de.musterhaus.mobiq.fibu.export;

import de.musterhaus.mobiq.faktura.Belegart;
import java.math.BigDecimal;

public record Buchungssatz(
        Belegart belegart,
        String belegnr,
        String kvNr,
        BigDecimal betragBrutto,
        short steuerschluessel,
        Short teillieferungNr,
        BigDecimal azVerrechnet) {
}
