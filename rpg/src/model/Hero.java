package model;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hero extends Human {
	private int attackHp;
	private int crHitRate;
	private int mp;
	
	public Hero() {};
	public Hero(String name, int hp, int attackHp, int crHitRate, int mp) {
		super(name, hp);
		this.setAttackHp(attackHp);
		this.setCrHitRate(crHitRate);
		this.setMp(mp);
	}
	
	@Override
	public String attack(Monster monster) {
		String text = null;
		if(this.isCToF()) {
			Calc.doWait(1000);
			text = this.getName() + "の攻撃、";
			Calc.doWait(1000);
			int damage = new Random().nextInt(this.getAttackHp()) + 1;
			int cnum = new Random().nextInt(100) + 1;
			if(cnum < this.getCrHitRate()) {
				text += "会心の一撃！ ";
				damage *= 3;
				Calc.doWait(1000);
			}
			text += monster.getMonsterType() + "に" + damage + "ポイントのダメージをあたえた！";
			int damaged = monster.getHp() - damage;
			monster.setHp(damaged);
			String doa = monster.dead(this);
			if(doa != null) {
				text += doa;
			}
		}
		return text;
	}

	@Override
	public void escape() {
		if(this.isCToF()) {
			System.out.println(this.getName() + "は逃げ出した！");
			int number = new Random().nextInt(10) + 1;
			if(number > 5) {
				System.out.println(this.getName() + "は無事に戦いから脱出した");
				this.setCToF(false);
			} else {
				System.out.println(this.getName() + "は敵に回り込まれ、逃げ出せない！");
			}
		}
	}
	
	@Override
	public String dead() {
		String text = null;
		boolean alive = true;
		if(this.getHp() <= 0) {
			text = this.getName() + "は力尽きた…";
//			Calc.doWait(1000);
//			System.out.println("== <GAME OVER> ==");
			alive = false;
		}
		this.setCToF(alive);
		return text;
	}

	@Override
	@SuppressWarnings("resource")
	public void command(Monster monster) {
		if(monster.isCToF()) {
			System.out.println(this.getName() + "は、どうする？");
			System.out.print("＜ 0:戦う、1:逃げる ＞ ⇒ ");
			Scanner scan = new Scanner(System.in);
			int heroCommand = scan.nextInt();
			switch(heroCommand) {
				case 0:
					this.attack(monster);
					break;
				case 1:
					this.escape();
					break;
				default:
					System.out.println("想定外のエラーが発生しました。アプリ管理者に連絡してください。");
			}
		}
	}

	@Override
	public String toString() {
		String text = this.getName() + " HP:" + this.getHp();
		return text;
	}
	
	@SuppressWarnings("resource")
	public void command(List<Monster> monsterList) {
		if(!this.isCToF()) { return; }
		System.out.println(this.getName() + "は、どうする？");
		System.out.print("＜ 0:戦う、1:逃げる ＞ ⇒ ");
		Scanner scan = new Scanner(System.in);
		int heroCommand = scan.nextInt();
		switch(heroCommand) {
			case 0:
				boolean hcFlag = false;
				do {
					System.out.println("どの敵を攻撃する？");
					System.out.print("＜ ");
					for(int i = 0; i < monsterList.size(); i++) {
						if(monsterList.get(i).isCToF()) {
							System.out.print(i + ":" + monsterList.get(i).getMonsterType() + " ");
						}
					}
					System.out.print("＞ ⇒ ");
					int targetMonsterIndex = scan.nextInt();
					Monster targetMonster = monsterList.get(targetMonsterIndex);
					if(targetMonster.isCToF()) {
						this.attack(targetMonster);
						hcFlag = false;
					} else {
						hcFlag = true;
						System.out.println("そのターゲットは存在しない！");
					}
				} while(hcFlag);
				break;
			case 1:
				this.escape();
				break;
			default:
				System.out.println("想定外のエラーが発生しました。アプリ管理者に連絡してください。");
		}
	}
	
	public int getAttackHp() {
		return attackHp;
	}
	public void setAttackHp(int attackHp) {
		this.attackHp = attackHp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getCrHitRate() {
		return crHitRate;
	}
	public void setCrHitRate(int crHitRate) {
		this.crHitRate = crHitRate;
	}
		
}
