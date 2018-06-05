package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class D_Class {
	@Autowired
	 A_Class a_Class;
	@Autowired
	 C_Class c_Class;
}
