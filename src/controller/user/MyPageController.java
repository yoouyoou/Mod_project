package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.member;
import model.dao.memberDAO;

public class MyPageController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("미 로그인");
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }

    	memberDAO memberDao = new memberDAO();
    	HttpSession session = request.getSession();
    	String userId = (String) session.getAttribute("userId");
    	//String userId = request.getParameter("userId");
    	System.out.println("현재 요청의 userId 파라미터 값: " + userId);
    	request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));		
    	member member = new member();
    	
    	try {
    		member = memberDao.searchMemberInfo(userId);
        	//member객체를 request에 저장하여 뷰로 전달
        	request.setAttribute("user", member);
    		return "/user/myPage.jsp";
    		
    	}catch(Exception e) {
    		return "redirect:/user/main";
    	}
    	
	}

}
