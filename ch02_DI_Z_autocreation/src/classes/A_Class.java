package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A_Class {
	@Autowired
	B_Class b_Class;
	@Autowired
	C_Class c_Class;
}
