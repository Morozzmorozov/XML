package ru.nsu.fit.morozov.xml.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "brothers-type")
public class BrothersType {
  private List<ReferenceType> brothers = new ArrayList<>();

  @XmlElement(name = "brother")
  public void setBrothers(List<ReferenceType> brothers) {
    this.brothers = brothers;
  }

  public List<ReferenceType> getBrothers() {
    return brothers;
  }
}
