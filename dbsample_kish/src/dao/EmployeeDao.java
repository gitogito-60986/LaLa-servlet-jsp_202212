package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dept;
import model.Employee;
import model.Gender;

/**
 * 社員テーブル用DAO
 *
 * @author SeiichiNukayama
 *
 */
public class EmployeeDao {
	private static final String SQL_FIND_ALL =
			"SELECT " + 
			"e.id AS eid," + 
			"e.name AS ename," + 
			"g.id AS gid," + 
			"g.name AS gname," + 
			"e.birthday AS birthday," + 
			"d.id AS did," + 
			"d.name AS dname " + 
			"FROM employee e " + 
			"INNER JOIN gender g ON e.gender_id = g.id " + 
			"INNER JOIN dept d ON e.dept_id = d.id " + 
			"ORDER BY e.id ASC";
	private static final String SQL_FIND_BY_ID =
			"SELECT " + 
			"e.id AS eid," + 
			"e.name AS ename," + 
			"g.id AS gid," + 
			"g.name AS gname," + 
			"e.birthday AS birthday," + 
			"d.id AS did," + 
			"d.name AS dname " + 
			"FROM employee e " + 
			"INNER JOIN gender g ON e.gender_id = g.id " + 
			"INNER JOIN dept d ON e.dept_id = d.id " + 
			"WHERE e.id=?";
	private static final String SQL_CREATE =
			"INSERT INTO employee " +
			"(id, name, gender_id, birthday, dept_id) " +
			 "VALUES " +
			 "(?, ?, ?, ?, ?)";

	/**
	 * 社員テーブル全件検索メソッド
	 *
	 * @return 社員テーブル全件のリスト
	 */
	public static List<Employee> findAll() {

		// 全件を格納するリストを準備しておく
		List<Employee> empList = new ArrayList<Employee>();

		try(Connection conn = DBConnect.connect()) {
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納し、そのbeanをリストに詰める
			while (rs.next()) {
				Employee emp = getEmp(rs);
				empList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}

	/**
	 * 社員テーブルIDによる検索メソッド
	 *
	 * @return 社員のレコード
	 */
	public static Employee findById(String emp_id) {

		// 社員のレコードを格納するインスタンスを準備しておく
		Employee emp = null;

		try(Connection conn = DBConnect.connect()) {
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID);
			ps.setString(1, emp_id);
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納
			while (rs.next()) {
				emp = getEmp(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return emp;
	}
	
	/**
	 * 社員レコード取得メソッド
	 *
	 * @return Employee
	 * @throws SQLException 
	 */
	public static Employee getEmp(ResultSet rs) throws SQLException {
		String id = rs.getString("eid");
		String name = rs.getString("ename");
		String genderId = rs.getString("gid");
		String genderName = rs.getString("gname");
		String birthday = rs.getString("birthday");
		String deptId = rs.getString("did");
		String deptName = rs.getString("dname");
		
		Gender gender = new Gender(genderId, genderName);
		Dept dept = new Dept(deptId, deptName);
		
		Employee emp = new Employee(id, name, gender, birthday, dept);
		return emp;
	}
	public static boolean create(Employee emp) {
		boolean isCreated = false;
		try(Connection conn = DBConnect.connect()) {
			PreparedStatement ps = conn.prepareStatement(SQL_CREATE);
			ps.setString(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getGender().getId());
			ps.setString(4, emp.getBirthday());
			ps.setString(5, emp.getDept().getId());
			int rs = ps.executeUpdate();

			// 検索結果をbeanに格納し、そのbeanをリストに詰める
			if (rs == 1) {
				isCreated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return isCreated;
		}
		return isCreated;
	}
}
