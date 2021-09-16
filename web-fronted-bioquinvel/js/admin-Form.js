function set(administrador){
    $("#txtCedulaAdmin").val(administrador.cedula);
    $("#txtNombreAdmin").val(administrador.nombre);
    $("#txtTelefonoAdmin").val(administrador.telefono);
    $("#txtEmailAdmin").val(administrador.emailAdmin);
    $("#txtPasword").val(administrador.claveAdministrativo);
    $("#txtIdAdministrador").val(administrador.idAdministrativo);
}

function serializeForm(){
    let administrador = {
        "cedula" : $("#txtCedulaAdmin").val(),
        "nombre" : $("#txtNombreAdmin").val(), 
        "telefono" : $("#txtTelefonoAdmin").val(),  
        "emailAdmin" : $("#txtEmailAdmin").val(),
        "claveAdministrativo" : $("#txtPasword").val(),
        "idAdministrativo" : $("#txtIdAdministrador").val()
    };
    return administrador;
}

function save(){
    //Crear el objeto
    var administrador = serializeForm();
    console.log(administrador);
    var requestBody = JSON.stringify(administrador);
    console.log(requestBody);
    //Utilizar jQuery AJAX para enviar al Backend
    if(administrador.idAdministrativo == 0){
        $.ajax({        
            type: "POST", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/administrador/create", //Dirección para realizar la petición HTTP
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
        let id = administrador.idAdministrativo;
        $.ajax({        
            type: "PUT", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/administrador/update/" + id, //Dirección para realizar la petición HTTP
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

    $('#frmAdministrador').on('submit', function() {
        var form = document.getElementById('frmAdministrador');
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