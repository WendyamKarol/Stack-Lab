
CREATE OR REPLACE FUNCTION subLocal( l integer, r integer)
RETURNS table(  val_const_ float,
                val_const_hab_ float,
                val_mult_ float,
                val_mult_hab_ float,
                val_upperCap_ integer,
                val_lowerCap_ integer)
AS
$$
    DECLARE
        var_r record;
    BEGIN
        FOR var_r IN (SELECT * FROM Geo_sub_liquide where id_region_concernee=r AND id_liquide=l)
        LOOP
            val_const_ := (SELECT val_const FROM Sub_valFix WHERE id = var_r.id_sub);
            val_mult_ := (SELECT val_mult FROM Sub_valFix WHERE id = var_r.id_sub);
            val_const_hab_ := (SELECT val_const FROM Sub_valHab WHERE id = var_r.id_sub);
            val_mult_hab_ := (SELECT val_mult FROM Sub_valHab WHERE id = var_r.id_sub);
            val_upperCap_ := (SELECT val_upperCap FROM Sub_valHab WHERE id = var_r.id_sub);
            val_lowerCap_ := (SELECT val_lowerCap FROM Sub_valHab WHERE id = var_r.id_sub);
            return next;
        END LOOP;
    END;
$$
LANGUAGE plpgsql ;

CREATE OR REPLACE VIEW vw_subLocal_Liquide AS
    SELECT Liquide.id as id_liquide, Region_geo.id as id_geo, val_const_, val_const_hab_, val_mult_, val_mult_hab_, val_upperCap_, val_lowerCap_ from Liquide,Region_geo,subLocal(Liquide.id,Region_geo.id) ORDER BY val_upperCap_,val_lowerCap_ ;