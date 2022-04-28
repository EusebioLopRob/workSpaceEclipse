window.addEventListener('load',function(){
	document.getElementById("formularioAdd").style.display = "none";
	document.getElementById("formularioEdit").style.display = "none";
	let botonesEditar = document.getElementsByClassName("botonEditar");
	for (let i=0;i<botonesEditar.length;i++){
		botonesEditar[i].addEventListener('click', function(e){
			document.getElementById("formularioEdit").style.display = "block";
			let clienteString = e.target.value.replace(/'/g,'"');
			let cliente = JSON.parse(clienteString);
			console.log(cliente)
			
			document.getElementById("codClienteEdit").value = cliente.codCliente;
			document.getElementById("nombreEdit").value = cliente.nombre;
			document.getElementById("contrasenaEdit").value = cliente.contrasena;
			document.getElementById("direccionEdit").value = cliente.direccion;
			
		},false)
	}
	document.getElementById("addBtn").addEventListener('click',function(){
		document.getElementById("formularioAdd").style.display = "block";
	},false);	
},false);