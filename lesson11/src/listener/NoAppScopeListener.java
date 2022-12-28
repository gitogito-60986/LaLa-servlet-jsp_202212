package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class NoAppScopeListener implements ServletContextAttributeListener {

  public void attributeAdded(ServletContextAttributeEvent arg) {
	  System.out.println("警告: アプリケーションスコープへのインスタンスの保存は禁止されています。");
  }

  public void attributeRemoved(ServletContextAttributeEvent arg) {
	  System.out.println("警告: アプリケーションスコープ内のインスタンスの削除は禁止されています。");
  }
  
  public void attributeReplaced(ServletContextAttributeEvent arg) {
	  System.out.println("警告: アプリケーションスコープ内のインスタンスの変更・更新は禁止されています。");
  }
}
  