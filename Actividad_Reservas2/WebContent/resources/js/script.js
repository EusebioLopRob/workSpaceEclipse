window.addEventListener("load",inicio,false)

function inicio(){
    document.getElementById("anadir").addEventListener("click",nuevaTabla,false)
	document.getElementById("guardar").addEventListener("click",enviar,false)
}

function nuevaTabla(){
	
	if(document.getElementById("tablaNuevoHotel").style.display=="none"){
        document.getElementById("tablaNuevoHotel").style.display = "block"
		document.getElementById("exito").style.display= "none";
		document.getElementById("error").style.display= "none";
    }else{
        document.getElementById("tablaNuevoHotel").style.display = "none"
    }
	
}

function enviar(){
	if(document.getElementById("tablaNuevoHotel").style.display=="block"){
		document.forms[0].submit();
		}
}
