package com.cqdx.springboot.service.impl;

import com.cqdx.springboot.dto.StudentDTO;
import com.cqdx.springboot.entity.Student;
import com.cqdx.springboot.dao.StudentDao;
import com.cqdx.springboot.service.StudentService;
import com.cqdx.springboot.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2023-06-28 09:58:20
 */
@Service("studentService")
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param studentId 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Long studentId) {
        return this.studentDao.queryById(studentId);
    }

    /**
     * 分页查询
     *
     * @param studentDto 筛选条件
     * @return 查询结果
     */
    @Override
    public DataResult queryByPage(StudentDTO studentDto) {
        long total = this.studentDao.count(studentDto);
        List<Student> students = this.studentDao.queryAllByLimit(studentDto);
        return DataResult.successByTotalData(students,total);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        this.studentDao.update(student);
        return this.queryById(student.getStudentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param studentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long studentId) {
        return this.studentDao.deleteById(studentId) > 0;
    }
}
