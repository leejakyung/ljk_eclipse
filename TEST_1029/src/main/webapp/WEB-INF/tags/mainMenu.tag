<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <header class="s-header">

            <div class="header__top">
                <div class="header__logo">
                    <a class="site-logo" href="index.jsp">
                        <img style="height: 40px; margin-left: -10px; width: 150px;" src="images/logo.png" alt="Homepage">
                    </a>
                </div>

                <div class="header__search">
    				<c:if test="${seUser.email=='admin'}">
                    <form role="search" method="post" class="header__search-form" action="adminList.do">
                        <label>
                            <span class="hide-content">Search for:</span>
                            <input type="search" class="header__search-field" placeholder="Type Keywords" value="" name="keyword" title="Search for:" autocomplete="off">
                        </label>
                        <input type="submit" class="header__search-submit" value="Search">
                    </form>
                    </c:if>
                    	<c:if test="${seUser.email!='admin'}">
                    <form role="search" method="post" class="header__search-form" action="category.do">
                        <label>
                            <span class="hide-content">Search for:</span>
                            <input type="search" class="header__search-field" placeholder="Type Keywords" value="" name="keyword" title="Search for:" autocomplete="off">
                        </label>
                        <input type="submit" class="header__search-submit" value="Search">
                    </form>
                    </c:if>
        
        
                    <a href="" title="Close Search" class="header__search-close">Close</a>
        
                </div>  <!-- end header__search -->

                <!-- toggles -->
                <a href="#0" class="header__search-trigger"></a>
                <a href="#0" class="header__menu-toggle"><span>Menu</span></a>

            </div> <!-- end header__top -->

            <nav class="header__nav-wrap">

                <ul class="header__nav">
                    <li class="current"><a href="main.do" title="">Home</a></li>
			<c:if test="${seUser.email=='admin'}">
				<li class="has-children"><a href="#0" title="">AdminCategories</a>
					<ul class="sub-menu">
						<li><a href="adminList.do?brandname=Nike">Nike</a></li>
						<li><a href="adminList.do?brandname=Jordan">Jordan</a></li>
						<li><a href="adminList.do?brandname=New Balance">New Balance</a></li>
					</ul>
				</li>
			</c:if>
			<c:if test="${seUser.email!='admin'}">
				<li class="has-children"><a href="#0" title="">Categories</a>
					<ul class="sub-menu">
						<li><a href="category.do?brandname=Nike">Nike</a></li>
						<li><a href="category.do?brandname=Jordan">Jordan</a></li>
						<li><a href="category.do?brandname=New Balance">New Balance</a></li>
					</ul>
				</li>
			</c:if>
			<li class="has-children">
                        <a href="#0" title="">About us</a>
                        <ul class="sub-menu">
                        <li><a href="https://blog.naver.com/ljk940826">Blog</a></li>
                        <li><a href="https://github.com/leejakyung">Git Hub</a></li>
                        </ul>
                    </li>
                    <c:if test="${seUser.email==null}">
                    <li><a href="login.jsp" title="">Login</a></li>
                    </c:if>
                    <c:if test="${seUser.email!=null}">
                    <li><a href="mine.do">Mypage</a></li>
                    <li><a href="#;" onclick="logout()">Logout</a></li>
                    </c:if>
                </ul> <!-- end header__nav -->

                <ul class="header__social">
                    <li class="ss-instagram">
                        <a href="https://www.instagram.com/rxlo.__/">
                            <span class="screen-reader-text">Instagram</span>
                        </a>
                    </li>
                    <li class="ss-facebook">
                        <a href="https://www.youtube.com/results?search_query=%EB%B0%95%EB%B0%94%EB%A6%AC">
                            <span class="screen-reader-text">Facebook</span>
                        </a>
                    </li>
                </ul>

            </nav> <!-- end header__nav-wrap -->

            

        </header> <!-- end s-header -->