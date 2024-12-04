select liquide.nom, liquide.isPotable from liquide where liquide.nom in (select jus.composition from jus);
/* requête vérifiant que tous les jus sont bie potables */