package com.example.easyexcel.demo.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * 性别converter
 *
 * @author fraser
 * @date 2019/10/7 9:26 AM
 */
public class GenderConverter implements Converter<Integer> {

	public static final String MALE = "男";
	public static final String FEMALE = "女";

	@Override
	public Class supportJavaTypeKey() {
		return Integer.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public Integer convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
		String stringValue = cellData.getStringValue();
		if (MALE.equals(stringValue)){
			return 1;
		}else {
			return 2;
		}
	}

	@Override
	public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
		return null;
	}
}
