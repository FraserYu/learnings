package com.example.configurationproperties.converter;

import com.example.configurationproperties.entity.Weight;
import org.springframework.core.convert.converter.Converter;

/**
 * @author fraser
 * @date 2019-07-24 15:07
 */
public class WeightConverter implements Converter<String, Weight> {

	@Override
	public Weight convert(String source) {
		return Weight.fromString(source);
	}

}