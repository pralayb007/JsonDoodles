package com.pralayb.annotations.generalannotations;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class JsonViewExample {

    @Getter
    @JsonView(JsonViewViews.External.class)
    private String oneString;

    @Getter
    @JsonView({JsonViewViews.External.class, JsonViewViews.Internal.class})
    private String secString;

    public static void main(String[] args) throws JsonProcessingException {

        JsonViewExample myObj = new JsonViewExample("oneString", "secString");

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(myObj));
        System.out.println(mapper.writer().withView(JsonViewViews.External.class).writeValueAsString(myObj));
        System.out.println(mapper.writer().withView(JsonViewViews.Internal.class).writeValueAsString(myObj));

    }
}
/**
{"oneString":"oneString","secString":"secString"}
{"oneString":"oneString","secString":"secString"}
{"secString":"secString"}

*/