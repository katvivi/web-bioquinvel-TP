function load(){
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/producto/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){                             
            $("#txtFormula").empty();
            let productos = response;
            productos.forEach(producto => {
                $("#txtFormula").append("<option value=" + producto.idProducto + ">"+ producto.nombre + "</option>");        
    });                         
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

            //Detalle Formula

    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/adicional/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){                             
            $("#txtDetalle").empty();
            let adicional = response;
            adicional.forEach(adi => {
                $("#txtDetalle").append("<option value=" + adi.idAdicional + ">"+ adi.codigo + " - " + adi.aroma +"</option>");        
    });                         
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

function set(formula){
    console.log(formula);
    $("#lblNombreDetalle").html(formula.codigo);
    $("#txtDetalle").empty();
    formula.formulas.forEach(detalle => {        
        $("#txtDetalle").append("<option value=" + detalle.idDetalle + ">"+ detalle.tipo + "</option>");        
    }); 
}

function retrieve(){       
    let txtBuscar = $("#txtBuscar").val();
    if(txtBuscar === "") return;

    let id = parseInt(txtBuscar); //Transforma el txtBuscar en un número entero
    console.log(id);
    if(isNaN(id)){
        $.ajax({        
            type: "GET", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/adicional/retrieve?nombre=" + txtBuscar, //Dirección para realizar la petición HTTP        
            contentType : "application/json",
            dataType : "json",
            success : function(response){                 
                //El response contiene el objeto pedido consultado
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
            url: "http://localhost:8080/adicional/retrieve/" + id, //Dirección para realizar la petición HTTP        
            contentType : "application/json",
            dataType : "json",
            success : function(response){                
                //El response contiene el objeto pedido consultado
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
    let pedido = {
        "fechaPedido" : $("#txtFecha").val(),
        "tarjetas" : $("#txtAceptamos").val(),
        "calificacion" : $("#txtCantidad").val(),
        "producto" : {
            "idProducto" : $('#txtFormula').find(":selected").val()
        },
        "detalle" : {
            "idDetalle" : $('#txtDetalle').find(":selected").val()
        }
    };
    return pedido;
}

function save(){    
    //Creando el objeto
    var pedido = serializeForm();    
    var requestBody = JSON.stringify(pedido);
    console.log(requestBody);    
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "POST", 
        url: "http://localhost:8080/pedido/create", 
        data: requestBody, 
        contentType : "application/json",
        crossDomain: true,
        dataType: "json",
        success : function(response){
            console.log(response);  
            alert("Pedido Realizado");
		},
		error : function(err){
			console.error(err);
		}        
    });
}

$(function() {
    load();

    $('#frmPedido').on('submit', function() {
        var form = document.getElementById('frmPedido');                
        if(form.checkValidity()){
            save();                       
        }
    });
    
    $("#btnBuscar").click(function(){        
        retrieve();
    });    
    
});
