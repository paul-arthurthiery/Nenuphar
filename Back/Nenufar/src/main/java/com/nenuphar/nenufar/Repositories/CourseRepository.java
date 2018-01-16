package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    @Query(value="SELECT * FROM Course WHERE id = (SELECT course_id FROM Skill WHERE id = (SELECT skill_id FROM sub_skill WHERE subskill_id = (SELECT subskill_id FROM graded_sub_skill WHERE user_id = (SELECT id FROM User WHERE uuid = ?1))))", nativeQuery = true)
    List<Course> getCoursesFromUUID(String uuid);
}
