package container;

import com.inc.dao.CommentDao;
import com.inc.dao.UserDao;
import com.inc.util.MysqlConnector;
import com.inc.util.OracleConnector;

public class DaoContainer {
	
	//UserDao의 커넥터 타입 의존관계 설정
	public UserDao userDao() {
		UserDao userDao = new UserDao(new OracleConnector());
		return userDao;
	}
	
	public CommentDao commentDao() {
		CommentDao commentDao = new CommentDao(new MysqlConnector());
		return commentDao;
	}
	
	
}
