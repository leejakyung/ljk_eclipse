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
    <title>SHUMONS</title>
    <link rel="SHOMONS icon" href="images/user.ico"> 
    <script type="text/javascript">
	function logout() {
		if (confirm("정말로 로그아웃 하시겠습니까?") == true) {
			location.href = "logout.do";
		} else {
			return;
		}
	}
	
	function sfunction(){
		document.getElementById('styleform').submit();
	}
	
	function mUP(){
		document.getElementById('mUpdate').submit();
	}
	
	function showInput(index){
		$("#input_"+index).css('display','');
		$("#updateButton_"+index).css('display','');
		$("#cancleButton_"+index).css('display','');
		$("#text_"+index).css('display','none');
		$("#showInputButton_"+index).css('display','none');
	}

	function editCancle(index){
		$("#input_"+index).css('display','none');
		$("#updateButton_"+index).css('display','none');
		$("#cancleButton_"+index).css('display','none'); //add
		$("#text_"+index).css('display',''); //remove
		$("#showInputButton_"+index).css('display','');
	}
	
	function todoEditDB(index){ 
		var msg = $("#input_"+index).val().replaceAll("??", "⁇").replaceAll("&","＆").replaceAll("%","％")
		.replaceAll("+","＋").replaceAll("\\", "￦");
		var params = "content="+$("#input_"+index).val()+"&cnum="+index;

		$.ajax({
			type:"post",
			url:"updateTodo.do",
			data:params,
			dataType:"json",
			success:function(args){
				console.log(args);
				// console.log("성공했으면 소리질러!!");
				$('#text_'+index).css('display','');
				$('#showInputButton_'+index).css('display','');
				$('#cancleButton_'+index).css('display','none');
				$('#input_'+index).css('display','none');
				$('#updateButton_'+index).css('display','none');
				
				var v=args[0].name;
				console.log("성공했으면 소리질러!!"+v);
				$("#text_"+index).text(args[0].name); //보여지는 화면에서도 바꿔줄 수 있도록 !! controller랑 같이 볼 것
			}
		})
	}
	function deleteTodoDB(index){ 
		var params = "cnum="+index;
		$.ajax({
			type:"post",
			url:"deleteTodo.do",
			data:params,
			dataType:"json",
			success:function(data){
				var todoSet = document.querySelector("#todoSet_"+index);
				todoSet.remove();
			}
		})

	}
	function favart(){ // 찜 
		console.log("in");
		 $.ajax({
			url : 'mineIns.do',
			type : 'POST',
			data : 'email=${seUser.email}&spk=${data.spk}',
			success : function(result){
				console.log(result);
				
				if(result=='addSuccess'){
					$('#favImg').attr('src','images/RED.png');
					
				}
				else if(result=='delSuccess'){
					$('#favImg').attr('src','images/BLACK.png');
					
				}
				else{
					alert('잘못된 요청입니다');
				}
			}
		}); 
	}	
	
	window.onload=function(){
		$.ajax({
			url : 'checkMine.do',
			type : 'POST',
			data : 'spk=${data.spk}&email=${seUser.email}',
			success : function(result){
				if(result=='true'){
					$('#favImg').attr('src','images/RED.png');
				}
				return
			}
		});
	}
	
	/* .css('visibility','hidden')
	.css('visibility','') //remove */
	
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
        <mytag:mainMenu />

        <!-- site content
        ================================================== -->
        <div class="s-content content">
            <main class="row content__page">
                
                <article class="column large-full entry format-standard">

  

                   

                    <div class="entry__content">
                      

                        <div style="width: 500px; height: 500px;">
                        <img src="${data.filename}"  alt="신발 이미지"> 
                        </div>

						<c:choose> 
						<c:when test="${seUser==null}">
						<h2>${data.sname}&nbsp;&nbsp;<img alt="찜" src="images/BLACK.png" style="margin: auto;"></h2>
						</c:when>
						
						<c:when test="${edata!=null}">
                        <h2>${data.sname}&nbsp;&nbsp;<button style="padding: 0; margin: 0; line-height: 0; height: 0; border: none; background-color:  white;" onClick="favart()"><img alt="찜" id="favImg" src="images/RED.png" style="margin: auto;"></button></h2>
    					</c:when>
    					
    					<c:when test="${edata==null}">
                        <h2>${data.sname}&nbsp;&nbsp;<button style="padding: 0; margin: 0; line-height: 0; height: 0; border: none; background-color:  white;" onClick="favart()"><img alt="찜" id="favImg" src="images/BLACK.png" style="margin: auto;"></button></h2>
    					</c:when>
    					
    					</c:choose> 
    					
    					
    					
                        <blockquote>
                            <p>
                            ${data.brandname}<br>
                            ${data.spk}<br>
                            ${data.price}원<br>
                            </p>
                            <cite>출시일 ${data.sdate}</cite>
                        </blockquote>
    		
        			</div> <!-- end s-content -->





				<div class="entry__related">


					<form action="stinsert.do" method="post" enctype="multipart/form-data" id="styleform" name="styleform">
					<p class="entry__tags"
						style="float: left; margin-top: unset; font-size: xx-large;">
						<span>Style</span> <span class="entry__tag-list"> <a href="#"
							onclick="sfunction()" style="font-size: 1.2rem;">+사진 올리기</a>
						</span>

					</p>

					<!-- <h3 class="h2" style="float: left;">Style</h3> -->
					
						<input type="hidden" value="${data.spk}" name="spk"> <input
							type="hidden" value="${seUser.email}" name="email"> <input
							type="file" name="fileUpload"
							style="font-size: small; font-weight: 800; float: right; margin-top: 2em;">
				
					</form>
				
				</div>
				<!-- end entry related -->


					<div class="entry__related" style="margin-top: 125px;">
				 		<ul class="related">
				 			<c:forEach var="v" items="${stdatas}">
                            <li class="related__item">
                               <!--  <a href="single-standard.html" class="related__link">
                                    <img src="images/thumbs/masonry/walk-600.jpg" alt="">
                                </a> -->
                                <c:if test="${v.email==seUser.email}">
								<a href="stdelete.do?spk=${data.spk}&snum=${v.snum}&filename=${v.filename}" class="related__link">
									<img style="position: absolute; z-index: 1;" alt="삭제 이미지"
									src="images/del.png">
								</a>
								</c:if>
							
	
							<a href="" class="related__link" style="width: 200px; height: 200px;">
								<img src="images/${v.filename}" alt="신발자랑하기 이미지">
							</a> 
                            </li>
                            </c:forEach>
                          
                    	 </ul>
                    </div>	 
                    
                    <a href="shoesList.do?spk=${data.spk}&scnt=${scnt+3}" class="related__link">
						<img  alt="삭제 이미지" src="images/more.png" style="margin-left: 45%;">
					</a>
					
                    

	
				
				
				
				
				
				<!-- end entry related -->
			</article> <!-- end column large-full entry-->

			


			<div class="row add-bottom">

				<div class="column large-full"  style="width: 47em;">

					<h3>Comment</h3>

					<div class="table-responsive">

						<table>
							<thead>
								<tr>
									<th>ID</th>
									<th>Comment</th>
									<th>date</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="v" items="${mdatas}">
									<tr style="font-size: 1.5rem; font-weight: 700;" id="todoSet_${v.cnum}">
										<th style="width: 15%">${v.userID}</th>
										<th style="width: 40%"><span id="text_${v.cnum}">${v.content}</span><input
											type="text" id="input_${v.cnum}"
											style="display: none;"><a
											href="javascript:void(0);" onclick="editCancle(${v.cnum})"
											id="cancleButton_${v.cnum}"
											style="display: none; float: right; margin: -50px; margin-right: 75px;">X</a></th>
										<th style="width: 20%">${v.cdate}</th>



										<c:if test="${v.userID==seUser.userID}">
											<%-- <td style="width: 25%; font-size: small; font-weight: unset;"><a class="btn-update" href="#" onclick="mUP()">수정</a>&nbsp;/&nbsp;<a href="mdelete.do?cnum=${v.cnum}&spk=${data.spk}">삭제</a></td>
											<td style="width: 25%; font-size: small; font-weight: unset;"><a class="btn-updateBtn" href="#" onclick="mUP()">수정완료</a>&nbsp;/&nbsp;<a href="mdelete.do?cnum=${v.cnum}&spk=${data.spk}">삭제</a></td> --%>

											<td>
												<!-- show input button --> <a href="javascript:void(0);"
												onclick="showInput(${v.cnum})"
												id="showInputButton_${v.cnum}"
												style="font-size: small; font-weight: 900;">수정</a> <!-- updateDB button -->
												<a href="javascript:void(0);"
												onclick="todoEditDB(${v.cnum})" id="updateButton_${v.cnum}"
												style="display: none; font-size: small; font-weight: 900;">수정완료</a>
											</td>
											<td><a href="javascript:void(0);"
												onclick="deleteTodoDB(${v.cnum})"
												id="deleteTodoButton_${v.cnum}"
												style="margin-left: -130px; font-size: small; font-weight: 900;">삭제</a></td>
										</c:if>



										<c:if test="${v.userID!=seUser.userID}">
											<td style="width: 25%; font-size: small; font-weight: unset;"></td>
											<td></td>
										</c:if>

									</tr>

								</c:forEach>

								<%-- <c:forEach var="v" items="${mdatas}">
					<tr id="todoSet_${v.cnum}">
						<td><span id="text_${v.cnum}">${v.content}</span><input
							type="text" id="input_${v.cnum}" class="noShow"> <a
							href="javascript:void(0);" onclick="editCancle(${v.cnum})"
							id="cancleButton_${v.cnum}" class="noShow">수정취소</a></td>
						<td>
							<!-- show input button --> <a href="javascript:void(0);"
							onclick="showInput(${v.cnum})"
							id="showInputButton_${v.cnum}">수정</a> <!-- updateDB button -->
							<a href="javascript:void(0);" onclick="todoEditDB(${v.cnum})"
							id="updateButton_${v.cnum}" class="noShow">수정완료</a>
						</td>
						<td><a href="javascript:void(0);"
							onclick="deleteTodoDB(${v.cnum})"
							id="deleteTodoButton_${v.cnum}">삭제</a></td>
						
					</tr>
				</c:forEach>
								 --%>
								
							</tbody>
						</table>

					</div>

				</div>

			</div>
			
			<!-- 댓글 페이징 처리  -->

			<div class="row">
				<div class="column large-full">
					<nav class="pgn">
						<ul>
						<c:if test="${paging.startPage != 1 }">
						<li><a  class="pgn__prev" href="shoesList.do?page=${(page-1)-(page-1)%paging.perPageSet - paging.perPageSet + 1}&spk=${data.spk}"></a></li><!-- 이전페이지 -->
						</c:if>
						<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
						<c:if test="${paging.curPage == p}">
						<li><a  class="pgn__num current"  href="shoesList.do?page=${p}&spk=${data.spk}">${p}</a></li>
						</c:if>
						<c:if test="${paging.curPage != p}">
						<li><a  class="pgn__num" href="shoesList.do?page=${p}&spk=${data.spk}" >${p}</a></li>
						</c:if>
						</c:forEach>
                        <c:if test="${paging.endPage != paging.lastPage}">
                        <li><a  class="pgn__next" href="shoesList.do?page=${(page-1)-(page-1)%paging.perPageSet + paging.perPageSet + 1}&spk=${data.spk}"></a></li><!-- 다음페이지 -->
                        </c:if>
						</ul>
					</nav>
				</div>
			</div>
			
		
			<!-- end row -->

			<div class="column large-12 comment-respond">

				<!-- START respond -->
				<div id="respond" style="margin-left: -30px">

					<form action="minsert.do" method="post">
						<input type="hidden" value="${data.spk}" name="spk">
						<input type="hidden" value="${seUser.userID}" name="userID">
						<c:if test="${seUser!=null}">
						<label for="exampleMessage">Message</label>
						<input type="text" class="full-width" placeholder="Your message"
							id="exampleMessage" name="content" style="width: 100%">
							<input class="btn full-width" type="submit" value="add comment">
						</c:if>
						<c:if test="${seUser==null}">
							<label for="exampleMessage">Message</label>
						<input type="text" class="full-width" placeholder="Your message"
							id="exampleMessage" name="content" style="width: 100%">
							<input class="btn full-width" type="button" value="add comment" onclick="location.href='login.jsp'">
						</c:if>
					</form>
					

				</div>
				<!-- END respond-->

			</div>
			<!-- end comment-respond -->
            
                </div> <!-- end comments-wrap -->

   </div> <!-- end s-wrap -->

            </main>

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

 

    <!-- Java Script
    ================================================== -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script>

</body>