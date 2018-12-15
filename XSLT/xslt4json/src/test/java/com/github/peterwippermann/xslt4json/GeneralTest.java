package com.github.peterwippermann.xslt4json;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.junit.Test;
import org.xml.sax.SAXException;

public class GeneralTest {

	@Test
	public void test() throws FileNotFoundException, TransformerConfigurationException, SAXException, TransformerFactoryConfigurationError, IOException {
		com.gerixsoft.xslt4json.Test.transform(new String[] {"transform.xsl", "input.json", "output.json"});
	}

}
