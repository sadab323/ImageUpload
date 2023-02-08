package com.sa.controller;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class XmltoJsonController {
	
	Gson gson=new Gson();
	
	@PostMapping(value = "/xml-to-json", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object convertXmlToJson(@RequestBody String xmlPayload) throws JAXBException {
		StringReader sr = new StringReader(xmlPayload);
		JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Response response = (Response) unmarshaller.unmarshal(sr);
		return gson.toJson(response);
	 
	}

}
