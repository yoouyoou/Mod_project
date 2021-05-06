package controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.reservation;
import model.dao.reservationDAO;

public class MyReservationController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("예약확인 컨트롤러 내부");
		
		// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("미 로그인");
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
    	
    	HttpSession session = request.getSession();
    	String userId = (String) session.getAttribute("userId");
    	System.out.println("현재 요청의 userId 파라미터 값: " + userId);
    	
    	reservationDAO reservationDao = new reservationDAO();
    	List<Integer> resIdList = new ArrayList<Integer>();			 		//예약상품의 아이디 리스트
    	List<reservation> reservationList = new ArrayList<reservation>();		//예약정보 객체 리스트
    	
    	resIdList = reservationDao.searchResIdByUser(userId);  //예약상품의 아이디 리스트
    	System.out.println("중간 점검(로그인한 아이디로 상품의 res_id받은 개수): " + resIdList.size());
    	
    	for(int i = 0; i < resIdList.size(); i++) {
    		reservationList.add( reservationDao.searchReservationByUser(resIdList.get(i)) );
    	}
    	System.out.println(reservationDao.searchReservationByUser(1).getItemName());
    	System.out.println("중간 점검(검색된 예약상품 개수): " + reservationList.size());
    	
    	request.setAttribute("reservationList", reservationList);
    	request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));
		
    	System.out.println("세션에 현재 로그인 객체와 검색상품 담아서 이동");
    	return "/user/myReservation.jsp";
	}

}
