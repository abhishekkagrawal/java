package com.concretepage;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ObjectToJSON {
  public static void main(String[] args) throws JsonProcessingException {
     Writer writer = new Writer("Mohit", new Date(), new Date());   
     ObjectMapper mapper = new ObjectMapper();     
     String jsonData = mapper.writerWithDefaultPrettyPrinter()
		 .writeValueAsString(writer);
     System.out.println(jsonData);
  }
} 