INSERT INTO Fournisseur VALUES (1,'Roxane'); /* cristalline */
INSERT INTO Fournisseur VALUES (2,'Tropicana Products, Inc.');  /* jus de fruits tropicana */
INSERT INTO Fournisseur VALUES (3,'Heineken');  /* heineken et desperados */
INSERT INTO Fournisseur VALUES (4,'Danone'); /* fournisseur de evian et jus danone */
INSERT INTO Fournisseur VALUES (5,'Grupo Modelo'); /* biere corona */
INSERT INTO Fournisseur VALUES (6,'PepsiCo, Inc.'); /* pepsi */
INSERT INTO Fournisseur VALUES (7,'La Martiniquaise'); /* poliakov */
INSERT INTO Fournisseur VALUES (8,'Red Bull GmbH'); /* fournisser de redbull */
INSERT INTO Fournisseur VALUES (9,'Brown-Forman Corporation'); /* fournisser de jackdaniels */


INSERT INTO Client VALUES (1,'donatello','gisele','fan_do_du14@gmail.com');
INSERT INTO Client VALUES (2,'Lucifer','Lucius','contract666@hotmail.com');
INSERT INTO Client VALUES (3,'touggard','mona','mtouggard@gmail.com');
INSERT INTO Client VALUES (4,'presley','elvis','vegastars@gmail.com');
INSERT INTO Client VALUES (5,'Jackson','michael','MJMJ@yahoo.com');
INSERT INTO Client VALUES (6,'Cristal','Line','cristalline_egerie@gmail.com');
INSERT INTO Client VALUES (7,'LeGris','Gandalph','mageDeLaCompte@gmail.com');


INSERT INTO Liquide VALUES (1,true,'badoit');
INSERT INTO Liquide VALUES (2,true,'cristalline');
INSERT INTO Liquide VALUES (3,true,'contrex');
INSERT INTO Liquide VALUES (4,true,'vittel');
INSERT INTO Liquide VALUES (5,true,'boisson energisante');
INSERT INTO Liquide VALUES (6,true,'jus orange');
--INSERT INTO Liquid VALUES (7,false,'essence'); pas de fournisseur pour ca 
INSERT INTO Liquide VALUES (8,true,'banane');
INSERT INTO Liquide VALUES (9,true,'kiwi');
INSERT INTO Liquide VALUES (10,true,'ananas');
INSERT INTO Liquide VALUES (11,true,'pomme');
INSERT INTO Liquide VALUES (12,true,'pamplemousse');
INSERT INTO Liquide VALUES (13,true,'danone lait et jus orange');
INSERT INTO Liquide VALUES (14,true,'coco');
--INSERT INTO Liquid VALUES (15,false,'acide');  la non plus
INSERT INTO Liquide VALUES (16,true,'polia');
INSERT INTO Liquide VALUES (17,true,'CaptainMorgan');
INSERT INTO Liquide VALUES (18,true,'Jackdaniel');
INSERT INTO Liquide VALUES (19,true,'Biere Heineken');
INSERT INTO Liquide VALUES (20,true,'Biere Corona');


