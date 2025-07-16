CREATE OR REPLACE FUNCTION fact(i integer, g integer)
RETURNS float
AS
$$
    DECLARE
        idl integer;
        tmpFacture float;
    BEGIN
        idl :=0;
        tmpFacture := 0;
        LOOP
            IF EXISTS(SELECT conso FROM Client_liquide WHERE id_client = i AND id_liquide = idl)
                THEN
                    tmpFacture := tmpFacture + (SELECT prixLocal FROM vw_prixLocal_Liquid WHERE id_geo = g AND id_liquide = idl)*1.1;  --1.1 pour on vent 10% plus cger que ce que ça nous coute
                    tmpFacture := tmpFacture - FtotalSubRegionLiquide( g , idl )/(SELECT COUNT(*) FROM Client_liquide JOIN Client ON id=id_Client  WHERE id_liquide=idl AND FisRegionIn(id_geo , g) );
            END IF;
            idl := idl + 1;
        EXIT WHEN NOT EXISTS(SELECT * FROM Liquide WHERE id = idl);
        END LOOP;
        RETURN tmpFacture;
    END;
$$
LANGUAGE plpgsql ;

SELECT id, prenom || ' ' || nom as client, fact(Client.id,Client.id_geo) as Totale_à_payer From Client;

