package com.example.dozer.demo.converter;

import com.example.dozer.demo.vo.ScoreEnum;
import org.dozer.DozerConverter;

/**
 * 分数Converter
 *
 * @author fraser
 * @date 2019-05-30 10:53
 */
public class ScoreConverter extends DozerConverter<Integer, ScoreEnum> {


	public ScoreConverter() {
		super(Integer.class, ScoreEnum.class);
	}

	@Override
	public ScoreEnum convertTo(Integer score, ScoreEnum scoreEnum) {
		if (60 <= score && score < 80) {
			return ScoreEnum.C;
		} else if (80 <= score && score < 90) {
			return ScoreEnum.B;
		} else if (90 <= score) {
			return ScoreEnum.A;
		} else {
			return ScoreEnum.D;
		}
	}

	@Override
	public Integer convertFrom(ScoreEnum scoreEnum, Integer integer) {
		return null;
	}
}
