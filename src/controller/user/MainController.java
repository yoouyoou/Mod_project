package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class MainController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�α��� ���� Ȯ��
    	if (UserSessionUtils.hasLogined(request.getSession())) { //if (!UserSessionUtils.hasLogined(request.getSession()))
            //return "redirect:/user/login/form";		// login form ��û���� redirect
    		request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));
        }
    	
    	request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));		
		
    	return "/user/main.jsp";
	}

}
