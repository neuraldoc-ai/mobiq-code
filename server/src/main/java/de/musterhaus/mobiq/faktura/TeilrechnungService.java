package de.musterhaus.mobiq.faktura;

import de.musterhaus.mobiq.auftrag.Kaufvertrag;
import de.musterhaus.mobiq.auftrag.Lieferteil;

/** Erstellt je ausgeliefertem Lieferteil eine Teilrechnung. */
public class TeilrechnungService {

    private final AnzahlungVerrechnung verrechnung = new AnzahlungVerrechnung();

    public Rechnung teilrechnung(Kaufvertrag kv, Lieferteil teil, boolean letzterTeil) {
        Rechnung r = Rechnung.neu(Belegart.TR, kv);
        r.setPositionen(teil.positionen());
        r.setTeilNr(teil.teilNr());
        r.setAnzahlungVerrechnet(letzterTeil
                ? verrechnung.rest(kv, Rechnungen.verrechneteAnzahlung(kv))
                : verrechnung.anteilig(kv, teil));
        return r;
    }
}
