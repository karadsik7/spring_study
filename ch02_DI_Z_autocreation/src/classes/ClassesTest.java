package classes;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ClassesTest {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext container = new GenericXmlApplicationContext();
		
		container.load("root-context.xml");
		container.refresh();
		
		A_Class a_Class = container.getBean("a_Class", A_Class.class);
		System.out.println(a_Class.c_Class.age);
		System.out.println(a_Class.b_Class.e_Class.d_Class.c_Class.name);
		System.out.println(a_Class.c_Class == a_Class.b_Class.e_Class.d_Class.c_Class);
		
		
		
	}
	
	
	
}
