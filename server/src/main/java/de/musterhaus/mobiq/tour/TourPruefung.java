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
        double volumen = tour.stopps().stream().mapToDouble(TourStopp::volumenM3).sum();
        if (volumen > tour.fahrzeug().ladevolumenM3()) {
            if (!param.getBool("TOUR_UEBERLADUNG_ERLAUBT")) {
                return PruefErgebnis.fehler("Ladevolumen des Fahrzeugs überschritten");
            }
            return PruefErgebnis.bestaetigen("Ladevolumen überschritten. Trotzdem speichern?");
        }
        return PruefErgebnis.ok();
    }
}
