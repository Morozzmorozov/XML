package ru.nsu.fit.morozov.xml.types;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "people", namespace = "http://fit.nsu.ru/people")
public class PeopleType {
  protected List<PersonType> persons;

  @XmlElement(name = "person")
  public void setPersons(List<PersonType> persons) {
    this.persons = persons;
  }

  public List<PersonType> getPersons() {
    return persons;
  }
}
