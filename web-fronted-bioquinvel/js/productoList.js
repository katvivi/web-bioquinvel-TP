function retrieve(id){
    $("#txtIdProducto").val(id);//esta es la propia
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/producto/retrieve/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);    
            //La response contiene el objeto de tipo producto
            let producto = response;            
            $("#tblProductos").html(producto.nombre);
            $("#spCodigo").html(producto.codigo);
            $("#spNombre").html(producto.nombre);
            $("#spDescripcion").html(producto.descripcion);
            $("#spPrecio").html(producto.precio);
            //Setter
            //let valor = $("#txtIdproducto").val(); //Getter
		},
		error : function(err){
			console.error(err);
		}
    });
}

function show(list){ 
    $("#tblProductos").empty(); //Eliminar el contenido del tbody de la tabla
    list.forEach(producto => {        
        $("#tblProductos").append('<tr>'            
            + '<td>' + producto.nombre +'</td>'
            + '<td>' + producto.codigo +'</td>'
            + '<td>' + producto.descripcion +'</td>'
            + '<td>' + producto.precio +'</td>'            
            //Boton de consultar
            + '<td>'
            + '<button onclick="retrieve('+ producto.idProducto +')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#mdProductos">Consultar</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/producto/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);
            //response trae la lista de productoes como un Arreglo JSON
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
    let id = $("#txtIdProducto").val();
    console.log("hola",id);
    $.ajax({        
        type: "DELETE", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/producto/delete/"+id , //Dirección para realizar la petición HTTP   

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