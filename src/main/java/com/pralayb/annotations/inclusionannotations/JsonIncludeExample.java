package com.pralayb.annotations.inclusionannotations;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@ToString
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
public class JsonIncludeExample {

    private int objectId;
    private String objectName;

    public static void main(String[] args) throws IOException {

        JsonIncludeExample myObj = new JsonIncludeExample(0, "someName"); //will not be ser'ed if the int is 0 aka default

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(myObj);
        System.out.println(json);

        JsonIncludeExample secondObj = mapper.readValue(json, JsonIncludeExample.class);
        System.out.println(secondObj);

    }
}

/**
{"objectId":11,"objectName":"someName"}
JsonIncludeExample(objectId=11, objectName=someName)

When id = 0
{"objectName":"someName"} //serialization only impact of JsonInclude NON_DEFAULT
JsonIncludeExample(objectId=0, objectName=someName)
*/