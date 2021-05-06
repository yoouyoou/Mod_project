package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.member;
import model.dao.memberDAO;

public class MyPageController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// �α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("�� �α���");
            return "redirect:/user/login/form";		// login form ��û���� redirect
        }

    	memberDAO memberDao = new memberDAO();
    	HttpSession session = request.getSession();
    	String userId = (String) session.getAttribute("userId");
    	//String userId = request.getParameter("userId");
    	System.out.println("���� ��û�� userId �Ķ���� ��: " + userId);
    	request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));		
    	member member = new member();
    	
    	try {
    		member = memberDao.searchMemberInfo(userId);
        	//member��ü�� request�� �����Ͽ� ��� ����
        	request.setAttribute("user", member);
    		return "/user/myPage.jsp";
    		
    	}catch(Exception e) {
    		return "redirect:/user/main";
    	}
    	
	}

}
