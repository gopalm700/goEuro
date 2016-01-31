package com.goeuro.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Test {

	
	public static void main(String[] args)  {
		
		final String uri = "http://api.goeuro.com/api/v2/position/suggest/en/warsaw";
		RestTemplate restTemplate = new RestTemplate();
		
		
		//String results = restTemplate.getForObject(uri, String.class);
		ResponseEntity<CityInfomation[]> responseEntity = restTemplate.getForEntity(uri, CityInfomation[].class);


		CityInfomation[] list = responseEntity.getBody();
		System.out.println(list);
//		JSONArray object = new JSONArray(results);
//		String[] keys = JSONObject.getNames(object);
//
//		
//		System.out.println(results);
	}
}
