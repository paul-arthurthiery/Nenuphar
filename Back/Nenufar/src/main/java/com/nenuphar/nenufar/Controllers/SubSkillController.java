package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Services.SubSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubSkillController {

    @Autowired
    private SubSkillService subSkillService;
}
