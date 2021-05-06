package controller.item;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.item;
import model.schedule;
import model.dao.itemDAO;

public class ItemViewController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("아이템뷰 컨트롤러 내부");
		
		itemDAO itemDao = new itemDAO();
		
		int viewId = Integer.parseInt(request.getParameter("viewId"));
		System.out.println("선택한 상품 아이디: " + viewId);
		
		try {
			item item = itemDao.searchItemById(viewId);
			ArrayList<schedule> scheList = (ArrayList<schedule>) itemDao.searchScheduleByID(viewId);
			
			request.setAttribute("scheList", scheList);
			System.out.println(scheList.size());
			request.setAttribute("viewItem", item);
			return "/item/view.jsp";
		} catch(Exception e) {
			return "redirect:/user/main";
		}
	}

}
