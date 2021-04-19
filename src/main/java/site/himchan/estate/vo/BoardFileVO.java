package site.himchan.estate.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BoardFileVO {
    private long fileSq;
    private String filePath;
    private String fileOriginNm;
    private String fileNm;
    private Date fileCreateDt;
    private long fileSize;
    private String fileType;
    private long boardSq;
}
