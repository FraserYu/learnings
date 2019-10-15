package com.example.easyexcel.demo.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.example.easyexcel.demo.converter.GenderConverter;
import lombok.Data;

import java.util.Date;

/**
 * 用户人员实体
 *
 * @author fraser
 * @date 2019/10/6 10:05 AM
 */
@Data
public class User {

	/**
	 * 姓名
	 */
	@ExcelProperty(index = 0)
	private String name;

	/**
	 * 年龄
	 */
	@ExcelProperty(index = 1)
	private Integer age;

	/**
	 * 性别 1：男；2：女
	 */
	@ExcelProperty(index = 2, converter = GenderConverter.class)
	private Integer gender;

	/**
	 * 出生日期
	 */
	@ExcelProperty(index = 3)
	@DateTimeFormat("yyyy-MM-dd HH:mm:ss")
	private String birth;

	/**
	 * 是否已婚
	 */
//	@ExcelProperty(index = 4)
//	@ExcelIgnore
//	private boolean married;
}
