package com.demo.interceptor.annotation;

import java.lang.annotation.*;

/**
 * 需要加解密的类注解
 *
 * @author fraser
 * @date 2019-05-15 11:11
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptDecryptClass {
}
