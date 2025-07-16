--FRegionEnglobantes
-- Fonction qui retourne la table des regions qui contiennent la region donner en entrée
-- en entré : id_geo INTERGER 
CREATE OR REPLACE FUNCTION FRegionEnglobantes(r integer)
RETURNS table(
    id_geo integer
)
AS
$$
    DECLARE
        tmp integer;
    BEGIN
        tmp := r;
        WHILE EXISTS(SELECT * FROM Geo_geo WHERE tmp=Geo_geo.id_geo)
        LOOP
            tmp := (SELECT id_geo_macro FROM Geo_geo WHERE tmp=Geo_geo.id_geo);
            id_geo :=tmp;
            RETURN NEXT;
        END LOOP;
    END;
$$
LANGUAGE plpgsql ;


