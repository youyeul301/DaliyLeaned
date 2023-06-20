package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    public List<MemberInfoResponseDTO> findAllMembers(){
        return memberService.findAllMembers();
    }

    public MemberInfoResponseDTO findMemberById(Map<String , String> parameter){
        Long id = Long.parseLong(parameter.get("id"));

        return memberService.findMemberById(id);

    }
}
