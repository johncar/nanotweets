package com.nanotweets.dao.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.nanotweets.dao.custom.SequenceMapper;

public class MyBatis {
	
	static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSession() throws Exception{
		
		if( sqlSessionFactory == null ){
			String resource = "com/nanotweets/dao/xml/mybatis-config.xml";

			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			sqlSessionFactory.getConfiguration().addMapper(SequenceMapper.class);
		}

		return sqlSessionFactory.openSession();
	}
	
	public static void closeSession( SqlSession sqlSession ){
		if(sqlSession != null){
			sqlSession.close();
			sqlSession = null;
		}
	}
	
	
}
