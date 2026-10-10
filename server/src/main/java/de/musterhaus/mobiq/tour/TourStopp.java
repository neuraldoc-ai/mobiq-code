package de.musterhaus.mobiq.tour;

public record TourStopp(String kvNr, Integer teilNr, boolean montage, double volumenM3) {

    public String bezeichnung() {
        return teilNr == null ? kvNr : kvNr + " T" + teilNr;
    }
}
