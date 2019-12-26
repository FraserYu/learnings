import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author fraser
 * @date 2019/11/25 9:55 AM
 */
public class Test {

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setName("日拱一兵");
		student1.setAge(18);

		Student student2 = new Student();
		student2.setName("日拱一兵");
		student2.setAge(18);

		System.out.println("student1.equals(student2)的结果是：" + student1.equals(student2));

		Set<Student> students = new HashSet<Student>();
		students.add(student1);
		students.add(student2);
		System.out.println("Student Set 集合长度是：" + students.size());

		Map<Student, java.lang.String> map = new HashMap<Student, java.lang.String>();
		map.put(student1, "student1");
		map.put(student2, "student2");
		System.out.println("Student Map 集合长度是：" + map.keySet().size());
	}
}
