package kr.co.rland.web.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyBatisConfigListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("톰캣 시작이벤트");
//		try {
//			System.out.println("config 읽는중");
//			Class.forName("kr.co.rland.web.context.MyBatisContext");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("톰캣 종료이벤트");
	}
}
