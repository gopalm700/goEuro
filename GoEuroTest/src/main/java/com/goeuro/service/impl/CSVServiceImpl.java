package com.goeuro.service.impl;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import au.com.bytecode.opencsv.CSVWriter;

import com.goeuro.dto.CityInfomation;
import com.goeuro.service.ICSVService;

public class CSVServiceImpl implements ICSVService {

	private static Log log = LogFactory.getLog(CSVServiceImpl.class);

	private String csvHeader;

	@Override
	public void exportToCSV(CityInfomation[] data) {

		log.info("Started Creating Data Excel File for " + csvHeader);
		String csv = "GO_EURO.csv";
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(csv));
		//header
			writer.writeNext(csvHeader.split(","));
			if (data != null) {
				for (CityInfomation cityInfomation : data) {
					String[] record = cityInfomation.toCSVString().split(",");
					writer.writeNext(record);
				}

			}
		} catch (IOException e) {
			log.error("Exception occured while exporting to csv", e);
		} finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public String getCsvHeader() {
		return csvHeader;
	}

	public void setCsvHeader(String csvHeader) {
		this.csvHeader = csvHeader;
	}

}
