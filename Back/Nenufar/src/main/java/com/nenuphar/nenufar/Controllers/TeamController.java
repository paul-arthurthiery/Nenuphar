package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;


}
