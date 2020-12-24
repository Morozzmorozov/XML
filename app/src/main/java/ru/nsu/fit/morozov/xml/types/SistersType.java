package ru.nsu.fit.morozov.xml.types;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "sisters-type")
public class SistersType {
  private List<ReferenceType> sisters = new ArrayList<>();

  @XmlElement(name = "sister")
  public void setSisters(List<ReferenceType> sisters) {
    this.sisters = sisters;
  }

  public List<ReferenceType> getSisters() {
    return sisters;
  }
}
