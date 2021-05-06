package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.member;
import model.dao.memberDAO;

public class RegisterUserController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 여부 확인
    	if (UserSessionUtils.hasLogined(request.getSession())) { //if (!UserSessionUtils.hasLogined(request.getSession()))
    		//로그인 상태에서 회원가입 누르면 로그아웃 처리
    		return "redirect:/user/logout";
        }
    	
    	System.out.println("회원가입 컨트롤러 내부");
    	
		member member = new member(
				request.getParameter("userId"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("phone"),
				request.getParameter("birth"),
				request.getParameter("passport"));
		
		try {
			memberDAO memberDao = new memberDAO();
			memberDao.createMember(member);
			System.out.println("회원가입 성공, 메인으로 리다이렉션");
			return "redirect:/user/main";
			
		} catch(Exception e) {
			System.out.println("회원가입 실패, 등록다시");
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", member);
			return "/user/registerForm.jsp";
		}
	}

}
