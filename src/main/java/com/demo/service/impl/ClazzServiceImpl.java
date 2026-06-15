package com.demo.service.impl;

import com.demo.mapper.ClazzMapper;
import com.demo.pojo.Clazz;
import com.demo.pojo.ClazzDataQueryParm;
import com.demo.pojo.PageResult;
import com.demo.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> pageSelect(ClazzDataQueryParm clazzDataQueryParm) {
        PageHelper.startPage(clazzDataQueryParm.getPage(), clazzDataQueryParm.getPageSize());
        List<Clazz> list =clazzMapper.pageSelect(clazzDataQueryParm);
        Page<Clazz> page = (Page<Clazz>) list;
        return new PageResult<Clazz>(page.getTotal(),list);
    }
    @Override
    public void delete(Integer id) {
    clazzMapper.deleteById(id);
    }
    @Override
    public void insert(Clazz clazz) {
        clazz.setCreateTime(LocalDate.now());
        clazz.setUpdateTime(LocalDate.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz selectById(Integer id) {
        return clazzMapper.selectById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDate.now());
        clazzMapper.update(clazz);
    }
}
