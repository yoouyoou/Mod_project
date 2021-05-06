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
			
			//�̺κ��� ���̵� �����ϱ� ���ؼ�//
			if(memberDao.exitGuideInfo(userId, password)) {
				HttpSession session = request.getSession();
				session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
				session.setAttribute("divGuide", 1);
				System.out.println("����� �α��� ����, ��������, �������� �����̷���");
				return "redirect:/user/main";
			}
			//���̵� ���� //
			
			if(memberDao.exitMemberInfo(userId, password)) {
				HttpSession session = request.getSession();
				session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
				System.out.println("����� �α��� ����, ��������, �������� �����̷���");
				return "redirect:/user/main";
			} else {
				System.out.println("����� �α��� ����, �α���â���� ������");
				return "/user/loginForm.jsp";
			}
			
		} catch(Exception e) {
			request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			System.out.println("����� �α��� ����, �α���â���� ������");
			return "/user/loginForm.jsp";
		}
	}

}
