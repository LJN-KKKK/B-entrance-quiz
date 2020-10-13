package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.domain.TeamMember;
import com.thoughtworks.capability.gtb.entrancequiz.service.TeamMemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TeamMemberResource.class)
public class TeamMemberResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamMemberService TeamMemberService;

    @Test
    void shouldGetTeamMembersSuccessfully() throws Exception {

        List<TeamMember> expectedTeamMembers = new ArrayList<>();
        expectedTeamMembers.add(new TeamMember("111"));

        when(TeamMemberService.getAll()).thenReturn(expectedTeamMembers);

        mockMvc.perform(get("/")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("111"));
    }
    
}
