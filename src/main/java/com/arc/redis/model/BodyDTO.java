package com.arc.redis.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Component
public class BodyDTO {

	private String key;
	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<InputDTO> data;
}
