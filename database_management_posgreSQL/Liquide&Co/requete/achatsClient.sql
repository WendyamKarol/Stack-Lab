--les clients et ce qu'ils ont acheté 
SELECT Client.nom, Liquide.nom
FROM Client
INNER JOIN Client_Liquide ON Client.id = Client_Liquide.id_client
INNER JOIN Liquide ON Client_Liquide.id_liquide = Liquide.id;

