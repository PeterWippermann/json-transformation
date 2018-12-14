package com.gerixsoft.xslt4json;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.xerial.json.impl.JSONLexer;
import org.xerial.json.impl.JSONParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

public class JsonSaxReader implements XMLReader {

	@Override
	public void parse(InputSource input) throws IOException, SAXException {
		parse(new ANTLRFileStream(input.getSystemId()));
	}

	@Override
	public void parse(String systemId) throws IOException, SAXException {
		throw new SAXNotSupportedException();
	}

	// impl

	private void parse(CharStream stream) throws SAXException {
		JSONLexer lexer = new JSONLexer(stream);
		JSONParser parser = new JSONParser(new CommonTokenStream(lexer));
		CommonTree tree;
		try {
			tree = (CommonTree) parser.json().getTree();
		} catch (RecognitionException e) {
			throw new SAXException(e);
		}
		contentHandler.startDocument();
		try {
			visit(tree);
		} finally {
			contentHandler.endDocument();
		}
	}

	private void visit(Tree tree) {
		String text = tree.getText();
		int type = tree.getType();
		try {
			if (type == JSONParser.XML_ELEMENT) {
				AttributesImpl attrs = new AttributesImpl();
				int i = 0;
				for (; i < tree.getChildCount(); i++) {
					Tree attr = tree.getChild(i);
					if (attr.getType() != JSONParser.XML_ATTRIBUTE) {
						break;
					}
					String attrName = attr.getText();
					StringBuilder attrValue = new StringBuilder();
					for (int j = 0; j < attr.getChildCount(); j++) {
						Tree value = attr.getChild(j);
						attrValue.append(value.getText());
					}
					attrs.addAttribute("", attrName, attrName, "CDATA", attrValue.toString());
				}
				contentHandler.startElement("", text, text, attrs);
				for (; i < tree.getChildCount(); i++) {
					visit(tree.getChild(i));
				}
				contentHandler.endElement("", text, text);
			} else {
				String name = JSONParser.tokenNames[type];
				if (name.equals(name.toUpperCase())) {
					contentHandler.startElement("", name, name, new AttributesImpl());
					for (int i = 0; i < tree.getChildCount(); i++) {
						visit(tree.getChild(i));
					}
					contentHandler.endElement("", name, name);
				} else {
					// handler.processingInstruction("antlr", text);
					contentHandler.characters(text.toCharArray(), 0, text.length());
				}
			}
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	// property

	private ContentHandler contentHandler;

	@Override
	public void setContentHandler(ContentHandler value) {
		contentHandler = value;
	}

	@Override
	public ContentHandler getContentHandler() {
		return contentHandler;
	}

	// property

	private ErrorHandler errorHandler;

	@Override
	public void setErrorHandler(ErrorHandler value) {
		errorHandler = value;
	}

	@Override
	public ErrorHandler getErrorHandler() {
		return errorHandler;
	}

	// not implemented

	@Override
	public void setEntityResolver(EntityResolver resolver) {
	}

	@Override
	public EntityResolver getEntityResolver() {
		return null;
	}

	@Override
	public void setDTDHandler(DTDHandler handler) {
	}

	@Override
	public DTDHandler getDTDHandler() {
		return null;
	}

	// not supported

	@Override
	public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
		throw new SAXNotSupportedException();
	}

	@Override
	public void setFeature(String name, boolean value) throws SAXNotRecognizedException,
			SAXNotSupportedException {
		throw new SAXNotSupportedException();

	}

	@Override
	public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
		throw new SAXNotSupportedException();
	}

	@Override
	public void setProperty(String name, Object value) throws SAXNotRecognizedException,
			SAXNotSupportedException {
		throw new SAXNotSupportedException();
	}

}
