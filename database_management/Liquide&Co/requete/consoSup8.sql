select nom, prenom from client where id in (select id_client from client_liquide where conso >= 8);
/* trouve les clients dont la consommation de liquide dépasse les 8 unités SI */