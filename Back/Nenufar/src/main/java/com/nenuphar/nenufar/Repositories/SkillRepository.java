package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.Skill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, Long>{
    @Query(value="SELECT * FROM skill WHERE course_id = ?1", nativeQuery = true)
    List<Skill> getSkillsFromCourseID(int course_id);
}
