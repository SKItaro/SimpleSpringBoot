package com.trainingself.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingself.domain.model.University;
import com.trainingself.domain.repository.UniversityDao;
@Service
public class UniversitiesService {

	@Autowired
	UniversityDao udao;

	public List<University> getUniversities(String category) throws Exception{
		return udao.selectByCategory(category);
	}


}
