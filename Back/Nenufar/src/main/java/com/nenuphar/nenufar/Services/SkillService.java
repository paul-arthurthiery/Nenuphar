package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Skill;
import com.nenuphar.nenufar.Repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;


@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill getSkill(Long id){ return skillRepository.findOne(id);}

    public Skill getPostedSkill(Skill skill){ return skill;}

    public Skill createSkill(String name, int nbrSkills, Date recommendedWeek)
    {
        Skill skill = new Skill(name, nbrSkills, recommendedWeek);
        skillRepository.save(skill);
        return skill;
    }

    public List<Skill> getSkillsFromCourseID(int course_id)
    {
        try
        {
            List<Skill> skills = skillRepository.getSkillsFromCourseID(course_id);
            return skills;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
