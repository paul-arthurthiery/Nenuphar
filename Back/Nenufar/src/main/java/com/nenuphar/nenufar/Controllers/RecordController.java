package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Models.Record;
import com.nenuphar.nenufar.Services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/record/{id}", method = RequestMethod.GET)
    private ResponseEntity getRecordById(@PathVariable("id") long id)
    {
        Record record = recordService.getRecord(id);
        if(record==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @RequestMapping(value = "/record", method = RequestMethod.POST)
    public ResponseEntity createRecord(@RequestBody int nbrCourses, Date deadlines)
    {
        Record record = recordService.createRecord(nbrCourses, deadlines);
        if(record==null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(record, HttpStatus.OK);
    }
}
