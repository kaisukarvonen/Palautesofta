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
		
		
	<a href="kyselytsisalto.json">Kyselyt json-datana</a><br>
	<a href="kysymystyyppilista.json">Kysymystyypit</a><br><br>
	
	Kyselyjen nimet
	<div id="listaaKyselyt"></div>
 	
 	
 	
 	<h4><div id="kysymys1">Minkä arvosanan antaisit kurssista?</div></h4>
	  <input type="radio" name="arvosana" value="hyva"> Hyvä<br>
	  <input type="radio" name="arvosana" value="keskiverto"> Keskiverto<br>
	  <input type="radio" name="arvosana" value="huono"> Huono
      <br><br>
      <input type="button" id="lisaaVastaus" value="Lisää vastaus"/>
      
      
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



$(document).ready(function() { 
	$('#lisaaVastaus').click(function() {
		var valinta = $('input[name="arvosana"]:checked').val();		
        //var kysymysId6 = {kysymys_id:6};
        var vastaus = {vastaus_arvo: valinta, kysymys_id:6};
        console.log(vastaus.vastaus_arvo + ", " + vastaus.kysymys_id);
        
        $.ajax({
            url: '${pageContext.request.contextPath}/lisaaVastaus',
            type: 'POST',
            data: JSON.stringify(vastaus),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){
            	console.log("onnistui");
            },
            failure: function(errMsg) {
                console.log("failed");
            }
        });
		
        /*$.post('${pageContext.request.contextPath}/lisaaVastaus', 
        		$(this).serialize(), function(response) {
          });
          e.preventDefault(); // prevent actual form submit and page reload
          prevent form post javascript
          submit --> onclick*/
	});
});



</script>
 
</body>
</html>