package com.epam.te.task04.operation;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;


public class XMLOperation {
	private static final Logger logger = Logger.getLogger(XMLOperation.class);
	private static final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	
	public static void main (String [] args) throws SAXException, IOException{
		String pathToXSD = "src/resources/tariff.xsd";
		String pathToXML = "src/resources/tariff.xml";
		String pathToXSL = "src/resources/tariff.xsl";
		String fileHTML = "newtariff.html";
		
		BasicConfigurator.configure();
		
		try{
			getXSDValidation(pathToXSD, pathToXML);
			logger.info("XML file is valid");
			
			TransformToHTML(pathToXSL, pathToXML, fileHTML);
			logger.info("Transform  complete");
		}catch (SAXException e){
			logger.error(e.getMessage());
		}catch (IOException e){
			logger.error(e.getMessage());
		}catch (TransformerException e){
			logger.error("Impossible transform file "  + " : " + e.getMessage());
		}catch (Exception e){
			logger.error(e.getMessage());
		}

	}
	
	// XSDValidation
	private static void getXSDValidation(String schema_location, String sourcePath) throws SAXException, IOException{
		SchemaFactory factory = SchemaFactory.newInstance(XML_SCHEMA);
		
		File schemaLocation = new File(schema_location);
		Schema schema = factory.newSchema(schemaLocation);
		
		Validator validator = schema.newValidator();	
		Source source = new StreamSource(sourcePath);		
		validator.validate(source);
	}
	
	// Transform XML file to HTML
	private static void TransformToHTML(String pathToXSL, String pathToXML, String fileHTML) throws TransformerException{
		TransformerFactory tf = TransformerFactory.newInstance();
		
		Transformer transformer = tf.newTransformer(new StreamSource(pathToXSL));	
		transformer.transform(new StreamSource(pathToXML), new StreamResult(fileHTML));
	}
}
