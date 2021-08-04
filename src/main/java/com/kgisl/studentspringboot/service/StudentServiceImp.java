package com.kgisl.studentspringboot.service;

import java.util.List;

import javax.transaction.Transactional;

import com.kgisl.studentspringboot.entity.Student;
import com.kgisl.studentspringboot.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentServiceImp implements StudentService{

    @Autowired
    public StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByStudentId(Long id) {
        studentRepository.findById(id);
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student s = studentRepository.getById(id);
        s.setName(student.getName());
        s.setCity(student.getCity());
        s.setDepartment(student.getDepartment());
        s.setGender(student.getGender());

        studentRepository.save(student); 
        return studentRepository.save(student); 
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        
    }   
}
