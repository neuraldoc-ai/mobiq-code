package de.musterhaus.mobiq.auftrag;

import java.math.BigDecimal;

/** Position eines Kaufvertrags. */
public record KvPosition(
        String artikelNr,
        String text,
        int menge,
        BigDecimal betrag,
        boolean montage,
        boolean imLager,
        BigDecimal volumenM3) {
}
