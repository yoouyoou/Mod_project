package controller.guide;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.schedule;
import model.dao.itemDAO;

public class CheckScheduleController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�α��� ����
		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/user/login/form";
		}
		
		String itemName = request.getParameter("clickName");
		itemName = new String(itemName.getBytes("ISO8859_1"), "UTF-8");
		//itemName = new String(itemName.getBytes("ISO8859_1"), "UTF-8");
		System.out.println("�̸��� �̻��ϰ� ���: " + itemName);
		int itemId = Integer.parseInt(request.getParameter("clickId"));
		System.out.println("���̵� �̸�: " + itemId);
		try {
			itemDAO itemDao = new itemDAO();
			List<schedule> scheList = new ArrayList<schedule>();
			scheList = itemDao.searchScheduleByID(itemId);
			request.setAttribute("checkItemList", scheList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));	
		request.setAttribute("clickId", itemId);
		request.setAttribute("clickName", itemName);

		return "/guide/checkSchedule.jsp";
	}

}
