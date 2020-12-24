package ru.nsu.fit.morozov.xml.types;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "sons-type")
public class SonsType {
  private List<ReferenceType> sons = new ArrayList<>();

  @XmlElement(name = "son")
  public void setSons(List<ReferenceType> sons) {
    this.sons = sons;
  }

  public List<ReferenceType> getSons() {
    return sons;
  }
}
