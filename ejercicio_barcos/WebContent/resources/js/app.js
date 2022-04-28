window.addEventListener('load',function(){
	document.getElementById("formulario").style.display = "none";
	document.getElementById("addType").style.display = "none";
	document.getElementById("addClass").style.display = "none";
	let botonesEditar = document.getElementsByClassName("botonEditar");
	for (let i=0;i<botonesEditar.length;i++){
		botonesEditar[i].addEventListener('click', function(e){
			let barcoString = e.target.value.replace(/'/g,'"');
			let barco = JSON.parse(barcoString);
			document.getElementById("id_editar").value = barco.id;
			document.getElementById("nombre_editar").value = barco.nombre;
			document.getElementById("tipo_editar").value = barco.tipo.id;
			document.getElementById("clase_editar").value = barco.clase.id;
			document.getElementById("fechaBotado_editar").value = barco.fechaBotado;
		},false)
	}
	document.getElementById("addBtn").addEventListener('click',function(){
		document.getElementById("formulario").style.display = "block";
	},false);
	document.getElementById("addTypeBtn").addEventListener('click',function(){
		document.getElementById("addType").style.display = "block";
	},false);
	document.getElementById("addClassBtn").addEventListener('click',function(){
		document.getElementById("addClass").style.display = "block";
	},false);	
},false);