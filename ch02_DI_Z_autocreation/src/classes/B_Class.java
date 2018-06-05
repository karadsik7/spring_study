package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B_Class {
	@Autowired
	 C_Class c_Class;
	@Autowired
	 E_Class e_Class;
}
