package controller.guide;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.item;
import model.dao.itemDAO;

public class AddReservationController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AddReservationController내부");
		//로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) { //if (!UserSessionUtils.hasLogined(request.getSession()))
    		return "redirect:/user/main";
        }
    	
    	HttpSession session = request.getSession();
    	request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));
    	//SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

    	//int itemId = Integer.parseInt( request.getParameter("id") );
    	//System.out.println("상품 id: " + itemId);
    	
    	String name = request.getParameter("name");
    	System.out.println("상품 이름: " + name);
    	
    	int price = Integer.valueOf( request.getParameter("price") );
    	System.out.println("상품 가격: " + price);
    	
    	Date departTime = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("departTime"));
    	//String departTime = request.getParameter("departTime");
    	System.out.println("출발일: " + departTime);
    	
    	Date arrTime = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("arrTime"));
    	//String arrTime = request.getParameter("arrTime");
    	System.out.println("도착일: " + arrTime);
    	
    	String guideId = (String) session.getAttribute("userId");
    	System.out.println("가이드 id: " + guideId);
    	
    	String category = request.getParameter("category");
    	System.out.println("카테고리: " + category);
    	
    	item newItem = new item(0, name, price, departTime, arrTime, guideId, category);
    	
		try {
			itemDAO itemDao = new itemDAO();
			int r = itemDao.createItemByGuide(newItem);
			System.out.println("가이드 상품 추가 성공, 메인으로 리다이렉션");
			if(r == 1)
				return "redirect:/user/main";
			else
				return "addReservation.jsp";
		} catch(Exception e) {
			System.out.println("가이드 상품 추가 실패, 등록다시");
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			//request.setAttribute("newItem", newItem);
			return "/guide/addReservation.jsp";
		}
    	
	}

}
