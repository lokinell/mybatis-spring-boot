package com.learn.mybatis.convert;

import com.learn.mybatis.domain.Student;
import com.learn.mybatis.web.dto.StudentDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-08T14:22:19+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_402 (Temurin)"
)
@Component
public class StudentConverterImpl implements StudentConverter {

    @Override
    public StudentDTO fromStudent(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentID( student.getId() );
        studentDTO.setName( student.getName() );
        studentDTO.setEmail( student.getEmail() );

        return studentDTO;
    }

    @Override
    public Student toStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.id( studentDTO.getStudentID() );
        student.name( studentDTO.getName() );
        student.email( studentDTO.getEmail() );

        return student.build();
    }
}
