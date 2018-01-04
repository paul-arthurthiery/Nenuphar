package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Models.SubSkill;
import com.nenuphar.nenufar.Services.SubSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubSkillController {

    @Autowired
    private SubSkillService subSkillService;

    @RequestMapping(value = "/subskill/{id}", method = RequestMethod.GET)
    private ResponseEntity getSubSkillById(@PathVariable("id") long id)
    {
        SubSkill subskill = subSkillService.getSubSkill(id);
        if(subskill==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(subskill, HttpStatus.OK);
    }

    @RequestMapping(value = "/subskill/", method = RequestMethod.POST)
    public ResponseEntity createSubSkill(@RequestBody String name, int grade)
    {
        SubSkill subskill = subSkillService.createSubSkill(name, grade);
        if(subskill==null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(subskill, HttpStatus.OK);
    }
}
