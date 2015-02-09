



$(window).load(function() {
	$(".loader").fadeOut("slow");

})

function lonading(){
	
	$(".loader").fadeIn("slow");
}

function fechar(){
	alert("fechar");
	$(".loader").fadeOut("slow");
	console.log("teste")
}