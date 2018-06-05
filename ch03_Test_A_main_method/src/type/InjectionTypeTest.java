package type;

import java.util.Iterator;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectionTypeTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("root-context.xml");
		InjectionType type = 
			container.getBean("injectionType",InjectionType.class);
		
		System.out.println(type.integer);
		System.out.println(type.string);
		
		System.out.println(type.map.get("name"));
		System.out.println(type.map.get("job"));
		
		Iterator<Integer> it = type.set.iterator();
		
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		
		System.out.println(type.list.get(0));
		System.out.println(type.list.get(1));
		System.out.println(type.list.get(2));
		System.out.println(type.list.get(3));
		
		System.out.println((String)type.list.get(2)+10);
		System.out.println((Integer)type.list.get(3)+10);
	}
}







