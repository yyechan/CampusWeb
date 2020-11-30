<%@page import="java.net.URLEncoder"%>
<%@page import="shop.dongguktime.web.dao.TimeTableDAO"%>
<%@page import="shop.dongguktime.web.dto.TimeTableDTO"%>
<%@page import="java.util.ArrayList"%>
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
    
    th ,td{
   	 border:1px solid black ;
   	 text-align:center;
   	 width : 100px;
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
  
  
  
  <div class="search-bar" >
  	<ul style="    padding-inline-start: 20px;">
	  <form  action="search.do">
	  			<input  type="text"  name="pattern" style="margin-top:20px; border-radius: 5px; ">
	  			<button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
		</form>	
   </ul>
  </div>
  
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



<div style ="padding :100px; float : left;">
		<table style="width : 300px ;text-align: center ; border : 1px solid #dddddd ; border-radius : 30px;">
		
			<thead>
				<tr class = "thead-light" style = "font-size : 0.8rem;">
					<th style="background-color: #eeeeee; text-align:center;min-width:80px;">내 시간표</th>
				</tr>
			</thead>
			
			<tbody>
				<%	
					TimeTableDAO dao = TimeTableDAO.getInstance();
					ArrayList<TimeTableDTO> dtos = dao.getTimeTableFromId(id);
					
					
					
					for(int i = 0; i < dtos.size() ; i++){	
						
						String url = URLEncoder.encode(dtos.get(i).getTimeTableName());
						
				%>
					
					
					<tr>
						<td style = "text-align:center;"><a href="timetableView.do?timetableName=<%=url %>" style = "color:gray;">
								<%=dtos.get(i).getTimeTableName()%></a>&nbsp;
						</td>
					</tr>
				<% 
					}
				%>
				
			</tbody>
			

		</table>
		
		<a href = "timetableInsertView.jsp" class ="btn btn-secondary ml-auto" style = "margin-top : 10px; font-size : 0.8rem;">시간표 추가</a>
</div>
	
<div style ="padding : 100px;">
	<table style="border : 1px solid black;">
	
		<thead>
				<tr style ="font-size : 0.8rem;">
					<th style="background-color: #eeeeee; text-align:center; width:100px; width:80px;">교시</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px">월</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px;">화</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px">수</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px;">목</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px">금</th>
				</tr>
		</thead>	
			
			
			
		<tbody>
				
				<tr>
					<td>1.0</td>	<td>${MON1}</td>	<td>${TUE1}</td>	<td>${WED1}</td>	<td>${THU1}</td>	<td>${FRI1}</td>	
				</tr>
				
				<tr>
					<td>1.5</td>	<td>${MON2}</td>	<td>${TUE2}</td>	<td>${WED2}</td>	<td>${THU2}</td>	<td>${FRI2}</td>	
				</tr>
				
				<tr>
					<td>2.0</td>	<td>${MON3}</td>	<td>${TUE3}</td>	<td>${WED3}</td>	<td>${THU3}</td>	<td>${FRI3}</td>	
				</tr>
				
				<tr>
					<td>2.5</td>	<td>${MON4}</td>	<td>${TUE4}</td>	<td>${WED4}</td>	<td>${THU4}</td>	<td>${FRI4}</td>	
				</tr>
				
				<tr>
					<td>3.0</td>	<td>${MON5}</td>	<td>${TUE5}</td>	<td>${WED5}</td>	<td>${THU5}</td>	<td>${FRI5}</td>
				</tr>
				
				<tr>
					<td>3.5</td>	<td>${MON6}</td>	<td>${TUE6}</td>	<td>${WED6}</td>	<td>${THU6}</td>	<td>${FRI6}</td>	
				</tr>
				
				<tr>
					<td>4.0</td>	<td>${MON7}</td>	<td>${TUE7}</td>	<td>${WED7}</td>	<td>${THU7}</td>	<td>${FRI7}</td>	
				</tr>
				
				<tr>
					<td>4.5</td>	<td>${MON8}</td>	<td>${TUE8}</td>	<td>${WED8}</td>	<td>${THU8}</td>	<td>${FRI8}</td>	
				</tr>
				
				<tr>
					<td>5.0</td>	<td>${MON9}</td>	<td>${TUE9}</td>	<td>${WED9}</td>	<td>${THU9}</td>	<td>${FRI9}</td>	
				</tr>
				
				<tr>
					<td>5.5</td>	<td>${MON10}</td>	<td>${TUE10}</td>	<td>${WED10}</td>	<td>${THU10}</td>	<td>${FRI10}</td>	
				</tr>
				
				<tr>
					<td>6.0</td>	<td>${MON11}</td>	<td>${TUE11}</td>	<td>${WED11}</td>	<td>${THU11}</td>	<td>${FRI11}</td>	
				</tr>
				
				<tr>
					<td>6.5</td>	<td>${MON12}</td>	<td>${TUE12}</td>	<td>${WED12}</td>	<td>${THU12}</td>	<td>${FRI12}</td>	
				</tr>
		
				<tr>
					<td>7.0</td>	<td>${MON13}</td>	<td>${TUE13}</td>	<td>${WED13}</td>	<td>${THU13}</td>	<td>${FRI13}</td>	
				</tr>
				
				<tr>
					<td>7.5</td>	<td>${MON14}</td>	<td>${TUE14}</td>	<td>${WED14}</td>	<td>${THU14}</td>	<td>${FRI14}</td>	
				</tr>
				
				<tr>
					<td>8.0</td>	<td>${MON15}</td>	<td>${TUE15}</td>	<td>${WED15}</td>	<td>${THU15}</td>	<td>${FRI15}</td>	
				</tr>
				
				<tr>
					<td>8.5</td>	<td>${MON16}</td>	<td>${TUE16}</td>	<td>${WED16}</td>	<td>${THU16}</td>	<td>${FRI16}</td>	
				</tr>
				
				<tr>
					<td>9.0</td>	<td>${MON17}</td>	<td>${TUE17}</td>	<td>${WED17}</td>	<td>${THU17}</td>	<td>${FRI17}</td>	
				</tr>
				
				<tr>
					<td>9.5</td>	<td>${MON18}</td>	<td>${TUE18}</td>	<td>${WED18}</td>	<td>${THU18}</td>	<td>${FRI18}</td>	
				</tr>
				
				<tr>
					<td>10.0</td>	<td>${MON19}</td>	<td>${TUE19}</td>	<td>${WED19}</td>	<td>${THU19}</td>	<td>${FRI19}</td>	
				</tr>
				
				<tr>
					<td>10.5</td>	<td>${MON20}</td>	<td>${TUE20}</td>	<td>${WED20}</td>	<td>${THU20}</td>	<td>${FRI20}</td>	
				</tr>
		
				<tr>
					<td>11.0</td>	<td>${MON21}</td>	<td>${TUE21}</td>	<td>${WED21}</td>	<td>${THU21}</td>	<td>${FRI21}</td>	
				</tr>
				
				<tr>
					<td>11.5</td>	<td>${MON22}</td>	<td>${TUE22}</td>	<td>${WED22}</td>	<td>${THU22}</td>	<td>${FRI22}</td>	
				</tr>
				
				<tr>
					<td>12.0</td>	<td>${MON23}</td>	<td>${TUE23}</td>	<td>${WED23}</td>	<td>${THU23}</td>	<td>${FRI23}</td>	
				</tr>
				
				
		</tbody>
		
		
		
	</table>



</div>















    	

</body>
</html>