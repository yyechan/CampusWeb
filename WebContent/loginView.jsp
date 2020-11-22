<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	if (session.getAttribute("LoginSession") != null) {
%>
<jsp:forward page="index.jsp" />
<%
	}
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>yechan's</title>


<title>Insert title here</title>

<style>

html,body{
min-width : 1024px;
}

 .navbar{
   
    padding-left: 50px;
    padding-right: 50px;
    }

#head {
	text-align: center;
	margin-top: 30px;
}

#container {
	text-align: center;
	width : 600px;
	border: 1px solid #ccc;
    border-radius: 4px;
    margin : 0 auto;
    padding : 50px
    
}

.form-group input
{

width: 400px;
margin: auto;

}
</style>

</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

		<a class="navbar-brand" href="mainView.jsp">Home</a>

	</nav>



	<div id="wrap">


		<div id="head">
			<h1>로그인</h1>
		</div>


		<div id="container">


			<form action="login.do" class="was-validated" method ="post">
				<div class="form-group">
					<label >아이디:</label> 
					<input type="text" class="form-control" placeholder="Enter username" name="id" required
					value ="<%if (session.getAttribute("id") != null) out.println(session.getAttribute("id"));%>">
					<div class="valid-feedback"></div>
					<div class="invalid-feedback">아이디를 입력해 주세요.</div>
				</div>
				<div class="form-group">
					<label >비밀번호:</label>
					 <input type="password" class="form-control" placeholder="Enter password" name="pw" required>
					<div class="valid-feedback"></div>
					<div class="invalid-feedback">비밀번호를 입력해 주세요.</div>
				</div>
				
				<button type="submit" class="btn btn-secondary">로그인</button> &nbsp;&nbsp;
		
				<a href="signupView.jsp" class="btn btn-secondary" role="button">회원 가입</a>
			</form>





		</div>




	</div>

</body>
</html>