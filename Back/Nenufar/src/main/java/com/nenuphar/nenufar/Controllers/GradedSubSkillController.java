package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.DTO.GetIDDTO;
import com.nenuphar.nenufar.DTO.GettokenDTO;
import com.nenuphar.nenufar.Models.GradedSubSkill;
import com.nenuphar.nenufar.Models.SubSkill;
import com.nenuphar.nenufar.Models.User;
import com.nenuphar.nenufar.Services.GradedSubSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradedSubSkillController
{

    @Autowired
    private GradedSubSkillService gradedsubSkillService;

    @RequestMapping(value = "/get_gradedsubskill", method = RequestMethod.POST)
    private ResponseEntity getGradedSubSkillById(@RequestBody GetIDDTO dto)
    {
        Long id = dto.getID();
        GradedSubSkill gradedsubskill = gradedsubSkillService.getGradedSubSkill(id);
        if(gradedsubskill==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(gradedsubskill, HttpStatus.OK);
    }

    @RequestMapping(value = "/get_lastweek_gradedsubskills", method = RequestMethod.POST)
    private ResponseEntity getLastWeekGradedSubSkillsFromUUID(@RequestBody GettokenDTO dto)
    {
        String uuid = dto.getToken();
        List<GradedSubSkill> gradedsubskills = gradedsubSkillService.getLastWeekGradedSubSkillsFromUUID(uuid);
        if(gradedsubskills==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(gradedsubskills, HttpStatus.OK);
    }

    @RequestMapping(value = "/gradedsubskill", method = RequestMethod.POST)
    public ResponseEntity createGradedSubSkill(@RequestBody int level, SubSkill subSkillID, User user)
    {
        GradedSubSkill gradedsubskill = gradedsubSkillService.createGradedSubSkill(level, subSkillID, user);
        if(gradedsubskill==null) {return new ResponseEntity(HttpStatus.BAD_REQUEST);}
        return new ResponseEntity(gradedsubskill, HttpStatus.OK);
    }
}
