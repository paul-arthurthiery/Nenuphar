package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Team;
import com.nenuphar.nenufar.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team getTeam(Long id)
    {
        Team temp = teamRepository.findOne(id);
        return infiniteLoopFix(temp);
    }

    public Team getPostedTeam(Team team){ return team;}

    public Team createTeam(int size, String name)
    {
        Team team = new Team(size, name);
        teamRepository.save(team);
        return team;
    }

    private Team infiniteLoopFix(Team temp)
    {
        Team team = new Team();
        team.setId(temp.getId());
        team.setName(temp.getName());
        team.setSize(temp.getSize());
        team.setUsers(temp.getUsers());
        team.setWorkgroup(temp.getWorkgroupID().getId());
        return team;
    }

    private List<Team> infiniteListProcess(List<Team> teams)
    {
        for(int i=0; i<teams.size(); i++)
        {
            Team temp = teams.get(i);
            Team team = infiniteLoopFix(temp);
            teams.set(i,team);
        }
        return teams;
    }
}