--pays
INSERT INTO Region_geo VALUES (1,'FRANCE');
INSERT INTO Region_geo VALUES (2,'JAPON');
INSERT INTO Region_geo VALUES (3,'ETATS-UNIS');
INSERT INTO Region_geo VALUES (4,'AMSTERDAM');
INSERT INTO Region_geo VALUES (5,'AUSTRALIE');
INSERT INTO Region_geo VALUES (6,'BRESIL');
INSERT INTO Region_geo VALUES (7,'ALGERIE');
INSERT INTO Region_geo VALUES (8,'CHINE');
INSERT INTO Region_geo VALUES (9,'CANADA');
INSERT INTO Region_geo VALUES (10,'INDE');
INSERT INTO Region_geo VALUES (11,'RUSSIE');
INSERT INTO Region_geo VALUES (12,'AFRIQUE DU SUD');
INSERT INTO Region_geo VALUES (13,'MEXIQUE');
INSERT INTO Region_geo VALUES (14,'NOUVELLE-ZELANDE');
INSERT INTO Region_geo VALUES (15,'ESPAGNE');
INSERT INTO Region_geo VALUES (16,'ARGENTINE');
INSERT INTO Region_geo VALUES (17,'AUTRICHE');
INSERT INTO Region_geo VALUES (18,'MEXIQUE');
INSERT INTO Region_geo VALUES (19,'ALLEMAGNE');
INSERT INTO Region_geo VALUES (20,'ITALIE');
--Region
INSERT INTO Region_geo VALUES (21, 'Ile de France');
INSERT INTO Region_geo VALUES (22, 'Hokkaido');
INSERT INTO Region_geo VALUES (23, 'Californie');
INSERT INTO Region_geo VALUES (24, 'Casablanca-Settat');
INSERT INTO Region_geo VALUES (25, 'Queensland');
INSERT INTO Region_geo VALUES (26, 'Rio de Janeiro');
INSERT INTO Region_geo VALUES (27, 'Tizi Ouzou');
INSERT INTO Region_geo VALUES (28, 'Shandong');
INSERT INTO Region_geo VALUES (29, 'Ontario');
INSERT INTO Region_geo VALUES (30, 'Maharashtra');
INSERT INTO Region_geo VALUES (31, 'Moscou');
INSERT INTO Region_geo VALUES (32, 'KwaZulu-Natal');
INSERT INTO Region_geo VALUES (33, 'Jalisco');
INSERT INTO Region_geo VALUES (34, 'Auckland');
INSERT INTO Region_geo VALUES (35, 'Andalousie');
INSERT INTO Region_geo VALUES (36, 'Buenos Aires');
INSERT INTO Region_geo VALUES (37, 'Le Caire');
INSERT INTO Region_geo VALUES (38, 'Téhéran');
INSERT INTO Region_geo VALUES (39, 'Bavière');
INSERT INTO Region_geo VALUES (40, 'Lombardie');
--Metropole/Grande ville
INSERT INTO Region_geo VALUES (41, 'Paris');
INSERT INTO Region_geo VALUES (42, 'Tokyo');
INSERT INTO Region_geo VALUES (43, 'Los Angeles');
INSERT INTO Region_geo VALUES (44, 'Casablanca');
INSERT INTO Region_geo VALUES (45, 'Brisbane');
INSERT INTO Region_geo VALUES (46, 'Rio de Janeiro');
INSERT INTO Region_geo VALUES (47, 'Tizi Ouzou');
INSERT INTO Region_geo VALUES (48, 'Qingdao');
INSERT INTO Region_geo VALUES (49, 'Toronto');
INSERT INTO Region_geo VALUES (50, 'Mumbai');
INSERT INTO Region_geo VALUES (51, 'Moscou');
INSERT INTO Region_geo VALUES (52, 'Durban');
INSERT INTO Region_geo VALUES (53, 'Guadalajara');
INSERT INTO Region_geo VALUES (54, 'Auckland');
INSERT INTO Region_geo VALUES (55, 'Séville');
INSERT INTO Region_geo VALUES (56, 'Buenos Aires');
INSERT INTO Region_geo VALUES (57, 'Le Caire');
INSERT INTO Region_geo VALUES (58, 'Téhéran');
INSERT INTO Region_geo VALUES (59, 'Munich');
INSERT INTO Region_geo VALUES (60, 'Milan');
--Commune
INSERT INTO Region_geo VALUES (61, 'Rouen');
INSERT INTO Region_geo VALUES (62, 'Sapporo');
INSERT INTO Region_geo VALUES (63, 'Los Angeles');
INSERT INTO Region_geo VALUES (64, 'Tangier');
INSERT INTO Region_geo VALUES (65, 'Brisbane');
INSERT INTO Region_geo VALUES (66, 'Rio das Ostras');
INSERT INTO Region_geo VALUES (67, 'Tizi Ouzou');
INSERT INTO Region_geo VALUES (68, 'Qingdao');
INSERT INTO Region_geo VALUES (69, 'Toronto');
INSERT INTO Region_geo VALUES (70, 'Mumbai');
INSERT INTO Region_geo VALUES (71, 'Moscou');
INSERT INTO Region_geo VALUES (72, 'Durban');
INSERT INTO Region_geo VALUES (73, 'Guadalajara');
INSERT INTO Region_geo VALUES (74, 'Auckland');
INSERT INTO Region_geo VALUES (75, 'Séville');
INSERT INTO Region_geo VALUES (76, 'Le havre');
INSERT INTO Region_geo VALUES (77, 'Saint-etienne');
INSERT INTO Region_geo VALUES (78, 'bordeaux');
INSERT INTO Region_geo VALUES (79, 'Munich');
INSERT INTO Region_geo VALUES (80, 'Milan');


