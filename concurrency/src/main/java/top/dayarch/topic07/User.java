package top.dayarch.topic07;

import lombok.Builder;
import lombok.Data;

/**
 * 用户
 *
 * @author fraser
 * @date 2020/7/19 7:58 PM
 */
@Builder
@Data
public class User {

	private Long id;
	private String name;
}
