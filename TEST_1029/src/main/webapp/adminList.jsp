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
    <title>SHUMONS</title>
    <link rel="SHOMONS icon" href="images/admin.ico"> 
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
    <mytag:mainMenu />
		<!-- end s-header -->

	</div>
		<!-- site content
        ================================================== -->

			<article class="column large-full entry format-standard">


		<div class="s-content content">
			<main class="row content__page">



				<div class="entry__content">




					<div class="entry__related">
						<a href="admin.jsp">»게시물 등록</a>
						<ul class="related">
						<c:forEach var="v" items="${datas}">
							<li class="related__item">
							<a href="admin.do?spk=${v.spk}" class="related__link"> 
							<img src="${v.filename}" alt="신발이미지">
							</a>
								<h5 class="related__post-title" style="margin-top: -3rem;">${v.sname}<br>${v.price}원</h5></li>
						</c:forEach>			
							
						</ul>
					</div>
					<!-- end entry related -->
				</div>

			<div class="row">
				<div class="column large-full">
					<nav class="pgn">
						<ul>
						<c:if test="${paging.startPage != 1 }">
						<li><a  class="pgn__prev" href="adminList.do?page=${(page-1)-(page-1)%paging.perPageSet - paging.perPageSet + 1}&brandname=${brandname}&keyword=${keyword}"></a></li><!-- 이전페이지 -->
						</c:if>
						<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
						<c:if test="${paging.curPage == p}">
						<li><a  class="pgn__num current"  href="adminList.do?page=${p}&brandname=${brandname}&keyword=${keyword}">${p}</a></li>
						</c:if>
						<c:if test="${paging.curPage != p}">
						<li><a  class="pgn__num" href="adminList.do?page=${p}&brandname=${brandname}&keyword=${keyword}" >${p}</a></li>
						</c:if>
						</c:forEach>
                        <c:if test="${paging.endPage != paging.lastPage}">
                        <li><a  class="pgn__next" href="adminList.do?page=${(page-1)-(page-1)%paging.perPageSet + paging.perPageSet + 1}&brandname=${brandname}&keyword=${keyword}"></a></li><!-- 다음페이지 -->
                        </c:if>
						</ul>
					</nav>
				</div>
			</div>
			
			
			<!-- end column large-full entry--> </main>
			</div>
			</article>

			<!-- Java Script
    ================================================== -->
			<script src="js/jquery-3.2.1.min.js"></script>
			<script src="js/plugins.js"></script>
			<script src="js/main.js"></script>
</body>