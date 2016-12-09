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
		
	<!--  -->	
	<a href="kyselytsisalto.json">Kyselyt json-datana</a><br>
	<a href="kysymystyyppilista.json">Kysymystyypit</a><br><br>
      
      <h4>Lisää uusi kysymys</h4>
      <b>Tyyppi:</b><br>
      <input type="radio" name="kysymystyyppi" value="avoin"> Avoin kysymys<br>
	  <input type="radio" name="kysymystyyppi" value="radiobutton"> Radiobutton<br>
	  <input type="radio" name="kysymystyyppi" value="skaala"> Skaala<br>
	  Vastausvaihtoehdot (erota pilkulla): <br><input type="text" id="vastausvaihtoehdot"/><br>
	  Kysymys:<br> <input type="text" id="uusi_kysymys1"/><br>
	  <input type="button" id="lisaaKysymys" value="Lisää kysymys"/>
	  
	  <br><br>
	  
	  <div id="ajaxMessage"></div><br><br>
	  
	  <a href="../j_spring_security_logout" >Kirjaudu ulos</a><br><br>
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



$(document).ready(function() { 
	
	$('#lisaaKysymys').click(function() {
		var kysymystyyppi = $('input[name="kysymystyyppi"]:checked').val();
		console.log(kysymystyyppi);
		var vaihtoehdot = $("#vastausvaihtoehdot").val();
		var uusiKysymysArvo = $("#uusi_kysymys1").val();
		console.log("kysymys_arvo: "+uusiKysymysArvo);
		var tyyppi = 0;
		if (kysymystyyppi == 'avoin') {
			tyyppi = 1;
			if (vaihtoehdot == "") {
				vaihtoehdot = "-";
			}
		} else if (kysymystyyppi == 'radiobutton') {
			tyyppi = 2;
		} else if (kysymystyyppi == 'skaala') {
			tyyppi = 3;
		}
		console.log(tyyppi);
        var uusiKysymys1 = {kysymys_arvo: uusiKysymysArvo, tyyppi_id:tyyppi, vastausvaihtoehdot:vaihtoehdot};

        
        $.ajax({
            url: '${pageContext.request.contextPath}/admin/lisaaKysymys',
            type: 'POST',
            data: JSON.stringify(uusiKysymys1),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){
            	$("#ajaxMessage").text("kysymyksen lisäys onnistui");
            },
            failure: function(errMsg) {
            	$("#ajaxMessage").text("kysymyksen lisäys epäonnistui");
            }
        });
	});
});

</script>
 
</body>
</html>