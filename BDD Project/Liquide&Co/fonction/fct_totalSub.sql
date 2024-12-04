CREATE OR REPLACE FUNCTION FtotalSub()
RETURNS float
AS
$$
    DECLARE
        tmp float;
        id_ integer;
    BEGIN
        tmp := 0;
        id_ := 0;
        LOOP
            IF EXISTS(SELECT * FROM Sub_valFix WHERE id_ = Sub_valFix.id)
                THEN 
                    tmp := tmp + (SELECT val_const FROM Sub_valFix WHERE id_=Sub_valFix.id);
            ELSE
                IF (SELECT COUNT(*) FROM Client WHERE FisRegionIn(id_geo,(SELECT id_geo FROM Subvention WHERE id_ = id))) >= (SELECT val_lowerCap FROM Sub_valHab WHERE id_ = id)
                THEN
                    tmp := tmp + (SELECT val_const FROM Sub_valHab WHERE id_ = id)*(SELECT MIN(val_upperCap) FROM Sub_valHab WHERE id_ = id UNION SELECT COUNT(*) FROM Client WHERE FisRegionIn(id_geo,(SELECT id_geo FROM Subvention WHERE id_ = id)));
                END IF;
            END IF;
            id_ := id_ + 1;
            EXIT WHEN NOT EXISTS(SELECT * FROM Subvention WHERE id_=Subvention.id);
        END LOOP;
        RETURN tmp;
    END;
$$
LANGUAGE plpgsql ;


CREATE OR REPLACE FUNCTION FtotalSubRegion(g integer)
RETURNS float
AS
$$
    DECLARE
        tmp float;
        id_ integer;
    BEGIN
        tmp := 0;
        id_ := 0;
        LOOP
            IF EXISTS(SELECT * FROM Geo_sub_liquide WHERE id_ = id_sub AND id_region_concerne = g)
                THEN
                    IF EXISTS(SELECT * FROM Sub_valFix WHERE id_ = id)
                        THEN 
                            tmp := tmp + (SELECT val_const FROM Sub_valFix WHERE id_=Sub_valFix.id);
                    ELSE
                        IF (SELECT COUNT(*) FROM Client WHERE FisRegionIn(id_geo,(SELECT id_geo FROM Subvention WHERE id_ = id))) >= (SELECT val_lowerCap FROM Sub_valHab WHERE id_ = id)
                        THEN
                            tmp := tmp + (SELECT val_const FROM Sub_valHab WHERE id_ = id)*(SELECT MIN(val_upperCap) FROM Sub_valHab WHERE id_ = id UNION SELECT COUNT(*) FROM Client WHERE FisRegionIn(id_geo,(SELECT id_geo FROM Subvention WHERE id_ = id)));
                        END IF;
                END IF;
            END IF;
            id_ := id_ + 1;
            EXIT WHEN NOT EXISTS(SELECT * FROM Subvention WHERE id_=Subvention.id);
        END LOOP;
        RETURN tmp;
    END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION FtotalSubRegionLiquide(g integer,l integer )
RETURNS float
AS
$$
    DECLARE
        tmp float;
        id_ integer;
    BEGIN
        tmp := 0;
        id_ := 0;
        LOOP
            IF EXISTS(SELECT * FROM Geo_sub_liquide WHERE id_ = id_sub AND id_region_concerne = g AND id_liquide = l)
            THEN 
                IF EXISTS(SELECT * FROM Sub_valFix WHERE id_ = Sub_valFix.id)
                    THEN 
                        tmp := tmp + (SELECT val_const FROM Sub_valFix WHERE id_=Sub_valFix.id);
                ELSE
                    IF (SELECT COUNT(*) FROM Client WHERE FisRegionIn(id_geo,(SELECT id_geo FROM Subvention WHERE id_ = id))) >= (SELECT val_lowerCap FROM Sub_valHab WHERE id_ = id)
                    THEN
                        tmp := tmp + (SELECT val_const FROM Sub_valHab WHERE id_ = id)*(SELECT MIN(val_upperCap) FROM Sub_valHab WHERE id_ = id UNION SELECT COUNT(*) FROM Client WHERE FisRegionIn(id_geo,(SELECT id_geo FROM Subvention WHERE id_ = id)));
                    END IF;
                END IF;
            END IF;
            id_ := id_ + 1;
            EXIT WHEN NOT EXISTS(SELECT * FROM Subvention WHERE id_=Subvention.id);
        END LOOP;
        RETURN tmp;
    END;
$$
LANGUAGE plpgsql ;
