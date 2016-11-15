package com.pralayb.annotations.serialization;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class JsonValueExample {

    @Getter private String firstAttr;
    @Getter private String secAttr;

//    @JsonValue
//    public Boolean demoJsonValueReturningFalse() {
//        return false;
//    }

    @JsonValue
    @JsonRawValue
    public String demoJsonValueReturningString() {
        return "{\"hello\": \"World\"}";
    }

    public static void main(String[] args) {

        JsonValueExample myObject = new JsonValueExample("Hello", "World");

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
 * false when return is Boolean and returning false
 * {"hello": "World"}
*/