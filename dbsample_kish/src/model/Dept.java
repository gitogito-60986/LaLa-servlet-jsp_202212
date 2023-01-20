package model;

import java.io.Serializable;

public class Dept implements Serializable {
	private String id;
	private String name;
	
	public Dept() {}
	public Dept(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getId() + ":" + this.getName();
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
