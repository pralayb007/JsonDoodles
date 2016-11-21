package com.pralayb.annotations.generalannotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class JsonFormatExample {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")

    @JsonProperty("reformattedDate")
    @Getter @Setter Date myDate;

    public static void main(String[] args) throws ParseException, JsonProcessingException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = format.parse("2016-10-25");
        System.out.println(myDate);

        JsonFormatExample myObj = new JsonFormatExample(myDate);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(myObj));
    }
}

/**
Tue Oct 25 00:00:00 PDT 2016
{"reformattedDate":"25-10-2016"}
*/