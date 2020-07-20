package top.dayarch.topic07;

import lombok.Builder;
import lombok.Data;

/**
 * 模拟商品
 *
 * @author fraser
 * @date 2020/7/19 7:27 PM
 */
@Builder
@Data
public class Product {

	private Long id;
	private String name;
}
