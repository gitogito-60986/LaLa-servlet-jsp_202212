package model.logic;

import java.util.List;

import dao.EmployeeDao;
import model.Employee;

public class GetEmpListLogic {
	public List<Employee> execute() {
		List<Employee> empList = EmployeeDao.findAll();
		return empList;
	}
}
