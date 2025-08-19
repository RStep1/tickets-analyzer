package com.rstep1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Ticket (
    @JsonProperty("origin") String origin,
    @JsonProperty("origin_name")String originName,
    @JsonProperty("destination") String destination,
    @JsonProperty("destination_name") String destinationName,
    @JsonProperty("departure_date") String departureDate,
    @JsonProperty("departure_time") String departureTime,
    @JsonProperty("arrival_date") String arrivalDate,
    @JsonProperty("arrival_time") String arrivalTime,
    @JsonProperty("carrier") String carrier,
    @JsonProperty("price") int price
) {}
