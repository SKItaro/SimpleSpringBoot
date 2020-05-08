package com.trainingself.form.gakusei;

public class EntryInputForm {

	private String name; //氏名
	private String school;//最終学歴
	private boolean dev;//開発経験有無
	private String machingPoint; //マッチングポイント


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

	@Override
	public String toString() {
		return "EntryInputForm [name=" + name + ", school=" + school + ", dev=" + dev + ", machingPoint=" + machingPoint
				+ "]";
	}



}
