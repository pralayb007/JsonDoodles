package com.pralayb.annotations.deserialization;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.ToString;

/**
 * baseJson has two properties, jsonId and jsonName
 * Attempting to map them to objectId and objectName
 */
@ToString(includeFieldNames=true, of={"objectId", "objectName"})
public class JsonCreatorExample {

    private int objectId;
    private String objectName;

    @JsonCreator
    public JsonCreatorExample(
            @JsonProperty("jsonId") int objectId,
            @JsonProperty("jsonName") String objectName) {
        this.objectId = objectId;
        this.objectName = objectName;
    }

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String baseJson = "{\"jsonId\":1, \"jsonName\" : \"Some Name\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonCreatorExample myObject = mapper.readValue(baseJson, JsonCreatorExample.class);
        System.out.println(myObject);

        System.out.println("*********");
        JsonCreatorExample myObject2 =  mapper.reader().forType(JsonCreatorExample.class).readValue(baseJson);
        System.out.println(myObject2);
    }
}
/**
JsonCreatorExample(objectId=1, objectName=Some Name)
*********
JsonCreatorExample(objectId=1, objectName=Some Name)
*/