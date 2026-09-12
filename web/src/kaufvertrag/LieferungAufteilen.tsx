import { Dialog } from '@mobiq/ui'
import type { Kaufvertrag } from '../api/types'

// TODO Positionen per Drag & Drop, Prüfung Mindestwert
export function LieferungAufteilen({ kv }: { kv: Kaufvertrag }) {
  return <Dialog titel='Lieferung aufteilen'>{kv.kvNr}</Dialog>
}

export function oeffneAufteilen(kv: Kaufvertrag) {
  Dialog.oeffne(<LieferungAufteilen kv={kv} />)
}
