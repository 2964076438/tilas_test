package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer id;
    private String name;
    private Integer room;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Integer masterId;
    private LocalDate createTime;
    private LocalDate updateTime;
    private String masterName;
    private Integer status;
    private String subject;
}
