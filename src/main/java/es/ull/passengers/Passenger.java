/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.flights.Flight;

public class Passenger {

    // Fields to store passenger information
    private String identifier;
    private String name;
    private String countryCode;
    private Flight flight;

    /**
     * Constructor for the Passenger class.
     *
     * @param identifier  The identifier for the passenger.
     * @param name        The name of the passenger.
     * @param countryCode The country code of the passenger.
     * @throws RuntimeException If the provided country code is invalid.
     */
    public Passenger(String identifier, String name, String countryCode) {
        // Validate the country code
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    /**
     * Get the identifier of the passenger.
     *
     * @return The identifier.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Get the name of the passenger.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the country code of the passenger.
     *
     * @return The country code.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Get the flight associated with the passenger.
     *
     * @return The associated flight.
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Join a flight by setting the associated flight for the passenger.
     *
     * @param flight The flight to join.
     * @throws RuntimeException If the passenger cannot be removed from the previous flight or added to the new flight.
     */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        // Remove the passenger from the previous flight
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        // Set the passenger's flight to the new flight
        setFlight(flight);
        // Add the passenger to the new flight
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }

    /**
     * Set the associated flight for the passenger.
     *
     * @param flight The flight to set.
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * Override the toString method to provide a custom string representation of the passenger.
     *
     * @return A string representation of the passenger.
     */
    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}

