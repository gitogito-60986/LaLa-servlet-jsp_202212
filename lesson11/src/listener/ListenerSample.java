package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerSample implements ServletContextListener {

  public void contextInitialized(ServletContextEvent arg0) {
	ServletContext context = arg0.getServletContext();
	Integer count = 0;
	context.setAttribute("count", count);
	System.out.println("ListenerSample サーブレット によってリスナーが実行されました。");
  }

  public void contextDestroyed(ServletContextEvent arg0) {
	  ServletContext context = arg0.getServletContext();
	  context.removeAttribute("count");
	  System.out.println("ListenerSample サーブレット の destroy() が実行されました");
  }
}