package com.gerixsoft.xslt4json;

import java.io.IOException;
import java.io.OutputStream;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class JsonSaxWriter implements ContentHandler {

	public JsonSaxWriter(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	private OutputStream outputStream;	
	private boolean indent = true;
	private String indentStr = "\t";
	private int indentLevel;

	private void write(String s) throws SAXException {
		try {
			outputStream.write(s.getBytes());
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	private void writeln() throws SAXException {
		if (!indent) {
			write(" ");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("\n");
			for (int i = 0; i < indentLevel; i++) {
				sb.append(indentStr);
			}
			write(sb.toString());
		}
	}

	@Override
	public void setDocumentLocator(Locator locator) {

	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {

	}

	private boolean needsComma;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts)
			throws SAXException {
		if ((uri == null || uri.length() == 0) && localName.equals(qName)) {
			if (needsComma) {
				write(",");
				writeln();
				needsComma = false;
			}
			if (localName.equals("field")) {
				if (atts.getLength() == 1 && atts.getQName(0).equals("name")) {
					write("\"" + atts.getValue(0) + "\": ");
				} else {
					throw new SAXException("element 'field' must have only one name attribute");
				}
			} else {
				if (atts.getLength() != 0) {
					throw new SAXException("element '" + localName + "' must not have attributes");
				}
				if (localName.equals("object")) {
					write("{");
					indentLevel++;
					writeln();
				} else if (localName.equals("array")) {
					write("[");
					indentLevel++;
					writeln();
				} else if (localName.equals("string")) {
					write("\"");
				} else if (localName.equals("integer") || localName.equals("double")
						|| localName.equals("boolean")) {
				} else {
					throw new SAXException("not valid element: " + localName);
				}
			}
		} else {
			throw new SAXException("not valid element: " + qName);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ((uri == null || uri.length() == 0) && localName.equals(qName)) {
			needsComma = true;
			if (localName.equals("object")) {
				indentLevel--;
				writeln();
				write("}");
			} else if (localName.equals("array")) {
				indentLevel--;
				writeln();
				write("]");
			} else if (localName.equals("field")) {
			} else if (localName.equals("string")) {
				write("\"");
			} else if (localName.equals("integer") || localName.equals("double")
					|| localName.equals("boolean")) {
			} else {
				throw new SAXException("not valid element: " + localName);
			}
		} else {
			throw new SAXException("not valid element: " + qName);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		write(String.valueOf(ch, start, length));
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {

	}

	@Override
	public void skippedEntity(String name) throws SAXException {

	}

}
