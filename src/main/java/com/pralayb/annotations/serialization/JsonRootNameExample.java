package com.pralayb.annotations.serialization;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonPropertyOrder ({"secAttr", "firstAttr", "thirdAttr"})
@JsonRootName("testRootName")
public class JsonRootNameExample {

    @Getter private String firstAttr;
    @Getter private String secAttr;
    @Getter private String thirdAttr;

    public static void main(String[] args) {


        JsonRootNameExample myObject = new JsonRootNameExample("firstValue", "secondValue", "thirdValue");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        ObjectWriter writer = new ObjectMapper()
                .writer()
                .with(SerializationFeature.WRAP_ROOT_VALUE)
                .withDefaultPrettyPrinter();

        try {
            System.out.println(writer.writeValueAsString(myObject));
            System.out.println("*********");
            System.out.println(mapper.writeValueAsString(myObject));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

/**
    {"secAttr":"secondValue","firstAttr":"firstValue","thirdAttr":"thirdValue"} when root level wrapping is not on

   {
      "testRootName" : {
        "secAttr" : "secondValue",
        "firstAttr" : "firstValue",
        "thirdAttr" : "thirdValue"
      }
   }
    *********
    {"testRootName":{"secAttr":"secondValue","firstAttr":"firstValue","thirdAttr":"thirdValue"}}
*/