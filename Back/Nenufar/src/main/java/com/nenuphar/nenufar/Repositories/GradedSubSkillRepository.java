package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.GradedSubSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradedSubSkillRepository extends CrudRepository<GradedSubSkill, Long>
{
    @Query(value="SELECT * FROM graded_sub_skill WHERE user_id = (SELECT id FROM User WHERE uuid = ?1) AND date > (SELECT CURDATE()-7)", nativeQuery = true)
    List<GradedSubSkill> getLastWeekGradedSubSkillsFromUUID(@Param("uuid") String uuid);

    // returns the LAST 3 graded subskills for the user
    @Query(value="SELECT * FROM graded_sub_skill WHERE user_id = (SELECT id FROM User WHERE uuid = ?1) ORDER BY date DESC LIMIT 3", nativeQuery = true)
    List<GradedSubSkill> getLastGradedSubSkillsFromUUID(@Param("uuid") String uuid);

    @Query(value="SELECT * FROM graded_sub_skill WHERE subskill_id =(SELECT id FROM subskill WHERE course_id = (SELECT id FROM course WHERE name = ?1)) ", nativeQuery = true)
    List<GradedSubSkill> getLastGradedSubSkillsFromCourse(@Param("name") String course_name);

    @Query(value="SELECT * FROM graded_sub_skill WHERE subskill_id = ?1 AND user_id = (SELECT id FROM user WHERE uuid = ?2)", nativeQuery = true)
    GradedSubSkill getGradedSubSkillFromSubskillUuid(@Param("subskill_id") long subskill_id, @Param("uuid") String uuid);
}
