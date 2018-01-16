package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.DTO.GetIDDTO;
import com.nenuphar.nenufar.Models.Skill;
import com.nenuphar.nenufar.Services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "/get_skill", method = RequestMethod.POST)
    private ResponseEntity getSkillById(@RequestBody GetIDDTO dto)
    {
        Long id = dto.getID();
        Skill skill = skillService.getSkill(id);
        if(skill==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @RequestMapping(value = "/get_skills_from_course", method = RequestMethod.POST)
    private ResponseEntity getSkillsFromCourseID(@RequestBody GetIDDTO dto)
    {
        Long id = dto.getID();
        List<Skill> skill = skillService.getSkillsFromCourseID(id);
        if(skill==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @RequestMapping(value = "/skill", method = RequestMethod.POST)
    public ResponseEntity createSkill(@RequestBody String name, int nbrSkills, Date recommendedWeek)
    {
        Skill skill = skillService.createSkill(name, nbrSkills, recommendedWeek);
        if(skill==null) {return new ResponseEntity(HttpStatus.BAD_REQUEST);}
        return new ResponseEntity(skill, HttpStatus.OK);
    }
}
