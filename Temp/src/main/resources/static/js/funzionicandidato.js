// lista di tutti i candidati

$("#listacandidati").click(function(){
	$.ajax({
		url: "candidato/candidati",
		success: function(risultato){
			$.each(risultato,function(i,item){
				document.getElementById("tuttiCandidati").innerHTML += "<br><tr> <td>" + item.idCandidato +"</td><td>" + item.nome + "</td> <td>" + item.cognome + "</td></tr><br>";
			});
		}
	});
});

//lista di tutti i candidati per cognome

$("#listapernome").click(function(){
	var nomel = document.getElementById("scrivinome").value;
	var url = "candidato/nome";
	var n = {nome:nomel}
	console.log(nome);
	$.ajax({
		url: url,
		data:n,
		success: function(risultato){
			$.each(risultato,function(i,item){
				document.getElementById("candidatipernome").innerHTML += "<br><tr> <td>" + item.idCandidato +"</td><td>" + item.nome + "</td> <td>" + item.cognome + "</td></tr><br>";
			});
		}
	});
});

// lista di tutti i candidati per cognome

$("#listapercognome").click(function(){
	var cognome = document.getElementById("scrivicognome").value;
	var url = "candidato/candidati/"+cognome;
	console.log(cognome);
	$.ajax({
		url: url,
		success: function(risultato){
			$.each(risultato,function(i,item){
				document.getElementById("candidatipercognome").innerHTML += "<br><tr> <td>" + item.idCandidato +"</td><td>" + item.nome + "</td> <td>" + item.cognome + "</td></tr><br>";
			});
		}
	});
});
//Ritorna candidato in base al cognome
$("#listapernome").click(function(){
	var cognome = document.getElementById("scrivinome").value;
	var url = "candidato/candidati/"+cognome;
	console.log(cognome);
	$.ajax({
		url: url,
		success: function(risultato){
			$.each(risultato,function(i,item){
				document.getElementById("candidatipernome").innerHTML += "<br><tr> <td>" + item.idCandidato +"</td><td>" + item.nome + "</td> <td>" + item.cognome + "</td></tr><br>";
			});
		}
	});
});
//Compare il form per creare il candidato
$(function(){
	  $('#cliccami').click(function(){
	 
	    if( $('#hide').css('display') == 'block' )
	       $('#hide').css('display','none');
	    else
	       $('#hide').css('display','block');
	 
	    return false;
	  });
	});

//Compare l'input text per creare il candidato
$(function(){
	  $('#mostraform').click(function(){
	 
	    if( $('#compe').css('display') == 'block' )
	       $('#compe').css('display','none');
	    else
	       $('#compe').css('display','block');
	 
	    return false;
	  });
	});



//registra un candidato
	$("#registra").submit(function(esito){
	esito.preventDefault();
	$("#registra").serialize();
	var cnome = document.getElementById("nome").value;
	var ccognome = document.getElementById("cognome").value;
	var ceta = document.getElementById("eta").value;
	var ccandidato = {nome:cnome, cognome:ccognome, eta:ceta};
	var url = "candidato/candidati/";
	
	console.log(JSON.stringify(ccandidato));
	$.ajax({
		url: url,
		contentType : "application/json",
		method : "post",
		data:JSON.stringify(ccandidato),
		success: function(risultato){
			
		console.log("registrato!");
				
			
		}
	});
	});