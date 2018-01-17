package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.SubSkill;
import com.nenuphar.nenufar.Repositories.SubSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubSkillService {

    @Autowired
    private SubSkillRepository subSkillRepository;

    public SubSkill getSubSkill(Long id){ return subSkillRepository.findOne(id);}

    public SubSkill getPostedSubSkill(SubSkill subSkill){ return subSkill;}

    public SubSkill getSubSkillFromNameAndCourse(String subskill_name, String course_name)
    {
        try
        {
            SubSkill subskill = getSubSkillFromNameAndCourse(course_name, subskill_name);
            return subskill;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public SubSkill createSubSkill(String name, int grade)
    {
        SubSkill subskill = new SubSkill(name, grade);
        subSkillRepository.save(subskill);
        return subskill;
    }

    public List<SubSkill> getSubSkillsFromSkillID(Long skill_id)
    {
        try
        {
            List<SubSkill> subskills = subSkillRepository.getSubSkillsFromSkillID(skill_id);
            return subskills;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
