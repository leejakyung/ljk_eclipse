<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!-- 로그인페이지 -->
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>SHUMONS</title>
    <link rel="SHOMONS icon" href="images/user.ico">
<script type="text/javascript">
	function logout() {
		if (confirm("정말로 로그아웃 하시겠습니까?") == true) {
			location.href = "logout.do";
		} else {
			return;
		}
	}
</script>
<meta name="description" content="">
    <meta name="author" content="">

    <!-- mobile specific metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/vendor.css">
    <link rel="stylesheet" href="css/main.css">

    <style type="text/css" media="screen">
        .s-styles { 
            max-width: 1100px;
            padding-bottom: 12rem;
        }
    </style>

    <!-- script
    ================================================== -->
    <script src="js/modernizr.js"></script>

    <!-- favicons
    ================================================== -->
    <link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
    <link rel="manifest" href="site.webmanifest">

</head>

<body class="ss-bg-white">


	<mytag:mainMenu />
		

    

                    <div class="row" style="justify-content: center;">

                        <div class="column large-6 tab-full" style="margin-top: 5em;">

                            <h2 style="margin: revert;">LOGIN</h2>

                            <form action="login.do" method="post">
                                <div>
                                    <label for="sampleInput">Your email</label>
                                    <input class="full-width" type="text" placeholder="test@mailbox.com" id="sampleInput" name="email" value="${guest.email}">
                                </div>
                                <div>
                                    <label for="sampleInput">Password</label>
                                    <input class="full-width" type="password" placeholder="password" id="sampleInput" name="userPW" value="${guest.userPW}">
                                </div>
                 				<a class="pwBTN" href="pw.jsp" style="float: right; FONT-SIZE: medium; MARGIN: inherit;">» Forgot Password ?</a>
                                <input class="btn--primary full-width" type="submit" value="Login">             
                                <a class="btn btn--stroke full-width" href="signup.jsp">SIGNUP</a>
                            </form>

                        </div>

           

        <!-- footer
        ================================================== -->
        <footer class="s-footer footer">
            <div class="row">
                <div class="column large-full footer__content">
                    <div class="footer__copyright">
                        <span>© Copyright Typerite 2019</span> 
                        <span>Design by <a href="https://www.styleshout.com/">StyleShout</a></span>
                    </div>
                </div>
            </div>

            <div class="go-top">
                <a class="smoothscroll" title="Back to Top" href="#top"></a>
            </div>
        </footer>

    </div> <!-- end s-wrap -->


    <!-- Java Script
    ================================================== -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script>

</body>