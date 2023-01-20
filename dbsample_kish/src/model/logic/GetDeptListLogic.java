package model.logic;

import java.util.List;

import dao.DeptDao;
import model.Dept;

public class GetDeptListLogic {
	public List<Dept> execute() {
		List<Dept> deptList = DeptDao.findAll();
		return deptList;
	}
}
