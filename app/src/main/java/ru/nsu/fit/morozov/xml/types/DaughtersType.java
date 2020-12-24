package ru.nsu.fit.morozov.xml.types;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "daughters-type")
public class DaughtersType {
  private List<ReferenceType> daughters = new ArrayList<>();

  @XmlElement(name = "daughter")
  public void setDaughters(List<ReferenceType> daughters) {
    this.daughters = daughters;
  }

  public List<ReferenceType> getDaughters() {
    return daughters;
  }
}
