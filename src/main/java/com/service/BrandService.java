package com.service;

import com.mapper.BrandMapper;
import com.pojo.Brand;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author :珠代
 * @description :
 * @create :2022-03-16 22:47:00
 */
public class BrandService {
    //工厂类创建工对象，创在方法外面便于复用
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    //查询所有
    public List<Brand> selectAll() {
        //使用工厂打开会话
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        List<Brand> brands = brandMapper.selectAll();
        //释放资源
        sqlSession.close();

        return brands;
    }
    //添加
    public void add(Brand brand){
        //使用工厂打开会话
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    //根据id查询
    public Brand selectById(int id) {
        //使用工厂打开会话
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        Brand brand=brandMapper.selectById(id);
        //释放资源
        sqlSession.close();

        return brand;
    }

    //修改
    public void update(Brand brand){
        //使用工厂打开会话
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.update(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    //根据id查询
    public void delete(int id) {
        //使用工厂打开会话
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        brandMapper.delete(id);
        //释放资源
        sqlSession.close();

    }


}
