function set(producto){
    $("#txtCodigo").val(producto.codigo);
    $("#txtFormula").val(producto.nombre);
    $("#txtPrecio").val(producto.precio);
    $("#txtCantidad").val(producto.cantidad);
    
    $("#txtIdproducto").val(producto.idProducto);
}

function retrieve(){       
    let txtBuscar = $("#txtBuscar").val();
    if(txtBuscar === "") return;

    let id = parseInt(txtBuscar); //Transforma el txtBuscar en un número entero
    console.log(id);
    if(isNaN(id)){
        $.ajax({        
            type: "GET", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/producto/retrieve?nombre=" + txtBuscar, //Dirección para realizar la petición HTTP        
            contentType : "application/json",
            dataType : "json",
            success : function(response){
                console.log(response);    
                //El response contiene el objeto producto consultado
                set(response);                            
		    },
		    error : function(err){
			    console.error(err);
		    },
            complete : function(xhr, textStatus){
                if(xhr.status == 404)
                {
                    alert(xhr.responseText);                    
                }
            }
        });
    }
    else{
        $.ajax({        
            type: "GET", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/producto/retrieve/" + id, //Dirección para realizar la petición HTTP        
            contentType : "application/json",
            dataType : "json",
            success : function(response){
                console.log(response);    
                //El response contiene el objeto producto consultado
                set(response);                            
		    },
		    error : function(err){
			    console.error(err);
		    },
            complete : function(xhr, textStatus){
                if(xhr.status == 404)
                {
                    alert(xhr.responseText);                    
                }
            }
        });
    }
}

function serializeForm(){
    let producto = {
        "codigo" : $("#txtCodigo").val(),
        "nombre" : $("#txtFormula").val(),
        "precio" : $("#txtPrecio").val(), 
        "cantidad" : $("#txtCantidad").val(),       
        "idProducto" : $("#txtIdproducto").val()
        
    };
    return producto;
}

function save(){
    //Crear el objeto
    var producto = serializeForm();
    console.log(producto);
    var requestBody = JSON.stringify(producto);
    console.log(requestBody);
    //Utilizar jQuery AJAX para enviar al Backend
    if(producto.idproducto == 0){
        $.ajax({        
            type: "POST", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/producto/create", //Dirección para realizar la petición HTTP
            data: requestBody, //El contenido Body de la petición HTTP                
            contentType : "application/json",
            crossDomain: true,
            dataType: "json",
            success : function(response){
                console.log(response);                
		    },
		    error : function(err){
			    console.error(err);
		    }            
        });
    }
    else{
        //Update
        let id = producto.idProducto;
        $.ajax({        
            type: "PUT", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/producto/update/" + id, //Dirección para realizar la petición HTTP
            data: requestBody, //El contenido Body de la petición HTTP                
            contentType : "application/json",
            crossDomain: true,
            dataType: "json",
            success : function(response){
                console.log(response);             
		    },
		    error : function(err){
			    console.error(err);
		    }            
        });
    }
}

$(function() {       

    $('#frmproducto').on('submit', function() {
        var form = document.getElementById('frmproducto');
        var a = form.checkValidity();
        console.log(a);
        if(a){
            save();
        }
    });


    $("#btnBuscar").click(function(){        
        retrieve();
    });    
});
