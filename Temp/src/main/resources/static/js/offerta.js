$("#bottoneStato").click(function(){
	$.ajax({
		url: "offerta/stato",
		success: function(result){
			
			$.each(result,function(i,item){
				document.getElementById("div1").innerHTML += "<p>" + item.ruolo +"," + item.statoOfferta + "," + item.dipartimento + "</p>";
			});
			
		}
		});
});