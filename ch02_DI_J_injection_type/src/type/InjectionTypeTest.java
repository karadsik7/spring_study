package type;

import java.util.Iterator;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectionTypeTest {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext container = new GenericXmlApplicationContext();
		
		container.load("root-context.xml");
		container.refresh();
		
		InjectionType it = container.getBean("injectionType", InjectionType.class);
		System.out.println(it.integer);
		System.out.println(it.string);
		
		System.out.println(it.map.get("name"));
		System.out.println(it.map.get("job"));
		
		for(int i : it.set) {
			System.out.println(i);
		}
		
		System.out.println(it.list);
		
		System.out.println((String)it.list.get(2) + 10);
		System.out.println((Integer)it.list.get(3) + 10);
		
		
		
		
	}
	
}
