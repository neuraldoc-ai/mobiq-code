import { Dialog, DragListe, Field, KwAuswahl, Warnung } from '@mobiq/ui'
import { useParameter } from '../api/parameter'
import type { Kaufvertrag, KvPosition } from '../api/types'
import { t } from '../i18n'
import { useAufteilung } from './useAufteilung'

export function LieferungAufteilen({ kv }: { kv: Kaufvertrag }) {
  const param = useParameter()
  const a = useAufteilung(kv, param.TEILLIEF_MAX_ANZAHL)
  return (
    <Dialog titel={t('kv.aufteilen.titel')} speichernErlaubt={a.gueltig} onSpeichern={a.speichern}>
      {a.teile.map((teil) => (
        <fieldset key={teil.nr}>
          <legend>{t('kv.aufteilen.teil')} {teil.nr}</legend>
          <DragListe<KvPosition> items={teil.positionen} gruppe='positionen' onDrop={(p) => a.verschiebe(p, teil.nr)} />
          <Field label={t('kv.aufteilen.warenwert')}>{teil.anteilProzent} %</Field>
          <Field label={t('kv.lieferung.wunschtermin')} required>
            <KwAuswahl value={teil.wunschKw} onChange={(kw) => a.setzeTermin(teil.nr, kw)} />
          </Field>
        </fieldset>
      ))}
      {a.warnung && <Warnung>{a.warnung}</Warnung>}
    </Dialog>
  )
}

export function oeffneAufteilen(kv: Kaufvertrag) {
  if (kv.finanzkauf) return // Teillieferung bei Finanzkauf gesperrt, siehe MOB-4812
  Dialog.oeffne(<LieferungAufteilen kv={kv} />)
}
