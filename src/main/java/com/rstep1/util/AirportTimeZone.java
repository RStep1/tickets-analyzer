package com.rstep1.util;

import java.util.HashMap;
import java.util.Map;

public class AirportTimeZone {
    private static final Map<String, Integer> timeZones = new HashMap<>();

    static {
        timeZones.put("VVO", 10);
        timeZones.put("TLV", 3);
    }

    public static int getUtcOffset(String IATA) {
        if (!timeZones.containsKey(IATA)) {
            throw new IllegalArgumentException(String.format("IATA code {} does not exist", IATA));
        }
        return timeZones.get(IATA); 
    }
}
