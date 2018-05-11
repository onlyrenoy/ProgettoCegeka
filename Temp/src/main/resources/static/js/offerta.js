
$(document).on('click','#bottoneStato',(function(){
	$.ajax({
		url: "offerta/stato",
		success: function(result){
		    $("#div1").empty();

			$.each(result,function(i,item){
				document.getElementById("div1").innerHTML += "<br><br><table style='width:40%'><tr> <th>RUOLO</th> <th>STATO OFFERTA</th> <th>DIPARTIMENTO</th> <th>COMPETENZE</th> </tr>" +
						"<tr><td>" + item.ruolo +"</td><td>" + item.statoOfferta + "</td>" +
						"<td>" + item.dipartimento + "</td> <td><a class='linkDettaglio' href='offerta/offerte/"+item.idOfferta+"'>Clicca per le competenze</a></td></tr>" +
								"<input id='idOfferta' type='hidden' value='"+ item.idOfferta + "'></input> " ;
			});
			
		}
		});
}));

document.getElementById("div1").innerHTML += "</table>"

$(document).on('click','.linkDettaglio', function(evt){
	evt.preventDefault();
    var href = this.href;
    $("#newDiv").empty();
    $("#matchDiv").empty();
	$.ajax({
		url: href,
		success: function(result){
			
			console.log(result);
			
		    $("#newDiv").append("<div class='newDiv'> <br><tr><td>" + result.ruolo + " " +"</td><td>" 
		    		+ result.statoOfferta + " "+ "</td><td>" + result.dipartimento + " " + "</td><td>" )  
			
			$.each(result.competenze,function(i,item){ 
				$("#newDiv").append("<tr><td>" + item.categoria + " " + item.nome +  "</td></tr> " ) 
				});
		    $("#newDiv").append("<p>inserisci il numero di candidati desiderati:</p><input id='nPag' type='number' >" +
					"</input><a class='linkMatch' href='offerta/matchN/"+result.idOfferta+"'>Clicca per eseguire il matching</a> <br></div>")
		}
	 
		});
	
});

$(document).on('click','.linkMatch', function(evt){
	$("#matchDiv").empty();
	var pag = $('#nPag').val()
	console.log(pag);
	evt.preventDefault();
    var href = this.href + "/" + pag;
    console.log(href);
	$.ajax({
		url: href,
		success: function(result){
			
			 
			console.log(result);
			$.each(result,function(i,item){ 
				 $("#matchDiv").append("<tr><td>" + item.candidato.nome + " " + item.candidato.cognome + " " + item.candidato.eta + " livello: "+ item.contatore +"</td></tr>")
				
			});
		}
	 
		});
	
});

