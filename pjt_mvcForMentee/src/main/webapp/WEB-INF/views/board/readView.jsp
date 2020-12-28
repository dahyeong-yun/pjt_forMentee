<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>게시판</title>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
				<form role="form" method="post" name="readForm">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="bno">글 번호</label><input type="text" id="bno" name="brd_no" value="${read.brd_no}" readonly="readonly"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="brd_title" value="${read.brd_title}"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content" name="brd_content"><c:out value="${read.brd_content}" /></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label><input type="text" id="writer" name="brd_writer" value="${read.brd_writer}"  readonly="readonly"/>
								</td>
							</tr>
							<tr>
								<td>
									<label for="regdate">작성날짜</label>
									<fmt:formatDate value="${read.brd_created}" pattern="yyyy-MM-dd"/>					
								</td>
							</tr>		
						</tbody>			
					</table>
				</form>
				<div>
					<button type="submit" class="update_btn">수정</button>
					<button type="submit" class="delete_btn">삭제</button>
					<button type="submit" class="list_btn">목록</button>	
				</div>
			</section>
			<hr />
		</div>
		
		<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			console.log(formObj);
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/board/updateView");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				var deleteYN = confirm("삭제하시겠습니까?");
				if(deleteYN == true){
					
				formObj.attr("action", "/board/delete");
				formObj.attr("method", "post");
				formObj.submit();
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				location.href = "/board/list";
			})
		})
	</script>
	</body>
</html>