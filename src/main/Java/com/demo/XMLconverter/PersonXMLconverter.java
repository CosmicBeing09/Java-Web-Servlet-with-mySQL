package com.demo.XMLconverter;

import com.demo.Wrapper.PersonWrapper;
import com.demo.model.Person;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class PersonXMLconverter {

   public String convertPersonListToXml(PersonWrapper personWrapper) throws JAXBException {
       JAXBContext jaxbContext = JAXBContext.newInstance(PersonWrapper.class);
       Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
       jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

       StringWriter sw = new StringWriter();
       jaxbMarshaller.marshal(personWrapper,sw);

       return sw.toString();
   }
}
