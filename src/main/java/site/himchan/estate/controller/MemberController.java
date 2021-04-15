package site.himchan.estate.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import site.himchan.estate.service.MemberService;
import site.himchan.estate.vo.MemberVO;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @RequestMapping("/select")
    @ResponseBody
    public ResponseEntity select() {
        List<MemberVO> list = memberService.findAll();

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping("/save")
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

    @RequestMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestParam String id,
                               @RequestParam String password) throws Exception {
        MemberVO member = new MemberVO();
        member.setMemberId(id);
        member.setMemberPwd(password);
        return new ResponseEntity(memberService.login(member), HttpStatus.OK);
    }
}
