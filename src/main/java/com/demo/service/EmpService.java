package com.demo.service;

import com.demo.pojo.DataQueryParam;
import com.demo.pojo.Emp;
import com.demo.pojo.LoginInfo;
import com.demo.pojo.PageResult;

import java.util.List;

public interface EmpService {
    PageResult<Emp> list(DataQueryParam queryParam);

    void add(Emp emp);

    void delete(List<Integer> ids);

    Emp selectById(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp emp);
}
