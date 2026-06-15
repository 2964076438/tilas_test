package com.demo.mapper;

import com.demo.pojo.DataQueryParam;
import com.demo.pojo.Emp;
import com.demo.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
    //    @Select("select count(*) from emp e left join dept d on e.id =d.id")
//    public Long Count();
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id =d.id order by e.update_time desc " +
//            "limit #{start},#{pageSize}")
//
//    public List<Emp> select(Integer start,Integer pageSize);
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id =d.id order by e.update_time desc")

    public List<Emp> select(DataQueryParam dataQueryParam);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert(" INSERT INTO emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "VALUES (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    void deleteById(List<Integer> ids);

    Emp selectById(Integer id);

    void updateById(Emp emp);

    Emp selectByUsernameAndPassword(Emp emp);
}
