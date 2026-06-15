package com.demo.service;

import com.demo.mapper.DeptMapper;
import com.demo.pojo.Dept;
import com.demo.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DeptService {

    void delete(Integer id);

    List<Dept> select();

    void add(Dept dept);

    Dept selectById(Integer id);

    void update(Dept dept);
}
