package com.demo.mapper;

import com.demo.pojo.Clazz;
import com.demo.pojo.ClazzDataQueryParm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> pageSelect(ClazzDataQueryParm clazzDataQueryParm);

    void deleteById(Integer id);

    void insert(Clazz clazz);

    Clazz selectById(Integer id);

    void update(Clazz clazz);
}
