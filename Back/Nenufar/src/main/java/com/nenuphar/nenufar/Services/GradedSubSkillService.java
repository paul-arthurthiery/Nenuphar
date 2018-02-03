package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.GradedSubSkill;
import com.nenuphar.nenufar.Models.SubSkill;
import com.nenuphar.nenufar.Models.User;
import com.nenuphar.nenufar.Repositories.GradedSubSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class GradedSubSkillService
{
    @Autowired
    private GradedSubSkillRepository gradedsubSkillRepository;

    public GradedSubSkill getGradedSubSkill(Long id){ return gradedsubSkillRepository.findOne(id);}

    public GradedSubSkill getPostedGradedSubSkill(GradedSubSkill gradedsubSkill){ return gradedsubSkill;}

    public GradedSubSkill createGradedSubSkill(int level, SubSkill subSkillID, User userID, Date date)
    {
        GradedSubSkill gradedsubskill = new GradedSubSkill(level, subSkillID, userID, date);
        gradedsubSkillRepository.save(gradedsubskill);
        return gradedsubskill;
    }

    public List<Object> getLastWeekGradedSubSkillsFromUUID(String uuid)
    {
        try {
            List<Object> gradedSubSkills = gradedsubSkillRepository.getLastWeekGradedSubSkillsFromUUID(uuid);
            return gradedSubSkills;
        }
        catch(Exception e) {
            return null;
        }
    }

    public List<Object> getLastGradedSubSkillsFromUUID(String uuid)
    {
        try {
            List<Object> gradedSubSkills = gradedsubSkillRepository.getLastGradedSubSkillsFromUUID(uuid);
            return gradedSubSkills;
        }
        catch(Exception e) {
            return null;
        }
    }

    public List<Object> getLastGradedSubSkillsFromCourse(String course_name)
    {
        try {
            List<Object> gradedSubSkills = gradedsubSkillRepository.getLastGradedSubSkillsFromCourse(course_name);
            return gradedSubSkills;
        }
        catch(Exception e) {
            return null;
        }
    }
}
