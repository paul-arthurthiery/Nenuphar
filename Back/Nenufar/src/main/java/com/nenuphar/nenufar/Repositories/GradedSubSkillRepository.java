package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.GradedSubSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GradedSubSkillRepository extends CrudRepository<GradedSubSkill, Long>
{
    @Query(value="SELECT * FROM graded_sub_skill WHERE user_id = (SELECT id FROM User WHERE uuid = ?1) AND date > (SELECT CURDATE()-7)", nativeQuery = true)
    List<GradedSubSkill> getLastWeekGradedSubSkillFromUUID(@Param("uuid") String uuid);
}
