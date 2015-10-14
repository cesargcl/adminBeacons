/**
 * 
 */

var ux = {
		
		showCustomerPromotion : function ( nameClient , promoDescription ) {
			$(".nombre").html( nameClient );
			$(".promocion").html( promoDescription );
			
			$("#iddle").fadeOut("fast",function(){
				$("#promo").fadeIn("fast").delay(15000).fadeOut("fast", function(){
					$("#iddle").fadeIn("fast");
				});
			});
			
		},
		
		controlError : function ( mensaje ) {
			alert(mensaje);
		},
		
		log : function ( mensaje ) {
			if ( console != undefined ) {
				console.log(mensaje);	
			}
		}
		
}

channel = new goog.appengine.Channel( tokenScreen );
socket 	= channel.open();

socket.onopen = function () {
	ux.log("Conexion abierta");
}

socket.onmessage = function ( message ) {
	try {
		var data = JSON.parse(message.data);
		ux.log(data);
		ux.showCustomerPromotion( data.nombreCliente, data.message );	
	} catch (err) {
		ux.log(err.message);
	}
}

socket.onerror = function ( err ) {
	ux.log( err );
}
socket.onclose = function () {
	ux.log( "conexion cerrada" );
}