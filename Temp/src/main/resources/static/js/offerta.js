
$(document).on('click','#bottoneStato',(function(){
	$.ajax({
		url: "offerta/stato",
		success: function(result){
			
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
	$.ajax({
		url: href,
		success: function(result){
			
			console.log(result);
			
			document.getElementById("div1").innerHTML += "<br><tr><td>" + result.ruolo + " " +"</td><td>" 
			+ result.statoOfferta + " "+ "</td><td>" + result.dipartimento + " " + "</td><td>" 
			$.each(result.competenze,function(i,item){ 
				document.getElementById("div1").innerHTML += "<tr><td>" + item.categoria + " " + item.nome +  "</td></tr> " 
				});
			document.getElementById("div1").innerHTML += "<p>inserisci il numero di candidati desiderati:</p><input type='text' >" +
					"</input><a class='linkMatch' href='offerta/match/"+result.idOfferta+"'>Clicca per eseguire il matching</a> <br>"
		}
	 
		});
	
});

$(document).on('click','.linkMatch', function(evt){
	evt.preventDefault();
    var href = this.href;
    
    console.log(href);
	$.ajax({
		url: href,
		success: function(result){
			console.log("hello");
			console.log(result);
		}
	 
		});
	
});

