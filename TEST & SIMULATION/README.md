# Projet Test & Simulation

## Introduction

Le projet Test & Simulation a pour objectif la création d'une solution logicielle innovante permettant le contrôle et la gestion d'un robot spatial à travers un système de supervision centralisé. Ce robot, conçu pour effectuer des missions dans un environnement spatial simulé, est contrôlé à distance via une API REST. L'objectif principal du projet est d'optimiser les opérations automatisées tout en offrant une gestion centralisée et une supervision en temps réel des différentes missions.

## Choix des Outils et Techniques

Le projet utilise une combinaison de technologies modernes et éprouvées pour offrir une solution robuste et flexible :

- **Langage** : Java
- **Framework** : Spring
- **Base de données** : PostgreSQL
- **Tests** : JUnit, Postman
- **IDE** : IntelliJ IDEA

### Détails techniques

- **Java** : Le langage principal utilisé pour la conception du projet. Nous avons choisi Java pour sa robustesse, sa portabilité et la vaste communauté qui l'entoure.
- **Spring** : Framework populaire qui permet de développer des applications Java modulaires et évolutives. Spring simplifie la gestion des dépendances et l'intégration des différents composants du système.
- **PostgreSQL** : Base de données relationnelle utilisée pour stocker les informations relatives aux robots et aux missions.
- **JUnit** et **Postman** : Utilisés pour effectuer des tests unitaires sur les composants du système et valider les points de terminaison de l'API REST.
- **IntelliJ IDEA** : L'environnement de développement intégré (IDE) choisi pour son excellent support Java, ses fonctionnalités avancées et son intégration avec de nombreux outils de développement.

## Architecture Logicielle

L'architecture de notre solution est conçue de manière modulaire et évolutive. Voici les principaux composants :

- **Robot** : Un composant physique intégré au système pour effectuer des actions automatisées.
- **API REST** : L'architecture REST permet une communication standardisée entre le robot et le système de supervision. Les points de terminaison de l'API facilitent l'échange de données entre le robot et l'interface de gestion.
- **Base de données** : PostgreSQL est utilisé pour stocker les informations relatives aux missions, aux robots et à d'autres entités du système.
- **Spring** : Utilisé pour gérer les services du système, permettant une gestion centralisée et modulaire des différents processus.

### Schéma de l'architecture

L'architecture repose sur un modèle client-serveur où le robot agit comme un client qui envoie des données à un serveur via des points de terminaison d'API REST. Le serveur traite ces données et renvoie des réponses adaptées, facilitant ainsi l'intégration de nouveaux robots et la gestion des missions.

## Tests Unitaires

### Tests Unitaires pour la Classe `Mission`

La classe `Mission` représente une entité essentielle dans notre système, décrivant les caractéristiques d'une mission attribuée à un robot. Pour garantir la robustesse et la fiabilité de cette classe, des tests unitaires ont été élaborés en utilisant le framework **JUnit**.

Les tests pour la classe `Mission` incluent :

- Vérification de la création de missions avec des attributs valides.
- Tests de la gestion des erreurs (par exemple, lorsque des données incorrectes sont fournies).
- Tests de la logique métier associée à la gestion des missions.

Les tests sont conçus pour s'assurer que toutes les méthodes de la classe fonctionnent correctement, en garantissant que l'attribut de la mission est bien initialisé et que les modifications sont correctement appliquées.


## Fonctionnalités

Voici les principales fonctionnalités du projet **Test & Simulation** :

### 1. **Création et gestion des missions**
   - Les utilisateurs peuvent créer, modifier et suivre les missions attribuées aux robots.
   - Chaque mission possède des attributs spécifiques, tels que le nom de la mission, l'identifiant du robot, et la description de l'objectif.
   - L'état de chaque mission peut être mis à jour au fur et à mesure de son avancement.

