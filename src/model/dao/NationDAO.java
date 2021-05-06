package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Nation;

public class NationDAO {
	
	private JDBCUtil jdbcUtil = null;

	public NationDAO() {
		jdbcUtil = new JDBCUtil();
	}

	//나라 관리 테이블에 새로운 나라 생성

	public int create(Nation nation) throws SQLException{
		String sql = "INSERT INTO NATIONINFO (nationId, name, continent)"
				+ "VALUES(?, ?, ?)";
		Object[] param = new Object[] {nation.getNationId(), nation.getContinent()};
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}
	// 기본 나라 정보를 수정

	public int update(Nation nation) throws SQLException {
		String sql = "UPDATE NATIONINFO"
				+ " SET name=?, continent=? "
				+ "WHERE nationid=?";
		Object[] param = new Object[] {nation.getName(), nation.getContinent()};
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	//나라 ID에 해당하는 나라를 삭제

	public int remove(String nationId) throws SQLException {
		String sql = "DELETE FROM NATIONINFO WHERE nationid=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {nationId});

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	//나라 id에 해당하는 continent정보를 DB에서 찾아 nation도메인 클래스에 저장하여 반환 

	public Nation findNationByName (String nationName) throws SQLException{
		String sql ="SELECT nationId, name, continent"
				+ "FROM NATION"
				+"WHERE nationId=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {nationName});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				Nation continent = new Nation(
						nationName,
						rs.getString("nationId"),
						rs.getString("name"));
				return continent;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	//전체 나라 정보 검색해서 list에 저장 및 반환

	public List<Nation> findNationList() throws SQLException {
		String sql = "SELECT nationId, name, continent" 
				+ "FROM NATIONINFO "
				+ "ORDER BY nationId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Nation> nationList = new ArrayList<Nation>();	
			while (rs.next()) {
				Nation nation = new Nation(			
						rs.getString("nationId"),
						rs.getString("name"),
						rs.getString("continent"));	
				nationList.add(nation);				
			}		
			return nationList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
