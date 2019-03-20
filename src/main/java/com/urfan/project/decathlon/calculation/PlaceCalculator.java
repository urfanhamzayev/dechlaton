package com.urfan.project.decathlon.calculation;

import com.urfan.project.decathlon.data.Athlete;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlaceCalculator {

    public static Map<String, String> getPlaces(List<Athlete> source) {
        Map<String, String> places = new LinkedHashMap<>();
        long place = 1;
        long startPlace = place;
        Map<BigDecimal, List<Athlete>> pointCounts = source.stream().collect(Collectors.groupingBy(Athlete::getTotalPoints));
        Map<BigDecimal, List<Athlete>> sortedByPoints = pointCounts.entrySet().stream()
                .sorted(Map.Entry.<BigDecimal, List<Athlete>>comparingByKey()
                        .reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<BigDecimal, List<Athlete>> entry : sortedByPoints.entrySet()) {
            if (entry.getValue().size() > 1) {
                int excludeLastOne = 1;
                String competitorsPlace = formatCompetitorPlaceValue(startPlace, entry, excludeLastOne);
                places.putAll(entry.getValue().stream().collect(Collectors.toMap(Athlete::getName, c -> competitorsPlace)));
                place = startPlace + entry.getValue().size();
            } else {
                places.put(entry.getValue().get(0).getName(), Long.toString(place));
                startPlace = ++place;
            }
        }
        return places;
    }
    public static Map<String, BigDecimal> getPoints(List<Athlete> source) {
      //  Map<String,String> points = new LinkedHashMap<>();
        Map<String,BigDecimal> point1=  source.stream().collect(Collectors.toMap(Athlete::getName,Athlete::getTotalPoints));
        return point1 ;
    }

    private static String formatCompetitorPlaceValue(long startPlace, Map.Entry<BigDecimal, List<Athlete>> entry, int excludeLastOne) {
        return startPlace + "-" + (startPlace + entry.getValue().size() - excludeLastOne);
    }
}
