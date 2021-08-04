package com.kgisl.studentspringboot.service;

import java.util.List;

import com.kgisl.studentspringboot.entity.Student;

public interface StudentService {
    public List<Student> getStudents();
    public Student findByStudentId(Long id);
    public Student createStudent(Student student);
    public Student updateStudent(Long id,Student student);
    public void deleteStudentById(Long id);    
}
