package model;

import java.io.Serializable;

public class MyError implements Serializable{
	private String key;
	private String msg;
	
	public MyError() {}
	public MyError(String key, String msg) {
		this.key = key;
		this.msg = msg;
	}
	
	public String toString() {
		return this.key + ":" + this.msg;
	}
	public String getKey() {
		return this.key;
	}
	public String getMsg() {
		return this.msg;
	}
	
}
