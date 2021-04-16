package site.himchan.estate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home() { return "index"; }

    @RequestMapping("/come")
    public String come() {
        return "come/come_main";
    }

    @RequestMapping("/login")
    public String login() { return "sign/login"; }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
