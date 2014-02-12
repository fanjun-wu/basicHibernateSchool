package org.fanjun.controller;

import java.util.Map;

import org.fanjun.model.College;

import org.fanjun.service.CollegeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CollegeController {

	
	@Autowired
	private CollegeService collegeService;
	
	@RequestMapping("/college")
	public String setupForm(Map<String, Object> map){
		College college = new College();
		map.put("college", college);
		map.put("collegeList", collegeService.getAllCollege());
		map.put("studentList", collegeService.getAllStuentInCollege());
		return "college";
	}
	
	@RequestMapping(value="/college.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute College college, BindingResult result, @RequestParam String action, Map<String, Object> map){
		College collegeResult = new College();
		switch(action.toLowerCase()){	
		case "add":
			collegeService.add(college);
			collegeResult = college;
			break;
		case "edit":
			collegeService.edit(college);
			collegeResult = college;
			break;
		case "delete":
			collegeService.delete(college.getCollegeId());
			collegeResult = new College();
			break;
		case "search":
			College searchedcollege = collegeService.getCollege(college.getCollegeId());
			collegeResult = searchedcollege!=null ? searchedcollege : new College();
			break;
		}
		map.put("college", collegeResult);
		map.put("collegeList", collegeService.getAllCollege());
		return "college";
	}
	
	
}
