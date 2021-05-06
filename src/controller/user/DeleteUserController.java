package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dao.memberDAO;

public class DeleteUserController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String deleteId = request.getParameter("userId");
		System.out.println("������ ���̵�: " + deleteId);
		
		memberDAO memberDao = new memberDAO();
		HttpSession session = request.getSession();
		
		if((UserSessionUtils.isLoginUser("admin", session) && !deleteId.equals("admin")) ||
			(!UserSessionUtils.isLoginUser("admin", session) && UserSessionUtils.isLoginUser(deleteId, session)) ) {
			memberDao.removeMemberInfo(deleteId);
			if (UserSessionUtils.isLoginUser("admin", session))	// �α����� ����ڰ� ������ 	
				return "redirect:/user/main";		// ����� ����Ʈ�� �̵�
			else 									// �α����� ����ڴ� �̹� ������
				return "redirect:/user/logout";		// logout ó��
		}
		
		return "/user/main.jsp";
	}

}
