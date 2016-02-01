package com.goeuro.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.goeuro.dto.CityInfomation;
import com.goeuro.exception.GoEuroApplicationException;
import com.goeuro.service.IGetResultService;

public class GetResultServiceImpl implements IGetResultService {

	private static Log logger = LogFactory.getLog(GetResultServiceImpl.class);

	private String restUrl;

	@Override
	public CityInfomation[] fetchData(String cityName) throws GoEuroApplicationException {
		try {
			UriComponents uri = UriComponentsBuilder.fromHttpUrl(restUrl)
					.pathSegment(cityName).build();
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CityInfomation[]> responseEntity = restTemplate
					.getForEntity(uri.toUriString(), CityInfomation[].class);
			logger.info("Sucessfully got data from API");
			return responseEntity.getBody();
		} catch (Exception e) {
			
			logger.error("Error while fetching result");
			throw new GoEuroApplicationException(e);
		}

	}

	public String getRestUrl() {
		return restUrl;
	}

	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}

}
