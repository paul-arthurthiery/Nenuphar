package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


}
