package com.example.unifiedreturn.converter;

import com.example.unifiedreturn.vo.Modes;
import org.springframework.core.convert.converter.Converter;

/**
 * String 2 Enum 转换器
 *
 * @author fraser
 * @date 2019/12/12 1:50 PM
 */
public class StringToEnumConverter implements Converter<String, Modes> {

	@Override
	public Modes convert(String s) {
		return Modes.valueOf(s);
	}
}
