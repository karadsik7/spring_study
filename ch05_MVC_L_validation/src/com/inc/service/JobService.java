
package com.inc.service;

import java.util.List;

import com.inc.dao.JobDao;
import com.inc.vo.BjobVo;
import com.inc.vo.SjobVo;

public class JobService {
	private JobDao jobDao;
	
	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}
	
	public List<BjobVo> getBjobList() {
		List<BjobVo> bjobList = jobDao.selectBjobList();
		return bjobList;
	}

	public List<SjobVo> getSjobList(int b_id) {
		List<SjobVo> sjobList = jobDao.selectSjobList(b_id);
		return sjobList;
	}

}
