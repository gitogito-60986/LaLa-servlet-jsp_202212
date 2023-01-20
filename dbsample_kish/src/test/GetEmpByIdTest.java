package test;

import model.Employee;
import model.logic.GetEmpByIdLogic;

public class GetEmpByIdTest {
	public static void main(String[] args) {
		GetEmpByIdLogic logic = new GetEmpByIdLogic();
		Employee emp = logic.execute("EMP001");
		System.out.println(emp);
	}
}
