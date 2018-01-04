package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Workgroup;
import com.nenuphar.nenufar.Repositories.WorkgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkgroupService
{

    @Autowired
    private WorkgroupRepository workgroupRepository;

    public Workgroup getWorkgroup(Long id){ return workgroupRepository.findOne(id);}

    public Workgroup getPostedWorkgroup(Workgroup workgroup){ return workgroup;}

    public Workgroup createWorkgroup(String name, int size)
    {
        Workgroup workgroup = new Workgroup(name, size);
        workgroupRepository.save(workgroup);
        return workgroup;
    }
}
