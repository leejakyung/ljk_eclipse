<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>  
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>SHUMONS</title>
    <script type="text/javascript">
/*    function minsert() {
      if(insert.filename.value == ""){
         alert("사진파일을 추가해 주세요!");         
         return false;
      }
      else if(insert.title.value == ""){
         alert("제목을 입력해 주세요!")
         return false;
      }
      else if(insert.mdate.value == ""){
         alert("날짜를 입력해 주세요!")
         return false;
      }
      else if(insert.content.value == ""){
         alert("내용을 입력해 주세요!")
         return false;
      }
      
    if (confirm("게시물을 등록하시겠습니까?") == true) {
        document.insert.submit();
      } else {
         return;
      }
   }
   function Mupdate() {
      if (confirm("게시물을 수정하시겠습니까?") == true) {
         document.movie.submit();
      } else {
         return;
      }
   }
   function sdelete() {
      return confirm("게시물을 삭제하시겠습니까?");
   } */
   function logout(){
      if(confirm("정말로 로그아웃 하시겠습니까?")==true){
         location.href="logout.do";      
      }
      else{
         return;
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
            <main class="row s-styles">
                
                <!-- styles
                ================================================== -->
                <section id="styles" class="column large-full">
                    
              
                    
                    <div class="row">

                        <div class="column large-6 tab-full">

							<c:if test="${param.spk==null}">
                            	<h2 style="margin: revert;">File Upload</h2>
                            	<form action="sinsert.do" method="post" enctype="multipart/form-data">
                            	
                            	 <div>
								<p>
									<img src="images/tweety.jpg" alt="기본이미지 트위티" class="thumb">
								</p>
								
                                
								<div>
									<label for="sampleInput">파일업로드</label> 
									<input class="full-width" type="file" id="imageSelector" name="fileUpload" accept="image/jpeg, image/jpg, image/png" required>
								</div>
								<label for="sampleRecipientInput">브랜드</label>
                                    <div class="ss-custom-select">
                                        <select class="full-width" id="sampleRecipientInput" name="brandname">
                                            <option value="Nike">Nike</option>
                                            <option value="Jordan">Jordan</option>
                                            <option value="New Balance">New Balance</option>
                                        </select>
                                    </div>
                                </div>
                                <div>
                                    <label for="sampleInput">모델번호</label>
                                    <input class="full-width" type="text"  id="sampleInput"  name="spk" required>
                                </div>
                                <div>
                                    <label for="sampleInput">모델명</label>
                                    <input class="full-width" type="text"  id="sampleInput" name="sname" required>
                                </div>
                                <div>
                                    <label for="sampleInput">출시일</label>
                                    <input class="full-width" type="text"  id="sampleInput" name="sdate" required>
                                </div>
                                <div>
                                    <label for="sampleInput">가격</label>
                                    <input class="full-width" type="text"  id="sampleInput" name="price" required>
                                </div>
                                
                          
                                <input class="btn--primary full-width" type="submit" value="File-Upload">
                            
                            	</form>
                            </c:if> 
                            <c:if test="${param.spk!=null}">
                            	<h2 style="margin: revert;">File Edit</h2>
                            	<form action="supdate.do" method="post" enctype="multipart/form-data">
                            	<input type="hidden" value="${data.filename}" name="filename">
                            	
                                <div> 
								<p>
									<img src="${data.filename}" class="thumb">
								</p>

								<div>
									<label for="sampleInput">파일업로드</label> 
									<input class="full-width hidden_input" type="file" id="imageSelector" name="fileUpload" accept="image/jpeg, image/jpg, image/png">
								</div>
								<label for="sampleRecipientInput">브랜드</label>
                                    <div class="ss-custom-select">
                                        <select class="full-width" id="sampleRecipientInput" name="brandname">
											<option value="Nike">Nike</option>
											<option value="Jordan">Jordan</option>
											<option value="New Balance">New Balance</option>
										</select>
                                    </div>
                                </div>
                           
                                <div>
                                    <label for="sampleInput">모델번호</label>
                                    <input class="full-width" type="text"  id="sampleInput"  name="spk" value="${data.spk}" re required> 
                                </div>
                                <div>
                                    <label for="sampleInput">모델명</label>
                                    <input class="full-width" type="text"  id="sampleInput" name="sname" value="${data.sname}" required>
                                </div>
                                <div>
                                    <label for="sampleInput">출시일</label>
                                    <input class="full-width" type="text"  id="sampleInput" name="sdate" value="${data.sdate}" required>
                                </div>
                                <div>
                                    <label for="sampleInput">가격</label>
                                    <input class="full-width" type="text"  id="sampleInput" name="price" value="${data.price}" required>
                                </div>
                                
                                
                     
                                <input class="btn--primary full-width" type="submit" value="수정">             
                                <a class="btn btn--stroke full-width" href="sdelete.do?spk=${data.spk}&filename=${data.filename}">삭제</a>
                            </form>
                           </c:if>
                            
                            

                        </div>

                        

                    </div> <!-- end row -->

                </section> <!-- end styles -->

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
    <script src="js/upload.js"></script>
    

</body>