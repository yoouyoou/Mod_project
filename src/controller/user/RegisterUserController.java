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
		//�α��� ���� Ȯ��
    	if (UserSessionUtils.hasLogined(request.getSession())) { //if (!UserSessionUtils.hasLogined(request.getSession()))
    		//�α��� ���¿��� ȸ������ ������ �α׾ƿ� ó��
    		return "redirect:/user/logout";
        }
    	
    	System.out.println("ȸ������ ��Ʈ�ѷ� ����");
    	
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
			System.out.println("ȸ������ ����, �������� �����̷���");
			return "redirect:/user/main";
			
		} catch(Exception e) {
			System.out.println("ȸ������ ����, ��ϴٽ�");
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", member);
			return "/user/registerForm.jsp";
		}
	}

}
