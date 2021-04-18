package site.himchan.estate.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import site.himchan.estate.service.BoardService;
import site.himchan.estate.vo.BoardFileVO;
import site.himchan.estate.vo.BoardVO;
import site.himchan.estate.vo.PageVo;
import site.himchan.estate.vo.Pagination;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String board(Model model,
                        @RequestParam(value="page", required=false) Integer page,
                        @RequestParam(value="sVal", required = false) String sVal,
                        @RequestParam(value="sCate", required = false) String sCate) {

        int currentPage = 1;

        if(page != null){
            currentPage = page;
        }

        PageVo pv = null;
        List<BoardVO> bList = null;
        Map<String, String> map = new HashMap<String, String>();
        if(sVal != null){
            if(sCate.equals("title")){
                map.put("title", sVal);
                map.put("content", null);
            } else if(sCate.equals("content")){
                map.put("title", null);
                map.put("content", sVal);
            }
            int listCount = boardService.getSearchCount(map);
            pv = Pagination.getPageInfo(currentPage, listCount);
            bList = boardService.searchList(map,pv);
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
    @PostMapping("/uploadFile")
    @ResponseBody
    public void uploadFile(MultipartHttpServletRequest multi, HttpServletRequest request){

        String root = request.getSession().getServletContext().getRealPath("resources");
        String path = root + "\\uploadFiles";
        String fileOriginNm = "";


        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdirs();
        }

        String extension = fileOriginNm.substring(fileOriginNm.lastIndexOf("."));

        UUID uuid = UUID.randomUUID();
        String fileNm = uuid.toString() + extension;

        String filePath = folder + "\\" + fileNm;

        Iterator<String> files = multi.getFileNames();
        while (files.hasNext()){
            String uploadFile = files.next();
            MultipartFile mFile = multi.getFile(uploadFile);
            fileOriginNm = mFile.getOriginalFilename();

            try{
                mFile.transferTo(new File(filePath));
            } catch (IllegalStateException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

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
