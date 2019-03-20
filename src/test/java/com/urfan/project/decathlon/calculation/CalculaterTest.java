package com.urfan.project.decathlon.calculation;

import com.urfan.project.decathlon.data.Athlete;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;

import static com.urfan.project.decathlon.data.Event.*;
import static org.junit.Assert.assertEquals;

public class CalculaterTest {
    private List<Athlete> result = new ArrayList<>();

    @Before
    public void setUp() throws IOException {
        List<Enum> keys = Arrays.asList(EVENT_100M, EVENT_LONG_JUMP , EVENT_SHOT_PUT , EVENT_HIGH_JUMP , EVENT_400M ,
                EVENT_110M_HURDLES , EVENT_DISCUS_THROW , EVENT_POLE_VAULT , EVENT_JAVELIN_THROW , EVENT_1500M );
      
        List<String> values = Arrays.asList("13.75","4.84", "10.12","1.50","68.44","19.18","30.85","2.80","33.88","6.22.75");
        List<String> values2 = Arrays.asList("20.00","2.00", "15.00","1.80","80.00","25.00","23.25","2.20","33.48","6.51.01");
        List<String> values3 = Arrays.asList("20.00","2.00", "15.00","1.80","80.00","25.00","23.25","2.20","33.48","6.51.01");

        Map<String, String> events1 = IntStream.range(0, keys.size())
                .collect(
                        HashMap::new,
                        (m, i) -> m.put(keys.get(i).toString(), values.get(i)),
                        Map::putAll
                );
        Athlete athlete1 = new Athlete("Beata Kana", events1);


        Map<String, String> events2 = IntStream.range(0, keys.size())
                .collect(
                        HashMap::new,
                        (m, i) -> m.put(keys.get(i).toString(), values2.get(i)),
                        Map::putAll
                );
        Athlete athlete2 = new Athlete("John Braun", events2);


        Map<String, String> events3 = IntStream.range(0, keys.size())
                .collect(
                        HashMap::new,
                        (m, i) -> m.put(keys.get(i).toString(), values3.get(i)),
                        Map::putAll
                );
        Athlete athlete3 = new Athlete("Kate Flora", events3);

        result =Arrays.asList(athlete1,athlete2,athlete3);

    }

    @Test
    public void getPlacesTest() {
        Map<String, String> places = PlaceCalculator.getPlaces(result);
        assertEquals(3, result.size());
        assertEquals("2-3", places.get("John Braun"));
        assertEquals("2-3", places.get("Kate Flora"));
        assertEquals("1", places.get("Beata Kana"));
        }
    @Test
     public void getPointsTest(){
       Map<String,BigDecimal> pooints =PlaceCalculator.getPoints(result);
       assertEquals(3,result.size());
        assertEquals(BigDecimal.valueOf(2441),pooints.get("John Braun"));
        assertEquals(BigDecimal.valueOf(2441),pooints.get("Kate Flora"));
        assertEquals(BigDecimal.valueOf(3494),pooints.get("Beata Kana"));
     }
}
