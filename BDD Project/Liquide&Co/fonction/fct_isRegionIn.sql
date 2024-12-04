CREATE OR REPLACE FUNCTION FisRegionIn(a integer , b integer)
RETURNS boolean
AS
$$
    DECLARE
        tmp integer;
    BEGIN
        tmp := a;
        WHILE EXISTS(SELECT * FROM Geo_geo WHERE tmp=id_geo)
        LOOP
            tmp := (SELECT id_geo_macro FROM Geo_geo WHERE tmp=id_geo);
            IF tmp=b 
                THEN
                    RETURN true;
            END IF;
        END LOOP;
        RETURN false;
    END;
$$
LANGUAGE plpgsql ;



