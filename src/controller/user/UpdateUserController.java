package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.member;
import model.dao.memberDAO;

public class UpdateUserController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("���������� ���� ��Ʈ�ѷ�");
		
    	HttpSession session = request.getSession();
    	String userId = (String) session.getAttribute("userId");

		member updateMember = new member(
				userId,
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("phone"),
				request.getParameter("birth"),
				request.getParameter("passport") );
		
		try {
			memberDAO memberDao = new memberDAO();
			memberDao.updateMemberInfo(updateMember);
			
        	//member��ü�� request�� �����Ͽ� ��� ����
        	request.setAttribute("user", updateMember);
    		//return "/user/myPage.jsp";
			
			System.out.println("���������� �����Ϸ�,  ������������ �����̷���");
			return "redirect:/user/mypage";
		} catch(Exception e) {
			System.out.println("����������  ��������, ��ϴٽ�");
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", updateMember);
			return "/user/myPage.jsp";
		}
	}

}
