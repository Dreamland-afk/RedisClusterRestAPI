package com.arc.redis.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseDTO {

	private int statusCode;
	private String message;
	private List<BodyDTO> body;
}
