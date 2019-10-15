package com.example.dozer.demo.vo;

import lombok.Data;

/**
 * 课程
 *
 * @author fraser
 * @date 2019-05-28 21:16
 */

@Data
public class CourseVo {

	/**
	 * 课程编码
	 */
	private String courseCode;

	/**
	 * 课程Id
	 */
	private String courseId;

	/**
	 * 课程名称
	 */
	private String courseName;

	/**
	 * 老师名称
	 */
	private String teacherName;

}
