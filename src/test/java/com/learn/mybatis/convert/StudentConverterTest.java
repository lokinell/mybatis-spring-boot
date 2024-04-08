package com.learn.mybatis.convert;

import com.learn.mybatis.domain.Student;
import com.learn.mybatis.web.dto.StudentDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentConverterTest {

    @Autowired
    StudentConverter studentConverter;

    @Test
    public void shouldMapStudentToDto() {
        Student source = Student.builder()
                .id(56)
                .name("hello")
                .email("world@test")
                .build();

        StudentDTO studentDTO = studentConverter.fromStudent(source);
        Assertions.assertThat(studentDTO.getName()).isEqualTo("hello");
        Assertions.assertThat(studentDTO.getStudentID()).isEqualTo(56);
    }
}