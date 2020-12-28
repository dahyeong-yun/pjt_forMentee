<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>게시판</title>
	</head>

	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<div>
				<%@include file="template/nav.jsp" %>
			</div>
			<hr />
			
			<section id="container">
				<form name="updateForm"  class="chk" role="form" method="post" action="/board/update">
					<input type="hidden" name="brd_no" value="${update.brd_no}" readonly="readonly"/>
					<table>
						<tbody>
							<tr>
								<td>
									<label for="title">제목</label><input type="text"  class="chk" id="title" name="brd_title" value="${update.brd_title}" title="제목을 입력하세요"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content"  class="chk" name="brd_content"><c:out value="${update.brd_content}"  /></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label><input type="text" class="chk"  id="writer" name="brd_writer" value="${update.brd_writer}" title="작성자를 입력하세요" readonly="readonly"/>
								</td>
							</tr>
							<tr>
								<td>
									<label for="regdate">작성날짜</label>
									<fmt:formatDate value="${update.brd_created}" pattern="yyyy-MM-dd"/>					
								</td>
							</tr>		
						</tbody>			
					</table>
					<div>
						<button type="button" class="update_btn">저장</button>
						<button type="button" class="cancel_btn">취소</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
		
<script type="text/javascript">
function fn_valiChk(){
	var updateForm = $("form[name='updateForm'] .chk").length;
	for(var i = 0; i<updateForm; i++){
		if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
			alert($(".chk").eq(i).attr("title"));
			return true;
		}
	}
}

$(document).ready(function(){
	var formObj = $("form[name='updateForm']");
	
	$(".cancel_btn").on("click", function(){
		event.preventDefault();
		location.href = "/board/list";
	})
	
	$(".update_btn").on("click", function(){
		if(fn_valiChk()){
			return false;
		}
		formObj.attr("action", "/board/update");
		formObj.attr("method", "post");
		formObj.submit();
	})
})
</script>
</body>
</html>