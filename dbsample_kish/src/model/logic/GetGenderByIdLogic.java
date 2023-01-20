package model.logic;

import dao.GenderDao;
import model.Gender;

public class GetGenderByIdLogic {
	public Gender execute(String gender_id) {
		Gender gender = GenderDao.findById(gender_id);
		return gender;
	}
	
}
