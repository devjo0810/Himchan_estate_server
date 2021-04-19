<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/common.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/html_head.jspf" %>
    <link rel="stylesheet" href="/resources/css/home.css">
    <script src="/resources/js/board.js"></script>
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
                <form id="uploadForm" action="/board/upload" method="post" encType="multipart/form-data">
                    <input type="file" name="files" multiple>
                    공개 여부 :
                    <select name="boardSecret">
                        <option value="Y" checked>전체공개</option>
                        <option value="N">비공개</option>
                    </select>
                    <hr>
                    <input type="text" name="boardTitle" id="boardTitle" placeholder="제목을 입력해 주세요.">
                    <textarea placeholder="글을 입력해 주세요." cols="80" rows="6" name="boardContent" id="boardContent"></textarea>

                    <div class="btn-area">
                        <a href="<%= request.getHeader("referer") %>"><button class='btn'>취소</button></a>
                        <button type="submit" class="btn" id="enroll">등록하기</button>
                    </div>
                </form>
            </div>
        </section>
        <%@ include file="/WEB-INF/views/include/html_right_section.jspf" %>
    </div>
    <%@ include file="/WEB-INF/views/include/html_footer.jspf" %>
    <script>
        $(document).ready(function(){
            $("#uploadForm").on("submit", function() {
                var title = $('#boardTitle').val();
                var content = $('#boardContent').val();

                if(title == '' || content == '') {
                    mcxDialog.alert("제목과 글을 모두  작성해 주세요.");
                    return false;
                }

                return true;
            });
        });
    </script>
</body>
</html>