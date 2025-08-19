package com.rstep1.app;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.rstep1.filemanager.JSONReader;
import com.rstep1.filter.FlightPointsFilter;
import com.rstep1.flight.FlightPriceAnalyzer;
import com.rstep1.flight.FlightTimeAnalyzer;
import com.rstep1.model.Ticket;
import com.rstep1.util.CommandArgumentParser;
import com.rstep1.util.ResultPrinter;

public class App {
    public static void main(String[] args) {
        Optional<String> maybePath = CommandArgumentParser.parseFilePath(args);
        if (!maybePath.isPresent()) return;

        String filePath = maybePath.get();
        FileReader<Ticket> fileReader = new JSONReader();
        List<Ticket> tickets = fileReader.read(filePath);
        
        TicketFilter ticketFilter = new FlightPointsFilter("VVO", "TLV");
        tickets = ticketFilter.filter(tickets);

        TimeAnalyzer flightTimeAnalyzer = new FlightTimeAnalyzer(tickets);
        Map<String, Duration> minFlightDurations = flightTimeAnalyzer.calculateMinFlightDurations();

        PriceAnalyzer priceAnalyzer = new FlightPriceAnalyzer(tickets);
        double averagePrice = priceAnalyzer.calculateAverage();
        double medianPrice = priceAnalyzer.calculateMedian();

        ResultPrinter.printFlightDurations(minFlightDurations);
        ResultPrinter.printDifferenceAverageMedianPrice(averagePrice, medianPrice);
    }
}
