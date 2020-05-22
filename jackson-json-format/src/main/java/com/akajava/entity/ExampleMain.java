package com.akajava.entity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ExampleMain {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//        String jsonString = om.writeValueAsString(employee);
//        System.out.println(jsonString);
        String jsonString = getJsonString();
        System.out.println(jsonString);
//        jsonString = om.readTree(jsonString).findPath("nameData").toString();
        jsonString = om.readTree(jsonString).findPath("ICRS_FullSubjectByECN_Response").toString();
        System.out.println("-- after deserialization --");
//        NameFieldsFormatDate fields = om.readValue(jsonString, NameFieldsFormatDate.class);
        FullSubjectByECNFormatDateResponse fields = om.readValue(jsonString, FullSubjectByECNFormatDateResponse.class);
        System.out.println(fields);

//        om.setDateFormat(df);
        jsonString = om.writeValueAsString(fields);
        System.out.println(jsonString);

    }

    private static String getJsonString() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("src/test/request.json");
        return IOUtils.toString(fis, "UTF-8");
    }
}