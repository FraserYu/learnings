package com.example.dozer.demo.domain;

import lombok.Data;

/**
 * 课程
 *
 * @author fraser
 * @date 2019-05-28 21:13
 */
@Data
public class CourseDomain {

	/**
	 * 课程编码
	 */
	private String courseCode;

	/**
	 * 课程Id
	 */
	private Integer courseId;

	/**
	 * 课程名称
	 */
	private String courseName;

	/**
	 * 老师名称
	 */
	private String teacherName;

}
