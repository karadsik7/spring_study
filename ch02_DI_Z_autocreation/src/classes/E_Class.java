package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class E_Class {
	@Autowired
	 A_Class a_Class;
	@Autowired
	 D_Class d_Class;
}
