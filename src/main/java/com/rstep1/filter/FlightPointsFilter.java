package com.rstep1.filter;

import java.util.List;
import java.util.stream.Collectors;

import com.rstep1.app.TicketFilter;
import com.rstep1.model.Ticket;

public class FlightPointsFilter implements TicketFilter {
    private String firstAirport;
    private String secondAirport;

    public FlightPointsFilter(String firstAirport, String secodeAirport) {
        this.firstAirport = firstAirport;
        this.secondAirport = secodeAirport;
    }

    @Override
    public List<Ticket> filter(List<Ticket> tickets) {
        return tickets.stream()
            .filter(ticket -> 
                ticket.origin().equals(firstAirport) || ticket.origin().equals(secondAirport))
            .filter(ticket -> 
                ticket.destination().equals(firstAirport) || ticket.destination().equals(secondAirport))
            .collect(Collectors.toList());
    }
    
}
