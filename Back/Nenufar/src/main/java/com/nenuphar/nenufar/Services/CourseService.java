package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Course;
import com.nenuphar.nenufar.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course getCourse(Long id){ return courseRepository.findOne(id);}

    public Course getPostedCourse(Course course){ return course;}

    public Course createCourse(String name, int nbrSkills)
    {
        Course course = new Course(name, nbrSkills);
        courseRepository.save(course);
        return course;
    }

    public List<Object> getCoursesFromUUID(String uuid)
    {
        try
        {
            List<Object> courses = courseRepository.getCoursesFromUUID(uuid);
            return courses;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
