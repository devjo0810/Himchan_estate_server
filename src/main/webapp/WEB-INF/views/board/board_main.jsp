<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/common.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/html_head.jspf" %>
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
                        <th width="5%">No</th>
                        <th width="60%">Title</th>
                        <th width="15%">Date</th>
                        <th width="5%">Count</th>
                        <th width="15%">File</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${!empty bList}">
                        <c:forEach var="list" items="${bList}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>
                            <c:url var="view" value="/board/view">
                                <c:param name="boardSq" value="${list.boardSq}"/>
                            </c:url>
                            <a href="${view}">${list.boardTitle}</a>
                        </td>
                        <td><fmt:formatDate value="${list.boardModifyDt}" pattern="yyyy.MM.dd"/></td>
                        <td>${list.boardCount}</td>
                        <td>${list.boardSecret}</td>
                    </tr>
                        </c:forEach>
                    </c:if>
                </tbody>


                <table id="etc-btn">
                    <thead>
                        <tr>
                            <td style="text-align: left;">
                                <input type="text" placeholder="검색어를 입력해주세요." />
                                <button style="border: 1px solid black; padding-top: 0px;">조회</button>
                            </td>

                            <c:if test="${sessionScope.login ne null}">
                            <td style="text-align: right;">
                                <a href="/board/writeForm" style="border: 1px solid black;">
                                    <button>글쓰기</button>
                                </a>
                            </td>
                            </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <tr align="center">
                            <td colspan="2">
                                <a href="" class="Btn">&lt;</a>

                                <span id="choosen">1</span>

                                <a href="#" class="Btn">2</a>
                                <a href="#" class="Btn">3</a>
                                <a href="#" class="Btn">4</a>
                                <a href="#" class="Btn">5</a>
                                <a href="#" class="Btn">6</a>

                                <a href="#" class="Btn">&gt;</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </table>
        </section>
        <%@ include file="/WEB-INF/views/include/html_right_section.jspf" %>
    </div>
    <%@ include file="/WEB-INF/views/include/html_footer.jspf" %>
</body>
</html>