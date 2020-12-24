package ru.nsu.fit.morozov.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import org.xml.sax.SAXException;

public class Lab2 {
  public static void main(String[] args) {

    try (InputStream stream = new FileInputStream("app\\src\\main\\resources\\people.xml")) {
      List<Person> persons = new PeopleData().parse(stream);

      new XMLWriter().write("app\\src\\main\\resources\\people1.xml", "app\\src\\main\\resources\\people.xsd", persons);
    } catch (IOException | XMLStreamException | JAXBException | SAXException e) {
      e.printStackTrace();
    }

  }
}
