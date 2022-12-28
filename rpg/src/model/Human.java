package model;

import java.util.List;

public abstract class Human {
	private String name;
	private int hp;
	private boolean CToF = true;
	
	public Human() {}
	public Human(String name, int hp) {
		this.setName(name);
		this.setHp(hp);
	}
	
	public abstract String attack(Monster monster);
	public abstract void escape();
	public abstract String dead();
	public abstract void command(Monster monster);
	public abstract void command(List<Monster> monsterList);

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		if(hp > 0) {
			this.hp = hp;
		} else {
			this.hp = 0;
		}
	}
	public boolean isCToF() {
		return this.CToF;
	}
	public void setCToF(boolean cToF) {
		this.CToF = cToF;
	}
}
