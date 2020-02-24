package com.demo.XMLconverter;

import com.demo.Wrapper.PersonWrapper;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;


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
