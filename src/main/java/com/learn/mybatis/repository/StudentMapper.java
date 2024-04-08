package com.learn.mybatis.repository;

import com.learn.mybatis.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAllStudents();

    void insertStudent(Student student);

    void updateStudent(Student student, int id);

    Student selectStudentById(int id);

    void deleteStudent(Integer id);
}
