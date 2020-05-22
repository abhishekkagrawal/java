package com.logicbig.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class ExampleMain {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
//        Employee employee = new Employee();
//        employee.setName("Amy");
//        employee.setDateOfBirth(Date.from(ZonedDateTime.now().minusYears(30).toInstant()));
//        employee.setStartDate(Date.from(ZonedDateTime.now().minusYears(2).toInstant()));
//        employee.setDept(Dept.Sales);
//
//        System.out.println("-- before serialization --");
//        System.out.println(employee);
//
//        System.out.println("-- after serialization --");
        ObjectMapper om = new ObjectMapper();

//        String jsonString = om.writeValueAsString(employee);
//        System.out.println(jsonString);

        String jsonString = "{\"name\":\"Amy\",\"dateOfBirth\":\"19900508\",\"startDate\":\"2018-04-22 07:48:10 -0400\",\"dept\":2}";
        System.out.println("-- after deserialization --");
        Employee employee = om.readValue(jsonString, Employee.class);
        System.out.println(employee);

//        om.setDateFormat(df);
        jsonString = om.writeValueAsString(employee);
        System.out.println(jsonString);

    }
}