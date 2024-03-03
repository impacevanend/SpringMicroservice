package com.microservice.course.service;

import com.microservice.course.entities.Course;
import com.microservice.course.repository.ICourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    private final ICourseRepository iCourseRepository;

    public CourseServiceImpl(ICourseRepository iCourseRepository) {
        this.iCourseRepository = iCourseRepository;
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) iCourseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return iCourseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        iCourseRepository.save(course);
    }
}
