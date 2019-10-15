package com.example.unifiedreturn.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Api统一结果
 *
 * @author fraser
 * @date 2019-08-08 16:57
 */
@Data
public final class CommonResult<T> {

	private int status = 1;

	private String errorCode = "";

	private String errorMsg = "";

	private T resultBody;

	public CommonResult() {
	}

	public CommonResult(T resultBody) {
		this.resultBody = resultBody;
	}

	public CommonResult(int status, T resultBody) {
		this.status = status;
		this.resultBody = resultBody;
	}

	public static <T> CommonResult<T> errorResult(String errorCode, String errorMsg) {
		CommonResult<T> commonResult = new CommonResult<>();
		commonResult.errorCode = errorCode;
		commonResult.errorMsg = errorMsg;
		commonResult.status = -1;
		return commonResult;
	}
}
