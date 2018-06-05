package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inc.vo.UserVo;

public interface UserDaoInterface {
	public void add(UserVo uvo) throws ClassNotFoundException, SQLException;

	public UserVo get(String id) throws ClassNotFoundException, SQLException;

	public void deleteAll() throws ClassNotFoundException, SQLException;
}
