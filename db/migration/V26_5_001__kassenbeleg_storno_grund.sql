-- Grund eines Stornos am Kassenbeleg (MOB-4920)
ALTER TABLE kassenbeleg ADD COLUMN storno_grund varchar(80);
