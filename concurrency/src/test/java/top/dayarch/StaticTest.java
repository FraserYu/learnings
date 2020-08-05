package top.dayarch;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 静态变量使用
 *
 * @author fraser
 * @date 2020/7/29 11:08 AM
 */
@Slf4j
public class StaticTest {
	public static List<Double> list = new ArrayList<>();

	public void populateList() {
		List<Double> list = new ArrayList<>();
		for (int i = 0; i < 10000000; i++) {
			list.add(Math.random());
		}
	}

	public static void main(String[] args) {
		new StaticTest().populateList();
	}
}
