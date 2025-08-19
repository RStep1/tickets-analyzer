package com.rstep1.flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rstep1.app.Analyzer;
import com.rstep1.model.Ticket;

public class FlightTimeAnalyzer implements Analyzer {
    private final List<Ticket> tickets;
    private final Map<String, String> minFlightTimes = new HashMap<>();

    public FlightTimeAnalyzer(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public void analyze() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'analyze'");
    }

    private void calculateMinTimes() {
        
    }

    public Map<String, String> getMinFlightTimes() {
        return minFlightTimes;
    }
}