INSERT INTO Subvention (id, nom, date_debut, date_fin) VALUES 
(1,'Subvention pour achat de machines de production de jus', '2022-01-01', '2022-12-31'),
(2,'Subvention pour la modernisation de la production de bière artisanale', '2022-03-15', '2023-03-14'),
(3,'Subvention pour le développement une entreprise de distribution de vin bio', '2022-05-01', '2023-05-01'),
(4,'Subvention pour installation un système de filtration eau pour la production de whisky', '2022-07-01', '2023-07-01'),
(5,'Subvention pour achat de cuves de fermentation pour la production de bière', '2022-09-01', '2023-09-01'),
(6,'Subvention pour le développement une entreprise de distribution de thé haut de gamme', '2022-11-01', '2023-11-01'),
(7,'Subvention pour achat un système de pasteurisation pour la production de lait', '2023-01-01', '2024-01-01'),
(8,'Subvention pour la modernisation de la production de soda artisanal', '2023-03-01', '2024-03-01'),
(9,'Subvention pour le développement une entreprise de distribution de champagne bio', '2023-05-01', '2024-05-01'),
(10,'Subvention pour installation un système de nettoyage automatisé pour la production de spiritueux', '2023-07-01', '2024-07-01'),
(11,'Subvention pour la promotion des produits locaux', '2022-01-01', '2022-06-30'),
(12,'Subvention pour amélioration de la qualité des eaux de surface', '2022-03-01', '2022-12-31'),
(13,'Subvention pour la modernisation des exploitations agricoles', '2022-04-01', '2022-09-30'),
(14,'Subvention pour la transition vers une agriculture biologique', '2022-05-01', '2022-11-30'),
(15,'Subvention pour la construction de serres horticoles', '2022-07-01', '2022-12-31'),
(16,'Subvention pour amélioration de la qualité des sols', '2022-08-01', '2022-12-31'),
(17,'Subvention pour installation de systèmes irrigation économes', '2022-09-01', '2022-12-31'),
(18,'Subvention pour la réduction des émissions de gaz à effet de serre en agriculture', '2022-10-01', '2022-12-31'),
(19,'Subvention pour achat de matériel agricole performant', '2022-11-01', '2022-12-31'),
(20,'Subvention pour la mise en place de pratiques agroforestières', '2022-12-01', '2022-12-31');

INSERT INTO Pays VALUES (1);
INSERT INTO Pays VALUES (2);
INSERT INTO Pays VALUES (3);
INSERT INTO Pays VALUES (4);
INSERT INTO Pays VALUES (5);
INSERT INTO Pays VALUES (6);
INSERT INTO Pays VALUES (7);
INSERT INTO Pays VALUES (8);
INSERT INTO Pays VALUES (9);
INSERT INTO Pays VALUES (10);
INSERT INTO Pays VALUES (11);
INSERT INTO Pays VALUES (12);
INSERT INTO Pays VALUES (13);
INSERT INTO Pays VALUES (14);
INSERT INTO Pays VALUES (15);
INSERT INTO Pays VALUES (16);
INSERT INTO Pays VALUES (17);
INSERT INTO Pays VALUES (18);
INSERT INTO Pays VALUES (19);
INSERT INTO Pays VALUES (20);

--id ref id_subvention
INSERT INTO Etatique (id,id_pays_concerne) VALUES 
(16,12),
(17,13),
(18,14),
(19,15),
(20,16);





INSERT INTO Region (id) VALUES 
(21),
(22),
(23),
(24),
(25),
(26),
(27),
(28),
(29),
(30),
(31),
(32),
(33),
(34),
(35),
(36),
(37),
(38),
(39),
(40);


INSERT INTO Metropole (id) VALUES 
(41),
(42),
(43),
(44),
(45),
(46),
(47),
(48),
(49),
(50),
(51),
(52),
(53),
(54),
(55),
(56),
(57),
(58),
(59),
(60);

INSERT INTO Metropolitaine (id,id_metropole_concernee) VALUES 
(7,44),
(8,50),
(9,59),
(10,45),
(11,46),
(12,47),
(13,48),
(14,49),
(15,50);


INSERT INTO Commune (id) VALUES 
(61),
(62),
(63),
(64),
(65),
(66),
(67),
(68),
(69),
(70),
(71),
(72),
(73),
(74),
(75),
(76),
(77),
(78),
(79),
(80);

insert into Communale (id,id_commune_concernee) VALUES

(1,61),
(2,72),
(3,61),
(4,71),
(5,63),
(6,73);





