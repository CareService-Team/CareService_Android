package com.example.care.database;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.DriverManager;

public class ConnectionManager {
	private static final String DB_URL = "jdbc:mysql://3.34.133.71:3306/care_db?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
    private static final String DB_USERNAME = "kim";
    private static final String DB_PASSWORD = "rnfl123";
    private static DataSource ds = null;
    private static Connection conn = null;
    
    public ConnectionManager() {}

	public static Connection getConn(){
    	if(conn == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				// 참고: WAS의 DataSource를 이용할 경우:
				// Context init = new InitialContext();
				// ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDS");
				conn.setAutoCommit(false);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("Connection Created");
		}
    	return conn;
	}

    public void close() {
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
