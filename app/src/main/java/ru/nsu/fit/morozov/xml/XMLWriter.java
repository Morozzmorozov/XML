package ru.nsu.fit.morozov.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import ru.nsu.fit.morozov.xml.types.BrothersType;
import ru.nsu.fit.morozov.xml.types.DaughtersType;
import ru.nsu.fit.morozov.xml.types.PeopleType;
import ru.nsu.fit.morozov.xml.types.PersonType;
import ru.nsu.fit.morozov.xml.types.ReferenceType;
import ru.nsu.fit.morozov.xml.types.SistersType;
import ru.nsu.fit.morozov.xml.types.SonsType;

public class XMLWriter {


  public void write(String filename, String schema, List<Person> persons) throws SAXException, JAXBException {
    Map<String, PersonType> idMap = new HashMap<>();
    for (Person person : persons) {
      idMap.put(person.getId(), new PersonType());
    }

    for (Person person : persons) {
      PersonType personType = idMap.get(person.getId());

      personType.setId(person.getId());
      personType.setName(person.getFullName());
      personType.setGender(person.getGender());

      if (person.getFatherId() != null) {
        ReferenceType reference = new ReferenceType();
        reference.setId(idMap.get(person.getFatherId()));
        personType.setFather(reference);
      }

      if (person.getMotherId() != null) {
        ReferenceType reference = new ReferenceType();
        reference.setId(idMap.get(person.getMotherId()));
        personType.setMother(reference);
      }

      if (person.getHusbandId() != null) {
        ReferenceType reference = new ReferenceType();
        reference.setId(idMap.get(person.getHusbandId()));
        personType.setSpouse(reference);
      }

      if (person.getWifeId() != null) {
        ReferenceType reference = new ReferenceType();
        reference.setId(idMap.get(person.getWifeId()));
        personType.setSpouse(reference);
      }

      BrothersType brothersType = new BrothersType();
      for (String id : person.getBrothersId()) {
        ReferenceType referenceType = new ReferenceType();
        referenceType.setId(idMap.get(id));
        brothersType.getBrothers().add(referenceType);
      }
      personType.setBrothers(brothersType);


      SistersType sistersType = new SistersType();
      for (String id : person.getSistersId()) {
        ReferenceType referenceType = new ReferenceType();
        referenceType.setId(idMap.get(id));
        sistersType.getSisters().add(referenceType);
      }


      SonsType sonsType = new SonsType();
      for (String id : person.getSonsId()) {
        ReferenceType referenceType = new ReferenceType();
        referenceType.setId(idMap.get(id));
        sonsType.getSons().add(referenceType);
      }


      DaughtersType daughtersType = new DaughtersType();
      for (String id : person.getDaughtersId()) {
        ReferenceType referenceType = new ReferenceType();
        referenceType.setId(idMap.get(id));
        daughtersType.getDaughters().add(referenceType);
      }
      personType.setDaughters(daughtersType);

    }


    PeopleType peopleType = new PeopleType();
    peopleType.setPersons(new ArrayList<>(idMap.values()));

    JAXBContext jc = JAXBContext.newInstance(PeopleType.class);
    Marshaller writer = jc.createMarshaller();
    SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
    writer.setSchema(schemaFactory.newSchema(new File(schema)));
    writer.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    writer.marshal(peopleType, new File(filename));
  }


}
