package de.musterhaus.mobiq.auftrag;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Kaufvertrag {

    private final String kvNr;
    private final String kundeNr;
    private final List<KvPosition> positionen = new ArrayList<>();
    private BigDecimal anzahlung = BigDecimal.ZERO;
    private boolean finanzkauf;
    private boolean liefersperre;
    private KvStatus status = KvStatus.ERFASST;

    public Kaufvertrag(String kvNr, String kundeNr) {
        this.kvNr = kvNr;
        this.kundeNr = kundeNr;
    }

    public boolean istLieferbereit() {
        return !liefersperre && positionen.stream().allMatch(KvPosition::imLager);
    }

    public BigDecimal warenwert() {
        return positionen.stream().map(KvPosition::betrag).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String kvNr() { return kvNr; }
    public String kundeNr() { return kundeNr; }
    public List<KvPosition> positionen() { return positionen; }
    public BigDecimal anzahlung() { return anzahlung; }
    public void setAnzahlung(BigDecimal anzahlung) { this.anzahlung = anzahlung; }
    public boolean finanzkauf() { return finanzkauf; }
    public boolean liefersperre() { return liefersperre; }
    public void setLiefersperre(boolean liefersperre) { this.liefersperre = liefersperre; }
    public KvStatus status() { return status; }
    public void setStatus(KvStatus status) { this.status = status; }
}
