package com.concretepage;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JSONToObject {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		 String jsonData = 
		    "{"
			  +"\"writerName\" : \"Mahesh\","
			  +"\"bdate\" : 1528703231286,"
			  +"\"pubDate\" : \"2018-Jun-11 07:00:46 EST\""	
		   +"}";
		 ObjectMapper mapper = new ObjectMapper();
		 Writer writer = mapper.readValue(jsonData, Writer.class);
		 System.out.println(writer.getName());
		 System.out.println(writer.getBirthDate()+" | "+ writer.getRecentBookPubDate());
	}
} 