package site.himchan.estate.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import site.himchan.estate.mapper.MemberMapper;
import site.himchan.estate.vo.LoginVO;
import site.himchan.estate.vo.MemberVO;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<MemberVO> findAll() {
        return memberMapper.findAll();
    }

    public MemberVO findById(String id) {
        return memberMapper.findById(id);
    }

    public LoginVO login(MemberVO member)  throws Exception{
        LoginVO login = null;
        MemberVO origin = findById(member.getMemberId());
        if(origin == null) {
            throw new Exception("Not Found member id");
        }

        if(passwordEncoder.matches(member.getMemberPwd(), origin.getMemberPwd()) == false) {
            throw new Exception("Not Matched Password");
        } else {
            login = new LoginVO(origin.getMemberSq(), origin.getMemberId(), origin.getMemberCreateDt(), origin.getMemberGrant());
        }

        return login;
    }

    public int save(MemberVO member) throws Exception {
        if(memberMapper.checkId(member.getMemberId()) > 0) {
            throw new Exception("Same ID exists");
        }

        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
        if(member.getMemberGrant() == null) {
            member.setMemberGrant("G");
        }
        return memberMapper.save(member);
    }

    public int checkId(String id) {
        return memberMapper.checkId(id);
    }

}
