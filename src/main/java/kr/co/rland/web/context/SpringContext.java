package kr.co.rland.web.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.rland.web.entity.Menu;

public class SpringContext {

	public static void main(String[] args) {

		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("spring-config.xml");
				new AnnotationConfigApplicationContext("kr.co.rland.web.entity"); //패키지안에 어노테이션이 붙은것들을 찾아줌
		

		{
			Menu menu = (Menu) context.getBean("aa"); //형변환 해주는 이유는 메뉴라는 객체만 뽑아오고 어떤타입인지는 정의하지 않았기때문에 
													  //오브젝트타입의 객체로 추출이된다. 
													  //해당 클래스명의 대문자를 자동으로 소문자로 변환해준다
			System.out.println(menu);
		}
		
		{
			Menu menu = context.getBean(Menu.class);
			System.out.println(menu);
		}
	}

}
