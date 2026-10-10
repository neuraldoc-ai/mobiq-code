package de.musterhaus.mobiq.kasse;

import java.time.LocalDate;
import java.util.List;

public class Tagesabschluss {

    private final KassenbelegRepository belege;

    public Tagesabschluss(KassenbelegRepository belege) {
        this.belege = belege;
    }

    public Abschluss erstelle(String filiale, LocalDate tag) {
        List<Kassenbeleg> liste = belege.findeTag(filiale, tag);
        if (liste.isEmpty()) {
            return Abschluss.leer(filiale, tag);
        }
        return Abschluss.aus(filiale, tag, liste.get(0).kassenNr(), liste);
    }
}
