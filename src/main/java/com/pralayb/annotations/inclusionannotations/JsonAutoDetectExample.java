package com.pralayb.annotations.inclusionannotations;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
public class JsonAutoDetectExample {

    private int objectId;
    private String objectName;

    public static void main(String[] args) throws IOException {

        JsonAutoDetectExample myObj = new JsonAutoDetectExample(11, "someName");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(myObj);
        System.out.println(json);

        JsonAutoDetectExample secondObj = mapper.readValue(json, JsonAutoDetectExample.class);
        System.out.println(secondObj);

    }
}

/**
{"objectId":11,"objectName":"someName"}
JsonAutoDetectExample(objectId=11, objectName=someName)
*/