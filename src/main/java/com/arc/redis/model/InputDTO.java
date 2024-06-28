package com.arc.redis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = false)
public class InputDTO {

	private String field;
    private String value;
}
