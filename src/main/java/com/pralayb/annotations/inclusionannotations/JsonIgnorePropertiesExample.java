package com.pralayb.annotations.inclusionannotations;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@JsonIgnoreProperties({"objectId"})
@ToString
public class JsonIgnorePropertiesExample {

    @Setter @Getter
    private int objectId;
    @Setter @Getter
    private String objectName;

    public static void main(String[] args) throws IOException {

        JsonIgnorePropertiesExample myObj = new JsonIgnorePropertiesExample(11, "someName");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(myObj);
        System.out.println(json);

        JsonIgnorePropertiesExample secondObj = mapper.readValue(json, JsonIgnorePropertiesExample.class);
        System.out.println(secondObj);

        System.out.println("--------------------------------------------------------------------");
        System.out.println(secondObj.getObjectId());
        System.out.println(secondObj.getObjectName());
    }
}

/**
{"objectName":"someName"}
JsonIgnorePropertiesExample(objectId=0, objectName=someName)
--------------------------------------------------------------------
0
someName
*/