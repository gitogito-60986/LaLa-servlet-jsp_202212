package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Dept;
import model.Gender;


public class GenderDao {
	private static final String SQL_FIND_BY_ID = "SELECT id, name FROM gender WHERE id=?";

	public static Gender findById(String gender_id) {
		Gender gender = null;
		try(Connection conn = DBConnect.connect()) {
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID);
			ps.setString(1, gender_id);
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納し、そのbeanをリストに詰める
			while (rs.next()) {
				gender = new Gender(rs.getString("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return gender;
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

}
