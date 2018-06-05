package type;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class InjectionType {
	
	int integer;
	String string;
	
	public InjectionType(int integer, String string) {
		this.integer = integer;
		this.string = string;
	}
	
	Map<String, String> map;
	Set<Integer> set;
	List<Object> list;

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public void setSet(Set<Integer> set) {
		this.set = set;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	
	
	
}
