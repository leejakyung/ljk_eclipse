<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!-- 메인 페이지 -->
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>SHUMONS</title>
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
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Dongle&family=Mochiy+Pop+One&display=swap" rel="stylesheet">


    <!-- script
    ================================================== -->
    <script src="js/modernizr.js"></script>

    <!-- favicons
    ================================================== -->
    <link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
    <link rel="manifest" href="site.webmanifest">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&family=Mochiy+Pop+One&display=swap" rel="stylesheet">


</head>

<body>

    <!-- preloader
    ================================================== -->
    <div id="preloader">
        <div id="loader" class="dots-fade">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>

    <div id="top" class="s-wrap site-wrapper">

        <!-- site header
        ================================================== -->
       <mytag:mainMenu />
		<!-- end s-header -->


		<!-- site content
        ================================================== -->

			<article class="column large-full entry format-standard">


		<div class="s-content content">
			<main class="row content__page">



				<div class="entry__content">




					<div class="entry__related">
					<h3>
						<a href="mypage.jsp" style="font-family: 'Jua', sans-serif; font-size: xx-large;">${seUser.userID}</a>
					</h3>
						<img alt="찜 하트 이미지" src="images/heart2.png"
							style="margin-bottom: -10px;">
						<hr>

						


					<div class="entry__related">

						<ul class="related">
						<c:forEach var="v" items="${datas}">
							<li class="related__item">
							<a href="shoesList.do?spk=${v.spk}" class="related__link"> 
							<img src="${v.filename}" alt="신발이미지" style="margin-top: -50px;">
							</a>
								<h5 class="related__post-title" style="margin-top: -3rem; font-size: smaller;">${v.sname}<br>${v.price}원</h5></li>
						</c:forEach>			
							
						</ul>
					</div>
					<!-- end entry related -->
				</div>
					</div>
					<!-- end entry related -->
				</div>

			<!-- end column large-full entry--> </main>
			</article>

			<!-- Java Script
    ================================================== -->
			<script src="js/jquery-3.2.1.min.js"></script>
			<script src="js/plugins.js"></script>
			<script src="js/main.js"></script>
</body>