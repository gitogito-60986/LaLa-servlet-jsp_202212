package model;

import java.util.List;
import java.util.Scanner;

public class Calc {
//	public static boolean isContinue(boolean isHuCon, boolean isMoCon) {
//		boolean isCon = true;
//		if(!(isHuCon && isMoCon)) {
//			isCon = false;
//		}
//		return isCon;
//	}

//	public static void showStatus(Human human, Monster monster) {
//		Calc.doWait(1000);
//		System.out.println(
//			"\n[" + human.getName() + "のHP:" + human.getHp() + "、" + 
//			monster.getMonsterType() + "のHP:" + monster.getHp() + "]"
//		);
//	}

	public static void showStatus(Human human, List<Monster> monsterList) {
		Calc.doWait(1000);
		System.out.println(	"\n[" + human.getName() + "のHP:" + human.getHp() );
		for(Monster monster : monsterList) {
			if(monster instanceof Dragon) {
				Dragon dragon = (Dragon)monster;
				if(dragon.isCToF()) {
					System.out.print(" " + monster.getMonsterType() + "のHP:" + monster.getHp());
				}
			}
		}
		System.out.println("]");
	}
	
	public static void showStatus(List<Human> humanList, List<Monster> monsterList) {
		Calc.doWait(1000);
		System.out.print("\n[");
		for(Human human : humanList) {
			if(human.isCToF()) {
				System.out.print(human.getName() + "のHP:" + human.getHp() + " ");
			}
		}
		System.out.print("\n ");
		for(Monster monster : monsterList) {
			if(monster.isCToF()) {
				System.out.print(monster.getMonsterType() + "のHP:" + monster.getHp() + " ");
			}
		}
		System.out.println("]");
	}
	
	public static int cont(List<Human> humanList, List<Monster> monsterList) {
		int cnum = 0;
		String hIsCTof = null;
		String mIsCTof = null;
		for(Human human : humanList) {
			if(human.isCToF()) {
				hIsCTof = hIsCTof + "true";
			} else {
				hIsCTof = hIsCTof + "false";
			}
		}
		if(hIsCTof.indexOf("true") == -1) {
			cnum = 1;
		}
		for(Monster monster : monsterList) {
			if(monster.isCToF()) {
				mIsCTof = mIsCTof + "true";
			} else {
				mIsCTof = mIsCTof + "false";
			}
		}
		if(mIsCTof.indexOf("true") == -1) {
			cnum = 2;
		}
		return cnum;
	}
	
	public static boolean isRetry() {
		boolean retry = false;
		System.out.println("\n再度、チャレンジしますか？");
		System.out.print("＜ 0:チャレンジする、1:終わる ＞ ⇒ ");
		@SuppressWarnings("resource")
		int num = new Scanner(System.in).nextInt();
		switch(num) {
			case 0:
				retry = true;
				break;
			case 1:
				retry = false;
				break;
			default:
				System.out.println("想定外のエラーが発生しました。アプリ管理者へ連絡してください。");
		}
		return retry;
	}
	
	public static void doWait(int second) {
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			System.out.println("想定外のエラーが発生しました。アプリ管理者へ連絡してください。");
			e.printStackTrace();
		}
	}
}
