<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 입력 화면</title>
</head>
<body>

<a href="control.jsp?action=list">메인으로 돌아가기</a>
<hr>
<form action="control.jsp" method="post" name="form1">
<input type="hidden" name="action" value="insert">
<table border="1"> <!--   인자 파라미터 인수 인풋 입력값 매개변수 -> 4개 보냄 -->
   <tr>
      <td>작성자</td>
      <td><input type="text" name="writer"></td>
   </tr>
   <tr>
      <td>제목</td>
      <td><input type="text" name="title"></td>
   </tr>
   <tr>
      <td>내용</td>
      <td><input type="text" name="content"></td>
   </tr>
   <tr>
      <td colspan='2'><input type="submit" value="글 작성하기"></td>
   </tr>
</table>
</form>

</body>
</html>