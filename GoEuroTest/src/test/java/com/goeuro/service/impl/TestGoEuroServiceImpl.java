package com.goeuro.service.impl;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.goeuro.dto.CityInfomation;
import com.goeuro.service.ICSVService;
import com.goeuro.service.IGetResultService;
import com.goeuro.service.validator.DataValidator;

@RunWith(EasyMockRunner.class)
public class TestGoEuroServiceImpl {

	@TestSubject
	private GoEuroServiceImpl goEuroServiceImpl = new GoEuroServiceImpl();

	@Mock
	private DataValidator dataValidator;

	@Mock
	private ICSVService csvService;

	@Mock
	private IGetResultService getResultService;

	@Test
	public void teststartProcess() {
		String[] arr = { "berlin", "munich" };
		CityInfomation[] cityInfomation = new CityInfomation[2];
		EasyMock.expect(
				dataValidator.validateData(EasyMock.isA(String[].class)))
				.andReturn(true);
		EasyMock.expect(getResultService.fetchData(EasyMock.isA(String.class)))
				.andReturn(cityInfomation);
		csvService.exportToCSV(cityInfomation);
		EasyMock.expectLastCall();
		EasyMock.replay(dataValidator, getResultService, csvService);

		goEuroServiceImpl.startProcess(arr);
		EasyMock.verify(dataValidator, getResultService, csvService);
	}

	@Test
	public void teststartProcessInvalidData() {
		String[] arr = { "berlin", "munich" };
		EasyMock.expect(
				dataValidator.validateData(EasyMock.isA(String[].class)))
				.andReturn(false);
		EasyMock.replay(dataValidator);
		goEuroServiceImpl.startProcess(arr);
		EasyMock.verify(dataValidator);
	}

}
