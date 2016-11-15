package com.pralayb.annotations.serialization;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class JsonRawValueExample {

    @Getter
    @JsonRawValue
    private String firstAttr;
    @Getter private String secAttr;

    public static void main(String[] args) {

        JsonRawValueExample myObject = new JsonRawValueExample("\"Hello world\"", "\"Hello world\"");

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
 * {"firstAttr":"Hello world","secAttr":"\"Hello world\""}
*/