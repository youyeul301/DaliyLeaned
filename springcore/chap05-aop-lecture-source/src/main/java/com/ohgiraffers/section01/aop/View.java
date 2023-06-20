package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
@Component
public class View {
    private final MemberController memberController;

    @Autowired
    public View(MemberController memberController){
        this.memberController=memberController;
    }

    public void findAllMembers(){
        List<MemberInfoResponseDTO> member=memberController.findAllMembers();
        printMembers(member);
    }



    public void findMemberById(){

        Scanner sc= new Scanner(System.in);
        System.out.println("조회하실 사용자 아이디를 입력해 주세요 : ");
        String id=sc.nextLine();

        Map<String ,String> parameter=new HashMap<>();
        parameter.put("id",id);

        MemberInfoResponseDTO member= memberController.findMemberById(parameter);
        printMember(member);
    }

    private void printMember(MemberInfoResponseDTO memberInfoResponseDTO){
        System.out.println(memberInfoResponseDTO);
    }

    private void printMembers(List<MemberInfoResponseDTO> dtos) {

        dtos.forEach(this::printMember);
    }
}
