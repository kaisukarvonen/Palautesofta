<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<http auto-config="false" disable-url-rewriting="true"/>
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
		
		
	<a href="kyselytsisalto.json">JSON response</a>
	<div id="listaaKyselyt"></div>
 	
 	<form id="lisaaVastausForm">
 	
 	<h4><div id="kysymys1">Kysymys</div></h4>
      <label for="vastaus">Vastaus: </label><br>
      <input type="text" name="vastaus" id="vastaus1"/>
      <br><br>
      <input type="submit" value="Lisää vastaus"/>
      
      </form>
      <br><br>
 	</div>
 </div>
</div>

 
<script>
$.getJSON("kyselytsimple.json", function (json) {
		var list = [];
		$.each(json, function(key, value){
	       list.push(value.kyselyn_nimi + "<br>");
	    });
		$("#listaaKyselyt").append(list);
});

$.getJSON("kysymysLista.json", function (object) {
	var kysymysmra = 0;
	var kysymysNimet = [];
	$.each(object, function(key, value){
		kysymysmra++;
		kysymysNimet.push(value.arvo);
	});
	console.log(kysymysNimet);
	/* fronttihommaa...
       kuinka monta diviä löytyy nimellä kysymys kuinka monta kysymysta tietokannasta
       jos divejä vähemmän, lisää erotus
       metodit: laske kysymys-divit, laske kysymysLista oliot, jos erisuuri */
});





$(document).ready(function() { 
	$('#lisaaVastausForm').submit(function(e) {
        $.post('${pageContext.request.contextPath}/lisaaVastaus', 
        		$(this).serialize(), function(response) {
          });
          /*e.preventDefault(); // prevent actual form submit and page reload
          prevent form post javascript
          submit --> onclick*/
	});
});
</script>
 
</body>
</html>