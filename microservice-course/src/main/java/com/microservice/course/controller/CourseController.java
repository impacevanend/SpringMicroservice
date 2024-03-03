package com.microservice.course.controller;


import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final ICourseService iCourseService;

    public CourseController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course){
        iCourseService.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse(){
        return ResponseEntity.ok(iCourseService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(iCourseService.findById(id));
    }

}
