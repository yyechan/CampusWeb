<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
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

<title>Insert title here</title>

<script>

function infoConfirm()
{
	if(my_js.id.value.length == 0) 	{
		alert("아이디는 필수사항 입니다.");
		my_js.id.focus();
		return;
	}
	
	if(my_js.id.value.length < 4) {
		alert("아이디는 4글자 이상입니다.");
		my_js.id.focus();
		return;	
		}
	if(my_js.pw.value.length == 0) 	{
		alert("비밀번호는 필수사항 입니다.");
		my_js.pw.focus();
		return;
		}

	if(my_js.pw.value != my_js.pw_check.value) {
		alert("비밀번호가 다릅니다.");
		my_js.pw_check.focus();
		return;
		}
	
	if(my_js.name.value.length == 0) {
		alert("이름은 필수 사항입니다.");
		my_js.name.focus();
		return;
		}
	
	if(my_js.eMail.value.length == 0) 	{
	alert("이메일은 필수 사항입니다.");
	my_js.eMail.focus();
	return;
	}
	
	document.my_js.submit();
	
}


</script>

<style>

html,body{
min-width : 1024px;
}

#head {
	text-align: center;
	margin-top: 30px;
}


 .navbar{
    
    padding-left: 50px;
    padding-right: 50px;
    }
    
.form-group input {
	
	width : 400px;
	margin : 0 auto;
}

.container {
	text-align : center;
	width : 600px;
	border: 1px solid #ccc;
    border-radius: 4px;
    margin : 0 auto;
    padding : 50px;
    
}


.form-group input {
width : 300px;
}

</style>



</head>

<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand -->
		<a class="navbar-brand" href="index.jsp">Home</a>
	</nav>

	
	<div id="head">
			<h1>회원 가입</h1>
		</div>

<div class = "container"> 

<form action="signup.do" class="was-validated" name ="my_js" method="post">
  <div class="form-group">
    <label >아이디:</label>
    <input type="text" class="form-control" placeholder="아이디를 입력해주세요" name="id" required>
  </div>
  
  <div class="form-group">
    <label for="pwd">비밀번호:</label>
    <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력해주세요" name="pw" required>
  </div>
  
  <div class="form-group">
  	<label>비밀번호 확인:</label>
  	<input type= "password" class="form-control" placeholder="비밀번호를 입력해주세요" name="pw_check" required>
  </div>
  
  <div class="form-group">
  	<label>이름:</label>
  	<input type= "text" class="form-control" placeholder="이름을 입력해주세요" name="name" required>
  </div>
  
  <div class="form-group">
  	<label>이메일:</label>
  	<input type= "text" class="form-control" placeholder="이메일을 입력해주세요" name="eMail" required>
  </div>
  
  
  <button type ="button" class="btn btn-secondary" onclick="infoConfirm();">회원가입</button>
  <button type ="button" class="btn btn-secondary" onclick="history.back();">취소</button>
</form>

</div>

</body>
</html>