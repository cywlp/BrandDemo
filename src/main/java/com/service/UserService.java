package com.service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author :珠代
 * @description :
 * @create :2022-03-18 10:01:00
 */
public class UserService {
    //工厂类创建工对象，创在方法外面便于复用
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    //登录方法
    public User login(String username,String password){

        SqlSession sqlSession = factory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.select(username, password);

        sqlSession.close();

        return user;
    }

    //注册方法
    public boolean register(User user){

        SqlSession sqlSession = factory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User u = userMapper.selectByUsername(user.getUsername());

        if(u==null){
            //用户名不存在，注册
            userMapper.add(user);
            sqlSession.commit();
        }

        sqlSession.close();

        return u==null;
    }
}
