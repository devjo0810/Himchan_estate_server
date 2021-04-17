package site.himchan.estate.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.himchan.estate.service.BoardService;
import site.himchan.estate.vo.BoardVO;
import site.himchan.estate.vo.PageVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String board(Model model, PageVo pageVo) {

        int page = 1;
        int totalCnt = 0;

        if(pageVo.getPageNo() == 0){
            pageVo.setPageNo(page);
        }

        List<BoardVO> bList = boardService.boardList(pageVo);

        model.addAttribute("bList", bList);
        model.addAttribute("page", page);

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

    @RequestMapping("/writeForm")
    public String boardWriteForm(){
        return "board/board_write";
    }

    @PostMapping("/write")
    @ResponseBody
    public String boardWrite(BoardVO boardvo){

        Map<String, String> msg = new HashMap<String, String>();

        int result = boardService.boardWrite(boardvo);
        msg.put("check", (result > 0)? "작성 완료":"작성 실패");

        System.out.println("callbackMsg" + msg);
        return new Gson().toJson(msg);

    }

    @RequestMapping("/view")
    public String boardView(@RequestParam("boardSq")long boardSq, Model m){

        BoardVO board = boardService.boardView(boardSq);

        m.addAttribute("board", board);

        return "board/board_view";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String boardDelete(@RequestParam("sq") long boardSq){

        Map<String, String> msg = new HashMap<String, String>();

//        Map<String, Long> map = new HashMap<String, Long>();
//        map.put("boardSq", boardSq);

        System.out.println("boardSq : " + boardSq);
        int result = boardService.boardDelete(boardSq);
        msg.put("check", (result > 0)? "삭제 완료":"삭제 실패");

        System.out.println("callbackMsg" + msg);
        return new Gson().toJson(msg);
    }

}
