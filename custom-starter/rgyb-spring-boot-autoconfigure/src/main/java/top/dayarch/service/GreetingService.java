package top.dayarch.service;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 问候service
 *
 * @author fraser
 * @date 2019/10/15 4:58 PM
 */
@AllArgsConstructor
public class GreetingService {

	private List<String> members = new ArrayList<String>();

	public void sayHello(){
		members.forEach(s -> System.out.println("hello " + s));
	}
}
