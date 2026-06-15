package com.demo.mapper;

import com.demo.pojo.Emp;
import com.demo.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void insertBatch(List<EmpExpr> exprList);

    void deleteExprById(List<Integer> empIds);

    void updateExpr(Integer id, List<EmpExpr> exprList);
}
