<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

<!--- basic page needs
    ================================================== -->
<meta charset="utf-8">
<title>Styles - Typerite</title>
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
                    <li><a href="mypage.jsp">Mypage</a></li>
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
		<div class="s-content content">
		
				<div class="column large-6 tab-full" style="max-width: 100%">

					<h3>Q&A</h3>

					<br>
				<form action="list.do" method="post">
					<c:if test="${mdatas==null}">
						<tr>
							<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${mdatas!=null}">
					<c:forEach var="v" items="${mdatas}">
						<div class="alert-box alert-box--error hideit">
							<p>${v.userID}</p>
							${v.content} <i class="fa fa-times alert-box__close"
								aria-hidden="true"></i>
						</div>
					</c:forEach>	
					</c:if>
					<!-- end error -->

					<div class="alert-box alert-box--success hideit">
						<p>Success Message. Your Message Goes Here.</p>
						<i class="fa fa-times alert-box__close" aria-hidden="true"></i>
					</div>
					<!-- end success -->

					<div class="alert-box alert-box--info hideit">
						<p>Info Message. Your Message Goes Here.</p>
						<i class="fa fa-times alert-box__close" aria-hidden="true">
					
					</i>
					</div>
					<!-- end info -->

					<div class="alert-box alert-box--notice hideit">
						<p>Notice Message. Your Message Goes Here.</p>
						<i class="fa fa-times alert-box__close" aria-hidden="true"></i>
					</div>
					<!-- end notice -->
				</form>
				
				<div class="row">
					<div class="column large-full">
						<nav class="pgn">
							<ul>
								<li><a class="pgn__prev" href="#0">Prev</a></li>
								<li><a class="pgn__num" href="#0">1</a></li>
								<li><span class="pgn__num current">2</span></li>
								<li><a class="pgn__num" href="#0">3</a></li>
								<li><a class="pgn__num" href="#0">4</a></li>
								<li><a class="pgn__num" href="#0">5</a></li>
								<li><span class="pgn__num dots">…</span></li>
								<li><a class="pgn__num" href="#0">8</a></li>
								<li><a class="pgn__next" href="#0">Next</a></li>
							</ul>
						</nav>
					</div>
				</div>




				<form action="minsert.do" method="post">

					<label for="exampleMessage">Message</label>
					<textarea class="full-width" placeholder="Your message" id="exampleMessage" style="width: 100%"></textarea>

					<input class="btn full-width" type="submit" value="add Q&A">
				</form>


			</div>


			</div>
	<!-- end s-content -->


	<!-- footer
        ================================================== -->
	<footer class="s-footer footer">
		<div class="row">
			<div class="column large-full footer__content">
				<div class="footer__copyright">
					<span>© Copyright Typerite 2019</span> <span>Design by <a
						href="https://www.styleshout.com/">StyleShout</a></span>
				</div>
			</div>
		</div>

		<div class="go-top">
			<a class="smoothscroll" title="Back to Top" href="#top"></a>
		</div>
	</footer>

	</div>
	<!-- end s-wrap -->


	<!-- Java Script
    ================================================== -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>

</body>