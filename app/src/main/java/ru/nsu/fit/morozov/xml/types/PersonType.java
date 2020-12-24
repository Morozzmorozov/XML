package ru.nsu.fit.morozov.xml.types;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")
@XmlType(propOrder = { "id", "name", "gender", "spouse", "father", "mother", "brothers", "sisters", "sons", "daughters" })
public class PersonType {
  protected String id;
  protected String name;
  protected String gender;
  protected ReferenceType spouse;
  protected ReferenceType father;
  protected ReferenceType mother;
  protected BrothersType brothers;
  protected SistersType sisters;
  protected SonsType sons;
  protected DaughtersType daughters;

  @XmlID
  @XmlAttribute(name = "id", required = true)
  public void setId(String id) {
    this.id = id;
  }

  @XmlAttribute(name = "name", required = true)
  public void setName(String name) {
    this.name = name;
  }

  @XmlAttribute(name = "gender", required = true)
  public void setGender(String gender) {
    this.gender = gender;
  }

  @XmlElement(name = "spouse")
  public void setSpouse(ReferenceType spouse) {
    this.spouse = spouse;
  }

  @XmlElement(name = "father")
  public void setFather(ReferenceType father) {
    this.father = father;
  }

  @XmlElement(name = "mother")
  public void setMother(ReferenceType mother) {
    this.mother = mother;
  }

  @XmlElement(name = "brothers")
  public void setBrothers(BrothersType brothers) {
    this.brothers = brothers;
  }

  @XmlElement(name = "sisters")
  public void setSisters(SistersType sisters) {
    this.sisters = sisters;
  }

  @XmlElement(name = "sons")
  public void setSons(SonsType sons) {
    this.sons = sons;
  }

  @XmlElement(name = "daughters")
  public void setDaughters(DaughtersType daughters) {
    this.daughters = daughters;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public ReferenceType getSpouse() {
    return spouse;
  }

  public ReferenceType getFather() {
    return father;
  }

  public ReferenceType getMother() {
    return mother;
  }

  public BrothersType getBrothers() {
    return brothers;
  }

  public SistersType getSisters() {
    return sisters;
  }

  public SonsType getSons() {
    return sons;
  }

  public DaughtersType getDaughters() {
    return daughters;
  }
}
