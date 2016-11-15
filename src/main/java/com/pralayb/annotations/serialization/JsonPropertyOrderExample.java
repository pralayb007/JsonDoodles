package com.pralayb.annotations.serialization;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonPropertyOrder ({"secAttr", "firstAttr", "thirdAttr"})
public class JsonPropertyOrderExample {

    @Getter private String firstAttr;
    @Getter private String secAttr;
    @Getter private String thirdAttr;

    public static void main(String[] args) {


        JsonPropertyOrderExample myObject = new JsonPropertyOrderExample("firstValue", "secondValue", "thirdValue");

        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonOutput = mapper.writeValueAsString(myObject);
            System.out.println(jsonOutput);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

/**
 * {"secAttr":"secondValue","firstAttr":"firstValue","thirdAttr":"thirdValue"}
*/