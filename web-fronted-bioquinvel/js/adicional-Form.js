var detalles = [];

function serializeForm(){
    let adicional = {
        "codigo" : $("#txtCodigo").val(),
        "aroma" : $("#txtAroma").val(),
        "colorante" : $("#txtColorante").val(),
        "vitamina" : $("#txtVitamina").val(),           
        "formulas" : detalles
    };
    return adicional;
}

function save(){    
    //Creando el objeto
    var adicional = serializeForm();    
    var requestBody = JSON.stringify(adicional);
    console.log(requestBody);
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "POST", 
        url: "http://localhost:8080/adicional/create", 
        data: requestBody, 
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

function list(){
    $("#tblDetalle").empty(); //Eliminar el contenido del tbody de la tabla
    $("#txtDetalleFormula").empty();
    detalles.forEach(formula => {        
        $("#tblDetalle").append('<tr>'            
            + '<td>' + formula.tipo +'</td>'
            + '<td>' + formula.descripcion +'</td>'            
            //Boton de consultar
            + '<td>'
            + '<button onclick="remove('+ detalles.indexOf(formula) +')" type="button" class="btn btn-danger">Eliminar</button>'
            + '</td>'                        
        +'</tr>');
        $("#txtDetalleFormula").html(detalles);
    });
}

function remove(index){
    detalles.splice(index, 1);
    list();
}

function add(){
    let detalle = {
        "tipo" : $("#txtCodigo").val(),
        "descripcion" : $("#txtDescripcion").val(),
    }
    detalles.push(detalle);
    list();
}

$(function() {    
    $('#frmAdicional').on('submit', function() {
        var form = document.getElementById('frmAdicional');                
        if(form.checkValidity()){
            save();                       
        }
    });


    $("#btnAgregar").click(function(){        
        add();
    });
});
