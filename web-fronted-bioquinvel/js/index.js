$( document ).ready(function() {    

    $("#btnMain").click(function(){        
        $("#divMain").append("Hola mundo<br>");
    });

    $("#btnDanger").click(function(){        
        $("#divMain").removeClass('alert alert-info');        
        $("#divMain").addClass('alert alert-danger');        
    });

    $("#btnInfo").click(function(){        
        $("#divMain").removeClass('alert alert-danger');        
        $("#divMain").addClass('alert alert-info');        
    });
});