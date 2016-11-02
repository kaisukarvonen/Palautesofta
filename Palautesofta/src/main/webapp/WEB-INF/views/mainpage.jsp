<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h1>Palautesofta</h1>
		<h3>Vastaukset: </h3>
			<div id="listaa"></div>
 	<br><br>
 	</div>
 </div>
</div>
 
<script>
$.getJSON("vastaukset.json", function (lista) {
		var list = [];
		$.each(lista, function(key, value){
	       list.push(value.kysymys + " "+value.nimi+"<br>");
	    });
		$("#listaa").append(list);
});


</script>
 
 
</body>
</html>