package com.mapper;

import com.pojo.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author :珠代
 * @description :
 * @create :2022-03-16 22:37:00
 */
public interface BrandMapper {

    //查询所有
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    //添加
    @Select("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    //根据id查询
    @Select("select * from tb_brand where id=#{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    //修改数据
    @Select("update tb_brand set " +
            "brand_name=#{brandName},company_name=#{companyName}," +
            "ordered=#{ordered},description=#{description},STATUS=#{status} where id=#{id}")
    void update(Brand brand);
    //删除数据
    @Select("delete from tb_brand where id=#{id}")
    void delete(int id);

}
