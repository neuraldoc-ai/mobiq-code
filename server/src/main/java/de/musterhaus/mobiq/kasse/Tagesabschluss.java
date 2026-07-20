package de.musterhaus.mobiq.kasse;

import java.time.LocalDate;
import java.util.List;

/** Tagesabschluss je Filiale: liest alle Kassenbelege des Tages. */
public class Tagesabschluss {

    private final KassenbelegRepository belege;

    public Tagesabschluss(KassenbelegRepository belege) {
        this.belege = belege;
    }

    public Abschluss erstelle(String filiale, LocalDate tag) {
        List<Kassenbeleg> liste = belege.findeTag(filiale, tag);
        return Abschluss.aus(filiale, tag, liste.get(0).kassenNr(), liste);
    }
}
