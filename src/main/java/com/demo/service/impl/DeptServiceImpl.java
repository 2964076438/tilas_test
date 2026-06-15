package com.demo.service.impl;

import com.demo.mapper.DeptMapper;
import com.demo.pojo.Dept;
import com.demo.pojo.Result;
import com.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public void delete(Integer id) {
        deptMapper.deleteDept(id);
    }

    @Override
    public List<Dept> select() {
        return deptMapper.selectDept();
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept selectById(Integer id) {

        return deptMapper.selectDeptById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }
}
