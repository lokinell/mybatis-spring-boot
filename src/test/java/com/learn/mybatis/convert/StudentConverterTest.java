package com.learn.mybatis.convert;

import com.learn.mybatis.DataFaker;
import com.learn.mybatis.domain.Student;
import com.learn.mybatis.web.dto.StudentDTO;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
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
        EasyRandom generator = new EasyRandom(new EasyRandomParameters()
                .randomize(field->
                                field.getName().equals("email"),
                        new DataFaker.EmailRandomizer()));
        Student source = generator.nextObject(Student.class);
        StudentDTO studentDTO = studentConverter.fromStudent(source);
        Assertions.assertThat(studentDTO.getName()).isEqualTo(source.getName());
        Assertions.assertThat(studentDTO.getStudentID()).isEqualTo(source.getId());
    }
}