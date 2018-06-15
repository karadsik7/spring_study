package com.inc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.inc.vo.BjobVo;
import com.inc.vo.SjobVo;

public class JobDao {

	private SqlSession session;
	
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	
	public List<BjobVo> selectBjobList(){
		return session.selectList("bjob.selectList");
	}

	public List<SjobVo> selectSjobList(int b_id) {
		List<SjobVo> sjobList = session.selectList("sjob.selectList", b_id);
		return sjobList;
	}
	
	
}
