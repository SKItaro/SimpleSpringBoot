package com.trainingself.form.gakusei;

public class EntryInputForm {

	private String name; //氏名
	private String school;//最終学歴
	private boolean dev;//開発経験有無
	private String machingPoint; //マッチングポイント
	private String category; //学校の区分

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}

	public boolean isDev() {
		return dev;
	}
	public void setDev(boolean dev) {
		this.dev = dev;
	}
	public String getMachingPoint() {
		return machingPoint;
	}
	public void setMachingPoint(String machingPoint) {
		this.machingPoint = machingPoint;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "EntryInputForm [name=" + name + ", school=" + school + ", dev=" + dev + ", machingPoint=" + machingPoint
				+ ", category=" + category + ", getName()=" + getName() + ", getSchool()=" + getSchool() + ", isDev()="
				+ isDev() + ", getMachingPoint()=" + getMachingPoint() + ", getCategory()=" + getCategory()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}



}
