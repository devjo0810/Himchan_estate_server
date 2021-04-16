package site.himchan.estate.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NewsVO {
    private String linkUrl;
    private String imgUrl;
    private String title;
    private String info;
    private String content;
}
