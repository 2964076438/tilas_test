package com.demo.service.impl;

import com.demo.mapper.EmpExprMapper;
import com.demo.mapper.EmpMapper;
import com.demo.pojo.*;
import com.demo.service.EmpLogService;
import com.demo.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<Emp> list(DataQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Emp> select = empMapper.select(param);
        Page<Emp> empPage = (Page<Emp>) select;
        return new PageResult<>(empPage.getTotal(), empPage.getResult());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(expr -> expr.setEmpId(emp.getId()));
                empExprMapper.insertBatch(exprList);
            }

        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工：" + emp);
            empLogService.insertLog(empLog);

        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteById(ids);
        empExprMapper.deleteExprById(ids);
    }

    @Override
    public Emp selectById(Integer id) {

        return empMapper.selectById(id);
    }

    @Override
    public void update(Emp emp) {
        empExprMapper.updateExpr(emp.getId(), emp.getExprList());
        empMapper.updateById(emp);
    }

    @Override
    public LoginInfo login(Emp emp) {
       Emp emp1 = empMapper.selectByUsernameAndPassword(emp);
       if (emp1 != null) {
           log.info("用户登录成功，用户名：{}", emp);
           return new LoginInfo(emp1.getId(), emp1.getUsername(), emp1.getPassword(), " ");
       } else {
           return null;
       }

    }
}
