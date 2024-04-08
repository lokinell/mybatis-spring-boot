package com.learn.mybatis.repository;

import com.learn.mybatis.domain.Student;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void findByStateTest() {
        List<Student> before = studentMapper.findAllStudents();
        Student newStudent = Student.builder()
                .name("loki")
                .email("lokinell@gmail.com")
                .build();
        studentMapper.insertStudent(newStudent);
        List<Student> after = studentMapper.findAllStudents();
        Assertions.assertThat(after.size() - before.size()).isEqualTo(1);
    }

}