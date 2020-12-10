<%@page import="shop.dongguktime.web.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>

<%
	String name = (String) session.getAttribute("name");
%>

<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>yechan's</title>
    
    <style>
    html, body    {
     min-width : 1024px;
    }
    
    
    body{
	  -webkit-background-size: cover;
	  -moz-background-size: cover;
	  background-size: cover;
	  -o-background-size: cover;
    
    }
    
    .navbar{
	    padding-left: 50px;
	    padding-right: 50px;
    }
    
 
    </style>
    
    
  </head>
  
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="height:60px;">
  <!-- Brand -->
  <a class="navbar-brand" href="mainView.jsp">Home</a>

  <!-- Links -->
  <ul class="navbar-nav ">
  
    <li class = "nav-item">
      <a class="nav-link" href="boardListView.do?bType=1">자유게시판</a>
    </li>

	<li class = "nav-item">
      <a class="nav-link" href="boardListView.do?bType=2">익명게시판</a>
    </li>
    
    <li class = "nav-item">
      <a class="nav-link" href="boardListView.do?bType=3">장터게시판</a>
    </li>
	    
 
    <li class = "nav-item">
      <a class="nav-link" href="timetableView.do">시간표</a>
    </li>
    

    
  
  </ul>
  

  
  <% if(name != null){ %>
	<ul class = "navbar-nav ml-auto">	
	<div class="btn-group">
	<button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"><%= name%> 님</button>
	<div class="dropdown-menu">
      <a class="dropdown-item" href="messageListView.jsp">쪽지함</a>
      <a class="dropdown-item" href="logout.do">로그아웃</a>
      
     
    </div>
    </div>
	</ul>
  <% }
  	else {
   %>
   <script>
   location.href="loginView.jsp";
   </script>
    <%
   }
	%>
	
</nav>
  
  
<body>


<div class ="container" style="padding:50px;">
	<div class="row">
		<table class="table" style="text-align: center
		; border : 1px solid #dddddd ; border-radius : 30px;">
		
			<thead>
				<tr class = "thead-light"style = "font-size : 0.8rem;">
					<th style="background-color: #eeeeee; text-align:center;min-width:80px; width:80px; ">번호</th>
					<th style="background-color: #eeeeee; text-align:left; ">제목</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px">작성자</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px;">작성일</th> 
				</tr>
			</thead>
			
			<tbody>
				<%	
					ArrayList<BoardDTO> dtos = (ArrayList<BoardDTO>)request.getAttribute("dtos");
					for(int i = 0; i < dtos.size() ; i++){	
				%>
					<tr>
						<td style = "font-size : 0.8rem;"><%=dtos.size()-i%></td>
						<td style = "text-align:left;"><a href="boardView.jsp?bNum=<%=dtos.get(i).getbNum()%>" style = "color:gray;">
								<%=dtos.get(i).getbTitle()%></a>&nbsp;
						</td>
						<td style = "font-size : 0.8rem;">익명</td>
						<td style = "font-size : 0.8rem;"><%=dtos.get(i).getbDate().getYear()+1900%>.<%=dtos.get(i).getbDate().getMonth()+1%>.<%=dtos.get(i).getbDate().getDate()%></td>
					</tr>
				<% 
					}
				%>
					
				</tbody>
		</table>
		
		<a href = "boardInsertView.jsp?bType=<%=request.getParameter("bType")%>" class ="btn btn-secondary ml-auto">글쓰기</a>
	</div>
</div>



    	

</body>
</html>