package com.example.dozer.demo.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户Vo
 *
 * @author fraser
 * @date 2019-05-27 11:43
 */
@Data
public class StudentVo {

	/**
	 * 身份ID
	 */
	private Long id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 电话
	 */
	private String mobile;

	/**
	 * 地址
	 */
	private AddressVo address;

	/**
	 * 课程
	 */
	private List<CourseVo> courses;
//
	/**
	 * 班主任
	 */
	private String counsellor;

	/**
	 * 入学日期
	 */
	private Date enrollmentDate;

	/**
	 * 分数
	 */
	private ScoreEnum score;

}
