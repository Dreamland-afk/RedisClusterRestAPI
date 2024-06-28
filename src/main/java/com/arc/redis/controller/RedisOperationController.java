package com.arc.redis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arc.redis.model.BodyDTO;
import com.arc.redis.model.HashDTO;
import com.arc.redis.model.InputDTO;
import com.arc.redis.model.ResponseDTO;

@RestController
@RequestMapping("/com/arc/redis/op")
public class RedisOperationController {

	private String hashKey;
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	ResponseDTO responseDTO;
	
	@Autowired
	BodyDTO bodyDTO;
	
	
	@PostMapping("/putHash")
	public ResponseEntity<ResponseDTO> hashOpPostAll(@RequestBody List<HashDTO> hashDTO) {
		
		try {
			for (HashDTO dto : hashDTO) {
				
				hashKey  = dto.getKey();
				
				Map<String, String> inputMap = new HashMap<String, String>();
				
				for(InputDTO inputDTO : dto.getInputs())
				{
					inputMap.put(inputDTO.getField(), inputDTO.getValue());
				}
				
				redisTemplate.opsForHash().putAll(hashKey, inputMap);
			}
			
			bodyDTO.setKey(hashKey);
			bodyDTO.setMessage("Data inserted successfully");
			List<BodyDTO> bodyDTOs = new ArrayList<BodyDTO>();
			bodyDTOs.add(bodyDTO);
			responseDTO.setStatusCode(HttpStatus.OK.value());
			responseDTO.setBody(bodyDTOs);
			
			
		} catch (Exception e) {
			bodyDTO.setKey(hashKey);
			bodyDTO.setMessage("Data insertion failed : "+ e.getMessage());
			List<BodyDTO> bodyDTOs = new ArrayList<BodyDTO>();
			bodyDTOs.add(bodyDTO);
			responseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseDTO.setBody(bodyDTOs);
		}
		
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
//	@GetMapping
//	public void hashOpGetAll(@RequestBody HashDTO hashDTO) {
//		
//		if(hashDTO.getField() == null)
//			System.out.println(redisTemplate.opsForHash().entries(hashDTO.getKey()));
//		else
//			System.out.println(redisTemplate.opsForHash().get(hashDTO.getKey(), hashDTO.getField()));
//	}	
}
