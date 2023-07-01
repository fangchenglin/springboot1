package com.cqdx.springboot.dto;

import com.cqdx.springboot.entity.Student;

/**
 * @version V1.0
 * @author: hepeng
 * @Title: StudentDTO.java
 * @Package:
 * @description:
 * @date: 2023/6/19 09:09
 */
public class StudentDTO extends Student {
    private Long page;//当前页码
    private Long limit;//每页条数

    public StudentDTO() {
    }

    public StudentDTO(Long page, Long limit) {
        this.page = page;
        this.limit = limit;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
