package com.microservice.student.service;

import com.microservice.student.entities.Student;
import com.microservice.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;


    public StudentsServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentRepository.findAllStudent(idCourse);
    }
}
