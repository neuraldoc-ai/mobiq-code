import { Auswahl, Field, Zahl, Text } from '@mobiq/ui'
import type { Fahrzeug } from '../api/types'
import { t } from '../i18n'

export function FahrzeugMaske({ fz, onChange }: { fz: Fahrzeug; onChange: (fz: Fahrzeug) => void }) {
  return (
    <form>
      <Field label={t('stamm.fahrzeug.kennzeichen')} required>
        <Text value={fz.kennzeichen} onChange={(kennzeichen) => onChange({ ...fz, kennzeichen })} />
      </Field>
      <Field label={t('stamm.fahrzeug.zuladung')}>
        <Zahl value={fz.zuladungKg} onChange={(zuladungKg) => onChange({ ...fz, zuladungKg })} />
      </Field>
      <Field label={t('stamm.fahrzeug.filiale')} required>
        <Auswahl value={fz.filiale} optionen={fz.filialen} onChange={(filiale) => onChange({ ...fz, filiale })} />
      </Field>
    </form>
  )
}
