package site.himchan.estate.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MemberVO {
    private long memberSq;
    private String memberId;
    private String memberPwd;
    private Date memberCreateDt;
    private String memberGrant;
}
