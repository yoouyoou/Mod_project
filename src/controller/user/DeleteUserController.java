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
		System.out.println("삭제할 아이디: " + deleteId);
		
		memberDAO memberDao = new memberDAO();
		HttpSession session = request.getSession();
		
		if((UserSessionUtils.isLoginUser("admin", session) && !deleteId.equals("admin")) ||
			(!UserSessionUtils.isLoginUser("admin", session) && UserSessionUtils.isLoginUser(deleteId, session)) ) {
			memberDao.removeMemberInfo(deleteId);
			if (UserSessionUtils.isLoginUser("admin", session))	// 로그인한 사용자가 관리자 	
				return "redirect:/user/main";		// 사용자 리스트로 이동
			else 									// 로그인한 사용자는 이미 삭제됨
				return "redirect:/user/logout";		// logout 처리
		}
		
		return "/user/main.jsp";
	}

}
