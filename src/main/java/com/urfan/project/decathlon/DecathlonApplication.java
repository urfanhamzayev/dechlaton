package com.urfan.project.decathlon;

import com.urfan.project.decathlon.XmlMapping.Competeter;
import com.urfan.project.decathlon.XmlMapping.Participant;
import com.urfan.project.decathlon.calculation.PlaceCalculator;
import com.urfan.project.decathlon.data.Athlete;
import com.urfan.project.decathlon.parser.AthletesParser;
import com.urfan.project.decathlon.utils.CSVReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.urfan.project.decathlon.XmlMapping.Result.getResult;
import static com.urfan.project.decathlon.utils.XmlConverter.xmlConverter;

@SpringBootApplication
public class DecathlonApplication {

	public static void main(String[] args) throws IOException, JAXBException {
		//SpringApplication.run(DecathlonApplication.class, args);

		 String directory = "competeter.xml";
		ClassLoader classLoader = DecathlonApplication.class.getClassLoader();

		File inputDataFile =   new File(classLoader.getResource("resultTestMock.csv").getFile()); //new File(args[0]);

		List<List<String>> result = new CSVReader().loadFile(inputDataFile.getAbsolutePath());
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

		Competeter competeter = new Competeter(participants);


		xmlConverter(competeter,directory);



	}

}
