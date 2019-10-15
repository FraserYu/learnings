package com.example.dozer.demo.config;

import com.example.dozer.demo.converter.ScoreConverter;
import com.example.dozer.demo.domain.AddressDomain;
import com.example.dozer.demo.domain.StudentDomain;
import com.example.dozer.demo.listener.StudentListener;
import com.example.dozer.demo.vo.AddressVo;
import com.example.dozer.demo.vo.StudentVo;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.DozerEventListener;
import org.dozer.Mapper;
import org.dozer.fieldmap.DozerField;
import org.dozer.loader.DozerBuilder;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOption;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;

import static org.dozer.loader.api.FieldsMappingOptions.customConverter;

/**
 * Dozer 配置类
 *
 * @author fraser
 * @date 2019-05-27 11:36
 */
@Configuration
public class DozerConfig {

	@Bean
	public Mapper dozerMapper() {
		Mapper mapper = DozerBeanMapperBuilder.create()
				// 1.这里我们可指定 dozer mapping 的配置文件，可添加多个 xml 文件，用逗号隔开即可
				// 2. 也可以通过 YAML 的方式配置,
				.withMappingFiles("dozerBeanMapping.xml")
				.withMappingBuilder(beanMappingBuilder())
				.withEventListener(studentListener())
				.build();
		return mapper;
	}

	@Bean
	public DozerEventListener studentListener() {
		return new StudentListener();
	}


	@Bean
	public BeanMappingBuilder beanMappingBuilder() {
		return new BeanMappingBuilder() {
			@Override
			protected void configure() {
//				//地址映射
				mapping(AddressDomain.class, AddressVo.class/*, TypeMappingOptions.mapId("addrAllProperties"),TypeMappingOptions.dateFormat("yyyy-MM-dd")*/)
						.fields("detail", "detailAddr");
//
//				//测试所有properties，为不同名的 property 手动配置映射关系
//				mapping(StudentDomain.class, StudentVo.class/*, TypeMappingOptions.mapId("userAllProperties")*/)
//					.fields("address", "addr");
//
				//测试所有properties，为不同名的 property 手动配置映射关系，排除 mobile 字段
//				mapping(StudentDomain.class, StudentVo.class, TypeMappingOptions.mapId("userExcludeMobile"))
//						.exclude("mobile")
//						.fields("address", "addr");
//
//				//测试所有properties，为不同名的 property 手动配置映射关系，排除 mobile 字段,空字段不显示
//				mapping(StudentDomain.class, StudentVo.class, TypeMappingOptions.mapId("userNonNullAndExcludeMobile"), TypeMappingOptions.mapEmptyString(true))
//						.exclude("mobile")
//						.fields("address", "addr");
//
//				//测试指定properties
//				mapping(StudentDomain.class, StudentVo.class, TypeMappingOptions.mapId("userWildcardFalse"), TypeMappingOptions.wildcard(false))
//						.fields("address", "addr");
//
//				//测试指定properties并指定mapid
//				mapping(StudentDomain.class, StudentVo.class, TypeMappingOptions.mapId("userFieldUseSpecifiedMapId"), TypeMappingOptions.wildcard(false))
//						.fields("address", "addr", FieldsMappingOptions.useMapId("addrAllProperties"));
//
				//关闭隐式匹配
//				mapping(StudentDomain.class, StudentVo.class, TypeMappingOptions.wildcard(false))
//					.fields("address", "addr");
//
//				//测试mapping oneway
//				mapping(StudentDomain.class, StudentVo.class, TypeMappingOptions.mapId("userOneWay"), TypeMappingOptions.oneWay())
//						.fields("address", "addr", FieldsMappingOptions.useMapId("addrAllProperties"));
//
//				//测试field oneway
//				mapping(StudentDomain.class, StudentVo.class, TypeMappingOptions.mapId("userFieldOneWay"))
//						.fields("age", "age", FieldsMappingOptions.useMapId("addrAllProperties"),FieldsMappingOptions.oneWay());
//
//				//测试深度索引匹配
//				mapping(StudentDomain.class, StudentVo.class/*, TypeMappingOptions.mapId("userDeepMapping")*/, TypeMappingOptions.dateFormat("yyyy-MM-dd"))
//						.fields("courses[0].teacherName", "counsellor");
//
//				//测试自定义converter
//				mapping(StudentDomain.class, StudentVo.class/*, TypeMappingOptions.mapId("userScoreConverter")*/)
//						.fields("score", "score", customConverter(ScoreConverter.class));

				mapping(StudentDomain.class, StudentVo.class/*, TypeMappingOptions.mapId("userScoreConverter")*/)
						.fields(field("enrollmentDate"), "enrollmentDate");
			}
		};

	}

}
