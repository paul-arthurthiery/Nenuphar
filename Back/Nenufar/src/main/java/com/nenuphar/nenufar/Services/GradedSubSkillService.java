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

    public List<GradedSubSkill> getLastWeekGradedSubSkillsFromUUID(String uuid)
    {
        try {
            List<GradedSubSkill> temp = gradedsubSkillRepository.getLastWeekGradedSubSkillsFromUUID(uuid);
            return infiniteListProcess(temp);
        }
        catch(Exception e) {
            return null;
        }
    }

    public List<GradedSubSkill> getLastGradedSubSkillsFromUUID(String uuid)
    {
        try {
            List<GradedSubSkill> temp = gradedsubSkillRepository.getLastGradedSubSkillsFromUUID(uuid);
            return infiniteListProcess(temp);
        }
        catch(Exception e) {
            return null;
        }
    }

    public List<GradedSubSkill> getLastGradedSubSkillsFromCourse(String course_name)
    {
        try {
            List<GradedSubSkill> temp = gradedsubSkillRepository.getLastGradedSubSkillsFromCourse(course_name);
            return infiniteListProcess(temp);
        }
        catch(Exception e) {
            return null;
        }
    }

    public GradedSubSkill getGradedSubSkillFromSubskillUuid(long subskill_id, String uuid)
    {
        GradedSubSkill temp = gradedsubSkillRepository.getGradedSubSkillFromSubskillUuid(subskill_id,uuid);
        return infiniteLoopFix(temp);
    }

    private GradedSubSkill infiniteLoopFix(GradedSubSkill temp)
    {
        GradedSubSkill gradedsubskill = new GradedSubSkill();
        gradedsubskill.setId(temp.getId());
        gradedsubskill.setDate(temp.getDate());
        gradedsubskill.setLevel(temp.getLevel());
        gradedsubskill.setSubskill(temp.getSubSkillID().getId());
        gradedsubskill.setUser(temp.getUserID().getId());
        return gradedsubskill;
    }

    private List<GradedSubSkill> infiniteListProcess(List<GradedSubSkill> gradedsubskills)
    {
        for(int i=0; i<gradedsubskills.size(); i++)
        {
            GradedSubSkill temp = gradedsubskills.get(i);
            GradedSubSkill gradedsubskill = infiniteLoopFix(temp);
            gradedsubskills.set(i,gradedsubskill);
        }
        return gradedsubskills;
    }
}
