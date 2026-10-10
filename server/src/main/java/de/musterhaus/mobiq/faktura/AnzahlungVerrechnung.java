package de.musterhaus.mobiq.faktura;

import de.musterhaus.mobiq.auftrag.Kaufvertrag;
import de.musterhaus.mobiq.auftrag.KvPosition;
import de.musterhaus.mobiq.auftrag.Lieferteil;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class AnzahlungVerrechnung {

    public BigDecimal voll(Kaufvertrag kv) {
        return kv.anzahlung();
    }

    public BigDecimal rest(Kaufvertrag kv, BigDecimal bereitsVerrechnet) {
        return kv.anzahlung().subtract(bereitsVerrechnet);
    }

    public BigDecimal anteilig(Kaufvertrag kv, Lieferteil teil) {
        BigDecimal anteil = teil.positionen().stream().map(KvPosition::betrag).reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(kv.warenwert(), 6, RoundingMode.HALF_UP);
        return kv.anzahlung().multiply(anteil).setScale(2, RoundingMode.HALF_UP);
    }
}
