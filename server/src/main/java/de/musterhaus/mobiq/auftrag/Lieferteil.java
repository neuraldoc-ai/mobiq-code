package de.musterhaus.mobiq.auftrag;

import java.util.List;

public record Lieferteil(long ltId, String kvNr, int teilNr, String wunschKw, List<KvPosition> positionen) {

    public boolean istLieferbereit() {
        return positionen.stream().allMatch(KvPosition::imLager);
    }
}
