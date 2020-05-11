package com.trainingself.domain.model;

public class University {
	@Override
	public String toString() {
		return "University [category=" + category + ", university=" + university + "]";
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	String category;
	String university;

}
