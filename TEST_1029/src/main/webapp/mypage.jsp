<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!-- 마이페이지 -->
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>Styles - Typerite</title>
<script type="text/javascript">
	function memDel() {
		result = confirm("정말 탈퇴하시겠습니까?");
		if (result == true) {
			location.href = "cdelete.do?&email=${seUser.email}";
		} else {
			return;
		}

	}
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

                            <h2 style="margin: revert;">MY PAGE</h2>

                            <form action="cupdate.do" method="post">
                                <div>
                                    <label for="sampleInput">Your email</label>
                                    <input class="full-width" type="text" value="${seUser.email}" id="sampleInput" name="email" readonly="readonly">
                                </div>
                            	<div>
                                  	<label for="sampleInput">Nickname</label>
                                    <input class="full-width" type="text" value="${seUser.userID}" id="sampleInput" name="userID" readonly="readonly">
                                </div>
                                <div>
                                    <label for="sampleInput">Password</label>
                                    <input class="full-width" type="password" value="${seUser.userPW}" id="sampleInput" name="userPW">
                                </div>
                               
                          
                                <input class="btn--primary full-width" type="submit" value="회원정보 수정">             
                                <a class="btn btn--stroke full-width" type="button" onclick="memDel()">회원탈퇴</a>
                                
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