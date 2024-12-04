# Base de Données de Distribution de Boissons

## Introduction

Le projet **Base de Données de Distribution de Boissons** vise à développer une solution permettant à l'entreprise **Liquide & Co** de gérer efficacement toutes les données relatives à la production, la distribution et la facturation de boissons. Ce système doit stocker des informations sur les boissons produites, les clients, les fournisseurs, les régions de distribution ainsi que les subventions obtenues. L'objectif principal est de faciliter la gestion des stocks, des commandes, des livraisons, des paiements et de permettre une facturation précise en fonction de critères géographiques et économiques régionaux.

L'entreprise doit s'assurer de la sécurité des produits (potabilité des liquides) et de la conformité avec les législations locales. En outre, elle doit pouvoir prendre en compte les différents coûts liés à l'acheminement des marchandises, les coûts de production et les subventions applicables.

## Cahier des Charges

### Contexte

**Liquide & Co** est une entreprise spécialisée dans la production et la distribution de boissons. Elle doit pouvoir gérer efficacement ses clients, fournisseurs, produits, et les différentes régions géographiques où elle distribue. Les différents types de liquides (eau, jus, alcool) doivent être suivis et la société doit s'assurer qu'ils respectent les normes de qualité et de sécurité en vigueur dans chaque région. L'entreprise doit également prendre en compte les subventions régionales, étatiques, métropolitaines et communales lors de la facturation et du calcul des prix des produits.

### Objectif

Le projet a pour but de concevoir une **base de données** robuste, évolutive et sécurisée, permettant de gérer et de stocker les informations nécessaires pour la production et la distribution de boissons. Il permettra à l'entreprise de calculer des factures personnalisées en fonction des régions géographiques, du type de liquide et du contexte économique régional.

## Description de la Base de Données et Son Utilisation

La base de données est composée de plusieurs tables interconnectées permettant de gérer les informations relatives aux produits, clients, fournisseurs, régions géographiques et subventions. Les tables principales et leurs relations sont détaillées ci-dessous.

### Tables

#### 1. **Liquide**
- **id** : Identifiant unique du liquide.
- **nom** : Nom du liquide (eau, jus, alcool, etc.).
- **ispotable** : Indicateur de la potabilité du liquide (booléen).

#### 2. **Region_geo**
- **id** : Identifiant de la région géographique.
- **nom** : Nom de la région géographique.

#### 3. **Client**
- **id** : Identifiant du client.
- **nom** : Nom du client.
- **prenom** : Prénom du client.
- **email** : Adresse e-mail du client.
- **id_geo** : Identifiant de la région géographique associée au client.

#### 4. **Fournisseur**
- **id** : Identifiant du fournisseur.
- **nom** : Nom du fournisseur.

#### 5. **Subvention**
- **id** : Identifiant de la subvention.
- **nom** : Nom de la subvention.
- **date_début** : Date de début de la subvention.
- **date_fin** : Date de fin de la subvention.

#### 6. **Pays**
- **id** : Identifiant du pays, référencé par la région géographique associée.

#### 7. **Etatique**
- **id** : Identifiant de la subvention étatique.
- **id_pays_concerne** : Identifiant du pays concerné par la subvention.

#### 8. **Region**
- **id** : Identifiant de la région.
- **id_region_geo** : Identifiant de la région géographique associée à la région.

#### 9. **Metropole**
- **id** : Identifiant de la métropole.
- **id_region_geo** : Identifiant de la région géographique associée à la métropole.

#### 10. **Commune**
- **id** : Identifiant de la commune.
- **id_region_geo** : Identifiant de la région géographique associée à la commune.

#### 11. **Geo_sub_liquide**
- **id** : Identifiant.
- **id_region_geo** : Identifiant de la région géographique.
- **id_subvention** : Identifiant de la subvention.
- **id_liquide** : Identifiant du liquide.

### Relations

Les tables sont interconnectées par des relations via des tables de jointure, permettant de lier les clients, fournisseurs, liquides et régions géographiques de manière cohérente et dynamique. Voici les principales tables de liaison :

- **Geo_sub_liquide** : Associe une subvention et un liquide à une région géographique spécifique.
- **Client_geo** : Associe un client à une région géographique spécifique.
- **Fournisseur_geo** : Associe un fournisseur à une région géographique spécifique.
- **Fournisseur_liquide** : Associe un fournisseur à un liquide, avec des informations sur les prix et les débits.

## Requêtes SQL

Voici un ensemble de requêtes pour manipuler et extraire les données de la base de données :

### 1. **Requêtes avec sous-requêtes**

- **consoSup8.sql** : Trouve les clients dont la consommation dépasse 8 unités SI.
- **jusIsPotable.sql** : Vérifie que tous les jus sont bien potables.

### 2. **Requêtes avec jointures**

- **paysFournisseur.sql** : Liste les pays et les fournisseurs associés.
- **achatsClient.sql** : Affiche les achats réalisés par les clients.

### 3. **Création de vues**

- **vw_prixLocal_Liquide.sql** : Affiche les coûts liés à chaque région pour chaque liquide.
- **vw_subLocal_liquide.sql** : Table condensée des subventions pour un passage dans loop.

## Fonctions

Les fonctions suivantes sont utilisées pour des calculs spécifiques dans la base de données :

- **fct_isRegionIn.sql** : Vérifie si une région est englobée par une autre région.
- **fct_RegionEnglobantes.sql** : Liste les régions englobées par celle spécifiée.
- **fct_totalSub.sql** : Calcule la somme des subventions pour une région donnée et un liquide spécifique.

## Triggers

13 triggers ont été définis pour maintenir l'intégrité des données et garantir le bon fonctionnement de la base.

## Diagrammes

- **Diagramme E/R** : Un diagramme Entité-Relation détaillant les relations entre les différentes tables.
- **Diagramme SQL** : Un diagramme des schémas SQL représentant la structure de la base de données.

