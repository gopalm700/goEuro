package com.goeuro.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.goeuro.dto.CityInfomation;
import com.goeuro.service.IGetResultService;

public class GetResultServiceImpl implements IGetResultService {
	
	
	private String restUrl;

	@Override
	public CityInfomation[] fetchData(String cityName) {
		UriComponents uri = UriComponentsBuilder.fromHttpUrl(restUrl).pathSegment(cityName).build();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CityInfomation[]> responseEntity  = restTemplate.getForEntity(uri.toUriString(), CityInfomation[].class);
		return responseEntity.getBody();
	}

	public String getRestUrl() {
		return restUrl;
	}

	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}

	
	
}
