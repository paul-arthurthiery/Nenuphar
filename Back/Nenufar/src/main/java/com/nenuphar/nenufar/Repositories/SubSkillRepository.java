package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.SubSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubSkillRepository extends CrudRepository<SubSkill, Long> {
    @Query(value="SELECT * FROM sub_skill WHERE skill_id = ?1", nativeQuery = true)
    List<SubSkill> getSubSkillsFromSkillID(Long skill_id);

    @Query(value="SELECT * FROM sub_skill WHERE skill_id = (SELECT id FROM skill WHERE course_id = (SELECT id FROM course WHERE name = ?1)) AND name = ?2", nativeQuery = true)
    SubSkill getSubSkillFromNameAndCourse(String course_name, String subskill_name);

}
