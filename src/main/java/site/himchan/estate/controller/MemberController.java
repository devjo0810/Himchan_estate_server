package site.himchan.estate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.himchan.estate.service.MemberService;
import site.himchan.estate.vo.LoginVO;
import site.himchan.estate.vo.MemberVO;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/select")
    @ResponseBody
    public ResponseEntity select() {
        return new ResponseEntity(memberService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity save(@RequestParam String id,
                               @RequestParam String password,
                               @RequestParam(required = false) String grant) throws Exception {
        MemberVO member = new MemberVO();
        member.setMemberId(id);
        member.setMemberPwd(password);
        member.setMemberGrant(grant);
        return new ResponseEntity(memberService.save(member), HttpStatus.OK);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestParam String id,
                               @RequestParam String password) throws Exception {
        MemberVO member = new MemberVO();
        member.setMemberId(id);
        member.setMemberPwd(password);
        return new ResponseEntity(memberService.login(member), HttpStatus.OK);
    }
}
