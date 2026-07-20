import { AdressFeld, Auswahl, Checkbox, Field, KwAuswahl } from '@mobiq/ui'
import type { Kaufvertrag } from '../api/types'
import { t } from '../i18n'

export function RegisterLieferung({ kv, onChange }: { kv: Kaufvertrag; onChange: (kv: Kaufvertrag) => void }) {
  return (
    <section aria-label={t('kv.lieferung.titel')}>
      <Field label={t('kv.lieferung.wunschtermin')} required>
        <KwAuswahl value={kv.wunschtermin} onChange={(wunschtermin) => onChange({ ...kv, wunschtermin })} />
      </Field>
      <Field label={t('kv.lieferung.adresse')} required>
        <AdressFeld value={kv.lieferadresse} onChange={(lieferadresse) => onChange({ ...kv, lieferadresse })} />
      </Field>
      <Field label={t('kv.lieferung.etage')}>
        <Auswahl value={kv.etage} optionen={['EG', '1. OG', '2. OG', '3. OG+', 'mit Aufzug']} onChange={(etage) => onChange({ ...kv, etage })} />
      </Field>
      <Checkbox label={t('kv.lieferung.liefersperre')} checked={kv.liefersperre} onChange={(liefersperre) => onChange({ ...kv, liefersperre })} />
      <Checkbox label={t('kv.lieferung.montage')} checked={kv.montage} onChange={(montage) => onChange({ ...kv, montage })} />
    </section>
  )
}
