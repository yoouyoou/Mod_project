package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.member;
import model.dao.memberDAO;

public class UpdateUserFormController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String updateId = request.getParameter("userId");
		
		memberDAO memberDao = new memberDAO();
		member member = memberDao.searchMemberInfo(updateId);
		
		HttpSession session = request.getSession();
		if(UserSessionUtils.isLoginUser(updateId, session) ||
			UserSessionUtils.isLoginUser("admin", session)) {
			//���� �α����� ����ڰ� ���� ��� ����� �Ǵ� �������� ��� ->��������
			return "/user/myPage.jsp";
		}
		
		request.setAttribute("updateFailed", true);
		request.setAttribute("exception", new IllegalStateException("Ÿ���� ������ ������ �� �����ϴ�."));
		return "/user/myPage.jsp";
	}

}
