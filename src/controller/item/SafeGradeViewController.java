package controller.item;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.SafeGrade;
import model.dao.SafeGradeDAO;

public class SafeGradeViewController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("안전등급 컨트롤러");
		
		SafeGradeDAO safeGradeDao = new SafeGradeDAO();
		
		try {
			ArrayList<SafeGrade> safeGradeList = (ArrayList<SafeGrade>) safeGradeDao.searchSafeGrade();
			System.out.println(safeGradeList.size());
			request.setAttribute("safeGradeList", safeGradeList);
			request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));	
			return "/user/safeGrade.jsp";
		} catch(Exception e) {
			return "redirect:/user/main";
		}
	}
	
}
