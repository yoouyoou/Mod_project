package controller.item;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.item;
import model.dao.itemDAO;

public class SearchViewController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String searchString = request.getParameter("searchView");
		itemDAO itemDao = new itemDAO();
		ArrayList<item> searchList = new ArrayList<item>();
		
		try {
			ArrayList<Integer> idList = (ArrayList<Integer>) itemDao.searchStringItem(searchString);
			for(int i = 0; i < idList.size(); i++) {
				searchList.add( itemDao.searchItemById((int)idList.get(i)) );
			}
			request.setAttribute("searchList", searchList);
			request.setAttribute("searchString", searchString);
			request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));	
			return "/item/searchView.jsp";
		} catch(Exception e) {
			return "redirect:/user/main";
		}
	}

}
