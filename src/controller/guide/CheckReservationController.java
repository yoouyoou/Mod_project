package controller.guide;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.item;
import model.dao.itemDAO;

public class CheckReservationController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("여기는 예약추가 눌렀을 시 나오는 checkReservation컨트롤러임");
		//로그인 여부
		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/user/login/form";
		}
		
		HttpSession session = request.getSession();
		request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));
		String guideId = (String)session.getAttribute("userId");
		
		itemDAO itemDao = new itemDAO();
		List<item> itemList = new ArrayList<item>();
		itemList = itemDao.findItemByGuide(guideId); //가이드가 맡은 상품객체 리스트 반환
		
		request.setAttribute("itemList", itemList);
		
		return "/guide/checkReservation.jsp";
	}

}
