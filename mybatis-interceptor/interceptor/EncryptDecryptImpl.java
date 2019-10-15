package com.demo.interceptor;

/**
 * 加解密接口实现
 *
 * @author fraser
 * @date 2019-05-20 15:00
 */
@Component
public class EncryptDecryptImpl implements IEncryptDecrypt {
	@Override
	public <T> T encrypt(Field[] declaredFields, T parameterObject) throws IllegalAccessException {
		return EncryptDecryptUtils.encrypt(declaredFields, parameterObject);
	}

	@Override
	public <T> T decrypt(T result) throws IllegalAccessException {
		return EncryptDecryptUtils.decrypt(result);
	}
}
