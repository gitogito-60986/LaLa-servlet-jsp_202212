package model;

import java.io.Serializable;

public class Employee implements Serializable {
	private String id;
	private String name;
	private Gender gender;
	private String birthday;
	private Dept dept;
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Employee() {}
	public Employee(String id, String name, Gender gender, String birthday, Dept dept) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return this.getId() + ":" + this.getName() + ":" + this.getGender().getName() + ":" + this.getBirthday() + ":" + this.getDept().getName();
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Gender getGender() {
		return gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public Dept getDept() {
		return dept;
	}
}
