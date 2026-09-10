import type { Tour } from '../api/types'
import { t } from '../i18n'

export function TourKopf({ tour }: { tour: Tour }) {
  const volumen = tour.stopps.reduce((n, s) => n + s.volumenM3, 0)
  return (
    <header className='tour-kopf'>
      <h2>{tour.name}</h2>
      <span className={volumen > tour.fahrzeug.ladevolumenM3 ? 'ueberladen' : undefined}>
        {t('tour.volumen')}: {volumen.toFixed(1)} / {tour.fahrzeug.ladevolumenM3} m³
      </span>
    </header>
  )
}
