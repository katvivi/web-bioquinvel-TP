function retrieve(id){
        
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/cliente/retrieve/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);    
            //La response contiene el objeto de tipo cliente
            let cliente = response;            
            $("#lblNombre").html(cliente.nombre);
            $("#spCiudad").html(cliente.ciudad);
            $("#spDireccion").html(cliente.direccion);
            $("#spPostal").html(cliente.codigoPostal);
            $("#txtIdcliente").val(cliente.idcliente); //Setter
            //let valor = $("#txtIdcliente").val(); //Getter
		},
		error : function(err){
			console.error(err);
		}
    });
}

function show(list){ 
    $("#tblClientes").empty(); //Eliminar el contenido del tbody de la tabla
    list.forEach(cliente => {        
        $("#tblClientes").append('<tr>'            
            + '<td>' + cliente.cedula +'</td>'
            + '<td>' + cliente.nombre +'</td>'
            + '<td>' + cliente.telefono +'</td>'
            + '<td>' + cliente.emailCliente +'</td>'
                        
            //Boton de consultar
            + '<td>'
            + '<button onclick="retrieve('+ cliente.idcliente +')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#mdcliente">Direccion</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/cliente/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);
            //response trae la lista de clientees como un Arreglo JSON
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
    let id = $("#txtIdcliente").val();
    $.ajax({        
        type: "DELETE", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/cliente/delete/" + id, //Dirección para realizar la petición HTTP        
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