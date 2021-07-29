package site.himchan.estate.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import site.himchan.estate.service.CrawlerService;
import site.himchan.estate.vo.NewsVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    private final CrawlerService crawlerService;

    @RequestMapping("/")
    public String home(HttpServletRequest request) throws Exception{
        List<NewsVO> newsList =  crawlerService.getNews();
        request.setAttribute("newsList", newsList);
        return "index";
    }

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
