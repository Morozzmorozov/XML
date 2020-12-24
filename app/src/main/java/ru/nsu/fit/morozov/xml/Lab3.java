package ru.nsu.fit.morozov.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;

public class Lab3 {

  public static void main(String[] args) {
    try {
      DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
      SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
      File schemaFile = new File("app\\src\\main\\resources\\people.xsd");
      docBuilderFactory.setSchema(schemaFactory.newSchema(schemaFile));
      docBuilderFactory.setNamespaceAware(true);
      Document doc = docBuilderFactory.newDocumentBuilder().parse("app\\src\\main\\resources\\people1.xml");

      StreamSource styleSheet = new StreamSource(new File("app\\src\\main\\resources\\transform.xsl"));
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer transformer = tf.newTransformer(styleSheet);
      transformer.transform(new DOMSource(doc),
          new StreamResult(new FileOutputStream("app\\src\\main\\resources\\output.html")));
    } catch (SAXException | ParserConfigurationException | IOException | TransformerException e) {
      e.printStackTrace();
    }
  }
}
