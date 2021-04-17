package site.himchan.estate.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BoardVO {
    private long boardSq;
    private String boardTitle;
    private String boardContent;
    private long boardCount;
    private Date boardCreateDt;
    private Date boardModifyDt;
    private String boardSecret;


}
