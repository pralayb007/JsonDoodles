package com.pralayb.annotations.serialization;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class JsonGetterExample {

   @Getter private String someName;

    //@JsonProperty("someOtherNameInJson")
    @JsonGetter("someOtherNameInJson")
    public String notTheRegularGetterMethod() {
        return this.someName;
    }

    public static void main(String[] args) {

        JsonGetterExample myObject = new JsonGetterExample("pralayb");

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
{"someOtherNameInJson":"pralayb"} without the getter on  someName
{"someName":"pralayb","someOtherNameInJson":"pralayb"} with the getter on someName
*/