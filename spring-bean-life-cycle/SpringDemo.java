public class SpringDemo {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Book book = (Book) context.getBean("book");
		System.out.println("Book Name:" + book.getBookName());
		context.registerShutdownHook();
	}
}
