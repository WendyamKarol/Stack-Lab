
CREATE OR REPLACE FUNCTION prixLocal( l integer, r integer)
RETURNS float
AS
$$
    BEGIN
        IF NOT EXISTS ( SELECT prix AS cout FROM Fournisseur_liquide AS Fl JOIN Fournisseur_geo AS Fg ON Fg.id_fournisseur=Fl.id_fournisseur WHERE l= id_liquide AND Fg.id_geo IN (SELECT FRegionEnglobantes(r) )
                        UNION 
                        SELECT MIN(cout_deplacement) AS cout 
                        FROM Liquide_geo 
                        WHERE id_liquide=l AND id_geo__arrive=r AND id_geo__depart IN(  SELECT fg.id_geo 
                                                                                        FROM Fournisseur_liquide AS fl JOIN Fournisseur_geo AS fg ON fl.id_fournisseur=fg.id_fournisseur 
                                                                                        WHERE fl.id_liquide=l))
        THEN
            RETURN 'Infinity';
            --RAISE EXCEPTION 'ERREUR, impossible d acheminer le liquide';
        ELSEIF EXISTS(SELECT prix AS cout FROM Fournisseur_liquide AS Fl JOIN Fournisseur_geo AS Fg ON Fg.id_fournisseur=Fl.id_fournisseur WHERE l= id_liquide AND Fg.id_geo IN (SELECT FRegionEnglobantes(r) ))
            THEN 
                RETURN (SELECT Min(prix) AS cout FROM Fournisseur_liquide AS Fl JOIN Fournisseur_geo AS Fg ON Fg.id_fournisseur=Fl.id_fournisseur WHERE l= id_liquide AND Fg.id_geo IN (SELECT FRegionEnglobantes(r) ));
        ELSE
            RETURN (SELECT MIN(cout_deplacement) AS cout 
                        FROM Liquide_geo 
                        WHERE id_liquide=l AND id_geo__arrive=r AND id_geo__depart IN(  SELECT fg.id_geo 
                                                                                        FROM Fournisseur_liquide AS fl JOIN Fournisseur_geo AS fg ON fl.id_fournisseur=fg.id_fournisseur 
                                                                                        WHERE fl.id_liquide=l));
            --Implementetion basique sans algo de parcour de graphe pour acheminer les liquides
        END IF;
    END;
$$
LANGUAGE plpgsql ;

CREATE OR REPLACE VIEW vw_prixLocal_Liquid AS
    SELECT * FROM (SELECT Liquide.id AS id_liquide, Region_geo.id as id_geo , prixLocal(Liquide.id,Region_geo.id) as prixLocal from Liquide,Region_geo) AS tmp WHERE tmp.prixLocal != 'Infinity';