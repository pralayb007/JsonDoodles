package com.pralayb.annotations.inclusionannotations;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@JsonIgnoreProperties({"objectId"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
public class JsonIgnoreExample {

    //@Setter @Getter
    private int objectId;
    //@Setter @Getter
    private String objectName;

    public static void main(String[] args) throws IOException {

        JsonIgnoreExample myObj = new JsonIgnoreExample(11, "someName");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(myObj);
        System.out.println(json);

        JsonIgnoreExample secondObj = mapper.readValue(json, JsonIgnoreExample.class);
        System.out.println(secondObj);

//        System.out.println("--------------------------------------------------------------------");
//        System.out.println(secondObj.getObjectId());
//        System.out.println(secondObj.getObjectName());
    }
}

/**
{"objectName":"someName"}
--------------------------------------------------------------------
0
someName
*/