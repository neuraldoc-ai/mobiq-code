package de.musterhaus.mobiq.admin;

import de.musterhaus.mobiq.druck.VorlagenQuelle;

@AdminJob(name = "Vorlagen konvertieren", bereich = "Administration")
public class VorlagenKonvertieren implements Job {

    private final VorlagenQuelle quelle;

    public VorlagenKonvertieren(VorlagenQuelle quelle) {
        this.quelle = quelle;
    }

    @Override
    public JobErgebnis ausfuehren() {
        int n = 0;
        for (String datei : quelle.kundeneigeneFtl()) {
            quelle.speichere(datei.replace(".ftl", ".html"), FtlNachHtml.konvertiere(quelle.lade(datei)));
            n++;
        }
        return JobErgebnis.ok(n + " Vorlagen konvertiert");
    }
}
