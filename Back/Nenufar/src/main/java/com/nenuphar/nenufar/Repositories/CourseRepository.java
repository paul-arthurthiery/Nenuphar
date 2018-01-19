package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    @Query(value="SELECT id,name,nbr_skills FROM Course WHERE id = (SELECT course_id FROM course_user WHERE user_id = (SELECT id FROM user WHERE id = (SELECT teacher_id from workgroup WHERE id = (SELECT workgroup_id FROM workgroup_user WHERE user_id = (SELECT id FROM USER WHERE uuid = ?1)))))", nativeQuery = true)
    List<Object> getCoursesFromUUID(String uuid);
}
