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
            <h2>게시판</h2>
                <hr>

                <div class="write-area">
                    제목 : <span name="boardTitle">${board.boardTitle}</span> 작성 날짜 : <fmt:formatDate value="${board.boardModifyDt}" pattern="yyyy.MM.dd"/>
                    <p>첨부파일 : <a href="#" download="">TestFile.zip</a></p>
                    <hr>
                    <textarea cols="80" style="min-height: 133.6px;" readonly>${board.boardContent}</textarea>
                    <input type="hidden" value="${board.boardSq}" id="delBtn">
                    <div class="btn-area">
                        <button class='btn' id="delete">삭제</button>
                        <a href="<%= request.getHeader("referer") %>"><button class='btn'>뒤로가기</button></a>
                    </div>
                </div>
            </section>
        </section>
        <%@ include file="/WEB-INF/views/include/html_right_section.jspf" %>
    </div>
    <%@ include file="/WEB-INF/views/include/html_footer.jspf" %>
</body>
</html>