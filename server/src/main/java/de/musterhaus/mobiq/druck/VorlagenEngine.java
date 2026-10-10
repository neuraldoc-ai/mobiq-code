package de.musterhaus.mobiq.druck;

import java.util.Map;

public class VorlagenEngine {

    private final VorlagenQuelle quelle;

    public VorlagenEngine(VorlagenQuelle quelle) {
        this.quelle = quelle;
    }

    public byte[] drucke(String vorlage, Map<String, Object> daten) {
        return PdfRenderer.render(quelle.lade(vorlage + ".html"), daten);
    }
}
