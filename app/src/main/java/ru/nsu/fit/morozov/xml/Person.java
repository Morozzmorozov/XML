package ru.nsu.fit.morozov.xml;

import java.util.HashSet;
import java.util.Set;

public class Person {
  private String id;
  private String firstName;
  private String lastName;
  private String gender;

  private Set<String> parentsId = new HashSet<>();
  private String motherId;
  private String fatherId;
  private Set<String> parentsName = new HashSet<>();
  private String motherName;
  private String fatherName;

  private Set<String> siblingsId = new HashSet<>();
  private Set<String> brothersId = new HashSet<>();
  private Set<String> sistersId = new HashSet<>();
  private Set<String> siblingsName = new HashSet<>();
  private Set<String> brothersName = new HashSet<>();
  private Set<String> sistersName = new HashSet<>();

  private Set<String> kidsId = new HashSet<>();
  private Set<String> sonsId = new HashSet<>();
  private Set<String> daughtersId = new HashSet<>();
  private Set<String> kidsName = new HashSet<>();
  private Set<String> sonsName = new HashSet<>();
  private Set<String> daughtersName = new HashSet<>();

  private String spouseId;
  private String husbandId;
  private String wifeId;
  private String spouseName;
  private String husbandName;
  private String wifeName;

  private int kidsCount = -1;
  private int siblingsCount = -1;

  public void merge(Person other) {
    if (id == null) {
      id = other.getId();
    }

    if (firstName == null) {
      firstName = other.getFirstName();
    }

    if (lastName == null) {
      lastName = other.getLastName();
    }

    if (gender == null) {
      gender = other.getGender();
    }

    if (motherId == null) {
      motherId = other.getMotherId();
    }

    if (fatherId == null) {
      fatherId = other.getFatherId();
    }

    if (motherName == null) {
      motherName = other.getMotherName();
    }

    if (fatherName == null) {
      fatherName = other.getFatherName();
    }

    if (spouseId == null) {
      spouseId = other.getSpouseId();
    }

    if (wifeId == null) {
      wifeId = other.getWifeId();
    }

    if (husbandId == null) {
      husbandId = other.getHusbandId();
    }

    if (spouseName == null) {
      spouseName = other.getSpouseName();
    }

    if (wifeName == null) {
      wifeName = other.getWifeName();
    }

    if (husbandName == null) {
      husbandName = other.getHusbandName();
    }

    if (kidsCount == -1) {
      kidsCount = other.getKidsCount();
    }

    if (siblingsCount == -1) {
      siblingsCount = other.getSiblingsCount();
    }

    parentsId.addAll(other.getParentsId());
    parentsName.addAll(other.getParentsName());
    siblingsId.addAll(other.getSiblingsId());
    brothersId.addAll(other.getBrothersId());
    sistersId.addAll(other.getSistersId());
    siblingsName.addAll(other.getSiblingsName());
    brothersName.addAll(other.getBrothersName());
    sistersName.addAll(other.getSistersName());
    kidsId.addAll(other.getKidsId());
    sonsId.addAll(other.getSonsId());
    daughtersId.addAll(other.getDaughtersId());
    kidsName.addAll(other.getKidsName());
    sonsName.addAll(other.getSonsName());
    daughtersName.addAll(other.getDaughtersName());
  }

  public String getFullName() {
    if (firstName == null || lastName == null) {
      return null;
    }
    return firstName + " " + lastName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Set<String> getParentsId() {
    return parentsId;
  }

  public void setParentsId(Set<String> parentsId) {
    this.parentsId = parentsId;
  }

  public String getMotherId() {
    return motherId;
  }

  public void setMotherId(String motherId) {
    this.motherId = motherId;
  }

  public String getFatherId() {
    return fatherId;
  }

  public void setFatherId(String fatherId) {
    this.fatherId = fatherId;
  }

  public Set<String> getParentsName() {
    return parentsName;
  }

  public void setParentsName(Set<String> parentsName) {
    this.parentsName = parentsName;
  }

  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public Set<String> getSiblingsId() {
    return siblingsId;
  }

  public void setSiblingsId(Set<String> siblingsId) {
    this.siblingsId = siblingsId;
  }

  public Set<String> getBrothersId() {
    return brothersId;
  }

  public void setBrothersId(Set<String> brothersId) {
    this.brothersId = brothersId;
  }

  public Set<String> getSistersId() {
    return sistersId;
  }

  public void setSistersId(Set<String> sistersId) {
    this.sistersId = sistersId;
  }

  public Set<String> getSiblingsName() {
    return siblingsName;
  }

  public void setSiblingsName(Set<String> siblingsName) {
    this.siblingsName = siblingsName;
  }

  public Set<String> getBrothersName() {
    return brothersName;
  }

  public void setBrothersName(Set<String> brothersName) {
    this.brothersName = brothersName;
  }

  public Set<String> getSistersName() {
    return sistersName;
  }

  public void setSistersName(Set<String> sistersName) {
    this.sistersName = sistersName;
  }

  public Set<String> getKidsId() {
    return kidsId;
  }

  public void setKidsId(Set<String> kidsId) {
    this.kidsId = kidsId;
  }

  public Set<String> getSonsId() {
    return sonsId;
  }

  public void setSonsId(Set<String> sonsId) {
    this.sonsId = sonsId;
  }

  public Set<String> getDaughtersId() {
    return daughtersId;
  }

  public void setDaughtersId(Set<String> daughtersId) {
    this.daughtersId = daughtersId;
  }

  public Set<String> getKidsName() {
    return kidsName;
  }

  public void setKidsName(Set<String> kidsName) {
    this.kidsName = kidsName;
  }

  public Set<String> getSonsName() {
    return sonsName;
  }

  public void setSonsName(Set<String> sonsName) {
    this.sonsName = sonsName;
  }

  public Set<String> getDaughtersName() {
    return daughtersName;
  }

  public void setDaughtersName(Set<String> daughtersName) {
    this.daughtersName = daughtersName;
  }

  public String getSpouseId() {
    return spouseId;
  }

  public void setSpouseId(String spouseId) {
    this.spouseId = spouseId;
  }

  public String getHusbandId() {
    return husbandId;
  }

  public void setHusbandId(String husbandId) {
    this.husbandId = husbandId;
  }

  public String getWifeId() {
    return wifeId;
  }

  public void setWifeId(String wifeId) {
    this.wifeId = wifeId;
  }

  public String getSpouseName() {
    return spouseName;
  }

  public void setSpouseName(String spouseName) {
    this.spouseName = spouseName;
  }

  public String getHusbandName() {
    return husbandName;
  }

  public void setHusbandName(String husbandName) {
    this.husbandName = husbandName;
  }

  public String getWifeName() {
    return wifeName;
  }

  public void setWifeName(String wifeName) {
    this.wifeName = wifeName;
  }

  public int getKidsCount() {
    return kidsCount;
  }

  public void setKidsCount(int kidsCount) {
    this.kidsCount = kidsCount;
  }

  public int getSiblingsCount() {
    return siblingsCount;
  }

  public void setSiblingsCount(int siblingsCount) {
    this.siblingsCount = siblingsCount;
  }
}
