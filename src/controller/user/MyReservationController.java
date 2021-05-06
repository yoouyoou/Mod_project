package controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.reservation;
import model.dao.reservationDAO;

public class MyReservationController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("����Ȯ�� ��Ʈ�ѷ� ����");
		
		// �α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("�� �α���");
            return "redirect:/user/login/form";		// login form ��û���� redirect
        }
    	
    	HttpSession session = request.getSession();
    	String userId = (String) session.getAttribute("userId");
    	System.out.println("���� ��û�� userId �Ķ���� ��: " + userId);
    	
    	reservationDAO reservationDao = new reservationDAO();
    	List<Integer> resIdList = new ArrayList<Integer>();			 		//�����ǰ�� ���̵� ����Ʈ
    	List<reservation> reservationList = new ArrayList<reservation>();		//�������� ��ü ����Ʈ
    	
    	resIdList = reservationDao.searchResIdByUser(userId);  //�����ǰ�� ���̵� ����Ʈ
    	System.out.println("�߰� ����(�α����� ���̵�� ��ǰ�� res_id���� ����): " + resIdList.size());
    	
    	for(int i = 0; i < resIdList.size(); i++) {
    		reservationList.add( reservationDao.searchReservationByUser(resIdList.get(i)) );
    	}
    	System.out.println(reservationDao.searchReservationByUser(1).getItemName());
    	System.out.println("�߰� ����(�˻��� �����ǰ ����): " + reservationList.size());
    	
    	request.setAttribute("reservationList", reservationList);
    	request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));
		
    	System.out.println("���ǿ� ���� �α��� ��ü�� �˻���ǰ ��Ƽ� �̵�");
    	return "/user/myReservation.jsp";
	}

}
