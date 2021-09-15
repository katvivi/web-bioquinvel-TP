function serializeForm() {
    let usuario = {
        "emailAdmin": $("#txtUsuario").val(),
        "claveAdministrativo": $("#txtPassword").val(),
    };
    return usuario;
}

function login() {
    var usuario = serializeForm();
    console.log(usuario);
    var requestBody = JSON.stringify(usuario);
    console.log(requestBody);
   
    $.ajax({
        type: "POST", 
        url: "http://localhost:8080/administrador/login", 
        data: requestBody,           
        contentType: "application/json",
        crossDomain: true,
        dataType: "json",
        complete: function (response) {
            if (response.status == 200)
                window.location.replace("productoForm.html");
            if (response.status == 401)
                alert("401 NOT AUTHORIZED");
            if (response.status == 404)
                alert("404 NOT FOUND");
            if(response.status ==500)
                alert("500 - Internal server error ");
        }
    });
}