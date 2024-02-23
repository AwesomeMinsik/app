package kr.co.rland.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class MVCConfig {
	
	//뷰리졸버를 만들어서 줄테니.... 이것 좀 담아줘~ 이름은 뭐로(aa)해서 담아줘
	   @Bean
	   public ViewResolver aa() {
	      InternalResourceViewResolver bean = new InternalResourceViewResolver();
	       bean.setViewClass(JstlView.class);
	       bean.setPrefix("/WEB-INF/view/");
	       bean.setSuffix(".jsp");
	       return bean;
	   }
	   
}
