package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SafeGrade;

public class SafeGradeDAO {
	
	public SafeGradeDAO() {	//생성자
		// JDBC 드라이버 로딩 및 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}	
	}
	
	private static Connection getConnection() {
		String url = "jdbc:oracle:thin:@202.20.119.117:1521:orcl";	
		String user = "dbprog0206";
		String passwd = "dbprog0206";

		// DBMS와의 연결 획득
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}	 
		return conn;
	}
	
	//국가 안전등급 전체 리스트
	public List<SafeGrade> searchSafeGrade(){
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "SELECT n.nation_id, n.name, disease, naturalAccident, terror, war "
					+ "FROM nation n, safeGrade s "
					+ "WHERE n.nation_id = s.nation_id";
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			rs = pStmt.executeQuery();
			List<SafeGrade> safeGradeList = new ArrayList<SafeGrade>();
			
			while(rs.next()) {
				System.out.println(rs.getString("nation_id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("disease"));
				System.out.println(rs.getString("naturalAccident"));
				System.out.println(rs.getString("naturalAccident"));
				System.out.println(rs.getString("war"));
				SafeGrade obj = new SafeGrade(
						rs.getString("nation_id"),
						rs.getString("name"),
						rs.getString("disease"),
						rs.getString("naturalAccident"),
						rs.getString("terror"),
						rs.getString("war"));
				safeGradeList.add(obj);
			}
			return safeGradeList;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) 
				try { 
					rs.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (pStmt != null) 
				try { 
					pStmt.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (conn != null) 
				try { 
					conn.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
		}
		return null;
	}
}
