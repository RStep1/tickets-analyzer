package com.rstep1.flight;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rstep1.app.TimeAnalyzer;
import com.rstep1.model.Ticket;
import com.rstep1.util.AirportTimeZone;

public class FlightTimeAnalyzer implements TimeAnalyzer {
    private final List<Ticket> tickets;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");

    public FlightTimeAnalyzer(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public Map<String, Duration> calculateMinFlightDurations() {
        Map<String, Duration> minFlightDurations = new HashMap<>();
        for (Ticket ticket : tickets) {
            String carrier = ticket.carrier();
            Duration newDuration = calculateDuration(ticket);
            
            if (minFlightDurations.containsKey(carrier)) {
                Duration duration = minFlightDurations.get(carrier);
                if (newDuration.compareTo(duration) < 0) {
                    minFlightDurations.put(carrier, newDuration);
                }
            } else {
                minFlightDurations.put(carrier, newDuration);
            }
        }
        return minFlightDurations;
    }

    private Duration calculateDuration(Ticket ticket) {
        int originUtcOffset = AirportTimeZone.getUtcOffset(ticket.origin());
        int destinationUtcOffset = AirportTimeZone.getUtcOffset(ticket.destination());

        LocalDateTime departureLocal = 
            LocalDateTime.parse(ticket.departureDate() + " " + ticket.departureTime(), formatter);
        LocalDateTime arrivalLocal = 
            LocalDateTime.parse(ticket.arrivalDate() + " " + ticket.arrivalTime(), formatter);

        return Duration.between(arrivalLocal, departureLocal).abs().minusHours(destinationUtcOffset - originUtcOffset);
    }
}
