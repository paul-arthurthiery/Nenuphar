package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.DTO.GetAllAboutCourseDTO;
import com.nenuphar.nenufar.DTO.GetIDDTO;
import com.nenuphar.nenufar.DTO.GettokenDTO;
import com.nenuphar.nenufar.Models.Course;
import com.nenuphar.nenufar.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/get_course", method = RequestMethod.POST)
    private ResponseEntity getCourseById(@RequestBody GetIDDTO dto)
    {
        Long id = dto.getID();
        Course course = courseService.getCourse(id);
        if(course==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "/get_courses", method = RequestMethod.POST)
    private ResponseEntity getCoursesFromUUID(@RequestBody GettokenDTO dto)
    {
        String uuid = dto.getToken();
        List<Course> courses = courseService.getCoursesFromUUID(uuid);
        if(courses==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(courses.toArray(), HttpStatus.OK);
    }

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public ResponseEntity createCourse(@RequestBody String name, int nbrSkills)
    {
        Course course = courseService.createCourse(name, nbrSkills);
        if(course==null) {return new ResponseEntity(HttpStatus.BAD_REQUEST);}
        return new ResponseEntity<>(course.getName(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get_all", method = RequestMethod.POST)
    public ResponseEntity getAllAboutSkillsFromIDUuid(@RequestBody GetAllAboutCourseDTO dto)
    {
        long course_id = dto.getCourse_id();
        String uuid = dto.getUuid();
        ArrayList<Object> everything = courseService.getAllAboutSkillsFromIDUuid(course_id,uuid);
        if(everything==null){ return new ResponseEntity(HttpStatus.BAD_REQUEST); }
        return new ResponseEntity<>(everything, HttpStatus.OK);
    }
}
