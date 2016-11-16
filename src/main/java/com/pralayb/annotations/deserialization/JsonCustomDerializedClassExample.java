package com.pralayb.annotations.deserialization;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;

/**
 * Attempting to read an int from Json and convert to boolean
 */

public class JsonCustomDerializedClassExample {

    @JsonDeserialize(using=JsonCustomDerializer.class)
    @JsonProperty("someIntegerValue")
    @Getter private boolean generatedBoolean; //just to read at the end

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        String basejson = "{\"someIntegerValue\":22}";
        ObjectMapper mapper = new ObjectMapper();

        JsonCustomDerializedClassExample obj = mapper.readValue(basejson, JsonCustomDerializedClassExample.class);
        System.out.println(obj.generatedBoolean);
    }
}
