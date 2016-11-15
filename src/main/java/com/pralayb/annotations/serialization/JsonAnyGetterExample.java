package com.pralayb.annotations.serialization;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class JsonAnyGetterExample {

    @Getter
    private String name;
    private Map<String, String> someMap;

    public Map<String, String> getTheMap() {
        return this.someMap;
    }

    public static void main(String[] args) {

        Map<String, String> myMap = new HashMap<>();
        myMap.put("attr1", "value1");
        myMap.put("attr2", "value2");

        JsonAnyGetterExample myObject = new JsonAnyGetterExample("pralayb", myMap);

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
{"name":"pralayb","theMap":{"attr2":"value2","attr1":"value1"}} when name has a getter
{"theMap":{"attr2":"value2","attr1":"value1"}} when name does not have the getter
*/