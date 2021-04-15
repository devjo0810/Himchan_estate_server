package site.himchan.estate.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String select() {
        List<MemberVO> list = memberService.findAll();

        return new Gson().toJson(list);
    }
}
