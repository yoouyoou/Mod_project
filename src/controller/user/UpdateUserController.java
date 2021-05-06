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
		System.out.println("마이페이지 수정 컨트롤러");
		
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
			
        	//member객체를 request에 저장하여 뷰로 전달
        	request.setAttribute("user", updateMember);
    		//return "/user/myPage.jsp";
			
			System.out.println("마이페이지 수정완료,  마이페이지로 리다이렉션");
			return "redirect:/user/mypage";
		} catch(Exception e) {
			System.out.println("마이페이지  수정실패, 등록다시");
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", updateMember);
			return "/user/myPage.jsp";
		}
	}

}
