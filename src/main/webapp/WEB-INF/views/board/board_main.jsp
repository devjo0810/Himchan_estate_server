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
            <table id="board-table">
                <thead>
                    <tr>
                        <th width="5%">번호</th>
                        <th width="60%">제목</th>
                        <th width="15%">날짜</th>
                        <th width="5%">조회수</th>
                        <%-- <th width="15%">File</th> --%>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${!empty bList}">
                        <c:forEach var="list" items="${bList}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>
                            <input type="hidden" id="boardSq" value="${list.boardSq}">
                            <input type="hidden" id="page" value="${ pv.currentPage}">
                            <c:url var="view" value="/board/view">
                                <c:param name="boardSq" value="${list.boardSq}"/>
                                <c:param name="page" value="${ pv.currentPage}"/>
                            </c:url>
                            <c:if test="${list.boardSecret eq 'N'}">
                                <c:if test="${empty sessionScope.login || sessionScope.login.memberGrant eq 'G'}">
                                    <a href="#" class="boardView">비공개 글입니다.</a>
                                </c:if>
                                <c:if test="${!empty sessionScope.login && sessionScope.login.memberGrant eq 'A'}">
                                    <a href="#" class="boardView">${list.boardTitle}</a>
                                </c:if>
                            </c:if>
                            <c:if test="${list.boardSecret eq 'Y'}">
                                <a href="#" class="boardView">${list.boardTitle}</a>
                            </c:if>
                        </td>
                        <td><fmt:formatDate value="${list.boardModifyDt}" pattern="yyyy.MM.dd"/></td>
                        <td>${list.boardCount}</td>
                    </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty bList}">
                        <tr>
                            <td colspan="5">
                                <b>조회된 내역이 없습니다.</b>
                            </td>
                        </tr>
                    </c:if>
                </tbody>
            </table>

            <div class="etc-area">
                <div class="search-area">
                    <select name="searchCate" id="searchCate">
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                    </select>
                    <input type="text" placeholder="검색어를 입력해주세요." name="searchValue" id="searchValue"/>
                    <button class="btn main-bg" id="searchBtn">조회</button>
                </div>
                <div class="write-btn">
                    <a href="/board/writeForm">
                        <button class="btn sub-bg">글쓰기</button>
                    </a>
                </div>
            </div>

            <div class="paging-area">
                <c:if test="${!empty bList}">
                    <c:if test="${ pv.currentPage <= 1}">
                        <a class="disable">&lt;</a> &nbsp;
                    </c:if>
                    <c:if test="${ pv.currentPage > 1}">
                        <c:url var="before" value="/board">
                            <c:param name="page" value="${ pv.currentPage - 1}"/>
                        </c:url>
                        <a href="${ before}" class="able">&lt;</a> &nbsp;
                    </c:if>

                    <c:forEach var="p" begin="${ pv.startPage}" end="${ pv.endPage}">
                        <c:if test="${ p eq pv.currentPage}">
                            <a class="disable">${p}</a>
                        </c:if>
                        <c:if test="${ p ne pv.currentPage}">
                            <c:url var="pagination" value="/board">
                                <c:param name="page" value="${ p }"/>
                            </c:url>
                            <a href="${ pagination}" class="able">${p}</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${ pv.currentPage >= pv.maxPage}">
                        &nbsp; <a class="disable">&gt;</a>
                    </c:if>
                    <c:if test="${ pv.currentPage < pv.maxPage}">
                        <c:url var="after" value="/board">
                            <c:param name="page" value="${ pv.currentPage + 1 }"/>
                        </c:url>
                        &nbsp; <a href="${ after}" class="able">&gt;</a>
                    </c:if>
                </c:if>

            </div>
        </section>
        <%@ include file="/WEB-INF/views/include/html_right_section.jspf" %>
    </div>
    <%@ include file="/WEB-INF/views/include/html_footer.jspf" %>
    <script src="/resources/js/board.js"></script>
</body>
</html>