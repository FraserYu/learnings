package top.dayarch.memoryleak;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 内存溢出测试
 *
 * @author fraser
 * @date 2020/7/26 11:49 AM
 */
public class MemLeakTest {

	public static void main(String[] args) throws InterruptedException {
		Set<Person> set = new HashSet<Person>();

		Person p1 = new Person("zhangsan", 1);
		Person p2 = new Person("lisi", 2);
		Person p3 = new Person("wanger", 3);

		set.add(p1);
		set.add(p2);
		set.add(p3);

		System.out.println(set.size()); // 运行结果：3
		p3.setName("wangermao");
		set.remove(p3);
		System.out.println(set.size()); // 运行结果：3
		set.add(p3);
		System.out.println(set.size()); // 运行结果：4
		set.forEach(person -> {
			System.out.println(person.toString() + "|" + person.hashCode());
		});



//		map.put(p1, "zhangsan");
//		map.put(p2, "zhangsan");
//		map.put(p3, "zhangsan");

//		System.out.println(map.entrySet().size()); // 运行结果：3
//
////		Person p2 = new Person("lisi", 2);
////		Person p3 = new Person("wanger", 3);
//		Set<Person> set = new HashSet<Person>();

//
//		System.out.println(set.size());
//		p3.setName("wangermazi");
//		set.remove(p3);
//		System.out.println(set.size());
//		set.add(p3);
//		System.out.println(set.size());
//
//		for (Person person : set)
//		{
//			System.out.println(person);
//		}
//		System.out.println(p1.hashCode());
//		System.out.println(System.identityHashCode(p1));
//		System.out.println(System.identityHashCode(p1));
////		Person p3 = new Person("zhangsan");
////		Person p2 = new Person("lisi");
////		Person p3 = new Person("zhangsan");
////		map.put(p1, "hello");
////		map.put(p2, "world");
////		map.put(p3, "zhangsan");
//		System.out.println(map.get(p1));
//
////		p1.setName("zhangsanfeng");
////		System.out.println(map.get(p1));
////		System.out.println(map.entrySet().size());
////		System.out.println(map.get(new Person("zhangsan")));
////
//
//
////		System.out.println(p1.equals(p2));
////
////		map.put(p1, "zhangsan");
////		map.put(p2, "lisi");
////
////		System.out.println(p1.hashCode());
////		System.out.println(p3.hashCode());
////		System.out.println(map.get(p1));
////		p1.setName("zhangsanfeng");
////		System.out.println(p1.hashCode());
////		System.out.println(map.get(p1));
////		p1.setName("zhangsan");
////		System.out.println(map.get(p1));
////
////		System.out.println(new Person("zhangsan").hashCode());
////		System.out.println(new Person("zhangsan").hashCode());
////		System.out.println(map.get(new Person("zhangsan")));

	}

//	@EqualsAndHashCode

}

@Data
//@Getter
//@Setter
class Person {
	private String name;
	private Integer id;

	public Person(String name, Integer id){
		this.name = name;
		this.id = id;
	}
}