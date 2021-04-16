package site.himchan.estate.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.himchan.estate.service.BoardService;
import site.himchan.estate.vo.BoardVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String board(Model model) {

        List<BoardVO> bList = boardService.boardList();
        model.addAttribute("bList", bList);

        return "board/board_main";
    }

    /*@RequestMapping("/list")
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
    }*/

//    @RequestMapping("/writeForm")
//    public String boardWriteForm(){
//        return "board/boardWrite";
//    }

    @PostMapping("/write")
    @ResponseBody
    public String boardWrite(BoardVO boardvo){

        Map<String, String> msg = new HashMap<String, String>();

        int result = boardService.boardWrite(boardvo);
        msg.put("check", (result > 0)? "성공":"실패");

        return new Gson().toJson(msg);

    }

}
