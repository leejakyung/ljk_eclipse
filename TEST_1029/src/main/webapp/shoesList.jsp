<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>    
<!-- 게시물 상세 페이지 -->   
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>Standard Post - Typerite</title>
    
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


        <!-- site content
        ================================================== -->
        <div class="s-content content">
            <main class="row content__page">
                
                <article class="column large-full entry format-standard">

  

                   

                    <div class="entry__content">
                      

                        <p>
                        <img src="images/${data.filename}"  alt="신발 이미지">
                        </p>

                        <h2>${data.sname}</h2>
    
                        <blockquote>
                            <p>
                            ${data.brandname}<br>
                            ${data.spk}<br>
                            ${data.price}원<br>
                            </p>
                            <cite>출시일 ${data.sdate}</cite>
                        </blockquote>
    	
                       
    

                   

                    <div class="entry__related">
                        <h3 class="h2">이 상품을 본 사람들이 많이 본 게시물</h3>

                        <ul class="related">
                            <li class="related__item">
                                <a href="single-standard.html" class="related__link">
                                    <img src="images/thumbs/masonry/walk-600.jpg" alt="">
                                </a>
                                <h5 class="related__post-title">Using Repetition and Patterns in Photography.</h5>
                            </li>
                            <li class="related__item">
                                <a href="single-standard.html" class="related__link">
                                    <img src="images/thumbs/masonry/dew-600.jpg" alt="">
                                </a>
                                <h5 class="related__post-title">Health Benefits Of Morning Dew.</h5>
                            </li>
                            <li class="related__item">
                                <a href="single-standard.html" class="related__link">
                                    <img src="images/thumbs/masonry/rucksack-600.jpg" alt="">
                                </a>
                                <h5 class="related__post-title">The Art Of Visual Storytelling.</h5>
                            </li>
                        </ul>
                    </div> <!-- end entry related -->

                </article> <!-- end column large-full entry-->


			<div class="row add-bottom">

				<div class="column large-full">

					<h3>Comment</h3>

					<div class="table-responsive">

						<table>
							<thead>
								<tr>
									<th>ID</th>
									<th>Comment</th>
									<th>date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="v" items="${mdatas}">
									<tr>
										<td>${v.userID}</td>
										<td>${v.content}</td>
										<td>${v.cdate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>

				</div>

			</div>
			<!-- end row -->

			<div class="column large-12 comment-respond">

				<!-- START respond -->
				<div id="respond">

					<form action="minsert.do" method="post">
						<input type="hidden" value="${data.spk}" name="spk">
						<input type="hidden" value="${seUser.userID}" name="userID">
						<label for="exampleMessage">Message</label>
						<input type="text" class="full-width" placeholder="Your message"
							id="exampleMessage" name="content" style="width: 100%">
					
						<input class="btn full-width" type="submit" value="add comment">
					</form>
					

				</div>
				<!-- END respond-->

			</div>
			<!-- end comment-respond -->
            
                </div> <!-- end comments-wrap -->
            </main>

        </div> <!-- end s-content -->


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