import java.util.Objects;

/**
 * 学生类
 *
 * @author fraser
 * @date 2019/12/16 9:34 PM
 */
public class Student {

	private String name;

	private int age;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return age == student.age &&
				Objects.equals(name, student.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
