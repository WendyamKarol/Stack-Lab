--Les fournisseurs et ce qu'ils vendent. Certains ne vendent rien
SELECT Fournisseur.nom, Liquide.nom
FROM Fournisseur
LEFT OUTER JOIN Fournisseur_Liquide ON Fournisseur.id = Fournisseur_Liquide.id_fournisseur
LEFT outer JOIN Liquide ON Fournisseur_Liquide.id_liquide = Liquide.id;