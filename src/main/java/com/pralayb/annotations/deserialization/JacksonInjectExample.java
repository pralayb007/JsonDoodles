package com.pralayb.annotations.deserialization;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * baseJson has two properties, jsonId and jsonName
 * Attempting to map them to objectId and objectNamy
 * We will inject the value of objectId externally
 */
@ToString(includeFieldNames=true, of={"objectId", "objectName"})
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true) //required or else jsonId will throw and exception
public class JacksonInjectExample {

    @JacksonInject private int objectId;

    @JsonProperty("jsonName") //required else jackson wont know that this is a mapping to jsonName
    private String objectName;

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String baseJson = "{\"jsonId\":1, \"jsonName\" : \"Some Name\"}";

        ObjectMapper mapper = new ObjectMapper();

        InjectableValues injectedObjectId = new InjectableValues.Std()
                .addValue(int.class, 77);

        JacksonInjectExample myObject = mapper.reader()
                .with(injectedObjectId)
                .forType(JacksonInjectExample.class)
                .readValue(baseJson);

        System.out.println(myObject);

    }
}
/**
JacksonInjectExample(objectId=77, objectName=Some Name)
*/