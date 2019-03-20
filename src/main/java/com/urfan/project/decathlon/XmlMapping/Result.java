package com.urfan.project.decathlon.XmlMapping;

import com.urfan.project.decathlon.data.Athlete;
import com.urfan.project.decathlon.data.Event;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class Result {
    private String EVENT_100M;
    private String EVENT_LONG_JUMP;
    private String EVENT_SHOT_PUT;
    private String EVENT_HIGH_JUMP;
    private  String EVENT_400M;
    private String EVENT_110M_HURDLES;
    private String EVENT_DISCUS_THROW;
    private String EVENT_POLE_VAULT;
    private String EVENT_JAVELIN_THROW;
    private String EVENT_1500M;

    public Result(){}
    public Result(String EVENT_100M, String EVENT_LONG_JUMP, String EVENT_SHOT_PUT, String EVENT_HIGH_JUMP, String EVENT_400M, String EVENT_110M_HURDLES, String EVENT_DISCUS_THROW, String EVENT_POLE_VAULT, String EVENT_JAVELIN_THROW, String EVENT_1500M) {
        super();
        this.EVENT_100M = EVENT_100M;
        this.EVENT_LONG_JUMP = EVENT_LONG_JUMP;
        this.EVENT_SHOT_PUT = EVENT_SHOT_PUT;
        this.EVENT_HIGH_JUMP = EVENT_HIGH_JUMP;
        this.EVENT_400M = EVENT_400M;
        this.EVENT_110M_HURDLES = EVENT_110M_HURDLES;
        this.EVENT_DISCUS_THROW = EVENT_DISCUS_THROW;
        this.EVENT_POLE_VAULT = EVENT_POLE_VAULT;
        this.EVENT_JAVELIN_THROW = EVENT_JAVELIN_THROW;
        this.EVENT_1500M = EVENT_1500M;
    }

    @XmlElement(name = "_100_m")
    public String getEVENT_100M() {
        return EVENT_100M;
    }

    public void setEVENT_100M(String EVENT_100M) {
        this.EVENT_100M = EVENT_100M;
    }

    @XmlElement(name = "Long_jump")
    public String getEVENT_LONG_JUMP() {
        return EVENT_LONG_JUMP;
    }

    public void setEVENT_LONG_JUMP(String EVENT_LONG_JUMP) {
        this.EVENT_LONG_JUMP = EVENT_LONG_JUMP;
    }

    @XmlElement(name = "Shot_put")
    public String getEVENT_SHOT_PUT() {
        return EVENT_SHOT_PUT;
    }

    public void setEVENT_SHOT_PUT(String EVENT_SHOT_PUT) {
        this.EVENT_SHOT_PUT = EVENT_SHOT_PUT;
    }

    @XmlElement(name = "High_jump")
    public String getEVENT_HIGH_JUMP() {
        return EVENT_HIGH_JUMP;
    }

    public void setEVENT_HIGH_JUMP(String EVENT_HIGH_JUMP) {
        this.EVENT_HIGH_JUMP = EVENT_HIGH_JUMP;
    }

    @XmlElement(name = "_400_m")
    public String getEVENT_400M() {
        return EVENT_400M;
    }

    public void setEVENT_400M(String EVENT_400M) {
        this.EVENT_400M = EVENT_400M;
    }

    @XmlElement(name = "_110_m_hurdles")
    public String getEVENT_110M_HURDLES() {
        return EVENT_110M_HURDLES;
    }

    public void setEVENT_110M_HURDLES(String EVENT_110M_HURDLES) {
        this.EVENT_110M_HURDLES = EVENT_110M_HURDLES;
    }

    @XmlElement(name = "Discus_throw")
    public String getEVENT_DISCUS_THROW() {
        return EVENT_DISCUS_THROW;
    }

    public void setEVENT_DISCUS_THROW(String EVENT_DISCUS_THROW) {
        this.EVENT_DISCUS_THROW = EVENT_DISCUS_THROW;
    }

    @XmlElement(name = "Pole_vault")
    public String getEVENT_POLE_VAULT() {
        return EVENT_POLE_VAULT;
    }

    public void setEVENT_POLE_VAULT(String EVENT_POLE_VAULT) {
        this.EVENT_POLE_VAULT = EVENT_POLE_VAULT;
    }

    @XmlElement(name = "Javelin_throw")
    public String getEVENT_JAVELIN_THROW() {
        return EVENT_JAVELIN_THROW;
    }

    public void setEVENT_JAVELIN_THROW(String EVENT_JAVELIN_THROW) {
        this.EVENT_JAVELIN_THROW = EVENT_JAVELIN_THROW;
    }

    @XmlElement(name = "_1500_m")
    public String getEVENT_1500M() {
        return EVENT_1500M;
    }

    public void setEVENT_1500M(String EVENT_1500M) {
        this.EVENT_1500M = EVENT_1500M;
    }

    public static Result getResult(final String name , List<Athlete> calculatedData ){

        Result result = calculatedData.stream().filter(t -> t.getName().equals(name)).map(o ->
                new Result(o.getEvents().get(Event.EVENT_100M.getName()),
                        o.getEvents().get(Event.EVENT_LONG_JUMP.getName()),
                        o.getEvents().get(Event.EVENT_SHOT_PUT.getName()),
                        o.getEvents().get(Event.EVENT_HIGH_JUMP.getName()),
                        o.getEvents().get(Event.EVENT_400M.getName()),
                        o.getEvents().get(Event.EVENT_110M_HURDLES.getName()),
                        o.getEvents().get(Event.EVENT_DISCUS_THROW.getName()),
                        o.getEvents().get(Event.EVENT_POLE_VAULT.getName()),
                        o.getEvents().get(Event.EVENT_JAVELIN_THROW.getName()),
                        o.getEvents().get(Event.EVENT_1500M.getName()))).findFirst().orElse(null);

        return result;
    }
}
