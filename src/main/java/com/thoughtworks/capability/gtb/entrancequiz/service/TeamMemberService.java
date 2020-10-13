package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.TeamMember;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamMemberService {
    private List<TeamMember> teamMembers = new ArrayList<>();

    public void save(TeamMember teamMember){
        teamMembers.add(teamMember);
    }

    public List<TeamMember> getAll() {
        return teamMembers;
    }

}
