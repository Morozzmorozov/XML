package ru.nsu.fit.morozov.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class PeopleData {
  public List<Person> parse(InputStream stream) throws XMLStreamException {
    List<Person> peopleList = new ArrayList<>();
    XMLInputFactory streamFactory = XMLInputFactory.newInstance();
    XMLStreamReader reader = streamFactory.createXMLStreamReader(stream);
    Person person = null;
    while (reader.hasNext()) {
      reader.next();
      int eventType = reader.getEventType();
      List<String> name;
      switch (eventType) {
        case XMLStreamConstants.START_ELEMENT:
          switch (reader.getLocalName()) {
            case "person":
              person = new Person();
              for (int i = 0; i < reader.getAttributeCount(); i++) {

                switch (reader.getAttributeLocalName(i)) {
                  case "id":
                    person.setId(reader.getAttributeValue(i).trim());

                    break;
                  case "name":
                    name = Arrays.stream(reader.getAttributeValue(i).split(" "))
                        .filter((x) -> x.length() > 0).collect(Collectors.toList());
                    person.setFirstName(name.get(0));
                    person.setLastName(name.get(1));

                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "id":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "value":
                    person.setId(reader.getAttributeValue(i).trim());

                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "firstname":
              if (reader.getAttributeCount() == 0 ) {
                reader.next();
                person.setFirstName(reader.getText().trim());
              } else {
                for (int i = 0; i < reader.getAttributeCount(); i++) {
                  switch (reader.getAttributeLocalName(i)) {
                    case "value":
                      person.setFirstName(reader.getAttributeValue(i).trim());
                      break;
                    default:
                      System.out.println(reader.getLocalName() + " has unknown attribute: " + reader
                          .getAttributeLocalName(i));
                  }
                }
              }
              break;
            case "surname":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "value":
                    person.setLastName(reader.getAttributeValue(i).trim());
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "family-name":
            case "family":
              reader.next();
              person.setLastName(reader.getText().trim());
              break;
            case "fullname":
            case "children":
              break;
            case "first":
              reader.next();
              person.setFirstName(reader.getText().trim());
              break;
            case "gender":
              if (reader.getAttributeCount() > 0) {
                for (int i = 0; i < reader.getAttributeCount(); i++) {
                  switch (reader.getAttributeLocalName(i)) {
                    case "value":
                      person.setGender(
                          reader.getAttributeValue(i).trim().toUpperCase().substring(0, 1));
                      break;
                    default:
                      System.out.println(reader.getLocalName() + " has unknown attribute: " + reader
                          .getAttributeLocalName(i));
                  }
                }
              } else {
                reader.next();
                person.setGender(
                    reader.getText().trim().toUpperCase().substring(0, 1));
              }

              break;
            case "spouce":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "value":
                    if (!reader.getAttributeValue(i).trim().equals("NONE")) {
                      name = Arrays.stream(reader.getAttributeValue(i).split(" "))
                          .filter((x) -> x.length() > 0).collect(Collectors.toList());
                      person.setSpouseName(name.get(0) + " " + name.get(1));
                    }
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              if (reader.hasText()) {
                if (!reader.getText().trim().equals("NONE")) {
                  name = Arrays.stream(reader.getText().split(" "))
                      .filter((x) -> x.length() > 0).collect(Collectors.toList());
                  person.setSpouseName(name.get(0) + " " + name.get(1));
                }
              }
              break;
            case "husband":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "value":
                    person.setHusbandId(reader.getAttributeValue(i).trim());
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "wife":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "value":
                    person.setWifeId(reader.getAttributeValue(i).trim());
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "siblings":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "val":
                    List<String> siblings = Arrays.stream(reader.getAttributeValue(i).split(" "))
                        .filter((x) -> x.length() > 0).collect(Collectors.toList());
                    person.getSiblingsId().addAll(siblings);
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "brother":
              reader.next();
              name = Arrays.stream(reader.getText().split(" "))
                  .filter((x) -> x.length() > 0).collect(Collectors.toList());
              person.getBrothersName().add(name.get(0) + " " + name.get(1));
              break;
            case "sister":
              reader.next();
              name = Arrays.stream(reader.getText().split(" "))
                  .filter((x) -> x.length() > 0).collect(Collectors.toList());
              person.getSistersName().add(name.get(0) + " " + name.get(1));
              break;
            case "siblings-number":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "value":
                    person.setSiblingsCount(Integer.parseInt(reader.getAttributeValue(i).trim()));
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "child":
              reader.next();
              name = Arrays.stream(reader.getText().split(" "))
                  .filter((x) -> x.length() > 0).collect(Collectors.toList());
              person.getKidsName().add(name.get(0) + " " + name.get(1));
              break;
            case "son":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "id":
                    person.getSonsId().add(reader.getAttributeValue(i).trim());
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "daughter":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "id":
                    person.getDaughtersId().add(reader.getAttributeValue(i).trim());
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "parent":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "value":
                    if (!reader.getAttributeValue(i).trim().equals("UNKNOWN")) {
                      person.getParentsId().add(reader.getAttributeValue(i).trim());
                    }
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "father":
              reader.next();
              name = Arrays.stream(reader.getText().split(" "))
                  .filter((x) -> x.length() > 0).collect(Collectors.toList());
              person.setFatherName(name.get(0) + " " + name.get(1));
              break;
            case "mother":
              reader.next();
              name = Arrays.stream(reader.getText().split(" "))
                  .filter((x) -> x.length() > 0).collect(Collectors.toList());
              person.setMotherName(name.get(0) + " " + name.get(1));
              break;
            case "children-number":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "value":
                    person.setKidsCount(Integer.parseInt(reader.getAttributeValue(i).trim()));
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            case "people":
              for (int i = 0; i < reader.getAttributeCount(); i++) {
                switch (reader.getAttributeLocalName(i)) {
                  case "count":
                    System.out.println("Total people count: " + reader.getAttributeValue(i));
                    break;
                  default:
                    System.out.println(reader.getLocalName() + " has unknown attribute: " + reader.getAttributeLocalName(i));
                }
              }
              break;
            default:
              System.out.println("Unknown node: " + reader.getLocalName());
          }
          break;
        case XMLStreamConstants.END_ELEMENT:
          switch (reader.getLocalName()) {
            case "person":
              peopleList.add(person);
              person = null;
              break;
            default:
          }
          break;
        default:
      }
    }

    reader.close();

    Map<String, Person> idMap = new HashMap<>();
    Map<String, Person> nameMap = new HashMap<>();
    List<Person> conflicts = new ArrayList<>();
    List<String> invalidIds = new ArrayList<>();
    List<String> invalidNames = new ArrayList<>();

    for (Person p : peopleList) {
      if (p.getId() != null) {
        if (idMap.containsKey(p.getId())) {
          idMap.get(p.getId()).merge(p);
          p.merge(idMap.get(p.getId()));
        } else {
          idMap.put(p.getId(), p);
        }
      }

      if (p.getFullName() != null) {
        if (nameMap.containsKey(p.getFullName())) {
          Person savedPerson = nameMap.get(p.getFullName());
          if (savedPerson.getId() != null && p.getId() != null && !savedPerson.getId().equals(p.getId())) {
            conflicts.add(savedPerson);
            conflicts.add(p);
          } else {
            savedPerson.merge(p);
            p.merge(savedPerson);
          }
        } else {
          nameMap.put(p.getFullName(), p);
        }
      }
    }

    for (Person p : idMap.values()) {
      if (p.getFullName() != null) {
        p.merge(nameMap.get(p.getFullName()));
        nameMap.get(p.getFullName()).merge(p);
      }
    }

    for (Person p : conflicts) {
      idMap.remove(p.getId());
      nameMap.remove(p.getFullName());
      invalidIds.add(p.getId());
      invalidNames.add(p.getFullName());
    }

    boolean correct = true;

    for (Person p : idMap.values()) {
      if (p.getGender().equals("M")) {
        if (p.getWifeId() != null && p.getSpouseName() == null) {
          Person wife = idMap.get(p.getWifeId());
          if (wife != null) {
            p.setSpouseName(wife.getFullName());
          } else {
            if (invalidIds.contains(p.getWifeId())) {
              p.setWifeId(null);
            }
          }
        }

        if (p.getSpouseName() != null && p.getWifeId() == null) {
          Person wife = nameMap.get(p.getSpouseName());
          if (wife != null) {
            p.setWifeId(wife.getId());
          } else {
            if (invalidNames.contains(p.getSpouseName())) {
              p.setSpouseName(null);
            }
          }
        }
      }

      if (p.getGender().equals("F")) {
        if (p.getHusbandId() != null && p.getSpouseName() == null) {
          Person husband = idMap.get(p.getHusbandId());
          if (husband != null) {
            p.setSpouseName(husband.getFullName());
          } else {
            if (invalidIds.contains(p.getHusbandId())) {
              p.setHusbandId(null);
            }
          }
        }

        if (p.getSpouseName() != null && p.getHusbandId() == null) {
          Person husband = nameMap.get(p.getFullName());
          if (husband != null) {
            p.setHusbandId(husband.getId());
          } else {
            if (invalidNames.contains(p.getSpouseName())) {
              p.setSpouseName(null);
            }
          }
        }
      }

      if (p.getFatherName() != null) {
        Person father = nameMap.get(p.getFatherName());
        if (father != null) {
          p.setFatherId(father.getId());
        } else {
          if (invalidNames.contains(p.getFatherName())) {
            p.setFatherName(null);
          }
        }
      }

      if (p.getMotherName() != null) {
        Person mother = nameMap.get(p.getMotherName());
        if (mother != null) {
          p.setMotherId(mother.getId());
        } else {
          if (invalidNames.contains(p.getMotherName())) {
            p.setMotherName(null);
          }
        }
      }

      p.setParentsId(p.getParentsId().stream().filter((id) -> !invalidIds.contains(id)).collect(
          Collectors.toSet()));
      for (String id : p.getParentsId()) {
        Person parent = idMap.get(id);
        if (parent != null) {
          if (parent.getGender().equals("M")) {
            p.setFatherId(parent.getId());
          } else {
            p.setMotherId(parent.getId());
          }
        }
      }

      int kidsRemoved = p.getSonsId().size();
      p.setSonsId(p.getSonsId().stream().filter((id) -> !invalidIds.contains(id)).collect(
          Collectors.toSet()));
      kidsRemoved -= p.getSonsId().size();

      kidsRemoved += p.getDaughtersId().size();
      p.setDaughtersId(p.getDaughtersId().stream().filter((id) -> !invalidIds.contains(id)).collect(
          Collectors.toSet()));
      kidsRemoved -= p.getDaughtersId().size();

      kidsRemoved += p.getKidsName().size();
      p.setKidsName(p.getKidsName().stream().filter((name) -> !invalidNames.contains(name)).collect(
          Collectors.toSet()));
      kidsRemoved -= p.getKidsName().size();
      p.setKidsCount(p.getKidsCount() - kidsRemoved);

      for (String name : p.getKidsName()) {
        Person child = nameMap.get(name);
        if (child != null) {
          if (child.getGender().equals("M")) {
            p.getSonsId().add(child.getId());
          } else {
            p.getDaughtersId().add(child.getId());
          }
        }
      }

      int siblingsRemoved = p.getSiblingsId().size();
      p.setSiblingsId(p.getSiblingsId().stream().filter((id) -> !invalidIds.contains(id)).collect(
          Collectors.toSet()));
      siblingsRemoved -= p.getSiblingsId().size();


      for (String id : p.getSiblingsId()) {
        Person sibling = idMap.get(id);
        if (sibling != null) {
          if (sibling.getGender().equals("M")) {
            p.getBrothersId().add(id);
          } else {
            p.getSistersId().add(id);
          }
        }
      }

      siblingsRemoved += p.getBrothersName().size();
      p.setBrothersName(p.getBrothersName().stream().filter((name) -> !invalidNames.contains(name)).collect(
          Collectors.toSet()));
      siblingsRemoved -= p.getBrothersName().size();

      for (String name : p.getBrothersName()) {
        Person brother = nameMap.get(name);
        if (brother != null) {
          p.getBrothersId().add(brother.getId());
        }
      }

      siblingsRemoved += p.getSistersName().size();
      p.setSistersName(p.getSistersName().stream().filter((name) -> !invalidNames.contains(name)).collect(
          Collectors.toSet()));
      siblingsRemoved -= p.getSistersName().size();

      p.setSiblingsCount(p.getSiblingsCount() - siblingsRemoved);

      for (String name : p.getSistersName()) {
        Person sister = nameMap.get(name);
        if (sister != null) {
          p.getSistersId().add(sister.getId());
        }
      }

      if (p.getBrothersId().size() + p.getSistersId().size() != p.getSiblingsCount()) {
        System.out.println("Incorrect number of siblings: " + p.getId());
        correct = false;
      }
      if (p.getSonsId().size() + p.getDaughtersId().size() != p.getKidsCount()) {
        System.out.println("Incorrect number of children: " + p.getId());
        correct = false;
      }
    }

    if (correct) {
      System.out.println("Validation successful");
    }

    return new ArrayList(idMap.values());
  }
}
