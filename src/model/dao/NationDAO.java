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

	//���� ���� ���̺� ���ο� ���� ����

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
	// �⺻ ���� ������ ����

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

	//���� ID�� �ش��ϴ� ���� ����

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
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}

	//���� id�� �ش��ϴ� continent������ DB���� ã�� nation������ Ŭ������ �����Ͽ� ��ȯ 

	public Nation findNationByName (String nationName) throws SQLException{
		String sql ="SELECT nationId, name, continent"
				+ "FROM NATION"
				+"WHERE nationId=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {nationName});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
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
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}

	//��ü ���� ���� �˻��ؼ� list�� ���� �� ��ȯ

	public List<Nation> findNationList() throws SQLException {
		String sql = "SELECT nationId, name, continent" 
				+ "FROM NATIONINFO "
				+ "ORDER BY nationId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil�� query�� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query ����			
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
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
}
