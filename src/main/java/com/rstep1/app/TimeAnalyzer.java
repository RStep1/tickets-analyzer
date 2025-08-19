package com.rstep1.app;

import java.time.Duration;
import java.util.Map;

public interface TimeAnalyzer {
    Map<String, Duration> calculateMinFlightDurations();
}
