package com.goeuro.service;

import com.goeuro.dto.CityInfomation;

public interface IGetResultService {
	
	public CityInfomation[] fetchData(String cityName);

}
