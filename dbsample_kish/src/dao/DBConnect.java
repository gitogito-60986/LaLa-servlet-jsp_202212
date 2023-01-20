package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB接続処理用クラス
 *
 * @author System Shared
 *
 */
public class DBConnect {

	/** 接続するDBのURL */
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/dbsample";
	/**
	 * DB接続するためのユーザー名 データベースに作成したユーザーを指定する
	 */
	private static final String DB_USER = "sa";
	/**
	 * DB接続するためのパスワード データベースに作成したパスワードを指定する
	 */
	private static final String DB_PASS = "";

	/**
	 * DB接続メソッド
	 *
	 * @return 接続情報
	 */
	public static Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		return conn;
	}
}