package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.SubSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubSkillRepository extends CrudRepository<SubSkill, Long> {
    @Query(value="SELECT * FROM sub_skill WHERE skill_id = ?1", nativeQuery = true)
    List<SubSkill> getSubSkillsFromSkillID(int skill_id);
}
