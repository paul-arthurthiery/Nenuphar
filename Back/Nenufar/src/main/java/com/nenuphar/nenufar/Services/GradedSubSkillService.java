package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.GradedSubSkill;
import com.nenuphar.nenufar.Repositories.GradedSubSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradedSubSkillService
{
    @Autowired
    private GradedSubSkillRepository gradedsubSkillRepository;

    public GradedSubSkill getGradedSubSkill(Long id){ return gradedsubSkillRepository.findOne(id);}

    public GradedSubSkill getPostedGradedSubSkill(GradedSubSkill gradedsubSkill){ return gradedsubSkill;}

    public GradedSubSkill createGradedSubSkill(int level, int subskill_id, int user_id)
    {
        GradedSubSkill gradedsubskill = new GradedSubSkill(level, subskill_id, user_id);
        gradedsubSkillRepository.save(gradedsubskill);
        return gradedsubskill;
    }
}
