package com.goeuro.service;

import com.goeuro.dto.CityInfomation;
import com.goeuro.exception.GoEuroApplicationException;

public interface ICSVService {

	public void exportToCSV(CityInfomation[] data) throws GoEuroApplicationException;
}
