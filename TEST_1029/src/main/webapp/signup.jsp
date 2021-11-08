<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!-- 회원가입 페이지 -->
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

<!--- basic page needs
    ================================================== -->
<meta charset="utf-8">
<title>SHUMONS</title>
<link rel="SHOMONS icon" href="images/user.ico">
<script type="text/javascript">
	function logout() {
		if (confirm("정말로 로그아웃 하시겠습니까?") == true) {
			location.href = "Logout.do";
		} else {
			return;
		}
	}
	function checkId() {
		$.ajax({
					type : "POST", // 단순 정보 조회 시에는 GET, 정보가 너무 많거나 insert/update를 할때는 POST
					url : "checkID.do", /////////// ???????
					data : {
						userID : $("#userID").val()
					// $().val() : 값 가져오기
					},
							  success: function(data) { 
						            if (data.trim()=="false") {
						            	var regId = /^[가-힣a-zA-Z]+$/;
										if (document.check.userID.value.match(regId) == null) { // 대소문자 및 숫자 입력가능
						                     $("#resultId").css("color","red");
						                     $("#resultId").css("margin-top","-30px");
						                     $("#resultId").css("margin-bottom","30px");
						                     $("#resultId").css("font-size","small");
						                     $("#resultId").text("닉네임은 영문, 한글만 입력가능합니다.");
						                     }
						                  else if (document.check.userID.value.length<1 || document.check.userID.value.length>4) {
						                     $("#resultId").css("color","red");
						                     $("#resultId").css("margin-top","-30px");
						                     $("#resultId").css("margin-bottom","30px");
						                     $("#resultId").css("font-size","small");
						                     $("#resultId").text("닉네임은 4자 이하로 입력해주세요.");
						                    }
						                  else{
						                     $("#resultId").css("color","green");
						                     $("#resultId").css("margin-top","-30px");
						                     $("#resultId").css("margin-bottom","30px");
						                     $("#resultId").css("font-size","small");
						                     $("#resultId").text("사용 가능한 닉네임입니다.");
						                  }
						               
						               
						               /* alert("사용 가능한 ID입니다."); */
						            } else {
						               $("#resultId").css("color","red");
						               $("#resultId").css("margin-top","-30px");
						               $("#resultId").css("margin-bottom","30px");
						               $("#resultId").css("font-size","small");
						               $("#resultId").text("이미 존재하는 닉네임입니다. 다시 입력하세요.");
						               /* alert("ID가 이미 존재합니다. 다시 입력하세요."); */
						            }
						         },
						         error: function(xhr) {
						            console.log(xhr.status + " : " + xhr.errorText);
						            alert("에러발생!");
						        }
				});
		
		
		
		
	}
	function checkEmail() {
		$.ajax({
					type : "POST", // 단순 정보 조회 시에는 GET, 정보가 너무 많거나 insert/update를 할때는 POST
					url : "checkEmail.do", /////////// ???????
					data : {
						email : $("#email").val()
					// $().val() : 값 가져오기
					},
							  success: function(data) { 
								  console.log(data);
						            if (data.trim()=="false") {
						            	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
						        		if (document.check.email.value.match(regExp) == null) {
						        			$("#resultEmail").css("color", "red");
						        			$("#resultEmail").css("margin-top", "-30px");
						        			$("#resultEmail").css("margin-bottom", "30px");
						        			$("#resultEmail").css("font-size", "small");
						        			$("#resultEmail").text("올바른 이메일 형식이 아닙니다.");
						        		} else{
						                	$("#resultEmail").css("color", "green");
						          			$("#resultEmail").css("margin-top", "-30px");
						          			$("#resultEmail").css("margin-bottom", "30px");
						          			$("#resultEmail").css("font-size", "small");
						          			$("#resultEmail").text("사용 가능한 이메일입니다.");
						                }
						               
						            } else {
						            	$("#resultEmail").css("color", "red");
						    			$("#resultEmail").css("margin-top", "-30px");
						    			$("#resultEmail").css("margin-bottom", "30px");
						    			$("#resultEmail").css("font-size", "small");
						    			$("#resultEmail").text("이미 존재하는 이메일입니다. 다시 입력하세요.");
						               /* alert("ID가 이미 존재합니다. 다시 입력하세요."); */
						            }
						         },
						         error: function(xhr) {
						            console.log(xhr.status + " : " + xhr.errorText);
						            alert("에러발생!");
						        }
				});
		
		
		
		
	}
	
	function checkPw1() {
		if (document.check.userPW.value.length<4 || document.check.userPW.value.length>12) {
			$("#resultPw1").css("color", "red");
			$("#resultPw1").css("margin-top", "-30px");
			$("#resultPw1").css("margin-bottom", "30px");
			$("#resultPw1").css("font-size", "small");
			$("#resultPw1").text("비밀번호를 4~12자까지 입력해주세요.");
		} else {
			$("#resultPw1").css("color", "green");
			$("#resultPw1").css("margin-top", "-30px");
			$("#resultPw1").css("margin-bottom", "30px");
			$("#resultPw1").css("font-size", "small");
			$("#resultPw1").text("사용 가능한 비밀번호 입니다.");
		}
	}
	function checkPw2() {
		if (document.check.pw1.value != document.check.userPW.value) {
			$("#resultPw2").css("color", "red");
			$("#resultPw2").css("margin-top", "-30px");
			$("#resultPw2").css("margin-bottom", "30px");
			$("#resultPw2").css("font-size", "small");
			$("#resultPw2").text("비밀번호가 일치하지 않습니다.");
		} else {
			$("#resultPw2").css("color", "green");
			$("#resultPw2").css("margin-top", "-30px");
			$("#resultPw2").css("margin-bottom", "30px");
			$("#resultPw2").css("font-size", "small");
			$("#resultPw2").text("비밀번호가 일치합니다.");
		}
	}
	function send() {
		// 아이디 유효성 검사(4~12글자)
		if (document.check.userID.value.length<1 || document.check.userID.value.length>4) {
			alert("닉네임을 1~4자까지 입력해주세요.")
			document.check.userID.focus();
			document.check.userID.select();
			return false;
		}
		
		// 비밀번호 유효성 검사(4~16자 까지 허용)
		if (document.check.userPW.value.length<4 || document.check.userPW.value.length>16) {
			alert("비밀번호를 4~16자까지 입력해주세요.")
			document.check.userPW.focus();
			document.check.userPW.select();
			return false;
		}
		// 비밀번호와 비밀번호 확인 일치여부 체크
		if (document.check.pw1.value != document.check.userPW.value) {
			alert("비밀번호가 일치하지 않습니다")
			document.check.pw1.value = ""
			document.check.pw1.focus();
			return false;
		}
		// 이메일 유효성 검사
		var regExp = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		if (document.check.email.value.match(regExp) == null) {
			alert('올바른 이메일 형식이 아닙니다.')
			document.check.email.value = ""
			document.check.email.focus();
			return false;
		}
		// 닉네임 유효성 검사
		var regId = /^[가-힣a-zA-Z]+$/;
		if (document.check.userID.value.match(regId) == null) {
			alert('닉네임은 영어와 한글만 사용 가능합니다.')
			document.check.userID.value = ""
			document.check.userID.focus();
			return false;
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

	<mytag:mainMenu />




	<div class="row" style="justify-content: center;">

		<div class="column large-6 tab-full" style="margin-top: 5em;">

			<h2 style="margin: revert;">SIGNUP</h2>

			<form action="signup.do" method="post" id="form1" name="check" onsubmit="return send();">
				<div>
					<label for="sampleInput">Your email</label> <input
						class="full-width" type="text" placeholder="이메일을 입력하세요."
						id="email" name="email" onkeyup="checkEmail()" required="required">
				</div>
				<p id="resultEmail"  style="margin-bottom: -5px;"><br></p>
				<div>
					<label for="sampleInput">Nickname</label> <input class="full-width"
						type="text" placeholder="닉네임을  입력하세요." id="userID" onkeyup="checkId()"
						name="userID" required="required">
				</div>
				<p id="resultId" style="margin-bottom: -5px;"><br></p>
				<div>
					<label for="sampleInput">Password</label> <input class="full-width"
						type="password" placeholder="비밀번호를 입력하세요." id="userPW" onkeyup="checkPw1()"
						name="userPW" required="required">
				</div>
				<p id="resultPw1"  style="margin-bottom: -5px;"><br></p>
				<div>
					<label for="sampleInput">Password check</label> <input
						class="full-width" type="password" placeholder="비밀번호 확인" id="pw1"
						onkeyup="checkPw2()" required="required">
				</div>
				  <p id="resultPw2"  style="margin-bottom: -5px;"><br></p>
				<input class="btn--primary full-width" type="submit" value="SignUp">
			</form>

		</div>







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