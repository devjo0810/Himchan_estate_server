package site.himchan.estate.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.himchan.estate.vo.MemberVO;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {

    public List<MemberVO> findAll();
}
