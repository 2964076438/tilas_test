package com.demo.mapper;

import com.demo.pojo.Dept;
import com.demo.pojo.Result;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 根据id删除部门
     *
     * @param id
     */
    @Delete("delete from dept where id=#{id}")
    void deleteDept(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void updateDept(Dept dept);

    @Select("select id, name, create_time,update_time from dept order by update_time desc")
    List<Dept> selectDept();

    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void addDept(Dept dept);

    @Select("SELECT id, name, create_time,update_time from dept where id=#{id}")
    Dept selectDeptById(Integer id);

}
