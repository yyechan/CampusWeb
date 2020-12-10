<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>

<%
	String name = (String) session.getAttribute("name");
	String id = (String) session.getAttribute("id");
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
    
    
   
     .btn-file{
            position: relative;
            overflow: hidden;
        }
     .btn-file input[type=file] {
            position: absolute;
            top: 0;
                right: 0;
            min-width: 100%;
            min-height: 100%;
            font-size: 100px;
            text-align: right;
            filter: alpha(opacity=0);
            opacity: 0;
            outline: none;
            background: ;
            cursor: inherit;
            display: block;
     }


 
    </style>
    
    
  </head>
  
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="height:60px;">
  <!-- Brand -->
  <a class="navbar-brand" href="index.jsp">Home</a>

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

<%
					request.setAttribute("bType", request.getParameter("bType"));
				%>

<div class ="container" style="padding : 50px;">
	<div class="row">
			<form action = "boardInsert.do" method = "post" style = "width : 100%" enctype="multipart/form-data">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd;">
					<thead>
						<tr>
							<td colspan="2"
								style="background-color: #eeeeee; text-align: center;">게시판
								글쓰기</td>
						</tr>

					</thead>
					
					<tbody>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 제목" name="bTitle" maxlength="50" required></td>
						</tr>	
						
						<tr>	
							<td><textarea type="text" class="form-control"
									placeholder="글 내용" name="bContent" style="height : 350px;" required></textarea>
							</td>
						</tr>

					</tbody>

					

				</table>
				
				<% 
					if(request.getParameter("bType").equals("3")){
				%>
					<span class="btn btn-secondary btn-file">
      					 파일추가 <input type="file" name ="file" >
					</span>


						
				<%		
					}
				%>
				
				<input type="hidden" name = "bId" value = "<%=id%>"> 
				<input type="hidden" name = "bType" value = "<%=request.getParameter("bType") %>">
				
				
				
				
				<button type="submit" class="btn btn-secondary" style="float: right;">작성</button>
				
				
				
			</form>



		</div>


</div>


    	

</body>
</html>