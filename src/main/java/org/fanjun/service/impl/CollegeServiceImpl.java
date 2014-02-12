package org.fanjun.service.impl;

import java.util.List;

import org.fanjun.dao.CollegeDao;
import org.fanjun.dao.StudentDao;
import org.fanjun.model.College;
import org.fanjun.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CollegeServiceImpl implements CollegeService {

	
	@Autowired
	private CollegeDao collegeDao;
	@Transactional
	public void add(College college) {
		// TODO Auto-generated method stub
		collegeDao.add(college);
	}

	@Transactional
	public void edit(College college) {
		// TODO Auto-generated method stub
		collegeDao.edit(college);
	}

	@Transactional
	public void delete(int collegeId) {
		// TODO Auto-generated method stub
		collegeDao.delete(collegeId);
	}

	@Transactional
	public College getCollege(int collegeId) {
		// TODO Auto-generated method stub
		return collegeDao.getCollege(collegeId);
	}

	@Transactional
	public List getAllCollege() {
		// TODO Auto-generated method stub
		return collegeDao.getAllCollege();
	}

	@Transactional
	public List getAllStuentInCollege() {
		// TODO Auto-generated method stub
		return collegeDao.getAllStuentInCollege();
	}

}
