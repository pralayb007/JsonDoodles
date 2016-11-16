package com.pralayb.annotations.deserialization;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames=true, of={"objectId", "objectName"})
public class JsonSetterExample {

    @Setter private int objectId;
    @Setter private String objectName; // this will be overwritten by JsonSetter

    @JsonSetter("jsonId")
    public void setTheObjectId(int newObjectId){
        this.objectId = newObjectId;
    }

    @JsonSetter("objectName")
    public void setTheObjectName(String newObjectId){
        this.objectName = "HelloWorld";
    }

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String baseJson = "{\"jsonId\":1, \"objectName\" : \"Some Name\"}"; //replaced jsonName with objectName

        ObjectMapper mapper = new ObjectMapper();
        JsonSetterExample myObject = mapper.readValue(baseJson, JsonSetterExample.class);
        System.out.println(myObject);
    }
}
/**
JsonSetterExample(objectId=1, objectName=HelloWorld)
*/