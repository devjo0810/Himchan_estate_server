package site.himchan.estate.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.himchan.estate.service.BoardService;
import site.himchan.estate.vo.BoardVO;
import site.himchan.estate.vo.PageVo;
import site.himchan.estate.vo.Pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String board(Model model,
                        @RequestParam(value="page", required=false) Integer page,
                        @RequestParam(value="sVal", required = false) String sVal) {

        int currentPage = 1;

        if(page != null){
            currentPage = page;
        }

        PageVo pv = null;
        List<BoardVO> bList = null;
        if(sVal != null){
            int listCount = boardService.getSearchCount(sVal);
            pv = Pagination.getPageInfo(currentPage, listCount);
            bList = boardService.searchList(sVal,pv);
        } else {
            int listCount = boardService.getBoardCount();
            pv = Pagination.getPageInfo(currentPage, listCount);
            bList = boardService.boardList(pv);
        }

        model.addAttribute("bList", bList);
        model.addAttribute("pv", pv);

        return "board/board_main";
    }

    @RequestMapping("/writeForm")
    public String boardWriteForm(){
        return "board/board_write";
    }

    @PostMapping("/write")
    @ResponseBody
    public ResponseEntity boardWrite(BoardVO boardvo){

//        Map<String, String> msg = new HashMap<String, String>();
//
//        int result = boardService.boardWrite(boardvo);
//        msg.put("check", (result > 0)? "작성 완료":"작성 실패");
//
//        System.out.println("callbackMsg" + msg);
//        return new Gson().toJson(msg);

        return new ResponseEntity(boardService.boardWrite(boardvo), HttpStatus.OK);

    }

    @RequestMapping("/view")
    public String boardView( Model m, @RequestParam("boardSq")long boardSq,
                                        @RequestParam("page")int page){

        BoardVO board = boardService.boardView(boardSq);

        m.addAttribute("board", board);
        m.addAttribute("page", page);

        return "board/board_view";
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity boardDelete(@RequestParam("sq") long boardSq){

//        Map<String, String> msg = new HashMap<String, String>();
//
//        int result = boardService.boardDelete(boardSq);
//        msg.put("check", (result > 0)? "삭제 완료":"삭제 실패");
//
//        System.out.println("callbackMsg" + msg);
//        return new Gson().toJson(msg);

        return new ResponseEntity(boardService.boardDelete(boardSq), HttpStatus.OK);
    }
}
