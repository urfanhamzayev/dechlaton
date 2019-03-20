package com.urfan.project.decathlon.XmlMapping;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Participant  {
    private String name;
    private String place;
    private String points;
    private Result result ;

    public Participant(){

    }

    public Participant(String name, String place, String points, Result result) {
        super();
        this.name = name;
        this.place = place;
        this.points = points;
        this.result = result;
    }
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    @XmlElement
    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    @XmlElement
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }


}
