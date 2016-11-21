package com.pralayb.annotations.generalannotations;

import java.text.ParseException;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class JsonUnwrappedExample {

    @Getter @Setter
    @JsonUnwrapped
    private JsonUnwrappedEntity internalObject;
    @Getter @Setter private String stringInThisObject;

    public static void main(String[] args) throws ParseException, JsonProcessingException {

        JsonUnwrappedExample myObj = new JsonUnwrappedExample(new JsonUnwrappedEntity("internal"), "external");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myObj));


    }
}

/**

WithoutUnwrapped
{
  "internalObject" : {
    "someAttribute" : "internal"
  },
  "stringInThisObject" : "external"
}

After
{
  "someAttribute" : "internal",
  "stringInThisObject" : "external"
}

*/