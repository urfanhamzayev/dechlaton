package com.urfan.project.decathlon.data;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Athlete implements Comparable<Athlete> {
    private final String name;
    private Map<String, String> events = new LinkedHashMap<>();

    public Athlete(String name, Map<String, String> events) {
        this.name = name;
        this.events = events;
    }

    public Map<String, String> getEvents() {
        return events;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Athlete a) {
        return getTotalPoints().compareTo(a.getTotalPoints());
    }

    public BigDecimal getTotalPoints() {
        return events.entrySet().stream().map(e -> Event.fromString(e.getKey()).get().getPoints(e.getValue())).reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
    }
}
