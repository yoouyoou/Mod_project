package controller.guide;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.schedule;
import model.dao.itemDAO;

public class AddScheduleController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AddScheduleController����");
		//�α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) { //if (!UserSessionUtils.hasLogined(request.getSession()))
    		return "redirect:/user/main";
        }
    	
    	HttpSession session = request.getSession();
    	request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));
    	
    	int scheId = Integer.valueOf( request.getParameter("scheId") );
    	System.out.println("scheId: " + scheId);
    	
    	String scheName = request.getParameter("scheName");
    	System.out.println("scheName: " + scheName);
    	
    	Date scheTime = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("scheTime"));
    	System.out.println("scheTime: " + scheTime);
    	
    	String scheLocation = request.getParameter("scheLocation");
    	System.out.println("scheLocation: " + scheLocation);
    	
    	String scheDescription = request.getParameter("scheDescription");
    	System.out.println("scheDescription: " + scheDescription);
    	
		int itemId = Integer.valueOf(request.getParameter("clickId"));
		System.out.println("�̰� ������� ���� �Ѿ������ �𸣰���(Ŭ���� ���̵�): " + itemId);
		
		schedule newSchedule = new schedule(scheId, scheName, scheTime, scheLocation, scheDescription, itemId);
		
		try {
			itemDAO itemDao = new itemDAO();
			int r = itemDao.createScheduleByGuide(newSchedule);
			
			if(r == 1) {
				System.out.println("���̵� ������ �߰� ����, ��ǰ����â���� �̵�");
				return "/guide/addSchedule.jsp";
			}
			else
				return "redirect:/user/main";
		} catch(Exception e) {
			System.out.println("������ �߰� ����");
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			return "redirect:/user/main";
		}
	}

}
