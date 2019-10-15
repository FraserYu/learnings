package com.demo.interceptor.annotation;

import java.lang.annotation.*;

/**
 * 加密字典注解
 *
 * @author fraser
 * @date 2019-05-15 11:08
 */
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptDecryptField {

}
