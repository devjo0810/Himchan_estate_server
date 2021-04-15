package site.himchan.estate.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.himchan.estate.service.BoardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    public String board() {
        return "board/board_main";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String list() {
        List<Map<String, Object>> map = boardService.findAll();
        return new Gson().toJson(map);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test1", "test1");
        map.put("test2", "test2");
        map.put("test3", "test3");

        return new Gson().toJson(map);
    }
}
