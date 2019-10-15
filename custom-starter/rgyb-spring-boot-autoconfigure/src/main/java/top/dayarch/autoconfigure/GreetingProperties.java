package top.dayarch.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 问候属性配置
 *
 * @author fraser
 * @date 2019/10/15 5:01 PM
 */
@Data
@ConfigurationProperties(prefix = "rgyb.greeting")
public class GreetingProperties {

	/**
	 * GreetingProperties 开关
	 */
	boolean enable = false;

	/**
	 * 需要打招呼的成员列表
	 */
	List<String> members = new ArrayList<String>();
}

