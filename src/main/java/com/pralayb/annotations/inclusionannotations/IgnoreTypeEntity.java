package com.pralayb.annotations.inclusionannotations;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@JsonIgnoreType
public class IgnoreTypeEntity {

   @Getter @Setter private String someAttribute;
}