INSERT INTO Eau VALUES (1,0,0,0.1,0.5,0,0,9,10,4);
INSERT INTO Eau VALUES (2,0,0,0.1,0.5,0,0,9,10,4);
INSERT INTO Eau VALUES (3,0,0,0.1,0.5,0,0,9,10,4);
INSERT INTO Eau VALUES (4,0,0,0.1,0.5,0,0,9,10,4);


INSERT INTO Sub_valFix VALUES (11,546547,0.1);
INSERT INTO Sub_valFix VALUES (12,2,0.4);
INSERT INTO Sub_valFix VALUES (13,5,0.5);
INSERT INTO Sub_valFix VALUES (14,4,0.06);
INSERT INTO Sub_valFix VALUES (15,10,1);
INSERT INTO Sub_valFix VALUES (16,0,0);
INSERT INTO Sub_valFix VALUES (17,78,0.7);


INSERT INTO Sub_valHab VALUES (1,546,0.1,5,2);
INSERT INTO Sub_valHab VALUES (2,2,0.4,5,1);
INSERT INTO Sub_valHab VALUES (3,5,0.5,5,2);
INSERT INTO Sub_valHab VALUES (4,4,0.06,5,1);
INSERT INTO Sub_valHab VALUES (5,10,1,5,1);
INSERT INTO Sub_valHab VALUES (6,0,0,5,2);
INSERT INTO Sub_valHab VALUES (7,78,0.7,5,1);

/*
client_liquide (id_liquide,id_client,cout_conso)
*/

INSERT INTO Client_liquide VALUES (1,1,1.20);
INSERT INTO Client_liquide VALUES (1,2,1.05);
INSERT INTO Client_liquide VALUES (2,2,2);
INSERT INTO Client_liquide VALUES (3,1,6);

INSERT INTO Client_liquide VALUES (4,4,5);
INSERT INTO Client_liquide VALUES (5,5,10);
INSERT INTO Client_liquide VALUES (1,6,10);

/*
fournisseur_liquide(id_fournisseur,id_liquid,debit_max,prix)
*/

--roxanne
INSERT INTO Fournisseur_liquide VALUES (1,1,1.20,5);
INSERT INTO Fournisseur_liquide VALUES (1,2,1.05,5);
INSERT INTO Fournisseur_liquide VALUES (1,3,2,5);
INSERT INTO Fournisseur_liquide VALUES (1,4,2,5);
--tropicana
INSERT INTO Fournisseur_liquide VALUES (2,6,1.20,5);
INSERT INTO Fournisseur_liquide VALUES (2,8,1.05,5);
INSERT INTO Fournisseur_liquide VALUES (2,9,2,5);
INSERT INTO Fournisseur_liquide VALUES (2,10,2,5);
INSERT INTO Fournisseur_liquide VALUES (2,11,1.20,5);
INSERT INTO Fournisseur_liquide VALUES (2,12,1.05,5);
--danone
INSERT INTO Fournisseur_liquide VALUES (4,6,2,5);
INSERT INTO Fournisseur_liquide VALUES (4,13,2,5);
--Heineken
INSERT INTO Fournisseur_liquide VALUES (3,19,6,5);
INSERT INTO Fournisseur_liquide VALUES (3,17,5,5);
--GrupoModelo
INSERT INTO Fournisseur_liquide VALUES (5,20,10,5);
--LaMartiniquaise
INSERT INTO Fournisseur_liquide VALUES (7,16,10,5);
--Brown-Forman
INSERT INTO Fournisseur_liquide VALUES (9,18,10,5);
--redbull
INSERT INTO Fournisseur_liquide VALUES (8,5,10,5);


/*
geo_sub_liquide(id_region_concerne,id_sub,id_liquide)
*/

INSERT INTO Geo_sub_liquide VALUES (1,1,1);
INSERT INTO Geo_sub_liquide VALUES (2,2,1);
INSERT INTO Geo_sub_liquide VALUES (1,7,2);
INSERT INTO Geo_sub_liquide VALUES (3,3,4);
INSERT INTO Geo_sub_liquide VALUES (5,4,5);
INSERT INTO Geo_sub_liquide VALUES (5,5,6);
INSERT INTO Geo_sub_liquide VALUES (6,6,10);


