
$(document).on('click','#bottoneStato',(function(){
	$.ajax({
		url: "offerta/stato",
		success: function(result){
		    $("#div1").empty();

			$.each(result,function(i,item){
				document.getElementById("div1").innerHTML += "<br><br><table style='width:40%'><tr> <th>RUOLO</th> <th>STATO OFFERTA</th> <th>DIPARTIMENTO</th> <th>COMPETENZE</th> </tr>" +
						"<tr><td>" + item.ruolo +"</td><td>" + item.statoOfferta + "</td>" +
						"<td>" + item.dipartimento + "</td> <td><a id='"+i+"' class='linkDettaglio' href='offerta/offerte/"+item.idOfferta+"'>Clicca per le competenze</a></td></tr>" +
								"<input id='idOfferta'"+i+" type='hidden' value='"+ item.idOfferta + "'></input> " ;
			});
			
		}
		});
}));

document.getElementById("div1").innerHTML += "</table>"

$(document).on('click','.linkDettaglio', function(evt){
	evt.preventDefault();
    var href = this.href;
    var id = this.id;
    var idOfferta = $("#idOfferta"+ id).val();
    $("#newDiv").empty();
    $("#matchDiv").empty();
	$.ajax({
		url: href,
		success: function(result){
			
			console.log(result);
			
			 $("#newDiv").append("<input id='idOfferta' type='hidden' value='"+ idOfferta + "'></input>");
			
		    $("#newDiv").append("<br><tr><td>" + result.ruolo + " " +"</td><td>" 
		    		+ result.statoOfferta + " "+ "</td><td>" + result.dipartimento + " " + "</td><td>" )  
			
			$.each(result.competenze,function(i,item){ 
				$("#newDiv").append("<tr><td>" + item.categoria + " " + item.nome +  "</td></tr> " ) 
				});
		   
		    $("#newDiv").append("<p>inserisci il numero di candidati desiderati:</p><input id='nPag' type='number' >" +
					"</input><a class='linkMatch' href='offerta/matchN/"+result.idOfferta+"'>Clicca per eseguire il matching</a> <br>")
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
			$("#matchDiv").append("<table id='tabCandidato' style='width:50%'></table>");
			$("#tabCandidato").append("<tr id='titolo'><th>Nome</th><th>Cognome</th><th>Eta</th><th>Livello</th><th>Organizza Colloquio</th></tr>");
			
			 $.each(result,function(i,item){ 
				console.log(i);
				 $("#tabCandidato").append("<tr id='id"+i+"'><td id='nome'"+i+">" 
						 + item.candidato.nome + "</td> <td id='cognome'"+i+"> " + item.candidato.cognome + "</td> <td id='eta'"+i+">" + item.candidato.eta 
						 + "</td><td id='livello'"+i+">"+ item.contatore +"</td><td><a class='linkOrganizza' id='"+i+"' href='inter/allIntervistatori'>organizza un colloquio</a></td></tr>" +
						 		"<input id='idCandidato"+i+"' type='hidden' value='"+ item.candidato.idCandidato + "'></input> ");
				
			});
		}
	 
		});
	
});

$(document).on('click','.linkOrganizza', function(evt){
	$(".intervistatore").remove();
	evt.preventDefault();
    var href = this.href;
    var idRiga = this.id;
    console.log(href);
    console.log(idRiga);
	$.ajax({
		url: href,
		success: function(result){
			 $("#titolo").append("<th class='intervistatore'>Intervistatore</th>");
			 $("#id"+idRiga+"").append("<td  class='intervistatore'><select id='intervistatore' class='selectIntervistatori'></select></td>")
			 $("#titolo").append("<th class='intervistatore'>Dipartimento</th>");
			 $("#id"+idRiga+"").append("<td  class='intervistatore'><input id='dipartimento' type='text'></input></select></td>")
			 $("#titolo").append("<th class='intervistatore'>Data</th>");
			 $("#id"+idRiga+"").append("<td class='intervistatore'><input id='data' type='date'></input></td>")
			 $("#titolo").append("<th class='intervistatore'>Prenota</th>");
			 $("#id"+idRiga+"").append("<td id='prenota' class='intervistatore'><a class='linkPrenota' id='"+idRiga+"' href=''>prenota colloquio</a></td>")
			console.log(result);
			 console.log($("#intervistatore").val())
			$.each(result,function(i,item){ 
				 $(".selectIntervistatori").append("<option value='"+item.idIntervistatore+"'>"+item.nome+"</option>")
			});
		}
	 
		});
	
});

$(document).on('click','.linkPrenota', function(evt){
	evt.preventDefault();
    var href = this.href;
    var idRiga = this.id;
    var idIntervistatore = $("#intervistatore").val();
    var dipartimento = $("#dipartimento").val();
    var data = $('#data').val()
    var idCandidato = $("#idCandidato"+idRiga+"").val();
    var idOfferta = $("#idOfferta").val();
    var json = {dataOra:data,dipartimento:dipartimento,intervistatore:idIntervistatore,candidato:idCandidato,offerta:idOfferta};
    console.log(json);
    console.log(href);
    console.log(idRiga);
//	$.ajax({
//		url: href,
//		success: function(result){
//			
//		}
//	 
//		});
	
});