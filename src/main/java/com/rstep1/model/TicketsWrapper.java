package com.rstep1.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TicketsWrapper (
    @JsonProperty("tickets") List<Ticket> tickets
) {}
