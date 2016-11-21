package com.pralayb.annotations.inclusionannotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class IgnoreTypeExample {

    @Getter private IgnoreTypeEntity ignoreTypeEntity;
    @Getter private String someString;

    public static void main(String[] args) throws JsonProcessingException {

        IgnoreTypeExample myObj = new IgnoreTypeExample(new IgnoreTypeEntity("someEntity"), "someStringInThisobject");

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(myObj));

    }
}

/**
{"ignoreTypeEntity":{"someAttribute":"someEntity"},"someString":"someStringInThisobject"} //when not ignoredType on entity
{"someString":"someStringInThisobject"} //when ignored on entity type
*/
