package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;
}
