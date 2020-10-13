package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.controller.dto.TeamMemberRequest;
import com.thoughtworks.capability.gtb.entrancequiz.domain.TeamMember;
import com.thoughtworks.capability.gtb.entrancequiz.service.TeamMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/")
public class TeamMemberResource {
    private final TeamMemberService teamService;

    public TeamMemberResource(TeamMemberService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<Void> createTeamMember(@RequestBody TeamMemberRequest request) {
        teamService.save(new TeamMember(request));

        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TeamMember>> getTeamMember(){
        List<TeamMember> teamMembers = teamService.getAll();

        return ResponseEntity.ok(teamMembers);
    }
}
