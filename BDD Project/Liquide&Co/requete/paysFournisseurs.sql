--Le noms des fournisseurs et dans quel pays ils sont basés
SELECT Fournisseur.nom, Region_geo.nom
FROM Fournisseur
LEFT OUTER JOIN Fournisseur_geo ON Fournisseur.id = Fournisseur_geo.id_fournisseur
LEFT outer JOIN Region_geo ON Fournisseur_geo.id_geo = Region_geo.id;