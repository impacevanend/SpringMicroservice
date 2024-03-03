package com.microservice.course.client;

import com.microservice.course.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "http://localhost:8090/api/student")//consulting microservice's name
public interface StudentClient {
    @GetMapping("/search_by_course/{idCourse}")
    List<StudentDto> findAllStudentByCourse(@PathVariable("idCourse") Long idCourse);
}