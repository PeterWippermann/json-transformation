package com.github.peterwippermann.json;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void runJolt() throws JsonParseException, JsonMappingException, IOException {
		String specFile = "/json/sample/spec.json";
		String inputFile = "/json/sample/input.json";

		transforn(specFile, inputFile);
	}

	private void transforn(String specFile, String inputFile)
			throws IOException, JsonParseException, JsonMappingException, JsonProcessingException {
		// How to access the test artifacts, i.e. JSON files
		// JsonUtils.classpathToList : assumes you put the test artifacts in your class
		// path
		// JsonUtils.filepathToList : you can use an absolute path to specify the files


		List<Object> chainrSpecJSON = JsonUtils.classpathToList(specFile);
		Chainr chainr = Chainr.fromSpec(chainrSpecJSON);

		Object inputJSON = JsonUtils.classpathToObject(inputFile);

		Object transformedOutput = chainr.transform(inputJSON);
		String jsonString = JsonUtils.toJsonString(transformedOutput);

		String prettyJson = prettifyJson(jsonString);

		System.out.println(prettyJson);
	}

	private String prettifyJson(String jsonString)
			throws IOException, JsonParseException, JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		JsonNode readValue = objectMapper.readValue(jsonString, JsonNode.class);
		String prettyJson = objectMapper.writeValueAsString(readValue);
		return prettyJson;
	}
}
