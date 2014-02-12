package org.fanjun.dao.impl;

import java.util.List;

import org.fanjun.dao.CollegeDao;
import org.fanjun.model.College;
import org.fanjun.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CollegeDaoImp implements CollegeDao {

	
	@Autowired
	private SessionFactory session;
	@Override
	public void add(College college) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(college);
	}

	@Override
	public void edit(College college) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(college);
	}

	@Override
	public void delete(int collegeId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getCollege(collegeId));
	}

	@Override
	public College getCollege(int collegeId) {
		// TODO Auto-generated method stub
		
		return (College)session.getCurrentSession().get(College.class, collegeId);
	}

	@Override
	public List getAllCollege() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from College").list();
	}

	@Override
	public List getAllStuentInCollege() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Student where college_Id =1 ").list();
	}

}
