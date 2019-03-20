package com.urfan.project.decathlon.Utils;

import com.urfan.project.decathlon.XmlMapping.Competeter;
import com.urfan.project.decathlon.XmlMapping.Participant;
import com.urfan.project.decathlon.calculation.PlaceCalculator;
import com.urfan.project.decathlon.data.Athlete;
import com.urfan.project.decathlon.parser.AthletesParser;
import com.urfan.project.decathlon.utils.CSVReader;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.urfan.project.decathlon.XmlMapping.Result.getResult;
import static com.urfan.project.decathlon.utils.XmlConverter.xmlConverter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class XmlConverterTest {

    private File file;
    private String directory = "testData.xml";
    private Competeter competeter =null;

    @Before
    public void setUp() throws IOException, JAXBException {
        ClassLoader classLoader = getClass().getClassLoader();
        file  = new File(classLoader.getResource("testData.txt").getFile());

        List<List<String>> result = new CSVReader().loadFile(file.getAbsolutePath());
        List<Athlete> calculatedData = new AthletesParser().parseAthletes(result);
        Map<String,String> placeList = PlaceCalculator.getPlaces(calculatedData);
        Map<String, BigDecimal> pointList = PlaceCalculator.getPoints(calculatedData);
        List<Participant> participants = calculatedData.stream().
                map(iter->new Participant(
                        iter.getName(),
                        pointList.get(iter.getName()).toString(),
                        placeList.get(iter.getName()),
                        getResult(iter.getName() ,  calculatedData )
                )).collect(Collectors.toList());
        participants.sort((Participant s1, Participant s2)->s2.getPlace().compareTo(s1.getPlace()));

         competeter = new Competeter(participants);


        xmlConverter(competeter,directory);
    }

    @Test
    public void loadFileTest() throws IOException {
       assertEquals(5,competeter.getParticipantList().size());
       assertEquals("Siim Susi",competeter.getParticipantList().get(0).getName());
       assertEquals("4200",competeter.getParticipantList().get(0).getPlace());
       assertEquals("1",competeter.getParticipantList().get(0).getPoints());
    }

}
