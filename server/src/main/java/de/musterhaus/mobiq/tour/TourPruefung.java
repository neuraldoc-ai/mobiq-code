package de.musterhaus.mobiq.tour;

import de.musterhaus.mobiq.param.Parameter;

/** Prüft eine Tour vor dem Speichern. */
public class TourPruefung {

    private final Parameter param;

    public TourPruefung(Parameter param) {
        this.param = param;
    }

    public PruefErgebnis pruefe(Tour tour) {
        if (tour.stopps().size() > param.getInt("TOUR_MAX_STOPPS")) {
            return PruefErgebnis.fehler("Zu viele Stopps auf der Tour");
        }
        return PruefErgebnis.ok();
    }
}
