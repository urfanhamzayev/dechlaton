package com.urfan.project.decathlon.utils;

import com.urfan.project.decathlon.XmlMapping.Competeter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlConverter implements XmlFileConverter {

    public static void xmlConverter(final Competeter competeter,final String path) throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(Competeter.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshallerObj.marshal(competeter, new FileOutputStream(path));
        marshallerObj.marshal(competeter, System.out);

    }

    public static Competeter xmlConverterUnmarshaling(final String path) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Competeter.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Competeter competeter = (Competeter) jaxbUnmarshaller.unmarshal(new File(path));
        return competeter;
    }
}
