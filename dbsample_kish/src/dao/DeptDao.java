package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dept;


/**
 * 社員テーブル用DAO
 *
 * @author SeiichiNukayama
 *
 */
public class DeptDao {
	private static final String SQL_FIND_ALL = "SELECT id, name FROM dept ORDER BY id ASC";
	private static final String SQL_FIND_BY_ID = "SELECT id, name FROM DEPT WHERE id=?";

	/**
	 * 部署テーブル全件検索メソッド
	 *
	 * @return 部署テーブル全件のリスト
	 */
	public static List<Dept> findAll() {

		// 全件を格納するリストを準備しておく
		List<Dept> deptList = new ArrayList<Dept>();

		try(Connection conn = DBConnect.connect()) {
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納し、そのbeanをリストに詰める
			while (rs.next()) {
				Dept dept = getDept(rs);
				deptList.add(dept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return deptList;
	}

	/**
	 * 部署レコード取得メソッド
	 *
	 * @return Dept
	 * @throws SQLException 
	 */
	public static Dept getDept(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		Dept dept = new Dept(id, name);
		return dept;
	}

	public static Dept findById(String dept_id) {
		Dept dept = null;
		try(Connection conn = DBConnect.connect()) {
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID);
			ps.setString(1, dept_id);
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納し、そのbeanをリストに詰める
			while (rs.next()) {
				dept = new Dept(rs.getString("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return dept;
	}
}
