package de.musterhaus.mobiq.tour;

import de.musterhaus.mobiq.auftrag.Kaufvertrag;
import de.musterhaus.mobiq.auftrag.KvPosition;
import de.musterhaus.mobiq.auftrag.Lieferteil;
import java.util.List;

/** Baut die Stopps einer Tour aus lieferbereiten Kaufverträgen. */
public class StoppBuilder {

    /** Ein Kaufvertrag ergibt einen Stopp, bei Teillieferung einen Stopp je lieferbereitem Teil. */
    public List<TourStopp> baue(Kaufvertrag kv, List<Lieferteil> teile) {
        if (teile.isEmpty()) {
            boolean montage = kv.positionen().stream().anyMatch(p -> p.montage());
            return List.of(new TourStopp(kv.kvNr(), null, montage, volumen(kv.positionen())));
        }
        return teile.stream()
                .filter(Lieferteil::istLieferbereit)
                // Montage nur für den Teil, der die Montageposition enthält
                .map(t -> new TourStopp(kv.kvNr(), t.teilNr(), t.positionen().stream().anyMatch(p -> p.montage()), volumen(t.positionen())))
                .toList();
    }

    private double volumen(List<KvPosition> positionen) {
        return positionen.stream().mapToDouble(p -> p.volumenM3().doubleValue()).sum();
    }
}
