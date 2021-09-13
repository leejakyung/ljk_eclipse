<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.message.*, java.util.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="memberVO" class="model.member.MemberVO" scope="session" />
<!DOCTYPE HTML>
<!--
	Stellar by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Stellar by HTML5 UP</title>
<script type="text/javascript">
	function check(mnum){
		writer=prompt("글 정보 변경을 위해 작성자명을 입력하시오.");
		document.location.href="control.jsp?action=edit&mnum="+mnum+"&writer="+writer;
	} //mnum 받고, writer 작성자명 입력후 받아서 2개
	
</script>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header" class="alt">
			<span class="logo"><img src="images/logo.svg" alt="" /></span>
			<h1>Stellar</h1>
			<p>
				Just another free, fully responsive site template<br /> built by <a
					href="https://twitter.com/ajlkn">@ajlkn</a> for <a
					href="https://html5up.net">HTML5 UP</a>.
			</p>
		</header>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="#intro" class="active">Introduction</a></li>
				<li><a href="#first">First Section</a></li>
				<li><a href="#second">Second Section</a></li>
				<li><a href="#cta">Get Started</a></li>
			</ul>
		</nav>

		<!-- Main -->
		<div id="main">

			<!-- Introduction -->
			<section id="intro" class="main">
				<div class="spotlight">
					<div class="content">
						<header class="major">
							<h2>게시판</h2>
						</header>
						<form action="control.jsp" method="post">
							<table border="1">
								<tr>
									<th>글번호</th>
									<th>제목</th>
									<th>내용</th>
									<th>작성일</th>
								</tr>
								<%
									// useBean class 속성에서 제네릭을 사용하지 않았기 때문에 캐스팅 필요!
									if (datas.size() == 0) {
								%>
								<tr>
									<td colspan="5" align="center">검색 결과가 없습니다.</td>
								</tr>
								<%
									} else {
										for (MessageVO vo : (ArrayList<MessageVO>) datas) {
								%>
								<tr>
									<!-- 글 번호 클릭 시 상세페이지로 이동 -->
									<!-- 파라미터로 edit과 mnum 넘겨주기 -->
									<%-- <td><a href="control.jsp?action=edit&mnum=<%=vo.getMnum()%>"><%=vo.getMnum()%></a></td> --%>
									<td><a href="javascript:check(<%=vo.getMnum()%>)"><%=vo.getMnum()%></a></td>
									<!-- 글 변경을 위한 비밀번호 확인 등의 인증작업 처리 필요! -->
									<td><%=vo.getTitle()%></td>
									<td><%=vo.getContent() %></td>
									<td><%=vo.getWdate()%></td>
								</tr>
								<%
									}
									}
								%>
								<tr>
									<td colspan="4" align="right"><a href="form.jsp">글쓰기</a></td>
								</tr>
							</table>
							<br>
							<form action="control.jsp" method="post" name="form1">
								<input type="hidden" name="action" value="logout"> <input
									type="submit" value="로그아웃">
							</form>
					</div>
					<span class="image"><img src="images/pororo.png"
						alt="티모 아이콘" /></span>
				</div>
			</section>
			<!-- Footer -->
			<footer id="footer">
				<section>
					<h2>Aliquam sed mauris</h2>
					<p>Sed lorem ipsum dolor sit amet et nullam consequat feugiat
						consequat magna adipiscing tempus etiam dolore veroeros. eget
						dapibus mauris. Cras aliquet, nisl ut viverra sollicitudin, ligula
						erat egestas velit, vitae tincidunt odio.</p>
					<ul class="actions">
						<li><a href="generic.html" class="button">Learn More</a></li>
					</ul>
				</section>
				<section>
					<h2>Etiam feugiat</h2>
					<dl class="alt">
						<dt>Address</dt>
						<dd>1234 Somewhere Road &bull; Nashville, TN 00000 &bull; USA</dd>
						<dt>Phone</dt>
						<dd>(000) 000-0000 x 0000</dd>
						<dt>Email</dt>
						<dd>
							<a href="#">information@untitled.tld</a>
						</dd>
					</dl>
					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter alt"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f alt"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-instagram alt"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-github alt"><span
								class="label">GitHub</span></a></li>
						<li><a href="#" class="icon brands fa-dribbble alt"><span
								class="label">Dribbble</span></a></li>
					</ul>
				</section>
				<p class="copyright">
					&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.
				</p>
			</footer>

		</div>

		<!-- Scripts -->
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/jquery.scrollex.min.js"></script>
		<script src="assets/js/jquery.scrolly.min.js"></script>
		<script src="assets/js/browser.min.js"></script>
		<script src="assets/js/breakpoints.min.js"></script>
		<script src="assets/js/util.js"></script>
		<script src="assets/js/main.js"></script>
</body>
</html>