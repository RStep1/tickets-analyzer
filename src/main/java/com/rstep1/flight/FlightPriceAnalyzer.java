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
        if (tickets.size() == 0) {
            throw new IllegalStateException("Невозможно вычислить среднее для пустого списка");
        }

        long sum = 0;
        for (Ticket ticket : tickets) {
            sum += ticket.price();
        }
        return (double) sum / tickets.size();
    }

    @Override
    public double calculateMedian() {
        if (tickets.size() == 0) {
            throw new IllegalStateException("Невозможно вычислить медиану для путого списка");
        }
        
        List<Integer> prices = tickets.stream().map(Ticket::price).sorted().toList();
        int size = prices.size();
        int middleIndex = size / 2;
        if (size % 2 == 0) {
            return (prices.get(middleIndex) + prices.get(middleIndex - 1)) / 2.0;
        }
        return prices.get(middleIndex);
    }
    
}
