package de.musterhaus.mobiq.faktura;

public enum Belegart {
    RE("Rechnung"),
    GS("Gutschrift"),
    AZ("Anzahlung"),
    TR("Teilrechnung");

    private final String text;

    Belegart(String text) { this.text = text; }

    public String text() { return text; }
}
