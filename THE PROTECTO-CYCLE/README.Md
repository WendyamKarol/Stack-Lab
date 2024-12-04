# Protecto-Cycle: Internet of Things (IoT) Project

## Introduction
-----------------------------------------------

Le projet **Protecto-Cycle** a été conçu pour automatiser le système d'éclairage d'un environnement spécifique, tel qu'un parc à vélos, un garage ou tout autre lieu nécessitant un éclairage en fonction de la présence d'objets ou de personnes. Ce projet fait partie du domaine de l'**Internet des Objets (IoT)** et utilise des technologies comme **Python**, **C++**, **Raspberry Pi** et **Arduino** pour offrir une solution innovante et intelligente.

L'objectif principal est de créer un système d'éclairage capable de détecter la présence d'un vélo ou d'une personne dans une zone donnée et de contrôler l'éclairage en conséquence. Ce dispositif permet de réduire la consommation d'énergie tout en assurant une sécurité et une commodité optimales.

## Objectifs du Projet
-----------------------------------------------

- **Automatisation de l'éclairage** : Développer un système intelligent qui ajuste l'intensité et l'état des lumières en fonction de la présence dans la zone surveillée.
- **Optimisation de la consommation d'énergie** : Utiliser des capteurs pour détecter la présence et éteindre les lumières lorsque la zone est vide, réduisant ainsi la consommation d'énergie.
- **Contrôle à distance** : Permettre la gestion du système via une interface à distance pour le contrôle des paramètres (activation, désactivation, ajustement de l'intensité lumineuse).
- **Intégration IoT** : Créer une infrastructure IoT pour connecter les appareils et permettre la gestion et la surveillance du système à distance.

## Technologies Utilisées

- **Python** : Utilisé pour la programmation sur le Raspberry Pi, notamment pour le traitement des données des capteurs et la gestion des entrées/sorties.
- **C++** : Utilisé pour la programmation de la carte Arduino, principalement pour le contrôle des capteurs et des relais.
- **Raspberry Pi** : Utilisé comme unité centrale de traitement pour gérer les communications et exécuter les scripts Python.
- **Arduino** : Utilisé pour interfacer les capteurs de présence, contrôler les relais d'éclairage et transmettre les données au Raspberry Pi.
- **Capteurs de mouvement PIR (Passive Infrared)** : Détectent la présence de personnes ou d'objets dans la zone surveillée.
- **Relais** : Utilisés pour contrôler l'allumage et l'extinction des lumières en fonction des signaux envoyés par le Raspberry Pi et l'Arduino.
- **Réseau IoT** : Pour la gestion à distance et la surveillance du système à travers une interface web ou mobile.

## Architecture du Système
-----------------------------------------------

Le système se compose de plusieurs composants intégrés de manière à offrir une solution IoT complète :

1. **Raspberry Pi** : Sert de serveur central et exécute les scripts Python pour gérer les interactions entre les capteurs et les relais, tout en collectant et analysant les données.
   
2. **Arduino** : Gère les capteurs de mouvement PIR et les relais qui contrôlent l’éclairage. Arduino communique avec le Raspberry Pi pour transmettre les informations sur la présence détectée.

3. **Capteurs PIR** : Placés dans la zone à surveiller (par exemple, un parking pour vélos), ces capteurs détectent le mouvement et envoient les signaux appropriés à l'Arduino.

4. **Relais** : Les relais sont utilisés pour activer ou désactiver les systèmes d'éclairage en fonction de l'entrée reçue de l'Arduino.

5. **Interface Utilisateur (IoT)** : Permet de contrôler le système à distance, ajuster les paramètres d'éclairage et consulter l'état actuel via une interface web ou application mobile.

## Fonctionnalités Principales

- **Détection de présence** : Le système allume les lumières lorsqu'un mouvement est détecté dans la zone surveillée et les éteint lorsqu'aucun mouvement n'est détecté pendant un certain temps.
- **Gestion des lumières** : Le système ajuste automatiquement l'intensité des lumières selon le niveau de lumière ambiante ou l'heure de la journée.
- **Suivi à distance** : Surveillance et gestion du système via une interface web ou une application mobile.
- **Alertes** : Envoi d'alertes ou de notifications lorsque des anomalies sont détectées dans le fonctionnement du système.

## Schéma de Connexion

Le système repose sur une communication entre les différents composants matériels via des protocoles standards. Voici un schéma de base du système :

1. **Arduino** : Gère les capteurs PIR et les relais pour allumer ou éteindre les lumières.
2. **Raspberry Pi** : Analyse les données envoyées par l'Arduino et prend les décisions d'allumer ou d'éteindre les lumières, tout en permettant un contrôle à distance via l'interface web.
3. **Capteurs PIR** : Détectent la présence dans la zone à éclairer.
4. **Relais** : Contrôlent l’alimentation des lumières.

## Installation et Configuration

### Prérequis

- Raspberry Pi avec Raspbian installé.
- Carte Arduino (par exemple, Arduino Uno).
- Capteurs PIR (minimum 2-3).
- Relais pour contrôler les lumières.
- Câbles de connexion et breadboard.
- Connexion Internet pour la gestion IoT (optionnel).

### Étapes d'Installation

1. **Configuration du Raspberry Pi** :
   - Installez Python et les bibliothèques nécessaires (`RPi.GPIO`, `Flask`, etc.).
   - Configurez les scripts Python pour lire les données des capteurs via les broches GPIO du Raspberry Pi.

2. **Configuration de l'Arduino** :
   - Téléchargez et installez le logiciel Arduino IDE.
   - Programmez l'Arduino pour gérer les capteurs PIR et les relais.
   - Reliez les capteurs PIR et relais à l'Arduino.

3. **Communication Raspberry Pi / Arduino** :
   - Configurez la communication entre le Raspberry Pi et l'Arduino via le port série pour transmettre les informations de détection de présence.

4. **Développement de l'interface IoT** :
   - Créez une interface web (utilisant Flask ou un autre framework) pour permettre à l'utilisateur de contrôler et de surveiller le système.

5. **Tests et Déploiement** :
   - Testez le système en simulant des mouvements pour vérifier l’allumage et l'extinction des lumières.
   - Déployez le système dans l’environnement cible (par exemple, un parking de vélos ou un garage).
