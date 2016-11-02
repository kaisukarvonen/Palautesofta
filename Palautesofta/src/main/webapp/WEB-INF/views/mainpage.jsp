<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>Palautesofta</title>
</head>
<body>
 
 
<h3>Palautesofta</h3>
 <div id="listaa"></div>
 
<script>
$.getJSON("vastaukset.json", function (data) { //mikä url? tämä ei toimi
	$("#listaa").append("f");
	console.log(data); //tulostaa Array [ Object, Object, Object, Object ]
});


</script>
 
 
</body>
</html>