<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!-- 메인 페이지 -->
<!DOCTYPE html>
<html class="no-js" lang="en">
<script type="text/javascript">
	function logout() {
		if (confirm("정말로 로그아웃 하시겠습니까?") == true) {
			location.href = "logout.do";
		} else {
			return;
		}
	}
</script>
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>Typerite</title>
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
        <header class="s-header">

            <div class="header__top">
                <div class="header__logo">
                    <a class="site-logo" href="index.html">
                        <img src="images/logo.svg" alt="Homepage">
                    </a>
                </div>

                <div class="header__search">
    
                    <form role="search" method="get" class="header__search-form" action="#">
                        <label>
                            <span class="hide-content">Search for:</span>
                            <input type="search" class="header__search-field" placeholder="Type Keywords" value="" name="s" title="Search for:" autocomplete="off">
                        </label>
                        <input type="submit" class="header__search-submit" value="Search">
                    </form>
        
                    <a href="#0" title="Close Search" class="header__search-close">Close</a>
        
                </div>  <!-- end header__search -->

                <!-- toggles -->
                <a href="#0" class="header__search-trigger"></a>
                <a href="#0" class="header__menu-toggle"><span>Menu</span></a>

            </div> <!-- end header__top -->

            <nav class="header__nav-wrap">

                <ul class="header__nav">
                    <li class="current"><a href="main.do" title="">Home</a></li>
                    <li class="has-children">
                        <a href="#0" title="">Categories</a>
                        <ul class="sub-menu">
                        <li><a href="shoesList.jsp">Nike</a></li>
                        <li><a href="shoesList.jsp">Adidas</a></li>
                        <li><a href="shoesList.jsp">Vans</a></li>
                        <li><a href="shoesList.jsp">Converse</a></li>
                        </ul>
                    </li>
                    <li class="has-children">
                        <a href="#0" title="">About us</a>
                        <ul class="sub-menu">
                        <li><a href="single-gallery.html">LeeJaKyung</a></li>
                        <li><a href="single-video.html">Blog</a></li>
                        <li><a href="single-audio.html">Git Hub</a></li>
                        </ul>
                    </li>
                    <li><a href="styles.html" title="">Project</a></li>
                    <li><a href="qAa.jsp" title="">Q&A</a></li>
                    <li><a href="page-contact.html" title="">Contact</a></li>
                    <c:if test="${seUser.email==null}">
                    <li><a href="login.do" title="">Login</a></li>
                    </c:if>
                    <c:if test="${seUser.email!=null}">
                    <li><a href="mine.jsp">Mypage</a></li>
                    <li><a href="#;" onclick="logout()">Logout</a></li>
                    </c:if>
                </ul> <!-- end header__nav -->

                <ul class="header__social">
                    <li class="ss-facebook">
                        <a href="https://facebook.com/">
                            <span class="screen-reader-text">Instagram</span>
                        </a>
                    </li>
                    <li class="ss-twitter">
                        <a href="#0">
                            <span class="screen-reader-text">YouTube</span>
                        </a>
                    </li>
                    <li class="ss-dribbble">
                        <a href="#0">
                            <span class="screen-reader-text">Dribbble</span>
                        </a>
                    </li>
                    <li class="ss-pinterest">
                        <a href="#0">
                            <span class="screen-reader-text">Behance</span>
                        </a>
                    </li>
                </ul>

            </nav> <!-- end header__nav-wrap -->

            

        </header> <!-- end s-header -->
		<!-- end s-header -->


		<!-- site content
        ================================================== -->

			<article class="column large-full entry format-standard">


		<div class="s-content content">
			<main class="row content__page">



				<div class="entry__content">




					<div class="entry__related">

						<ul class="related">
						<c:forEach var="v" items="${datas}">
							<li class="related__item">
							<a href="shoesList.do?spk=${v.spk}" class="related__link"> 
							<img src="images/${v.filename}" alt="신발이미지">
							</a>
								<h5 class="related__post-title">${v.sname}<br>${v.price}원</h5></li>
						</c:forEach>			
							
						</ul>
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