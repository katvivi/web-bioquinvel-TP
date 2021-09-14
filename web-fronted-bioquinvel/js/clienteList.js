function retrieve(id){
    $("#txtIdCliente").val(id);//esta es
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/cliente/retrieve/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);    
            //La response contiene el objeto de tipo cliente
            let cliente = response;            
            $("#tblClientes").html(cliente.nombre);
            $("#spCodigo").html(cliente.codigoCliente);
            $("#spCedula").html(cliente.cedula);
            $("#spNombre").html(cliente.nombre);
            $("#spTelefono").html(cliente.telefono);
            $("#spEmail").html(cliente.email);
            //Setter
            //let valor = $("#txtIdCliente").val(); //Getter
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
            + '<td>' + cliente.codigoCliente +'</td>'
            + '<td>' + cliente.cedula +'</td>'
            + '<td>' + cliente.nombre +'</td>'
            + '<td>' + cliente.telefono +'</td>'  
            + '<td>' + cliente.email +'</td>'           
            //Boton de consultar
            + '<td>'
            + '<button onclick="retrieve('+ cliente.idcliente +')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#mdCliente">Consultar</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    console.log("Lista de Clientes");
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
    let id = $("#txtIdCliente").val();
    $.ajax({        
        type: "DELETE", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/cliente/delete/"+id , //Dirección para realizar la petición HTTP   

        contentType : "application/json",   
        crossDomain: true,     
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