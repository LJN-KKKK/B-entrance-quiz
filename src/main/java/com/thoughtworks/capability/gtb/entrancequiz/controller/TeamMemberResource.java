package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.controller.dto.TeamMemberRequest;
import com.thoughtworks.capability.gtb.entrancequiz.domain.TeamMember;
import com.thoughtworks.capability.gtb.entrancequiz.service.TeamMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
//TODO GTB：缺少了自动分组的api，缺少了查看分组的api
//TODO GTB: 以REST风格的API设计实践来说，path最好指明正在操作的资源，比如说这里"/team-member"比"/"合适
@RequestMapping("/")
//TODO GTB：一般项目上（使用了常规三层架构），在controller这一层class的命名，以xxxController命名。如果是用了其他必须要按照特定规则命名框架，那就按照项目要求来。
public class TeamMemberResource {
    private final TeamMemberService teamService;

    public TeamMemberResource(TeamMemberService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    //TODO GTB: BUG，无法创建新学员
    //TODO GTB: 如果不是自定义返回请求，可以省略ResponseEntity
    public ResponseEntity<Void> createTeamMember(@RequestBody TeamMemberRequest request) {
        //TODO GTB：request在做entity映射的时候，应该是Request to Entity，而非Entity调用Request进行转换
        teamService.save(new TeamMember(request));
        //TODO GTB：看下@ResponseStatus的用法
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TeamMember>> getTeamMember(){
        List<TeamMember> teamMembers = teamService.getAll();

        return ResponseEntity.ok(teamMembers);
    }
}