INSERT INTO Jus VALUES (6,'jus orange');
INSERT INTO Jus VALUES (9,'kiwi');
INSERT INTO Jus VALUES (8,'banane');
INSERT INTO Jus VALUES (10,'ananas');
INSERT INTO Jus VALUES (11,'pomme');
INSERT INTO Jus VALUES (12,'pamplemousse');
INSERT INTO Jus VALUES (13,'danone lait et jus orange');
INSERT INTO Jus VALUES (14,'coco');


INSERT INTO Alcool VALUES (16,'polia',35);
INSERT INTO Alcool VALUES (17,'CaptainMorgan',40);
INSERT INTO Alcool VALUES (18,'Jackdaniel',40);
INSERT INTO Alcool VALUES (19,'Biere Heineken',5);
INSERT INTO Alcool VALUES (20,'Biere Corona',5);

/*
Client_geo(id_client,id_region_geo_concerne)
*/

INSERT INTO Client_geo VALUES (1,3);
INSERT INTO Client_geo VALUES (2,3);
INSERT INTO Client_geo VALUES (3,1);
INSERT INTO Client_geo VALUES (4,3);
INSERT INTO Client_geo VALUES (5,5);
INSERT INTO Client_geo VALUES (6,4);
INSERT INTO Client_geo VALUES (7,1);

/*
Liquide_geo(id_liquide,id_region_geo_concerne)
id_liquide
id_geo__depart
id_geo__arrive
cout_deplacement
*/

INSERT INTO Liquide_geo VALUES (1,61,65,2000);
INSERT INTO Liquide_geo VALUES (2,61,65,2000);
INSERT INTO Liquide_geo VALUES (3,61,65,2000);
INSERT INTO Liquide_geo VALUES (4,61,65,2000);
INSERT INTO Liquide_geo VALUES (5,61,65,2000);
INSERT INTO Liquide_geo VALUES (6,67,78,389);
INSERT INTO Liquide_geo VALUES (14,60,73,56);
INSERT INTO Liquide_geo VALUES (4,62,77,3);
INSERT INTO Liquide_geo VALUES (5,68,77,5);
INSERT INTO Liquide_geo VALUES (6,60,77,4);
INSERT INTO Liquide_geo VALUES (14,60,62,100);


/*
Fournisseur_geo(id_liquide,id_region_geo_concerne)
*/

INSERT INTO Fournisseur_geo VALUES (1,1);
INSERT INTO Fournisseur_geo VALUES (2,3);
INSERT INTO Fournisseur_geo VALUES (3,4);
INSERT INTO Fournisseur_geo VALUES (4,1);
INSERT INTO Fournisseur_geo VALUES (5,18);
INSERT INTO Fournisseur_geo VALUES (6,3);
INSERT INTO Fournisseur_geo VALUES (7,1);
INSERT INTO Fournisseur_geo VALUES (8,17);
INSERT INTO Fournisseur_geo VALUES (9,3);



/*
CREATE TABLE IF NOT EXISTS Geo_geo(
    id_geo integer NOT NULL,
    id_geo_macro integer NOT NULL,
    CONSTRAINT fk_geo_geo__g FOREIGN KEY (id_geo) REFERENCES Region_geo(id),
    CONSTRAINT fk_geo_geo__mg FOREIGN KEY (id_geo_macro) REFERENCES Region_geo(id)
);
*/

insert into Geo_geo (id_geo,id_geo_macro) values 
	--region dans pays
	(21,1),
	(22,2),
	(23,3),
	(24,4),
	(25,5),
	(26,6),
	(27,7),
	(28,8),
	(29,9),
	(30,10),
	(31,11),
	(32,12),
	(33,13),
	(34,14),
	(35,15),
	(36,16),
	(37,17),
	(38,18),
	(39,19),
	(40,20),
	--metropole dans region
	(41,21),
	(42,22),
	(43,23),
	(44,24),
	(45,25),
	(46,26),
	(47,27),
	(48,28),
	(49,29),
	(50,30),
	(51,31),
	(52,32),
	(53,33),
	(54,34),
	(55,35),
	(56,36),
	(57,37),
	(58,38),
	(59,39),
	(60,40),
	--commune dans metropole ou region parce que metropole des fois dans certains pays, le concept est flou pour moi
	(61,41),
	(62,42),
	(63,43),
	(64,44),
	(65,45),
	(66,46),
	(67,47),
	(68,48),
	(69,49),
	(70,30),
	(71,31),
	(72,32),
	(73,33),
	(74,34),
	(75,35),
	(76,36),
	(77,37),
	(78,38),
	(79,39),
	(80,40);













