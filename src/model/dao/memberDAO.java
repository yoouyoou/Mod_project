package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.member;

public class memberDAO {

	public memberDAO() {	// 생성자 
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

	//id로 멤버정보 검색
	public member searchMemberInfo(String member_id) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String id, pwd, name, tel, email, birth, passport;
		member member = new member();
		
		String query = "SELECT member_id, member_pwd, name, tel, email, birth, passport "
					+ "FROM member "
					+ "WHERE member_id = ?";
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, member_id);
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("member_id");
				pwd = rs.getString("member_pwd");
				name = rs.getString("name");
				tel = rs.getString("tel");
				email = rs.getString("email");
				birth = rs.getString("birth");
				passport = rs.getString("passport");
				
				member = new member(id, pwd, name, tel, email, birth, passport); 
			}
			return member;
			
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
	
	//기존의 멤버정보 수정
	public int updateMemberInfo(member member){
		Connection conn = null;
		PreparedStatement pStmt = null;

		int result = 0;		
		String query = "UPDATE member "
					+ "SET member_pwd=?, name=?, email=?, tel=?, birth=?, passport=? "
					+ "WHERE member_id=?";
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, member.getPassword());
			pStmt.setString(2, member.getName());
			pStmt.setString(3, member.getEmail());
			pStmt.setString(4, member.getTel());
			pStmt.setString(5, member.getBirth());
			pStmt.setString(6, member.getPassport());
			pStmt.setString(7, member.getUserId());
			result = pStmt.executeUpdate();
			System.out.println("업데이트 결과 정수값: " + result);
			return result;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(pStmt != null)
				try {
					pStmt.close();
				} catch(SQLException ex) { ex.printStackTrace(); }
			if (conn != null) 
				try { 
					conn.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
		}
		return result;
	}

	//새로운 멤버추가
	public int createMember(member member) {
		Connection conn = null;
		PreparedStatement pStmt = null;

		int result = 0;		
		String query = "INSERT INTO member "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, member.getUserId());
			pStmt.setString(2, member.getPassword());
			pStmt.setString(3, member.getName());
			pStmt.setString(4, member.getEmail());
			pStmt.setString(5, member.getTel());
			pStmt.setString(6, member.getBirth());
			pStmt.setString(7, member.getPassport());
			result = pStmt.executeUpdate();
			return result;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(pStmt != null)
				try {
					pStmt.close();
				} catch(SQLException ex) { ex.printStackTrace(); }
			if (conn != null) 
				try { 
					conn.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
		}
		return result;
	}

	//멤버 삭제
	public int removeMemberInfo(String member_id) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		int r = 0;
		
		String query = "DELETE FROM member "
					+ "WHERE member_id = ?";

			try {
				conn = getConnection();
				pStmt = conn.prepareStatement(query);
				pStmt.setString(1, member_id);
				r = pStmt.executeUpdate();
				return r;
			} catch(SQLException ex) {
				ex.printStackTrace();
			} finally {
				if(pStmt != null)
					try {
						pStmt.close();
					} catch(SQLException ex) { ex.printStackTrace(); }
				if (conn != null) 
					try { 
						conn.close(); 
					} catch (SQLException ex) { ex.printStackTrace(); }
			}
			return r;	
	}

	//멤버의 아이디/비번 확인(로그인 검사)
	public boolean exitMemberInfo(String member_id, String password) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		
		String query = "SELECT count(*) FROM member "
					+ "WHERE member_id=? and member_pwd=?";
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, member_id);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(pStmt != null)
				try {
					pStmt.close();
				} catch(SQLException ex) { ex.printStackTrace(); }
			if (conn != null) 
				try{
					conn.close(); 
			} catch (SQLException ex) { ex.printStackTrace(); }
		}
		return false;	
	}


	//가이드 로그인 검사(이거 추후에 guideDAO쪽으로 넘겨야 함)
	public boolean exitGuideInfo(String guide_id, String password) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		
		String query = "SELECT count(*) FROM guide "
					+ "WHERE guide_id=? and guide_pwd=?";
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, guide_id);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(pStmt != null)
				try {
					pStmt.close();
				} catch(SQLException ex) { ex.printStackTrace(); }
			if (conn != null) 
				try{
					conn.close(); 
			} catch (SQLException ex) { ex.printStackTrace(); }
		}
		return false;	
	}
}
