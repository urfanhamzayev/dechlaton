package com.urfan.project.decathlon.parser;


import com.urfan.project.decathlon.data.Athlete;
import com.urfan.project.decathlon.data.Event;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AthletesParserTest {

    private List<List<String>> data;

    @Before
    public void setUp() throws IOException {
        List<String> events = Arrays.asList("Jack John", "12.61","5.00","9.22","1.50","60.39","16.43","21.60","2.60","35.81","5.25.72");
        List<String> events1 = Arrays.asList("Beata Kana", "13.04","4.53","7.79","1.55","64.72","18.74","24.20","2.40","28.20","6.50.76");

      data = Arrays.asList(events,events1);


    }

    @Test
    public void loadAthletes () {
        List<Athlete> result = new AthletesParser().parseAthletes(data);
        assertEquals(2, result.size());
        assertEquals("Jack John", result.get(0).getName());
        assertEquals(10, result.get(0).getEvents().size());
        assertEquals("12.61", result.get(0).getEvents().get(Event.EVENT_100M.getName()));
        assertEquals("5.00", result.get(0).getEvents().get(Event.EVENT_LONG_JUMP.getName()));
        assertEquals("9.22", result.get(0).getEvents().get(Event.EVENT_SHOT_PUT.getName()));
        assertEquals("1.50", result.get(0).getEvents().get(Event.EVENT_HIGH_JUMP.getName()));
        assertEquals("60.39", result.get(0).getEvents().get(Event.EVENT_400M.getName()));
        assertEquals("16.43", result.get(0).getEvents().get(Event.EVENT_110M_HURDLES.getName()));
        assertEquals("21.60", result.get(0).getEvents().get(Event.EVENT_DISCUS_THROW.getName()));
        assertEquals("2.60", result.get(0).getEvents().get(Event.EVENT_POLE_VAULT.getName()));
        assertEquals("35.81", result.get(0).getEvents().get(Event.EVENT_JAVELIN_THROW.getName()));
        assertEquals("5.25.72", result.get(0).getEvents().get(Event.EVENT_1500M.getName()));
        assertEquals(new BigDecimal(4200), result.get(0).getTotalPoints());
    }
}
