package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.DTO.GetIDDTO;
import com.nenuphar.nenufar.DTO.GettokenDTO;
import com.nenuphar.nenufar.DTO.GradedSubSkillDTO;
import com.nenuphar.nenufar.Models.GradedSubSkill;
import com.nenuphar.nenufar.Models.SubSkill;
import com.nenuphar.nenufar.Models.User;
import com.nenuphar.nenufar.Services.GradedSubSkillService;
import com.nenuphar.nenufar.Services.SubSkillService;
import com.nenuphar.nenufar.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class GradedSubSkillController
{

    @Autowired
    private GradedSubSkillService gradedsubSkillService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubSkillService subSkillService;

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

    @RequestMapping(value = "/get_last3_gradedsubskills", method = RequestMethod.POST)
    private ResponseEntity getLastGradedSubSkillsFromUUID(@RequestBody GettokenDTO dto)
    {
        String uuid = dto.getToken();
        List<GradedSubSkill> gradedsubskills = gradedsubSkillService.getLastGradedSubSkillsFromUUID(uuid);
        if(gradedsubskills==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(gradedsubskills, HttpStatus.OK);
    }

    @RequestMapping(value = "/gradedsubskill", method = RequestMethod.POST)
    public ResponseEntity createGradedSubSkill(@RequestBody GradedSubSkillDTO dto)
    {
        String name = dto.getName();
        String last_name = dto.getLast_name();
        User user = userService.getFromCompleteName(name,last_name);
        String subskill_name = dto.getSubSkillName();
        String course_name = dto.getCourseName();
        SubSkill subskill = subSkillService.getSubSkillFromNameAndCourse(course_name, subskill_name);
        int level = dto.getLevel();
        String response = user.getName()+" "+user.getLastName()+" // "+dto.getCourseName()+"/"+dto.getSubSkillName()+"/"+level;
        return new ResponseEntity<>(response, HttpStatus.OK);
        /*
        Calendar calendar = Calendar.getInstance();
        java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());
        GradedSubSkill gradedsubskill = gradedsubSkillService.createGradedSubSkill(level, subskill, user, currentDate);
        if(gradedsubskill==null) {return new ResponseEntity(HttpStatus.BAD_REQUEST);}
        return new ResponseEntity<>(gradedsubskill.getLevel(), HttpStatus.OK);
        */
    }
}
