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

    public Skill getSkill(Long id)
    {
        Skill temp = skillRepository.findOne(id);
        return infiniteLoopFix(temp);
    }

    public Skill getPostedSkill(Skill skill){ return skill;}

    public Skill createSkill(String name, int nbrSkills, Date recommendedWeek)
    {
        Skill skill = new Skill(name, nbrSkills, recommendedWeek);
        skillRepository.save(skill);
        return skill;
    }

    public List<Skill> getSkillsFromCourseID(Long course_id)
    {
        try
        {
            List<Skill> skills = skillRepository.getSkillsFromCourseID(course_id);
            System.out.println("#####################"+skills.size());
            for(int i=0; i<skills.size(); i++)
            {
                Skill temp = skills.get(i);
                Skill skill = infiniteLoopFix(temp);
                skills.set(i,skill);
            }
            return skills;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    private Skill infiniteLoopFix(Skill temp)
    {
        Skill skill = new Skill();
        skill.setId(temp.getId());
        skill.setName(temp.getName());
        skill.setNbrSubSkills(temp.getNbrSubSkills());
        skill.setRecommendedWeek(temp.getRecommendedWeek());
        skill.setCourse(temp.getCourseID().getId());
        return skill;
    }
}
