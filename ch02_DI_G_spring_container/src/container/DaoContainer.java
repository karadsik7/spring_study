package container;

import org.springframework.context.annotation.Bean;

import com.inc.dao.CommentDao;
import com.inc.dao.UserDao;
import com.inc.util.MysqlConnector;
import com.inc.util.OracleConnector;


public class DaoContainer {
	
	//UserDao의 커넥터 타입 의존관계 설정
	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao(oracleConnector());
		return userDao;
	}
	
	@Bean
	public CommentDao commentDao() {
		CommentDao commentDao = new CommentDao(mysqlConnector());
		return commentDao;
	}
	
	@Bean
	public OracleConnector oracleConnector() {
		return new OracleConnector();
	}
	
	@Bean
	public MysqlConnector mysqlConnector() {
		return new MysqlConnector();
	}
	
	
}
