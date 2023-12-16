package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengerTest {

    // Se crean instancias de Passenger para usar en las pruebas
    Passenger passenger1;
    Passenger passenger2;

    // Configuración inicial antes de cada prueba
    @BeforeEach
    void setUp() {
        passenger1 = new Passenger("1", "Manuel", "ES");
        passenger2 =  new Passenger("2", "Pedro", "LK");
    }

    // Prueba para verificar que el getter de Name funciona correctamente
    @Test
    @DisplayName("Getter of Name")
    void getName() {
        Assertions.assertEquals("Manuel", passenger1.getName());
    }

    // Prueba para verificar que el getter de Identifier funciona correctamente
    @Test
    @DisplayName("Getter of Identifier")
    void getIdentifier() {
        Assertions.assertEquals("1", passenger1.getIdentifier());
    }

    // Prueba para verificar que el getter de CountryCode funciona correctamente
    @Test
    @DisplayName("Getter of Country")
    void getCountryCode() {
        Assertions.assertEquals("ES", passenger1.getCountryCode());
    }

    // Prueba para verificar que el getter de Flight devuelve null inicialmente
    @Test
    @DisplayName("Getter of Flight")
    void getFlight() {
        Assertions.assertEquals(null, passenger1.getFlight());
    }

    // Prueba para verificar que un pasajero puede unirse a un vuelo
    @Test
    @DisplayName("The passenger should join a flight")
    void joinFlight() {
        Flight flight = new Flight("AH001", 1);
        passenger1.joinFlight(flight);
        Assertions.assertEquals(flight, passenger1.getFlight());
    }
}
