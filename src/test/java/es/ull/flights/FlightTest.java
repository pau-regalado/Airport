package es.ull.flights;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {
    Flight flight;
    Passenger passenger1;
    Passenger passenger2;

    @BeforeEach
    void setUp() {
        passenger1 = new Passenger("1", "Manuel", "ES");
        passenger2 =  new Passenger("2", "Pedro", "LK");
        flight = new Flight("AH001", 30);
    }

    @Test
    @DisplayName("Create valid flight")
    void createValidFlight() {
        Flight flight = new Flight("AA123", 100);
        Assertions.assertEquals("AA123", flight.getFlightNumber());
        //Assertions.assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    @DisplayName("Getters of the flight class should work")
    void groupGettersAssertions() {
        Assertions.assertAll("Flight",
                () -> Assertions.assertEquals("AH001", flight.getFlightNumber()),
                () -> Assertions.assertEquals(0, flight.getNumberOfPassengers())
        );
    }
}
