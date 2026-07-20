package de.musterhaus.mobiq.tour;

import de.musterhaus.mobiq.auftrag.Kaufvertrag;
import java.util.List;

/** Baut die Stopps einer Tour aus lieferbereiten Kaufverträgen. */
public class StoppBuilder {

    /** Ein Kaufvertrag ergibt genau einen Stopp. */
    public List<TourStopp> baue(Kaufvertrag kv) {
        boolean montage = kv.positionen().stream().anyMatch(p -> p.montage());
        return List.of(new TourStopp(kv.kvNr(), montage, volumen(kv)));
    }

    private double volumen(Kaufvertrag kv) {
        return kv.positionen().stream().mapToDouble(p -> p.volumenM3().doubleValue()).sum();
    }
}
