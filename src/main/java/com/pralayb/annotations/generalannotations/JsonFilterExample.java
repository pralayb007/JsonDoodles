package com.pralayb.annotations.generalannotations;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFilter("someFilter")
public class JsonFilterExample {

    @Getter
    private int id;

    @Getter
    private String name;

    public static void main(String[] args) throws JsonProcessingException {

        JsonFilterExample myObj = new JsonFilterExample(22, "someName");

        ObjectMapper mapper = new ObjectMapper();

//        System.out.println(mapper.writeValueAsString(myObj));

        FilterProvider myFilter = new SimpleFilterProvider()
                .addFilter("someFilter",
                        SimpleBeanPropertyFilter.filterOutAllExcept("id"));

        String afterFiltering = mapper.writer()
                .with(myFilter)
                .withDefaultPrettyPrinter()
                .writeValueAsString(myObj);

        System.out.println(afterFiltering);
    }
}

/**
Before (without the JsonFilter annotation from the commented out System.out.println(mapper.writeValueAsString(myObj));
{"id":22,"name":"someName"}


After
{
  "id" : 22
}

*/

