package com.example.unifiedreturn.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * String 2 Localdatetime 转换器
 *
 * @author fraser
 * @date 2019/12/12 1:14 PM
 */
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
	@Override
	public LocalDateTime convert(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
		return LocalDateTime.parse(s, formatter);
	}
}
