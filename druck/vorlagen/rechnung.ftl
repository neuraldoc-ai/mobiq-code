<#-- Rechnung -->
<h1>Rechnung ${beleg.nr}</h1>
<p>Kaufvertrag ${kv.nr} vom ${kv.datum}</p>
<#list positionen as p><tr><td>${p.text}</td><td>${p.betrag}</td></tr></#list>
<p>Abzüglich Anzahlung: ${beleg.anzahlungVerrechnet}</p>
