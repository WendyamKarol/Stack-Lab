# Planificateur d'Itinéraire de Métro  

Une application en **Java** permettant de calculer les itinéraires optimaux dans un réseau de métro.  
Ce projet utilise **Gradle** pour l'automatisation des builds, suit une approche de **Développement Piloté par les Tests (TDD)** et inclut des tests unitaires complets pour garantir la fiabilité et la précision.

---

## Fonctionnalités  

- **Calcul d'Itinéraire** :  
  Détermine le chemin le plus court ou le plus rapide entre deux stations dans un réseau de métro.  

- **Support des Tests Unitaires** :  
  Les tests automatisés assurent la qualité et la robustesse de chaque composant du programme.  

- **Approche TDD** :  
  Les fonctionnalités ont été développées avec une méthodologie axée sur les tests, garantissant une couverture optimale.  

- **Modularité** :  
  Code organisé pour faciliter les modifications et l’extension.  

---

## Technologies Utilisées  

Les outils et technologies suivants ont été utilisés pour développer ce projet :  

- **Langage** : Java  
- **Système de Build** : Gradle  
- **Tests Unitaires** : JUnit  
- **IDE Recommandé** : IntelliJ IDEA ou Eclipse  
- **Méthodologie de Développement** : Test-Driven Development (TDD)  

---

## Exemple de Code  

Voici une démonstration du fonctionnement de base :  

```java
public class ItineraireCalculator {
    public Itineraire calculItineraire(Station depart, Station arrivee) {
        return new Itineraire(depart, arrivee);
    }
}

// Exemple de test unitaire
@Test
public void testItineraireCalculator() {
    ItineraireCalculator calculator = new ItineraireCalculator();
    Station depart = new Station("Départ");
    Station arrivee = new Station("Arrivée");
    Itineraire itineraire = calculator.calculItineraire(depart, arrivee);
    assertNotNull(itineraire);
}
