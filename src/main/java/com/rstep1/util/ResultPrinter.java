package com.rstep1.util;

import java.time.Duration;
import java.util.Map;

public class ResultPrinter {
    public static void printFlightDurations(Map<String, Duration> minFlightDurations) {
        System.out.println("Минимальное время полёта между Владивостоком и Тель-Авивом:");        
        minFlightDurations.forEach((carrier, duration) -> {
            long hours = duration.toHours();
            long minutes = duration.toMinutesPart();
            System.out.printf("%-3s: %d ч %02d мин%n", carrier, hours, minutes);
        });
        
    }

    public static void printDifferenceAverageMedianPrice(double average, double median) {
        System.out.println("Разница между средней ценой и медианой:");
        System.out.println(average - median);
    }
}
