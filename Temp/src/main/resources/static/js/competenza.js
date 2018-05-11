// competenza

$("#mostraform").click(function(){
	$.ajax({
		url: "candidato/candidati",
		success: function(risultato){
			$.each(risultato,function(i,item){
				"<select id='ddlViewBy'>"+
			  	"<option value="">"+ item.nome +"</option>"+
			  	"</select>"
			});
		}
	});
});