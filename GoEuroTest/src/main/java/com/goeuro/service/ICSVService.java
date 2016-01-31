package com.goeuro.service;

import com.goeuro.dto.CityInfomation;

public interface ICSVService {

	public void exportToCSV(CityInfomation[] data);
}
