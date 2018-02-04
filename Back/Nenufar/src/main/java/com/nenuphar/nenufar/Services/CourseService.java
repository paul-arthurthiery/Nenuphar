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

    public Course getCourse(Long id)
    {
        Course temp = courseRepository.findOne(id);
        return infiniteLoopFix(temp);
    }

    public Course getPostedCourse(Course course){ return course;}

    public Course createCourse(String name, int nbrSkills)
    {
        Course course = new Course(name, nbrSkills);
        courseRepository.save(course);
        return course;
    }

    public List<Course> getCoursesFromUUID(String uuid)
    {
        try
        {
            List<Course> courses = courseRepository.getCoursesFromUUID(uuid);
            return infiniteListProcess(courses);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    private Course infiniteLoopFix(Course temp)
    {
        Course course = new Course();
        course.setId(temp.getId());
        course.setManager(temp.getManagerID().getId());
        course.setName(temp.getName());
        course.setNbrSkills(temp.getNbrSkills());
        course.setUsers(temp.getUsers());
        return course;
    }

    private List<Course> infiniteListProcess(List<Course> courses)
    {
        for(int i=0; i<courses.size(); i++)
        {
            Course temp = courses.get(i);
            Course course = infiniteLoopFix(temp);
            courses.set(i, course);
        }
        return courses;
    }
}
