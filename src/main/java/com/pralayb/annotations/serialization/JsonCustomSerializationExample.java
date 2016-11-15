package com.pralayb.annotations.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class JsonCustomSerializationExample {

    @JsonSerialize(using=CustomBooleanToIntegerSerialzer.class)
    @Getter private boolean someValue;

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(new JsonCustomSerializationExample(true)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}

/**
{"someValue":1}
*/
