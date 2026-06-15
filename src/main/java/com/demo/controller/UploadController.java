package com.demo.controller;

import com.demo.Utils.AliyunOSSOperator;
import com.demo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result uploadFile(MultipartFile file) throws Exception {
        log.info("上传文件: {}", file.getOriginalFilename());
        String url= aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("url: {}", url);

        return Result.success(url);

    }
}
