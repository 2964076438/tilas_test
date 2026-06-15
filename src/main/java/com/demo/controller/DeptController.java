package com.demo.controller;

import com.demo.pojo.Dept;
import com.demo.pojo.Result;
import com.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    /**
     * 删除部门
     *
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        System.out.println("删除部门ID：" + id);
        // TODO: 删除部门
        deptService.delete(id);
        return Result.success();

    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping
   public Result select() {
        System.out.println("查询全部" );
        // TODO: 查询部门
        List<Dept> select = deptService.select();

        return Result.success(select);
   }

    /**
     * 添加部门
     * @param dept
     * @return
     */
   @PostMapping
    public Result add(@RequestBody Dept dept) {
        System.out.println("添加部门" );
        // TODO: 添加部门
        deptService.add(dept);
        return Result.success();
   }
   @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        System.out.println("查询部门ID：" + id);
        // TODO: 查询部门
        Dept dept = deptService.selectById(id);
        return Result.success(dept);
   }
   @PutMapping
    public Result update(@RequestBody Dept dept) {
       System.out.println("更新部门");
       // TODO: 更新部门
       deptService.update(dept);
       return Result.success();
   }
}
