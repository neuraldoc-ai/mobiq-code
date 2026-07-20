package de.musterhaus.mobiq.druck;

import java.util.Map;

/** Druckausgabe über FreeMarker-Vorlagen in druck/vorlagen. */
public class LegacyDruck {

    public byte[] drucke(String vorlage, Map<String, Object> daten) {
        return FreemarkerRenderer.render("druck/vorlagen/" + vorlage + ".ftl", daten);
    }
}
