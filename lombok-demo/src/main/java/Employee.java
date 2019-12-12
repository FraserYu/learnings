import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

/**
 * 员工，用于说明lombok
 *
 * @author fraser
 * @date 2019/11/24 8:56 PM
 */

@RequiredArgsConstructor
public class Employee {

	final private Long id;

	@NonNull private String name;

	private static Integer age;

	private String password;

}
