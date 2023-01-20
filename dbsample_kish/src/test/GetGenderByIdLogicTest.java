package test;

import model.Gender;
import model.logic.GetGenderByIdLogic;

public class GetGenderByIdLogicTest {

	public static void main(String[] args) {
		GetGenderByIdLogic logic = new GetGenderByIdLogic();
		Gender gender = logic.execute("2");
		System.out.println(gender);
	}

}
