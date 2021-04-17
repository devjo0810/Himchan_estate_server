package site.himchan.estate.service;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import site.himchan.estate.mapper.BoardMapper;
import site.himchan.estate.vo.BoardVO;
import site.himchan.estate.vo.PageVo;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Map<String, Object>> findAll() {
        return boardMapper.findAll();
    }

    public String selectTest() {
        return boardMapper.selectTest();
    }

    public int boardWrite(BoardVO boardvo){
        return boardMapper.boardWrite(boardvo);
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

    public int getSearchCount(String sVal) {
        System.out.println("service : " + boardMapper.getSearchCount(sVal));
        return boardMapper.getSearchCount(sVal);
    }

    public List<BoardVO> searchList(String sVal, PageVo pv) {

        int offset = (pv.getCurrentPage() -1) * pv.getBoardLimit();

        RowBounds rBounds = new RowBounds(offset, pv.getBoardLimit());

        return boardMapper.searchList(sVal, rBounds);
    }

}
