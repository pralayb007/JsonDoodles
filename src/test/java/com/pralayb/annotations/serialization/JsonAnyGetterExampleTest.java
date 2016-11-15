package com.pralayb.annotations.serialization;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;

public class JsonAnyGetterExampleTest {

    private ObjectMapper mapper;
    private JsonAnyGetterExample sut;
    private Map<String, String> myMap;

    @Before
    public void setUp() {
        mapper = new ObjectMapper();

        myMap = new HashMap<>();
        myMap.put("attr1", "value1");
        myMap.put("attr2", "value2");

        sut = new JsonAnyGetterExample("someName", myMap);
    }

    @Test
    public void mapWithValidAttributes_returnsGoodJson() throws JsonProcessingException {
        assertThat(mapper.writeValueAsString(sut), containsString("\"attr1\":\"value1\""));
    }

}
