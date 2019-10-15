package com.example.unifiedreturn.vo;

import lombok.Builder;
import lombok.Data;

/**
 * 用户vo
 *
 * @author fraser
 * @date 2019-08-08 17:14
 */
@Data
@Builder
public class UserVo {

	private Long id;

	private String name;

	private Integer age;
}
