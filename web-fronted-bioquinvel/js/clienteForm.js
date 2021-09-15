function set(cliente){
    $("#txtCedulaCliente").val(cliente.cedula);
    $("#txtNombreCliente").val(cliente.nombre);
    $("#txtTelefonoCliente").val(cliente.telefono);
    $("#txtEmailCliente").val(cliente.emailCliente);
    $("#txtCiudadCliente").val(cliente.ciudad);
    $("#txtDireccionCliente").val(cliente.direccionCliente);
    $("#txtPostalCliente").val(cliente.codigoPostal);
    $("#txtContCliente").val(cliente.claveCliente);
    $("#txtIdCliente").val(cliente.idcliente);
}

function serializeForm(){
    let cliente = {
        "cedula" : $("#txtCedulaCliente").val(),
        "nombre" : $("#txtNombreCliente").val(), 
        "telefono" : $("#txtTelefonoCliente").val(),  
        "email" : $("#txtEmailCliente").val(),
        "ciudad" : $("#txtCiudadCliente").val(),
        "direccionCliente" : $("#txtDireccionCliente").val(),
        "codigoPostal" : $("#txtPostalCliente").val(),
        "claveCliente" : $("#txtContCliente").val(),
        "idcliente" : $("#txtIdCliente").val()
    };
    return cliente;
}

function save(){
    //Crear el objeto
    var cliente = serializeForm();
    console.log(cliente);
    var requestBody = JSON.stringify(cliente);
    console.log(requestBody);
    //Utilizar jQuery AJAX para enviar al Backend
    if(cliente.idcliente == 0){
        $.ajax({        
            type: "POST", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/cliente/create", //Dirección para realizar la petición HTTP
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
        let id = cliente.idcliente;
        $.ajax({        
            type: "PUT", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/cliente/update/" + id, //Dirección para realizar la petición HTTP
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

    $('#frmCliente').on('submit', function() {
        var form = document.getElementById('frmCliente');
        var a = form.checkValidity();
        console.log(a);
        if(a){
            save();
        }
    });   
});