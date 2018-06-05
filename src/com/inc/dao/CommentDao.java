package com.inc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.inc.util.OracleConnector;

public class CommentDao {

	public void add() throws ClassNotFoundException, SQLException {
		//코드 있다고 가정
		Connection conn = OracleConnector.getInstance().getConnection();
	}
	
	public void get() throws ClassNotFoundException, SQLException {
		//코드 있다고 가정
		Connection conn = OracleConnector.getInstance().getConnection();
	}
	
	/*private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"spring", "1111");
		
		return conn;
	}*/
	
	//그러나 이 Dao에서도 jdbc 커넥터를 생성하기 위한 getConnection() 메서드가 필요함
	//Dao의 기능으로 유추해볼 때 커넥터를 생성하는 기능은 Dao 내부에 있으면 결합도 증가
	//결과적으로 클래스 간 코드의 중복이 일어남
	//클래스 단위로 분리해 재사용 가능하도록 리팩토링
}
