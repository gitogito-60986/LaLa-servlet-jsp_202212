package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Calc;
import model.Dragon;
import model.Hero;
import model.Human;
import model.Monster;

public class Main {
	public static void main(String[] args) {
		boolean retry = true;
		do {
			List<Human> humanList = new ArrayList<>();
			
			String heroName1 = "ミナト";
			int heroHp1 = 50;
			int heroAttackHp1 = 50;
			int heroCrHitRate1 = 30;
			int heroMp1 = 15;
			Hero hero1 = new Hero(heroName1, heroHp1, heroAttackHp1, heroCrHitRate1, heroMp1);

			String heroName2 = "アサカ";
			int heroHp2 = 50;
			int heroAttackHp2 = 50;
			int heroCrHitRate2 = 30;
			int heroMp2 = 15;
			Hero hero2 = new Hero(heroName2, heroHp2, heroAttackHp2, heroCrHitRate2, heroMp2);

			humanList.add(hero1);
			humanList.add(hero2);

			List<Monster> monsterList = new ArrayList<>();

			String monsterType1 = "ドラゴン";
			int dragonHp1 = 60;
			int dragonAttackHp1 = 50;
			int dragonCrHitRate1 = 30;
			int breathStock1 = 20;
			Dragon dragon1 = new Dragon(monsterType1, dragonHp1, dragonAttackHp1, dragonCrHitRate1, breathStock1);
			
			String monsterType2 = "マスタードラゴン";
			int dragonHp2 = 60;
			int dragonAttackHp2 = 50;
			int dragonCrHitRate2 = 30;
			int breathStock2 = 20;
			Dragon dragon2 = new Dragon(monsterType2, dragonHp2, dragonAttackHp2, dragonCrHitRate2, breathStock2);

			monsterList.add(dragon1);
			monsterList.add(dragon2);
			
			System.out.println("\n");
			for(Monster monster : monsterList) {
				System.out.println(monster.getMonsterType() + "があらわれた！");
			}
			while(true) {
				int mIsCont = 0;
				int hIsCont = 0;
				for(Human human : humanList) {
					// なぜか下記実施するとフリーズ: 原因不明…
//					if(!human.isCToF()) { return; }
					Calc.showStatus(humanList, monsterList);
					human.command(monsterList);
					mIsCont = Calc.cont(humanList, monsterList);
					if(mIsCont == 2) { break; }
				}
				mIsCont = Calc.cont(humanList, monsterList);
				if(mIsCont == 2) { break; }
				for(Monster monster : monsterList) {
					// なぜか下記実施するとフリーズ: 原因不明…
//					if(!monster.isCToF()) { return; }
					int listIndex = 0;
					Human comHuman = null;
					boolean chFlag = false;
					do {
						// なぜか下記実施するとフリーズ: 原因不明…
//						if(!monster.isCToF()) { return; }
						listIndex = new Random().nextInt(humanList.size());
						comHuman = humanList.get(listIndex);
						if(comHuman.isCToF()) {
							monster.command(comHuman);
							chFlag = false;
						} else {
							chFlag = true;
						}
					} while(chFlag);
					hIsCont = Calc.cont(humanList, monsterList);
					if(hIsCont == 1) { break; }
				}
				hIsCont = Calc.cont(humanList, monsterList);
				if(hIsCont == 1) { break; }
			}
			retry = Calc.isRetry();
		} while(retry);
	}
}
