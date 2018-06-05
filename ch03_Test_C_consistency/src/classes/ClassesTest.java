package classes;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ClassesTest {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext container = new GenericXmlApplicationContext();
		
		container.load("root-context.xml");
		container.refresh();
		
		AClass aClass = container.getBean("aClass", AClass.class);
		System.out.println(aClass.cClass.age);
		System.out.println(aClass.bClass.eClass.dClass.cClass.name);
		System.out.println(aClass.cClass == aClass.bClass.eClass.dClass.cClass);
		
		
		
	}
	
	
	
}
