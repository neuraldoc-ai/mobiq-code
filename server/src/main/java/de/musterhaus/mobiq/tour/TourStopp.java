package de.musterhaus.mobiq.tour;

/** Ein Stopp auf einer Tour. */
public record TourStopp(String kvNr, Integer teilNr, boolean montage, double volumenM3) {

    /** Anzeige auf Karte und Lieferschein: KV-Nummer, bei Teillieferung mit T1, T2 … */
    public String bezeichnung() {
        return teilNr == null ? kvNr : kvNr + " T" + teilNr;
    }
}
