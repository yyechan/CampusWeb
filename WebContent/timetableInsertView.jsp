<%@page import="shop.dongguktime.web.dto.ClassDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.dongguktime.web.dao.ClassDAO"%>
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
    
 
    </style>
    
    <script>
    
    	var cnt = 0;
    	
    	
    
    	function insert(classId) {
    		
    		cnt++;
    		
    		// table 또는 tbody 객체를 가져온다.
    		var clsTable = document.getElementById("mytable");
	
    		// table 또는 tbody 에 저장된 row 의 개수를 가져온다.
    		var iRowCount = clsTable.rows.length;

    		// table 또는 tbody 에 4개의 row 가 있다면 2 와 3 번째 사이에 
    		// 새로운 row 를 추가하고 싶으면 아래와 같이 호출한다.
    		// 맨 마지막에 row 를 추가하고 싶으면 iRowCount 를 입력한다.
    		var clsRow = clsTable.insertRow(iRowCount);

    		// 새로운 row 에 2개의 cell 을 추가한다.
    		var clsCell1 = clsRow.insertCell(0);
    		
    		// 각 cell 에 텍스트를 입력한다.
    		
    		
    		clsCell1.innerHTML = classId;
			
    		document.getElementById("str").value += classId+',';
    		
    		
    		
    	}
    
    
    </script>
    
    
    
    
    
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
	
	
	<%
		ClassDAO dao = ClassDAO.getInstance();
		ArrayList<ClassDTO> dtos;
		
		if(request.getParameter("pattern") == null){
			dtos = dao.getTimeTablesFromClassName("",false);
		}
		else {
			dtos = dao.getTimeTablesFromClassName(request.getParameter("pattern"),true);
		}
		
		ArrayList<ClassDTO> cla = new ArrayList<ClassDTO>();
		
		for(ClassDTO dto : dtos){
		
			
			
			boolean flag = false;
			
			for(ClassDTO c : cla) {
			
				if(c.getClassId().equals(dto.getClassId())){
				
					c.setClassDay(c.getClassDay()+","+dto.getClassDay());
					c.setClassLocation(c.getClassLocation() + "," + dto.getClassLocation());
					c.setStartTime(c.getStartTime()+","+ dto.getStartTime());
					c.setEndTime(c.getEndTime() + "," + dto.getEndTime());
					
					flag = true;
				}
				
			}
			
			if(flag == false){
				cla.add(dto);
			}
			
		}
			
	%>
	
<div style ="padding :50px; padding-left : 100px; float : left;">
		<table style="width : 300px ;text-align: center ; border : 1px solid #dddddd ; border-radius : 30px;">
		
			<thead>
				<tr class = "thead-light" style = "font-size : 0.8rem;">
					<th style="background-color: #eeeeee; text-align:center;min-width:80px;">담은 과목</th>
				</tr>
			</thead>
		
		
			<form action = "timetableInsert.do" method = "post">
				<tbody id="mytable">
						
		
				</tbody>
				
	
			</table>
			
				<input style="margin-top : 30px; border-radius: 3px;height:30px; border:solid 1px black;" type="text" name="timetableTitle" value="시간표 이름" />
				<input type="hidden" id="str" name="classIds" value = "">
				<input type="submit" class="btn btn-secondary ml-auto" style = " font-size : 0.8rem;" value="시간표 추가">
			</form>
</div>	
	
	
	
	
<div class ="container" style="padding:50px;">
	<div class="row">
		<table class="table" style="text-align: center ; border : 1px solid #dddddd ; border-radius : 30px;">
		
			<thead>
				<tr class = "thead-light"style = "font-size : 0.8rem;">
					<th style="background-color: #eeeeee; text-align:center;min-width:80px; width:80px; ">학수번호</th>
					<th style="background-color: #eeeeee; text-align:left; width : 200px ;">교과목명</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px">교원명</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px;">요일/시간</th>
					<th style="background-color: #eeeeee; text-align:center; width : 200px;">강의실</th> 
					<th style="background-color: #eeeeee; text-align:center; width : 100px;">학점</th>
					<th style="background-color: #eeeeee; text-align:center; width : 100px;"></th>
				</tr>
			</thead>
			
			<tbody>
				<%	
					
					for(int i = 0 ; i < cla.size() ; i++){
						
						String[] days = cla.get(i).getClassDay().split(",");
						String[] starts = cla.get(i).getStartTime().split(",");
						String[] ends = cla.get(i).getEndTime().split(",");
						
						
						String classTime = "";
					
						
						for(int j = 0 ; j < days.length ; j++){
							
							
							classTime += days[j] +" : "+ starts[j] +"-"+ ends[j];
	
							if(j+1 != days.length){
								classTime +=",";
							}
							
						}
						
				%>
					<tr>
						<td style = "font-size : 0.8rem;"><%=cla.get(i).getClassId()%></td>
						<td style = "text-align:left;">	<%=cla.get(i).getClassName()%>&nbsp;</td>
						<td style = "font-size : 0.8rem;">	<%=cla.get(i).getProfessorName()%></td>
						<td style = "font-size : 0.8rem;"><%=classTime%></td>
						<td style = "font-size : 0.8rem;"><%=cla.get(i).getClassLocation()%></td>
						<td style = "font-size : 0.8rem;"><%=cla.get(i).getClassScore() %></td>
						<td style = "font-size : 0.8rem;"><button class ="btn btn-secondary ml-auto" onclick="insert('<%= cla.get(i).getClassId()%>')"> 담기 </td>
					</tr>
					
				<% 
					}
				%>
					
				</tbody>
		</table>
		
	
	</div>
</div>
	
	
	
	
	





    	

</body>
</html>