package com.example.unifiedreturn.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 业务异常
 *
 * @author fraser
 * @date 2019-08-09 11:10
 */
@Data
@AllArgsConstructor
public final class BusinessException extends RuntimeException {

	private String errorCode;

	private String errorMsg;

}
