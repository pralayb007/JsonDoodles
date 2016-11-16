package com.pralayb.annotations.deserialization;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames=true, of={"objectId", "objectName"})
public class JsonAnySetterExample {

    @Setter private int objectId; //these still wont get populated
    @Setter private String objectName; //these still wont get populated
    @Getter private Map<String, Object> myMap = new HashMap<>();

    @JsonAnySetter
    public void add (String anyJsonKey, Object anyJsonValue) {
        myMap.put(anyJsonKey, anyJsonValue);
    }

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String baseJson = "{\"jsonId\":1, \"jsonName\" : \"Some Name\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonAnySetterExample myObject = mapper.readValue(baseJson, JsonAnySetterExample.class);

        System.out.println(myObject.getMyMap());
        System.out.println("*******");
        System.out.println(myObject);
    }
}
/**
{jsonName=Some Name, jsonId=1}
*******
JsonAnySetterExample(objectId=0, objectName=null)
*/