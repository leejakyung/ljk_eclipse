<%-- <%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="uid" %>

<c:if test="${seUser == m.userID}">
	<input type="button" value="삭제" onclick="del(${m.mid},${mcnt})"> <!-- 스크립트에 받아온 인자를 넣어줌  -->
</c:if> --%>