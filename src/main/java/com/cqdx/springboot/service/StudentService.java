package com.cqdx.springboot.service;

import com.cqdx.springboot.dto.StudentDTO;
import com.cqdx.springboot.entity.Student;
import com.cqdx.springboot.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2023-06-28 09:58:19
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param studentId 主键
     * @return 实例对象
     */
    Student queryById(Long studentId);

    /**
     * 分页查询
     *
     * @param studentDto 筛选条件
     * @return 查询结果
     */
    DataResult queryByPage(StudentDTO studentDto);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param studentId 主键
     * @return 是否成功
     */
    boolean deleteById(Long studentId);

}
