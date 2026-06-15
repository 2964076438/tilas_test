package com.demo.service;

import com.demo.pojo.Clazz;
import com.demo.pojo.ClazzDataQueryParm;
import com.demo.pojo.PageResult;

import java.time.LocalDate;

public interface ClazzService {
    PageResult<Clazz> pageSelect(ClazzDataQueryParm clazzDataQueryParm);

    void delete(Integer id);

    void insert(Clazz clazz);

    Clazz selectById(Integer id);

    void update(Clazz clazz);
}
