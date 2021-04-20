package site.himchan.estate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.himchan.estate.service.MemberService;
import site.himchan.estate.vo.LoginVO;
import site.himchan.estate.vo.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String login(@RequestParam String id,
                        @RequestParam String password,
                        HttpSession session) {

        String returnUrl;
        MemberVO member = new MemberVO();
        member.setMemberId(id);
        member.setMemberPwd(password);
        try {
            LoginVO login = memberService.login(member);

            if(login != null) {
                session.setAttribute("login", login);
                session.setAttribute("msg", login.getMemberId() + "님 환영합니다!");
                returnUrl = "redirect:/";
            } else {
                session.setAttribute("msg", "회원 정보가 일치하지 않습니다.");
                returnUrl = "redirect:/login";
            }
        } catch(Exception e) {
            e.printStackTrace();
            returnUrl = "error/exception";
        }

        return returnUrl;
    }
}
