package com.urfan.project.decathlon.XmlMapping;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Competeter {

    List<Participant> participantList;

    public Competeter(){}

    public Competeter(List<Participant> participantList) {
        super();
        this.participantList = participantList;
    }
    @XmlElement
    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }


}
