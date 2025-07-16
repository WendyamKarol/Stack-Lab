# Projet de Programmation Synchrone

## Description du Projet

Ce projet, réalisé dans le cadre du **Master 2 Informatique (UP)** et de la **3ème année EIDD**, vise à fournir une expérience pratique du développement en langages synchrones, largement utilisés dans les systèmes critiques industriels. Vous êtes chargé de développer un **programme synchrone** contrôlant un **véhicule autonome** évoluant dans une **ville virtuelle en 2D**.

Le projet utilise principalement **Heptagon**, un langage synchrone dérivé de **SCADE**, ainsi que **C**, pour la création et l'intégration des systèmes critiques.

La performance de votre programme sera évaluée en fonction de la capacité du véhicule à compléter des parcours de complexité croissante tout en respectant les contraintes imposées, telles que :
- Les limitations de vitesse.
- Les feux rouges.
- L’évitement d’obstacles.

---

## Objectifs

- Développer un programme synchrone performant et modulaire à l'aide de **Heptagon**.
- Contrôler un véhicule autonome et respecter les règles de conduite définies par les cartes virtuelles.
- Utiliser les outils de débogage et de simulation pour tester et améliorer les performances du programme.

---

## Prérequis Techniques

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :

- **Système d’exploitation** : UNIX-like (Linux ou macOS).
- **Chaîne de compilation** : GCC, GNU Make (4.0+).
- **Gestionnaire de version** : Git.
- **Bibliothèque multimédia** : SDL2.
- **Compilateur Heptagon** : installable via OPAM.
- **Bibliothèques Python** : *Pandas*, *Matplotlib* (facultatif, pour le traçage graphique).


## Fonctionnalités Implémentés

Le projet se développe en plusieurs étapes fonctionnelles. Voici une méthodologie suggérée :

1. **Suivre une route rectiligne** en avançant à vitesse constante.
2. **Corriger l'orientation du véhicule** sur des routes courbes.
3. **Effectuer des rotations précises**.
4. **Détecter les étapes (balises vertes)** et suivre l'itinéraire.
5. **Respecter les feux rouges**.
6. **Éviter les collisions** en détectant les obstacles avec le sonar.



