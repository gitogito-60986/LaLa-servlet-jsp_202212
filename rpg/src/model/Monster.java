package model;

public abstract class Monster {
	private String monsterType;
	private int hp;
	private boolean CToF = true;
	
	public Monster() {}
	public Monster(String monsterType, int hp) {
		this.setMonsterType(monsterType);
		this.setHp(hp);
	}
	
	public abstract String attack(Human human);
	public abstract void escape(Human human);
	public abstract void dead(Human human);
	public abstract void command(Human human);
//	public abstract void command(List<Human> HumanList);
	
	public String getMonsterType() {
		return monsterType;
	}
	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public boolean isCToF() {
		return this.CToF;
	}
	public void setCToF(boolean cToF) {
		this.CToF = cToF;
	}

}
