package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Models.GradedSubSkill;
import com.nenuphar.nenufar.Models.SubSkill;
import com.nenuphar.nenufar.Models.User;
import com.nenuphar.nenufar.Services.GradedSubSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GradedSubSkillController
{

    @Autowired
    private GradedSubSkillService gradedsubSkillService;

    @RequestMapping(value = "/gradedsubskill/{id}", method = RequestMethod.GET)
    private ResponseEntity getGradedSubSkillById(@PathVariable("id") long id)
    {
        GradedSubSkill gradedsubskill = gradedsubSkillService.getGradedSubSkill(id);
        if(gradedsubskill==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(gradedsubskill, HttpStatus.OK);
    }

    @RequestMapping(value = "/gradedsubskill", method = RequestMethod.POST)
    public ResponseEntity createGradedSubSkill(@RequestBody int level, SubSkill subSkillID, User user)
    {
        GradedSubSkill gradedsubskill = gradedsubSkillService.createGradedSubSkill(level, subSkillID, user);
        if(gradedsubskill==null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(gradedsubskill, HttpStatus.OK);
    }
}
