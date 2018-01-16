package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
   // List<Course> getCoursesFromUUID(String uuid);
}
