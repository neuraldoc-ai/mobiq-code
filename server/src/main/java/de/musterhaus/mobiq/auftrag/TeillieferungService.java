package de.musterhaus.mobiq.auftrag;

import de.musterhaus.mobiq.param.Parameter;
import java.util.List;

/** Teilt einen Kaufvertrag in Lieferteile auf. */
public class TeillieferungService {

    private final Parameter param;

    public TeillieferungService(Parameter param) {
        this.param = param;
    }

    public List<Lieferteil> aufteilen(Kaufvertrag kv, List<List<KvPosition>> teile) {
        if (!param.getBool("TEILLIEF_ERLAUBT")) {
            throw new FachlicherFehler("Teillieferung ist im Mandanten nicht erlaubt");
        }
        if (kv.finanzkauf()) {
            // Mit der Partnerbank noch nicht geklärt, siehe MOB-4808
            throw new FachlicherFehler("Teillieferung ist bei Finanzkauf nicht möglich");
        }
        if (teile.size() > param.getInt("TEILLIEF_MAX_ANZAHL")) {
            throw new FachlicherFehler("Zu viele Lieferteile");
        }
        return Lieferteile.aus(kv, teile);
    }
}
