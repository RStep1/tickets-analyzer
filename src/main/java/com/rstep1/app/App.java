package com.rstep1.app;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import com.rstep1.filemanager.JSONReader;
import com.rstep1.filter.FlightPointsFilter;
import com.rstep1.flight.FlightPriceAnalyzer;
import com.rstep1.flight.FlightTimeAnalyzer;
import com.rstep1.model.Ticket;
import com.rstep1.util.CommandArgumentParser;
import com.rstep1.util.ResultPrinter;

public class App {
    public static void main(String[] args) {
        String filePath = "";
        try {
            filePath = CommandArgumentParser.parseFilePath(args);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return;
        }

        FileReader<Ticket> fileReader = new JSONReader();
        List<Ticket> tickets;
        try {
            tickets = fileReader.read(filePath);
        } catch (IOException e) {
            System.err.println(String.format("Ошибка: не удалось прочитать файл %s. Проверьте корректность данных. " + e.getMessage(), filePath));
            return;
        }

        TicketFilter ticketFilter = new FlightPointsFilter("VVO", "TLV");
        tickets = ticketFilter.filter(tickets);

        TimeAnalyzer flightTimeAnalyzer = new FlightTimeAnalyzer(tickets);
        Map<String, Duration> minFlightDurations = flightTimeAnalyzer.calculateMinFlightDurations();

        PriceAnalyzer priceAnalyzer = new FlightPriceAnalyzer(tickets);
        double averagePrice = 0, medianPrice = 0;
        try {
            averagePrice = priceAnalyzer.calculateAverage();
            medianPrice = priceAnalyzer.calculateMedian();
        } catch (IllegalStateException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return;
        }
        
        ResultPrinter.printFlightDurations(minFlightDurations);
        ResultPrinter.printDifferenceAverageMedianPrice(averagePrice, medianPrice);
    }
}
