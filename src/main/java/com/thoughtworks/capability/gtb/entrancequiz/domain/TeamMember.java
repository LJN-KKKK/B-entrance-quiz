package com.thoughtworks.capability.gtb.entrancequiz.domain;

import com.thoughtworks.capability.gtb.entrancequiz.controller.dto.TeamMemberRequest;

public class TeamMember {
    private final String name;

    public TeamMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TeamMember(TeamMemberRequest request) {
        this.name = request.getName();
    }
}