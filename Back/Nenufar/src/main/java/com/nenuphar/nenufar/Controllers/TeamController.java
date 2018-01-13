package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Models.Team;
import com.nenuphar.nenufar.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    private ResponseEntity getTeamById(@PathVariable("id") long id)
    {
        Team team = teamService.getTeam(id);
        if(team==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(value = "/team", method = RequestMethod.POST)
    public ResponseEntity createTeam(@RequestBody int size, String name)
    {
        Team team = teamService.createTeam(size, name);
        if(team==null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(team, HttpStatus.OK);
    }


}
