package com.example.dozer.demo.domain;

import lombok.Data;

/**
 * 地址domain
 *
 * @author fraser
 * @date 2019-05-28 10:24
 */
@Data
public class AddressDomain {

	/**
	 * 省
	 */
	private String province;

	/**
	 * 市
	 */
	private String city;

	/**
	 * 区
	 */
	private String district;

	/**
	 * 详细
	 */
	private String detail;
}