### 2. **Supervision des robots**
   - Le système permet de superviser l'état des robots en temps réel via un tableau de bord centralisé.
   - Les informations sur chaque robot, telles que son statut (actif, en pause, etc.), son positionnement, et les missions en cours, sont accessibles.
   - Des alertes peuvent être configurées pour notifier les utilisateurs en cas de problème avec un robot.

### 3. **API REST pour l'intégration et la communication**
   - Une architecture API REST standardisée permet la communication entre le robot physique et le système de supervision.
   - Le système expose des points de terminaison permettant :
     - **GET** : Récupérer les informations sur les robots, missions, et autres entités.
     - **POST** : Créer de nouvelles missions ou ajouter de nouveaux robots.
     - **PUT** : Mettre à jour les informations des robots ou des missions.
     - **DELETE** : Supprimer des robots ou des missions.
   - L'API REST permet d’intégrer d’autres services ou applications au système de supervision.

### 4. **Tests unitaires pour la validation du système**
   - Des tests unitaires ont été développés pour valider la bonne fonctionnalité des principales classes du système, comme la classe `Mission`.
   - Ces tests permettent de vérifier que la logique métier fonctionne correctement et que les erreurs sont gérées correctement.
   - Le framework **JUnit** est utilisé pour automatiser ces tests, garantissant la fiabilité du code.

### 5. **Tests d'API avec Postman**
   - Les points de terminaison de l'API REST ont été testés avec **Postman** afin de s'assurer que chaque fonctionnalité fonctionne comme prévu.
   - Les tests incluent des vérifications de la réponse du serveur, des tests de gestion des erreurs, ainsi que des tests de performance et de sécurité pour garantir la stabilité du système.

### 6. **Simulation des missions**
   - Le système permet de simuler les missions des robots avant de les exécuter dans un environnement réel.
   - Les utilisateurs peuvent planifier et tester les missions dans un environnement contrôlé pour s'assurer qu'elles fonctionnent correctement avant de les déployer.
   - Cette fonctionnalité permet de réduire les risques d'erreurs dans les missions réelles en simulant les différents scénarios.

### 7. **Gestion de la base de données**
   - Une base de données PostgreSQL est utilisée pour stocker toutes les informations relatives aux robots, missions, utilisateurs, et autres entités du système.
   - La gestion de la base de données se fait via **JPA (Java Persistence API)**, permettant une gestion efficace des données et une intégration transparente avec l'application.
   - Les entités de la base de données sont liées aux différentes classes Java du projet, facilitant la manipulation des données et la gestion des relations entre elles.

### 8. **Tableau de bord de supervision**
   - Un tableau de bord visuel est fourni pour permettre aux utilisateurs de superviser en temps réel l’état des robots et des missions.
   - Les utilisateurs peuvent visualiser des graphiques et des statistiques sur les performances des robots, les progrès des missions et d’autres indicateurs clés.
   - Ce tableau de bord aide à la prise de décision en offrant une vue d'ensemble claire et détaillée des opérations en cours.

### 9. **Extensibilité et évolutivité**
   - Le système est conçu pour être facilement extensible, permettant l'ajout de nouvelles fonctionnalités et de nouveaux robots à tout moment.
   - L’architecture modulaire permet l’ajout de nouveaux services, la gestion de nouveaux types de missions et l’intégration avec d'autres systèmes via l'API REST.
   - La gestion des mises à jour est simplifiée, garantissant que le système reste flexible face aux évolutions technologiques et aux nouveaux besoins des utilisateurs.

### 10. **Suivi de l’état des robots**
   - Le système permet de suivre en temps réel l'état des robots via des indicateurs de performance et des rapports d'état.
   - Le suivi inclut des données telles que la localisation du robot, son niveau de batterie, son état opérationnel, et les missions en cours.
   - Des alertes peuvent être envoyées en cas de détection d'anomalies dans le fonctionnement des robots.

Ces fonctionnalités font de notre solution une plateforme complète et robuste pour gérer des robots autonomes et leurs missions de manière efficace et centralisée.
