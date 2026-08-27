import { Betrag, Field, Scanner } from '@mobiq/ui'
import { gutscheinEinloesen } from '../api/kasse'
import { t } from '../i18n'

export function GutscheinZahlung({ bon }: { bon: { id: string; offen: number; restguthaben?: number } }) {
  return (
    <Field label={t('kasse.gutschein')}>
      <Scanner onScan={(code) => gutscheinEinloesen(bon.id, code)} />
      <Betrag value={bon.offen} readOnly />
      <Betrag label={t('kasse.restguthaben')} value={bon.restguthaben} readOnly />
    </Field>
  )
}
