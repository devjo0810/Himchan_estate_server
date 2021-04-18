<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/common.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/html_head.jspf" %>
    <link rel="stylesheet" href="/css/home.css">
    <script src="/js/board.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/views/include/html_header.jspf" %>
    <%@ include file="/WEB-INF/views/include/html_nav.jspf" %>

    <div class="main-content">
        <%@ include file="/WEB-INF/views/include/html_left_section.jspf" %>
        <section class="center-section">
            <h2>글쓰기</h2>
            <hr>

            <div class="write-area">
                <!--
                <span><a href="#this" class="btn" id="addFile">파일추가</a></span>
                <div id="file-area">
                    <p>
                        <input type="file" name="fileOriginNm">
                        <a href="" class="btn" id="fileDelete" name="fileDelete">삭제</a>
                    </p>
                </div>
                -->
                <form id="uploadForm" action="" method="post" encType="multipart/form-data">
                    <input type="file" name="fileOriginNm" multiple>
                </form>
                공개 여부 :
                <select name="boardSecret">
                    <option value="Y">전체공개</option>
                    <option value="N">비공개</option>
                </select>
                <hr>
                <input type="text" name="boardTitle" id="boardTitle" placeholder="제목을 입력해 주세요.">
                <textarea placeholder="글을 입력해 주세요." cols="80" rows="6" name="boardContent" id="boardContent"></textarea>

                <div class="btn-area">
                    <a href="<%= request.getHeader("referer") %>"><button class='btn'>취소</button></a>
                    <button class="btn" id="enroll">등록하기</button>
                </div>
            </div>
        </section>
        <%@ include file="/WEB-INF/views/include/html_right_section.jspf" %>
    </div>
    <%@ include file="/WEB-INF/views/include/html_footer.jspf" %>
</body>
</html>