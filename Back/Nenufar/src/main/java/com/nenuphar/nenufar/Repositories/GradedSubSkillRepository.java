package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.GradedSubSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradedSubSkillRepository extends CrudRepository<GradedSubSkill, Long>
{
    @Query(value="SELECT id,date,level,subskill_id FROM graded_sub_skill WHERE user_id = (SELECT id FROM User WHERE uuid = ?1) AND date > (SELECT CURDATE()-7)", nativeQuery = true)
    List<Object> getLastWeekGradedSubSkillsFromUUID(@Param("uuid") String uuid);

    // returns the LAST 3 graded subskills for the user
    @Query(value="SELECT id,date,level,subskill_id FROM graded_sub_skill WHERE user_id = (SELECT id FROM User WHERE uuid = ?1) ORDER BY date DESC LIMIT 3", nativeQuery = true)
    List<Object> getLastGradedSubSkillsFromUUID(@Param("uuid") String uuid);

    @Query(value="SELECT id,date,level,subskill_id FROM graded_sub_skill WHERE subskill_id =(SELECT id FROM subskill WHERE course_id = (SELECT id FROM course WHERE name = ?1)) ", nativeQuery = true)
    List<Object> getLastGradedSubSkillsFromCourse(@Param("name") String course_name);
}
