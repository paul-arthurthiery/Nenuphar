package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Models.Workgroup;
import com.nenuphar.nenufar.Services.WorkgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkgroupController
{
    @Autowired
    private WorkgroupService workgroupService;

    @RequestMapping(value = "/workgroup/{id}", method = RequestMethod.GET)
    private ResponseEntity getWorkgroupById(@PathVariable("id") long id)
    {
        Workgroup workgroup = workgroupService.getWorkgroup(id);
        if(workgroup==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(workgroup, HttpStatus.OK);
    }

    @RequestMapping(value = "/workgroup/", method = RequestMethod.POST)
    public ResponseEntity createWorkgroup(@RequestBody String name, int size)
    {
        Workgroup workgroup = workgroupService.createWorkgroup(name, size);
        if(workgroup==null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(workgroup, HttpStatus.OK);
    }
}
