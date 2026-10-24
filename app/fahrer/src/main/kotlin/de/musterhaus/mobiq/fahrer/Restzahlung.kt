package de.musterhaus.mobiq.fahrer

import java.math.BigDecimal

/** Zeigt dem Fahrer die offene Restzahlung beim Kunden. */
class Restzahlung(private val api: FahrerApi) {

    /** Bar nur bis zu dieser Grenze, darüber nur Karte (Geldwäschegesetz). */
    val barGrenze = BigDecimal("1000.00")

    fun zahlarten(betrag: BigDecimal): List<Zahlart> = if (betrag > barGrenze) listOf(Zahlart.KARTE) else listOf(Zahlart.BAR, Zahlart.KARTE)

    /** Offener Betrag: bei Teillieferung nur für den gelieferten Teil, sonst Warenwert minus Anzahlung. */
    fun offenerBetrag(stopp: Stopp): BigDecimal {
        val kv = api.kaufvertrag(stopp.kvNr)
        val teil = stopp.teilNr ?: return kv.warenwert - kv.anzahlung
        return api.teilrechnung(stopp.kvNr, teil).offen
    }
}
