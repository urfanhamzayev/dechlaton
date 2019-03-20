package com.urfan.project.decathlon.Data;

import com.urfan.project.decathlon.data.Event;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class EventTest {

    @Test
    public void getPointsTest() {
        assertEquals(Event.EVENT_100M.toString(), new BigDecimal(536), Event.EVENT_100M.getPoints("12.61"));
        assertEquals(Event.EVENT_LONG_JUMP.toString(), new BigDecimal(382), Event.EVENT_LONG_JUMP.getPoints("5.00"));
        assertEquals(Event.EVENT_SHOT_PUT.toString(), new BigDecimal(439), Event.EVENT_SHOT_PUT.getPoints("9.22"));
        assertEquals(Event.EVENT_HIGH_JUMP.toString(), new BigDecimal(389), Event.EVENT_HIGH_JUMP.getPoints("1.50"));
        assertEquals(Event.EVENT_400M.toString(), new BigDecimal(400), Event.EVENT_400M.getPoints("60.39"));
        assertEquals(Event.EVENT_110M_HURDLES.toString(), new BigDecimal(685), Event.EVENT_110M_HURDLES.getPoints("16.43"));
        assertEquals(Event.EVENT_DISCUS_THROW.toString(), new BigDecimal(302), Event.EVENT_DISCUS_THROW.getPoints("21.60"));
        assertEquals(Event.EVENT_POLE_VAULT.toString(), new BigDecimal(264), Event.EVENT_POLE_VAULT.getPoints("2.60"));
        assertEquals(Event.EVENT_1500M.toString(), new BigDecimal(421), Event.EVENT_1500M.getPoints("5.25.72"));
    }
}
