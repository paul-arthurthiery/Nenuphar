package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Models.Skill;
import com.nenuphar.nenufar.Services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "/skill/{id}", method = RequestMethod.GET)
    private ResponseEntity getSkillById(@PathVariable("id") long id)
    {
        Skill skill = skillService.getSkill(id);
        if(skill==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @RequestMapping(value = "/skill", method = RequestMethod.POST)
    public ResponseEntity createSkill(@RequestBody String name, int nbrSkills, Date recommendedWeek)
    {
        Skill skill = skillService.createSkill(name, nbrSkills, recommendedWeek);
        if(skill==null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(skill, HttpStatus.OK);
    }
}
