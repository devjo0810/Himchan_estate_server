<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/common.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/html_head.jspf" %>
    <link rel="stylesheet" href="/css/home.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/include/html_header.jspf" %>
    <%@ include file="/WEB-INF/views/include/html_nav.jspf" %>

    <div class="main-content">
        <%@ include file="/WEB-INF/views/include/html_left_section.jspf" %>
        <section class="center-section">
            <h2>부동산 뉴스</h2>
            <hr>
            <c:forEach var="news" items="${newsList}">
                <div class="news-item">
                    <a href="${news.linkUrl}" target="_blank" class="news-img-wrap">
                        <img src="${news.imgUrl}" width="80" height="80" class="news-img">
                    </a>
                    <div>
                        <a href="${news.linkUrl}" target="_blank" class="news-title">
                            ${news.title}
                        </a>
                        <br>
                        <span class="news-info">${news.info}</span>
                        <p class="news-content">${news.content}</p>
                    </div>
                </div>
            </c:forEach>
        </section>
        <%@ include file="/WEB-INF/views/include/html_right_section.jspf" %>
    </div>
    <%@ include file="/WEB-INF/views/include/html_footer.jspf" %>
    <%@ include file="/WEB-INF/views/include/html_loader.jspf" %>
</body>
</html>