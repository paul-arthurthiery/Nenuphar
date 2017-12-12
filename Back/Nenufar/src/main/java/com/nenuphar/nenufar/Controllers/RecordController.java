package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;
}
