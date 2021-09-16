function retrieve(id){
        
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/adicional/retrieve/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);    
            let adicional = response;  
            $("#spCodigo").html(adicional.codigo);          
            $("#spAroma").html(adicional.aroma);
            $("#spColorante").html(adicional.colorante);
            $("#spVitamina").html(adicional.vitamina);            
            $("#txtIdAdicional").val(adicional.idAdicional);
            $("#tblDetalle").empty(); //Eliminar el contenido del tbody de la tabla
            adicional.formulas.forEach(detalle => {        
                $("#tblDetalle").append('<tr>'
                    + '<td>' + detalle.tipo +'</td>'
                    + '<td>' + detalle.descripcion +'</td>'            
                    +'</tr>');
            });
        },
		error : function(err){
			console.error(err);
		}
    });
}

function show(lista){ 
    $("#tblAdicional").empty(); //Eliminar el contenido del tbody de la tabla
    lista.forEach(adicional => {        
        $("#tblAdicional").append('<tr>'            
            + '<td>' + adicional.codigo +'</td>'
            + '<td>' + adicional.aroma +'</td>'
            + '<td>' + adicional.colorante +'</td>'
            + '<td>' + adicional.vitamina +'</td>'            
            //Boton de eliminar
            + '<td>'
            + '<button onclick="retrieve('+ adicional.idAdicional +')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#mdAdicional">Consultar</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/adicional/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);
            show(response);
		},
		error : function(err){
			console.error(err);
		}        
    });
}

function del(){
    let id = $("#txtIdAdicional").val();
    $.ajax({        
        type: "DELETE", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/adicional/delete/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",        
        success : function(response){
            console.log(response);                            
		},
		error : function(err){
			console.error(err);
		}        
    });
}

$( document ).ready(function() {    
    list();
    $("#btnEliminar").click(function(){        
        del();
    });
});