package com.rstep1.app;

import java.util.List;

import com.rstep1.filemanager.JSONReader;
import com.rstep1.filter.FlightPointsFilter;
import com.rstep1.model.Ticket;

public class App {
    public static void main(String[] args) {
        FileReader<Ticket> fileReader = new JSONReader();
        List<Ticket> tickets = fileReader.read("tickets.json");
        TicketFilter ticketFilter = new FlightPointsFilter("VVO", "TLV");
        tickets = ticketFilter.filter(tickets);

        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
