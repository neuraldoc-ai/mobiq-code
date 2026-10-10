package de.musterhaus.mobiq.auftrag;

import de.musterhaus.mobiq.param.Parameter;
import java.math.BigDecimal;
import java.util.List;

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

            throw new FachlicherFehler("Teillieferung ist bei Finanzkauf nicht möglich");
        }
        if (teile.size() > param.getInt("TEILLIEF_MAX_ANZAHL")) {
            throw new FachlicherFehler("Zu viele Lieferteile");
        }
        BigDecimal min = kv.warenwert().multiply(BigDecimal.valueOf(param.getInt("TEILLIEF_MIN_WARENWERT_PROZ"))).movePointLeft(2);
        for (List<KvPosition> teil : teile) {
            BigDecimal wert = teil.stream().map(KvPosition::betrag).reduce(BigDecimal.ZERO, BigDecimal::add);
            if (wert.compareTo(min) < 0) {
                throw new FachlicherFehler("Ein Lieferteil unterschreitet den Mindestwarenwert");
            }
        }
        return Lieferteile.aus(kv, teile);
    }
}
