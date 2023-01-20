package model.logic;

import dao.DeptDao;
import model.Dept;

public class GetDeptByIdLogic {
	public Dept execute(String dept_id) {
		Dept dept = DeptDao.findById(dept_id);
		return dept;
	}
	
}
