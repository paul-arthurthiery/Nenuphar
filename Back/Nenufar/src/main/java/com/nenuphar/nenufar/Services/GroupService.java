package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Group;
import com.nenuphar.nenufar.Repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group getGroup(Long id){ return groupRepository.findOne(id);}

    public Group getPostedGroup(Group group){ return group;}
}
