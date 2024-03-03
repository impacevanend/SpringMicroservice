package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import com.microservice.student.service.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudenteController {


    private final IStudentService iStudentService;

    public StudenteController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        iStudentService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?>findAllStudents(){
        return ResponseEntity.ok(iStudentService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        return ResponseEntity.ok(iStudentService.findById(id));
    }

    @GetMapping("/seach_by_course/{idCoruse}")
    public ResponseEntity<?>findByIdCourse(@PathVariable Long idCoruse){
        return ResponseEntity.ok(iStudentService.findByIdCourse(idCoruse));
    }
}
