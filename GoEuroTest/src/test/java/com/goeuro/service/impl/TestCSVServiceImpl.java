package com.goeuro.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import au.com.bytecode.opencsv.CSVReader;

import com.goeuro.dto.CityInfomation;
import com.goeuro.exception.GoEuroApplicationException;

@RunWith(EasyMockRunner.class)
public class TestCSVServiceImpl {

	@TestSubject
	private static CSVServiceImpl csvServiceImpl = new CSVServiceImpl();

	@BeforeClass
	public static void init() {
		csvServiceImpl.setCsvHeader("_id, name, type, latitude, longitude");
	}

	@Test
	public void testExportToCSV() throws GoEuroApplicationException {
		try {
			CityInfomation[] obj = new CityInfomation[2];
			CityInfomation cityInfomation = null;
			for (int i = 0; i < 2; i++) {
				cityInfomation = new CityInfomation();
				cityInfomation.set_id(new Long(i));
				cityInfomation.setName("test-" + i);
				obj[i] = cityInfomation;
			}

			csvServiceImpl.exportToCSV(obj);
			String[] row = null;
			String csvFilename = "GO_EURO.csv";

			@SuppressWarnings("resource")
			CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
			@SuppressWarnings("rawtypes")
			List content = csvReader.readAll();
			int count = 0;
			for (Object object : content) {
				row = (String[]) object;
				if (count > 0) {
					Assert.assertEquals(row[0], obj[count - 1].get_id()
							.toString());
				}
				++count;
			}

			File file = new File(csvFilename);
			file.delete();
		} catch (IOException e) {

		}
	}

}
