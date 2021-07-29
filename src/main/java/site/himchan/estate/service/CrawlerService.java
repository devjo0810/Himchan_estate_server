package site.himchan.estate.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import site.himchan.estate.vo.NewsVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CrawlerService {
    private final String NEWS_URL = "https://search.daum.net/search?w=news&nil_search=btn&DA=NTB&enc=utf8&cluster=y&cluster_page=1&q=%EB%B6%80%EB%8F%99%EC%82%B0";

    public List<NewsVO> getNews() throws Exception {
        List<NewsVO> newsList = new ArrayList<>();
        Document doc = Jsoup.connect(NEWS_URL).get();
//        Elements elements = doc.select("#clusterResultUL li");
        Elements elements = doc.select(".list_news li");

        for(Element element : elements) {
            NewsVO news = new NewsVO();
            Element link = element.select(".wrap_thumb a").first();
            if(link != null) {
                news.setLinkUrl(link.attr("href"));
            }

            Element img = element.select(".wrap_thumb img").first();
            if(img != null) {
                news.setImgUrl(img.attr("src"));
            }

//            Element title = element.select(".wrap_tit a").first();
            Element title = element.select(".wrap_cont a").first();
            news.setTitle(title.text());
            if(link == null) {
                news.setLinkUrl(title.attr("href"));
            }

//            Element info = element.select(".cont_inner .f_nb").first();
            Element info = element.select(".cont_info .f_nb").first();
            news.setInfo(info.text());

//            Element content = element.select(".cont_inner .f_eb").first();
            Element content = element.select(".wrap_cont .desc").first();
            news.setContent(content.text());

            newsList.add(news);
        }
        return newsList;
    }
}
