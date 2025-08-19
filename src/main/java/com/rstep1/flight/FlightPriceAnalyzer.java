package com.rstep1.flight;

import java.util.List;

import com.rstep1.app.PriceAnalyzer;
import com.rstep1.model.Ticket;

public class FlightPriceAnalyzer implements PriceAnalyzer {
    private final List<Ticket> tickets;

    public FlightPriceAnalyzer(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    @Override
    public double calculateAverage() {
        if (tickets.size() == 0) return 0;

        long sum = 0;
        for (Ticket ticket : tickets) {
            sum += ticket.price();
        }
        return (double) sum / tickets.size();
    }

    @Override
    public double calculateMedian() {
        if (tickets.size() == 0) return 0;
        
        List<Integer> prices = tickets.stream().map(Ticket::price).sorted().toList();
        int size = prices.size();
        if (size % 2 == 0) {
            return (prices.get(size / 2) + prices.get(size / 2 - 1)) / 2.0;
        }
        return prices.get(size / 2);
    }
    
}
