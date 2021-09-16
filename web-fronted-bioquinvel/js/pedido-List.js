function show(list){ 
    $("#tblPedido").empty(); //Eliminar el contenido del tbody de la tabla
    list.forEach(pedido => {        
        $("#tblPedido").append('<tr>'            
            + '<td>' + pedido.fechaPedido +'</td>'
            + '<td>' + pedido.tarjetas +'</td>'
            + '<td>' + pedido.producto.nombre +'</td>'
            + '<td>' + pedido.detalle.tipo +'</td>'
            + '<td>' + pedido.calificacion +'</td>'                                  
        +'</tr>');
    });
}

function list(){
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/pedido/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);
            //response trae la lista de variedades como un Arreglo JSON
            show(response);
		},
		error : function(err){
			console.error(err);
		},
        complete: function(xhr, textStatus) {            
            if(xhr.status == 404){
                alert(xhr.responseText);
            }
            if(xhr.status == 500){
                alert(xhr.responseText);
            }
        }       
    });
}

function del(){
    let id = $("#txtIdproducto").val();
    $.ajax({        
        type: "DELETE", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/pedido/delete/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",        
        success : function(response){
            console.log(response);                            
		},
		error : function(err){
			console.error(err);
		},
        complete : function(xhr, textStatus){
            if(xhr.status == 200)
            {
                alert(xhr.responseText);
                list();         
            }            
        }
    });
}

$( document ).ready(function() {    
    list();
    $("#btnEliminar").click(function(){        
        del();
    });
});