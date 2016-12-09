<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<title>Palautesofta</title>
</head>
<style>
body {
	margin:60px 0 0 90px;
}
</style>
<body class="w3-light-grey">
 
<div class="w3-content w3-margin-top" style="max-width:1700px;">
 <div class="w3-twothird">
    <div class="w3-container w3-card-2 w3-white w3-margin-bottom">
		
		<form action="j_spring_security_check" method="post">
		Käyttäjätunnus<br>
		<input type='text' name='j_username' value=''><br><br>
		
		Salasana<br>
		<input type='password' name='j_password' /><br><br>
		
		<button type="submit" class="btn">Kirjaudu</button><br><br>
		</form>

		<c:if test="${not empty loginerror}">
			Käyttäjätunnus ja salasana eivät täsmää!
		</c:if>
	  
	  	<br><br>
 	</div>
 </div>
</div>

 
<script>

</script>
 
</body>
</html>