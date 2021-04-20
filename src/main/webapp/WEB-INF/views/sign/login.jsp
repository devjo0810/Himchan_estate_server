<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/common.jspf" %>
<!DOCTYPE html>
<html>

<head>
    <%@ include file="/WEB-INF/views/include/html_head.jspf" %>
</head>

<body>
    <div class="sign-page">
        <div class="sign-wrap">
            <div class="sign-title">
                <a href="/">
                    <img src="/resources/images/verti-logo.png">
                </a>
                <h2>LOGIN</h2>
            </div>
            <form action="/member/login" method="POST" id="loginForm">
                <div class="input-group">
                    <label for="login_id" class="label">ID</label>
                    <input id="login_id" class="input" type="text" name="id">
                </div>
                <div class="input-group">
                    <label for="login_pwd" class="label">Password</label>
                    <input id="login_pwd" class="input" type="password" name="password">
                </div>
                <button type="submit" class="btn block main-bg">로그인</button>
            </form>
        </div>
    </div>

    <script>
        var $id = $("#login_id");
        var $pwd = $("#login_pwd");

        $(document).ready(function() {
            $("#loginForm").on("submit", function() {
                if(!$id.val()) {
                    mcxDialog.alert('아이디를 입력해주세요.');
                    return false;
                }

                if(!$pwd.val()) {
                    mcxDialog.alert('비밀번호를 입력해주세요.');
                    return false;
                }

                console.log("submit");
                return true;
            });
        });
    </script>
</body>

</html>