package com.goeuro.service;

import com.goeuro.dto.CityInfomation;
import com.goeuro.exception.GoEuroApplicationException;

public interface IGetResultService {
	
	public CityInfomation[] fetchData(String cityName) throws GoEuroApplicationException;

}
