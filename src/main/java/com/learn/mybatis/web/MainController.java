package com.learn.mybatis.web;

import com.learn.mybatis.convert.StudentConverter;
import com.learn.mybatis.domain.Student;
import com.learn.mybatis.repository.StudentMapper;
import com.learn.mybatis.web.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/", consumes = "application/json", produces = "application/json")
public class MainController {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentConverter studentConverter;

    @GetMapping("/findAllStudents")
    public List<StudentDTO> findAllStudents() {
        List<Student> allStudents = studentMapper.findAllStudents();
        List<StudentDTO> result = new ArrayList<>();
        allStudents.forEach(student -> {
            result.add(studentConverter.fromStudent(student));
        });
        return result;
    }

    @PostMapping("/insertStudent")
    public void insertStudent(@RequestBody StudentDTO student) {
        studentMapper.insertStudent(studentConverter.toStudent(student));
    }

    @PutMapping("/updateStudent/{id}")
    public void updateStudent(@RequestBody StudentDTO student, @PathVariable("id") int id) {
        studentMapper.updateStudent(studentConverter.toStudent(student), id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentMapper.deleteStudent(id);
    }
}