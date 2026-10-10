package de.musterhaus.mobiq.fahrer

import java.math.BigDecimal

class Restzahlung(private val api: FahrerApi) {

    fun offenerBetrag(stopp: Stopp): BigDecimal {
        val kv = api.kaufvertrag(stopp.kvNr)
        val teil = stopp.teilNr ?: return kv.warenwert - kv.anzahlung
        return api.teilrechnung(stopp.kvNr, teil).offen
    }
}
