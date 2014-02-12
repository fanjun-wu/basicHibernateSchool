package org.fanjun.service;

import java.util.List;

import org.fanjun.model.College;

public interface CollegeService {
	public void add(College college);
	public void edit(College college);
	public void delete(int collegeId);
	public College getCollege(int collegeId);
	public List getAllCollege();
	public List getAllStuentInCollege();
}
