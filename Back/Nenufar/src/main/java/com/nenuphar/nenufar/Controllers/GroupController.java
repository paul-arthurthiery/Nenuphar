package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;
}
