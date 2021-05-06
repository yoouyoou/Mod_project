package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebServlet(name = "userSevlet", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private RequestMapping rm;

    @Override
    public void init() throws ServletException {
    	System.out.println("���� �Ϸ�");
        rm = new RequestMapping();
        rm.initMapping();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException {
    	logger.debug("Method : {}, Request URI : {}, ServletPath : {}", 
    			request.getMethod(), request.getRequestURI(), request.getServletPath());
    	
    	String contextPath = request.getContextPath();
    	String servletPath = request.getServletPath();
    	System.out.println("pathȮ��: "+contextPath+", "+servletPath);
    	
    	// URL �� servletPath�� �����Ǵ� controller�� ����
        Controller controller = rm.findController(servletPath);
        System.out.println("��Ʈ�ѷ� ã�� �Ϸ�");
        try {
        	// controller�� ���� request ó�� ��, �̵��� uri�� ��ȯ ����
            String uri = controller.execute(request, response);
            System.out.println("�̵��� uri: " + uri);
            
 			// ��ȯ�� uri�� ���� forwarding �Ǵ� redirection ���θ� �����ϰ� �̵� 
            if (uri.startsWith("redirect:")) {	
            	System.out.println("�����̷����� ���");
            	// redirection ����
            	String targetUri = contextPath + uri.substring("redirect:".length());
            	System.out.println("Ÿ��:" + targetUri);
            	response.sendRedirect(targetUri);	// redirect to url     
            	System.out.println("�����̷�Ʈ!!");
            }
            else {
            	System.out.println("�������� ���");
            	// forwarding ����
            	RequestDispatcher rd = request.getRequestDispatcher(uri);
                rd.forward(request, response);		// forward to the view page
            }                   
        } catch (Exception e) {
        	System.out.println("�̰�..�� ����");
            logger.error("Exception : {}", e);
            throw new ServletException(e.getMessage());
        }
    }
}
