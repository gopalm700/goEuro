package com.goeuro.service.validator;

import org.apache.commons.lang3.StringUtils;

public class DataValidator {
	
	public boolean validateData(String[] data){
		
		if(data != null && data.length ==1){
			String city = data[0];
			if(StringUtils.isNotBlank(city) && StringUtils.isAlpha(city)){
				return true;
			}
		}
		return false;
	}

}
