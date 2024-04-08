package com.learn.mybatis.convert;

import com.learn.mybatis.domain.Student;
import com.learn.mybatis.web.dto.StudentDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentConverter {

    @Mapping(source = "studentID", target = "id")
    Student toStudent(StudentDTO studentDTO);

    @InheritInverseConfiguration
    StudentDTO fromStudent(Student student);


}
