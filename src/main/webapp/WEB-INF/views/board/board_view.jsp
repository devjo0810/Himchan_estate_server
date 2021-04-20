<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/common.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/html_head.jspf" %>
    <link rel="stylesheet" href="/resources/css/board.css">
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
                    <p>첨부파일
                        <c:if test="${fn:length(files) > 0}">
                            <c:forEach var="file" items="${files}">
                                <br />
                                <a href="${uploadFilePath}/${file.fileNm}" class="sign-link" download="${file.fileOriginNm}">${file.fileOriginNm}</a>
                                <span class="sub-caption">(${file.fileSize} byte)</span>
                            </c:forEach>
                        </c:if>
                        <c:if test="${fn:length(files) <= 0}">
                            없음
                        </c:if>
                    </p>
                    <hr>
                    <div class="content-wrap">${board.boardContent}</div>
                    <input type="hidden" value="${board.boardSq}" id="delBtn">
                    <div class="btn-area">
                    <c:if test="${!empty sessionScope.login && sessionScope.login.memberGrant eq 'A'}">
                        <button class='btn red-bg' id="delete">삭제</button>
                    </c:if>
                        <a href="<%= request.getHeader("referer") %>"><button class='btn'>뒤로가기</button></a>
                    </div>
                </div>
            </section>
        </section>
        <%@ include file="/WEB-INF/views/include/html_right_section.jspf" %>
    </div>
    <%@ include file="/WEB-INF/views/include/html_footer.jspf" %>
    <script src="/resources/js/board.js"></script>
</body>
</html>