package com.example.dozer.demo;

import com.example.dozer.demo.domain.AddressDomain;
import com.example.dozer.demo.domain.CourseDomain;
import com.example.dozer.demo.domain.StudentDomain;
import com.example.dozer.demo.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

	@Autowired
	private Mapper dozerMapper;

	@Test
	public void contextLoads() {
	}


//	@Test
//	public void testDefault(){
//		StudentDomain studentDomain = new StudentDomain(1024L, "tan日拱一兵", 18, "18888888888");
//
//		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class);
//		log.info("StudentVo: [{}]", studentVo.toString());
//
//		studentVo.setAge(16);
//		log.info("StudentDomain: [{}]", dozerMapper.map(studentVo, StudentDomain.class));
//	}


	@Test
	public void testCascadeObject() {
		StudentDomain studentDomain = getStudentDomain();

		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class);
		log.info("StudentVo: [{}]", studentVo.toString());
	}


	@Test
	public void testUserAllProperties() {
		StudentDomain studentDomain = getStudentDomain();

		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userAllProperties");
		log.info("StudentVo: [{}]", studentVo.toString());

//		运行结果
//		StudentVo: [StudentVo(id=1024, name=tan日拱一兵, age=18, mobile=13333333333, addr=AddressVo(province=辽宁, city=大连, district=高新园区))]
	}


	@Test
	public void testUserExcludeMobile() {
		StudentDomain studentDomain = getStudentDomain();
		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userExcludeMobile");
		log.info("StudentVo: [{}]", studentVo.toString());
//		运行结果
//		StudentVo: [StudentVo(id=1024, name=tan日拱一兵, age=18, mobile=null, addr=AddressVo(province=辽宁, city=大连, district=高新园区))]
	}


	//TODO
	@Test
	public void testUserNonNullAndExcludeMobile() {
		StudentDomain studentDomain = getStudentDomain();
		studentDomain.setName(null);
		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userNonNullAndExcludeMobile");
		log.info("StudentVo: [{}]", studentVo.toString());
	}

	@Test
	public void testUserWildcardFalse() {
		StudentDomain studentDomain = getStudentDomain();
		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userWildcardFalse");
		log.info("StudentVo: [{}]", studentVo.toString());
//		运行结果
//		StudentVo: [StudentVo(id=null, name=null, age=null, mobile=null, addr=AddressVo(province=辽宁, city=大连, district=高新园区))]
	}

	@Test
	public void testUserFieldUseSpecifiedMapId() {
		StudentDomain studentDomain = getStudentDomain();
		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userFieldUseSpecifiedMapId");
		log.info("StudentVo: [{}]", studentVo.toString());
//		运行结果
//		StudentVo: [StudentVo(id=null, name=null, age=null, mobile=null, addr=AddressVo(province=辽宁, city=大连, district=高新园区, detailAddr=腾飞软件园))]
	}

	@Test
	public void testUserOneWay() {
		StudentDomain studentDomain = getStudentDomain();

		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userOneWay");
		log.info("StudentVo: [{}]", studentVo.toString());

		studentVo.setAge(16);
		log.info("studentDomain: [{}]", dozerMapper.map(studentVo, StudentDomain.class, "userOneWay"));

		//运行结果：
//org.dozer.MappingException: Class mapping not found by map-id: SRC-CLASS->com.example.dozer.demo.vo.StudentVo DST-CLASS->com.example.dozer.demo.domain.StudentDomain MAP-ID->userOneWay
	}

	@Test
	public void testUserFieldOneWay() {
		StudentDomain studentDomain = getStudentDomain();

		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userFieldOneWay");
		log.info("StudentVo: [{}]", studentVo.toString());

		studentVo.setAge(16);
		log.info("studentDomain: [{}]", dozerMapper.map(studentVo, StudentDomain.class, "userFieldOneWay"));

		//运行结果：
		//StudentVo: [StudentVo(id=1024, name=tan日拱一兵, age=18, mobile=13333333333, addr=null)]
		//studentDomain: [StudentDomain(id=1024, name=tan日拱一兵, age=null, mobile=13333333333, address=null)]

	}


	@Test
	public void testUserDeepMapping() {
		StudentDomain studentDomain = getStudentDomain();

		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userDeepMapping");
		log.info("StudentVo: [{}]", studentVo.toString());

		//运行结果：
		//StudentVo: [StudentVo(id=1024, name=tan日拱一兵, age=18, mobile=13333333333, addr=null)]
		//studentDomain: [StudentDomain(id=1024, name=tan日拱一兵, age=null, mobile=13333333333, address=null)]

	}

	@Test
	public void testUserScoreConverter() {
		StudentDomain studentDomain = getStudentDomain();

		StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userScoreConverter");
		log.info("StudentVo: [{}]", studentVo.toString());

	}


	private StudentDomain getStudentDomain() {
		StudentDomain studentDomain = new StudentDomain();
		studentDomain.setId(1024L);
		studentDomain.setName("tan日拱一兵");
		studentDomain.setAge(18);
		studentDomain.setMobile("13996996996");
		studentDomain.setScore(90);

		AddressDomain addressDomain = new AddressDomain();
		addressDomain.setProvince("北京");
		addressDomain.setCity("北京");
		addressDomain.setDistrict("海淀区");
		addressDomain.setDetail("西二旗");
		studentDomain.setAddress(addressDomain);

		List<CourseDomain> courseDomains = new ArrayList<>(2);
		CourseDomain englishCourse = new CourseDomain();
		englishCourse.setCourseId(1);
		englishCourse.setCourseCode("English");
		englishCourse.setCourseName("英语");
		englishCourse.setTeacherName("京晶");
		courseDomains.add(englishCourse);

		CourseDomain chineseCourse = new CourseDomain();
		chineseCourse.setCourseId(2);
		chineseCourse.setCourseCode("Chinese");
		chineseCourse.setCourseName("语文");
		chineseCourse.setTeacherName("水寒");
		courseDomains.add(chineseCourse);

		studentDomain.setCourses(courseDomains);
		studentDomain.setEnrollmentDate("2019-09-01 10:00:00");

		return studentDomain;
	}

}
