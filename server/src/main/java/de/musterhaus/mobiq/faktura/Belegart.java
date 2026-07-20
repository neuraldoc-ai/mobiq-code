package de.musterhaus.mobiq.faktura;

/** Belegarten, wie sie an die Finanzbuchhaltung übergeben werden. */
public enum Belegart {
    RE("Rechnung"),
    GS("Gutschrift"),
    AZ("Anzahlung");

    private final String text;

    Belegart(String text) { this.text = text; }

    public String text() { return text; }
}
