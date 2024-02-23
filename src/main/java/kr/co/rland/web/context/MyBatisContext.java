package kr.co.rland.web.context;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisContext {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		System.out.println("테스트");
		try {
			String resource = "mybatis-config.xml";
//			System.out.println(resource);
			InputStream inputStream;
				inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
//			MyBatisContext.setSqlSessionFactory(sqlSessionFactory);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		MyBatisContext.sqlSessionFactory = sqlSessionFactory;
	}
}
