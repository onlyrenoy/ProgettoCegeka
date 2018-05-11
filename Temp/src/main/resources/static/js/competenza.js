// competenza
	
$("#mostraform").click(function(){
	$.ajax({
		url: "co/tuttecompetenze",
		success: function(risultato){
			
			$.each(risultato,function(i,item){
						
							var appendi = "<option value='item.nome'>"+ item.nome +"</option>";
							$('#ddlViewBy').append(appendi);
							
						  	console.log(item.nome);
						  	
							
						
				
			});
			
		}
	});
	
});
