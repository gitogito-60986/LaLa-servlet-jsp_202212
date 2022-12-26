package model;

import java.io.Serializable;

public class Divination implements Serializable {
	private String today;
	private String DivResult;
	
	public Divination() {}
	public Divination(String today, String divResult) {
		this.today = today;
		this.DivResult = divResult;
	}
	
	public String getToday() {
		return this.today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getDivResult() {
		return DivResult;
	}
	public void setDivResult(String divResult) {
		DivResult = divResult;
	}
}
