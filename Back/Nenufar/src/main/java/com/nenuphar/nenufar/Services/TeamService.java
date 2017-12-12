package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Team;
import com.nenuphar.nenufar.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team getTeam(Long id){ return teamRepository.findOne(id); }

    public Team getPostedTeam(Team team){ return team;}
}
