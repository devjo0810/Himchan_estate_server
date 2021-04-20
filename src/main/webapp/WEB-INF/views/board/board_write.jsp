<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/common.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/html_head.jspf" %>
    <link rel="stylesheet" href="/resources/css/board.css">
    <script src="https://cdn.tiny.cloud/1/y6ypfcu3qs0kqjfkb2vmbkx6t2pvqk8zqu5pyt8uwmu353yr/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
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
                    <div class="write-title">
                        <span>제목</span>
                        <input type="text" name="boardTitle" id="boardTitle" placeholder="제목을 입력해 주세요.">
                    </div>
                    <textarea placeholder="내용을 입력해 주세요." id="tiny"></textarea>
                    <input type="hidden" name="boardContent" id="boardContent">
                    <div class="btn-area">
                        <a href="<%= request.getHeader("referer") %>" id="cancelBtn"><button type="button" class='btn red-bg'>취소</button></a>
                        <button type="submit" class="btn main-bg" id="enroll">등록하기</button>
                    </div>
                </form>
            </div>
        </section>
        <%@ include file="/WEB-INF/views/include/html_right_section.jspf" %>
    </div>
    <%@ include file="/WEB-INF/views/include/html_footer.jspf" %>
    <script src="/resources/js/board.js"></script>
    <script>
        $(document).ready(function(){
            $("#uploadForm").on("submit", function() {
                var title = $('#boardTitle').val();

                var content = tinymce.get("tiny").getContent();

                if(title == '' || content == '') {
                    mcxDialog.alert("제목과 글을 모두  작성해 주세요.");
                    return false;
                }
                $("#boardContent").val(content);

                return true;
            });

            tinymce.init({
                selector: "#tiny",
                resize: false,
                height: '70vh',
                plugins: [
                    'advlist autolink link lists charmap print preview hr anchor pagebreak spellchecker',
                    'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime nonbreaking',
                    'table emoticons template paste help'
                ]
            });
        });
    </script>
</body>
</html>