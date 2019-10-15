package com.example.dozer.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户Domain
 *
 * @author fraser
 * @date 2019-05-27 11:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDomain {

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
	private AddressDomain address;

	/**
	 * 课程
	 */
	private List<CourseDomain> courses;

	/**
	 * 入学日期
	 */
	private String enrollmentDate;

	/**
	 * 分数
	 */
	private Integer score;
}
