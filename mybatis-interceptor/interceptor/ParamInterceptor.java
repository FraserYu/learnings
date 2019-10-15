package com.demo.interceptor;

/**
 * Mybatis 参数拦截器
 *
 * @author fraser
 * @date 2019-05-15 12:50
 */


@Intercepts({
		@Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class),
})
@ConditionalOnProperty(value = "domain.encrypt", havingValue = "true")
@Component
@Slf4j
public class ParamInterceptor implements Interceptor {

	@Autowired
	private IEncryptDecrypt encryptDecrypt;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		log.info("拦截器ParamInterceptor");
		//拦截 ParameterHandler 的 setParameters 方法 动态设置参数
		if (invocation.getTarget() instanceof ParameterHandler) {
			ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
			PreparedStatement ps = (PreparedStatement) invocation.getArgs()[0];

			// 反射获取 BoundSql 对象，此对象包含生成的sql和sql的参数map映射
			/*Field boundSqlField = parameterHandler.getClass().getDeclaredField("boundSql");
			boundSqlField.setAccessible(true);
			BoundSql boundSql = (BoundSql) boundSqlField.get(parameterHandler);*/

			// 反射获取 参数对像
			Field parameterField =
					parameterHandler.getClass().getDeclaredField("parameterObject");
			parameterField.setAccessible(true);
			Object parameterObject = parameterField.get(parameterHandler);
			if (Objects.nonNull(parameterObject)) {
				Class<?> parameterObjectClass = parameterObject.getClass();
				EncryptDecryptClass encryptDecryptClass = AnnotationUtils.findAnnotation(parameterObjectClass, EncryptDecryptClass.class);
				if (Objects.nonNull(encryptDecryptClass)) {
					Field[] declaredFields = parameterObjectClass.getDeclaredFields();

					final Object encrypt = encryptDecrypt.encrypt(declaredFields, parameterObject);
				}
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object o) {
		return Plugin.wrap(o, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}
}

