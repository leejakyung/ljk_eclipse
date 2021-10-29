<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!-- 임시비밀번호 발급 페이지 -->
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>Styles - Typerite</title>
   <!--  <script type="text/javascript">
	function send_mail() {
		window.open("./test_mail.jsp", "", "width=370, height=360, resizable=no, scrollbars=no, status=no");
	}
	</script> -->
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
                        <li><a href="category.html">Nike</a></li>
                        <li><a href="category.html">Adidas</a></li>
                        <li><a href="category.html">Vans</a></li>
                        <li><a href="category.html">Converse</a></li>
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
                    <li><a href="list.do" title="">Q&A</a></li>
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

    

                    <div class="row" style="justify-content: center;">

                        <div class="column large-6 tab-full" style="margin-top: 5em;">

                            <h2 style="margin: revert;">Forgot Password ?</h2>

                            <form action="pwmail.do" method="post">
                                <div>
                                    <label for="sampleInput">Your email</label>
                                    <input class="full-width" type="email" name="email" placeholder="test@mailbox.com" id="sampleInput">
                                </div>
                           
                                <input class="btn--primary full-width" type="submit"  value="임시 비밀번호 발급">
                            </form>
								<!-- <div class="form-group" style="width: 38%; margin: 10px auto;">
									<button type="button" class="btn btn-primary btn-lg btn-block"
										onclick="send_mail()">보내기</button>
								</div> -->
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