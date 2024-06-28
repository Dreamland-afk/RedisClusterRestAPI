package com.arc.redis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = false)
@AllArgsConstructor
public class InputDTO {

	private String field;
    private String value;
}
