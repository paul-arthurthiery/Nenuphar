package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Workgroup;
import com.nenuphar.nenufar.Repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Workgroup getGroup(Long id){ return groupRepository.findOne(id);}

    public Workgroup getPostedGroup(Workgroup workgroup){ return workgroup;}
}
