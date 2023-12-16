package es.ull.flights;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {

    // Se crean instancias de Flight y Passenger para usar en las pruebas
    Flight flight;
    Passenger passenger1;
    Passenger passenger2;

    // Configuración inicial antes de cada prueba
    @BeforeEach
    void setUp() {
        passenger1 = new Passenger("1", "Manuel", "ES");
        passenger2 = new Passenger("2", "Pedro", "LK");
        flight = new Flight("AH001", 30);
    }

    // Prueba para verificar la creación exitosa de un vuelo válido
    @Test
    @DisplayName("Create valid flight")
    void createValidFlight() {
        Flight flight = new Flight("AA123", 100);
        Assertions.assertEquals("AA123", flight.getFlightNumber());
        //Assertions.assertEquals(0, flight.getNumberOfPassengers());
    }

    // Prueba para verificar que los getters de la clase Flight funcionan correctamente
    @Test
    @DisplayName("Getters of the flight class should work")
    void groupGettersAssertions() {
        Assertions.assertAll("Flight",
                () -> Assertions.assertEquals("AH001", flight.getFlightNumber()),
                () -> Assertions.assertEquals(0, flight.getNumberOfPassengers())
        );
    }

    // Prueba para verificar la adición y eliminación exitosa de múltiples pasajeros
    @Test
    void addAndRemoveMultiplePassengers() {
        Flight flight = new Flight("AB123", 3);
        Passenger passenger1 = new Passenger("3", "Pedro", "LK");
        Passenger passenger2 = new Passenger("4", "Alba", "LK");
        Passenger passenger3 = new Passenger("5", "Mario", "LK");

        assertTrue(flight.addPassenger(passenger1));
        assertTrue(flight.addPassenger(passenger2));
        assertTrue(flight.addPassenger(passenger3));

        assertEquals(3, flight.getNumberOfPassengers());

        assertTrue(flight.removePassenger(passenger1));
        assertTrue(flight.removePassenger(passenger2));

        assertEquals(1, flight.getNumberOfPassengers());
    }

    // Prueba para verificar la excepción al intentar agregar un pasajero con vuelo nulo
    @Test
    void addPassengerWithNullFlight() {
        Flight flight = new Flight("AB123", 0);
        Passenger passenger = new Passenger("6", "John", "LK");
        passenger.setFlight(null);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> flight.addPassenger(passenger)
        );

        assertEquals("Not enough seats for flight AB123", exception.getMessage());
    }
}
