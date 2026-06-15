package com.demo.controller;

import com.demo.pojo.Clazz;
import com.demo.pojo.ClazzDataQueryParm;
import com.demo.pojo.PageResult;
import com.demo.pojo.Result;
import com.demo.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping("/clazzs")
    public Result pageSelect(ClazzDataQueryParm clazzDataQueryParm){
        log.info("clazzDataQueryParm:{}",clazzDataQueryParm);
        PageResult<Clazz> pageResult= clazzService.pageSelect(clazzDataQueryParm);
         return Result.success(pageResult);
    }
    @DeleteMapping("/clazzs/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("id:{}",id);
        clazzService.delete(id);
        return Result.success();
    }
    @PostMapping("/clazzs")
    public Result insert(@RequestBody Clazz clazz){
        log.info("clazz:{}",clazz);
        clazzService.insert(clazz);
        return Result.success();
    }
    @GetMapping("/clazzs/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("id:{}",id);
        Clazz clazz=clazzService.selectById(id);
        return Result.success(clazz);
    }
    @PutMapping("/clazzs")
    public Result update(@RequestBody Clazz clazz){
        log.info("clazz:{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }
}
