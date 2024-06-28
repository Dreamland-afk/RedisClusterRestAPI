package com.arc.redis.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = false)
public class HashDTO {


    private String key;
    private List<InputDTO> inputs;
}
