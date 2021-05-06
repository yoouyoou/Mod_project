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
			//현재 로그인한 사용자가 수정 대상 사용자 또는 관리자인 경우 ->수정가능
			return "/user/myPage.jsp";
		}
		
		request.setAttribute("updateFailed", true);
		request.setAttribute("exception", new IllegalStateException("타인의 정보는 수정할 수 없습니다."));
		return "/user/myPage.jsp";
	}

}
