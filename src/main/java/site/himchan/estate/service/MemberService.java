package site.himchan.estate.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.himchan.estate.mapper.MemberMapper;
import site.himchan.estate.vo.MemberVO;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public List<MemberVO> findAll() {
        return memberMapper.findAll();
    }

}
