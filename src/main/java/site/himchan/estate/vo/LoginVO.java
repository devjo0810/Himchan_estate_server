package site.himchan.estate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {
    private long memberSq;
    private String memberId;
    private Date memberCreateDt;
    private String memberGrant;
}
