package com.learn.mybatis.convert;

import com.learn.mybatis.domain.Student;
import com.learn.mybatis.web.dto.StudentDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentConverter {

    @InheritInverseConfiguration
    StudentDTO fromStudent(Student student);

    @Mapping(source = "studentID", target = "id")
    Student toStudent(StudentDTO studentDTO);

}
