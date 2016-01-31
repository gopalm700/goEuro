package com.goeuro.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.goeuro.dto.CityInfomation;
import com.goeuro.service.ICSVService;
import com.goeuro.service.IGetResultService;
import com.goeuro.service.IGoEuroService;
import com.goeuro.service.validator.DataValidator;

public class GoEuroServiceImpl implements IGoEuroService{

	Log log = LogFactory.getLog(GoEuroServiceImpl.class);
	
	private DataValidator dataValidator;
	
	private ICSVService csvService;
	
	private IGetResultService getResultService;

	@Override
	public void startProcess(String[] data) {
		log.info("Process started!");
		if(dataValidator.validateData(data) == false){
			log.error("Invalid Data");	
		}
		else{
			CityInfomation[] cityList = getResultService.fetchData(data[0]);
			csvService.exportToCSV(cityList);
		}
		
	}

	public DataValidator getDataValidator() {
		return dataValidator;
	}

	public void setDataValidator(DataValidator dataValidator) {
		this.dataValidator = dataValidator;
	}

	public ICSVService getCsvService() {
		return csvService;
	}

	public void setCsvService(ICSVService csvService) {
		this.csvService = csvService;
	}

	public IGetResultService getGetResultService() {
		return getResultService;
	}

	public void setGetResultService(IGetResultService getResultService) {
		this.getResultService = getResultService;
	}
	
	
	
}
