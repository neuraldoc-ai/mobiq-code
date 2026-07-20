package de.musterhaus.mobiq.faktura;

import de.musterhaus.mobiq.auftrag.Kaufvertrag;
import de.musterhaus.mobiq.auftrag.KvStatus;

/** Erstellt Rechnungen zum Kaufvertrag. */
public class RechnungService {

    private final AnzahlungVerrechnung verrechnung = new AnzahlungVerrechnung();

    /** Schlussrechnung, sobald der Kaufvertrag vollständig ausgeliefert ist. */
    public Rechnung schlussrechnung(Kaufvertrag kv) {
        if (kv.status() != KvStatus.AUSGELIEFERT) {
            throw new IllegalStateException("Kaufvertrag " + kv.kvNr() + " ist noch nicht vollständig ausgeliefert");
        }
        Rechnung r = Rechnung.neu(Belegart.RE, kv);
        r.setAnzahlungVerrechnet(verrechnung.voll(kv));
        return r;
    }
}
