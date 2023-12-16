package es.ull.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.passengers.Passenger;

// Define a custom exception for invalid flight numbers
class InvalidFlightNumberException extends RuntimeException {
    public InvalidFlightNumberException(String message) {
        super(message);
    }
}

public class Flight {

    // Private fields to store flight information
    private String flightNumber;
    private int seats;
    private Set<Passenger> passengers = new HashSet<>();

    // Regular expression for validating flight numbers
    private static String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
    private static Pattern pattern = Pattern.compile(flightNumberRegex);

    /**
     * Constructor for the Flight class.
     *
     * @param flightNumber The flight number to set.
     * @param seats        The number of seats on the flight.
     * @throws InvalidFlightNumberException If the provided flight number is invalid.
     */
    public Flight(String flightNumber, int seats) {
        // Validate the flight number using a regular expression
        Matcher matcher = pattern.matcher(flightNumber);
        if (!matcher.matches()) {
            throw new InvalidFlightNumberException("Invalid flight number");
        }
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    /**
     * Get the flight number.
     *
     * @return The flight number.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Get the number of passengers on the flight.
     *
     * @return The number of passengers.
     */
    public int getNumberOfPassengers() {
        return passengers.size();
    }

    /**
     * Add a passenger to the flight.
     *
     * @param passenger The passenger to add.
     * @return True if the passenger is added successfully, false otherwise.
     * @throws RuntimeException If there are not enough seats for the passenger.
     */
    public boolean addPassenger(Passenger passenger) {
        // Check if there are enough seats for the passenger
        if (getNumberOfPassengers() >= seats) {
            throw new RuntimeException("Not enough seats for flight " + getFlightNumber());
        }
        // Set the flight for the passenger and add them to the set of passengers
        passenger.setFlight(this);
        return passengers.add(passenger);
    }

    /**
     * Remove a passenger from the flight.
     *
     * @param passenger The passenger to remove.
     * @return True if the passenger is removed successfully, false otherwise.
     */
    public boolean removePassenger(Passenger passenger) {
        // Set the flight for the passenger to null and remove them from the set of passengers
        passenger.setFlight(null);
        return passengers.remove(passenger);
    }
}
