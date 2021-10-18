<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.message.*, java.util.*"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");

%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="session" />
<jsp:useBean id="memberVO" class="model.member.MemberVO" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 메인 화면</title>
<script type="text/javascript">
	function check(mnum, userID) {
		if (userID == '<%=memberVO.getUserID()%>')
	 {
			document.location.href = "control.jsp?action=edit&mnum=" + mnum;
		} else {
			alert("접근 권한이 없습니다!");
		}
	}
	/*
	function mylist() {
		document.form1.action.value = "mylist";
		document.form1.submit();
	}
	 */
</script>
</head>
<body>
	<h2>게시글</h2>
	<hr>

	<table>

		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>

		<%
									if (datas.size() == 0) {
										%>
		<tr>
			<td colspan="5" align="center">검색 결과가 없습니다.</td>
		</tr>
		<%
									} else {
										for (MessageVO vo : (ArrayList<MessageVO>) datas) { // useBean class 속성에서 제네릭을 사용하지 않았기 때문에 캐스팅 필요!
								%>
		<tr>
			<!-- 글 번호 클릭 시 상세페이지로 이동 -->
			<!-- 파라미터로 edit과 mnum 넘겨주기 -->
			<%-- <td><a href="control.jsp?action=edit&mnum=<%=vo.getMnum()%>"><%=vo.getMnum()%></a></td> --%>
			<td><%=vo.getMnum()%></td>
			<!-- 글 변경을 위한 비밀번호 확인 등의 인증작업 처리 필요! -->
			<td><a
				href="javascript:check(<%=vo.getMnum()%>,'<%=vo.getUserID()%>')"><%=vo.getTitle()%></a></td>
			<td><%=vo.getUserID()%></td>
			<td><%=vo.getWdate()%></td>
		</tr>
		<%
										}
									}
								%>

		</tbody>
	</table>
	<form action="control.jsp" name="form1">
		<input type="hidden" name="action" value="list">
		<table>
			<tr>
				<td><input type="text" name="search"></td>
				<td><input type="submit" value="검색"></td>
				<!-- <td><input type="button" name="myself" value="내 게시글" onclick="mylist()"></td> -->
				<td><input type="button" value="내 글보기" class="button"
					onclick="location.href='control.jsp?action=mylist'"></td>
				<td><input type="button" value="글쓰기" class="button"
					onclick="location.href='form.jsp'"></td>
			</tr>
		</table>
	</form>

	<mytag:logout />

	<a href="control.jsp?action=mypage">마이페이지</a>






</body>
</html>