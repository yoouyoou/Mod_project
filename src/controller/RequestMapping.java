package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.MyReservationController;
import controller.guide.AddReservationController;
import controller.guide.AddScheduleController;
import controller.guide.CheckReservationController;
import controller.guide.CheckScheduleController;
import controller.item.ItemReservationController;
import controller.item.ItemViewController;
import controller.item.SafeGradeViewController;
import controller.item.SearchViewController;
import controller.user.DeleteUserController;
import controller.user.LoginController;
import controller.user.LogoutController;
import controller.user.MainController;
import controller.user.MyPageController;
import controller.user.RegisterUserController;
import controller.user.UpdateUserController;
import controller.user.UpdateUserFormController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // �� ��û uri�� ���� controller ��ü�� ������ HashMap ����
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// �� uri�� �����Ǵ� controller ��ü�� ���� �� ����
    	//main����
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/main", new MainController());
        
        //user����
        mappings.put("/user/mypage", new MyPageController());
        mappings.put("/user/myreservation", new MyReservationController());
        
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
        
        mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/user/register", new RegisterUserController());
        
        mappings.put("/user/update/form", new UpdateUserFormController());
        mappings.put("/user/update", new UpdateUserController());
        
        mappings.put("/user/safeGrade", new SafeGradeViewController());
        
        //���̵� ����
        mappings.put("/guide/addreservation/form", new ForwardController("/guide/addReservation.jsp"));
        mappings.put("/guide/addreservation", new AddReservationController());
        mappings.put("/guide/checkreservation", new CheckReservationController());
        mappings.put("/guide/checkschedule", new CheckScheduleController());
        mappings.put("/guide/addschedule", new AddScheduleController());
 
        
        //��ǰ ����
        mappings.put("/item/country/form", new ForwardController("/item/country.jsp"));
        mappings.put("/item/price/form", new ForwardController("/item/price.jsp"));
        mappings.put("/item/season/form", new ForwardController("/item/season.jsp"));
        mappings.put("/item/theme/form", new ForwardController("/item/theme.jsp"));
        mappings.put("/item/searchView", new SearchViewController());
        mappings.put("/item/view", new ItemViewController());
        mappings.put("/item/reservation", new ItemReservationController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// �־��� uri�� �����Ǵ� controller ��ü�� ã�� ��ȯ
        return mappings.get(uri);
    }
}
