package controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dao.reservationDAO;

public class ItemReservationController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		reservationDAO scheDao = new reservationDAO();
    	HttpSession session = request.getSession();
    	String member_id = (String) session.getAttribute("userId");
    	int item_id = Integer.parseInt(request.getParameter("itemReservation"));
    	
		scheDao.itemReservationByUser(item_id, member_id);
		return "redirect:/user/main.jsp";
	}

}
