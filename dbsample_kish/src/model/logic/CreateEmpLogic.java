package model.logic;

import dao.EmployeeDao;
import model.Employee;

public class CreateEmpLogic {
	public boolean execute(Employee emp) {
		boolean isCreated = EmployeeDao.create(emp);
		return isCreated;
	}
}
