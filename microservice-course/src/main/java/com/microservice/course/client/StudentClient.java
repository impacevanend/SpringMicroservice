package com.microservice.course.client;

import com.microservice.course.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090/seach_by_course/{idCoruse}") //consulting microservice's name
public interface StudentClient {
    @GetMapping("/seach_by_course/{idCoruse}")
    List<StudentDto>findAllStudentByCourse(@PathVariable Long idCoruse);
}
