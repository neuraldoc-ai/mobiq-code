import { Karte, Pin } from '@mobiq/karte'
import type { TourStopp } from '../api/types'

export function StoppKarte({ stopps }: { stopps: TourStopp[] }) {
  return (
    <Karte>
      {stopps.map((s, i) => (
        <Pin key={s.kvNr + (s.teilNr ?? '')} nummer={i + 1} titel={s.teilNr ? s.kvNr + ' T' + s.teilNr : s.kvNr} montage={s.montage} />
      ))}
    </Karte>
  )
}
