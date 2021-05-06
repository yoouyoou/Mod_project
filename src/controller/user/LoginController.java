package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.member;
import model.dao.memberDAO;

public class LoginController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		try {
			memberDAO memberDao = new memberDAO();
			//member member = memberDao.searchMemberInfo(userId);
			
			//이부분은 가이드 구별하기 위해서//
			if(memberDao.exitGuideInfo(userId, password)) {
				HttpSession session = request.getSession();
				session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
				session.setAttribute("divGuide", 1);
				System.out.println("여기는 로그인 성공, 세션저장, 메인으로 리다이렉션");
				return "redirect:/user/main";
			}
			//가이드 구분 //
			
			if(memberDao.exitMemberInfo(userId, password)) {
				HttpSession session = request.getSession();
				session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
				System.out.println("여기는 로그인 성공, 세션저장, 메인으로 리다이렉션");
				return "redirect:/user/main";
			} else {
				System.out.println("여기는 로그인 실패, 로그인창으로 포워딩");
				return "/user/loginForm.jsp";
			}
			
		} catch(Exception e) {
			request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			System.out.println("여기는 로그인 실패, 로그인창으로 포워딩");
			return "/user/loginForm.jsp";
		}
	}

}
