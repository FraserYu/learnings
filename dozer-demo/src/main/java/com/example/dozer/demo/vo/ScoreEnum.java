package com.example.dozer.demo.vo;

/**
 * 分数枚举
 *
 * @author fraser
 * @date 2019-05-30 10:12
 */
public enum ScoreEnum {

	/**
	 * 优秀
	 */
	A("优秀"),

	/**
	 * 良
	 */
	B("良"),

	/**
	 * 及格
	 */
	C("及格"),

	/**
	 * 不及格
	 */
	D("不及格");

	private final String name;

	ScoreEnum(String name) {
		this.name = name;
	}
}
