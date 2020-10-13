package com.thoughtworks.capability.gtb.entrancequiz.controller.dto;

public class TeamMemberRequest {
    private String name;

    public TeamMemberRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
