CREATE TABLE IF NOT EXISTS Liquide(
    id serial,
    ispotable BOOLEAN,
    nom text,
    CONSTRAINT pk_liquid PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Region_geo(
    id serial,
    nom text,
    CONSTRAINT pk_region_geo PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Client(
    id serial,
    nom text,
    prenom text,
    email text,
    id_geo integer,
    CONSTRAINT pk_client PRIMARY KEY (id),
    CONSTRAINT hk_client_geo FOREIGN KEY (id_geo) REFERENCES Region_geo(id)
);

CREATE TABLE IF NOT EXISTS Fournisseur(
    id serial,
    nom text,
    CONSTRAINT pk_fournisseur PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Subvention(
    id serial,
    nom text,
    date_debut DATE,
    date_fin DATE,
    CONSTRAINT pk_subvention PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Pays(
    id integer,
    CONSTRAINT hk_pays FOREIGN KEY (id) REFERENCES Region_geo(id),
    CONSTRAINT pk_pays PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Etatique(
    id integer,
    id_pays_concerne integer,
    CONSTRAINT hk_etatique FOREIGN KEY (id) REFERENCES Subvention(id),
    CONSTRAINT fk_etatique_pays FOREIGN KEY (id_pays_concerne) REFERENCES Pays(id),
    CONSTRAINT pk_etatique PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Region(
    id integer,
    CONSTRAINT hk_region FOREIGN KEY (id) REFERENCES Region_geo(id),
    CONSTRAINT pk_region PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Regionale(
    id integer,
    id_region_concerneee integer,
    CONSTRAINT hk_regionale FOREIGN KEY (id) REFERENCES Subvention(id),
    CONSTRAINT fk_regionale_region FOREIGN KEY (id_region_concerneee) REFERENCES Region(id),
    CONSTRAINT pk_regionale PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Metropole(
    id integer,
    CONSTRAINT hk_metropole FOREIGN KEY (id) REFERENCES Region_geo(id),
    CONSTRAINT pk_metropole PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Metropolitaine(
    id integer,
    id_metropole_concernee integer,
    CONSTRAINT hk_metropolitaine FOREIGN KEY (id) REFERENCES Subvention(id),
    CONSTRAINT fk_metropolitaine_metropole FOREIGN KEY (id_metropole_concernee) REFERENCES Metropole(id),
    CONSTRAINT pk_regional PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Commune(
    id integer,
    CONSTRAINT hk_commune FOREIGN KEY (id) REFERENCES Region_geo(id),
    CONSTRAINT pk_commune PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Communale(
    id integer,
    id_commune_concernee integer,
    CONSTRAINT hk_communale FOREIGN KEY (id) REFERENCES Subvention(id),
    CONSTRAINT fk_communale_commune FOREIGN KEY (id_commune_concernee) REFERENCES Commune(id),
    CONSTRAINT pk_communale PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Sub_valFix(
    id integer,
    val_const float DEFAULT 0 CHECK (val_mult >= 0),
    val_mult float DEFAULT 0 CHECK (val_mult >= 0 and val_mult <= 1),
    CONSTRAINT hk_sub_valFix FOREIGN KEY (id) REFERENCES Subvention(id),
    CONSTRAINT pk_sub_valfix PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Sub_valHab(
    id integer,
    val_const float DEFAULT 0 CHECK (val_mult >= 0),
    val_mult float DEFAULT 0 CHECK (val_mult >= 0 and val_mult <= 1),
    val_upperCap integer NOT NULL CHECK (val_upperCap > 0),
    val_lowerCap integer DEFAULT 0 CHECK (val_lowerCap > 0),
    CONSTRAINT hk_sub_valhab FOREIGN KEY (id) REFERENCES Subvention(id),
    CONSTRAINT pk_sub_valhab PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Eau(
    id integer,
    magnesium float NOT NULL,
    calcium float NOT NULL,
    bicarbonates float NOT NULL,
    sulfate float NOT NULL,
    sodium float NOT NULL,
    nitrate float NOT NULL,
    potassium float NOT NULL,
    silicum float NOT NULL,
    fluor float NOT NULL,
    CONSTRAINT hk_eau FOREIGN KEY (id) REFERENCES Liquide(id),
    CONSTRAINT pk_eau PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Jus(
    id integer,
    composition text,
    CONSTRAINT hk_jus FOREIGN KEY (id) REFERENCES Liquide(id),
    CONSTRAINT pk_jus PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Alcool(
    id integer,
    composition text,
    alcool_value integer,
    CONSTRAINT hk_alcool FOREIGN KEY (id) REFERENCES Liquide(id),
    CONSTRAINT pk_alcool PRIMARY KEY (id)
);

/*      
Debut des tables de liens.
*/

CREATE TABLE IF NOT EXISTS Geo_sub_liquide(
    id_region_concernee integer NOT NULL,
    id_sub integer NOT NULL,
    id_liquide integer NOT NULL,
    CONSTRAINT fk_geo_sub_liquide__l FOREIGN KEY (id_liquide) REFERENCES Liquide(id),
    CONSTRAINT fk_geo_sub_liquide__s FOREIGN KEY (id_sub) REFERENCES Subvention(id),
    CONSTRAINT fk_geo_sub_liquide__r FOREIGN KEY (id_region_concernee) REFERENCES Region_geo(id),
    CONSTRAINT pk_geo_sub_liquide PRIMARY KEY (id_sub)
);

CREATE TABLE IF NOT EXISTS Client_geo(
    id_client integer NOT NULL,
    id_region_concernee integer NOT NULL,
    CONSTRAINT fk_client_geo__c FOREIGN KEY (id_client) REFERENCES Client(id),
    CONSTRAINT fk_client_geo__r FOREIGN KEY (id_region_concernee) REFERENCES Region_geo(id)
);

CREATE TABLE IF NOT EXISTS Geo_geo(
    id_geo integer NOT NULL,
    id_geo_macro integer NOT NULL,
    CONSTRAINT fk_geo_geo__g FOREIGN KEY (id_geo) REFERENCES Region_geo(id),
    CONSTRAINT fk_geo_geo__mg FOREIGN KEY (id_geo_macro) REFERENCES Region_geo(id)
);

CREATE TABLE IF NOT EXISTS Client_liquide(
    id_liquide integer NOT NULL,
    id_client integer NOT NULL,
    conso float CHECK (conso >= 0),
    CONSTRAINT fk_client_liquide__l FOREIGN KEY (id_liquide) REFERENCES Liquide(id),
    CONSTRAINT fk_client_liquide__c FOREIGN KEY (id_client) REFERENCES Client(id)
);

CREATE TABLE IF NOT EXISTS Liquide_geo(
    id_liquide integer NOT NULL,
    id_geo__depart integer NOT NULL,
    id_geo__arrive integer NOT NULL,
    cout_deplacement float CHECK (cout_deplacement >= 0),
    CONSTRAINT fk_liquide_geo__l FOREIGN KEY (id_liquide) REFERENCES Liquide(id),
    CONSTRAINT fk_liquide_geo__g__d FOREIGN KEY (id_geo__depart) REFERENCES Region_geo(id),
    CONSTRAINT fk_liquide_geo__g__a FOREIGN KEY (id_geo__arrive) REFERENCES Region_geo(id)
);

CREATE TABLE IF NOT EXISTS Fournisseur_geo(
    id_fournisseur integer NOT NULL,
    id_geo integer NOT NULL,
    CONSTRAINT fk_fournisseur_geo__f FOREIGN KEY (id_fournisseur) REFERENCES Fournisseur(id),
    CONSTRAINT fk_fournisseur_geo__g FOREIGN KEY (id_geo) REFERENCES Region_geo(id)
);

CREATE TABLE IF NOT EXISTS Fournisseur_liquide(
    id_fournisseur integer NOT NULL,
    id_liquide integer NOT NULL,
    debit_max float NOT NULL CHECK (debit_max >= 0),
    prix float NOT NULL,
    CONSTRAINT fk_fournisseur_liquid__f FOREIGN KEY (id_fournisseur) REFERENCES Fournisseur(id),
    CONSTRAINT fk_fournisseur_liquid__l FOREIGN KEY (id_liquide) REFERENCES Liquide(id)
);