package site.himchan.estate.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.himchan.estate.vo.BoardFileVO;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface FileMapper {
    int save(Map<String, Object> param);

    List<BoardFileVO> findByBoardSq(long boardSq);
}
