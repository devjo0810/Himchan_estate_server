package site.himchan.estate.service;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import site.himchan.estate.mapper.BoardMapper;
import site.himchan.estate.mapper.FileMapper;
import site.himchan.estate.vo.BoardFileVO;
import site.himchan.estate.vo.BoardVO;
import site.himchan.estate.vo.PageVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;
    private final FileMapper fileMapper;

    public List<Map<String, Object>> findAll() {
        return boardMapper.findAll();
    }

    public String selectTest() {
        return boardMapper.selectTest();
    }

    public long boardWrite(BoardVO boardvo){
        boardMapper.boardWrite(boardvo);
        return boardvo.getBoardSq();
    }

    public List<BoardVO> boardList(PageVo pv) {
        int offset = (pv.getCurrentPage() -1) * pv.getBoardLimit();
        RowBounds rBounds = new RowBounds(offset, pv.getBoardLimit());
        return boardMapper.boardList(null, rBounds);
    }

    public BoardVO boardView(long boardSq) {
        int result = boardMapper.viewCount(boardSq);
        BoardVO b = null;
        if(result > 0){
            b = boardMapper.boardView(boardSq);
        }
        return b;
    }

    public int boardDelete(long boardSq) { return boardMapper.boardDelete(boardSq);
    }

    public int getBoardCount() { return boardMapper.getBoardCount();
    }

    public int getSearchCount(Map<String, String> map) {
        return boardMapper.getSearchCount(map);
    }

    public List<BoardVO> searchList(Map<String, String> map, PageVo pv) {
        int offset = (pv.getCurrentPage() -1) * pv.getBoardLimit();
        RowBounds rBounds = new RowBounds(offset, pv.getBoardLimit());
        return boardMapper.searchList(map, rBounds);
    }

    public int fileUpload(List<MultipartFile> files, HttpServletRequest request, long key) throws Exception {
        int result = 0;
        Map<String, Object> param = new HashMap<>();
//        String root = request.getSession().getServletContext().getRealPath("/");
//        String path = root + "\\uploadFiles";

        String buildPath = "/var/www/html/resource/uploadFiles";

        File folder = new File(buildPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        param.put("path", buildPath);
        param.put("boardSq", key);

        for(MultipartFile file : files) {
            String originFileName = file.getOriginalFilename(); // 원본 파일 명
            long fileSize = file.getSize(); // 파일 사이즈

            if(originFileName == null || fileSize == 0) continue;

            String extension = originFileName.substring(originFileName.lastIndexOf("."));
            UUID uuid = UUID.randomUUID();
            String changeFileName = uuid.toString() + extension;

            file.transferTo(new File(buildPath + "/" + changeFileName));
            param.put("originName", originFileName);
            param.put("name", changeFileName);
            param.put("fileSize", fileSize);
            result = fileMapper.save(param);
        }

        return result;
    }

    public List<BoardFileVO> findByBoardSq(long boardSq){
        return fileMapper.findByBoardSq(boardSq);
    }

}
