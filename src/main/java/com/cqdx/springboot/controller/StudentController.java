package com.cqdx.springboot.controller;

import com.cqdx.springboot.dto.StudentDTO;
import com.cqdx.springboot.entity.Student;
import com.cqdx.springboot.service.StudentService;
import com.cqdx.springboot.utils.PageUtil;
import com.cqdx.springboot.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2023-06-28 09:58:16
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 分页查询
     *
     * @param studentDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("listStudent")
    public DataResult queryByPage(@RequestBody StudentDTO studentDto) {
        Long page = studentDto.getPage();
        Long limit = studentDto.getLimit();
        Long startPage = PageUtil.getStartPage(page, limit);
        studentDto.setPage(startPage);
        DataResult dataResult = this.studentService.queryByPage(studentDto);
        return dataResult;
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @PostMapping("getStudent")
    public DataResult queryById(@RequestBody Student student) {
        Student student1 = this.studentService.queryById(student.getStudentId());
        return DataResult.successByData(student1);
    }

    /**
     * 新增数据
     *
     * @param student 实体
     * @return 新增结果
     */
    @PostMapping("addStudent")
    public DataResult add(@RequestBody Student student) {
        Student insert = this.studentService.insert(student);
        return DataResult.successByData(insert);
    }

    /**
     * 编辑数据
     *
     * @param student 实体
     * @return 编辑结果
     */
    @PostMapping("updateStudent")
    public DataResult edit(@RequestBody Student student) {
        Student update = this.studentService.update(student);
        return DataResult.successByData(update);
    }

    /**
     * 删除数据
     *
     * @return 删除是否成功
     */
    @PostMapping("delStudent")
    public DataResult deleteById(@RequestBody Student student) {
        boolean b = this.studentService.deleteById(student.getStudentId());
        if(b){
            return DataResult.succ();
        }
        return DataResult.err();
    }

}

