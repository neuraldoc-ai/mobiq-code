package de.musterhaus.mobiq.fahrer

import java.math.BigDecimal

/** Zeigt dem Fahrer die offene Restzahlung beim Kunden. */
class Restzahlung(private val api: FahrerApi) {

    /** Offener Betrag des Kaufvertrags: Warenwert minus Anzahlung. */
    fun offenerBetrag(stopp: Stopp): BigDecimal {
        val kv = api.kaufvertrag(stopp.kvNr)
        return kv.warenwert - kv.anzahlung
    }
}
