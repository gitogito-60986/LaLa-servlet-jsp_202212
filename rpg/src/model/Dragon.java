package model;

import java.util.Random;

public class Dragon extends Monster {
	private int attackHp;
	private int crHitRate;
	private int breathStock;
	
	public Dragon() {
		this.setMonsterType("ドラゴン");
	}
	public Dragon(String monsterType, int hp, int attackHp, int crHitRate, int breathStock) {
		super(monsterType, hp);
		this.setAttackHp(attackHp);
		this.setCrHitRate(crHitRate);
		this.setBreathStock(breathStock);
	}

	@Override
	public String attack(Human human) {
		String text = null;
		if(this.isCToF()) {
			Calc.doWait(1000);
			text = this.getMonsterType() + "の攻撃、";
			Calc.doWait(1000);
			int damage = new Random().nextInt(this.getAttackHp()) + 1;
			int cnum = new Random().nextInt(100) + 1;
			if(cnum < this.getCrHitRate()) {
				text += "痛恨の一撃！ ";
				damage *= 3;
				Calc.doWait(1000);
			}
			text += human.getName() + "は" + damage + "ポイントのダメージをうけた！";
			int damaged = human.getHp() - damage;
			human.setHp(damaged);
			String doa = human.dead();
			if(doa != null) {
				text += doa;
			}
		}
		return text;
	}

	@Override
	public void escape(Human human) {
		if(this.isCToF()) {
			System.out.println(this.getMonsterType() + "は空高く羽ばたいた！");
			int number = new Random().nextInt(10) + 1;
			if(number > 5) {
				System.out.println(this.getMonsterType() + "は飛び去ってしまった");
				this.setCToF(false);
			} else {
				System.out.println(human.getName() + "は逃がさない！");
			}
		}
	}
	
	@Override
	public String dead(Human human) {
		String text = null;
		boolean alive = true;
		if(this.getHp() <= 0) {
			text = human.getName() + "は、" + this.getMonsterType() + "を打ち倒した！";
			alive = false;
		}
		this.setCToF(alive);
		return text;
	}
	
	@Override
	public void command(Human human) {
		if(this.getHp() >= 10) {
			this.attack(human);
		} else {
			this.escape(human);
		}
	}

	@Override
	public String toString() {
		String text = this.getMonsterType() + " HP:" + this.getHp();
		return text;
	}
	
//	@Override
//	public void command(List<Human> humanList) {
//		for(Human human : humanList) {
//			this.command(human);
//		}
//	}

	public int getAttackHp() {
		return attackHp;
	}
	public void setAttackHp(int attackHp) {
		this.attackHp = attackHp;
	}
	public int getBreathStock() {
		return breathStock;
	}
	public void setBreathStock(int breathStock) {
		this.breathStock = breathStock;
	}
	public int getCrHitRate() {
		return crHitRate;
	}
	public void setCrHitRate(int crHitRate) {
		this.crHitRate = crHitRate;
	}
}
