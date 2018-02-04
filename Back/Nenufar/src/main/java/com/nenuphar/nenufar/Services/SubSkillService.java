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

    public SubSkill getSubSkill(Long id)
    {
        SubSkill subskill = subSkillRepository.findOne(id);
        return infiniteLoopFix(subskill);
    }

    public SubSkill getPostedSubSkill(SubSkill subSkill){ return subSkill;}

    public SubSkill getSubSkillFromNameAndCourse(String course_name, String subskill_name)
    {
        try
        {
            SubSkill subskill = subSkillRepository.getSubSkillFromNameAndCourse(course_name, subskill_name);
            return infiniteLoopFix(subskill);
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
            return infiniteListProcess(subskills);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    private SubSkill infiniteLoopFix(SubSkill temp)
    {
        SubSkill subskill = new SubSkill();
        subskill.setId(temp.getId());
        subskill.setGrade(temp.getGrade());
        subskill.setName(temp.getName());
        subskill.setSkill(temp.getSkillID().getId());
        return subskill;
    }

    private List<SubSkill> infiniteListProcess(List<SubSkill> subskills)
    {
        for(int i=0; i<subskills.size(); i++)
        {
            SubSkill temp = subskills.get(i);
            SubSkill subskill = infiniteLoopFix(temp);
            subskills.set(i,subskill);
        }
        return subskills;
    }
}
