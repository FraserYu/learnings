package com.example.dozer.demo.vo;

import lombok.Data;

/**
 * 地址vo
 *
 * @author fraser
 * @date 2019-05-28 10:25
 */
@Data
public class AddressVo {

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
	private String detailAddr;

}
