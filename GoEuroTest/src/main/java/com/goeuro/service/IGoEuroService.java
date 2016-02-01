package com.goeuro.service;

import com.goeuro.exception.GoEuroApplicationException;

public interface IGoEuroService {
	public void startProcess(String []data) throws GoEuroApplicationException;
}
