package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Workgroup;
import com.nenuphar.nenufar.Repositories.WorkgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkgroupService
{

    @Autowired
    private WorkgroupRepository workgroupRepository;

    public Workgroup getWorkgroup(Long id)
    {
        Workgroup temp = workgroupRepository.findOne(id);
        return infiniteLoopFix(temp);
    }

    public Workgroup getPostedWorkgroup(Workgroup workgroup){ return workgroup;}

    public Workgroup createWorkgroup(String name, int size)
    {
        Workgroup workgroup = new Workgroup(name, size);
        workgroupRepository.save(workgroup);
        return workgroup;
    }

    private Workgroup infiniteLoopFix(Workgroup temp)
    {
        Workgroup workgroup = new Workgroup();
        workgroup.setId(temp.getId());
        workgroup.setName(temp.getName());
        workgroup.setSize(temp.getSize());
        workgroup.setUsers(temp.getUsers());
        workgroup.setTeacher(temp.getTeacherID().getId());
        return workgroup;
    }

    private List<Workgroup> infiniteListProcess(List<Workgroup> workgroups)
    {
        for(int i=0; i<workgroups.size(); i++)
        {
            Workgroup temp = workgroups.get(i);
            Workgroup workgroup = infiniteLoopFix(temp);
            workgroups.set(i, workgroup);
        }
        return workgroups;
    }
}
