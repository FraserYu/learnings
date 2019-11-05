package top.dayarch.learnings.rgybspringbootsample;

import org.junit.Test;

/**
 * Lambda Test
 *
 * @author fraser
 * @date 2019/10/24 11:09 AM
 */
public class LambdaTest {





	public void testRunnable(Runnable runnable){
		runnable.run();
	}


	@Test
	public void callTestRunnable1(){
		testRunnable(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello Runnable");
			}
		});
	}

	@Test
	public void callTestRunnable(){
		testRunnable(() -> System.out.println("hello Runnable"));
	}











}
