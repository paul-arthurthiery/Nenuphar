package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Models.Course;
import com.nenuphar.nenufar.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    private ResponseEntity getCourseById(@PathVariable("id") long id)
    {
        Course course = courseService.getCourse(id);
        //if(course==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
