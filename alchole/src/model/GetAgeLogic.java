package model;

public class GetAgeLogic {
	public static boolean execute(User user) {
		if(user.getAge() >= 20) {
			return true;
		} else {
			return false;
		}
	}
}
