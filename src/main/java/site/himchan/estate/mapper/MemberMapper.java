package site.himchan.estate.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.himchan.estate.vo.LoginVO;
import site.himchan.estate.vo.MemberVO;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {

    List<LoginVO> findAll();
    MemberVO findById(String id);
    int save(MemberVO member);
    int checkId(String id);
}
