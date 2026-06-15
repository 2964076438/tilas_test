package com.demo.controller;

import com.demo.pojo.*;
import com.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    //分页查询
    @GetMapping("/emps")
    public Result List (DataQueryParam dataQueryParam){
        log.info("分页查询：{}",dataQueryParam);
        PageResult<Emp> pageResult= empService.list(dataQueryParam);
        return Result.success(pageResult);

    }
    //新增
    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        empService.add(emp);
        return Result.success();
    }
   @DeleteMapping("/emps")
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工：{}",ids);
        empService.delete(ids);
        return Result.success();
   }
   //查询回显
    @GetMapping("/emps/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("查询员工：{}",id);
        Emp emp=empService.selectById(id);
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工：{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
