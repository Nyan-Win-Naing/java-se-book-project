package com.jdc.app.util;

import java.text.DecimalFormat;

import javafx.util.StringConverter;

public class TableFormatter extends StringConverter<Integer> {

	private static DecimalFormat DF = new DecimalFormat("#,##0");
	
	@Override
	public String toString(Integer data) {
		if (data != null) {
			return DF.format(data);
		}
		return null;
	}

	@Override
	public Integer fromString(String str) {
		try {
			if (!str.isEmpty()) {
				return DF.parse(str).intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
