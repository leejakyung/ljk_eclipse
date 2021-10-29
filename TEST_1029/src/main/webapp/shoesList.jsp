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
                        <img src="images/wheel-1000.jpg" 
                             srcset="images/wheel-2000.jpg 2000w, 
                                     images/wheel-1000.jpg 1000w, 
                                     images/wheel-500.jpg 500w" 
                                     sizes="(max-width: 2000px) 100vw, 2000px" alt="">
                        </p>

                        <h2>Large Heading</h2>
    
                        <p>
                        Harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum 
                        soluta nobis est eligendi optio cumque nihil impedit quo minus 
                        <a href="http://#">omnis voluptas assumenda est</a> id quod maxime placeat 
                        facere possimus, omnis dolor repellendus. Temporibus autem quibusdam et aut 
                        officiis debitis aut rerum necessitatibus saepe eveniet ut et.
                        </p>
    
                        <blockquote>
                            <p>
                            For God so loved the world, that he gave his only Son, that whoever believes in 
                            him should not perish but have eternal life. For God did not send his Son into 
                            the world to condemn the world, but in order that the world might be 
                            saved through him.
                            </p>
                            <cite>John 3:16-17 ESV</cite>
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
                                            <th>Title</th>
                                            <th>Comment</th>
                                            <th>date</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>Naruto Uzumaki</td>
                                            <td>16</td>
                                            <td>Male</td>
                                            <td>Konoha</td>
                                        </tr>
                                        <tr>
                                            <td>Sakura Haruno</td>
                                            <td>16</td>
                                            <td>Female</td>
                                            <td>Konoha</td>
                                        </tr>
                                        </tbody>
                                </table>

                            </div>

                        </div>
                        
                    </div> <!-- end row -->    

                    <div class="column large-12 comment-respond">

                        <!-- START respond -->
                        <div id="respond">
            
                            <h3 class="h2">Add Comment <span>Your email address will not be published</span></h3>
            
                            <form name="contactForm" id="contactForm" method="post" action="" autocomplete="off">
                                <fieldset>
            
                                    <div class="form-field">
                                        <input name="cName" id="cName" class="full-width" placeholder="Your Name" value="" type="text">
                                    </div>
            
                                    <div class="form-field">
                                        <input name="cEmail" id="cEmail" class="full-width" placeholder="Your Email" value="" type="text">
                                    </div>
            
                                    <div class="form-field">
                                        <input name="cWebsite" id="cWebsite" class="full-width" placeholder="Website" value="" type="text">
                                    </div>
            
                                    <div class="message form-field">
                                        <textarea name="cMessage" id="cMessage" class="full-width" placeholder="Your Message"></textarea>
                                    </div>
            
                                    <input name="submit" id="submit" class="btn full-width" value="Add Comment" type="submit">
           
                                </fieldset>
                            </form> <!-- end form -->
            
                        </div>
                        <!-- END respond-->
            
                    </div> <!-- end comment-respond -->
            
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