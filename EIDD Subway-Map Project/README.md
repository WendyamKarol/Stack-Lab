# MetroFlow

A **Java** application that calculates optimal routes in a subway network.  
This project uses **Gradle** for build automation, follows a **Test-Driven Development (TDD)** approach, and includes comprehensive unit tests to ensure reliability and accuracy.

---

## Features

- **Route Calculation**:  
  Determines the shortest or fastest route between two stations in a subway network.

- **Unit Test Support**:  
  Automated tests ensure the quality and robustness of each component of the program.

- **TDD Approach**:  
  Features were developed using a test-oriented methodology, ensuring optimal coverage.

- **Modularity**:  
  Code is structured to facilitate modifications and extensions.

---

## Technologies Used

The following tools and technologies were utilized for this project:

- **Language**: Java  
- **Build System**: Gradle  
- **Unit Tests**: JUnit  
- **Recommended IDE**: IntelliJ IDEA or Eclipse  
- **Development Methodology**: Test-Driven Development (TDD)  

---

## Code Example

Below is a demonstration of the basic functionality:

```java
public class ItineraryCalculator {
    public Itinerary calculateItinerary(Station departure, Station arrival) {
        return new Itinerary(departure, arrival);
    }
}

// Example of a unit test
@Test
public void testItineraryCalculator() {
    ItineraryCalculator calculator = new ItineraryCalculator();
    Station departure = new Station("Departure");
    Station arrival = new Station("Arrival");
    Itinerary itinerary = calculator.calculateItinerary(departure, arrival);
    assertNotNull(itinerary);
}
