function retrieve(id){
    $("#txtIdAdministrador").val(id);//esta es
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/administrador/retrieve/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);    
            //La response contiene el objeto de tipo administrador
            let administrador = response;            
            $("#tblAdministradores").html(administrador.nombre);
            $("#spCedula").html(administrador.cedula);
            $("#spNombre").html(administrador.nombre);
            $("#spTelefono").html(administrador.telefono);
            $("#spPasword").html(administrador.claveAdministrativo);
            $("#spEmail").html(administrador.emailAdmin);
            //Setter
            //let valor = $("#txtIdadministrador").val(); //Getter
		},
		error : function(err){
			console.error(err);
		}
    });
}

function show(list){ 
    $("#tblAdministradores").empty(); //Eliminar el contenido del tbody de la tabla
    list.forEach(administrador => {
        console.log(administrador);       
        $("#tblAdministradores").append('<tr>'          
            + '<td>' + administrador.cedula +'</td>'
            + '<td>' + administrador.nombre +'</td>'
            + '<td>' + administrador.telefono +'</td>'
            + '<td>' + administrador.claveAdministrativo +'</td>'  
            + '<td>' + administrador.emailAdmin +'</td>'  
            //Boton de consultar
            + '<td>'
            + '<button onclick="retrieve('+ administrador.idAdministrativo +')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#mdAdministrador">Consultar</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    console.log("Lista");
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/administrador/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);
            //response trae la lista de administradores como un Arreglo JSON
            console.log("Lista de administradores");
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
    let id = $("#txtIdAdministrador").val();
    $.ajax({        
        type: "DELETE", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/administrador/delete/"+id , //Dirección para realizar la petición HTTP   

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