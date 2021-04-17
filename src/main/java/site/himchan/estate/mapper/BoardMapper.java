package site.himchan.estate.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.himchan.estate.vo.BoardVO;
import site.himchan.estate.vo.PageVo;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BoardMapper {
    List<Map<String, Object>> findAll();
    String selectTest();

    int boardWrite(BoardVO boardvo);

    List<BoardVO> boardList(PageVo pageVo);

    BoardVO boardView(long boardSq);

    int boardDelete(long boardSq);
}
