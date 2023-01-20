package model.logic;

import dao.EmployeeDao;
import model.Employee;

public class GetEmpByIdLogic {
	public Employee execute(String emp_id) {
		Employee emp = EmployeeDao.findById(emp_id);
		return emp;
	}
}
