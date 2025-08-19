package com.rstep1.app;

import java.util.List;

import com.rstep1.model.Ticket;

public interface TicketFilter {
    List<Ticket> filter(List<Ticket> tickets);
}
