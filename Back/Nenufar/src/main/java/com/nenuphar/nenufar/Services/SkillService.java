package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Skill;
import com.nenuphar.nenufar.Repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill getSkill(Long id){ return skillRepository.findOne(id);}

    public Skill getPostedSkill(Skill skill){ return skill;}
}
