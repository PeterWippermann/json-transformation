package com.gerixsoft.xslt4json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.ValidatorHandler;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Test {

	public static void main(String[] args) throws IOException, SAXException, TransformerException {
		if (args.length != 3) {
			System.err.println("usage: <xslt-file> <input-file> <output-file>");
			System.exit(-1);
		}
		transform(args);
	}

	public static void transform(String[] args) throws FileNotFoundException, SAXException,
			TransformerConfigurationException, TransformerFactoryConfigurationError, IOException {
		File xsltFile = new File(args[0]);
		File inputFile = new File(args[1]);
		File outputFile = new File(args[2]);

		JsonSaxWriter writer = new JsonSaxWriter(new FileOutputStream(outputFile));
		
		SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		Schema schema;
		schema = schemaFactory.newSchema(new StreamSource(Test.class.getResourceAsStream("/json.xsd")));
		ValidatorHandler validatorHandler = schema.newValidatorHandler();
		validatorHandler.setErrorHandler(new __ErrorHandler());
		validatorHandler.setContentHandler(writer);
		
		TransformerHandler transformerHandler = ((SAXTransformerFactory)TransformerFactory.newInstance()).newTransformerHandler(new StreamSource(xsltFile));
		//transformerHandler.setResult(new SAXResult(validatorHandler)); // TODO uncomment this for XSD validation
		transformerHandler.setResult(new SAXResult(writer)); 
		
		JsonSaxReader reader = new JsonSaxReader();
		reader.setContentHandler(transformerHandler);
		reader.parse(new InputSource(inputFile.toString()));
		
		System.out.println("ok");
	}

	private static final class __ErrorHandler implements ErrorHandler {
		@Override
		public void warning(SAXParseException exception) throws SAXException {
			log("warning", exception);
		}

		@Override
		public void fatalError(SAXParseException exception) throws SAXException {
			log("fatal error", exception);
		}

		@Override
		public void error(SAXParseException exception) throws SAXException {
			log("error", exception);
		}

		public void log(String type, SAXParseException exception) {
			System.err.println(type + " at line: " + exception.getLineNumber() + " col:" + exception.getColumnNumber() + " message: " + exception.getMessage());
		}
	}

}
