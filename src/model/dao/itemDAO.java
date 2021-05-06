package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.item;
import model.schedule;

public class itemDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public itemDAO(){
		jdbcUtil = new JDBCUtil();
	}
	
	//item 테이블에 새로운 상품 추가
	public int createItemByGuide(item item) throws SQLException {
		String sql = "INSERT INTO item "
					+ "VALUES (item_id_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		Object[] param = new Object[] {
				item.getName(), 
				item.getPrice(), 
				new java.sql.Date(item.getDepartTime().getTime()), 
				new java.sql.Date(item.getArrTime().getTime()), 
				item.getGuideId(), 
				item.getCategory()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}
	
	//item 삭제
	public int deleteItemByGuide(int itemId) throws SQLException{
		String sql = "DELETE FROM item "
					+ "WHERE item_id = ?";
		Object[] param = new Object[] {itemId};
		jdbcUtil.setSqlAndParameters(sql, param);

			try {
				int r = jdbcUtil.executeUpdate();
				return r;
			} catch(Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {
				jdbcUtil.commit();
				jdbcUtil.close();	// resource 반환
			}
			return 0;	
	}

	
	//가이드가 맡은 상품리스트 반환
	public List<item> findItemByGuide(String guideId) throws SQLException {
		String sql = "SELECT item_id, name, price, departtime, arrtime, category "
					+ "FROM item "
		    		+ "WHERE guide_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {guideId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<item> itemList = new ArrayList<item>();
			while (rs.next()) {
				item item = new item(
					rs.getInt("item_id"),
					rs.getString("name"),
					rs.getInt("price"),
					rs.getDate("departtime"),
					rs.getDate("arrtime"),
					guideId,
					rs.getString("category"));
				itemList.add(item);	
			}		
			return itemList;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	//아이템 아이디로 상품정보 검색
	public item searchItemById(int itemId)throws SQLException {
		String query = "SELECT item_id, name, price, departTime, arrTime, guide_id, category "
					+ "FROM item "
					+ "WHERE item_id = ?";
		
		Object[] param = new Object[] {itemId};
		jdbcUtil.setSqlAndParameters(query, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("price"));
				System.out.println(rs.getDate("departTime"));
				System.out.println(rs.getDate("arrTime"));
				System.out.println(rs.getString("guide_id"));
				System.out.println(rs.getString("category"));
				item item = new item(
					itemId,
					rs.getString("name"),
					rs.getInt("price"),
					rs.getDate("departTime"),
					rs.getDate("arrTime"),
					rs.getString("guide_id"),
					rs.getString("category"));
				return item;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.close();
		}
		return null;
	}

	//아이템 아이디로 세부일정 검색
	public List<schedule> searchScheduleByID(int itemId) throws SQLException{
		String query = "SELECT sche_id, sche_name, sche_time, sche_location, SCHE_DESCRIPTION "
				+ "FROM schedule "
				+ "WHERE item_id = ?";
	
	Object[] param = new Object[] {itemId};
	jdbcUtil.setSqlAndParameters(query, param);
	ArrayList<schedule> scheduleList = new ArrayList<schedule>();
	
	try {
		ResultSet rs = jdbcUtil.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("sche_id"));
			System.out.println(rs.getString("sche_name"));
			System.out.println(rs.getDate("sche_time"));
			System.out.println(rs.getString("sche_location"));
			System.out.println(rs.getString("SCHE_DESCRIPTION"));
	
			schedule sche = new schedule(
				rs.getInt("sche_id"),
				rs.getString("sche_name"),
				rs.getDate("sche_time"),
				rs.getString("sche_location"),
				rs.getString("SCHE_DESCRIPTION"),
				itemId	);
			scheduleList.add(sche);
		}
		return scheduleList;
		
	} catch(Exception e) {
		e.printStackTrace();
	}finally {
		jdbcUtil.close();
	}
	return null;
	}

	//아이템에 스케줄 추가
	public int createScheduleByGuide(schedule sche)throws SQLException{
		String query = "INSERT INTO schedule "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
	
		Object[] param = new Object[] {
				sche.getScheId(),
				sche.getName(), 
				new java.sql.Date(sche.getTime().getTime()),
				sche.getLocation(),
				sche.getDescription(), 
				sche.getItemId()};
		
		System.out.println(sche.getScheId()+","+ sche.getName()+ "," + sche.getTime() + ","
								+ sche.getLocation() + ","+ sche.getDescription()+","+ sche.getItemId());
		jdbcUtil.setSqlAndParameters(query, param);
	
		try {
			int r = jdbcUtil.executeUpdate();
			return r;
		} catch(Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}
		return 0;
	}
	
	//문자열이 들어간 상품 반환
	public List<Integer> searchStringItem(String search) throws SQLException{
		String query = "SELECT item_id "
					+"FROM item "
					//+"WHERE name= ?";
					+ "WHERE name LIKE ?";
	
	String temp = "%"+search+"%";
	Object[] param = new Object[] {temp};
	jdbcUtil.setSqlAndParameters(query, param);
	
	try {
		ResultSet rs = jdbcUtil.executeQuery();
		System.out.println("111111111111");
		ArrayList<Integer> idList = new ArrayList<Integer>();
		System.out.println("2222");
		while(rs.next()) {
			System.out.println("33333333" );
			System.out.println(rs.getInt("item_id"));
			idList.add((Integer)rs.getInt("item_id"));
		}
		System.out.println("받은 String으로 아이템 아이디 반환완료");
		return idList;
		
	} catch(Exception e) {
		e.printStackTrace();
	}finally {
		jdbcUtil.close();
	}
	return null;
	}
}
